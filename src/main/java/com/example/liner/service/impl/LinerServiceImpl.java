package com.example.liner.service.impl;

import com.example.liner.domain.*;
import com.example.liner.mapper.LinerMapper;
import com.example.liner.service.LinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class LinerServiceImpl implements LinerService {
    @Autowired
    private LinerMapper mapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public HighlightVO addHighlight(HighlightVO highlightVO) {
        int pageId = mapper.addPageInfo(highlightVO);
        highlightVO.setPageId(pageId);
        int sn = mapper.selectThemeSn(highlightVO);
        highlightVO.setThemeSn(sn);
        int highlightId = mapper.addHighlight(highlightVO);
        highlightVO.setHighlightId(highlightId);

        return highlightVO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public HighlightVO updateHighlight(HighlightVO highlightVO) {
        if(highlightVO.getColorHex() != null && "".equals(highlightVO.getColorHex())) {
            Integer themeSn = mapper.checkColor(highlightVO);
            if(themeSn == null ) {
                return null;
            } else {
                highlightVO.setThemeSn(themeSn.intValue());
                mapper.updateHighlight(highlightVO);
                HighlightVO result = mapper.selectUserHighlight(highlightVO);
                return result;
            }
        } else {
            mapper.updateHighlight(highlightVO);
            HighlightVO result = mapper.selectUserHighlight(highlightVO);
            return result;
        }
    }

    @Override
    public List<HighlightVO> selectMyHighlight(HighlightVO highlightVO) {
        List<HighlightVO> result = mapper.selectMyHighlight(highlightVO);

        return result;
    }

    @Override
    public List<MyPageHighlightVO> selectMyPageHighlight(HighlightVO highlightVO) {
        List<MyPageHighlightVO> pageList = mapper.selectMyPage(highlightVO);
        for(MyPageHighlightVO vo : pageList) {
            highlightVO.setPageUrl(vo.getPageUrl());
            List<HighlightVO> highlightList = mapper.selectMyHighlight(highlightVO);
            vo.setHighlightVO(highlightList);
        }
        return pageList;
    }

    @Override
    public void deleteHighlight(HighlightVO highlightVO) {
        mapper.deleteHighlight(highlightVO);
    }

    @Override
    public void updateMyTheme(HighlightVO highlightVO) {
        mapper.updateMyTheme(highlightVO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateMyThemeColor(UserThemeVO userThemeVO) {
        userThemeVO.getTheme().setColorHex(Arrays.asList(userThemeVO.getTheme().getColors()));
        // 중복 체크
        List<String> dupchk = mapper.duplicationCheck(userThemeVO.getTheme());
        if(dupchk.size() == userThemeVO.getTheme().getColorHex().size()) {
            dupchk.removeAll(userThemeVO.getTheme().getColorHex());
            if(dupchk.size() == 0)  return;
        }
        // 사이즈 체크 및 사이즈 확장
        int colorSize = mapper.selectUserThemeColor(userThemeVO);
        if(colorSize > userThemeVO.getTheme().getColors().length) {
            while(colorSize == userThemeVO.getTheme().getColorHex().size()){
                userThemeVO.getTheme().getColorHex().add(userThemeVO.getTheme().getColorHex().get(0));
            }
        }
        int sn = 1;
        // 업데이트 및 인서트
        for(String colorHex : userThemeVO.getTheme().getColorHex()) {
            ThemeInfo themeInfo = new ThemeInfo();
            themeInfo.setThemeId(userThemeVO.getTheme().getId());
            themeInfo.setThemeSn(sn++);
            themeInfo.setColorHex(colorHex);
            mapper.updateMyThemeColor(themeInfo);
        }
    }

    @Override
    public void deleteMyTheme(HighlightVO highlightVO) {

    }
}

package com.example.liner.service;

import com.example.liner.domain.HighlightVO;
import com.example.liner.domain.MyPageHighlightVO;
import com.example.liner.domain.UserThemeVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinerService {
    HighlightVO addHighlight(HighlightVO highlightVO);

    HighlightVO updateHighlight(HighlightVO highlightVO);

    List<HighlightVO> selectMyHighlight(HighlightVO highlightVO);

    List<MyPageHighlightVO> selectMyPageHighlight(HighlightVO highlightVO);

    void deleteHighlight(HighlightVO highlightVO);

    void updateMyTheme(HighlightVO highlightVO);

    void updateMyThemeColor(UserThemeVO userThemeVO);

    void deleteMyTheme(HighlightVO highlightVO);
}

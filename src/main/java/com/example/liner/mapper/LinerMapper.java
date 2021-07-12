package com.example.liner.mapper;

import com.example.liner.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LinerMapper {
    int addPageInfo(HighlightVO highlightVO);
    int addHighlight(HighlightVO highlightVO);

    int selectThemeSn(HighlightVO highlightVO);

    int checkColor(HighlightVO highlightVO);

    void updateHighlight(HighlightVO highlightVO);

    HighlightVO selectUserHighlight(HighlightVO highlightVO);

    List<HighlightVO> selectMyHighlight(HighlightVO highlightVO);

    List<MyPageHighlightVO> selectMyPageHighlight(HighlightVO highlightVO);

    List<MyPageHighlightVO> selectMyPage(HighlightVO highlightVO);

    void deleteHighlight(HighlightVO highlightVO);

    void updateMyTheme(HighlightVO highlightVO);

    void updateMyThemeColor(ThemeInfo themeVO);

    int selectUserThemeColor(UserThemeVO userThemeVO);

    List<String> duplicationCheck(ThemeVO theme);

    HighlightVO selectUserTheme(HighlightVO highlightVO);

    void deleteMyTheme(HighlightVO highlightVO);

    void deleteMyThemeInfo(HighlightVO highlightVO);
}

package com.example.liner.domain;

import lombok.Data;

@Data
public class HighlightVO {

    private int highlightId;
    private String userId;
    private String pageUrl;
    private int pageId;
    private String colorHex;
    private int themeSn;
    private String text;
    private int themeId;

}

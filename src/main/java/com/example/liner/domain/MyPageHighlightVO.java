package com.example.liner.domain;

import lombok.Data;
import java.util.List;

@Data
public class MyPageHighlightVO {

    private int pageId;
    private String pageUrl;
    private List<HighlightVO> highlightVO;
}

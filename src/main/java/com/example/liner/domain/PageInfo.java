package com.example.liner.domain;

import lombok.Data;

import java.util.Date;

@Data
public class PageInfo {

    private int pageId;

    private String userId;
    private String pageUrl;
    private String status;
    private Date createDate;
    private Date updateDate;

}

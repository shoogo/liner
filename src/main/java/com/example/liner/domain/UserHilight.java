package com.example.liner.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserHilight {
    private int hilightId;

    private String userId;
    private int pageId;
    private int themeSn;
    private String text;
    private String status;
    private Date createDate;
    private Date updateDate;

}

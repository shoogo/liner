package com.example.liner.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserTheme {
    private int themeId;

    private String userId;
    private String status;
    private Date createDate;
    private Date updateDate;

}

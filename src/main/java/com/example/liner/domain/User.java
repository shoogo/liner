package com.example.liner.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String userId;
    private String pw;
    private String userInfo;
    private Date createDate;
    private Date updateDate;
    private String status;

}

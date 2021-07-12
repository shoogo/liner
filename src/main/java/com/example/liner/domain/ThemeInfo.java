package com.example.liner.domain;


import lombok.Data;

import java.util.Date;

@Data
public class ThemeInfo {
    private int themeId;
    private int themeSn;
    private String colorHex;
    private String status;
    private Date creataDate;
    private Date updateDate;

}

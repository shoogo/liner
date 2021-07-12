package com.example.liner.domain;

import lombok.Data;

import java.util.List;

@Data
public class ThemeVO {
    private int id;
    private String[] colors;
    
    private List<String> colorHex;
}

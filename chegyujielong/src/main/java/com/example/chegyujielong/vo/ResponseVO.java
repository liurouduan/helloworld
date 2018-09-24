package com.example.chegyujielong.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {
    private String code;
    private String message;
    private Object body;
}

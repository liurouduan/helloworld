package com.example.chegyujielong.dao;

import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private String gender;

}

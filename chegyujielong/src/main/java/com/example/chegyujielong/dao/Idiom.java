package com.example.chegyujielong.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class Idiom {
    @Id
    private Integer id;
    private String word;
    private String pinyin;
    private String pinyin2;
    private String derivation;
    @Column(length = 1000)
    private String explanation;
    @Column(length = 1000)
    private String example;
    private String abbreviation;
    private String firstCharacter;
    private String firstCharacterPinyin;
}

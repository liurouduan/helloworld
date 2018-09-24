package com.example.chegyujielong.service;

import com.example.chegyujielong.dao.Idiom;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.List;

public interface IdiomService {

    public Idiom findByWord(String word);
    public Idiom findRandomIdiom();
    public Idiom findNext(String lastWord,String word) throws BadHanyuPinyinOutputFormatCombination;
    public Idiom findByPinyin(String pinyin);
}

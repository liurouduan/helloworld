package com.example.chegyujielong.serviceImpl;

import com.example.chegyujielong.util.PinyinUtil;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import static com.example.chegyujielong.util.PinyinUtil.getPinYin;
import static org.junit.Assert.*;

public class IdiomImplTest {

    @Test
    public void findNext() throws BadHanyuPinyinOutputFormatCombination {
       String pinYin =  PinyinUtil.getPinYin("闭阁自责");
       System.out.print(pinYin);
    }
}
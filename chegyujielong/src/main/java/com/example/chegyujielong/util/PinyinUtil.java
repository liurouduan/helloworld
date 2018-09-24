package com.example.chegyujielong.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtil {
    /**
     * 汉字转换为拼音
     * @param inputString
     * @return
     */
    public static String getPinYin(String inputString) throws BadHanyuPinyinOutputFormatCombination {

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        // 设置大小写
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // 设置有无声调
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // 碰到unicode 的ü 、v 和 u时的显示方式，共有三个方式 lu: lv lü
        format.setVCharType(HanyuPinyinVCharType.WITH_V);

        char[] input = inputString.trim().toCharArray();
        StringBuffer output = new StringBuffer("");

        for (int i = 0; i < input.length; i++) {
            if (Character.toString(input[i]).matches("[\u4E00-\u9FA5]+")) {
                String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
                output.append(temp[0]);
                output.append(" ");
            } else
                output.append(Character.toString(input[i]));
        }
        return output.toString();
    }
}

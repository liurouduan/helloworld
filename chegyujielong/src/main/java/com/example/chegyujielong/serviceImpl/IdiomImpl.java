package com.example.chegyujielong.serviceImpl;

import com.example.chegyujielong.dao.Idiom;
import com.example.chegyujielong.repository.IdiomRepository;
import com.example.chegyujielong.service.IdiomService;
import com.example.chegyujielong.util.PinyinUtil;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("idiomService")
public class IdiomImpl implements IdiomService {
    @Autowired
    IdiomRepository idiomRepository;

    @Override
    public Idiom findByWord(String word) {
        List<Idiom> idioms = idiomRepository.findByWord(word);
        if (idioms == null || idioms.size() == 0) {
            return null;
        } else {
            return idioms.get(0);
        }

    }

    @Override
    public Idiom findRandomIdiom() {
        long dataSize = idiomRepository.count();
        int random = new Random().nextInt((int) dataSize);
        Idiom idiom = idiomRepository.findById(random);
        return idiom;
    }


    @Override
    public Idiom findByPinyin(String pinyin) {
        List<Idiom> idioms = idiomRepository.findByFirstCharacterPinyin(pinyin);
        if (idioms == null || idioms.size() == 0) {
            return null;
        } else {
            return idioms.get(0);
        }


    }

    public Idiom findNext(String lastWord, String word) throws BadHanyuPinyinOutputFormatCombination {

        List<Idiom> idioms = idiomRepository.findByWord(word);
        if (idioms == null || idioms.size() == 0) {
           throw new RuntimeException();
        } else {
            String pinYin = PinyinUtil.getPinYin(word);
            String[] pinYins = pinYin.split(" ");
            String lastPinYin = pinYins[pinYins.length - 1];
            String firstPinYin = pinYins[0];
            String s1 = PinyinUtil.getPinYin(lastWord);
            String[] s1s = pinYin.split(" ");
            if (s1s[0] .equals(firstPinYin) ) {
                List<Idiom> newIdeiom =  idiomRepository.findByFirstCharacterPinyin(lastPinYin);
                return newIdeiom.get(0);
            } else {
                return null;
            }
        }
    }
}

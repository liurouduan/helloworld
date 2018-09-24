package com.example.chegyujielong.controller;

import com.example.chegyujielong.dao.Idiom;
import com.example.chegyujielong.service.IdiomService;
import com.example.chegyujielong.vo.ResponseVO;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idiom")
public class IdiomController {
    @Autowired
    IdiomService idiomService;
    @GetMapping(value = "/findByWord",produces ="application/json" )
    public ResponseEntity<ResponseVO> findByWord(@RequestParam String word){
        Idiom idiom = idiomService.findByWord(word);
        if(idiom==null){
            return ResponseEntity.ok(new ResponseVO("1","没有这个成语",null));
        }
        return ResponseEntity.ok(new ResponseVO("0","ok",idiom));
    }
    @GetMapping(value = "/findRandomIdiom",produces ="application/json" )
    public ResponseEntity<ResponseVO> findRandomIdiom(){
        Idiom idiom = idiomService.findRandomIdiom();
        while(idiom==null){
          idiom= idiomService.findRandomIdiom();
        }
        return ResponseEntity.ok(new ResponseVO("0","ok",idiom));
    }

    @GetMapping(value = "/findNext",produces ="application/json" )
    public ResponseEntity<ResponseVO> findNext(String oldWord,String newWord){

        Idiom idiom=null;
        try {
          idiom = idiomService.findNext(oldWord,newWord);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }

        return ResponseEntity.ok(new ResponseVO("0","ok",idiom));
    }
}

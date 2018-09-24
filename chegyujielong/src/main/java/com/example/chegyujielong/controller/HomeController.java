package com.example.chegyujielong.controller;

import com.example.chegyujielong.dao.Idiom;
import com.example.chegyujielong.dao.User;
import com.example.chegyujielong.service.IdiomService;
import com.example.chegyujielong.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test1")

public class HomeController {

    @GetMapping("/hello")
    public String fuction(@RequestParam String name,@RequestParam(required = false) String age) {
        if (age == null) {
            return "你好" + name;
        }
        return "你好" + name + age;
}
    @PostMapping(value = "/hello",produces = "application/json")
    public User post(@RequestBody User user){
        return user;
    }

}

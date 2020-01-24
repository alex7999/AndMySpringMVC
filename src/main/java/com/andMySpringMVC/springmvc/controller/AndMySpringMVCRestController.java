package com.andMySpringMVC.springmvc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andMySpringMVC.springmvc.domain.MyElementDictionaryRunner;
import com.andMySpringMVC.springmvc.domain.MyElementDictionary;

@RestController
public class AndMySpringMVCRestController {

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to SahaRestTemplate Example.";
    }

    @RequestMapping("/hello/{player}")
    public MyElementDictionary message(@PathVariable String player) {//REST Endpoint.

        MyElementDictionaryRunner elementDictionaryRunner = new MyElementDictionaryRunner();
        MyElementDictionary msg = elementDictionaryRunner.getFirstElementDictionary();
        return msg;
    }
}
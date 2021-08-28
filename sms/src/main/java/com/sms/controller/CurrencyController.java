package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    public static final String END_POINT = "http://localhost:8081/currency/";

    RestTemplate restTemplate;

    @Autowired
    public CurrencyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<String> exchange(@RequestParam double price, @RequestParam String type){
        ResponseEntity<String> responseEntity;
        if(type.equals("TL")){
            responseEntity = restTemplate.getForEntity(END_POINT + "tl_usd?TL="+price, String.class);
        }else{
            responseEntity = restTemplate.getForEntity(END_POINT + "us_tl?Usd="+price,String.class);
        }

        return responseEntity;
    }
}

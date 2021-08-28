package com.currency.exchange.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.NumberFormat;
import java.util.Locale;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private static final double TL_USD = 8.7;
    private static final Locale TR = new Locale("tr","TR");
    private static final Locale USD = new Locale("en","US");

    @GetMapping("tl_usd")
    public ResponseEntity<String> tlToUsd(@RequestParam double TL){
        return new ResponseEntity<>(NumberFormat.getCurrencyInstance(TR).format(TL_USD * TL), HttpStatus.OK);
    }

    @GetMapping("us_tl")
    public ResponseEntity<String> usdToTl(@RequestParam double Usd){
        return new ResponseEntity<>(NumberFormat.getCurrencyInstance(USD).format(TL_USD * Usd), HttpStatus.OK);
    }
}

package com.zaki.controller;


import com.zaki.mapper.CountryMapper;
import com.zaki.model.annotation.Accesslog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author argen
 */
@RestController
@RequestMapping("/apis/auth")
@Slf4j
public class CountryController {


    @Autowired
    private CountryMapper countryMapper;

    @GetMapping("/country")
    @Accesslog
    public ResponseEntity<?> getCountries() {
        log.info("begin getCountry");
        return ResponseEntity.ok(countryMapper.selectAll());
    }
}

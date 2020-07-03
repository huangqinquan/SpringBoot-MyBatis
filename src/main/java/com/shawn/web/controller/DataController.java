package com.shawn.web.controller;

import com.shawn.constant.ResourceNameConstant;
import com.shawn.service.DataService;
import com.shawn.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/test")
    public ResponseEntity<String> getCountFromDimPhoneBrand() {
        dataService.getCountFromDimPhoneBrand();
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}

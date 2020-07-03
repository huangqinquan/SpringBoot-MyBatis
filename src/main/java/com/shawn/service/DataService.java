package com.shawn.service;

import com.shawn.database.DataSource;
import com.shawn.repository.DataServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private DataServiceMapper mapper;

//    @DataSource("data_source_2")
    public void getCountFromDimPhoneBrand(){
        int count = mapper.selectCountFromDimPhoneBrand();
        System.out.println(count);
    }
}

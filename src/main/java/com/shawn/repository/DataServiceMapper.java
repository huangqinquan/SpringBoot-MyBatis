package com.shawn.repository;

import com.shawn.database.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataServiceMapper {

    @Select("select count(*) from dim_phone_brand;")
    @DataSource("data_source_2")
    int selectCountFromDimPhoneBrand();
}

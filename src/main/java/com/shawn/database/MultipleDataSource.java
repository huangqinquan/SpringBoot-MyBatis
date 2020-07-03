package com.shawn.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println(DataSourceContextHolder.getDataSource());
        return DataSourceContextHolder.getDataSource();
    }
}

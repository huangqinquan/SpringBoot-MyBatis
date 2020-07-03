package com.shawn.database;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@PropertySource("application-druid.properties")
public class MyBatiesPlusConfiguration {

    @Bean(name = "data_source_1")
    @ConfigurationProperties(prefix = "ds-114-dataservice" )
    public DataSource data_source_1() {
        return DruidDataSourceBuilder.create().build();
    }

	@Bean(name = "data_source_2")
	@ConfigurationProperties(prefix = "ds-114-dataservice" )
	public DataSource data_source_2() {
		return DruidDataSourceBuilder.create().build();
	}

    /**
     * 动态数据源配置
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(@Qualifier("data_source_1") DataSource data_source_1) {
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        Map< Object, Object > targetDataSources = new HashMap<>();
        targetDataSources.put("data_source_1", data_source_1);
        //添加数据源
        multipleDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        multipleDataSource.setDefaultTargetDataSource(data_source_1);
        return multipleDataSource;
    }


    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
//        log.info("sqlSessionFactory:--->mybatis.mapperLocation:" + mapperLocations );

        sqlSessionFactoryBean.setDataSource(multipleDataSource(data_source_1()));
        org.apache.ibatis.session.Configuration cfg = new org.apache.ibatis.session.Configuration();//configuration
        log.info("sqlSessionFactoryBean:-->" + sqlSessionFactoryBean.getObject());
        sqlSessionFactoryBean.setConfiguration(cfg);
        return sqlSessionFactoryBean.getObject();

    }
}

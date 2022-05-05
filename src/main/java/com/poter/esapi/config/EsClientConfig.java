package com.poter.esapi.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring两步骤
 * 1、找对象
 * 2、放到spring中待用
 * 3、如果是Springboot,就先分析源码
 * xxxxAutoConfig  xxxProperties
 */
@Configuration
public class EsClientConfig {

    /**
     * 官方提供的初始化方法
     * @return
     */
    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestClient.builder(
                /**
                 * 集群的时候，写多个
                 */
                new HttpHost("10.45.12.48",9200,"http"));
        return client();
    }
}

package com.poter.esapi;

import com.poter.esapi.config.EsClientConfig;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * es 7.6.x 高级客户端测试API
 */
@SpringBootTest
class EsApiApplicationTests {

   @Autowired
   @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

   //测试索引的创建
    @Test
    void testCreateIndex() throws IOException {
        //1、创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("testPoter");  //创建索引的请求
        //2、客户端执行请求IndicesClient，请求后获得响应
        CreateIndexResponse createIndexResponse =
                client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    //测试获取索引，只能判断其是否存在
    @Test
    void testExistsIndex() throws IOException {
        //1、创建获取索引的请求
        GetIndexRequest request = new GetIndexRequest("testpoter"); //获取索引的请求
        //2、判断索引是否存在
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

}

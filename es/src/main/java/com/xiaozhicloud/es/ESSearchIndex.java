package com.xiaozhicloud.es;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class ESSearchIndex {

    public static void main(String[] args) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );


        GetIndexRequest user = new GetIndexRequest("user");
        GetIndexResponse response = client.indices().get(user, RequestOptions.DEFAULT);


        System.out.println(response.getAliases());
        System.out.println(response.getMappings());
        System.out.println(response.getSettings());


        client.close();
    }
}

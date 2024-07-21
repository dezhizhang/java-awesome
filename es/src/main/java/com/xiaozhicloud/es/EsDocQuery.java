package com.xiaozhicloud.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class EsDocQuery {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 全量查询数据
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//
//        request.source(query);
//
//        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
//
//        System.out.println(response.getHits().getTotalHits());
//        System.out.println(response.getHits().getHits().getClass());


        SearchRequest request = new SearchRequest();
        request.indices("user");

        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.termQuery("name","张三"));

        request.source(query);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        System.out.println(response.getHits().getTotalHits());
        System.out.println(response.getHits().toString());

        client.close();
    }

}

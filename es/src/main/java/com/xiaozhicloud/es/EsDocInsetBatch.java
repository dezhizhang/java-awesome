package com.xiaozhicloud.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class EsDocInsetBatch {
    public static void main(String[] args)  throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        BulkRequest bulkRequest = new BulkRequest();
        IndexRequest source = new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "张三");
        IndexRequest source1 = new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "李四");
        bulkRequest.add(source,source1);


        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(bulk.getTook());


        client.close();
    }
}

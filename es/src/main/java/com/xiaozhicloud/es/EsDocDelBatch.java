package com.xiaozhicloud.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class EsDocDelBatch {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 批量删除文档
        BulkRequest bulkRequest = new BulkRequest();

        DeleteRequest user1 = new DeleteRequest().index("user").id("1001");
        DeleteRequest user2 = new DeleteRequest().index("user").id("1002");
        DeleteRequest user3 = new DeleteRequest().index("user").id("1003");

        bulkRequest.add(user1,user2,user3);

        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(bulk.getTook());

        System.out.println(bulk.getItems().length);


        client.close();
        


    }
}

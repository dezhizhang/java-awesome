package com.xiaozhicloud.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ESIndexDelete {
    public static void main(String[] args) throws Exception {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 删除索引
        DeleteIndexRequest user = new DeleteIndexRequest("user");
        AcknowledgedResponse delete = client.indices().delete(user, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());



        client.close();


    }
}

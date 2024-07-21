package com.xiaozhicloud.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class EsDocDelete {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 删除文档数据

        DeleteRequest request = new DeleteRequest();
        DeleteRequest user = request.index("user").id("1001");


        DeleteIndexRequest response = new DeleteIndexRequest();

        System.out.println(response.toString());


        client.close();
    }
}

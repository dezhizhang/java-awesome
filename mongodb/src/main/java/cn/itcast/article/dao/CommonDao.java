package cn.itcast.article.dao;

import cn.itcast.article.po.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommonDao extends MongoRepository<Comment,String> {

}

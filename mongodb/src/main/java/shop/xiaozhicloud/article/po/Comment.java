package shop.xiaozhicloud.article.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
@Document(collection = "comment")

public class Comment implements Serializable {
    @Id
    private String id;
    @Field("content")
    private String content;
    private String pubTime;

    @Indexed
    private String userId;
    private String state;
    private Integer likeNum; // 点赞数
    private String parentId; // 上级id
    private String articleId; // 文章id
    private Integer replyNum; // 回复数


    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public String getPubTime() {
        return pubTime;
    }

    public String getState() {
        return state;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public String getParentId() {
        return parentId;
    }

    public String getArticleId() {
        return articleId;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    @Override
    public String toString() {
        return "CommentPo{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", pubTime='" + pubTime + '\'' +
                ", userId='" + userId + '\'' +
                ", state='" + state + '\'' +
                ", likeNum=" + likeNum +
                ", parentId='" + parentId + '\'' +
                ", articleId='" + articleId + '\'' +
                ", replyNum=" + replyNum +
                '}';
    }
}

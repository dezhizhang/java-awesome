package shop.xiaozhicloud.article.service;

import shop.xiaozhicloud.article.po.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;


    @Test
    public void testFindCommentList() {
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }

    @Test
    public void testFindCommentById() {
        Comment commentById = commentService.findCommentById("669d0f6b93d24c6f5fc7972b");
        System.out.println(commentById);
    }

    @Test
    public void testSaveComment(){
        Comment comment=new Comment();
        comment.setArticleId("100000");
        comment.setContent("测试添加的数据");
        comment.setUserId("1003");

        comment.setState("1");
        comment.setLikeNum(100);

        commentService.saveComment(comment);

    }

    @Test
    public void testFindCommentListByParentId() {
        Page<Comment> page = commentService.findCommentListByParentId("3", 1, 2);
        System.out.println(page.getTotalElements());
        System.out.println(page.getContent());
    }

    @Test
    public void testUpdateCommentLikenum() {
        commentService.updateCommentLikenum("1");
    }



}

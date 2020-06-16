package leib.demo.dao;

import leib.demo.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author:Leib
 * @Date 2020/5/25 16:38
 */
//评论的dao接口
public interface CommentRepository extends MongoRepository<Comment,String> {

    //根据父id，查询子评论的分页列表
    Page<Comment> findByParentid(String parentid, Pageable pageable);

}

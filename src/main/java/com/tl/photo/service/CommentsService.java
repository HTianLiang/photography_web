package com.tl.photo.service;

import com.tl.photo.domain.Comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author tl
 * @Date 2022/2/8 3:05 下午
 * @Version 1.0
 * @Description
 */
public interface CommentsService {
    // 保存评论内容
    void saveComments(Comments comments);
    // 查询全部
    List<Comments> findAll();
    // 审核通过
    void auditPass(@Param("id") Integer id);
    // 审核不通过
    void auditNotPass(@Param("id") Integer id);
    // 根据输入条件查询内容
    List<Comments> findByCommentOption(Comments comments);
    // 根据作品ID查询评论内容
    List<Comments> findCommentByWorksId(Integer worksId);
}

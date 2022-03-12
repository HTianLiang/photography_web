package com.tl.photo.service.impl;

import com.tl.photo.domain.Comments;
import com.tl.photo.mapper.CommentsMapper;
import com.tl.photo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tl
 * @Date 2022/2/8 3:05 下午
 * @Version 1.0
 * @Description
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public void saveComments(Comments comments) {
        commentsMapper.saveComments(comments);
    }

    @Override
    public List<Comments> findAll() {
        return commentsMapper.findAll();
    }

    @Override
    public void auditPass(Integer id) {
        commentsMapper.auditPass(id);
    }

    @Override
    public void auditNotPass(Integer id) {
        commentsMapper.auditNotPass(id);
    }

    @Override
    public List<Comments> findByCommentOption(Comments comments) {
        return commentsMapper.findByCommentOption(comments);
    }

    @Override
    public List<Comments> findCommentByWorksId(Integer worksId) {
        return commentsMapper.findCommentByWorksId(worksId);
    }
}

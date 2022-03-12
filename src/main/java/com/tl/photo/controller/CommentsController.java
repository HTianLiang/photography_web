package com.tl.photo.controller;

import com.tl.photo.domain.Comments;
import com.tl.photo.enums.StatusEnum;
import com.tl.photo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author tl
 * @Date 2022/2/8 3:06 下午
 * @Version 1.0
 * @Description
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    /**
     * 保存评论内容
     * @param comments
     */
    @RequestMapping("/saveComments")
    public void saveComments(@RequestBody Comments comments) {
        // 创建当前时间
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        Comments commented = new Comments();
        commented.setUsersId(comments.getUsersId());
        commented.setUsername(comments.getUsername());
        commented.setAvatarPic(comments.getAvatarPic());
        commented.setWorksId(comments.getWorksId());
        commented.setContent(comments.getContent());
        commented.setCreateTime(date);
        commented.setCommentIp(comments.getCommentIp());
        commented.setCommentStatus(StatusEnum.STATUS_OF_NO.getType());
        /*存储到数据库中*/
        commentsService.saveComments(commented);
    }

    /**
     * 查询全部评论内容
     * @return
     */
    @GetMapping("/findAll")
    public List<Comments> findAll() {
        return commentsService.findAll();
    }

    /**
     * 审核通过
     * @param id
     */
    @GetMapping("/auditPass/{id}")
    public void auditPass(@PathVariable("id") Integer id) {
        commentsService.auditPass(id);
    }

    /**
     * 审核不通过
     * @param id
     */
    @GetMapping("/auditNotPass/{id}")
    public void auditNotPass(@PathVariable("id") Integer id) {
        commentsService.auditNotPass(id);
    }

    /**
     * 根据输入条件查询内容
     * @param comments
     * @return
     */
    @PutMapping("/findByCommentOption")
    public List<Comments> findByCommentOption(@RequestBody Comments comments) {
        return commentsService.findByCommentOption(comments);
    }

    /**
     * 根据作品id查询评论内容
     * @param worksId
     * @return
     */
    @GetMapping("/findCommentByWorksId/{worksId}")
    public List<Comments> findCommentByWorksId(@PathVariable("worksId") Integer worksId) {
        return commentsService.findCommentByWorksId(worksId);
    }

}

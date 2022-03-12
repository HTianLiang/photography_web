package com.tl.photo.service;

import com.tl.photo.domain.Copywriting;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/10 11:30 下午
 * @Version 1.0
 * @Description 文案接口类
 */
public interface CopywritingService {
    // 新增文案
    void addCopywriting(List<Copywriting> copywritingList);
    // 查询全部
    List<Copywriting> findAll();
    // 根据文案id修改文案信息
    void updateCopywriting(Copywriting copywriting);
    // 根据id删除文案
    void deleteCopywritingById(Integer id);
    // 查询状态是否有不同的值
    List<Copywriting> findByCopywritingStatusDistinct();
    // 根据id开启状态
    void openStatusByCopywritingId(Integer id);
    // 根据id关闭启用状态
    void closeStatusByCopywritingId(Integer id);
    // 根据文案标题查询内容
    List<Copywriting> findByCopywritingTitle(String copywritingTitle);
    // 查询开启状态
    List<Copywriting> findByOpenStatus();
}

package com.tl.photo.mapper;

import com.tl.photo.domain.Links;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/7 8:40 下午
 * @Version 1.0
 * @Description
 */
public interface LinksMapper {
    // 查询全部
    List<Links> findAll();
    // 新增友情链接
    void addLinks(List<Links> linksList);
    // 根据id查询友情链接
    Links findByLinksId(Integer id);
    // 修改友情链接
    void updateLinks(Links links);
    // 根据id删除友情链接
    void deleteLinksById(Integer id);
    // 修改友情链接状态为启用状态
    void updateLinksStatusOpen(Links links);
    // 关闭友情链接启用状态
    void updateLinksStatusClose(Links links);
    // 根据友情链接名称查询内容
    List<Links> findByLinksName(@Param("linksName") String linksName);
    // 查询开启状态
    List<Links> findByOpenStatus();
}

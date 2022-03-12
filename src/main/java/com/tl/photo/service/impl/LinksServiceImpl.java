package com.tl.photo.service.impl;

import com.tl.photo.domain.Links;
import com.tl.photo.mapper.LinksMapper;
import com.tl.photo.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/7 8:46 下午
 * @Version 1.0
 * @Description 友情链接接口实现类
 */
@Service
public class LinksServiceImpl implements LinksService {

    @Autowired
    private LinksMapper linksMapper;

    @Override
    public List<Links> findAll() {
        return linksMapper.findAll();
    }

    @Override
    public void addLinks(List<Links> linksList) {
        linksMapper.addLinks(linksList);
    }

    @Override
    public Links findByLinksId(Integer id) {
        return linksMapper.findByLinksId(id);
    }

    @Override
    public void updateLinks(Links links) {
        linksMapper.updateLinks(links);
    }

    @Override
    public void deleteLinksById(Integer id) {
        linksMapper.deleteLinksById(id);
    }

    @Override
    public void updateLinksStatusOpen(Links links) {
        linksMapper.updateLinksStatusOpen(links);
    }

    @Override
    public void updateLinksStatusClose(Links links) {
        linksMapper.updateLinksStatusClose(links);
    }

    @Override
    public List<Links> findByLinksName(String linksName) {
        return linksMapper.findByLinksName(linksName);
    }

    @Override
    public List<Links> findByOpenStatus() {
        return linksMapper.findByOpenStatus();
    }
}

package com.tl.photo.service.impl;

import com.tl.photo.domain.Copywriting;
import com.tl.photo.mapper.CopywritingMapper;
import com.tl.photo.service.CopywritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/10 11:31 下午
 * @Version 1.0
 * @Description 文案接口实现类
 */
@Service
public class CopywritingServiceImpl implements CopywritingService {

    @Autowired
    private CopywritingMapper copywritingMapper;

    @Override
    public void addCopywriting(List<Copywriting> copywritingList) {
        copywritingMapper.addCopywriting(copywritingList);
    }

    @Override
    public List<Copywriting> findAll() {
        return copywritingMapper.findAll();
    }

    @Override
    public void updateCopywriting(Copywriting copywriting) {
        copywritingMapper.updateCopywriting(copywriting);
    }

    @Override
    public void deleteCopywritingById(Integer id) {
        copywritingMapper.deleteCopywritingById(id);
    }

    @Override
    public List<Copywriting> findByCopywritingStatusDistinct() {
        return copywritingMapper.findByCopywritingStatusDistinct();
    }

    @Override
    public void openStatusByCopywritingId(Integer id) {
        copywritingMapper.openStatusByCopywritingId(id);
    }

    @Override
    public void closeStatusByCopywritingId(Integer id) {
        copywritingMapper.closeStatusByCopywritingId(id);
    }

    @Override
    public List<Copywriting> findByCopywritingTitle(String copywritingTitle) {
        return copywritingMapper.findByCopywritingTitle(copywritingTitle);
    }

    @Override
    public List<Copywriting> findByOpenStatus() {
        return copywritingMapper.findByOpenStatus();
    }
}

package com.tl.photo.service.impl;

import com.tl.photo.domain.Works;
import com.tl.photo.domain.WorksVo;
import com.tl.photo.mapper.WorksMapper;
import com.tl.photo.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/15 4:29 下午
 * @Version 1.0
 * @Description
 */
@Service
public class WorksServiceImpl implements WorksService {

    @Autowired
    private WorksMapper worksMapper;

    @Override
    public void worksPublish(List<Works> worksList) {
        worksMapper.worksPublish(worksList);
    }

    @Override
    public List<Works> findByWorksAll() {
        return worksMapper.findByWorksAll();
    }

    @Override
    public void auditPassWorksByWorksId(Integer worksId) {
        worksMapper.auditPassWorksByWorksId(worksId);
    }

    @Override
    public void auditNotPassWorksByWorksId(Integer worksId) {
        worksMapper.auditNotPassWorksByWorksId(worksId);
    }

    @Override
    public Works findByWorksId(Integer worksId) {
        return worksMapper.findByWorksId(worksId);
    }

    @Override
    public List<Works> findByWorksOption(Works works) {
        return worksMapper.findByWorksOption(works);
    }

    @Override
    public void updateWorks(Works works) {
        worksMapper.updateWorks(works);
    }

    @Override
    public Integer findWorksCountByUsersId(Integer usersId) {
        return worksMapper.findWorksCountByUsersId(usersId);
    }

    @Override
    public List<Works> findByUsersId(Integer usersId) {
        return worksMapper.findByUsersId(usersId);
    }

    @Override
    public List<WorksVo> findAuditPassAllByUsers() {
        return worksMapper.findAuditPassAllByUsers();
    }

    @Override
    public void updateWorksWatchNum(Integer worksId) {
        worksMapper.updateWorksWatchNum(worksId);
    }

    @Override
    public List<Works> findByWatchNumBiggerOne() {
        return worksMapper.findByWatchNumBiggerOne();
    }
}

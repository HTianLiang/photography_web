package com.tl.photo.service;

import com.tl.photo.domain.Works;
import com.tl.photo.domain.WorksVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author tl
 * @Date 2021/11/15 4:29 下午
 * @Version 1.0
 * @Description
 */
public interface WorksService {
    // 作品发布
    void worksPublish(List<Works> worksList);
    // 查询全部作品
    List<Works> findByWorksAll();
    // 根据作品id修改审核状态-通过
    void auditPassWorksByWorksId(Integer worksId);
    // 根据作品id修改审核状态-不通过
    void auditNotPassWorksByWorksId(Integer worksId);
    // 根据作品id查询
    Works findByWorksId(Integer worksId);
    // 根据作品条件查询内容
    List<Works> findByWorksOption(Works works);
    // 编辑作品
    void updateWorks(Works works);
    // 统计用户作品总条数
    Integer findWorksCountByUsersId(Integer usersId);
    // 根据用户ID查询作品
    List<Works> findByUsersId(Integer usersId);
    // 查询审核通过的全部用户作品
    List<WorksVo> findAuditPassAllByUsers();
    // 更新作品浏览量
    void updateWorksWatchNum(Integer worksId);
    // 查询作品浏览量大于1的内容
    List<Works> findByWatchNumBiggerOne();
}

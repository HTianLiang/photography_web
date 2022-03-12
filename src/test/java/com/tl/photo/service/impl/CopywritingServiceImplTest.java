package com.tl.photo.service.impl;

import com.tl.photo.domain.Copywriting;
import com.tl.photo.service.CopywritingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author tl
 * @Date 2021/11/10 11:35 下午
 * @Version 1.0
 * @Description
 */
@SpringBootTest
class CopywritingServiceImplTest {

    @Autowired
    private CopywritingService copywritingService;

    @Test
    void addCopywriting() {
        List<Copywriting> copywritingList = new ArrayList<>();
        Copywriting copywriting = new Copywriting();
        copywriting.setCopywritingTitle("test01");
        copywriting.setCopywritingContent("content·················01");
        copywriting.setCopywritingStatus(0);
        copywritingList.add(copywriting);
        copywritingService.addCopywriting(copywritingList);
    }

    @Test
    void findAllTest() {
        List<Copywriting> copywritingList = copywritingService.findAll();
        for (Copywriting copywritings : copywritingList) {
            System.out.println(copywritings);
        }
    }

    @Test
    void update() {
        Copywriting copywriting = new Copywriting();
        copywriting.setCopywritingTitle("Test01");
        copywriting.setCopywritingContent("content·······1··········01");
        copywriting.setCopywritingStatus(1);
        copywriting.setCopywritingId(1);
        copywritingService.updateCopywriting(copywriting);
    }
}
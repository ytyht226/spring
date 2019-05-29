package com.jd58.mvcxml.test.editor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by yanghuitao on 2019/5/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-junit.xml" })
public class CustomPropertyEditorTest {
    @Resource
    private Boss boss;
    @Test
    public void process() {
        System.out.println(boss);
    }
}
package com.zc.pattern.template.course;

/**
 * @author: ZhouCong
 * @date: Create in 2021/1/11 15:34
 * @description:
 */
public class JavaCourse extends NetworkCourse {
    @Override
    void checkHomework() {
        System.out.println("检查Java架构的作业");
    }
}

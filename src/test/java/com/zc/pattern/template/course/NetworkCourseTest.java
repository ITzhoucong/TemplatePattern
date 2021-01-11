package com.zc.pattern.template.course;

/**
 * @author: ZhouCong
 * @date: Create in 2021/1/11 15:40
 * @description:
 */
public class NetworkCourseTest {
    public static void main(String[] args) {
        System.out.println("-------Java架构师课程-------");
        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();

        System.out.println("-----大数据课程-----");
        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }
}

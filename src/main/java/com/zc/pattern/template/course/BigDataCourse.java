package com.zc.pattern.template.course;

/**
 * @author: ZhouCong
 * @date: Create in 2021/1/11 15:35
 * @description:
 */
public class BigDataCourse extends NetworkCourse {

    /**
     * 是否有作业
     */
    private boolean needHomeworkFlag = false;

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    @Override
    void checkHomework() {
        System.out.println("检查大数据的课后作业");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}

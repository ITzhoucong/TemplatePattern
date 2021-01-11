package com.zc.pattern.template.course;

/**
 * @author: ZhouCong
 * @date: Create in 2021/1/11 15:23
 * @description: 网课抽象类
 */
public abstract class NetworkCourse {

    protected final void createCourse(){
//        1、发布预习资料
        this.postPreResource();
//        2、制作PPT课件
        this.createPPT();
//        3、在线直播
        this.liveVideo();
//        4、提交课件、课堂笔记
        this.postNode();
//        5、提交源码
        this.postSource();
//        6、布置作业，有些课有作业有些课没有作业
//        如果有作业的话，检查作业，没有作业，完成了
        if (needHomework()){
            checkHomework();
        }
    }

    abstract void checkHomework();

    /**
     * 钩子方法: 作用实现流程微调
     */
    protected boolean needHomework(){
        return false;
    };

    final void postSource(){
        System.out.println("提交源代码");
    };

    final void postNode(){
        System.out.println("提交课件和笔记");
    };

    final void liveVideo(){
        System.out.println("直播授课");
    };

    final void createPPT(){
        System.out.println("创建备课PPT");
    };

    final void postPreResource(){
         System.out.println("分发预习资料");
     };
}

package com.study.thread;

/**
 * 1.通过thread类创建线程
 */
public class ThreadCreate extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("正在运行的线程是： " + getName());
        }
    }
}

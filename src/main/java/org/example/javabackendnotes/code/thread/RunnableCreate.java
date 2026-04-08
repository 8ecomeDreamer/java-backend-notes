package org.example.javabackendnotes.code.thread;

/**
 * 2.通过实现Runnable接口创建多线程
 */
public class RunnableCreate implements Runnable{

    @Override
    public void run() {


        for (int i = 0; i < 10; i++) {
            try {//sleep会发生异常要显示处理
                Thread.sleep(20);//暂停20毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + " 运行了");
        }

    }
}

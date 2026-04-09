package org.example.javabackendnotes;

import org.example.javabackendnotes.code.thread.CallableCreate;
import org.example.javabackendnotes.code.thread.RunnableCreate;
import org.example.javabackendnotes.code.thread.ThreadCreate;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@SpringBootTest
public class ThreadTest {

    @Test
    public void testThreadCreate() {

        ThreadCreate t1 = new ThreadCreate();
        ThreadCreate t2 = new ThreadCreate();
        ThreadCreate t3 = new ThreadCreate();

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void testRunnableCreate() throws InterruptedException {
        System.out.println("通过继承Runnable接口创建多线程");

        // 由于java中类是单继承但是接口可以实现多个，因此创建RunnableCreate类主要用于实现内部业务逻辑，而创建几个Thread线程类有助于管理线程的生命周期，这样做符合设计模式中的单一原则且将业务模块与生命周期解耦同时可以实现多线程的思想，且几个线程可以同时共享这个RunnableCreate类的资源。
        RunnableCreate rc = new RunnableCreate();

        Thread people = new Thread(rc, "人");
        Thread cat = new Thread(rc, "猫");
        Thread dog = new Thread(rc, "狗");

        people.start();
        cat.start();
        dog.start();

        // 为了不让主线程太快退出，加上join可以让子线程结束后再退出 同时需要添加InterruptException异常
        people.join();
        cat.join();
        cat.join();
    }

    @Test
    public void testCallableCreate(){

        // 1.创建线程 通过FutureTask传入Callable类实现
        FutureTask<String> task = new FutureTask<>(new CallableCreate());
        // 2.启动线程 将任务传入Thread类
        Thread thread = new Thread(task);
        thread.start();

        try {
            // 3.获取结果 通常需要加上ExecutionException异常
            String result = task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

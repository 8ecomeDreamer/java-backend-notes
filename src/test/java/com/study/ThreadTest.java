package com.study;

import com.study.thread.RunnableCreate;
import com.study.thread.ThreadCreate;
import com.study.thread.CallableCreate;
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
        System.out.println("通过Callable创建线程类需要配合FutureTask使用");

        // 1.创建线程 通过FutureTask传入Callable类实现
        FutureTask<String> task = new FutureTask<>(new CallableCreate());
        // 2.启动线程 将任务传入Thread类
        Thread thread = new Thread(task);
        thread.start();

        try {
            // 3.获取结果 通常需要加上ExecutionException异常
            String result = task.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThreadMethodComparison(){
        System.out.println("多线程创建方式对比");

        System.out.println("1.线程调用start方法其实也是jvm底层调用线程的run方法。");
        System.out.println("2.Thread类创建的话有单继承的困境，而Callable和Runnable通过implements启动，可以更好的将业务与线程分离。");
        System.out.println("3.虽然Callable会有一个返回值，但是推荐使用Runnable。");
    }

    @Test
    public void testStopThread(){
        System.out.println("线程停止的方法有 sleep、join、yield、setDaemon，最常用的是sleep和join");
    }

    @Test
    public void testIntroduceFutureTask(){
        System.out.println("初步了解FutureTask, 更详细的可以在后期学习线程池时补充。");

        System.out.println("FutureTask用来干什么？");
        System.out.println("1.判断线程状态");
        System.out.println("2.取消/中断线程运行");
        System.out.println("3.获取线程结果");
        System.out.println("这三个目的也分别对应其api,isDone()、cancel()、get()。");
    }

    @Test
    public void testThreadState(){
        System.out.println("可以通过img的thread-state初步熟记线程状态");
    }

    @Test
    public void testThreadPriority(){
        System.out.println("线程优先级");
        System.out.println("1.线程优先级范围是1-10，默认是5");
        System.out.println("2.优先级高的线程会优先执行");
    }
    @Test
    public void testProcessorThreadComparison(){
        System.out.println("进程线程对比");

    }
    @Test
    public void testThreadSecurity(){
        System.out.println("线程安全性问题:");
        System.out.println("1.原子性问题,即a和b两个操作中断，但结果没有变回原来的值。");
        System.out.println("2.可见性问题，即用户a和用户b同一时间看到的结果不同步。");
        System.out.println("3.活跃性问题，分为死锁、活锁、饥饿性问题。死锁为竞争资源，活锁为完全不竞争资源，饥饿问题则是线程无异常但无法继续运行。");

    }


    @Test
    public void testJMM(){
        System.out.println("JMM内存模型——（内容多且抽象，适合多次阅读）");
        System.out.println("1.JMM主要是用来做什么的？");
        System.out.println("  JMM主要是负责管理java中的内存模型，以及线程之间的通信方式（正解：JMM是Java Memory Model，其定义了java中变量、线程如何与主存以及工作内存进行交互的规则。）");
        System.out.println("2.JMM中常见的2种消息传递方式");
        System.out.println("  分别是消息传递并发模型与共享内存并发模型，java使用的是共享内存并发模型。");
        System.out.println("3.在java中,什么是共享变量？");
        System.out.println("  要先了解java运行内存，java运行内存中有栈、程序计数器、堆、方法区，堆和方法区是线程共享的资源，栈和程序计数器则是线程私有的资源，因此共享资源一般是指堆中的变量。");
        System.out.println("4.请简单描述volatile和synchronized两个关键字的作用");
        System.out.println("  volatile保证线程可见性，synchronized保证线程的原子性。");
        System.out.println("5.JMM与java运行内存的区别");
        System.out.println("  JMM是物理意义上的内存管理规则，是不存在的，而java运行内存是基于计算机的内存进行管理的。");
        System.out.println("6.内存可见性是怎么发生的");
        System.out.println("  （正解：是因为计算机将共享内存存于高速缓冲区，线程访问缓存会先查找本地缓存确认访问变化后再查找共享缓存并更新到本地缓存再读取本地缓存的值，因此线程与线程之间有可见性。）");
        System.out.println("7.如何保证内存可见性？");
        System.out.println("  使用volatile关键字。");
        System.out.println("8.什么是重排序");
        System.out.println("  重排序指的是减少计算机流水线指令中断的一种操作，有助于提升效率。");
        System.out.println("9.重排序有哪几种？");
        System.out.println("  （正解：1.编译器优化重排 2，指令并行重排 3.内存系统重排）");
        System.out.println("10.什么是顺序一致模型");
        System.out.println("  顺序一致模型是指为了避免线程发生数据竞争的情况推导的一款模型，java须按照模型的顺序严格执行它的代码。");
        System.out.println("11.JMM为什么不保证顺序一致性？");
        System.out.println("  (正解：JMM没有保证未同步程序的执行结果与该程序在顺序一致性中执行结果一致，因为如果要保证结果一致，那么JMM需要禁止大量的优化，对程序的执行性能会有很大的影响。)");
        System.out.println("12.什么是happens-before？");
        System.out.println("  happens-before关系是指程序执行顺序，happens-before关系是JMM中一个很重要的概念。只要不改变最后的编译结果，允许编译器和处理器优化。");
        System.out.println("13.happens-before关系有哪些？");
        System.out.println("  （正解：1.程序顺序规则 2.监视器锁规则 3.volatile变量规则 4.传递性 5.start规则 6.join规则）");
        System.out.println("14.描述一下线程的可见性、原子性、有序性。");
        System.out.println("  线程可见性：线程与线程之间能互相查看资源。 原子性：线程操作之间要么全部成功，要么全部失败。有序性：线程之间有顺序。");
    }

    @Test
    public void testVolatile(){
        System.out.println("volatile保证线程之间的可见性");
        System.out.println("1.volatile能确保线程的可见性");
        System.out.println("2.volatile能禁止指令重排");
    }



    @Test
    public void testSynchronized(){
        System.out.println("Synchronized能确保线程之间的原子性");
        System.out.println("1.synchronized有四种锁，无锁，偏向锁，轻量锁，重量级锁");
    }
}

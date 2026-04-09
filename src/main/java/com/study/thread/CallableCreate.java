package com.study.thread;

import java.util.concurrent.Callable;

public class CallableCreate implements Callable<String> {

    public String call() throws Exception{
        return "通过Callable创建线程类需要配合FutureTask使用";
    }
    
}

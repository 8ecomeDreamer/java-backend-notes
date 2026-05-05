package com.study.basic;

import java.io.FileNotFoundException;

public class ExceptionException {

    public static class TryCatchFinallyException {
        public static void close() throws Exception {
            throw new Exception("close");
        }
        public static void readLine() throws Exception {
            throw new Exception("readLine");
        }
    }

    public static class TryCatchFinallyResourcesException implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("close");
        }
        public void readLine() throws Exception {
            throw new Exception("readLine");
        }
    }

    public static void ExceptionIntroduce() {
        System.out.println();
        System.out.println("1.Exception与Error的异常：Error通常指编译器无法接受的错误，如OutOfMemory。而Exception则指编译器可以接受的错误，则交由开发者处理。");
        System.out.println("Exception包含checked（检查型）与unchecked（非检查型）异常。");
        System.out.println("checked异常：checked异常一般是编译器会重点检查并显示提示你做修改。如IOException、SQLException、ClassNotFoundException。");
        System.out.println("unchecked异常：Exception则是运行时触发，不会显示抛出。如NullPointException、ArrayIndexOutOfBoundsException。");
        System.out.println("Exception测试环境可以使用try..catch捕获，但在生产环境，推荐使用throws抛出，但throws抛出也无法对Exception进行后续处理操作。");
        System.out.println("2.throw与throws有什么区别？");
        System.out.println("throw后面一般跟Error，如 throw new Error。throws后面一般跟着具体的Exception名称，如 throws IOException。");
        System.out.println("try-catch-finally，finally一般用于关闭资源等");
        System.out.println("3.try-catch与try-catch-resources的区别");
        System.out.println("在写法上,try-catch-resources将resource作为try的条件，核心区别是后者内部调用了addSuppressed()和getSuppressed()，在面对多个异常时前者会丢失异常后者则不会");
    }

    public static void testTryCatchFinallyException() throws Exception {
        System.out.println();
        System.out.println("testTryCatchFinallyException");
        try {
            TryCatchFinallyException.readLine();
        } finally {
            TryCatchFinallyException.close();
        }
    }


    public static void testTryCatchFinallyResourcesException() throws Exception {
        System.out.println();
        System.out.println("testTryCatchFinallyResourcesException");
        try (TryCatchFinallyResourcesException tryCatchFinallyResourcesException = new TryCatchFinallyResourcesException()) {
            tryCatchFinallyResourcesException.readLine();
        }
    }

    public static void testBestPracticeTryCatchWay() throws Exception {
        System.out.println();
        System.out.println("20个最佳实现try..catch的场景，避免踩坑");
        System.out.println("1.try..catch尽量不要捕获NullPointException");
        System.out.println("2.尽量使用try-catch-resource关闭资源而不是try-catch");
        System.out.println("3.catch中不要捕获Throwable");
        System.out.println("4.不要省略记录异常信息");
        System.out.println("5.不要同时省略和抛出异常");
        System.out.println("6.finally中不能return值");
        System.out.println("7.抛出具体定义的检查性异常名称而不是笼统的Exception");
        System.out.println("8.catch中也不能捕获Exception类，而是具体的子类，推荐写法如下，可提高代码的健壮性：");
//        catch (FileNotFoundException e) {
//            // 只捕获FileNotFoundException
//        } catch (IOException e) {
//            // 只捕获IOException
//        }
        System.out.println("9.自定义异常不要丢失跟踪");
//        catch(NoSuchException e) {
//            throw new Exception(e.getMessage()) // 错误写法，丢失跟踪
//        }
        // 假设你自定义了异常 自定义实现printStackTrace方法
//        @override
//        public void printStackTrace() {
//            System.err.println("MyException:") // 自定义异常消息，便于定位
//            super.printStackTrace();        // 正确写法，继承exception的printStackTrace方法，不会丢失跟踪
//        }
        System.out.println("10.finally中不能抛出任何异常，因为finally的异常会覆盖try块的所有异常，导致其丢失");
        System.out.println("11.不要在生产环境中使用printStackTrace()，推荐使用日志系统，如log4j、slf4j或其他");
        System.out.println("12.对于不打算处理的异常，直接使用 try-finally，不用 catch");
        System.out.println("13.原则：早throw晚catch");
        System.out.println("14.只抛出和方法相关的异常");
        System.out.println("15.切勿在代码中使用异常来进行流程控制");
        System.out.println("16.尽早验证用户输入以在请求处理的早期捕获异常");
        System.out.println("17.一个异常只能包含在一个日志中");
        System.out.println("18.将所有相关信息尽可能地传递给异常");
        System.out.println("19.终止掉被中断线程");
//        while (true) {
//            try {
//                Thread.sleep(100000);
//            } catch (InterruptedException e) {
//                break;
//            }
//        }
//        doSomethingCool();
        System.out.println("20.对于重复的 try-catch，使用模板方法, 即封装");
    }

    public static void main(String[] args) throws Exception {
        ExceptionIntroduce();
//        testTryCatchFinallyException();
//        testTryCatchFinallyResourcesException();
        testBestPracticeTryCatchWay();
    }
}

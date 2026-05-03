package com.study.basic;

public class ExceptionException {

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
    }

    public static void main(String[] args) {
        ExceptionIntroduce();
    }
}

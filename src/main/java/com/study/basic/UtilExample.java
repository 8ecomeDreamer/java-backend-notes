package com.study.basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class UtilExample {


    public static void useScannerDemo() {
        System.out.println();
        System.out.println("Scanner工具类的使用");
        System.out.println("1.控制台输入");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入1个字符串：");
        String str = scanner.nextLine();
        System.out.println("你的字符串是： " + str);
//        scanner.nextLine();
        System.out.println("请输入1个数字： " );
        int num = scanner.nextInt();
        System.out.println("你的数字是： " + num);
        scanner.close();
        System.out.println("Scanner类是输入类，next()是只接受除了空格、tab键等有效字符类。nextLine()结束符只是enter键。nextInt则读取这一行的整数若没有则报错。");
    }

    public static void useScannerScan() throws FileNotFoundException {
        System.out.println();
        System.out.println("2.扫描文件");
        // 1.选择需要读取的文件
        File file = new File("D:\\study\\github\\java-backend-notes\\README.md");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\z");
        // 2.循环读取内容
        System.out.println("文件内容是：");
        while(scanner.hasNextLine()) {
            // 方式1： 使用 nextLine 读取
//            String line = scanner.nextLine();
            // 方式2：使用next但要配合useDelimiter
            String line = scanner.next();
            System.out.println(line);
        }

        System.out.println();
        // 3. 找到对应的文件内容
        String input = "good good study, day day up.";
        Scanner searchScanner = new Scanner(input);
        String findResult;
        String findResult2;
        findResult =  searchScanner.findInLine("day");
        System.out.println("findInLine()： " + findResult);
        findResult2 = scanner.findWithinHorizon("study", 10);
        System.out.println("findWithinHorizon(): " + findResult2); // 输出 "study"
        scanner.close();

        System.out.println("findInLine寻找对应的内容，findWithinHorizon在对应范围内寻找内容。");
    }


    public static void useArraysDemo() {
        System.out.println();
        System.out.println("Arrays工具类的使用");
        String[] exampleStringArray = new String[] {"1", "2", "3"};
        System.out.println("1.创建数组: copyOf、copyOfRange、fill");
        String[] copyArray1 = Arrays.copyOf(exampleStringArray, 3);
        String[] copyArray2 = Arrays.copyOf(exampleStringArray,  5);
        String[] copyArray3 = Arrays.copyOfRange(exampleStringArray,0,   5);
        System.out.println(Arrays.toString(copyArray1));
        System.out.println(Arrays.toString(copyArray2));
        System.out.println(Arrays.toString(copyArray3));
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 9527);
        System.out.println(Arrays.toString(fillArray));
        System.out.println("copy和copyRange方法在无元素时会默认填充null");
        System.out.println("2.比较数组");
        System.out.println("3.数组排序");
        System.out.println("4.数组检索");
        System.out.println("5.数组转流");
        System.out.println("6.打印数组");
        System.out.println("7.数组转list");
        System.out.println("8.setAll");
        System.out.println("9.parallelPrefix");
    }


    public static void useScanner() throws FileNotFoundException  {
        System.out.println();
//        useScannerDemo();
        useScannerScan();
    }


    public static void useArrays()  {
        System.out.println();
        useArraysDemo();
    }

    public static void main(String[] args) throws Exception {
        useScanner();
        useArrays();
    }
}

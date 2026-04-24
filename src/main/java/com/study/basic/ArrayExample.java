package com.study.basic;

public class ArrayExample {


    public static void example() {
        // 仅声明
        int[] newArray;
        int oldArray[];

        // 声明并初始化
        int[] newArray1 = new int[5];
        int newArray2[] = new int[] {1,2,3,4,5,6,7,8,9,10};

        System.out.println("数组可以仅声明，也可以声明并初始化");


        // 访问数组
        System.out.println("newArray1[0] = " + newArray1[0]);
        System.out.println("newArray2[0] = " + newArray2[5]);

        // 遍历数组
        System.out.println("for循环遍历元素：");
        for (int i = 0; i < newArray2.length; i++) {
            System.out.println("i");
        }

        System.out.println("forEach循环遍历元素：");
        for(int i: newArray2) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        System.out.println("数组的声明");
        example();
    }

}

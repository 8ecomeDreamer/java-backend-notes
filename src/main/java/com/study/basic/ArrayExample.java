package com.study.basic;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayExample {


    public static void creatArray() {
        System.out.println();

        // 仅声明
        int[] newArray;
        int oldArray[];

        // 声明并初始化
        int[] newArray1 = new int[5];
        int newArray2[] = new int[] {1,2,3,4,5,6,7,8,9,10};

        System.out.println("数组可以仅声明，也可以声明并初始化");
        System.out.println("初始化格式1： int[] arr = new int[5], 只定义长度。");
        System.out.println("初始化格式2： int arr[] = new int[]{1，2，3，4，5}, 定义具体的值。");

        // 访问数组
        System.out.println("newArray1[0] = " + newArray1[0]);
        System.out.println("newArray2[0] = " + newArray2[5]);

    }

    public static void traverseArray(int... args) {
        System.out.println();

        int newArray2[] = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println("第一种方式： for循环遍历数组");
        // 遍历数组
        for (int i = 0; i < newArray2.length; i++) {
            System.out.println(i);
        }
        System.out.println("第二种方式： for-each循环遍历数组");
        for(int i: newArray2) {
            System.out.println(i);
        }

    }

    // 可变参数与数组
    public static void printStringArgs(String... args) {
        System.out.println();
        System.out.println("这是一个字符型可变参数的方法，用户可以通过传入不同的参数，更改类型后也可以改为数字");
        System.out.println("参数分别是：");
        for(String arg : args) {
            System.out.println(arg);
        }
    }

    // 数组与list
    public static void arrayAndList() {
        System.out.println();
        System.out.println("数组与list:由于数组没有封装过多操作，因此更推荐使用list, 以下是数组与list的转换");
        int[] arr1 = new int[]{1,2,3,4,5,6};
        List<Integer> list = new ArrayList<>();

        System.out.println("方式1, 逐个遍历添加进list:");
        for (int j : arr1) {
            list.add(j);
        }
        System.out.println("list内容是：");
        for(int i : list) {
            System.out.println(i);
        }

        System.out.println("方式2, 使用Arrays数组内部封装的aslist方法");
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
        System.out.println("list1内容是：");
        for(int i : list1) {
            System.out.println(i);
        }
        System.out.println("方式3, 使用Stream转换，由于list需要Integer类型，而arr是int类型，因此需要使用流转换");
        List<Integer> list2 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        System.out.println("list2内容是：");
        for(int i : list2) {
            System.out.println(i);
        }
    }

    public static void sortArray() {
        System.out.println();
        System.out.println("数组的排序与查找：使用Array.sorts排序，使用binarySearch二分查找");
        int[] anArray  = new int[]{5, 2, 1, 4, 8};
        Arrays.sort(anArray);
        System.out.println("sort排序后的数组是：" + Arrays.toString(anArray));
        String[] yetAnotherArray = new String[] {"A", "E", "Z", "B", "C"};
        // String::toString Function<String, String> keyExtractor = s -> s.toString();
        Arrays.sort(yetAnotherArray, 1, 5, Comparator.comparing(String::toString).reversed());
        System.out.println("只对 1-3 位置上的元素进行反序,sort排序后的数组是：" + Arrays.toString(yetAnotherArray));
        int index = Arrays.binarySearch(anArray, 4);
        // binarySearch内部会将乱序数组进行排序
        System.out.println("binarySearch二分查找4到的索引是：" + index);
    }

    public static void sliceArray() {
        System.out.println();
        System.out.println("数组数组的复制");
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        System.out.println("方式1：使用System.arrayCopy方法");
        System.out.println("解释一下System.arrayCopy参数，源数组，开始复制的位置（一般是0），目标数组，复制到目标数组的位置（分情况，若前面有复制则是前面复制的结果位置，否则一般是0），复制的长度");
        // 创建一个数组，长度是2个数组的长度。
        // public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
        int[] mergedArray1 = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, mergedArray1, 0, array1.length);
        System.out.println("mergedArray1第一次复制内容是：" + Arrays.toString(mergedArray1));
        System.arraycopy(array2, 0, mergedArray1, array1.length, array2.length);
        System.out.println("mergedArray1第二次复制内容是：" + Arrays.toString(mergedArray1));

        System.out.println("方式2：循环遍历数组");
        // 创建一个数组，长度是2个数组的长度。
        int[] mergedArray2 = new int[array1.length + array2.length];
        int index2 = 0;
        for (int i: array1) {
            mergedArray2[index2++] = i;
        }

        for (int i: array2) {
            mergedArray2[index2++] = i;
        }

        System.out.println("mergedArray2内容是：" + Arrays.toString(mergedArray2));
    }

    public static void ArrayIndexOutOfBoundsException () {
        System.out.println();
        System.out.println("数组越界异常,一般是下标超出界限。");
        int[] anArray = new int[] {1, 2, 3, 4, 5};
        System.out.println(anArray[5]);
    }

    public static void main(String[] args) {
        creatArray();
        traverseArray();
        printStringArgs("我","叫", "coderWorld");
        arrayAndList();
        sortArray();
        sliceArray();
        ArrayIndexOutOfBoundsException();
    }

}

package com.study.basic;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        System.out.println("copy和copyRange方法在无元素时会默认填充null, fill则是默认填充数组");
        System.out.println("2.比较数组");
        boolean equalResult1 = Arrays.equals(new String[] { "沉", "默", "王", "二" }, exampleStringArray);
        boolean equalResult2 = Arrays.equals(new String[] { "1", "2", "3"}, exampleStringArray);
        System.out.println("比较数组1结果： " + equalResult1);
        System.out.println("比较数组2结果： " + equalResult2);
        System.out.println("3.数组排序");
        String[] sortedArray = new String[] {"11", "22", "33","1", "2", "3"};
        Arrays.sort(sortedArray);
        System.out.println("排序结果： " + Arrays.toString(sortedArray));
        System.out.println("4.数组检索");
        int binarySearchResult = Arrays.binarySearch(sortedArray, "33");
        System.out.println("二分查找结果： " + binarySearchResult);
        System.out.println("5.数组转流");
        System.out.println("数组转流结果： " + Arrays.stream(sortedArray).count());
        System.out.println("6.打印数组");
        System.out.println("打印数组结果： 使用Arrays.toString可以打印");
        System.out.println("7.数组转list");
        List<String> rets = Arrays.asList(sortedArray);
//        rets.add("coderWorld");
        System.out.println("数组转list结果： " + rets);
        System.out.println("8.setAll");
        int[] array = new int[10];
        Arrays.setAll(array, i -> i * 10);
        System.out.println("数组 setAll 结果： " + Arrays.toString(array));
        System.out.println("9.parallelPrefix");
        int[] arr = new int[] { 1, 2, 3, 4};
        Arrays.parallelPrefix(arr, (left, right) -> left + right);
        System.out.println("数组 parallelPrefix 结果： " +Arrays.toString(arr));
    }


    public static void useStringUtilsDemo()   {
        System.out.println();
        System.out.println("StringUtils工具类的使用");
        String str1 = null;
        String str2 = "";
        String str3 = " ";
        String str4 = "abc";
        System.out.println("1.字符串判空");
//        System.out.println("isEmpty: " + StringUtils.isEmpty(str1) + " " + StringUtils.isEmpty(str2) + StringUtils.isEmpty(str3) + " " + StringUtils.isEmpty(str4));
        System.out.println("2.分割字符串");
//        String str5 = "null";
//        System.out.println("split : " + StringUtils.split(str5, "") );
//        System.out.println("split ,: " + StringUtils.split(str5, ",") );
        System.out.println("3.判断纯数字");
        String str6 = "123";
        String str7 = "123q";
        String str8 = "0.33";
        System.out.println("4.集合拼接成字符串");
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        joinList = StringUtils.join(list, "");
//        List<Integer> list2 = Lists.newArrayList(1, 2, 3);
        System.out.println("5.其他");
        System.out.println("StringUtils类很多没用了");
    }


    public static void useObjectsDemo() {
        System.out.println();
        System.out.println("Objects工具类的使用");
        System.out.println("1.对象判空 isNull isNotNull");
        Integer obj1 = 1;
        Integer obj2 = null;
        System.out.println("obj1是否为空： " + Objects.isNull(obj1) + " obj2是否为空： " + Objects.isNull(obj2));
        System.out.println("2.对象为空时抛异常 requireNonNull");
        Integer integer1 = 128;
        Integer integer2 = null;
        System.out.println("integer1空时抛异常:  " + Objects.requireNonNull(integer1));
//        System.out.println("integer2空时抛异常:  " + Objects.requireNonNull(integer2));
        System.out.println("3.判断两个对象是否相等 Object.equals");
        System.out.println("obj1 和 integer1 是否相等： " + Objects.equals(obj1, integer1));
        System.out.println("4.获取对象的hashCode");
        System.out.println("obj1 的 hashCode： " + Objects.hashCode(obj1));
        System.out.println("5.比较两个对象");
        System.out.println("obj1 和 integer1 是否相等： " + Objects.compare(obj1, integer1, (o1, o2) -> o1.compareTo(o2)));
        System.out.println("6.比较两个数组 deepEquals");
        String[][] nestedArray1 = {{"A", "B"}, {"C", "D"}};
        String[][] nestedArray2 = {{"A", "B"}, {"C", "D"}};
        String[][] nestedArray3 = {{"A", "B"}, {"C", "E"}};

        System.out.println("比较两个数组： " + Objects.deepEquals(nestedArray1, nestedArray2));
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


    public static void useStringUtils()  {
        System.out.println();
        useStringUtilsDemo();
    }



    public static void useObjects()  {
        System.out.println();
        useObjectsDemo();
    }

    public static void main(String[] args) throws Exception {
        useScanner();
        useArrays();
        useStringUtils();
        useObjects();
    }
}

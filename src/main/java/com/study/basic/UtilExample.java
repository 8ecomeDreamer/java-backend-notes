package com.study.basic;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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


    public static void useCollectionsDemo() {
        System.out.println();
        System.out.println("Collections工具类的使用");
        System.out.println("1.排序操作");
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("原始数组内容：" + list);
        Collections.reverse(list);
        System.out.println("反转数组： " + list);
        Collections.shuffle(list);
        System.out.println("洗牌数组： " + list);
        Collections.sort(list);
        System.out.println("自然升序数组： " + list);
        list.sort((a, b) -> b.compareTo(a));
        System.out.println("规则器排序数组： " + list);
        Collections.swap(list, 1, 2);
        System.out.println("交换数组： " + list);
        System.out.println("2.查找操作");
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(32);
        list2.add(1006);
        list2.add(88);
        int maxNum = Collections.max(list2);
        System.out.println("最大元素：" + maxNum);
        int minNum = Collections.min(list2);
        System.out.println("最小元素： " + minNum);
        int frequency = Collections.frequency(list2, 88);
        System.out.println("出现的次数： " + frequency);
        System.out.println("排序前的二分查找结果： " + list2);
        int i = Collections.binarySearch(list2, 88);
        System.out.println("排序后的二分查找结果： " + i);
        Collections.fill(list2, 151);
        System.out.println("填充后的结果： " + list2);
        System.out.println("3.同步控制");
        System.out.println("4.不可变集合 emptyXXX SingletonXXX unmodifiableXXX");
        List<Object> emptyList = Collections.emptyList();
//        emptyList.add(2); 如果往emptyXxx中添加元素会报错
        Set<Object> objects = Collections.emptySet();
        System.out.println("emptyList： " + emptyList + " emptySet： " + objects);
        System.out.println("5.其他 addAll disJoint");
        List<Integer> listAll = new ArrayList<>();
         Collections.addAll(listAll, 32,42,2,12);
        System.out.println("listAll addAll 后 " + listAll);
        System.out.println("list2 " + list2);
        System.out.println("list2 和 listAll 是否有交集" + Collections.disjoint(list2, listAll));
        System.out.println("6.CollectionUtils：Spring 和 Apache 都有提供的集合工具类");
    }

    public static void useHutoolDemo()   {
        System.out.println();
        System.out.println("1.引入hutool");
        System.out.println("2.类型转换");
        String param = "10";
        System.out.println("hutool转成整数: " + Convert.toInt(param));
        String param2 = "2026-10-21";
        System.out.println("hutool转成日期: " + Convert.toDate(param2));
        String unicodeStr = "coderWorld";
        System.out.println("hutool转成unicode: " + Convert.strToUnicode(unicodeStr));
        System.out.println("3.日期时间");
        Date date = DateUtil.date();
        Date JDKDate = new Date();
        System.out.println("hutool当前时间： " + date);
        System.out.println("JDK当前时间： " + JDKDate);
        String parsedDate1 = "2028-04-12"; // YYMMDD
        String parsedDate2 = "2029-2-42 17:43:32"; // YYMMDD HH:mm:ss
        String parsedDate3 = "14:30:24"; // HH:mm:ss
        String parsedDate4 = "2029-2-42 17:43"; // YYMMDD HH:mm
        String parsedDate5 = "2029-2-42 7:43:"; // YYMMDD HH:mm:ss.SSS
        String parsedDate6 = ""; // 中文 二零一二年五月十五日
        System.out.println("hutool日期转对应格式： " );
        System.out.println("parsedDate1： " + DateUtil.parse(parsedDate1));
        System.out.println("parsedDate2： " + DateUtil.parse(parsedDate2));
        System.out.println("parsedDate3： " + DateUtil.parse(parsedDate3));
        System.out.println("parsedDate4： " + DateUtil.parse(parsedDate4));
        System.out.println("parsedDate5： " + DateUtil.parse(parsedDate5));
        System.out.println("parsedDate6： " + DateUtil.parse(parsedDate6));
        System.out.println("4.IO 流相关");
        System.out.println("IO流总结我觉得蛮对的，所有项目中File类中都应该要有关于文件移动、复制、删除等操作、以及文件名获取、文件路径获取、判断文件是否存在等方法");
        System.out.println("5.字符串工具");
        String template = "{}, 聪明勇敢有力气";
        String str = StrUtil.format(template, "coderWorld");
        System.out.println("str： " + str);
        System.out.println("6.反射工具");
        System.out.println("7.压缩工具");
        System.out.println("8.身份证工具");
        String ID_18 = "321083197812162119";
        String ID_15 = "150102880730303";
        boolean valid = IdcardUtil.isValidCard(ID_18);
        boolean valid15 = IdcardUtil.isValidCard(ID_15);
        System.out.println("18位身份证： " + valid);
        System.out.println("15位身份证： " + valid15);
        System.out.println("9.扩展 HashMap");
        Dict dict = Dict.create().set("name", "coderWorld").set("age", 18).set("sex", "男");
        Integer age = dict.getInt("age");
        String name = dict.getStr("name");
        System.out.println("dict： " + dict);
        System.out.println("age： " + age);
        System.out.println("name： " + name);
        System.out.println("Dict是字典类型，专门用于存储key-value类型，具有高效的查找性能。");
        System.out.println("10.控制台打印");
        int[] consoleInt = {41,22,31};
        Console.log("Hutool的打印类，很方便~ " + Arrays.toString(consoleInt));
        System.out.println("11.字段验证器");
        System.out.println("12.双向查找 Map");
        System.out.println("13.图片工具");
        System.out.println("14.配置文件");
        System.out.println("15.日志工厂");
        System.out.println("16.缓存工具");
        System.out.println("17.加密解密");
        AES aes = SecureUtil.aes();
        String encrypt = aes.encryptHex("coderWorld");
        System.out.println("encrypt： " + encrypt);
        String decrypt = aes.decryptStr(encrypt);
        System.out.println("decrypt： " + decrypt);
        System.out.println("18.其他类库");

        System.out.println("总结：");
        System.out.println("1. hutool常见类库： Convert、DateUtil");
        System.out.println("2. 关于DateUtil： ");
        System.out.println("2-1. toDate方法默认转成 YYMMDD HH:mm:ss 格式");
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

    public static void useCollections()  {
        System.out.println();
        useCollectionsDemo();
    }
    public static void useHutool()  {
        System.out.println();
        useHutoolDemo();
    }

    public static void main(String[] args) throws Exception {
        useScanner();
        useArrays();
        useStringUtils();
        useObjects();
        useCollections();
        useHutool();
    }
}

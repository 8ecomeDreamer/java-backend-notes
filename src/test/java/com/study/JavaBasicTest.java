package com.study;

import com.study.basic.ReverseInteger;
import com.study.basic.StringToInteger;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class JavaBasicTest {

    @Resource
    private ReverseInteger reverseInteger;
    @Resource
    private StringToInteger stringToInteger;

    @Test
    public void testJavaIntroduce() {
        System.out.println("java基础");
        System.out.println("1.java是强类型语言");
        System.out.println("2.java特性： 封装、多态、继承");
        System.out.println("3.JDK、JVM、JRE的关系: JRE（java runtime environment）java最底层的运行环境，JVM（java virtual machine）java虚拟机，JDK（java development kit）开发java应用程序的软件环境。");
        System.out.println("4.java的关键字不能定义为变量： return abstract switch等等...");
        System.out.println("5.java注释：单行注释 // 多行注释 /**/ 文档注释 /** * */");
        System.out.println("6.java数据类型： 基本数据类型、引用数据类型。基本数据类型： 数值型（整形 short int long 、浮点型 float double、字节型 byte） 布尔型 （boolean） 字符型 （char）。引用数据类型： 数组、类、接口");
        System.out.println("7.java数据类型转换: 分为自动类型转换和强制类型转换。自动类型转换通常发生在小类型自动转成大类型。强制类型转换通常可以使用具体类型。");
        System.out.println("8.java数据类型缓存池： new Integer和Integer.valueOf() 结果不一样，前者每次创建新的对象，后者会根据范围值若值在类型范围内则创建新对象否则使用原来对象。");
        System.out.println("9.java运算符：逻辑运算符、关系运算符、算数运算敷、位运算符、赋值运算符、三元运算符等。");
        System.out.println("10.java流程控制：if-else、switch、for、while、do-while、break、continue等");
        System.out.println("翻转整数和转正数案例");
    }

    @Test
    public void testArrayExample() {
        System.out.println("数组部分在ArrayExample");
    }

    @Test
    public void testReverseInteger() {
        System.out.println("翻转整数： 给定一个 32 位有符号整数，将整数中的数字进行反转。 输入: 123 输出: 321  输入: -123 输出: -321");
        System.out.println("翻转前 123" + " 翻转结果为：" + ReverseInteger.reverse(123));
        System.out.println("翻转前 -123" + " 翻转结果为：" + ReverseInteger.reverse(-123));
    }

    @Test
    public void testStringToInteger() {
        System.out.println("字符串转换整数： 请你来实现一个 parseInt 方法，使其能将字符串转换成整数。");
        System.out.println("翻转前 \"42\"" + " 翻转结果为：" + StringToInteger.parseInt("42"));
        System.out.println("翻转前 \"   -42\"" + " 翻转结果为：" + StringToInteger.parseInt("    -42"));
        System.out.println("翻转前 \"4193 with words\"" + " 翻转结果为：" + StringToInteger.parseInt("4193 with words"));
        System.out.println("翻转前  \"91283472332\"" + " 翻转结果为：" + StringToInteger.parseInt( "91283472332"));
    }


    @Test
    public void testJavaException() {
        System.out.println("exception和error的区别？");
        System.out.println(" error为错误,exception为异常; exception可控不会导致程序退出，error则会退出。");
        System.out.println("checked和unchecked异常是什么？");
        System.out.println(" checked异常需要显示抛出，而unchecked不需要显示抛出。前者如IOException、SQLException、ClassNotFoundException，后者如NullPointerException、ArrayIndexOutOfMemoryException、illegalArgumentException");
        System.out.println(" 遇到checked异常线下环境可以使用printTrace,线上环境可以使用throws");
        System.out.println("throw和throws的区别？");
        System.out.println(" 可以理解成英语语法的动词和形容词，throw跟异常，throws后面跟异常的名字");
    }
}

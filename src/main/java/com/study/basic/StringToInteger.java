package com.study.basic;

/**
 * 请你来实现一个 parseInt 方法，使其能将字符串转换成整数。
 * 示例 1（正数）:
 * 输入: "42"
 * 输出: 42
 * 示例 2（带空格的负数）:
 * 输入: "   -42"
 * 输出: -42
 * 示例 3（带非数字的字符）:
 * 输入: "4193 with words"
 * 输出: 4193
 * 示例 4（超出 int 范围）:
 * 输入: "91283472332"
 * 输出: 2147483647
 */
public class StringToInteger {

    public static int parseInt(String str) {
        int index = 0; // 用于遍历字符串
        int sign = 1; // 用于标记正负号
        int total = 0; // 用于存储转换后的整数

        // 1. 跳过前面的空格
        while (index < str.length() && str.charAt(index) == ' ') index++;

        // 2. 检查正负号
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // 3. 转换数字
        while (index < str.length()) {
            int digit = str.charAt(index) - '0'; // 获取当前字符对应的数字
            if (digit < 0 || digit > 9) break; // 如果不是数字则退出循环
            // 检查溢出：如果 total > Integer.MAX_VALUE/10 或 total == Integer.MAX_VALUE/10 且 digit > Integer.MAX_VALUE%10，则会溢出
            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit; // 将 digit 添加到 total 的最后
            index++;
        }
        return total * sign; // 返回转换后的整数
    }
}

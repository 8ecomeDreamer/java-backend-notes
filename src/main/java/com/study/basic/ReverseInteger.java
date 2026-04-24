package com.study.basic;

/**
 *   翻转整数： 给定一个 32 位有符号整数，将整数中的数字进行反转。 输入: 123 输出: 321  输入: -123 输出: -321
 */
public class ReverseInteger {
    public static int reverse(int x) {
        int rev = 0; // 存储反转后的结果
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // 检查溢出：如果 rev > Integer.MAX_VALUE/10 或 rev < Integer.MIN_VALUE/10，则会溢出
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) return 0;

            rev = rev * 10 + pop; // 将 pop 添加到 rev 的最后
        }

        return rev; // 返回反转后的整数
    }
}

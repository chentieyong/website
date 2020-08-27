package com.shenzhou.utils;

import java.util.Stack;

/**
 * Created by apple on 15/12/17.
 */
public class HexConversionUtil {

    /**
     * 将数转为任意进制
     *
     * @param num
     * @param base
     * @return
     */
    public static String hexConversion(int num, int base) {
        if (base > 16) {
            throw new RuntimeException("进制数超出范围，base<=16");
        }
        StringBuffer str = new StringBuffer("");
        String digths = "0123456789ABCDEF";
        Stack<Character> s = new Stack<Character>();
        while (num != 0) {
            s.push(digths.charAt(num % base));
            num /= base;
        }
        while (!s.isEmpty()) {
            str.append(s.pop());
        }
        return str.toString();
    }

    /**
     * 16进制内任意进制转换
     *
     * @param num
     * @param srcBase
     * @param destBase
     * @return
     */
    public static String hexConversion(String num, int srcBase, int destBase) {
        if (srcBase == destBase) {
            return num;
        }
        String digths = "0123456789ABCDEF";
        char[] chars = num.toCharArray();
        int len = chars.length;
        if (destBase != 10) {//目标进制不是十进制 先转化为十进制
            num = hexConversion(num, srcBase, 10);
        } else {
            int n = 0;
            for (int i = len - 1; i >= 0; i--) {
                n += digths.indexOf(chars[i]) * Math.pow(srcBase, len - i - 1);
            }
            return n + "";
        }
        return hexConversion(Integer.valueOf(num), destBase);
    }
}

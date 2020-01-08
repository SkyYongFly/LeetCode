package cn.skylaker.leetcode.stack;

import org.junit.jupiter.api.Test;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 */
public class L07_IntReverse {
    @Test
    public void test(){
        System.out.println(reverse(-2147483412));
    }

    /**
     * 思路：转换成字符串反向拼接处理
     *
     * 执行用时 :3 ms, 在所有 Java 提交中击败了31.34% 的用户
     * 内存消耗 :35.6 MB, 在所有 Java 提交中击败了77.52%的用户
     */
    public int reverse(int x) {
        char[] str = String.valueOf(x).toCharArray();

        // 根据正负取符号
        String newVal = x < 0 ? String.valueOf(str[0]) : "";
        int end = x < 0 ? 1 : 0;

        for(int i = str.length - 1; i >= end; i--){
            newVal += String.valueOf(str[i]);
        }

        // 如果溢出则会抛出异常捕获即可
        try{
            return Integer.valueOf(newVal);
        } catch (Exception e){
            return 0;
        }

    }
}

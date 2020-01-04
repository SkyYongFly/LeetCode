package cn.skylaker.leetcode.util;

public class CommonUtils {
    /**
     * 打印数组
     * @param nums
     */
    public static void printArray(int[] nums){
        if(null == nums || 0 == nums.length){
            System.out.println("null");
        }

        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}

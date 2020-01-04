package cn.skylaker.leetcode.array;

import java.util.HashMap;

/**
 * 计算两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例：
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 */
public class L01_TwoNumberSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = twoSum3(nums, 9);

        if(null != result){
            for(int i : result){
                System.out.println(i);
            }
        }
    }

    //算法一：直接循环 时间复杂度 O(n^2) 空间复杂度 O(1)
    public static int[] twoSum(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return null;
        }

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    //算法二：利用Hash操作 时间复杂度 O(n) 空间复杂度 O(n)
    public static int[] twoSum2(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return null;
        }

        // 先将数组元素存入Hash结构中,key为元素值，value为数组索引
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        // 从前到后判断是否存在，当前值为 a ，如果存在另一个数相加为target，那么map一定包含 target - a
        for(int i = 0; i < nums.length; i++){
            // 需要排除当前元素，例如会出现 {3, 2 , 4} 目标值为6，而 3 + 3 = 6
            // 其实隐含一种特殊情况，例如 {3, 2, 3},目标值 6 ，map中保存3只有一个节点，即索引2对应的节点
            if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
        }

        return null;
    }

    //算法三：对算法二的优化，即进行存入hash表的同时进行判断
    // 时间复杂度 O(n) 空间复杂度 O(n)
    public static int[] twoSum3(int[] nums, int target) {
        if(null == nums || nums.length == 0){
            return null;
        }

        // 先将数组元素存入Hash结构中,key为元素值，value为数组索引
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for(int i = 0; i < nums.length; i++){
            int next = target - nums[i];

            if(i > 0 && map.containsKey(next)){
                return new int[]{i, map.get(next)};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}
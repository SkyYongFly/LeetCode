package cn.skylaker.leetcode.divide;

import org.junit.jupiter.api.Test;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class L53_MaxSubArray {
    @Test
    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(nums));
    }


    /**
     * 直接暴力法，依次遍历，找出所有可能组合
     * 但是时间复杂度较大，导致超出题目 时间限制
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j <= nums.length - i; j++){
                int sum = sum(nums, i, i + j - 1);
                if(sum > max){
                    max = sum;
                }
            }
        }

        return max;
    }

    private int sum(int[] nums, int start, int end){
        int sum = 0 ;
        for(int k = start; k <= end; k++){
            sum += nums[k];
        }
        return sum;
    }


    /**
     * 贪心算法，以任意位置n为结束点的子数组最大和，如果不是n位置元素本身，那么就是以位置n-1为结束位置的最大子数组加n位置元素本身，
     *
     * 0 1 2 ... m ... n-1  n
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

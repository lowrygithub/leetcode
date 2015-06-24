/**
 * Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Hide Tags Dynamic Programming

 */
package leetcode;

public class HouseRobberII {
	public int rob(int[] nums) {
        int len = nums.length;
        if(len==0)
            return 0;
        if(len==1)
            return nums[0];
        return Math.max(rob1(nums, 0, len-1), rob1(nums, 1, len));
    }
    public int rob1(int[] nums, int start, int end) {
        int len = end - start;
        int[] result = new int[len];
        if(len == 0)
            return 0;
        result[0] = nums[start];
        if(len == 1)
            return result[0];
        result[1] = Math.max(nums[start], nums[start+1]);
        for(int i=2;i<len;i++){
            result[i] = Math.max(result[i-1], result[i-2]+nums[i+start]);
        }
        return result[len-1];
    }
}

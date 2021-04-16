package _53_最大子序和;

/**
 * 题目：
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
class Solution {
    /**
	 * self思路：【写的还是有点混乱，更清晰的dp思见Solution2】
	 * dp
	 * 1.dp[i]:下标i的元素结尾的数组的最大子数组和(负数结尾的dp[i]=dp[i-1]+nums[i]>0?(dp[i-1]+nums[i]):0)
	 * 2.转移方程：
	 * dp[n]=
	 * (1)dp[i-1]+nums[i];							nums[i]>=0;
	 * (2)dp[i-1]+nums[i]>0?(dp[i-1]+nums[i]):0; 	nums[i]<0;
	 */
	public int maxSubArray(int[] nums) {
		//base
		if(nums.length<1) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = Math.max(0,nums[0]);
		int max = nums[0];
		for(int i=1;i<nums.length;i++) {
            max = Math.max(max,nums[i]);
			if(nums[i]>=0) {
				dp[i] = nums[i] + dp[i-1];
			}
			else {
				dp[i] = (nums[i]+dp[i-1])>0?nums[i]+dp[i-1]:0;
			}
            if(dp[i]!=0){
                max = Math.max(max, dp[i]);
            }
		}
		return max;
    }
}

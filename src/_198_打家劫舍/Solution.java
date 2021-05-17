package _198_打家劫舍;

/**
 * 题目：
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素
 * 就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Solution {
	/**
	 * self思路：【但没想出来转移方程...】
	 * dp
	 * 1.dp[i]=截止第i家的最大偷窃金额
	 * 2.转移方程【HDP】
	 * 【官方思路】第i家人，可以选择：【偷or不偷】——>
	 * (1)偷：则=nums[i]+第i-1家不能偷，那么就加上dp[i-2]
	 * (2)不偷：则=dp[i-1]
	 * dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2])
	 */
	public int rob(int[] nums) {
		//base
		if(nums.length==1) {
			return nums[0];
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++) {
			dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]); 
		}
		return dp[nums.length-1];
    }
}

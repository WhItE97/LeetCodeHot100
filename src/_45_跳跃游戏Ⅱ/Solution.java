package _45_跳跃游戏Ⅱ;

/**
 * 题目：
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 说明：假设你总是可以到达数组的最后一个位置。
 */
public class Solution {
	/**
	 * self思路：O(N^2)
	 * dp..
	 * 1.dp[i]:跳到下标i所需的最少步数
	 * 2.转移方程dp[i]=
	 * min{1+dp[i-1]&&nums[i-1]>=1;1+dp[i-2]&&nums[i-2]>=2...}
	 */
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		for(int i=1;i<nums.length;i++) {
			//对每一个位置求最少跳跃次数
			int min = Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				//如果j到i可达
				if((j+nums[j])>=i) {
					min = Math.min(dp[j]+1, min);
				}
			}
			dp[i] = min;
		}
		return dp[nums.length-1];
    }
}

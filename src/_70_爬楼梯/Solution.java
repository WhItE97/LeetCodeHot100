package _70_爬楼梯;

/**
 * 题目：
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 */
public class Solution {
	/**
	 * self思路：
	 * dp
	 * 1.dp[i]:i-1阶楼梯的爬法数量
	 * 2.转移方程
	 * dp[i] = dp[i-1]+dp[i-2]
	 */
	public int climbStairs(int n) {
		//【WRONG POINT.别忘了base...】
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++) {
        	dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}

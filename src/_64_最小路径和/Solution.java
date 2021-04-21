package _64_最小路径和;

/**
 * 题目：
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class Solution {
	/**
	 * self思路：【虽然AC了，但是这样写其实是有问题的！在Math.min中如果dp[i-1][j]或dp[i][j-1]真的大于Integer.MAX_VALUE了，那就有问题！所以需要把第一列和第一行拆开写！】
	 * 见Solution2
	 * dp
	 * 1.dp[i][j]:到达(i,j)位置元素的路径最小数字总和
	 * 2.转移方程dp[i][j]=
	 * min{dp[i-1][j],dp[i][j-1]}+grid[i][j]
	 */
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0&&j==0) {
					dp[i][j] = grid[i][j];
				}
				else {
					dp[i][j] = Math.min((i-1)>=0?dp[i-1][j]:Integer.MAX_VALUE, (j-1)>=0?dp[i][j-1]:Integer.MAX_VALUE)+grid[i][j];
				}
			}
		}
		return dp[m-1][n-1];
    }
}

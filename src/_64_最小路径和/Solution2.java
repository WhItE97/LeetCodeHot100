package _64_最小路径和;

public class Solution2 {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		//先记录第一行的dp
		for(int i=1;i<n;i++) {
			dp[0][i] = dp[0][i-1]+grid[0][i];
		}
		//再记录第一列的dp
		for(int i=1;i<m;i++) {
			dp[i][0] = dp[i-1][0]+grid[i][0];
		}
		//再遍历剩下的
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
			}
		}
		return dp[m-1][n-1];
    }
}

package _62_不同路径;

public class Solution2 {
	/**
	 * 【动态规划 O(MN)】（base：可以分解为子问题）
	 * 1.dp[i][j]:起点到[i,j]位置的总走法数
	 * 2.转移方程dp[i][j]=dp[i-1][j]+dp[i][j-1]
	 */
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0&&j==0) {
					continue;
				}
				dp[i][j] = ((i-1)>=0?dp[i-1][j]:0) + ((j-1)>=0?dp[i][j-1]:0);
			}
		}
		return dp[m-1][n-1];
	}
}

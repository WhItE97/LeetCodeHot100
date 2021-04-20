package _62_��ͬ·��;

public class Solution2 {
	/**
	 * ����̬�滮 O(MN)����base�����Էֽ�Ϊ�����⣩
	 * 1.dp[i][j]:��㵽[i,j]λ�õ����߷���
	 * 2.ת�Ʒ���dp[i][j]=dp[i-1][j]+dp[i][j-1]
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

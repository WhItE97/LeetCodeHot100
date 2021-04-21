package _64_��С·����;

/**
 * ��Ŀ��
 * ����һ�������Ǹ������� m x n ���� grid �����ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��
 * ˵����ÿ��ֻ�����»��������ƶ�һ����
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class Solution {
	/**
	 * self˼·������ȻAC�ˣ���������д��ʵ��������ģ���Math.min�����dp[i-1][j]��dp[i][j-1]��Ĵ���Integer.MAX_VALUE�ˣ��Ǿ������⣡������Ҫ�ѵ�һ�к͵�һ�в�д����
	 * ��Solution2
	 * dp
	 * 1.dp[i][j]:����(i,j)λ��Ԫ�ص�·����С�����ܺ�
	 * 2.ת�Ʒ���dp[i][j]=
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

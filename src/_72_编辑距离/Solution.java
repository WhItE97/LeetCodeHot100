package _72_编辑距离;

/**
 * 题目：
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 0 <= word1.length, word2.length <= 500
 */
public class Solution {
	/**
	 * self思路：
	 * none...
	 * 力扣【官方视频】题解思路：【O(MN)】
	 * dp！
	 * 1.dp[i][j]:word1的前i个字符 转换成 word2的前j个字符的 编辑距离
	 * 2.【HDP.状态转移方程 比较难想&&理解，配合例子食用】
	 * 如word1的i和word2的j如下：
	 * word1的前i=xxxa
	 * word2的前j=xxb
	 * 由例子可以看出，我们想写状态转移方程，必须先判断word1[i]和word2[j]的关系！（即他们是否相等！）
	 * （1）word1[i]==word2[j]:可以直接去掉他俩——>dp[i][j]=dp[i-1][j-1]
	 * （2）word1[i]!=word2[j]:则需要进行【操作(一共就3种！增or删or改)】！
	 * 		①在word1增加一个和word2[j]match的字符：dp[i][j]=dp[i][j-1]+1(这个+1是增加操作)
	 * 		②把word1不match的给删掉：dp[i][j]=dp[i-1][j]+1(这个+1是删除操作)
	 * 		③把word1不match的给替换成match的：dp[i][j]=dp[i-1][j-1]+1(这个+1是替换操作)
	 */
	public int minDistance(String word1, String word2) {
		//base
		if(word1.length()==0) {
			return word2.length();
		}
		int l1 = word1.length()+1;
		int l2 = word2.length()+1;
		int[][] dp = new int[l1][l2];
		//首先初始化word1和word2下标为0时候的dp数组
		//1.初始化word1前0个字符表示word2的编辑距离
		for(int i=0;i<l2;i++) {
			dp[0][i] = i;
		}
		//2.初始化word2前0个字符表示word1的编辑距离
		for(int i=0;i<l1;i++) {
			dp[i][0] = i;
		}
		//开始dp
		for(int i=1;i<l1;i++) {
			for(int j=1;j<l2;j++) {
				if(word1.charAt(i-1)==word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					int min1 = Math.min(dp[i][j-1], dp[i-1][j]);
					dp[i][j] = Math.min(min1, dp[i-1][j-1])+1;
				}
			}
		}
		return dp[l1-1][l2-1];
    }
}

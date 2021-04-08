package _4_最长回文子串;

public class Solution3 {
	/**
	 * 2021/4/7 dp方法review【WRONG！！！！！！！】
	 * boolean f[i][j]:s[i]~s[j]是否是回文串
	 * 转移方程f[i][j]=
	 * (1)false;					i>j非法
	 * (2)true;						i==j单个字符显然是回文
	 * (3)s[i]==s[j];				j-i==1【ATT！】
	 * (3)f[i+1][j-1]&&s[i]==s[j];	i<j
	 * 初始状态
	 * f[0][0] = true;//表示第一个字符
	 * ***********************************************
	 * 【开始分析上述思路的逻辑漏洞】
	 * f[i][j] = f[i+1][j-1]&&s[i]==s[j]的转移方程，base是i~j的子序列(i-1)~(j-1)已经check过了
	 * 那么我如果照下面的for(int i=0;i<s.length();i++){for(int j=i;j<s.length();j++){}}的2层嵌套的话
	 * 在i=0,j=k的时候，其子序列i=1,j=k-1都还没有check过！自然是false！！
	 * 【所以正确的思路】
	 * 因为我们的转移方程base的是子序列，所以我们循环也要从子序列层层向上求！所以最外层循环应该是子序列长度！从1个字符开始！
	 * 见Solution4
	 */
	public String longestPalindrome(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		int maxl = 0;
		int maxr = 0;
		dp[0][0] = true;
		for(int i=0;i<s.length();i++) {
			for(int j=i;j<s.length();j++) {
				//i==j,单个字符
				if(i==j) {
					dp[i][j] = true;
				}
				else if((j-i)==1) {
					dp[i][j] = s.charAt(i)==s.charAt(j);
				}
				//i<j
				else {
					dp[i][j] = dp[i+1][j-1]&&s.charAt(i)==s.charAt(j);
				}
				//每轮检查true的字符串长度是否比max大，大的话更新maxl和maxr
				if(dp[i][j]&&(j-i)>(maxr-maxl)) {
					maxl = i;
					maxr = j;
				}
			}
		}
		return s.substring(maxl,maxr+1);
    }
}

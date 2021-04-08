package _4_最长回文子串;

public class Solution4 {
	/**
	 * boolean dp[i][j]:i to j的子序列是否是回文
	 * 【CORE1】状态转移方程：
	 * dp[i][j]=
	 * (1)false;					i>j非法
	 * (2)true;						i==j单字符
	 * (3)s[i]==s[j];				j-i==1
	 * (4)s[i]==s[j]&&dp[i+1][j-1];	else
	 * 【CORE2】
	 * 因为状态转移方程是长串的base子串的结果，所以最外层循环以串长度从小到大遍历
	 */
	public String longestPalindrome(String s) {
		int maxl = 0;
		int maxr = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		dp[0][0] = true;
		//【CORE2】
		for(int len=1;len<=s.length();len++) {
			for(int i=0;i<=s.length()-len;i++) {
				//1.len==1
				if(len==1) {
					dp[i][i] = true;
				}
				//2.len==2
				else if(len==2) {
					dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
				}
				//3.len>2
				else {
					dp[i][i+len-1] = dp[i+1][i+len-2]&&s.charAt(i)==s.charAt(i+len-1);
				}
				//每轮check为true的串的长度是否比最长子串长！如果更长，则更新最长子串的指针
				if(dp[i][i+len-1]&&len>(maxr-maxl+1)) {
					maxl = i;
					maxr = i+len-1;
				}
			}
		}
		return s.substring(maxl,maxr+1);
    }
}

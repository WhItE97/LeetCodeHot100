package _10_正则表达式匹配;

/**
 * 题目：
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * ATT.
 * s 可能为空，且只包含从 a-z 的小写字母
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class Solution {
	/**
	 * 还是看了题解..思路：
	 * 如何处理*这个字符：【CORE.HDP①把他和它前面的ch绑定处理！！！！！“ch*”】
	 * 因为*是重复前面的字符，所以不妨从后向前match<不用！从前向后也可!>
	 * boolean f[i][j]:s的前i个字符能否由p的前j个字符匹配<TRUE>
	 * 转移方程：
	 * f[i][j]=
	 * (1)p[j]!=*
	 * matches=f[i-1][j-1]
	 * 不match=false;
	 * (2)p[j]==*【HDP② “ch*”整体的处理】
	 * 1)【HDP③ 管都不管这一对，直接把两个都抛弃=f[i][j-2]】
	 * 2)尝试用这一对去match，又会有match成功和失败2中situs：
	 * 2a)成功=f[i-1][j]
	 * 2b)失败=f[i][j-2]
	 */
	public boolean isMatch(String s, String p) {
		//base
		if(s.length()!=0&&p.length()==0) {
			return false;
		}
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;
		for(int i=0;i<=s.length();i++) {//【ATT.i可以从0开始！因为空s可以用非空p match！】
			for(int j=1;j<=p.length();j++) {
				//1.p[j]!='*'
				if(p.charAt(j-1)!='*') {
					if(matches(s,i,p,j)) {
						dp[i][j] = dp[i-1][j-1];
					}
					else {
						dp[i][j] = false;
					}
				}
				//2.p[j]=='*'，将他和前一个ch组合
				else {
					//2.1.不尝试去match，直接扔掉“ch*”
					dp[i][j] = dp[i][j-2];
					//2.2.尝试去match(如果已经为true，倒也不必再尝试了)
					if(dp[i][j]!=true) {
						//(1)match成功
						if(matches(s,i,p,j-1)) {
							dp[i][j] = dp[i-1][j];
						}
						//(2)match失败
						else {
							dp[i][j] = dp[i][j-2];
						}
					}
				}
			}
		}
		return dp[s.length()][p.length()];
    }
	//【HDP④ 把i、j和含义与下标的对应关系丢到单个match的子函数里处理！】
	//输入第i位和第j位进行match，所以函数内部对应原下标要-1
	public boolean matches(String s,int i,String p,int j) {
		if(i==0) {//【HDP⑤】i从0开始，考虑的是s为空串，p还是必须进入循环的（p可能="x*"）！但是下标是不能取-1的，所以直接return false；至于s=""和p="x*"就交给dp[0][2]=直接丢弃“ch*”组合=dp[0][0]的情况去处理即可！
			return false;
		}
		if(p.charAt(j-1)=='.') {
			return true;
		}
		else {
			return s.charAt(i-1)==p.charAt(j-1);
		}
	}
}

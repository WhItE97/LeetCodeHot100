package _32_最长有效括号;

/**
 * 题目：
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class Solution {
	/**
	 * self思路：
	 * dp——>但没写出来转移方程...
	 * 
	 * 官方题解dp self实现：【O(N)+O(N) 2ms 70%，但是逻辑写的太混乱了...见Solution2】
	 * dp[i]:以下标i的字符结尾的串的最长有效括号子串
	 * 【TRICK 因为dp的状态定义是以s[i]结尾！所以'('显然是非法状态！，其dp=0】
	 * 【转移方程 HDP】
	 * dp[i]=
	 * (1)2+dp[i-2];					s[i-1]=='(';
	 * (2)2+dp[i-1]+dp[i-dp[i-1]-2];	s[i-dp[i-1]-1]=='(';【MOST CORE HDP】这种跨尺度的match，还需要考虑找到遥远的左括号的左边一位的dp值！【因为这一对跨尺度的match只记录了自己的长度，他前面可能还有合法串！】
	 * (3)0;							else;
	 */
	public int longestValidParentheses(String s) {
		//base
		if(s.length()==0) {
			return 0;
		}
		int[] dp = new int[s.length()];
		dp[0] = 0;
		int max = 0;
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				dp[i] = 0;
			}
			else if(s.charAt(i-1)=='(') {
				dp[i] = ((i-2)>=0)?2+dp[i-2]:2;//【WRONG POINT.()的情况要考虑i-2越界了！】
			}
			else if((i-dp[i-1]-2)<0) {//【WRONG POINT 3.这里前面虽然没有子串了，但还要考虑本轮这个)有没有跨尺度match成功！】
				if((i-dp[i-1]-1)<0) {//【WRONG POINT 4.考虑本轮跨尺度match之前，还得考虑本轮还有没有余量供我们跨尺度match...】
					dp[i] = 0;
				}
				else if(s.charAt(i-dp[i-1]-1)=='(') {
					dp[i] = 2+dp[i-1];
				}
				else {
					dp[i] = 0;
				}
			}
			else if(s.charAt(i-dp[i-1]-1)=='(') {//【WRONG POINT 2.同样的没考虑越界...写到上面的else if里了】
				dp[i] =  2+dp[i-1]+dp[i-dp[i-1]-2];
			}
			else {
				dp[i] = 0;
			}
			System.out.println("i="+i+",dp[i]="+dp[i]);
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		return max;
    }
}


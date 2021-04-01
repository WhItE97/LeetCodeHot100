package _3_无重复字符的最长子串;

import java.util.Arrays;

/**
 * 题目：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution {
	/**
	 * self思路：【17ms 20%】
	 * “最长子串”->dp
	 * 1.dp[i]:以i结尾的最长子串长度
	 * 2.转移方程
	 * dp[i]=
	 * (1)dp[i-1]+1; 				s[i]在s[i-1]~s[i-dp[i-1]]都没出现过
	 * (2)i-上一次本字符出现的位置; 		else
	 * 所以需要实现一个search pre的子函数
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s.length()<1) {
			return 0;
		}
		int[] dp = new int[s.length()];
		dp[0] = 1;
		for(int i=1;i<s.length();i++) {
			int pre = searchPre(s,s.charAt(i),i-dp[i-1],i-1);
			dp[i] = (pre==-1)?dp[i-1]+1:(i-pre);
		}
		Arrays.sort(dp);
		return dp[s.length()-1];
    }
	//在[start,end]里查找target字符，返回最近一次出现的下标
	//如果没找到则返回-1
	public int searchPre(String s,char target,int start,int end) {
		for(int i=end;i>=start;i--) {
			if(s.charAt(i)==target) {
				return i;
			}
		}
		return -1;
	}
}

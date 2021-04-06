package _4_最长回文子串;

/**
 * 题目：
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class Solution {
	/**
	 * self思路：【1665ms 5%...】
	 * 遍历所有起点，求其最长回文子串，如果比当前存的最长子串（通过maxl和maxr标记下标）长，则更新下标
	 */
	public String longestPalindrome(String s) {
		if(s.length()==0) {
			return "";
		}
		int maxl = 0;
		int maxr = 1;//【ATT.最好设置成[maxl,maxr)左闭右开！因为substring函数是左闭右开的！】
		int maxlen = maxr-maxl;
		for(int i=0;i<s.length();i++) {
			//遍历每个字符做起点的最长子串
			//1.首先判断当前剩下长度是否比最长子串长，如果都不及最长子串长了，那直接break
			if((s.length()-i)<maxlen) {
				break;
			}
			//2.否则开始进行当前字符为起点的最长子串查找
			for(int j=i+1;j<=s.length();j++) {//【ATT2.这里要注意左闭右开！所以右边应该可以取到length()！】
				//2.1.一位一位加长子串进行判断，如果是回文串，则和maxlen比较，如果更长，则更新maxl,maxr,maxlen
				if(isPalindrome(s.substring(i,j))) {
					//和maxlen比较
					if((j-i)>maxlen) {
						maxl = i;
						maxr = j;
						maxlen = maxr-maxl;
					}
				}
			}
		}
		return s.substring(maxl,maxr);
    }
	
	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length()-1;
		while(left<right) {
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}

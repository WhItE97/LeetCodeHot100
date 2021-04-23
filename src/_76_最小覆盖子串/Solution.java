package _76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 */
public class Solution {
	/**
	 * self思路：【264/266测试用例超时】
	 * 窗口大小从t.length()递增，找到第一个能够包含t中所有字符的子串并返回
	 */
	public String minWindow(String s, String t) {
		for(int win=t.length();win<=s.length();win++) {//遍历所有窗口大小
			for(int i=0;i<=s.length()-win;i++) {//遍历某窗口大小的所有子串
				int ret = contains(s,t,win,i);
				if(ret==1) {
					return s.substring(i,i+win);
				}
			}
		}
		return "";
    }
	
	//return 1表示match成功；-1表示match失败
	public int contains(String s,String t,int win,int i) {
		//具体match方式：把t的字符都放进hashmap，每match到一次就对该字符value-1，value==0的就可以从map删除，mapsize==0即match成功
		Map<Character,Integer> map = new HashMap<>();
		for(int j=0;j<t.length();j++) {
			int times = map.getOrDefault(t.charAt(j), 0);
			map.put(t.charAt(j), times+1);
		}
		//开始match
		for(int j=i;j<i+win;j++) {
			if(map.get(s.charAt(j))!=null) {//【ATT.hashmap的get如果no mapping会返回null！】
				map.put(s.charAt(j), map.get(s.charAt(j))-1);
				if(map.get(s.charAt(j))==0) {
					map.remove(s.charAt(j));
				}
			}
			if(map.size()==0) {
				return 1;
			}
		}
		return -1;
	}
}

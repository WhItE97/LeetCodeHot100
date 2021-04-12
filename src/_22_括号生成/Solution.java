package _22_括号生成;

import java.util.List;
import java.util.Deque;
import java.util.LinkedList;
/**
 * 题目：
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 1 <= n <= 8
 */
public class Solution {
	/**
	 * self思路：【WRONG.没调通，写的太垃圾了】【这种没有左括号和右括号剩余数目指针的写法不好写！见Solution2】
	 * 2个栈，一个装左括号，一个装右括号。针对左括号出栈数k，右括号可以选择出0~k。——>dfs
	 */
	public List<String> generateParenthesis(int n) {
		Deque<Character> st1 = new LinkedList<>();
		Deque<Character> st2 = new LinkedList<>();
		for(int i=0;i<n;i++) {
			st1.push('(');
			st2.push(')');
		}
		dfs(st1,st2);
		return res;
    }
	
	List<String> res = new LinkedList<>();
	StringBuilder sb = new StringBuilder();
	
	public void dfs(Deque<Character> st1,Deque<Character> st2) {
		//1.结束条件
		if(st1.isEmpty()&&st2.isEmpty()) {
			res.add(sb.toString());
			return;
		}
		//2.dfs
		int gap = st2.size()-st1.size();
		System.out.println("gap="+gap);
		if(gap<0) {//1.说明右括号比左括号还多了，必不合理
			return;
		}
		else if(gap==0) {//2.说明左右括号当前前面的都match，但这一轮必须出左括号了
			//(1)做选择
			sb.append(st1.pop());
			//(2)dfs
			dfs(st1,st2);
			//(3)撤销选择
			sb.delete(sb.length()-1, sb.length());
			st1.push('(');
		}
		else {//3.左括号比右括号多，所以右括号有多条支路可以选(但是如果左括号的栈已经空了，右括号的栈就必须全出了！)
			for(int i=(st1.isEmpty())?1:0;i<=gap;i++) {
				//(1)做选择
				for(int j=0;j<i;j++) {
					sb.append(st2.pop());
				}
				//(2)dfs
				dfs(st1,st2);
				//(3)撤销选择
				sb.delete(sb.length()-i, sb.length());
				for(int j=0;j<i;j++) {
					st2.push(')');
				}
			}
		}
	}
}

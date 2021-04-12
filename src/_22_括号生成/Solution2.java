package _22_括号生成;

import java.util.List;
import java.util.ArrayList;
public class Solution2 {
	/**
	 * 力扣liweiwei1419思路：【1ms 96%】
	 * dfs——>int left:左括号剩余数；int right:右括号剩余数
	 * dfs：
	 * 1.结束条件 left==0&&right==0
	 * 2.dfs过程：只要left>0，就还可以选left进入下一轮dfs；right同理
	 * 【自己本来想的一样，但是没写出来！HDP在于：本题dfs的做选择阶段，分为了2个part！】
	 * 【1.优先左括号，所以if(left>0)的part；2.针对前面已经dfs的左括号情况，【紧接着】讨论右括号的情况！】
	 * 【ATT.其中右括号不仅要right>0，还必须满足right>left（说明当前字符串左括号个数>右括号）！】
	 */
	public List<String> generateParenthesis(int n) {
		int left = n;
		int right = n;
		dfs(left,right);
		return res;
    }
	
	List<String> res = new ArrayList<>();
	StringBuilder sb = new StringBuilder();
	public void dfs(int left,int right) {
		System.out.println("now sb="+sb.toString());
		//结束条件
		if(left==0&&right==0) {
			res.add(sb.toString());
			return;
		}
		//dfs
		if(left>0) {
			//做选择
			sb.append('(');
			//dfs
			dfs(left-1,right);
			//撤销选择
			sb.delete(sb.length()-1,sb.length());
		}
		if(right>0&&right>left) {
			//做right的选择
			sb.append(')');
			//dfs
			dfs(left,right-1);
			//撤销选择
			sb.delete(sb.length()-1, sb.length());
		}
	}
}

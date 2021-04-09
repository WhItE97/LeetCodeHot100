package _17_电话号码的字母组合;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Solution2 {
	/**
	 * self思路：【1ms 83%】
	 * 典型dfs
	 * 【TRICK】map的设置：可以直接把数字对应的字母编排成字符串传入！节约了转为char[]的空间以及繁琐的map初始化！
	 * 
	 * def dfs():
	 * if(满足结束条件):
	 * 	res.add
	 *
	 * for选择in选择列表：
	 * 	做选择；
	 * 	dfs；
	 * 	撤销选择；
	 */
	public List<String> letterCombinations(String digits) {
		//base
		if(digits.length()==0) {
			return new ArrayList<String>();
		}
		Map<Integer,String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		dfs(map,digits);
		return res;
    }
	
	List<String> res = new ArrayList<>();
	StringBuilder sb = new StringBuilder();
	public void dfs(Map<Integer,String> map,String digits) {
		if(sb.length()==digits.length()) {
			res.add(sb.toString());
			return ;
		}
		//dfs
		String choices = map.get(Integer.parseInt(digits.substring(sb.length(), sb.length()+1)));
		for(int i=0;i<choices.length();i++) {
			//做选择
			sb.append(choices.charAt(i));
			//dfs
			dfs(map,digits);
			//撤销选择
			sb.delete(sb.length()-1, sb.length());
		}
	}
}

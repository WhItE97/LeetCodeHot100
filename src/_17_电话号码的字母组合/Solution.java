package _17_电话号码的字母组合;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * 题目：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution {
	/**
	 * self思路：【dfs时间上没问题，空间上浪费了！可以直接用String存每位数字对应的字母构成的字符串的！见Solution2】
	 * 典型dfs
	 * 把每个数字对应的字母存进ch[]，然后把数字和ch[]的对应关系存进hashmap，每轮dfs根据数字获取到char[]后对该char[]进行dfs
	 * 
	 * def dfs(选择列表，):【ATT.递归传递的选择列表必须包含了所有数字对应的字母，这样每位在dfs时才能根据自己的数值选择——>选择列表用HashMap存，value为char[]】
	 * if(满足结束条件):
	 * 	res.add
	 *
	 * for选择in选择列表：
	 * 	做选择；
	 * 	dfs；
	 * 	撤销选择；
	 */
	public List<String> letterCombinations(String digits) {
		if(digits.length()==0) {
			return new ArrayList<>();
		}
		char[] chs = digits.toCharArray();
		//把chs全转换为数字
		int[] str = new int[chs.length];
		for(int i=0;i<chs.length;i++) {
			str[i] = chs[i]-'0';
		}
		Map<Integer,char[]> choices = new HashMap<>();
		//1.建立选择列表
		char[] ch2 = new char[] {'a','b','c'};
		choices.put(2,ch2);
		char[] ch3 = new char[] {'d','e','f'};
		choices.put(3,ch3);
		char[] ch4 = new char[] {'g','h','i'};
		choices.put(4,ch4);
		char[] ch5 = new char[] {'j','k','l'};
		choices.put(5,ch5);
		char[] ch6 = new char[] {'m','n','o'};
		choices.put(6,ch6);
		char[] ch7 = new char[] {'p','q','r','s'};
		choices.put(7,ch7);
		char[] ch8 = new char[] {'t','u','v'};
		choices.put(8,ch8);
		char[] ch9 = new char[] {'w','x','y','z'};
		choices.put(9,ch9);
		//进入dfs
		dfs(str,choices);
		return res;
    }
	
	List<String> res = new ArrayList<>();
	StringBuilder route = new StringBuilder();
	//str:原数字串
	//choices:map存放每个数字对应的char[]
	public void dfs(int[] str,Map<Integer,char[]> choices) {
		//1.结束条件
		if(route.length()==str.length) {
			res.add(route.toString());
			return ;
		}
		
		//dfs
		int num = str[route.length()];//num是某位数字，[2,9]
		char[] choice = choices.get(num);//通过当前route长度求出是str中第几位，从而取出对应该数字的char[]选择列表
		for(char ch:choice) {
			//1.做选择
			route.append(ch);
			//2.dfs
			dfs(str,choices);
			//3.撤销选择
			route.delete(route.length()-1, route.length());
		}
	}
}


/**
 * List<Character> ls = new ArrayList<>();
		//2
		ls.add('a');
		ls.add('b');
		ls.add('c');
		choices.put(2, new ArrayList<Character>(ls));
		ls.clear();
		//3
		ls.add('d');
		ls.add('e');
		ls.add('f');
		choices.put(3, new ArrayList<Character>(ls));
		ls.clear();
		//4
		ls.add('g');
		ls.add('h');
		ls.add('i');
		choices.put(4, new ArrayList<Character>(ls));
		ls.clear();
		//5
		ls.add('j');
		ls.add('k');
		ls.add('l');
		choices.put(5, new ArrayList<Character>(ls));
		ls.clear();
		//6
		ls.add('m');
		ls.add('n');
		ls.add('o');
		choices.put(6, new ArrayList<Character>(ls));
		ls.clear();
		//7
		ls.add('p');
		ls.add('q');
		ls.add('r');
		ls.add('s');
		choices.put(7, new ArrayList<Character>(ls));
		ls.clear();
		//8
		ls.add('t');
		ls.add('u');
		ls.add('v');
		choices.put(8, new ArrayList<Character>(ls));
		ls.clear();
		//9
		ls.add('w');
		ls.add('x');
		ls.add('y');
		ls.add('z');
		choices.put(9, new ArrayList<Character>(ls));
		ls.clear();
*/

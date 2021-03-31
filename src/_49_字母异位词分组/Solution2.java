package _49_字母异位词分组;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution2 {
	/**
	 * 官方题解思路1.【没想到啊没想到】【13ms 22%】
	 * 1.抓字母异位词的特点！！！【出现的字母及其出现次数相同！】
	 * 2.何不根据出现的字母及其次数，按a-z（说了全是小写）的顺序，排成一个：【TRICK 1】若满足异位词，则相同的key！
	 * 3.把异位词的通用形式作key，【TRICK 2】value是该种异位词的List！！！
	 * 4.最后把Map的每个键的value转换为对应的子数组即可
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<>();
		//遍历所有字符串
		for(String str:strs) {
			//首先count当前字符串的a-z元素个数
			int[] count = new int[26];
			for(int i=0;i<str.length();i++) {
				count[str.charAt(i)-'a']++;
			}
			//count完后，按a-z的顺序+count中的出现次数
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<26;i++) {
				while(count[i]!=0) {
					sb.append((char)(i+'a'));//【ATT】
					count[i]--;
				}
			}
			//还原出来即为该字母异位词的key，接下来根据该key插入map
			//1.首先要把map中该key的List获取出来，避免覆盖
			List<String> ls = map.getOrDefault(sb.toString(),new ArrayList<String>());//【ATT getOrDefault的用法！如果没get到就返回default】
			//2.把当前str添加进他所归属的key的value中
			ls.add(str);
			//3.把list写回map
			map.put(sb.toString(), ls);
		}
		//map的value就是待求的List
		return new ArrayList<List<String>>(map.values());
    }
}

package _3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class test {

	public static void main(String[] args) {
		String s = "abcccbad";
		System.out.println(new Solution3().lengthOfLongestSubstring(s));
		
		//LinkedHashMap测试：更新已存在的k的v后，其顺序变了否
//		HashMap<Character,Integer> map = new LinkedHashMap<>();
//		map.put('a', 1);
//		map.put('b', 2);
//		map.put('c', 3);
//		map.put('a', 4);
//		for(Entry<Character,Integer> en:map.entrySet()) {
//			System.out.println(en);
//			/**
//			 * a=4
//			 * b=2
//			 * c=3
//			 * 所以更新k,v并不影响LinkedHashMap的顺序！（只和插入顺序有关！）
//			 */
//		}
	}

}

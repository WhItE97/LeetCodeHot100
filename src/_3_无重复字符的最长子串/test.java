package _3_���ظ��ַ�����Ӵ�;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class test {

	public static void main(String[] args) {
		String s = "abcccbad";
		System.out.println(new Solution3().lengthOfLongestSubstring(s));
		
		//LinkedHashMap���ԣ������Ѵ��ڵ�k��v����˳����˷�
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
//			 * ���Ը���k,v����Ӱ��LinkedHashMap��˳�򣡣�ֻ�Ͳ���˳���йأ���
//			 */
//		}
	}

}

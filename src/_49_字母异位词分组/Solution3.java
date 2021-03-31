package _49_字母异位词分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
	/**
	 * 官方题解思路2.【妙啊】【7ms 96%】
	 * 组合拳
	 * 1.String先toCharArray
	 * 2.再Arrays.sort(chararr)
	 * 3.再new String(chararr)
	 * 就能得到该String排好序的一个母串，以该母串为key，同solution2.直接插在map的对应key的List型value中即可！
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<>();
		for(String str:strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			
			//组合拳打完了，开始插入
			List<String> ls = map.getOrDefault(key,new ArrayList<String>());
			ls.add(str);
			map.put(key, ls);
		}
		return new ArrayList<List<String>>(map.values());
    }
}

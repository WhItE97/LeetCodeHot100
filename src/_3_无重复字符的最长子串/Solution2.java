package _3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Solution2 {
	/**
	 * 官方思路self实现：滑动窗口！【10ms 30%..没对，我这样本质上还是有遍历前方子序列的流程..见Solution3】
	 * 1.思想：
	 * 类似队列存储当前子序列->如果遇到重复的，就把队头元素出队；在这个遍历过程中，求队列的最大长度
	 * 2.实现
	 * HashMap：key=字符；value=上次出现的下标
	 * 1.每次检索map，如果已经出现过->for遍历LinkedMap，把出现的位置和其之前的都删掉！
	 * 2.每完成一轮插入后要判断当前map size和max的大小！
	 */
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character,Integer> map = new LinkedHashMap<>();
		int max = 0;
		for(int i=0;i<s.length();i++) {
			char tmp = s.charAt(i);
			//首先判断之前出现过没有
			//1.出现过，则从队头把它及它之前的元素全都出掉
			if(map.containsKey(tmp)) {
				//1.1.先把它之前的队头元素都出掉
				//【CORE.IIMMMPP WRONG.hashmap使用foreach遍历的时候，不能删除当前元素！会丢失下一个元素的指针！所以这里得用iterator遍历】
				Iterator<Character> it = map.keySet().iterator();
				while(it.hasNext()) {
					if(it.next()==tmp) {
						break;
					}
					it.remove();//【CORE.iterator的删除也不能用map的remove！！要用iterator.remove()！！会自动删除本轮的！！】
				}
				//1.2.再出掉自己
				map.remove(tmp);
			}
			//2.没出现过，直接加入map，然后检查队列长度和max的关系
			map.put(tmp, i);
			max = (map.size()>max)?map.size():max;
		}
		return max;
    }
}

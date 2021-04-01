package _3_无重复字符的最长子串;

import java.util.Map;
import java.util.HashMap;

public class Solution3 {
	/**
	 * 力扣powcai题解：【6ms 85%】
	 * 1.思想
	 * 还是类似队列，出掉队头的思想
	 * 2.实现
	 * 【实现上大不同！】
	 * 自己的思路正是因为要遍历前面的子序列找重复元素位置所以慢！
	 * 现在既然是队列思想，那就不该用LinkedHashMap去挨个删！！
	 * (1)之所以用Map实现Queue一个是因为我们要精准的O（1） search到key！【确实较Solution1提升了几ms】
	 * (2)但是这里用map还可以不用完全实现Queue的机制！（map的value我们也要利用上啊！）
	 * (3)【IIIIMMMPPP CORE①】既然map不好挨个删除前面的元素（增加复杂度的POINT），那就别删了！！——>用一个left指针指代开头的下标！！这样就可以把O（N）的删除变为O（1）的定位！
	 * 【IMP CORE②不从表中删除已经出队元素所带来的弊端】如果在表中查到该key，还需要判断该键值对是否已经失效（即已经在left这个队列的头指针以外）！如果已经在队列头指针以外，left将不会修改！只用当本轮的key第一次出现，直接put即可！
	 * (4)同样的；max就可以用（新插入的字符下标-left）去和之前的max取max即可！
	 */
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int left = 0;
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			//遍历所有字符
			char ch = s.charAt(i);
			//1.先检查和map之中是否有重复的
			if(map.containsKey(ch)) {
				//1.1.如果有重复的
				//1.1.1.先把left指针指向重复位置的后一个
				left = Math.max(left,map.get(ch)+1);//【HHHDDD WRONG POINT.这里left不一定指向重复位置的后一个！可能该元素的上一次重复已经被丢弃了（即已经在left之外了<=>已经出队了，就当他不存在，直接put进去）！】
				//1.1.2.再更新该字符在map中的下标
				map.put(ch, i);
			}
			else {
				//1.2.如果没有重复的
				//1.2.1.首先把字符插进map
				map.put(ch,i);
			}
			//2.每个字符插入后，更新max
			max = Math.max(max,i-left+1);
		}
		return max;
    }
}

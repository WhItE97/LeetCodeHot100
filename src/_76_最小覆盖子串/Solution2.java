package _76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
	/**
	 * self思路2：【自己的实现思路太乱了..很多bug，见Solution3】
	 * 双指针【WRONG.这叫滑动窗口！】
	 * 1.用HashMap存t的所有字符及出现次数(map0)
	 * 2.双指针，一开始移动左+右指针，找到第一个合法字符；之后移动右指针，每次移动检查该字符是否在map0中出现，如果出现，则加入map1中
	 * 3.如果map1包含了map0【即map1和map0的keyset相同，但是map1的value可以比map2大】，则记录当前size；然后开始移动左指针
	 * 4.如果左指针移除的元素在map1中，则要对map1的对应元素作value-1操作，如果value==0，还需要将其删除；
	 * 5.【每次移除元素后，如果对map1修改了，都要再检查map1是否还能覆盖map0】一旦不能，则开始移动右指针
	 */
	public String minWindow(String s, String t) {
		Map<Character,Integer> map0 = new HashMap<>();
		for(int i=0;i<t.length();i++) {
			map0.put(t.charAt(i), map0.getOrDefault(t.charAt(i), 0)+1);
		}
		System.out.println("map0.size="+map0.size());
		Map<Character,Integer> map1 = new HashMap<>();
		int left = 0;
		while(!map0.containsKey(s.charAt(left))) {//把left指向第一个合法字符
			left++;
		}
		map1.put(s.charAt(left),1);
		int right = left+1;//开始移动right尝试map1覆盖map0从而实现match
		int start = 0;
		int end = 0;
		int minlen = Integer.MAX_VALUE;
		while(right<s.length()||left<right-t.length()) {
			while(check(map0,map1)) {//1.说明当前left和right子串覆盖了目标子串，所以移动左指针直到不match
				System.out.println("while check");
				//map1每次删除操作后也要检查是否还覆盖，如果覆盖应该尝试修改minlen
				if((right-left)<minlen) {
					start = left;
					end = right;
					minlen = end-start;
					System.out.println("start="+start+",end="+end+",minlen="+minlen);
				}
				if(map1.containsKey(s.charAt(left))) {
					map1.put(s.charAt(left), map1.get(s.charAt(left))-1);
					if(map1.get(s.charAt(left))==0) {
						map1.remove(s.charAt(left));
					}
				}
				left++;
			}
			//2.当前left和right子串未覆盖目标子串，所以移动右指针尝试match
			if(right<s.length()&&map0.containsKey(s.charAt(right))) {//如果是合法字符，则需要add进map1
				map1.put(s.charAt(right), map1.getOrDefault(s.charAt(right),0)+1);
				System.out.println("map1插入char="+s.charAt(right)+",插入后该char在map1中value="+map1.get(s.charAt(right)));
				//每次插入后都要检查是否覆盖了map0
				if(check(map0,map1)) {
					System.out.println("插入后check");
					//成功match，如果本子串长度比min小，则记录子串位置start,end并更新minlen
					if((right-left)<minlen) {
						start = left;
						end = right;
						minlen = end-start;
						System.out.println("start="+start+",end="+end+",minlen="+minlen);
					}
				}
				right++;
			}
			else if(right<s.length()) {
				right++;
			}
		}
		return s.substring(start,end+1);
    }
	
	public boolean check(Map<Character,Integer> map0,Map<Character,Integer> map1) {
		//【IMP ATT:HashMap的迭代方法！】
		//【ATT 2.两个hashmap的覆盖判断：因为map1要覆盖map0，所以迭代遍历map0检查map1是否全有！】
		for(Map.Entry<Character, Integer> a:map0.entrySet()) {
			if(map1.get(a.getKey())==null||map1.get(a.getKey())<a.getValue()) {//说明没覆盖
				return false;
			}
		}
		return true;
	}
}

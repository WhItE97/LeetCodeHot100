package _76_最小覆盖子串;

import java.util.Map;
import java.util.HashMap;
public class Solution3 {
	/**
	 * 官方题解思路：
	 * 总：把t的每个字符及出现次数写进一个hashmap，对s进行滑动窗口，每次s新增char如果是tmap也有的，则将其记入smap，并在插入后对smap进行覆盖检查check；
	 * 一旦check通过，就需要进入尝试缩短子串（即left的元素删除，left++）的寻找更短子串的过程。
	 * 1.设置resL和resR来记录找到的match的最短子串左右下标
	 * 2.resL和resR初始都设置-1，这样没找到的话便于判断，返回""
	 * 3.再使用一对left和right来记录当前走的子串位置，显然结束条件为right==s.length()
	 */
	public String minWindow(String s, String t) {
		int resL = -1;
		int resR = -1;
		int minlen = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		Map<Character,Integer> tmap = new HashMap<>();
		for(int i=0;i<t.length();i++) {
			tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0)+1);
		}
		Map<Character,Integer> smap = new HashMap<>();
		while(right<s.length()) {
			if(tmap.containsKey(s.charAt(right))) {//1.right元素如果是t中一员，则put进smap
				smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right),0)+1);
			}
			//2.smap被put后进行循环check，查找插入该right后尽可能的最短长度
			while(check(smap,tmap)&&left<=right) {
				//check合格，且left<=right；则需要进一步判断当前子串长度和最小子串长的关系
				if((right-left+1)<minlen) {
					resL = left;
					resR =  right;
					minlen = resR-resL+1;
					System.out.println("resL="+resL+",resR="+resR+"满足，且minlen="+minlen);
				}
				//尝试进一步缩短子串长度，缩短的时候要判断当前缩短left位置元素是否count进了smap
				if(smap.containsKey(s.charAt(left))) {
					smap.put(s.charAt(left), smap.get(s.charAt(left))-1);
					if(smap.get(s.charAt(left))==0) {
						smap.remove(s.charAt(left));
					}
				}
				left++;
			}
			//3.当前left到right已经不满足覆盖了,移动右指针
			right++;
		}
		return resL>=0?s.substring(resL,resR+1):"";
    }
	
	//要检查tmap是否被全覆盖，显然smap包含tmap，所以遍历tmap判断是否smap全都包含
	public boolean check(Map<Character,Integer> smap,Map<Character,Integer> tmap) {
		for(Map.Entry<Character, Integer> a:tmap.entrySet()) {
			if(smap.get(a.getKey())==null||smap.get(a.getKey())<a.getValue()) {
				return false;
			}
		}
		return true;
	}
}

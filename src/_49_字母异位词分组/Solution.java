package _49_字母异位词分组;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 题目：
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class Solution {
	/**
	 * self思路：【2396ms 5%...】
	 * 1.某单词的所有字母用一个HashSet装
	 * 2.然后遍历剩下的单词：
	 * （1）如果长度相等，则使用一个int count记录match的字母数（如果count==length，则加入到一个List，并将他从String[]中挪除）
	 * （2）长度不等则跳过
	 * 3.该单词的HashSet遍历完所有String后，寻找String[]中下一个！=null的单词，重复以上步骤
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		List<String> route = new ArrayList<>();
		for(int i=0;i<strs.length;i++) {
			System.out.println("本轮的母单词="+strs[i]);
			//遍历所有单词，给每一个单词进行亲属匹配的机会
			//注意要判断：该单词如果已经被某个亲属收走了，就会设置为null
			if(strs[i]==null) {
				continue;
			}
			//还要把本轮的母单词先压进route
			route.add(strs[i]);
			HashMap<Character,Integer> first = new HashMap<>();
			for(int j=0;j<strs[i].length();j++) {
				first.put(strs[i].charAt(j),first.getOrDefault(strs[i].charAt(j),0)+1);//把本轮母单词的所有字符add进map,并且记录每个字母的出现频率
			}
			//进入本轮母单词对余下单词的判亲遍历
			for(int k=i+1;k<strs.length;k++) {
				System.out.println("母单词="+strs[i]+",本轮进行match的子单词="+strs[k]);
				//首先判断和母单词长度是否相等
				if(strs[k]==null||strs[i].length()!=strs[k].length()) {
					continue;//长度不相等都不用再继续比较了
				}
				//如果长度相等，再用HashMap记录每个单词的出现次数。对之后的每一个新来单词copy该map，某个字母匹配就出现次数--，次数=0就从copy map中删除，最终根据copy map size是否==0来判断是否完全match
				//【针对重复字母，count必须有：重复字母的重复次数相同，所以我想拷贝一个母单词的map，对value进行--来判断，减到0就从map中删除，最后根据map是否为空来判断是否完全match】
				HashMap<Character,Integer> copy = new HashMap<>(first);
				//开始本轮的match
				for(int m=0;m<strs[i].length();m++) {
					if(copy.get(strs[k].charAt(m))==null) {//一旦遇到一个母单词没有出现过的字母，立即跳出
						break;
					}
					else {
						copy.put(strs[k].charAt(m), copy.get(strs[k].charAt(m))-1);
						if(copy.get(strs[k].charAt(m))==0) {
							copy.remove(strs[k].charAt(m));
						}
					}
				}
				//对一个单词完整一轮match后，查看copy的size
				if(copy.size()==0) {
					//说明完全match，可以添加进route
					route.add(strs[k]);
					//并且要把该位置的String置为null！
					strs[k] = null;
				}
			}
			//一个母单词的遍历结束，把route add进res后清空route
			res.add(new ArrayList<String>(route));
			route.clear();
		}
		return res;
    }
}

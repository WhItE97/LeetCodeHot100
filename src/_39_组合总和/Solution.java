package _39_组合总和;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * 题目：
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：所有数字（包括 target）都是正整数。解集不能包含重复的组合。 
 */
public class Solution {
	/**
	 * self思路：【31ms 5%...】
	 * 1.先sort candidates
	 * 2.针对target，从大到小dfs尝试candidates中的值
	 * 
	 * 1.dfs结束条件:target==0
	 * 2.dfs可选项：小于target的所有元素（ATT.选过之后还能再选）
	 * 
	 * 【HDP】如(1,2,3)——>6的(1,1,1,1,2)和(1,1,1,2,1)的去重
	 * 【self】把满足结束条件的route[]排序后，拼接成String扔进HashSet，如果HashSet中已经存在，说明无效，则不添加进res
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		//【WRONG POINT】别忘了一开始要先队candidates排序，方便后面剪枝
		Arrays.sort(candidates);
		dfs(candidates,target);
		return res;
    }
	
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> route = new ArrayList<>();
	Set<String> check = new HashSet<>();
	public void dfs(int[] candidates,int target) {
		//1.结束条件
		if(target==0) {
			//【去重！】
			StringBuilder sb = new StringBuilder();
			List<Integer> tmp = new ArrayList<>(route);
			Collections.sort(tmp);
			for(int i=0;i<tmp.size();i++) {
				sb.append(tmp.get(i));
			}
			if(!check.contains(sb.toString())) {
				check.add(sb.toString());
				res.add(new ArrayList<Integer>(route));
			}
			return ;
		}
		//2.dfs
		for(int i=0;i<candidates.length;i++) {
			//ATT.check剪枝：如果该元素已经大于target了，剩下的全都没有必要再尝试了
			if(candidates[i]>target) {
				break;
			}
			//1.做选择
			route.add(candidates[i]);
			//2.dfs
			dfs(candidates,target-candidates[i]);
			//3.撤销选择
			route.remove(route.size()-1);
		}
	}
}

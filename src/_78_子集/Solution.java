package _78_子集;

import java.util.List;
import java.util.ArrayList;
/**
 * 题目：
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 注意：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Solution {
	/**
	 * self思路：
	 * 根据数组长度，分0~nums.length-1进行dfs
	 */
	public List<List<Integer>> subsets(int[] nums) {
		//遍历所有可能的数组size
		for(int i=0;i<=nums.length;i++) {//【ATT POINT.别忘了==nums.length也是可以的！】
			dfs(nums,i,0);
		}
		return res;
    }
	
	
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> route = new ArrayList<>();
	//size:本轮dfs的目的数组长度
	//k:本轮选取元素的起始下标
	public void dfs(int[] nums,int size,int k) {
		//1.结束条件
		if(route.size()==size) {
			//因为用了k标志起始位置，所以一定不会重复，不用再去重
			res.add(new ArrayList<Integer>(route));
			return;
		}
		//2.dfs
		for(int i=k;i<nums.length;i++) {
			//1.做选择
			route.add(nums[i]);
			//2.dfs
			dfs(nums,size,i+1);//【ATT POINT.这里递归是i+1而不是k+1！】
			//3.取消选择
			route.remove(route.size()-1);
		}
	}
}

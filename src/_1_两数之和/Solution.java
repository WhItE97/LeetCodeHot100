package _1_两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class Solution {
	/**
	 * self思路：【0ms 100%】
	 * 注意到1.数组无序2.要返回的是下标
	 * 所以不能给数组排序后双指针search
	 * change思路:
	 * HashMap->每遍历一个数，查询map中是否存在和他和等于target的，如果有则返回两个的下标；else则把当前(数值，下标)的kv对存入map
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			//首先判断当前map中有没有和本轮元素相加满足target的
			if(map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			else {//如果没有，则把本轮的元素放进map
				map.put(nums[i],i);
			}
		}
		return new int[] {};
    }
}

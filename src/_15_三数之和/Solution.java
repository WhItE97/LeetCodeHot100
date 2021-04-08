package _15_三数之和;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * 题目：
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class Solution {
	/**
	 * self思路：
	 * 只能想到三层循环然后想办法去重...【O(N^3)太垃圾了..】
	 * 官方题解self实现：【36ms 17%】
	 * 【KP①】求的又不是下标，所以先sort，保证a<b<c！这样起码可以省略掉三层循环的去重阶段！
	 * 【KP②】a+b+c——>1.a用来枚举遍历所有节点做开头2.b和c双指针，b指向紧跟a的第一个！=a的值，c指向从后往前的第一个！=a的值，b、c逐渐靠近——>O(N)
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums.length<3) {
			return res;
		}
		Arrays.sort(nums);
		int lasta = nums[0];
		for(int a=0;a<nums.length-2;a++) {
			//【WRONG POINT ②】a也需要挪到和上一轮不相同的元素位置上！不然依旧会重复！
			if(a!=0) {
				while(a<nums.length-2&&nums[a]==lasta) {
					a++;
				}
			}
			if(a>=nums.length-2) {
				break;
			}
			lasta = nums[a];
			int b = a+1;
			int c = nums.length-1;
			while(b<c) {
				int sum = nums[a]+nums[b]+nums[c];
				//1.先判断本轮元素是否构成合理三元组
				if(sum==0) {
					List<Integer> route = new ArrayList<>();
					route.add(nums[a]);
					route.add(nums[b]);
					route.add(nums[c]);
					res.add(new ArrayList<>(route));
					//【WRONG POINT①】判断合理后，要挪动其中一个指针，不然会死循环..
					int lastb = nums[b];
					while(b<c&&nums[b]==lastb) {
						b++;
					}
				}
				//2.如果和<0，说明b指的数还不够大，右移b到一个不等于上一轮nums[b]的位置
				else if(sum<0) {
					int lastb = nums[b];
					while(b<c&&nums[b]==lastb) {
						b++;
					}
				}
				//3.如果和>0，说明c指的太大，左移c到一个不等于上一轮nums[c]的位置
				else {
					int lastc = nums[c];
					while(c>b&&nums[c]==lastc) {
						c--;
					}
				}
			}
		}
		return res;
    }
}

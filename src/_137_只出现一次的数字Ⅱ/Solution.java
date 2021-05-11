package _137_只出现一次的数字Ⅱ;

/**
 * 题目：
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class Solution {
	/**
	 * self思路：
	 * count二进制位为1的数量，取余3后剩下的就是只出现1次的数
	 * 【HDP负数的情况...&&O(1)的空间复杂度实现...】
	 * 
	 * 官方题解：
	 * 1.既然不能用辅助空间，那就不能对每一个num进行count所有位后再取余！
	 * so：双层for的外层for（i是32位int的从左向右的第i位） 内层for（int num:nums）
	 * 2.因为O(1)空间，所以一旦该从左往右的第i位count完成后，就计算取余，【CORE 2】并将其按照第i位的“阶”（即将该“1”左移i位，或（这里<=>加）到res）
	 */
	public int singleNumber(int[] nums) {
		int res = 0;
		for(int i=0;i<32;i++) {//1.外层for表示32位int的从低向高的第i位
			int count = 0;//count这一轮i位置上的1出现次数
			for(int num:nums) {//2.内层for遍历所有num，count其从低向高的第i位是否=1
				if(((num>>i)&1)!=0) {
					count++;
				}
			}
			//将本轮的i位置上的元素通过“|”,加到res中
			if(count%3!=0) {
				res |= (1<<i);
			}
		}
		return res;
    }
}

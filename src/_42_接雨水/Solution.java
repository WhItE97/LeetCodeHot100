package _42_接雨水;

/**
 * 题目：
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Solution {
	/**
	 * 官方题解：
	 * 【HDP BASE】下标i处能收集的雨水量=i两侧(不止相邻的两个位置！)最大高度的最小值-height[i]
	 * self实现：【O(N^2)...】
	 * 对每个i，分别向左和向右2个方向search得到2个最大高度，然后取min-height[i]
	 */
	public int trap(int[] height) {
		int res = 0;
		for(int i=0;i<height.length;i++) {
			int leftmax = 0;
			int rightmax = 0;
			//1.search left max
			for(int a=i-1;a>=0;a--) {
				leftmax = Math.max(height[a], leftmax);
			}
			//2.search right max
			for(int b=i+1;b<height.length;b++) {
				rightmax = Math.max(height[b], rightmax);
			}
			//3.求i处接水体积
			int v = Math.min(leftmax, rightmax)-height[i];
			res += v>0?v:0;
		}
		return res;
    }
}

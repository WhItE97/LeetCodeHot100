package _11_盛最多水的容器;

/**
 * 题目：
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器。
 */
public class Solution {
	/**
	 * self思路：
	 * 就是求最大矩形面积——>dp..没想到怎么写转移方程
	 * 只能想到O(N^2)的遍历..
	 * Krahets思路：（绝了..还是要安心画图分析规律啊）
	 * 【CORE 1】自己的困难点在于：矩形的长宽都在变化，只能想到穷举——>既然长宽都变，并且没法固定其中一个，那就【让其中一个的变化变成单调】的啊！
	 * 【双指针】
	 * 1.两个指针分别指向最左和最右挡板，把此时的面积写进res，然后开始把两个挡板往中间靠！（这样底边就单调递减！）
	 * 2.【CORE 2】固定下一边后，怎么移动两个挡板以获得最大值？——>移动短的那一根，则底边--但是高可能++，所以面积【存在变大的可能性！】
	 * 3.而如果移动长的那一根，则面积必减小！
	 */
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length-1;
		int size = (right-left)*Math.min(height[left], height[right]);
		while(left<right) {
			if(height[left]<height[right]) {
				left++;
				int tmp = (right-left)*Math.min(height[left], height[right]);
				size = Math.max(size, tmp);
			}
			else {
				right--;
				int tmp = (right-left)*Math.min(height[left], height[right]);
				size = Math.max(size, tmp);
			}
		}
		return size;
    }
}

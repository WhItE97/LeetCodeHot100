package _84_柱状图中最大的矩形;

/**
 * 题目：
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Solution {
	/**
	 * self思路：【O(NlogN) 95/96超时...(暴力的O(N^2)93/96超时)】
	 * 分治
	 * 1.第一轮先找到全局最小值点，计算一个底边拉满的矩形面积
	 * 2.根据该最小值点划分成2段（不包括最小值点）再分别求最小值点，然后求底边拉满的矩形面积，和max做比较
	 * 3.递归直至底边=1
	 */
	public int largestRectangleArea(int[] heights) {
		split(heights,0,heights.length-1);
		return maxsize;
    }
	
	int maxsize = -1;
	public void split(int[] heights,int start,int end) {
		if(start==end) {
			maxsize = Math.max(maxsize, heights[start]);
			System.out.println("maxsize="+maxsize);
			return ;
		}
		else if(start<end) {
			int min = Integer.MAX_VALUE;
			int minindex = -1;
			for(int i=start;i<=end;i++) {
				if(heights[i]<min) {
					min = heights[i];
					minindex = i;
				}
			}
			maxsize = Math.max(maxsize, min*(end-start+1));
			System.out.println("maxsize="+maxsize);
			split(heights,start,minindex-1);
			split(heights,minindex+1,end);
		}
		else {
			return ;
		}
	}
}

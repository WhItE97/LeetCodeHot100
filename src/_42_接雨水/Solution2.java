package _42_接雨水;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * self思路2：【O(N)3ms】
	 * 因为i每移动一位，leftmax就可能变化，所以leftmax用于实时存储左边最大值，rightmax因为i每移动一位就可能变化，所以需要通过一个单调栈来实现
	 * 1.先O(N)从右到左以单调栈的形式存rightmax
	 * 2.再i从0开始遍历（O(N)）
	 */
	public int trap(int[] height) {
		Deque<Integer> rightmax = new LinkedList<>();
		//1.O(N)把rightmax存入单调栈
		rightmax.push(0);
		for(int i=height.length-1;i>0;i--) {//【不用把i==0的压进来！因为i从0开始，其rightmax从1开始！】
			if(height[i]<rightmax.peek()) {
				rightmax.push(rightmax.peek());
			}
			else {
				rightmax.push(height[i]);
			}
		}
		//2.O(N)求雨水体积
		int res = 0;
		int leftmax = 0;
		for(int i=0;i<height.length;i++) {
			leftmax = (i>0)?Math.max(leftmax, height[i-1]):0;
			int rightmaxx = rightmax.pop();
			int v = Math.min(leftmax, rightmaxx)-height[i];
			res += v>0?v:0;
		}
		return res;
    }
}

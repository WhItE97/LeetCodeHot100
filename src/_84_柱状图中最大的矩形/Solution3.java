package _84_柱状图中最大的矩形;

import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {
	/**
	 * O(N)官方题解
	 * 【base思路：对每个位置的height，求出以该位置height为高的矩形的最大面积】
	 * 做法：
	 * 【CORE.什么时候能确定该位置height为高的矩形最大面积？——>其左边下标i的height严格小于他，右边下标j的height严格小于他，则其面积可以确定为(j-i-1)*height】
	 * 【so：每次计算下标i位置的最大面积都是在i+1的height严格小于i的height的时候发生的！如果i-1的height<i的height而>i+1的height，说明i-1的面积反而后于i的面积求解
	 * ——>后进先出！——>栈！】
	 */
	public int largestRectangleArea(int[] heights) {
		Deque<Integer> stack = new LinkedList<>();
		int maxsize = -1;
		for(int i=0;i<heights.length;i++) {
			//【CORE POINT】新插入元素之前，先要判断他是否比栈顶小！1.是的话就可以pop栈顶元素，计算其对应height的最大面积了2.比栈顶大【或者栈为空！】则直接压栈
			while(!stack.isEmpty()&&heights[i]<heights[stack.peek()]) {
				//栈非空且新来的元素比栈顶元素对应的height小，可以计算栈顶元素对应height的面积
				int index = stack.pop();//获取栈顶元素
				//计算该height对应maxsize还需要分情况：1.左边没有元素2.左边还有比他小的元素
				if(stack.isEmpty()) {//1.左边没有元素
					maxsize = Math.max(maxsize, i*heights[index]);
				}
				else {//2.左边还有比他小的元素
					maxsize = Math.max(maxsize, (i-stack.peek()-1)*heights[index]);
				}
			}
			//栈空or新来元素的height>=栈顶元素对应height，直接push
			stack.push(i);
		}
		
		//可能栈还没空！
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			//右边的必定比自己大or数组尾巴，所以底边右端点拉倒heights.lenght-1即可；主要是左端点
			if(stack.isEmpty()) {
				//左端点也可以拉满
				maxsize = Math.max(maxsize, heights[tmp]*heights.length);
			}
			else {
				maxsize = Math.max(maxsize, heights[tmp]*(heights.length-1-stack.peek()));
			}
		}
		return maxsize;
    }
}

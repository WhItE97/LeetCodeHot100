package _84_柱状图中最大的矩形;

import java.util.Deque;
import java.util.LinkedList;
public class Solution2 {
	/**
	 * O(N)官方题解【self实现，写的太乱了，在第一个for里的判断逻辑不好，简化见Solution3】
	 * 【base思路：对每个位置的height，求出该位置以height为高的矩形的最大面积】
	 * 做法：
	 * 【什么时候能求出该位置height为高的矩形最大面积？——>其左边下标i的height严格小于他，右边下标j的height严格小于他，则其面积可以确定为(j-i-1)*height】
	 * 【so：每次计算下标i位置的最大面积都是在i+1的height严格小于i的height的时候发生的！如果i-1的height<i的height而>i+1的height，说明i-1的面积反而后于i的面积求解
	 * ——>后进先出！——>栈！】
	 */
	public int largestRectangleArea(int[] heights) {
		Deque<Integer> stack = new LinkedList<>();
		int maxsize = -1;
		for(int i=0;i<heights.length;i++) {
			if(stack.isEmpty()) {
				stack.push(i);
			}
			else {
				while(!stack.isEmpty()) {
					//新插入的元素后要去和栈顶比较，如果比栈顶小，则说明栈顶元素对应的height的矩形面积可以确定了！
					if(heights[i]<heights[stack.peek()]) {
						int index = stack.pop();
						int height = heights[index];//获取到本轮的height
						//然后确定底边长，这时要分类讨论：1.栈空，说明他就是最低的，左边能一路延伸到下标0
						if(stack.isEmpty()) {
							maxsize = Math.max(maxsize, height*i);
						}
						else {//2.栈非空
							int left = stack.peek();
							maxsize = Math.max(maxsize, height*(i-left-1));
						}
						//这里还不能push，还要继续和新栈顶比较！除非没有新栈顶了！
//						System.out.println("here push "+i);
//						stack.push(i);
						if(stack.isEmpty()) {
							stack.push(i);
							break;
						}
					}
					else{
						stack.push(i);
						break;
					}
				}
			}
		}
		//所有元素都插完后，栈可能还有元素，所以还要继续计算
		while(!stack.isEmpty()) {
			//1.因为其右边已经没有元素，所以右边必定可以延伸到最右端；而左端则需要判断栈中还有没有元素！如果还有，则必比他小，不然把他压入栈的时候左边的元素就该出栈求面积了
			int tmp = stack.pop();
			if(stack.isEmpty()) {//1.1.如果左边也没有元素了，说明他就是最小的，左边也可以延伸到尽头
				maxsize = Math.max(maxsize, heights[tmp]*heights.length);
			}
			else {//1.2.左边还有元素
				maxsize = Math.max(maxsize, heights[tmp]*(heights.length-stack.peek()-1));
			}
		}
		
		return maxsize;
    }
}

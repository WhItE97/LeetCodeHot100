package _85_最大矩形;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * 官方思路2：【O(MN)】
	 * base1的基础上，不难发现——>我们对每一个'1'元素，以其为右下角求最大全1矩形的计算，和84.计算柱状图中最大矩形同理！
	 * so：只需要1.第一轮求出sup矩形（O(MN)）2.对每一列，进行84.的O(M)的求最大矩形面积（O(MN)）即可！
	 */
	public int maximalRectangle(char[][] matrix) {
		//base
		if(matrix.length==0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		//1.建立sup矩阵
		int[][] sup = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(j==0) {
					sup[i][j] = (matrix[i][j]=='1')?1:0;
				}
				else {
					sup[i][j] = (matrix[i][j]=='1')?(sup[i][j-1]+1):0;
				}
			}
		}
		//2.对sup矩阵的每一列，单独拿出来，做84.中的O(M)求max矩形面积的计算
		int max = Integer.MIN_VALUE;
		for(int i=0;i<cols;i++) {
			max = Math.max(max, colsmax(sup,i));
		}
		return max;
    }
	//对sup矩阵，O(M)求下标为k列的最大矩形面积
	//【思想：单调栈（每插入一个元素【的下标！（imp必须保存下标，涉及到左右相对位置！）】前，先要检查他是否严格小于栈顶，如果是则能确定以栈顶元素的height向两边延申的最大矩形面积）】
	//特殊情况：
	//1.如果栈空，则直接插入
	public int colsmax(int[][] sup,int k) {
		Deque<Integer> stack = new LinkedList<>();
		int maxsize = Integer.MIN_VALUE;
		for(int i=0;i<sup.length;i++) {
			while(!stack.isEmpty()&&sup[i][k]<sup[stack.peek()][k]) {//需要将栈顶出队计算面积
				int preindex = stack.pop();
				//求preindex对应height的最大面积又要分情况，其右边界肯定是到了i，但是左边界取决于栈顶元素的下标！
				if(stack.isEmpty()) {//1.栈顶为空，说明他能延伸到左边界
					maxsize = Math.max(maxsize, sup[preindex][k]*i);
				}
				else {
					maxsize = Math.max(maxsize, sup[preindex][k]*(i-stack.peek()-1));
				}
			}
			stack.push(i);
		}
		
		//stack可能还没出完，还要继续，但这些的右边界已经可以拉满到最右边界了
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			//同样的，左边界还是要讨论
			if(stack.isEmpty()) {
				//左边界也可以拉满
				maxsize = Math.max(maxsize, sup[tmp][k]*sup.length);
			}
			else {
				maxsize = Math.max(maxsize, sup[tmp][k]*(sup.length-stack.peek()-1));
			}
		}
		return maxsize;
	}
}

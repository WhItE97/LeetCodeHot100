package _85_最大矩形;

/**
 * 题目：
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 0 <= row, cols <= 200
 */
public class Solution {
	/**
	 * self思路：
	 * 只能想到遍历每个1做起点，暴力求每个起点的max...
	 * 这样暴力枚举所有可能矩形必超时，下面先介绍优化思路1
	 * 
	 * 官方思路1：【时间O(M^2*N) 空间O(MN)时间复杂度过高，见Solution2】
	 * 【CORE POINT在于想到：创建辅助矩阵记录每个点左边的连续1个数，从而转换为对矩阵的每列进行84题的算法。】
	 * 使用一个二维辅助矩阵sup记录每个(i,j)位置的元素左边的连续1的个数(包括自己本身)；如果自己是0，则记录0。
	 * 遍历每一个非0节点，通过辅助矩阵求出以该节点为【全1矩形右下角节点】的最大矩形面积
	 * 【base】对(i,j)有：
	 * 1.初始width = sup[i][j];height = 1（即自己这一行，以自己结尾的连续1的矩形）
	 * 2.求的是(i,j)为右下角元素，so：继续往上求
	 * 3.width = min(sup[i][j],sup[i][j-1]);height++
	 * 4.以此类推...直到sup[i][k]为0 or 越界为止，得到一个max
	 * 5.对每个1节点重复1~4，得到一个全局max
	 */
	public int maximalRectangle(char[][] matrix) {
		//base
		if(matrix.length==0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] sup = new int[rows][cols];
		//1.初始化sup矩阵
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(j==0) {
					sup[i][j] = (matrix[i][j]=='1')?1:0;
				}
				else {
					sup[i][j] = (matrix[i][j]=='1')?1+sup[i][j-1]:0;
				}
			}
		}
		//2.遍历每个元素，就以该元素为全1矩形右下角元素的最大全1矩形面积
		int max = 0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				//只计算为1的，才有意义
				if(matrix[i][j]=='1') {
					//从[i][j]到[i][k]计算max
					int min = Integer.MAX_VALUE;
					for(int m=0;m<=i;m++) {
						//面积计算=min(sup[i][j]~sup[i-m][j])*(m+1)
						//1.计算min
						min = Math.min(min, sup[i-m][j]);
						max = Math.max(max, min*(m+1));
					}
				}
			}
		}
		return max;
    }
}

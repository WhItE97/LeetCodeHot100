package _48_旋转图像;

/**
 * 题目：
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class Solution {
	/**
	 * self思路：【O(N^2)时间+O(N^2)空间】
	 * (m,n)变(n,-m):-表示倒序
	 * 设置一个boolean[][]矩阵判断当前元素是否已经旋转，然后遍历数组——>O(N^2)时间+O(N^2)空间
	 */
	public void rotate(int[][] matrix) {
		boolean[][] visited = new boolean[matrix.length][matrix.length];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				if(!visited[i][j]) {
					int tmp = matrix[i][j];
					matrix[i][j] = matrix[j][matrix.length-1-i];
					matrix[j][matrix.length-1-i] = tmp;
					visited[i][j] = true;
					visited[j][matrix.length-1-i] = true;
				}
			}
		}
		return;
    }
}

package _48_��תͼ��;

/**
 * ��Ŀ��
 * ����һ�� n �� n �Ķ�ά���� matrix ��ʾһ��ͼ�����㽫ͼ��˳ʱ����ת 90 �ȡ�
 * ������� ԭ�� ��תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫ ʹ����һ����������תͼ��
 */
public class Solution {
	/**
	 * self˼·����O(N^2)ʱ��+O(N^2)�ռ䡿
	 * (m,n)��(n,-m):-��ʾ����
	 * ����һ��boolean[][]�����жϵ�ǰԪ���Ƿ��Ѿ���ת��Ȼ��������顪��>O(N^2)ʱ��+O(N^2)�ռ�
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

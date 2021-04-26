package _85_������;

/**
 * ��Ŀ��
 * ����һ�������� 0 �� 1 ����СΪ rows x cols �Ķ�ά�����ƾ����ҳ�ֻ���� 1 �������Σ��������������
 * 0 <= row, cols <= 200
 */
public class Solution {
	/**
	 * self˼·��
	 * ֻ���뵽����ÿ��1����㣬������ÿ������max...
	 * ��������ö�����п��ܾ��αس�ʱ�������Ƚ����Ż�˼·1
	 * 
	 * �ٷ�˼·1����ʱ��O(M^2*N) �ռ�O(MN)ʱ�临�Ӷȹ��ߣ���Solution2��
	 * ��CORE POINT�����뵽���������������¼ÿ������ߵ�����1�������Ӷ�ת��Ϊ�Ծ����ÿ�н���84����㷨����
	 * ʹ��һ����ά��������sup��¼ÿ��(i,j)λ�õ�Ԫ����ߵ�����1�ĸ���(�����Լ�����)������Լ���0�����¼0��
	 * ����ÿһ����0�ڵ㣬ͨ��������������Ըýڵ�Ϊ��ȫ1�������½ǽڵ㡿�����������
	 * ��base����(i,j)�У�
	 * 1.��ʼwidth = sup[i][j];height = 1�����Լ���һ�У����Լ���β������1�ľ��Σ�
	 * 2.�����(i,j)Ϊ���½�Ԫ�أ�so������������
	 * 3.width = min(sup[i][j],sup[i][j-1]);height++
	 * 4.�Դ�����...ֱ��sup[i][k]Ϊ0 or Խ��Ϊֹ���õ�һ��max
	 * 5.��ÿ��1�ڵ��ظ�1~4���õ�һ��ȫ��max
	 */
	public int maximalRectangle(char[][] matrix) {
		//base
		if(matrix.length==0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] sup = new int[rows][cols];
		//1.��ʼ��sup����
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
		//2.����ÿ��Ԫ�أ����Ը�Ԫ��Ϊȫ1�������½�Ԫ�ص����ȫ1�������
		int max = 0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				//ֻ����Ϊ1�ģ���������
				if(matrix[i][j]=='1') {
					//��[i][j]��[i][k]����max
					int min = Integer.MAX_VALUE;
					for(int m=0;m<=i;m++) {
						//�������=min(sup[i][j]~sup[i-m][j])*(m+1)
						//1.����min
						min = Math.min(min, sup[i-m][j]);
						max = Math.max(max, min*(m+1));
					}
				}
			}
		}
		return max;
    }
}

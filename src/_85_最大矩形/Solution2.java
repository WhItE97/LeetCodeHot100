package _85_������;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * �ٷ�˼·2����O(MN)��
	 * base1�Ļ����ϣ����ѷ��֡���>���Ƕ�ÿһ��'1'Ԫ�أ�����Ϊ���½������ȫ1���εļ��㣬��84.������״ͼ��������ͬ��
	 * so��ֻ��Ҫ1.��һ�����sup���Σ�O(MN)��2.��ÿһ�У�����84.��O(M)���������������O(MN)�����ɣ�
	 */
	public int maximalRectangle(char[][] matrix) {
		//base
		if(matrix.length==0) {
			return 0;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		//1.����sup����
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
		//2.��sup�����ÿһ�У������ó�������84.�е�O(M)��max��������ļ���
		int max = Integer.MIN_VALUE;
		for(int i=0;i<cols;i++) {
			max = Math.max(max, colsmax(sup,i));
		}
		return max;
    }
	//��sup����O(M)���±�Ϊk�е����������
	//��˼�룺����ջ��ÿ����һ��Ԫ�ء����±꣡��imp���뱣���±꣬�漰���������λ�ã�����ǰ����Ҫ������Ƿ��ϸ�С��ջ�������������ȷ����ջ��Ԫ�ص�height������������������������
	//���������
	//1.���ջ�գ���ֱ�Ӳ���
	public int colsmax(int[][] sup,int k) {
		Deque<Integer> stack = new LinkedList<>();
		int maxsize = Integer.MIN_VALUE;
		for(int i=0;i<sup.length;i++) {
			while(!stack.isEmpty()&&sup[i][k]<sup[stack.peek()][k]) {//��Ҫ��ջ�����Ӽ������
				int preindex = stack.pop();
				//��preindex��Ӧheight����������Ҫ����������ұ߽�϶��ǵ���i��������߽�ȡ����ջ��Ԫ�ص��±꣡
				if(stack.isEmpty()) {//1.ջ��Ϊ�գ�˵���������쵽��߽�
					maxsize = Math.max(maxsize, sup[preindex][k]*i);
				}
				else {
					maxsize = Math.max(maxsize, sup[preindex][k]*(i-stack.peek()-1));
				}
			}
			stack.push(i);
		}
		
		//stack���ܻ�û���꣬��Ҫ����������Щ���ұ߽��Ѿ��������������ұ߽���
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			//ͬ���ģ���߽绹��Ҫ����
			if(stack.isEmpty()) {
				//��߽�Ҳ��������
				maxsize = Math.max(maxsize, sup[tmp][k]*sup.length);
			}
			else {
				maxsize = Math.max(maxsize, sup[tmp][k]*(sup.length-stack.peek()-1));
			}
		}
		return maxsize;
	}
}

package _84_��״ͼ�����ľ���;

import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {
	/**
	 * O(N)�ٷ����
	 * ��base˼·����ÿ��λ�õ�height������Ը�λ��heightΪ�ߵľ��ε���������
	 * ������
	 * ��CORE.ʲôʱ����ȷ����λ��heightΪ�ߵľ���������������>������±�i��height�ϸ�С�������ұ��±�j��height�ϸ�С�����������������ȷ��Ϊ(j-i-1)*height��
	 * ��so��ÿ�μ����±�iλ�õ�������������i+1��height�ϸ�С��i��height��ʱ�����ģ����i-1��height<i��height��>i+1��height��˵��i-1�������������i��������
	 * ����>����ȳ�������>ջ����
	 */
	public int largestRectangleArea(int[] heights) {
		Deque<Integer> stack = new LinkedList<>();
		int maxsize = -1;
		for(int i=0;i<heights.length;i++) {
			//��CORE POINT���²���Ԫ��֮ǰ����Ҫ�ж����Ƿ��ջ��С��1.�ǵĻ��Ϳ���popջ��Ԫ�أ��������Ӧheight����������2.��ջ���󡾻���ջΪ�գ�����ֱ��ѹջ
			while(!stack.isEmpty()&&heights[i]<heights[stack.peek()]) {
				//ջ�ǿ���������Ԫ�ر�ջ��Ԫ�ض�Ӧ��heightС�����Լ���ջ��Ԫ�ض�Ӧheight�����
				int index = stack.pop();//��ȡջ��Ԫ��
				//�����height��Ӧmaxsize����Ҫ�������1.���û��Ԫ��2.��߻��б���С��Ԫ��
				if(stack.isEmpty()) {//1.���û��Ԫ��
					maxsize = Math.max(maxsize, i*heights[index]);
				}
				else {//2.��߻��б���С��Ԫ��
					maxsize = Math.max(maxsize, (i-stack.peek()-1)*heights[index]);
				}
			}
			//ջ��or����Ԫ�ص�height>=ջ��Ԫ�ض�Ӧheight��ֱ��push
			stack.push(i);
		}
		
		//����ջ��û�գ�
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			//�ұߵıض����Լ���or����β�ͣ����Եױ��Ҷ˵�����heights.lenght-1���ɣ���Ҫ����˵�
			if(stack.isEmpty()) {
				//��˵�Ҳ��������
				maxsize = Math.max(maxsize, heights[tmp]*heights.length);
			}
			else {
				maxsize = Math.max(maxsize, heights[tmp]*(heights.length-1-stack.peek()));
			}
		}
		return maxsize;
    }
}

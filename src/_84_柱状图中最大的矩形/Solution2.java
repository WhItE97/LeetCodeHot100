package _84_��״ͼ�����ľ���;

import java.util.Deque;
import java.util.LinkedList;
public class Solution2 {
	/**
	 * O(N)�ٷ���⡾selfʵ�֣�д��̫���ˣ��ڵ�һ��for����ж��߼����ã��򻯼�Solution3��
	 * ��base˼·����ÿ��λ�õ�height�������λ����heightΪ�ߵľ��ε���������
	 * ������
	 * ��ʲôʱ���������λ��heightΪ�ߵľ���������������>������±�i��height�ϸ�С�������ұ��±�j��height�ϸ�С�����������������ȷ��Ϊ(j-i-1)*height��
	 * ��so��ÿ�μ����±�iλ�õ�������������i+1��height�ϸ�С��i��height��ʱ�����ģ����i-1��height<i��height��>i+1��height��˵��i-1�������������i��������
	 * ����>����ȳ�������>ջ����
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
					//�²����Ԫ�غ�Ҫȥ��ջ���Ƚϣ������ջ��С����˵��ջ��Ԫ�ض�Ӧ��height�ľ����������ȷ���ˣ�
					if(heights[i]<heights[stack.peek()]) {
						int index = stack.pop();
						int height = heights[index];//��ȡ�����ֵ�height
						//Ȼ��ȷ���ױ߳�����ʱҪ�������ۣ�1.ջ�գ�˵����������͵ģ������һ·���쵽�±�0
						if(stack.isEmpty()) {
							maxsize = Math.max(maxsize, height*i);
						}
						else {//2.ջ�ǿ�
							int left = stack.peek();
							maxsize = Math.max(maxsize, height*(i-left-1));
						}
						//���ﻹ����push����Ҫ��������ջ���Ƚϣ�����û����ջ���ˣ�
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
		//����Ԫ�ض������ջ���ܻ���Ԫ�أ����Ի�Ҫ��������
		while(!stack.isEmpty()) {
			//1.��Ϊ���ұ��Ѿ�û��Ԫ�أ������ұ߱ض��������쵽���Ҷˣ����������Ҫ�ж�ջ�л���û��Ԫ�أ�������У���ر���С����Ȼ����ѹ��ջ��ʱ����ߵ�Ԫ�ؾ͸ó�ջ�������
			int tmp = stack.pop();
			if(stack.isEmpty()) {//1.1.������Ҳû��Ԫ���ˣ�˵����������С�ģ����Ҳ�������쵽��ͷ
				maxsize = Math.max(maxsize, heights[tmp]*heights.length);
			}
			else {//1.2.��߻���Ԫ��
				maxsize = Math.max(maxsize, heights[tmp]*(heights.length-stack.peek()-1));
			}
		}
		
		return maxsize;
    }
}

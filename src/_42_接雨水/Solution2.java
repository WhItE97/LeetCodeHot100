package _42_����ˮ;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
	/**
	 * self˼·2����O(N)3ms��
	 * ��Ϊiÿ�ƶ�һλ��leftmax�Ϳ��ܱ仯������leftmax����ʵʱ�洢������ֵ��rightmax��Ϊiÿ�ƶ�һλ�Ϳ��ܱ仯��������Ҫͨ��һ������ջ��ʵ��
	 * 1.��O(N)���ҵ����Ե���ջ����ʽ��rightmax
	 * 2.��i��0��ʼ������O(N)��
	 */
	public int trap(int[] height) {
		Deque<Integer> rightmax = new LinkedList<>();
		//1.O(N)��rightmax���뵥��ջ
		rightmax.push(0);
		for(int i=height.length-1;i>0;i--) {//�����ð�i==0��ѹ��������Ϊi��0��ʼ����rightmax��1��ʼ����
			if(height[i]<rightmax.peek()) {
				rightmax.push(rightmax.peek());
			}
			else {
				rightmax.push(height[i]);
			}
		}
		//2.O(N)����ˮ���
		int res = 0;
		int leftmax = 0;
		for(int i=0;i<height.length;i++) {
			leftmax = (i>0)?Math.max(leftmax, height[i-1]):0;
			int rightmaxx = rightmax.pop();
			int v = Math.min(leftmax, rightmaxx)-height[i];
			res += v>0?v:0;
		}
		return res;
    }
}

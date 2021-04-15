package _42_����ˮ;

public class Solution3 {
	/**
	 * �ٷ�˼·3��
	 * ��O(N)ʱ��+O(1)�ռ�� ˫ָ�롿
	 * ˼·��
	 * ��Ϊ�±�i���ܽӵ�����ˮ��� �� leftmax��rightmax��min����������CORE����leftmax��rightmax����ͨ��left��rightָ���Լ�leftmax��rightmax����ֵ��ά������
	 * ��CORE BASE��
	 * 1.��ʼ��left=0;right=height.length-1;leftmax=0;rightmax=0
	 * 2.���leftmax>=rightmax:˵����ǰ����left>=right����Ϊleft��right��ʼ��ָ���Լ���max��������Դ��һ�˱����ڸ�λ�ã�!
	 * ����right�±��Ӧ����ˮ����Ѿ�����ͨ��rightmax��������res+=rightmaxt-right
	 * 3.���leftmax<rightmax:˵����ǰ����left<right!����left�±��Ӧ����ˮ����Ѿ�����ͨ��leftmax��������res+= leftmax-left
	 * 4.left��right�غϵ�ʱ��ѭ���ͽ�����
	 */
	public int trap(int[] height) {
		int left = 0;
		int right = height.length-1;
		int leftmax = 0;
		int rightmax = 0;
		int res = 0;
		while(left<right) {
			leftmax = Math.max(leftmax, height[left]);
			rightmax = Math.max(height[right], rightmax);
			//1.leftmax>=rightmax:����left>right
			if(leftmax>=rightmax) {
				res += rightmax-height[right];
				right--;
			}
			//2.leftmax<rightmax
			else {
				res += leftmax-height[left];
				left++;
			}
		}
		return res;
    }
}

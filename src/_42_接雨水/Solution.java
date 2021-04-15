package _42_����ˮ;

/**
 * ��Ŀ��
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 */
public class Solution {
	/**
	 * �ٷ���⣺
	 * ��HDP BASE���±�i�����ռ�����ˮ��=i����(��ֹ���ڵ�����λ�ã�)���߶ȵ���Сֵ-height[i]
	 * selfʵ�֣���O(N^2)...��
	 * ��ÿ��i���ֱ����������2������search�õ�2�����߶ȣ�Ȼ��ȡmin-height[i]
	 */
	public int trap(int[] height) {
		int res = 0;
		for(int i=0;i<height.length;i++) {
			int leftmax = 0;
			int rightmax = 0;
			//1.search left max
			for(int a=i-1;a>=0;a--) {
				leftmax = Math.max(height[a], leftmax);
			}
			//2.search right max
			for(int b=i+1;b<height.length;b++) {
				rightmax = Math.max(height[b], rightmax);
			}
			//3.��i����ˮ���
			int v = Math.min(leftmax, rightmax)-height[i];
			res += v>0?v:0;
		}
		return res;
    }
}

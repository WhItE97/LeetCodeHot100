package _121_������Ʊ�����ʱ��;

/**
 * ��Ŀ��
 * ����һ������ prices �����ĵ� i ��Ԫ�� prices[i] ��ʾһ֧������Ʊ�� i ��ļ۸�
 * ��ֻ��ѡ�� ĳһ�� ������ֻ��Ʊ����ѡ���� δ����ĳһ����ͬ������ �����ù�Ʊ�����һ���㷨�����������ܻ�ȡ���������
 * ��������Դ���ʽ����л�ȡ�������������㲻�ܻ�ȡ�κ����󣬷��� 0 ��
 */
public class Solution {
	/**
	 * self˼·����O(N)��
	 * һ�ֱ�����ά��һ��i��ǰ��min��ÿ����price[i]-minȥ��maxȡmax
	 */
	public int maxProfit(int[] prices) {
		int min = prices[0];
		int maxprofit = 0;
		for(int i=1;i<prices.length;i++) {
			maxprofit = Math.max(maxprofit, prices[i]-min);
			min = Math.min(min, prices[i]);
		}
		return maxprofit;
    }
}

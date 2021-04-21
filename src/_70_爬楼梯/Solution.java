package _70_��¥��;

/**
 * ��Ŀ��
 * ������������¥�ݡ���Ҫ n ������ܵ���¥����
 * ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 * ע�⣺���� n ��һ����������
 */
public class Solution {
	/**
	 * self˼·��
	 * dp
	 * 1.dp[i]:i-1��¥�ݵ���������
	 * 2.ת�Ʒ���
	 * dp[i] = dp[i-1]+dp[i-2]
	 */
	public int climbStairs(int n) {
		//��WRONG POINT.������base...��
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++) {
        	dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }
}

package _45_��Ծ��Ϸ��;

/**
 * ��Ŀ��
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * ���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
 * ˵�������������ǿ��Ե�����������һ��λ�á�
 */
public class Solution {
	/**
	 * self˼·��O(N^2)
	 * dp..
	 * 1.dp[i]:�����±�i��������ٲ���
	 * 2.ת�Ʒ���dp[i]=
	 * min{1+dp[i-1]&&nums[i-1]>=1;1+dp[i-2]&&nums[i-2]>=2...}
	 */
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		for(int i=1;i<nums.length;i++) {
			//��ÿһ��λ����������Ծ����
			int min = Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				//���j��i�ɴ�
				if((j+nums[j])>=i) {
					min = Math.min(dp[j]+1, min);
				}
			}
			dp[i] = min;
		}
		return dp[nums.length-1];
    }
}

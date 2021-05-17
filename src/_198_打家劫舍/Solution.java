package _198_��ҽ���;

/**
 * ��Ŀ��
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ����
 * �������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 */
public class Solution {
	/**
	 * self˼·������û�����ת�Ʒ���...��
	 * dp
	 * 1.dp[i]=��ֹ��i�ҵ����͵�Խ��
	 * 2.ת�Ʒ��̡�HDP��
	 * ���ٷ�˼·����i���ˣ�����ѡ�񣺡�͵or��͵������>
	 * (1)͵����=nums[i]+��i-1�Ҳ���͵����ô�ͼ���dp[i-2]
	 * (2)��͵����=dp[i-1]
	 * dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2])
	 */
	public int rob(int[] nums) {
		//base
		if(nums.length==1) {
			return nums[0];
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++) {
			dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]); 
		}
		return dp[nums.length-1];
    }
}

package _53_��������;

/**
 * ��Ŀ��
 * ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
 */
class Solution {
    /**
	 * self˼·����д�Ļ����е���ң���������dp˼��Solution2��
	 * dp
	 * 1.dp[i]:�±�i��Ԫ�ؽ�β�����������������(������β��dp[i]=dp[i-1]+nums[i]>0?(dp[i-1]+nums[i]):0)
	 * 2.ת�Ʒ��̣�
	 * dp[n]=
	 * (1)dp[i-1]+nums[i];							nums[i]>=0;
	 * (2)dp[i-1]+nums[i]>0?(dp[i-1]+nums[i]):0; 	nums[i]<0;
	 */
	public int maxSubArray(int[] nums) {
		//base
		if(nums.length<1) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = Math.max(0,nums[0]);
		int max = nums[0];
		for(int i=1;i<nums.length;i++) {
            max = Math.max(max,nums[i]);
			if(nums[i]>=0) {
				dp[i] = nums[i] + dp[i-1];
			}
			else {
				dp[i] = (nums[i]+dp[i-1])>0?nums[i]+dp[i-1]:0;
			}
            if(dp[i]!=0){
                max = Math.max(max, dp[i]);
            }
		}
		return max;
    }
}

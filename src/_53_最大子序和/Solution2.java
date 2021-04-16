package _53_��������;

public class Solution2 {
	/**
	 * �ٷ�dp����O(N)��
	 * 1.dp[i]:���±�i��β�������������
	 * 2.ת�Ʒ��̣�
	 * ��dp[i] = max(nums[i],dp[i-1]+nums[i])��
	 * 3.�������dp[i]ֻ��dp[i-1]�йأ����Բ���dp�����ǰ���dp�������Խ��пռ���Ż�����
	 */
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int pre = nums[0];
		for(int i=1;i<nums.length;i++) {
			int tmp = Math.max(nums[i], pre+nums[i]);
			pre = tmp;
			max = Math.max(max, tmp);
			System.out.println("i="+i+",tmp="+tmp+",pre="+pre+",max="+max);
		}
		return max;
    }
}

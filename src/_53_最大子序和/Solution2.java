package _53_最大子序和;

public class Solution2 {
	/**
	 * 官方dp：【O(N)】
	 * 1.dp[i]:以下标i结尾的子数组的最大和
	 * 2.转移方程：
	 * 【dp[i] = max(nums[i],dp[i-1]+nums[i])】
	 * 3.又这里的dp[i]只和dp[i-1]有关，所以不用dp数组存前面的dp！【可以进行空间的优化！】
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

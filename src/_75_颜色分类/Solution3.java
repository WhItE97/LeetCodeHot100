package _75_颜色分类;

public class Solution3 {
	/**
	 * 官方思路2.
	 * 【双指针】
	 * p0指向第一个非0位置，p1指向第一个非1位置
	 * 【易错点】
	 * 1.如果nums[i]==0，直接换到p0位置，再把p0++即可
	 * （这里有易错点1.p0++后可能比p1还大了(一开始的时候先出现0)所以如果p0>p1，需要把p1和p0设置在同一起点(因为p0保证了p0前全为0,所以不能被1换走！)）
	 * （易错点2.）把0换到前面，可能换回来的是1(因为1紧跟0)！所以还需要再对换回来的nums[i]进行检查是否==1，如果==1还需要换到p1去！
	 * 2.如果nums[i]==1，就很好办，他影响不到前面的0，所以直接和p1位置交换即可！
	 */
	public void sortColors(int[] nums) {
		int p0 = 0;
		int p1 = 0;
		for(int i=0;i<nums.length;i++) {
			 if(nums[i]==0) {
				 nums[i] = nums[p0];
				 nums[p0] = 0;
				 p0++;
				 if(p0>p1) {
					 p1 = p0;
				 }
			 }
			 if(nums[i]==1) {
				 nums[i] = nums[p1];
				 nums[p1] = 1;
				 p1++;
			 }
		}
    }
}

package _645_1ton缺1个重复1个;

public class Solution2 {
	/**
	 * 思路2.【2ms 90%】
	 * 1.第一个for添加一个长为n的辅助数组，记录每个下标对应元素的出现次数
	 * 2.第二个for求dup和mis
	 */
	public int[] findErrorNums(int[] nums) {
		int[] count = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			count[nums[i]-1]++;
		}
		int dup = -1;
		int mis = -1;
		for(int i=0;i<nums.length;i++) {
			if(count[i]>1) {
				dup = i+1;
			}
			if(count[i]<1) {
				mis = i+1;
			}
		}
		return new int[] {dup,mis};
    }
}

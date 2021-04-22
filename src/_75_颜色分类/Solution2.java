package _75_颜色分类;

public class Solution2 {
	/**
	 * 官方思路1.单指针，两次遍历O(N)【还可以更优化！一次遍历！见Solution3】
	 * 1.第一轮：指针指向第一个非0位，然后遍历数组，一旦找到指针后面的一个元素=0，这指针位置元素交换！然后指针后移一位，继续刚才的遍历。
	 * 2.第二轮：0已经全部在最前面了，所以指针指向0后面的第一个非1位，同上操作
	 */
	public void sortColors(int[] nums) {
		//第一轮，把0全部换到前面来
		int index0 = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				index0 = i;
				break;
			}
		}
		for(int i=index0+1;i<nums.length;i++) {
			if(nums[i]==0) {
				nums[i] = nums[index0];
				nums[index0] = 0;
				index0++;
			}
		}
		//第二轮
		int index1 = index0;
		for(int i=index1;i<nums.length;i++) {
			if(nums[i]!=1) {
				index1 = i;
				break;
			}
		}
		for(int i=index1+1;i<nums.length;i++) {
			if(nums[i]==1) {
				nums[i] = nums[index1];
				nums[index1] = 1;
				index1++;
			}
		}
    }
}

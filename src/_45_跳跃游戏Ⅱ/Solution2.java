package _45_跳跃游戏Ⅱ;

public class Solution2 {
	/**
	 * labuladong【贪心算法O(N)】：
	 * 【CORE】每次在可以跳跃的位置中，选择最有潜力的进行跳跃！
	 * eg：nums=[3,1,2,2,5]在0位置可以跳1,2,3三个下标，显然具有跳的更远的潜力的是下标3！
	 */
	public int jump(int[] nums) {
		int steps = 0;
		int posi = 0;
		while(posi<nums.length-1) {
			//就本轮位置posi选择最有潜力的下一跳
			int max = -1;
			int nextposi = -1;
			for(int i=1;i<=nums[posi];i++) {
				if((posi+i)>=nums.length-1) {//如果下一跳（即posi+i）就已经满足跳到结尾，那么就不需要找有潜力的了
					steps++;
					return steps;
				}
				if((posi+i+nums[posi+i])>max) {
					max = posi+i+nums[posi+i];
					nextposi = posi+i;
				}
			}
			//确定下一跳位置nextposi后，更新当前posi，并对总步数+1
			posi = nextposi;
			steps++;
		}
		return steps;
	}
}

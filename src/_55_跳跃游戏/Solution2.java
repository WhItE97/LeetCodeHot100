package _55_跳跃游戏;

public class Solution2 {
	/**
	 * 代码随想录Carl思路：
	 * 某位置=3，可跳1or2or3步，但是跳几步无所谓！关键在于可跳的覆盖范围！
	 * so，不一定要明确每次具体选择跳几步！一轮遍历，取可跳的最大范围即可！
	 * 贪心：每一步都做出一个局部最优的选择，最终的结果就是全局最优。注意，这是一种特殊性质，其实只有一部分问题拥有这个性质。
	 * 题目可以转换为：能跳到的最远位置是否超过了最后一位！
	 */
	public boolean canJump(int[] nums) {
		int furthest = 0;
		for(int i=0;i<nums.length-1;i++) {//最后一位没必要再求farthest了
			if(furthest<i) {
				//说明当前节点不可达
				break;
			}
			furthest = Math.max(furthest, i+nums[i]);
		}
		return furthest>=nums.length-1;
	}
}

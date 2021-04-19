package _55_跳跃游戏;

/**
 * 题目：
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class Solution {
	/**
	 * self思路1.
	 * dfs(感觉会超时..)
	 * 结束条件：到达下标len-1
	 * 
	 * 官方题解【贪心算法】
	 * 贪心：每一步都做出一个局部最优的选择，最终的结果就是全局最优。注意哦，这是一种特殊性质，其实只有一部分问题拥有这个性质。
	 * 题目可以转换为：要跳到nums.length-1及以后
	 * self实现：
	 * dfs每次尽可能跳最长的，行不通再回退，并比上次少跳一步【WRONG.这样只是优化后的dfs..74/75超时了，见real贪心at Solution2】
	 */
	public boolean canJump(int[] nums) {
		dfs(nums,0);
		return flag;
    }
	boolean flag = false;
	public void dfs(int[] nums,int posi) {
		//结束条件
		if(flag) {
			return ;
		}
		if(posi>=nums.length-1) {
			flag = true;
			return;
		}
		
		for(int i=nums[posi];i>0;i--) {
			dfs(nums,posi+i);
		}
	}
}

package _42_接雨水;

public class Solution3 {
	/**
	 * 官方思路3：
	 * 【O(N)时间+O(1)空间的 双指针】
	 * 思路：
	 * 因为下标i处能接到的雨水体积 由 leftmax和rightmax的min决定，而【CORE】【leftmax和rightmax可以通过left和right指针以及leftmax和rightmax两个值来维护！】
	 * 【CORE BASE】
	 * 1.初始化left=0;right=height.length-1;leftmax=0;rightmax=0
	 * 2.如果leftmax>=rightmax:说明当前必有left>=right（因为left和right初始都指向自己的max，并且相对大的一端保持在该位置）!
	 * 所以right下标对应的雨水体积已经可以通过rightmax定下来：res+=rightmaxt-right
	 * 3.如果leftmax<rightmax:说明当前必有left<right!所以left下标对应的雨水体积已经可以通过leftmax定下来：res+= leftmax-left
	 * 4.left和right重合的时候，循环就结束了
	 */
	public int trap(int[] height) {
		int left = 0;
		int right = height.length-1;
		int leftmax = 0;
		int rightmax = 0;
		int res = 0;
		while(left<right) {
			leftmax = Math.max(leftmax, height[left]);
			rightmax = Math.max(height[right], rightmax);
			//1.leftmax>=rightmax:必有left>right
			if(leftmax>=rightmax) {
				res += rightmax-height[right];
				right--;
			}
			//2.leftmax<rightmax
			else {
				res += leftmax-height[left];
				left++;
			}
		}
		return res;
    }
}

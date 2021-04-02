package _4_寻找2个正序数组的中位数;

/**
 * 题目：
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class Solution {
	/**
	 * self思路：O(m+n)【2ms 不够！这道题的考点在O(log(m+n))的时间复杂度上，见Solution2】
	 * merge以后求len/2处的元素：
	 * 1.如果len为奇数=nums[len/2]
	 * 2.如果len为偶数=(nums[len/2]+nums[len/2 -1])/2
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length+nums2.length];
		//开始merge
		int a = 0;//nums1的指针
		int b = 0;//nums2的指针
		int index = 0;//nums的指针
		while(a<nums1.length&&b<nums2.length) {
			if(nums1[a]<nums2[b]) {
				nums[index] = nums1[a];
				a++;
			}
			else {
				nums[index] = nums2[b];
				b++;
			}
			index++;
		}
		while(a<nums1.length) {
			nums[index] = nums1[a];
			a++;
			index++;
		}
		while(b<nums2.length) {
			nums[index] = nums2[b];
			b++;
			index++;
		}
		//根据数组长度奇偶return中位数
		if((nums.length&1)==0) {//偶数长度
			return (nums[nums.length>>1]+nums[(nums.length>>1)-1])/2.0;
		}
		return nums[nums.length>>1];
    }
}

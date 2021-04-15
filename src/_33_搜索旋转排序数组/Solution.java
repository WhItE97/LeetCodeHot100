package _33_搜索旋转排序数组;

/**
 * 题目：
 * 整数数组nums按升序排列，数组中的值互不相同。
 * 在传递给函数之前，nums在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，
 * 使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）。
 * 例如，[0,1,2,4,5,6,7]在下标3处经旋转后可能变为 [4,5,6,7,0,1,2]。
 * 给你旋转后的数组nums和一个整数target，如果nums中存在这个目标值target则返回它的下标否则返回-1 。
 */
public class Solution {
	/**
	 * self思路1.【O(logN)但是走了2次logN，感觉可以优化为1次，见Solution2】
	 * 两次二分，第一次找到分界点（左右都比自己小(最大值分界点)or左右都比自己大(最小值分界点)）；然后根据target在哪个范围，再进行一次二分查找
	 */
	public int search(int[] nums, int target) {
		int maxindex = binarySearchMax(nums);
		System.out.println("maxindex="+maxindex);
		if(target>=nums[0]&&target<=nums[maxindex]) {
			return binarySearch(nums,0,maxindex,target);
		}
		else if(target<nums[maxindex]) {
			System.out.println("left="+maxindex+",right="+(nums.length-1));
			return binarySearch(nums,maxindex+1,nums.length-1,target);
		}
		else {
			return -1;
		}
    }
	//input：一个递增数组经旋转后的数组
	//output：数组中max元素的下标（即旋转后的分界点）
	public int binarySearchMax(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while(left<right) {
			int mid = (left+right)/2;
			//先考虑边界
			//1.左边界
			if(mid==0) {
				if(nums[mid]>nums[mid+1]) {
					return mid;
				}
				else {
					return mid+1;
				}
			}
			//2.似乎到不了右边界？因为(nums.length-2+nums.length-1)/2<nums.length-1
			//考虑完边界情况，开始查看当前mid元素情况
			if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]) {
				return mid;
			}
			else if(nums[mid]>nums[0]) {
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		return left;
	}
	//input：递增有序数组
	//output：target下标，如果没找到则返回-1
	public int binarySearch(int[] nums,int start,int end,int target) {
		int left = start;
		int right = end;
		while(left<=right) {
			int mid = (left+right)/2;
			if(nums[mid]==target) {
				return mid;
			}
			if(nums[mid]<target) {
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}
		return -1;
	}
}

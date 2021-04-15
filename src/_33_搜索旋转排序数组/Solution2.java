package _33_搜索旋转排序数组;

public class Solution2 {
	/**
	 * 力扣Sweetiee思路：【一轮二分O(logN)】
	 * base：【每次求mid，必会把数组划分为至少一边有序！】
	 * so：
	 * 1.首先根据【mid元素左边有序还是右边有序进行分类】
	 * 【HDP：判断哪边有序的条件】nums[left]<=nums[mid]则左边有序！
	 * 2.【再细分target在有序的范围内还是无序的范围内】，从而确定左右指针的变化
	 */
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			//找到target
			if(nums[mid]==target) {
				return mid;
			}
			//1.根据mid元素左边有序还是右边有序进行分类
			if(nums[mid]>=nums[left]) {//mid左边有序【WRONG POINT.HDP取等吗？:取！因为元素不重复，若相等则证明mid和left重合！所以左边都没元素了，必有序啊！】
				//1.1.判断target在有序范围内还是无序范围内，以便于进行左右指针的变换
				if(target>=nums[left]&&target<nums[mid]) {
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
			else {//mid右边有序
				if(target>nums[mid]&&target<=nums[right]) {
					left = mid+1;
				}
				else {
					right = mid-1;
				}
			}
		}
		return -1;
    }
}

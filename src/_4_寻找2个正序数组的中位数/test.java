package _4_寻找2个正序数组的中位数;

public class test {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,3};
		int[] nums2 = new int[] {2,4};
		System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
	}
}

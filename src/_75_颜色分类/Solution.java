package _75_颜色分类;

/**
 * 题目：
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class Solution {
	/**
	 * self思路：【O(NlogN)；非本题最优解，见Solution2】
	 * 归并排序
	 */
	public void sortColors(int[] nums) {
		mergeSort(nums,0,nums.length-1);
    }
	
	public void mergeSort(int[] nums,int start,int end) {
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(nums,start,mid);
			mergeSort(nums,mid+1,end);
			merge(nums,start,mid,end);
		}
	}
	
	public void merge(int[] nums,int start,int mid,int end) {
		int[] temparr = new int[end-start+1];
		int left = start;
		int right = mid+1;
		int index = 0;
		while(left<=mid&&right<=end) {
			if(nums[left]<nums[right]) {
				temparr[index] = nums[left];
				left++;
			}
			else {
				temparr[index] = nums[right];
				right++;
			}
			index++;
		}
		while(left<=mid) {
			temparr[index] = nums[left];
			left++;
			index++;
		}
		while(right<=end) {
			temparr[index] = nums[right];
			right++;
			index++;
		}
		for(int i=0;i<temparr.length;i++) {
			nums[start+i] = temparr[i];
		}
	}
}

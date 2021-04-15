package _153_寻找旋转排序数组中的最小值;

/**
 * 题目：
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 */
public class Solution {
	/**
	 * 【官方题解】思路：（和自己的思路只有一点细微的差别，但是结果却相去甚远！）
	 * 【base】二分查找
	 * 具体实现：
	 * 每次求mid后，将mid位置的元素与right位置的元素比较：
	 * 1.如果nums[mid]>nums[right]，显然left~mid还是左侧的递增序列，最小值必在mid右边！所以left=mid+1
	 * 2.如果nums[mid]<nums[right]，显然mid元素已经在右侧的递增序列中，并且mid还比right更接近最小值，【但mid也可能就是最小值！】所以right=mid
	 * 3.因为题目说了【元素值不重复】，所以出现nums[mid]==nums[right]必有mid==right，又mid==right必有left==right，所以这里这里指针重合时，已经指向了最小值！
	 * 
	 * self：
	 * 官方题解base：在最小值左侧的数一定全>right位置的数；在最小值右侧的数一定全<right位置的数
	 * 那似乎..我base：在最小值左侧的数一定全>left位置的数；在最小值右侧的数一定全<left位置的数，看起来也没毛病【totally WRONG】
	 * 【IMP PRO之为什么【必须要选right】做比较的base】
	 * ans：
	 * 1.如果选left做比较的base，则【mid比base大并不能保证mid就在左子序列！】如果base已经指到了最小值，mid在他右边，也会有mid>left，但是这时候mid已经不在左子序列了！
	 * 所以通过left做base来判断相对位置，是走不通的！
	 * 2.如果选right做比较的base，则比right大的，一定在左子序列！而比right小的，必定在右子序列，且比right离min更近（当然也可能就是min）！
	 * 【SO.求min一定要选right做base！】
	 */
	public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
        	int mid = (left+right)/2;
        	if(nums[mid]>nums[right]) {//left~mid是升序的，可以抛弃这部分
        		left = mid+1;
        	}
        	else {//mid在右边降序部分，可以抛弃mid的右边
        		right = mid;//【似乎这里有个ATT：这里的right不能排除掉mid，因为mid可能是右半部分的开头！】
        	}
        }
        return nums[left];
    }
}

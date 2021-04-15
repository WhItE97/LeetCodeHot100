package _81_搜索旋转排序数组Ⅱ;

public class Solution {
	public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return true;
            }
            //【不同之处！】
            //【从“旋转不重复的递增数组”变成“旋转可重复的递增数组”——>区别在于可能出现1,0,1,1,1这样的情况，left\mid\right对应元素都相等！】
            //且他们和target不match！所以这时候直接left++,right--即可！
            if(nums[left]==nums[mid]&&nums[mid]==nums[right]){
                left++;
                right--;
                //【ATT：这里++--后要判断left和right是否还符合left<=right!所以continue】
                continue;
            }
            //1.根据mid左边有序还是右边有序来划分
            if(nums[left]<=nums[mid]){//mid左边有序
                if(target>=nums[left]&&target<nums[mid]){//target在左边有序列表中
                    right = mid-1;
                }
                else{//target在右边列表中
                    left = mid+1;
                }
            }
            else{//mid右边有序
                if(target>nums[mid]&&target<=nums[right]){//target在右边有序列表中
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}

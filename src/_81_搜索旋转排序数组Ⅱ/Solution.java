package _81_������ת���������;

public class Solution {
	public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return true;
            }
            //����֮ͬ������
            //���ӡ���ת���ظ��ĵ������顱��ɡ���ת���ظ��ĵ������顱����>�������ڿ��ܳ���1,0,1,1,1�����������left\mid\right��ӦԪ�ض���ȣ���
            //�����Ǻ�target��match��������ʱ��ֱ��left++,right--���ɣ�
            if(nums[left]==nums[mid]&&nums[mid]==nums[right]){
                left++;
                right--;
                //��ATT������++--��Ҫ�ж�left��right�Ƿ񻹷���left<=right!����continue��
                continue;
            }
            //1.����mid����������ұ�����������
            if(nums[left]<=nums[mid]){//mid�������
                if(target>=nums[left]&&target<nums[mid]){//target����������б���
                    right = mid-1;
                }
                else{//target���ұ��б���
                    left = mid+1;
                }
            }
            else{//mid�ұ�����
                if(target>nums[mid]&&target<=nums[right]){//target���ұ������б���
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

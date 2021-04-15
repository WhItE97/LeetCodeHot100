package _33_������ת��������;

public class Solution2 {
	/**
	 * ����Sweetiee˼·����һ�ֶ���O(logN)��
	 * base����ÿ����mid���ػ�����黮��Ϊ����һ�����򣡡�
	 * so��
	 * 1.���ȸ��ݡ�midԪ������������ұ�������з��ࡿ
	 * ��HDP���ж��ı������������nums[left]<=nums[mid]���������
	 * 2.����ϸ��target������ķ�Χ�ڻ�������ķ�Χ�ڡ����Ӷ�ȷ������ָ��ı仯
	 */
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			//�ҵ�target
			if(nums[mid]==target) {
				return mid;
			}
			//1.����midԪ������������ұ�������з���
			if(nums[mid]>=nums[left]) {//mid�������WRONG POINT.HDPȡ����:ȡ����ΪԪ�ز��ظ����������֤��mid��left�غϣ�������߶�ûԪ���ˣ������򰡣���
				//1.1.�ж�target������Χ�ڻ�������Χ�ڣ��Ա��ڽ�������ָ��ı任
				if(target>=nums[left]&&target<nums[mid]) {
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
			else {//mid�ұ�����
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

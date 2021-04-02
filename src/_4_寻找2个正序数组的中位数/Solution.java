package _4_Ѱ��2�������������λ��;

/**
 * ��Ŀ��
 * ����������С�ֱ�Ϊ m �� n �����򣨴�С�������� nums1 �� nums2�������ҳ���������������������� ��λ�� ��
 */
public class Solution {
	/**
	 * self˼·��O(m+n)��2ms �����������Ŀ�����O(log(m+n))��ʱ�临�Ӷ��ϣ���Solution2��
	 * merge�Ժ���len/2����Ԫ�أ�
	 * 1.���lenΪ����=nums[len/2]
	 * 2.���lenΪż��=(nums[len/2]+nums[len/2 -1])/2
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length+nums2.length];
		//��ʼmerge
		int a = 0;//nums1��ָ��
		int b = 0;//nums2��ָ��
		int index = 0;//nums��ָ��
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
		//�������鳤����żreturn��λ��
		if((nums.length&1)==0) {//ż������
			return (nums[nums.length>>1]+nums[(nums.length>>1)-1])/2.0;
		}
		return nums[nums.length>>1];
    }
}

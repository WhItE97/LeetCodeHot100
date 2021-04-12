package _31_��һ������;

public class Solution2 {
	/**
	 * ����Imageslr˼·����1ms 98%��
	 * ��������ͼ��⡿
	 * 1.���۷�����
	 * ϣ���õ�����һ�����бȵ�ǰ������Ҫ��ǰ���һ����С���ͺ����һ���ϴ���swap�����λ���ֱ��Ӷ����ֱ��
	 * ��ATT�����ǻ�ϣ����һ����������������С��so�����ھ����ܿ��ҵĵ�λ����swap�ڽ�һ��������С�ġ���������ǰ��ġ�С�������н���
	 * �۵���ֻ�ǵ�����swap�����ܱ�֤�ǵ�һ����������������С���>����Ҫ��swap�ĸ�λ�Ժ�������������г�����
	 * ��CORE POINT.�Լ�������ֻͨ��213/265��ԭ����������������Ҫ���Ӻ���ǰ���ҵ�����һ��������������ԡ���
	 * ���ҡ�����ֱ��swap���ǡ�����������ֻ��˵������и��͵㡿��һ������̧�ߣ����׾�����swap��������
	 * �������ǻ���Ҫ����swap���ȵ͵�󡿵ġ���С���֡�������Ҫ�ӵ͵�λ��������������պñ��������һ����swap��
	 * 2.�㷨���裺
	 * ��1���Ӻ���ǰ�ҵ���һ�����������left��right
	 * ��2����[right,end]��һ���պô���left�ģ���leftλ�õĽ���swap
	 * ��3����leftλ��֮������鰴����sort
	 */
	public void nextPermutation(int[] nums) {
		int right = nums.length-1;
		int left = right-1;
		//1.�Ӻ���ǰ�ҵ���һ�����������
		while(left>=0&&nums[left]>=nums[right]) {//��WRONG POINT������ԣ����Գ�ƽ�Բ����У��ǵ�ȡ�ȣ�
			left--;
			right--;
		}
		if(left<0) {//˵��û�ҵ�����ԣ��Ѿ���max��ֱ��reverse����
			for(int i=0;i<nums.length/2;i++) {
				int tmp = nums[i];
				nums[i] = nums[nums.length-1-i];
				nums[nums.length-1-i] = tmp;
			}
			return ;//��WRONG POINT��reverse������˽�����
		}
		//2.��left֮���Ԫ�����һ���պô�������
		int targetindex = right;
		for(int i=right;i<nums.length;i++) {
			if(nums[i]>nums[left]&&nums[i]<nums[targetindex]) {
				targetindex = i;
			}
		}
		//Ȼ��swap������λ��
		int tmp = nums[left];
		nums[left] = nums[targetindex];
		nums[targetindex] = tmp;
		//3.��[right,end]���������
		quicksort(nums,right,nums.length-1);
    }
	
	public void quicksort(int[] nums,int start,int end) {
		//��������
		if(start>=end) {
			return;
		}
		int pivot = nums[start];
		int left = start;
		int right = end;
		while(left<right) {
			//�ȴ��ұ���һ����pivotС��
			while(left<right&&nums[right]>=pivot) {
				right--;
			}
			if(left<right) {
				nums[left] = nums[right];
			}
			//�ٴ������һ����pivot���
			while(left<right&&nums[left]<pivot) {
				left++;
			}
			if(left<right) {
				nums[right] = nums[left];
			}
		}
		nums[left] = pivot;
		quicksort(nums,start,left);
		quicksort(nums,left+1,end);
	}
}

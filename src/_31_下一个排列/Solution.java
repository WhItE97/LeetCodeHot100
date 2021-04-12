package _31_��һ������;

/**
 * ��Ŀ��
 * ʵ�ֻ�ȡ ��һ������ �ĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
 * �����������һ����������У��������������г���С�����У����������У���
 * ���� ԭ�� �޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
 */
public class Solution {
	/**
	 * self˼·����WRONG��
	 * �Ӻ���ǰ������leftָ����ߵģ�rightָ���ұߵģ��ҵ���һ��nums[left]<nums[right]�ġ�����..12543����>��Ӧ��13245�������н�����Ȼ��return����
	 * ����ҵ�leftԽ�绹û�ҵ�����˵���Ѿ�����������ֱ�Ӱ����鷴�򼴿ɡ�
	 * 
	 * self����˼·����WRONG 213/265��
	 * 1.�Ӻ���ǰ��������min��¼�ҵ��ĵ�ǰ��Сֵ��minindex��¼���±ꣻ
	 * 2.�ҵ���һ��С�ڸ�minֵ��target��������min������������ȱ�ݣ�ֻA��188/265��û���ǵ�2,3,1�����Ҳ�����1С�ĵ������������Ҫ������min����Ϊ3������һ��search��
	 * ����>�����ǲ�����213/265..������ˣ����и�ϸ��ûע�⵽����������ߵ�����ʱ�򣬲�Ӧ��������ߵ�һ����С�����仹Ӧ���и������������ý�С���������ң�������Solution2��
	 * 3.�����Ҫ��[targetindex+1,minindex]������С������������
	 */
	public void nextPermutation(int[] nums) {
		//base
		if(nums.length<2) {
			return;
		}
		nextSearch(nums,nums.length-1);
    }
	//minstart���ڼ�¼���ִ��ĸ�λ�ÿ�ʼ��min����Ӧ��2,3,1�������
	public void nextSearch(int[] nums,int minstart) {
		int minindex = minstart;
		int min = nums[minindex];
		int targetindex = -1;
		for(int i=minindex-1;i>=0;i--) {
			//�Ӻ���ǰ�ҵ���һ����minС��
			if(nums[i]<min) {
				//�ҵ����Ƚ�������
				int tmp = nums[i];
				nums[i] = nums[minindex];
				nums[minindex] = tmp;
				//�ټ�¼����target���±�
				targetindex = i;
				break;
			}
		}
		//���û�ҵ���Ҫ���������WRONG��˵���Ѿ���max��ֱ��reverse���顿
		if(targetindex==-1) {
			if(minstart>1) {//1.���������minstart��û��ͷ���������
				nextSearch(nums,minstart-1);
			}
			else {//2.������minstart��ͷ�ˣ�˵���������鶼�ǽ�����ˣ���ֱ��reverse
				for(int i=0;i<nums.length/2;i++) {
					int tmp = nums[i];
					nums[i] = nums[nums.length-1-i];
					nums[nums.length-1-i] = tmp;
				}
			}
		}
		//����ҵ��ˣ�����Ҫ��[targetindex+1,nums.length-1]�������С�����ź�
		//�������ÿ���
		else {
			int left = targetindex+1;
			int right = nums.length-1;
			quicksort(nums,left,right);
		}
	}
	
	public void quicksort(int[] arr,int start,int end) {
		//��������
		if(start>=end) {
			return;
		}
		int pivot = arr[start];
		int left = start;
		int right = end;
		while(left<right) {
			//�ȴ��ұ��ҵ�һ����pivotС��
			while(arr[right]>=pivot&&right>left) {
				right--;
			}
			if(right>left) {
				arr[left] = arr[right];
			}
			//�ٴ������һ����pivot���
			while(arr[left]<=pivot&&right>left) {
				left++;
			}
			if(right>left) {
				arr[left] = arr[right];
			}
		}
		//����pivot���ȥ
		arr[left] = pivot;
		//�ݹ�
		quicksort(arr,start,left);
		quicksort(arr,left+1,end);
	}
}

package _75_��ɫ����;

public class Solution2 {
	/**
	 * �ٷ�˼·1.��ָ�룬���α���O(N)�������Ը��Ż���һ�α�������Solution3��
	 * 1.��һ�֣�ָ��ָ���һ����0λ��Ȼ��������飬һ���ҵ�ָ������һ��Ԫ��=0����ָ��λ��Ԫ�ؽ�����Ȼ��ָ�����һλ�������ղŵı�����
	 * 2.�ڶ��֣�0�Ѿ�ȫ������ǰ���ˣ�����ָ��ָ��0����ĵ�һ����1λ��ͬ�ϲ���
	 */
	public void sortColors(int[] nums) {
		//��һ�֣���0ȫ������ǰ����
		int index0 = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				index0 = i;
				break;
			}
		}
		for(int i=index0+1;i<nums.length;i++) {
			if(nums[i]==0) {
				nums[i] = nums[index0];
				nums[index0] = 0;
				index0++;
			}
		}
		//�ڶ���
		int index1 = index0;
		for(int i=index1;i<nums.length;i++) {
			if(nums[i]!=1) {
				index1 = i;
				break;
			}
		}
		for(int i=index1+1;i<nums.length;i++) {
			if(nums[i]==1) {
				nums[i] = nums[index1];
				nums[index1] = 1;
				index1++;
			}
		}
    }
}

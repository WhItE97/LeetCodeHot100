package _645_1tonȱ1���ظ�1��;

public class Solution2 {
	/**
	 * ˼·2.��2ms 90%��
	 * 1.��һ��for���һ����Ϊn�ĸ������飬��¼ÿ���±��ӦԪ�صĳ��ִ���
	 * 2.�ڶ���for��dup��mis
	 */
	public int[] findErrorNums(int[] nums) {
		int[] count = new int[nums.length];
		for(int i=0;i<nums.length;i++) {
			count[nums[i]-1]++;
		}
		int dup = -1;
		int mis = -1;
		for(int i=0;i<nums.length;i++) {
			if(count[i]>1) {
				dup = i+1;
			}
			if(count[i]<1) {
				mis = i+1;
			}
		}
		return new int[] {dup,mis};
    }
}

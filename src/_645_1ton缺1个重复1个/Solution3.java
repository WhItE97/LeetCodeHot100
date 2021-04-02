package _645_1tonȱ1���ظ�1��;

import java.lang.Math;

public class Solution3 {
	/**
	 * HD.��λ���� O(N)+O(1)��
	 * ˼�룺
	 * 1~n��һ������2�Σ�һ��û���֡���>
	 * ��1��ֱ��λ�����ƺ�ûʲô���ɣ�
	 * ��2������double����>�ƺ�Ҳû��
	 * ��3��������1~n����λ���㣡�������Ļ�������2�ε�����3�Σ�û���ֵı�1�Σ������ȫ��2�Σ�����>���õ�dup^mis
	 * ����steps��
	 * 1.��nums��һ��1~n�����鰴λ��򣬵õ����=dup^mis
	 * 2.Ϊ�˰�����������ֿ���ȡdup^mis���ұߵ�һ����Ϊ0��λ���ѡ�nums���ͣ�1~n�����顿�������λ���Ľ���Ĳ�ͬ���ֳ�2��
	 * 3.Ȼ�������ֱ������򣬴Ӷ��õ�dup��mis
	 */
	public int[] findErrorNums(int[] nums) {
		int xy = 0;
		int n = nums.length;
		//1.nums��1~n���õ�dup^mis
		for(int i=0;i<n;i++) {
			xy ^= (i+1);
			xy ^= nums[i];
		}
		System.out.println("xy="+xy);
		//2.�õ�x^y֮����һ���������ҵ�һ����0��λ���������
		int split = 0;
		while((xy&1)==0) {
			xy >>= 1;
			split++;
		}
		split = (int)Math.pow(2, split);
		int xor0 = 0;
		int xor1 = 0;
		//3.���ݺ�split����Ľ�����ָ���������
		//��self pro����ô�ж���һ�ߵ��������dup����һ����mis������>�ٷ���⣺������һ�ֱ�������������һ�����ҵ��˾���dup���������mis��
		for(int i=0;i<n;i++) {
			if((nums[i]&split)==0) {
				xor0 ^=  nums[i];
			}
			else {
				xor1 ^= nums[i];
			}
			if(((i+1)&split)==0) {
				xor0 ^= (i+1);
			}
			else {
				xor1 ^= (i+1);
			}
		}
		//4.��������xor0���жϾ���˭��dup��˭��mis
		for(int i=0;i<n;i++) {
			if(nums[i]==xor0) {
				return new int[] {xor0,xor1};
			}
		}
		return new int[] {xor1,xor0};
    }
}

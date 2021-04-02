package _645_1ton缺1个重复1个;

import java.lang.Math;

public class Solution3 {
	/**
	 * HD.【位运算 O(N)+O(1)】
	 * 思想：
	 * 1~n有一个出现2次，一个没出现——>
	 * （1）直接位运算似乎没什么规律！
	 * （2）尝试double——>似乎也没用
	 * （3）【尝试1~n加入位运算！】这样的话，出现2次的数变3次，没出现的变1次，其余的全是2次！——>异或得到dup^mis
	 * 具体steps：
	 * 1.把nums和一个1~n的数组按位异或，得到结果=dup^mis
	 * 2.为了把他们两个拆分开，取dup^mis的右边第一个不为0的位，把【nums！和！1~n的数组】根据与该位异或的结果的不同，分成2组
	 * 3.然后对两组分别进行异或，从而得到dup和mis
	 */
	public int[] findErrorNums(int[] nums) {
		int xy = 0;
		int n = nums.length;
		//1.nums和1~n异或得到dup^mis
		for(int i=0;i<n;i++) {
			xy ^= (i+1);
			xy ^= nums[i];
		}
		System.out.println("xy="+xy);
		//2.得到x^y之后求一个他的最右第一个非0的位所代表的数
		int split = 0;
		while((xy&1)==0) {
			xy >>= 1;
			split++;
		}
		split = (int)Math.pow(2, split);
		int xor0 = 0;
		int xor1 = 0;
		//3.根据和split做与的结果划分该两个数组
		//【self pro：怎么判断哪一边的异或结果是dup？哪一边是mis？——>官方题解：最后加上一轮遍历，查找其中一个，找到了就是dup；否则就是mis】
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
		//4.遍历查找xor0，判断究竟谁是dup，谁是mis
		for(int i=0;i<n;i++) {
			if(nums[i]==xor0) {
				return new int[] {xor0,xor1};
			}
		}
		return new int[] {xor1,xor0};
    }
}

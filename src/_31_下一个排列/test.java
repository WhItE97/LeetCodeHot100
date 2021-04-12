package _31_下一个排列;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		int[] nums = new int[]{5,1,1};
		Solution2 s = new Solution2();
		s.nextPermutation(nums);
//		s.quicksort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}

}

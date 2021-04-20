package _56_合并区间;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		int[] a = {3,5};
		int[] c = {2,4};
		int[] d = {6,7};
		int[][] b = new int[][] {a,c,d};
//		System.out.println(Arrays.toString(b[0]));
//		System.out.println(Arrays.toString(b[1]));
		Solution2 s = new Solution2();
		int[][] res = s.merge(b);
		for(int i=0;i<res.length;i++) {
			System.out.print(Arrays.toString(res[i])+",");
		}
	}

}

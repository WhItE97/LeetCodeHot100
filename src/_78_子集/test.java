package _78_×Ó¼¯;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class test {

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> res = s.subsets(new int[] {1,2,3});
		for(int i=0;i<res.size();i++) {
			System.out.println(res.get(i).toString());
		}
//		List<List<Integer>> res = new ArrayList<>();
//		List<Integer> l1 = new ArrayList<Integer>();
//		l1.add(1);
//		l1.add(2);
//		List<Integer> l2 = new ArrayList<Integer>();
//		l2.add(3);
//		res.add(l1);
//		res.add(l2);
//		System.out.println(Arrays.toString(ret));
	}

}

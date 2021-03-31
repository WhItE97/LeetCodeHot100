package _49_×ÖÄ¸ÒìÎ»´Ê·Ö×é;

import java.util.List;

public class test {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		Solution3 s = new Solution3();
		List<List<String>> ret = s.groupAnagrams(strs);
//		for(int i=0;i<ret.size();i++) {
//			for(int j=0;j<ret.get(i).size();j++) {
//				System.out.print(ret.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}
		System.out.println(ret);
	}

}

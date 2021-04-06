package _10_正则表达式匹配;

public class test {

	public static void main(String[] args) {
		String s = "ab";
		String p = "..*";
		System.out.println(new Solution().isMatch(s, p));
	}

}

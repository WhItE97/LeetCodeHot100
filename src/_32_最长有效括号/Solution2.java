package _32_最长有效括号;

public class Solution2 {
	/**
	 * 可以发现Solution中的dp分支，有很多=0的，那不如用if来写不等于0的！
	 * 1.dp[i]:以下标i的字符结尾的最长有效括号子串的长度——>【TRICK①显然只有')'结尾才会有效！】
	 * 2.转移方程：【本题的HDP①】
	 * dp[i]=
	 * (1)0;							s[i]=='('
	 * (2)2+dp[i-2];					s[i]和s[i-1]构成有效对，再加上其前面相邻的有效串长度
	 * (2.2)如果i-2<0，则dp[i]=2
	 * (3)2+dp[i-1]+dp[i-dp[i-1]-2];	s[i]和s[i-1]不构成有效对；但是和上一个子串的再前一个字符构成跨尺度有效对
	 * (3.2)如果i-dp[i-1]-1<0，则dp[i]=0
	 * (3.3)如果i-dp[i-1]-1>=0，但是s[i]和s[i-dp[i-1]-1]不构成有效对，则dp[i]=0
	 * (3.4)如果i-dp[i-1]-1>=0，且s[i]和s[i-dp[i-1]-1]构成有效对，还需要对(i-dp[i-1]-1)-1是否>=0进行判断，如果前面还可能存在子串（即i-dp[i-1]-2>=0），则还要加上该字符结尾的子串的dp
	 * 【ATT.上述2、3都需要考虑：越界情况！——>本题的HDP②】
	 * 【TRICK②（优化代码结构的TRICK）观察上述分析可以发现，有很多=0的分支，所以为了简化，把他们都归进else里】
	 */
	public int longestValidParentheses(String s) {
		if(s.length()==0) {
			return 0;
		}
		int[] dp = new int[s.length()];
		int max = 0;
		for(int i=1;i<s.length();i++) {
			//!=0的situ
			if(s.charAt(i)==')') {
				//1.和前面相邻的构成有效对
				if(s.charAt(i-1)=='(') {
					dp[i] = ((i>=2)?dp[i-2]:0)+2;
				}
				//2.跨尺度构成有效对
				else if((i-dp[i-1]-1)>=0) {
					//2.1.构成有效对
					if(s.charAt(i-dp[i-1]-1)=='(') {
						dp[i] = (((i-dp[i-1]-2)>=0)?dp[i-dp[i-1]-2]:0)+dp[i-1]+2;//2.1.1and2:细分前面是否还有子串
					}
				}
			}
			//如果上面的situs一个都没走通，那就理应设置为0——>又初始化了零值，所以不用再处理，直接取max即可
			max = Math.max(max, dp[i]);
		}
		return max;
    }
}

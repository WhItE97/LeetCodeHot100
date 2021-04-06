package _4_最长回文子串;

public class Solution2 {
	/**
	 * 官方题解1.【动态规划 O(n^2)+O(n^2),已经比自己的O(n^3)好 451ms 10%】：
	 * 1.不再是int dp[i]！因为子串涉及到起点和中点，所以用dp[i][j]表示从i到j的子串
	 * 2.是否是回文串——>用boolean——>boolean dp[][]
	 * 3.【HDP dp思路】【（1）第一个for：遍历所有的可能子串长度；（2）第二个for：在每个长度里遍历所有可能的起点，通过：
	 * dp[i][j]=
	 * (1)true; 			l(子串长)==1即dp[i][i]
	 * (2)true/false;		l(子串长)==2&&s[i]==s[j]
	 * (2)true;				s[i]==s[j]&&dp[i+1][j-1]
	 * (3)false;			!dp[i+1][j-1]||s[i]!=s[j]
	 * (其中，要注意i>j本来就是非法的)
	 */
	public String longestPalindrome(String s) {
		int len = s.length();
		if(len==0) {
			return "";
		}
		int maxl = 0;
		int maxr = 0;
		boolean[][] dp = new boolean[len][len];
		//1.第一层for遍历所有可能的子串长度
		for(int i=0;i<len;i++) {
			//2.第二层for遍历该子串长度，每一个可能的起点的dp
			for(int j=0;j<len-i;j++) {
				//(1)如果子串长=1（即offset i=0），必为回文
				if(i==0) {
					dp[j][j] = true;
					System.out.println("1.dp["+j+"]["+j+"]="+dp[j][j]);
				}
				//(2)【ATT】子串长=2也是特殊情况！只用判断两个位置的元素是否相等即可！
				else if(i==1&&s.charAt(j)==s.charAt(i+j)) {
					dp[j][j+i] = true;
					System.out.println("2.dp["+j+"]["+(j+i)+"]="+dp[j][j+i]);
				}
				//(3)子串长大于1，但满足s[a]==s[b]&&dp[a+1][b-1]
				else if(s.charAt(j)==s.charAt(j+i)&&dp[j+1][j+i-1]) {
					dp[j][j+i] = true;
					System.out.println("3.dp["+j+"]["+(j+i)+"]="+dp[j][j+i]);
				}
				//(4)else
				else {
					dp[j][j+i] = false;
					System.out.println("4.dp["+j+"]["+(j+i)+"]="+dp[j][j+i]);
				}
				//状态转移结束后，要检查是否需要更新最大回文子串的下标
				if(dp[j][j+i]&&(i+1>maxr-maxl+1)) {
					maxl = j;
					maxr = j+i;
					System.out.println("maxl="+maxl+",maxr="+maxr);
				}
			}
		}
		return s.substring(maxl,maxr+1);
    }
}

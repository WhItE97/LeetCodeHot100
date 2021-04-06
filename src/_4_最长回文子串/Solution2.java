package _4_������Ӵ�;

public class Solution2 {
	/**
	 * �ٷ����1.����̬�滮 O(n^2)+O(n^2),�Ѿ����Լ���O(n^3)�� 451ms 10%����
	 * 1.������int dp[i]����Ϊ�Ӵ��漰�������е㣬������dp[i][j]��ʾ��i��j���Ӵ�
	 * 2.�Ƿ��ǻ��Ĵ�����>��boolean����>boolean dp[][]
	 * 3.��HDP dp˼·������1����һ��for���������еĿ����Ӵ����ȣ���2���ڶ���for����ÿ��������������п��ܵ���㣬ͨ����
	 * dp[i][j]=
	 * (1)true; 			l(�Ӵ���)==1��dp[i][i]
	 * (2)true/false;		l(�Ӵ���)==2&&s[i]==s[j]
	 * (2)true;				s[i]==s[j]&&dp[i+1][j-1]
	 * (3)false;			!dp[i+1][j-1]||s[i]!=s[j]
	 * (���У�Ҫע��i>j�������ǷǷ���)
	 */
	public String longestPalindrome(String s) {
		int len = s.length();
		if(len==0) {
			return "";
		}
		int maxl = 0;
		int maxr = 0;
		boolean[][] dp = new boolean[len][len];
		//1.��һ��for�������п��ܵ��Ӵ�����
		for(int i=0;i<len;i++) {
			//2.�ڶ���for�������Ӵ����ȣ�ÿһ�����ܵ�����dp
			for(int j=0;j<len-i;j++) {
				//(1)����Ӵ���=1����offset i=0������Ϊ����
				if(i==0) {
					dp[j][j] = true;
					System.out.println("1.dp["+j+"]["+j+"]="+dp[j][j]);
				}
				//(2)��ATT���Ӵ���=2Ҳ�����������ֻ���ж�����λ�õ�Ԫ���Ƿ���ȼ��ɣ�
				else if(i==1&&s.charAt(j)==s.charAt(i+j)) {
					dp[j][j+i] = true;
					System.out.println("2.dp["+j+"]["+(j+i)+"]="+dp[j][j+i]);
				}
				//(3)�Ӵ�������1��������s[a]==s[b]&&dp[a+1][b-1]
				else if(s.charAt(j)==s.charAt(j+i)&&dp[j+1][j+i-1]) {
					dp[j][j+i] = true;
					System.out.println("3.dp["+j+"]["+(j+i)+"]="+dp[j][j+i]);
				}
				//(4)else
				else {
					dp[j][j+i] = false;
					System.out.println("4.dp["+j+"]["+(j+i)+"]="+dp[j][j+i]);
				}
				//״̬ת�ƽ�����Ҫ����Ƿ���Ҫ�����������Ӵ����±�
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

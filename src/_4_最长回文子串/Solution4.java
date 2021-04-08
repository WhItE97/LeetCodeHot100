package _4_������Ӵ�;

public class Solution4 {
	/**
	 * boolean dp[i][j]:i to j���������Ƿ��ǻ���
	 * ��CORE1��״̬ת�Ʒ��̣�
	 * dp[i][j]=
	 * (1)false;					i>j�Ƿ�
	 * (2)true;						i==j���ַ�
	 * (3)s[i]==s[j];				j-i==1
	 * (4)s[i]==s[j]&&dp[i+1][j-1];	else
	 * ��CORE2��
	 * ��Ϊ״̬ת�Ʒ����ǳ�����base�Ӵ��Ľ�������������ѭ���Դ����ȴ�С�������
	 */
	public String longestPalindrome(String s) {
		int maxl = 0;
		int maxr = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		dp[0][0] = true;
		//��CORE2��
		for(int len=1;len<=s.length();len++) {
			for(int i=0;i<=s.length()-len;i++) {
				//1.len==1
				if(len==1) {
					dp[i][i] = true;
				}
				//2.len==2
				else if(len==2) {
					dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
				}
				//3.len>2
				else {
					dp[i][i+len-1] = dp[i+1][i+len-2]&&s.charAt(i)==s.charAt(i+len-1);
				}
				//ÿ��checkΪtrue�Ĵ��ĳ����Ƿ����Ӵ���������������������Ӵ���ָ��
				if(dp[i][i+len-1]&&len>(maxr-maxl+1)) {
					maxl = i;
					maxr = i+len-1;
				}
			}
		}
		return s.substring(maxl,maxr+1);
    }
}

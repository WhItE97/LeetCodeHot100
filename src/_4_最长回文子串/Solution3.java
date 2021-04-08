package _4_������Ӵ�;

public class Solution3 {
	/**
	 * 2021/4/7 dp����review��WRONG����������������
	 * boolean f[i][j]:s[i]~s[j]�Ƿ��ǻ��Ĵ�
	 * ת�Ʒ���f[i][j]=
	 * (1)false;					i>j�Ƿ�
	 * (2)true;						i==j�����ַ���Ȼ�ǻ���
	 * (3)s[i]==s[j];				j-i==1��ATT����
	 * (3)f[i+1][j-1]&&s[i]==s[j];	i<j
	 * ��ʼ״̬
	 * f[0][0] = true;//��ʾ��һ���ַ�
	 * ***********************************************
	 * ����ʼ��������˼·���߼�©����
	 * f[i][j] = f[i+1][j-1]&&s[i]==s[j]��ת�Ʒ��̣�base��i~j��������(i-1)~(j-1)�Ѿ�check����
	 * ��ô������������for(int i=0;i<s.length();i++){for(int j=i;j<s.length();j++){}}��2��Ƕ�׵Ļ�
	 * ��i=0,j=k��ʱ����������i=1,j=k-1����û��check������Ȼ��false����
	 * ��������ȷ��˼·��
	 * ��Ϊ���ǵ�ת�Ʒ���base���������У���������ѭ��ҲҪ�������в�����������������ѭ��Ӧ���������г��ȣ���1���ַ���ʼ��
	 * ��Solution4
	 */
	public String longestPalindrome(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		int maxl = 0;
		int maxr = 0;
		dp[0][0] = true;
		for(int i=0;i<s.length();i++) {
			for(int j=i;j<s.length();j++) {
				//i==j,�����ַ�
				if(i==j) {
					dp[i][j] = true;
				}
				else if((j-i)==1) {
					dp[i][j] = s.charAt(i)==s.charAt(j);
				}
				//i<j
				else {
					dp[i][j] = dp[i+1][j-1]&&s.charAt(i)==s.charAt(j);
				}
				//ÿ�ּ��true���ַ��������Ƿ��max�󣬴�Ļ�����maxl��maxr
				if(dp[i][j]&&(j-i)>(maxr-maxl)) {
					maxl = i;
					maxr = j;
				}
			}
		}
		return s.substring(maxl,maxr+1);
    }
}

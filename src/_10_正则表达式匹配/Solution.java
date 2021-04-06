package _10_������ʽƥ��;

/**
 * ��Ŀ��
 * ����һ���ַ��� s ��һ���ַ����� p��������ʵ��һ��֧�� '.' �� '*' ��������ʽƥ�䡣
 * '.' ƥ�����ⵥ���ַ�
 * '*' ƥ���������ǰ�����һ��Ԫ��
 * ��νƥ�䣬��Ҫ���� ���� �ַ��� s�ģ������ǲ����ַ�����
 * ATT.
 * s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ
 * p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *
 * ��֤ÿ�γ����ַ� * ʱ��ǰ�涼ƥ�䵽��Ч���ַ�
 */
public class Solution {
	/**
	 * ���ǿ������..˼·��
	 * ��δ���*����ַ�����CORE.HDP�ٰ�������ǰ���ch�󶨴�������������ch*����
	 * ��Ϊ*���ظ�ǰ����ַ������Բ����Ӻ���ǰmatch<���ã���ǰ���Ҳ��!>
	 * boolean f[i][j]:s��ǰi���ַ��ܷ���p��ǰj���ַ�ƥ��<TRUE>
	 * ת�Ʒ��̣�
	 * f[i][j]=
	 * (1)p[j]!=*
	 * matches=f[i-1][j-1]
	 * ��match=false;
	 * (2)p[j]==*��HDP�� ��ch*������Ĵ���
	 * 1)��HDP�� �ܶ�������һ�ԣ�ֱ�Ӱ�����������=f[i][j-2]��
	 * 2)��������һ��ȥmatch���ֻ���match�ɹ���ʧ��2��situs��
	 * 2a)�ɹ�=f[i-1][j]
	 * 2b)ʧ��=f[i][j-2]
	 */
	public boolean isMatch(String s, String p) {
		//base
		if(s.length()!=0&&p.length()==0) {
			return false;
		}
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0] = true;
		for(int i=0;i<=s.length();i++) {//��ATT.i���Դ�0��ʼ����Ϊ��s�����÷ǿ�p match����
			for(int j=1;j<=p.length();j++) {
				//1.p[j]!='*'
				if(p.charAt(j-1)!='*') {
					if(matches(s,i,p,j)) {
						dp[i][j] = dp[i-1][j-1];
					}
					else {
						dp[i][j] = false;
					}
				}
				//2.p[j]=='*'��������ǰһ��ch���
				else {
					//2.1.������ȥmatch��ֱ���ӵ���ch*��
					dp[i][j] = dp[i][j-2];
					//2.2.����ȥmatch(����Ѿ�Ϊtrue����Ҳ�����ٳ�����)
					if(dp[i][j]!=true) {
						//(1)match�ɹ�
						if(matches(s,i,p,j-1)) {
							dp[i][j] = dp[i-1][j];
						}
						//(2)matchʧ��
						else {
							dp[i][j] = dp[i][j-2];
						}
					}
				}
			}
		}
		return dp[s.length()][p.length()];
    }
	//��HDP�� ��i��j�ͺ������±�Ķ�Ӧ��ϵ��������match���Ӻ����ﴦ����
	//�����iλ�͵�jλ����match�����Ժ����ڲ���Ӧԭ�±�Ҫ-1
	public boolean matches(String s,int i,String p,int j) {
		if(i==0) {//��HDP�ݡ�i��0��ʼ�����ǵ���sΪ�մ���p���Ǳ������ѭ���ģ�p����="x*"���������±��ǲ���ȡ-1�ģ�����ֱ��return false������s=""��p="x*"�ͽ���dp[0][2]=ֱ�Ӷ�����ch*�����=dp[0][0]�����ȥ�����ɣ�
			return false;
		}
		if(p.charAt(j-1)=='.') {
			return true;
		}
		else {
			return s.charAt(i-1)==p.charAt(j-1);
		}
	}
}

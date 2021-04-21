package _72_�༭����;

/**
 * ��Ŀ��
 * ������������ word1 �� word2������������ word1 ת���� word2 ��ʹ�õ����ٲ����� ��
 * ����Զ�һ�����ʽ����������ֲ�����
 * ����һ���ַ�
 * ɾ��һ���ַ�
 * �滻һ���ַ�
 * 0 <= word1.length, word2.length <= 500
 */
public class Solution {
	/**
	 * self˼·��
	 * none...
	 * ���ۡ��ٷ���Ƶ�����˼·����O(MN)��
	 * dp��
	 * 1.dp[i][j]:word1��ǰi���ַ� ת���� word2��ǰj���ַ��� �༭����
	 * 2.��HDP.״̬ת�Ʒ��� �Ƚ�����&&��⣬�������ʳ�á�
	 * ��word1��i��word2��j���£�
	 * word1��ǰi=xxxa
	 * word2��ǰj=xxb
	 * �����ӿ��Կ�����������д״̬ת�Ʒ��̣��������ж�word1[i]��word2[j]�Ĺ�ϵ�����������Ƿ���ȣ���
	 * ��1��word1[i]==word2[j]:����ֱ��ȥ����������>dp[i][j]=dp[i-1][j-1]
	 * ��2��word1[i]!=word2[j]:����Ҫ���С�����(һ����3�֣���orɾor��)����
	 * 		����word1����һ����word2[j]match���ַ���dp[i][j]=dp[i][j-1]+1(���+1�����Ӳ���)
	 * 		�ڰ�word1��match�ĸ�ɾ����dp[i][j]=dp[i-1][j]+1(���+1��ɾ������)
	 * 		�۰�word1��match�ĸ��滻��match�ģ�dp[i][j]=dp[i-1][j-1]+1(���+1���滻����)
	 */
	public int minDistance(String word1, String word2) {
		//base
		if(word1.length()==0) {
			return word2.length();
		}
		int l1 = word1.length()+1;
		int l2 = word2.length()+1;
		int[][] dp = new int[l1][l2];
		//���ȳ�ʼ��word1��word2�±�Ϊ0ʱ���dp����
		//1.��ʼ��word1ǰ0���ַ���ʾword2�ı༭����
		for(int i=0;i<l2;i++) {
			dp[0][i] = i;
		}
		//2.��ʼ��word2ǰ0���ַ���ʾword1�ı༭����
		for(int i=0;i<l1;i++) {
			dp[i][0] = i;
		}
		//��ʼdp
		for(int i=1;i<l1;i++) {
			for(int j=1;j<l2;j++) {
				if(word1.charAt(i-1)==word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					int min1 = Math.min(dp[i][j-1], dp[i-1][j]);
					dp[i][j] = Math.min(min1, dp[i-1][j-1])+1;
				}
			}
		}
		return dp[l1-1][l2-1];
    }
}

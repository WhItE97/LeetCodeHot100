package _32_���Ч����;

/**
 * ��Ŀ��
 * ����һ��ֻ���� '(' �� ')' ���ַ������ҳ����Ч����ʽ��ȷ�������������Ӵ��ĳ��ȡ�
 */
public class Solution {
	/**
	 * self˼·��
	 * dp����>��ûд����ת�Ʒ���...
	 * 
	 * �ٷ����dp selfʵ�֣���O(N)+O(N) 2ms 70%�������߼�д��̫������...��Solution2��
	 * dp[i]:���±�i���ַ���β�Ĵ������Ч�����Ӵ�
	 * ��TRICK ��Ϊdp��״̬��������s[i]��β������'('��Ȼ�ǷǷ�״̬������dp=0��
	 * ��ת�Ʒ��� HDP��
	 * dp[i]=
	 * (1)2+dp[i-2];					s[i-1]=='(';
	 * (2)2+dp[i-1]+dp[i-dp[i-1]-2];	s[i-dp[i-1]-1]=='(';��MOST CORE HDP�����ֿ�߶ȵ�match������Ҫ�����ҵ�ңԶ�������ŵ����һλ��dpֵ������Ϊ��һ�Կ�߶ȵ�matchֻ��¼���Լ��ĳ��ȣ���ǰ����ܻ��кϷ�������
	 * (3)0;							else;
	 */
	public int longestValidParentheses(String s) {
		//base
		if(s.length()==0) {
			return 0;
		}
		int[] dp = new int[s.length()];
		dp[0] = 0;
		int max = 0;
		for(int i=1;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				dp[i] = 0;
			}
			else if(s.charAt(i-1)=='(') {
				dp[i] = ((i-2)>=0)?2+dp[i-2]:2;//��WRONG POINT.()�����Ҫ����i-2Խ���ˣ���
			}
			else if((i-dp[i-1]-2)<0) {//��WRONG POINT 3.����ǰ����Ȼû���Ӵ��ˣ�����Ҫ���Ǳ������)��û�п�߶�match�ɹ�����
				if((i-dp[i-1]-1)<0) {//��WRONG POINT 4.���Ǳ��ֿ�߶�match֮ǰ�����ÿ��Ǳ��ֻ���û�����������ǿ�߶�match...��
					dp[i] = 0;
				}
				else if(s.charAt(i-dp[i-1]-1)=='(') {
					dp[i] = 2+dp[i-1];
				}
				else {
					dp[i] = 0;
				}
			}
			else if(s.charAt(i-dp[i-1]-1)=='(') {//��WRONG POINT 2.ͬ����û����Խ��...д�������else if���ˡ�
				dp[i] =  2+dp[i-1]+dp[i-dp[i-1]-2];
			}
			else {
				dp[i] = 0;
			}
			System.out.println("i="+i+",dp[i]="+dp[i]);
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		return max;
    }
}


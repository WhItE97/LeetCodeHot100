package _3_���ظ��ַ�����Ӵ�;

import java.util.Arrays;

/**
 * ��Ŀ��
 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
 */
public class Solution {
	/**
	 * self˼·����17ms 20%��
	 * ����Ӵ���->dp
	 * 1.dp[i]:��i��β����Ӵ�����
	 * 2.ת�Ʒ���
	 * dp[i]=
	 * (1)dp[i-1]+1; 				s[i]��s[i-1]~s[i-dp[i-1]]��û���ֹ�
	 * (2)i-��һ�α��ַ����ֵ�λ��; 		else
	 * ������Ҫʵ��һ��search pre���Ӻ���
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s.length()<1) {
			return 0;
		}
		int[] dp = new int[s.length()];
		dp[0] = 1;
		for(int i=1;i<s.length();i++) {
			int pre = searchPre(s,s.charAt(i),i-dp[i-1],i-1);
			dp[i] = (pre==-1)?dp[i-1]+1:(i-pre);
		}
		Arrays.sort(dp);
		return dp[s.length()-1];
    }
	//��[start,end]�����target�ַ����������һ�γ��ֵ��±�
	//���û�ҵ��򷵻�-1
	public int searchPre(String s,char target,int start,int end) {
		for(int i=end;i>=start;i--) {
			if(s.charAt(i)==target) {
				return i;
			}
		}
		return -1;
	}
}

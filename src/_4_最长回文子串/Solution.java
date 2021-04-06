package _4_������Ӵ�;

/**
 * ��Ŀ��
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ���
 * s �������ֺ�Ӣ����ĸ����д��/��Сд�����
 */
public class Solution {
	/**
	 * self˼·����1665ms 5%...��
	 * ����������㣬����������Ӵ�������ȵ�ǰ�����Ӵ���ͨ��maxl��maxr����±꣩����������±�
	 */
	public String longestPalindrome(String s) {
		if(s.length()==0) {
			return "";
		}
		int maxl = 0;
		int maxr = 1;//��ATT.������ó�[maxl,maxr)����ҿ�����Ϊsubstring����������ҿ��ģ���
		int maxlen = maxr-maxl;
		for(int i=0;i<s.length();i++) {
			//����ÿ���ַ���������Ӵ�
			//1.�����жϵ�ǰʣ�³����Ƿ����Ӵ����������������Ӵ����ˣ���ֱ��break
			if((s.length()-i)<maxlen) {
				break;
			}
			//2.����ʼ���е�ǰ�ַ�Ϊ������Ӵ�����
			for(int j=i+1;j<=s.length();j++) {//��ATT2.����Ҫע������ҿ��������ұ�Ӧ�ÿ���ȡ��length()����
				//2.1.һλһλ�ӳ��Ӵ������жϣ�����ǻ��Ĵ������maxlen�Ƚϣ���������������maxl,maxr,maxlen
				if(isPalindrome(s.substring(i,j))) {
					//��maxlen�Ƚ�
					if((j-i)>maxlen) {
						maxl = i;
						maxr = j;
						maxlen = maxr-maxl;
					}
				}
			}
		}
		return s.substring(maxl,maxr);
    }
	
	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length()-1;
		while(left<right) {
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}

package _76_��С�����Ӵ�;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ŀ��
 * ����һ���ַ��� s ��һ���ַ��� t ������ s �к��� t �����ַ�����С�Ӵ������ s �в����ں��� t �����ַ����Ӵ����򷵻ؿ��ַ��� "" ��
 * ע�⣺��� s �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
 * ���ף��������һ���� o(n) ʱ���ڽ����������㷨��
 */
public class Solution {
	/**
	 * self˼·����264/266����������ʱ��
	 * ���ڴ�С��t.length()�������ҵ���һ���ܹ�����t�������ַ����Ӵ�������
	 */
	public String minWindow(String s, String t) {
		for(int win=t.length();win<=s.length();win++) {//�������д��ڴ�С
			for(int i=0;i<=s.length()-win;i++) {//����ĳ���ڴ�С�������Ӵ�
				int ret = contains(s,t,win,i);
				if(ret==1) {
					return s.substring(i,i+win);
				}
			}
		}
		return "";
    }
	
	//return 1��ʾmatch�ɹ���-1��ʾmatchʧ��
	public int contains(String s,String t,int win,int i) {
		//����match��ʽ����t���ַ����Ž�hashmap��ÿmatch��һ�ξͶԸ��ַ�value-1��value==0�ľͿ��Դ�mapɾ����mapsize==0��match�ɹ�
		Map<Character,Integer> map = new HashMap<>();
		for(int j=0;j<t.length();j++) {
			int times = map.getOrDefault(t.charAt(j), 0);
			map.put(t.charAt(j), times+1);
		}
		//��ʼmatch
		for(int j=i;j<i+win;j++) {
			if(map.get(s.charAt(j))!=null) {//��ATT.hashmap��get���no mapping�᷵��null����
				map.put(s.charAt(j), map.get(s.charAt(j))-1);
				if(map.get(s.charAt(j))==0) {
					map.remove(s.charAt(j));
				}
			}
			if(map.size()==0) {
				return 1;
			}
		}
		return -1;
	}
}

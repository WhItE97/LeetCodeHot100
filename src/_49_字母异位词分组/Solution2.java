package _49_��ĸ��λ�ʷ���;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution2 {
	/**
	 * �ٷ����˼·1.��û�뵽��û�뵽����13ms 22%��
	 * 1.ץ��ĸ��λ�ʵ��ص㣡���������ֵ���ĸ������ִ�����ͬ����
	 * 2.�β����ݳ��ֵ���ĸ�����������a-z��˵��ȫ��Сд����˳���ų�һ������TRICK 1����������λ�ʣ�����ͬ��key��
	 * 3.����λ�ʵ�ͨ����ʽ��key����TRICK 2��value�Ǹ�����λ�ʵ�List������
	 * 4.����Map��ÿ������valueת��Ϊ��Ӧ�������鼴��
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<>();
		//���������ַ���
		for(String str:strs) {
			//����count��ǰ�ַ�����a-zԪ�ظ���
			int[] count = new int[26];
			for(int i=0;i<str.length();i++) {
				count[str.charAt(i)-'a']++;
			}
			//count��󣬰�a-z��˳��+count�еĳ��ִ���
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<26;i++) {
				while(count[i]!=0) {
					sb.append((char)(i+'a'));//��ATT��
					count[i]--;
				}
			}
			//��ԭ������Ϊ����ĸ��λ�ʵ�key�����������ݸ�key����map
			//1.����Ҫ��map�и�key��List��ȡ���������⸲��
			List<String> ls = map.getOrDefault(sb.toString(),new ArrayList<String>());//��ATT getOrDefault���÷������ûget���ͷ���default��
			//2.�ѵ�ǰstr��ӽ�����������key��value��
			ls.add(str);
			//3.��listд��map
			map.put(sb.toString(), ls);
		}
		//map��value���Ǵ����List
		return new ArrayList<List<String>>(map.values());
    }
}

package _49_��ĸ��λ�ʷ���;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * ��Ŀ��
 * ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����
 */
public class Solution {
	/**
	 * self˼·����2396ms 5%...��
	 * 1.ĳ���ʵ�������ĸ��һ��HashSetװ
	 * 2.Ȼ�����ʣ�µĵ��ʣ�
	 * ��1�����������ȣ���ʹ��һ��int count��¼match����ĸ�������count==length������뵽һ��List����������String[]��Ų����
	 * ��2�����Ȳ���������
	 * 3.�õ��ʵ�HashSet����������String��Ѱ��String[]����һ����=null�ĵ��ʣ��ظ����ϲ���
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		List<String> route = new ArrayList<>();
		for(int i=0;i<strs.length;i++) {
			System.out.println("���ֵ�ĸ����="+strs[i]);
			//�������е��ʣ���ÿһ�����ʽ�������ƥ��Ļ���
			//ע��Ҫ�жϣ��õ�������Ѿ���ĳ�����������ˣ��ͻ�����Ϊnull
			if(strs[i]==null) {
				continue;
			}
			//��Ҫ�ѱ��ֵ�ĸ������ѹ��route
			route.add(strs[i]);
			HashMap<Character,Integer> first = new HashMap<>();
			for(int j=0;j<strs[i].length();j++) {
				first.put(strs[i].charAt(j),first.getOrDefault(strs[i].charAt(j),0)+1);//�ѱ���ĸ���ʵ������ַ�add��map,���Ҽ�¼ÿ����ĸ�ĳ���Ƶ��
			}
			//���뱾��ĸ���ʶ����µ��ʵ����ױ���
			for(int k=i+1;k<strs.length;k++) {
				System.out.println("ĸ����="+strs[i]+",���ֽ���match���ӵ���="+strs[k]);
				//�����жϺ�ĸ���ʳ����Ƿ����
				if(strs[k]==null||strs[i].length()!=strs[k].length()) {
					continue;//���Ȳ���ȶ������ټ����Ƚ���
				}
				//���������ȣ�����HashMap��¼ÿ�����ʵĳ��ִ�������֮���ÿһ����������copy��map��ĳ����ĸƥ��ͳ��ִ���--������=0�ʹ�copy map��ɾ�������ո���copy map size�Ƿ�==0���ж��Ƿ���ȫmatch
				//������ظ���ĸ��count�����У��ظ���ĸ���ظ�������ͬ���������뿽��һ��ĸ���ʵ�map����value����--���жϣ�����0�ʹ�map��ɾ����������map�Ƿ�Ϊ�����ж��Ƿ���ȫmatch��
				HashMap<Character,Integer> copy = new HashMap<>(first);
				//��ʼ���ֵ�match
				for(int m=0;m<strs[i].length();m++) {
					if(copy.get(strs[k].charAt(m))==null) {//һ������һ��ĸ����û�г��ֹ�����ĸ����������
						break;
					}
					else {
						copy.put(strs[k].charAt(m), copy.get(strs[k].charAt(m))-1);
						if(copy.get(strs[k].charAt(m))==0) {
							copy.remove(strs[k].charAt(m));
						}
					}
				}
				//��һ����������һ��match�󣬲鿴copy��size
				if(copy.size()==0) {
					//˵����ȫmatch��������ӽ�route
					route.add(strs[k]);
					//����Ҫ�Ѹ�λ�õ�String��Ϊnull��
					strs[k] = null;
				}
			}
			//һ��ĸ���ʵı�����������route add��res�����route
			res.add(new ArrayList<String>(route));
			route.clear();
		}
		return res;
    }
}

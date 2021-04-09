package _17_�绰�������ĸ���;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Solution2 {
	/**
	 * self˼·����1ms 83%��
	 * ����dfs
	 * ��TRICK��map�����ã�����ֱ�Ӱ����ֶ�Ӧ����ĸ���ų��ַ������룡��Լ��תΪchar[]�Ŀռ��Լ�������map��ʼ����
	 * 
	 * def dfs():
	 * if(�����������):
	 * 	res.add
	 *
	 * forѡ��inѡ���б�
	 * 	��ѡ��
	 * 	dfs��
	 * 	����ѡ��
	 */
	public List<String> letterCombinations(String digits) {
		//base
		if(digits.length()==0) {
			return new ArrayList<String>();
		}
		Map<Integer,String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		dfs(map,digits);
		return res;
    }
	
	List<String> res = new ArrayList<>();
	StringBuilder sb = new StringBuilder();
	public void dfs(Map<Integer,String> map,String digits) {
		if(sb.length()==digits.length()) {
			res.add(sb.toString());
			return ;
		}
		//dfs
		String choices = map.get(Integer.parseInt(digits.substring(sb.length(), sb.length()+1)));
		for(int i=0;i<choices.length();i++) {
			//��ѡ��
			sb.append(choices.charAt(i));
			//dfs
			dfs(map,digits);
			//����ѡ��
			sb.delete(sb.length()-1, sb.length());
		}
	}
}

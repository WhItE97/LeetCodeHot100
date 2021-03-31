package _49_��ĸ��λ�ʷ���;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
	/**
	 * �ٷ����˼·2.�������7ms 96%��
	 * ���ȭ
	 * 1.String��toCharArray
	 * 2.��Arrays.sort(chararr)
	 * 3.��new String(chararr)
	 * ���ܵõ���String�ź����һ��ĸ�����Ը�ĸ��Ϊkey��ͬsolution2.ֱ�Ӳ���map�Ķ�Ӧkey��List��value�м��ɣ�
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<>();
		for(String str:strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			
			//���ȭ�����ˣ���ʼ����
			List<String> ls = map.getOrDefault(key,new ArrayList<String>());
			ls.add(str);
			map.put(key, ls);
		}
		return new ArrayList<List<String>>(map.values());
    }
}

package _17_�绰�������ĸ���;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * ��Ŀ��
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 */
public class Solution {
	/**
	 * self˼·����dfsʱ����û���⣬�ռ����˷��ˣ�����ֱ����String��ÿλ���ֶ�Ӧ����ĸ���ɵ��ַ����ģ���Solution2��
	 * ����dfs
	 * ��ÿ�����ֶ�Ӧ����ĸ���ch[]��Ȼ������ֺ�ch[]�Ķ�Ӧ��ϵ���hashmap��ÿ��dfs�������ֻ�ȡ��char[]��Ը�char[]����dfs
	 * 
	 * def dfs(ѡ���б�):��ATT.�ݹ鴫�ݵ�ѡ���б����������������ֶ�Ӧ����ĸ������ÿλ��dfsʱ���ܸ����Լ�����ֵѡ�񡪡�>ѡ���б���HashMap�棬valueΪchar[]��
	 * if(�����������):
	 * 	res.add
	 *
	 * forѡ��inѡ���б�
	 * 	��ѡ��
	 * 	dfs��
	 * 	����ѡ��
	 */
	public List<String> letterCombinations(String digits) {
		if(digits.length()==0) {
			return new ArrayList<>();
		}
		char[] chs = digits.toCharArray();
		//��chsȫת��Ϊ����
		int[] str = new int[chs.length];
		for(int i=0;i<chs.length;i++) {
			str[i] = chs[i]-'0';
		}
		Map<Integer,char[]> choices = new HashMap<>();
		//1.����ѡ���б�
		char[] ch2 = new char[] {'a','b','c'};
		choices.put(2,ch2);
		char[] ch3 = new char[] {'d','e','f'};
		choices.put(3,ch3);
		char[] ch4 = new char[] {'g','h','i'};
		choices.put(4,ch4);
		char[] ch5 = new char[] {'j','k','l'};
		choices.put(5,ch5);
		char[] ch6 = new char[] {'m','n','o'};
		choices.put(6,ch6);
		char[] ch7 = new char[] {'p','q','r','s'};
		choices.put(7,ch7);
		char[] ch8 = new char[] {'t','u','v'};
		choices.put(8,ch8);
		char[] ch9 = new char[] {'w','x','y','z'};
		choices.put(9,ch9);
		//����dfs
		dfs(str,choices);
		return res;
    }
	
	List<String> res = new ArrayList<>();
	StringBuilder route = new StringBuilder();
	//str:ԭ���ִ�
	//choices:map���ÿ�����ֶ�Ӧ��char[]
	public void dfs(int[] str,Map<Integer,char[]> choices) {
		//1.��������
		if(route.length()==str.length) {
			res.add(route.toString());
			return ;
		}
		
		//dfs
		int num = str[route.length()];//num��ĳλ���֣�[2,9]
		char[] choice = choices.get(num);//ͨ����ǰroute���������str�еڼ�λ���Ӷ�ȡ����Ӧ�����ֵ�char[]ѡ���б�
		for(char ch:choice) {
			//1.��ѡ��
			route.append(ch);
			//2.dfs
			dfs(str,choices);
			//3.����ѡ��
			route.delete(route.length()-1, route.length());
		}
	}
}


/**
 * List<Character> ls = new ArrayList<>();
		//2
		ls.add('a');
		ls.add('b');
		ls.add('c');
		choices.put(2, new ArrayList<Character>(ls));
		ls.clear();
		//3
		ls.add('d');
		ls.add('e');
		ls.add('f');
		choices.put(3, new ArrayList<Character>(ls));
		ls.clear();
		//4
		ls.add('g');
		ls.add('h');
		ls.add('i');
		choices.put(4, new ArrayList<Character>(ls));
		ls.clear();
		//5
		ls.add('j');
		ls.add('k');
		ls.add('l');
		choices.put(5, new ArrayList<Character>(ls));
		ls.clear();
		//6
		ls.add('m');
		ls.add('n');
		ls.add('o');
		choices.put(6, new ArrayList<Character>(ls));
		ls.clear();
		//7
		ls.add('p');
		ls.add('q');
		ls.add('r');
		ls.add('s');
		choices.put(7, new ArrayList<Character>(ls));
		ls.clear();
		//8
		ls.add('t');
		ls.add('u');
		ls.add('v');
		choices.put(8, new ArrayList<Character>(ls));
		ls.clear();
		//9
		ls.add('w');
		ls.add('x');
		ls.add('y');
		ls.add('z');
		choices.put(9, new ArrayList<Character>(ls));
		ls.clear();
*/

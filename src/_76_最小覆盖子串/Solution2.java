package _76_��С�����Ӵ�;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
	/**
	 * self˼·2�����Լ���ʵ��˼·̫����..�ܶ�bug����Solution3��
	 * ˫ָ�롾WRONG.��л������ڣ���
	 * 1.��HashMap��t�������ַ������ִ���(map0)
	 * 2.˫ָ�룬һ��ʼ�ƶ���+��ָ�룬�ҵ���һ���Ϸ��ַ���֮���ƶ���ָ�룬ÿ���ƶ������ַ��Ƿ���map0�г��֣�������֣������map1��
	 * 3.���map1������map0����map1��map0��keyset��ͬ������map1��value���Ա�map2�󡿣����¼��ǰsize��Ȼ��ʼ�ƶ���ָ��
	 * 4.�����ָ���Ƴ���Ԫ����map1�У���Ҫ��map1�Ķ�ӦԪ����value-1���������value==0������Ҫ����ɾ����
	 * 5.��ÿ���Ƴ�Ԫ�غ������map1�޸��ˣ���Ҫ�ټ��map1�Ƿ��ܸ���map0��һ�����ܣ���ʼ�ƶ���ָ��
	 */
	public String minWindow(String s, String t) {
		Map<Character,Integer> map0 = new HashMap<>();
		for(int i=0;i<t.length();i++) {
			map0.put(t.charAt(i), map0.getOrDefault(t.charAt(i), 0)+1);
		}
		System.out.println("map0.size="+map0.size());
		Map<Character,Integer> map1 = new HashMap<>();
		int left = 0;
		while(!map0.containsKey(s.charAt(left))) {//��leftָ���һ���Ϸ��ַ�
			left++;
		}
		map1.put(s.charAt(left),1);
		int right = left+1;//��ʼ�ƶ�right����map1����map0�Ӷ�ʵ��match
		int start = 0;
		int end = 0;
		int minlen = Integer.MAX_VALUE;
		while(right<s.length()||left<right-t.length()) {
			while(check(map0,map1)) {//1.˵����ǰleft��right�Ӵ�������Ŀ���Ӵ��������ƶ���ָ��ֱ����match
				System.out.println("while check");
				//map1ÿ��ɾ��������ҲҪ����Ƿ񻹸��ǣ��������Ӧ�ó����޸�minlen
				if((right-left)<minlen) {
					start = left;
					end = right;
					minlen = end-start;
					System.out.println("start="+start+",end="+end+",minlen="+minlen);
				}
				if(map1.containsKey(s.charAt(left))) {
					map1.put(s.charAt(left), map1.get(s.charAt(left))-1);
					if(map1.get(s.charAt(left))==0) {
						map1.remove(s.charAt(left));
					}
				}
				left++;
			}
			//2.��ǰleft��right�Ӵ�δ����Ŀ���Ӵ��������ƶ���ָ�볢��match
			if(right<s.length()&&map0.containsKey(s.charAt(right))) {//����ǺϷ��ַ�������Ҫadd��map1
				map1.put(s.charAt(right), map1.getOrDefault(s.charAt(right),0)+1);
				System.out.println("map1����char="+s.charAt(right)+",������char��map1��value="+map1.get(s.charAt(right)));
				//ÿ�β����Ҫ����Ƿ񸲸���map0
				if(check(map0,map1)) {
					System.out.println("�����check");
					//�ɹ�match��������Ӵ����ȱ�minС�����¼�Ӵ�λ��start,end������minlen
					if((right-left)<minlen) {
						start = left;
						end = right;
						minlen = end-start;
						System.out.println("start="+start+",end="+end+",minlen="+minlen);
					}
				}
				right++;
			}
			else if(right<s.length()) {
				right++;
			}
		}
		return s.substring(start,end+1);
    }
	
	public boolean check(Map<Character,Integer> map0,Map<Character,Integer> map1) {
		//��IMP ATT:HashMap�ĵ�����������
		//��ATT 2.����hashmap�ĸ����жϣ���Ϊmap1Ҫ����map0�����Ե�������map0���map1�Ƿ�ȫ�У���
		for(Map.Entry<Character, Integer> a:map0.entrySet()) {
			if(map1.get(a.getKey())==null||map1.get(a.getKey())<a.getValue()) {//˵��û����
				return false;
			}
		}
		return true;
	}
}

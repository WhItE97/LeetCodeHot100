package _76_��С�����Ӵ�;

import java.util.Map;
import java.util.HashMap;
public class Solution3 {
	/**
	 * �ٷ����˼·��
	 * �ܣ���t��ÿ���ַ������ִ���д��һ��hashmap����s���л������ڣ�ÿ��s����char�����tmapҲ�еģ��������smap�����ڲ�����smap���и��Ǽ��check��
	 * һ��checkͨ��������Ҫ���볢�������Ӵ�����left��Ԫ��ɾ����left++����Ѱ�Ҹ����Ӵ��Ĺ��̡�
	 * 1.����resL��resR����¼�ҵ���match������Ӵ������±�
	 * 2.resL��resR��ʼ������-1������û�ҵ��Ļ������жϣ�����""
	 * 3.��ʹ��һ��left��right����¼��ǰ�ߵ��Ӵ�λ�ã���Ȼ��������Ϊright==s.length()
	 */
	public String minWindow(String s, String t) {
		int resL = -1;
		int resR = -1;
		int minlen = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		Map<Character,Integer> tmap = new HashMap<>();
		for(int i=0;i<t.length();i++) {
			tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0)+1);
		}
		Map<Character,Integer> smap = new HashMap<>();
		while(right<s.length()) {
			if(tmap.containsKey(s.charAt(right))) {//1.rightԪ�������t��һԱ����put��smap
				smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right),0)+1);
			}
			//2.smap��put�����ѭ��check�����Ҳ����right�󾡿��ܵ���̳���
			while(check(smap,tmap)&&left<=right) {
				//check�ϸ���left<=right������Ҫ��һ���жϵ�ǰ�Ӵ����Ⱥ���С�Ӵ����Ĺ�ϵ
				if((right-left+1)<minlen) {
					resL = left;
					resR =  right;
					minlen = resR-resL+1;
					System.out.println("resL="+resL+",resR="+resR+"���㣬��minlen="+minlen);
				}
				//���Խ�һ�������Ӵ����ȣ����̵�ʱ��Ҫ�жϵ�ǰ����leftλ��Ԫ���Ƿ�count����smap
				if(smap.containsKey(s.charAt(left))) {
					smap.put(s.charAt(left), smap.get(s.charAt(left))-1);
					if(smap.get(s.charAt(left))==0) {
						smap.remove(s.charAt(left));
					}
				}
				left++;
			}
			//3.��ǰleft��right�Ѿ������㸲����,�ƶ���ָ��
			right++;
		}
		return resL>=0?s.substring(resL,resR+1):"";
    }
	
	//Ҫ���tmap�Ƿ�ȫ���ǣ���Ȼsmap����tmap�����Ա���tmap�ж��Ƿ�smapȫ������
	public boolean check(Map<Character,Integer> smap,Map<Character,Integer> tmap) {
		for(Map.Entry<Character, Integer> a:tmap.entrySet()) {
			if(smap.get(a.getKey())==null||smap.get(a.getKey())<a.getValue()) {
				return false;
			}
		}
		return true;
	}
}

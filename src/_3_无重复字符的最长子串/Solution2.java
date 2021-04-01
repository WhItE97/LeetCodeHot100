package _3_���ظ��ַ�����Ӵ�;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Solution2 {
	/**
	 * �ٷ�˼·selfʵ�֣��������ڣ���10ms 30%..û�ԣ������������ϻ����б���ǰ�������е�����..��Solution3��
	 * 1.˼�룺
	 * ���ƶ��д洢��ǰ������->��������ظ��ģ��ͰѶ�ͷԪ�س��ӣ���������������У�����е���󳤶�
	 * 2.ʵ��
	 * HashMap��key=�ַ���value=�ϴγ��ֵ��±�
	 * 1.ÿ�μ���map������Ѿ����ֹ�->for����LinkedMap���ѳ��ֵ�λ�ú���֮ǰ�Ķ�ɾ����
	 * 2.ÿ���һ�ֲ����Ҫ�жϵ�ǰmap size��max�Ĵ�С��
	 */
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character,Integer> map = new LinkedHashMap<>();
		int max = 0;
		for(int i=0;i<s.length();i++) {
			char tmp = s.charAt(i);
			//�����ж�֮ǰ���ֹ�û��
			//1.���ֹ�����Ӷ�ͷ��������֮ǰ��Ԫ��ȫ������
			if(map.containsKey(tmp)) {
				//1.1.�Ȱ���֮ǰ�Ķ�ͷԪ�ض�����
				//��CORE.IIMMMPP WRONG.hashmapʹ��foreach������ʱ�򣬲���ɾ����ǰԪ�أ��ᶪʧ��һ��Ԫ�ص�ָ�룡�����������iterator������
				Iterator<Character> it = map.keySet().iterator();
				while(it.hasNext()) {
					if(it.next()==tmp) {
						break;
					}
					it.remove();//��CORE.iterator��ɾ��Ҳ������map��remove����Ҫ��iterator.remove()�������Զ�ɾ�����ֵģ�����
				}
				//1.2.�ٳ����Լ�
				map.remove(tmp);
			}
			//2.û���ֹ���ֱ�Ӽ���map��Ȼ������г��Ⱥ�max�Ĺ�ϵ
			map.put(tmp, i);
			max = (map.size()>max)?map.size():max;
		}
		return max;
    }
}

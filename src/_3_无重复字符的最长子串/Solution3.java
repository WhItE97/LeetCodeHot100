package _3_���ظ��ַ�����Ӵ�;

import java.util.Map;
import java.util.HashMap;

public class Solution3 {
	/**
	 * ����powcai��⣺��6ms 85%��
	 * 1.˼��
	 * �������ƶ��У�������ͷ��˼��
	 * 2.ʵ��
	 * ��ʵ���ϴ�ͬ����
	 * �Լ���˼·������ΪҪ����ǰ������������ظ�Ԫ��λ����������
	 * ���ڼ�Ȼ�Ƕ���˼�룬�ǾͲ�����LinkedHashMapȥ����ɾ����
	 * (1)֮������Mapʵ��Queueһ������Ϊ����Ҫ��׼��O��1�� search��key����ȷʵ��Solution1�����˼�ms��
	 * (2)����������map�����Բ�����ȫʵ��Queue�Ļ��ƣ���map��value����ҲҪ�����ϰ�����
	 * (3)��IIIIMMMPPP CORE�١���Ȼmap���ð���ɾ��ǰ���Ԫ�أ����Ӹ��Ӷȵ�POINT�����Ǿͱ�ɾ�ˣ�������>��һ��leftָ��ָ����ͷ���±꣡�������Ϳ��԰�O��N����ɾ����ΪO��1���Ķ�λ��
	 * ��IMP CORE�ڲ��ӱ���ɾ���Ѿ�����Ԫ���������ı׶ˡ�����ڱ��в鵽��key������Ҫ�жϸü�ֵ���Ƿ��Ѿ�ʧЧ�����Ѿ���left������е�ͷָ�����⣩������Ѿ��ڶ���ͷָ�����⣬left�������޸ģ�ֻ�õ����ֵ�key��һ�γ��֣�ֱ��put���ɣ�
	 * (4)ͬ���ģ�max�Ϳ����ã��²�����ַ��±�-left��ȥ��֮ǰ��maxȡmax���ɣ�
	 */
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int left = 0;
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			//���������ַ�
			char ch = s.charAt(i);
			//1.�ȼ���map֮���Ƿ����ظ���
			if(map.containsKey(ch)) {
				//1.1.������ظ���
				//1.1.1.�Ȱ�leftָ��ָ���ظ�λ�õĺ�һ��
				left = Math.max(left,map.get(ch)+1);//��HHHDDD WRONG POINT.����left��һ��ָ���ظ�λ�õĺ�һ�������ܸ�Ԫ�ص���һ���ظ��Ѿ��������ˣ����Ѿ���left֮����<=>�Ѿ������ˣ��͵��������ڣ�ֱ��put��ȥ������
				//1.1.2.�ٸ��¸��ַ���map�е��±�
				map.put(ch, i);
			}
			else {
				//1.2.���û���ظ���
				//1.2.1.���Ȱ��ַ����map
				map.put(ch,i);
			}
			//2.ÿ���ַ�����󣬸���max
			max = Math.max(max,i-left+1);
		}
		return max;
    }
}

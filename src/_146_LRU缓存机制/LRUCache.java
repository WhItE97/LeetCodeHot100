package _146_LRU�������;

import java.util.Map;
import java.util.HashMap;
public class LRUCache {
	/**
     * ���ٷ�˼· �ٷ�ʵ�� ������O(1) 19ms�� 
	 * 1.ʵ��O(1),����Ҫ����һ��head��tailָ���ܹ�ʵ��O(1)�Ĳ����ɾ����������ֱ�ӽ�Ԫ�ز嵽����ͷ&&ɾ������β��Ԫ�أ�
	 * 2.�����Ҫ����λ��,Ҫʵ��O(1),��������O(1)��������ԭ�ڵ㲢ɾ������>������Ҫhashmap����key��Ӧ�ڵ��ָ��
	 */
	class Node{
		Node pre;
		Node next;
		Integer key;
		Integer value;
		
		Node(){
			
		}
		
		Node(int key,int value){
			this.key = key;
			this.value = value;
		}
	}
	
	Map<Integer,Node> map;
	Node head;
	Node tail;
	int capacity;
	
    public LRUCache(int capacity) {
    	head = new Node();
    	tail = new Node();
    	head.next = tail;
    	tail.pre = head;
    	map = new HashMap<Integer,Node>();
    	this.capacity = capacity;
    }
    
    public int get(int key) {
    	//1.map���Ҳ�����key
    	if(!map.containsKey(key)) {
    		return -1;
    	}
    	else {//2.�ҵ���key,��Ҫ�ӽڵ���ȡ��value,�����ڵ�Ų������ͷ
    		Node node = map.get(key);
    		moveToHead(node);
    		return node.value;
    	}
    }
    
    public void put(int key, int value) {
    	//1.ԭmap���Ѿ����ڣ������value��Ų������ͷ
    	if(map.containsKey(key)) {
    		//1.1.����value
    		Node tmp = map.get(key);
    		tmp.value = value;
    		//1.2.����������λ��
    		moveToHead(tmp);
    	}
    	//2.ԭmap�в����ڣ���Ҫ����
    	else {
    		Node tmp = new Node(key,value);
    		//2.1.����map
    		map.put(key, tmp);
    		//2.2.����list
    		tmp.next = head.next;
    		tmp.pre = head;
    		head.next.pre = tmp;
    		head.next = tmp;
    		//2.3.�������map�Ƿ񳬹�������
    		if(map.size()>capacity) {
    			//(1)ɾ�����������һ��node
    			Node del = tail.pre;
    			removeNode(del);
    			//(2)ɾ��map�е�entry
    			map.remove(del.key);
    		}
    	}
    }
    
    //�ѽڵ�Ų������ͷ��
    public void moveToHead(Node node) {
    	//1.�Ƚ��ڵ�ӵ�ǰλ��ɾ��
    	removeNode(node);
    	//2.��ӵ�head����
    	node.next = head.next;
    	node.pre = head;
    	head.next.pre = node;
    	head.next = node;
    	
    }
    
    //ɾ���ýڵ�
    public void removeNode(Node node) {
    	node.pre.next = node.next;
    	node.next.pre = node.pre;
    }
}

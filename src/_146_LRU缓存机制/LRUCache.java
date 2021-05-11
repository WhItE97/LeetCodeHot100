package _146_LRU缓存机制;

import java.util.Map;
import java.util.HashMap;
public class LRUCache {
	/**
     * 【官方思路 官方实现 真正的O(1) 19ms】 
	 * 1.实现O(1),就需要保持一个head和tail指针能够实现O(1)的插入和删除！（便于直接将元素插到链表头&&删除链表尾部元素）
	 * 2.如果需要更新位置,要实现O(1),还面临着O(1)检索到该原节点并删除——>所以需要hashmap来存key对应节点的指针
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
    	//1.map中找不到该key
    	if(!map.containsKey(key)) {
    		return -1;
    	}
    	else {//2.找到该key,需要从节点中取出value,并将节点挪到链表头
    		Node node = map.get(key);
    		moveToHead(node);
    		return node.value;
    	}
    }
    
    public void put(int key, int value) {
    	//1.原map中已经存在，则更新value并挪到链表头
    	if(map.containsKey(key)) {
    		//1.1.更新value
    		Node tmp = map.get(key);
    		tmp.value = value;
    		//1.2.更新链表中位置
    		moveToHead(tmp);
    	}
    	//2.原map中不存在，需要插入
    	else {
    		Node tmp = new Node(key,value);
    		//2.1.插入map
    		map.put(key, tmp);
    		//2.2.插入list
    		tmp.next = head.next;
    		tmp.pre = head;
    		head.next.pre = tmp;
    		head.next = tmp;
    		//2.3.插入后检查map是否超过了容量
    		if(map.size()>capacity) {
    			//(1)删除链表中最后一个node
    			Node del = tail.pre;
    			removeNode(del);
    			//(2)删除map中的entry
    			map.remove(del.key);
    		}
    	}
    }
    
    //把节点挪到链表头部
    public void moveToHead(Node node) {
    	//1.先将节点从当前位置删除
    	removeNode(node);
    	//2.添加到head后面
    	node.next = head.next;
    	node.pre = head;
    	head.next.pre = node;
    	head.next = node;
    	
    }
    
    //删除该节点
    public void removeNode(Node node) {
    	node.pre.next = node.next;
    	node.next.pre = node.pre;
    }
}

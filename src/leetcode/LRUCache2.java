package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache2 {
	private int capacity;
	private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
	public LRUCache2(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	if(map.containsKey(key)){
    		Integer value = map.get(key); 
    		map.remove(key);
    		map.put(key, value);
    		return value;
    	}
        return -1;
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)){
    		map.remove(key);
    	}
    	else if(map.size()==capacity){
    		Iterator<Integer> itr = map.keySet().iterator();
    		map.remove(itr.next());
    	}
    	map.put(key, value);
    }
    public static void main(String[] args){
    	LRUCache2 lruCache = new LRUCache2(1);
    	lruCache.set(2, 1);
    	System.out.println(lruCache.get(3));
    }
}

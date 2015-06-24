package leetcode;

import java.util.ArrayList;

public class LRUCache {
	private int capacity;
	private ArrayList<int[]> lruList=new ArrayList<>();
	public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	int keyLocation;
    	int value;
        for(keyLocation=0;keyLocation<lruList.size();keyLocation++){
        	if(lruList.get(keyLocation)[0]==key){
        		value = lruList.get(keyLocation)[1];
        		adjust(keyLocation);
        		return value;
        	}
        }
        return -1;
    }
    
    public void set(int key, int value) {
        int keyLocation;
        for(keyLocation=0;keyLocation<lruList.size();keyLocation++){
        	if(lruList.get(keyLocation)[0]==key){
        		int[] element = new int[2];
        		element[0]=key;
        		element[1]=value;
        		lruList.set(keyLocation, element);
        		adjust(keyLocation);
        		return;
        	}
        }
        int[] element = new int[2];
        element[0]=key;
        element[1]=value;
        if(lruList.size()<this.capacity){
    		lruList.add(lruList.size(), element);
        }
        else{
        	lruList.set(0, element);
        	adjust(0);
        }
    }
    public void adjust(int keyLocation){
    	int[] element = lruList.get(keyLocation);
    	lruList.remove(keyLocation);
    	lruList.add(lruList.size(), element);
    }
    public static void main(String[] args){
    	LRUCache lruCache = new LRUCache(1);
    	lruCache.set(2, 1);
    	System.out.println(lruCache.get(3));
    }
}

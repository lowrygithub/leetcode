package leetcode;

import java.util.HashSet;

public class LeetCodeTest {
	public static void main(String[] args){
		HashSet<HashSet<Integer>> set1 = new HashSet<HashSet<Integer>>();
		HashSet<Integer> set11=new HashSet<Integer>();
		set11.add(1);
		HashSet<Integer> set12=new HashSet<Integer>();
		set12.add(2);
		set1.add(set11);
		set1.add(set12);
		HashSet<HashSet<Integer>> set2 = new HashSet<HashSet<Integer>>();
		HashSet<Integer> set21=new HashSet<Integer>();
		set21.add(1);
		HashSet<Integer> set22=new HashSet<Integer>();
		set22.add(2);
		set2.add(set21);
		set2.add(set22);
		System.out.println(set1.equals(set2));
	}
}

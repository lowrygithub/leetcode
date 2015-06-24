package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class test {
	public static void main(String[] args){
		Fuck f = new Fuck(0);
		
		List p =new LinkedList();
//		System.out.println(p.getClass().getPackage().getName());
//		System.out.println(p.getClass().getName());
//		System.out.println();
		Class class1 = null;
		Class class2 = null;
		
		try {
			class1 = Class.forName("java.util.List");
//			System.out.println(class1.getName());
			class2 = String.class;  
//	        System.out.println("Demo2:(写法2) 包名: " + class2.getPackage().getName() + "，"   
//	                + "完整类名: " + class2.getName());  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			class1 = Class.forName("java.util.LinkedList");
			List s = (LinkedList)class1.newInstance();
//			for (Method m : s.getClass().getDeclaredMethods()){
//				System.out.println(m);
//			}
			for(Class inter:s.getClass().getInterfaces()){
				System.out.println(inter);
			}
			System.out.println(s.getClass().getSuperclass());
			
			System.out.println(class1.getClassLoader());
			System.out.println(class1.getClassLoader().getClass());
			System.out.println(class1.getClassLoader().getClass().getName());
//			System.out.println();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

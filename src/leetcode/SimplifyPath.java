/**
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Hide Tags Stack String

 */
package leetcode;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
        String pathSplit[] = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<pathSplit.length;i++){
            if(pathSplit[i].equals(".."))
            {
            	System.out.println("..");
                if(!stack.empty())
                    stack.pop();
            }
            else if(!(pathSplit[i].equals(".")||pathSplit[i].equals("")))
                stack.push(pathSplit[i]);
        }
        String result = "";
        if(stack.empty()){
            result = "/";
        }
        else{
            while(!stack.empty()){
                result="/"+stack.pop()+result;
            }
        }
        return result;
    }
	public static void main(String[] args){
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/.."));
	}
}

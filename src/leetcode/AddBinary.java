package leetcode;
/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Hide Tags Math String

 * @author Lowry
 *
 */
public class AddBinary {
	public String addBinary(String a, String b) {
        if(a.length()<b.length()){
            String temp = b;
            b=a;
            a=temp;
        }
        while(b.length()<a.length())
            b="0"+b;
        int carry=0;
        String resultString = "";
        int current;
        for(int i=a.length()-1;i>=0;i--){
            int abit=a.charAt(i)-'0';
            int bbit=b.charAt(i)-'0';
            current = (abit+bbit+carry)%2;
            carry = (abit+bbit+carry)/2;
            resultString = current + resultString;
        }
        if(carry==1)
            resultString = carry + resultString;
        return resultString;
    }
}

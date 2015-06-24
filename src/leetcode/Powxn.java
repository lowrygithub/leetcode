package leetcode;
/**
 * Implement pow(x, n).

Hide Tags Math Binary Search

 * @author Lowry
 *
 */
public class Powxn {
    public double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        boolean isNeg = false;
        if(n<0){
            isNeg=true;
            n=-n;
        }
        double result=x;
        long i;
        for(i=1;(i<<1)<=n;i=(i<<1)){
            result=Math.pow(result,2);
        }
        result*=myPow(x, (int) (n-i));
        if(isNeg==true){
            result = 1.0/result;
        }
        return result;
    }
    public static void main(String[] args){
    	System.out.println(new Powxn().myPow(0.00001, 2147483647));//特殊用例，所以i必须为long类型
    }
}

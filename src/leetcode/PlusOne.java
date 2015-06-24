package leetcode;
/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Hide Tags Array Math

 * @author Lowry
 *
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
        for(int i=digits.length-1 ; i>=0 ; i--){
            digits[i] = digits[i]+1;
            if(digits[i]<10){
                return digits;
            }
            digits[i]=0;
        }
        int[] result = new int[digits.length+1];
        result[0]=1;
        return result;
    }
}

package leetcode;
/**
 * 
 * @author Lowry
 * �������⣺
 * 1��int���½�ȡ����Խ��
 * ���ۣ�
 * 1���˳���������λ�ķ���ʵ��
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		long divid=dividend,divis=divisor;//-2^31 ==��2^31 int �洢���ˣ�������long
        if(dividend<0)
        	divid = -divid;
        if(divisor<0)
        	divis = -divis;
        if(divis==0 || (dividend==Integer.MIN_VALUE && divisor==-1))
        	return Integer.MAX_VALUE;
        int result=0;
        while(divid>=divis){
        	int shift=0;
        	long tempDivis = divis;
        	while(divid>=tempDivis){
        		shift++;
        		tempDivis<<=1;
        	}
        	result+=(1<<(shift-1));
        	divid-=(tempDivis>>1);
        }
        return (dividend>0^divisor>0)?-result:result;
    }
	public static void main(String[] args){
		DivideTwoIntegers dti = new DivideTwoIntegers();
		System.out.println(dti.divide(-2147483648,1));
//		System.out.println(dti.divide(-1010369383,-2147483648));
	}
}

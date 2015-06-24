package leetcode;

public class ImplementstrStr {
	/**
	 * ±©Á¦±È½Ï£º  
	 * @param haystack
	 * @param needle
	 * @return
	 */
	/*public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        int result=-1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            int j;
            for(j=0;j<needle.length();j++){
                if(needle.charAt(j)!=haystack.charAt(i+j))
                    break;
            }
            if(j==needle.length()){
                result = i;
                break;
            }
        }
        return result;
    }*/
	
	/**
	 * KMP
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		int h = haystack.length();
		int n = needle.length();
		int[] nextArray = new int[n];
		if(n>=1)
			nextArray[0] = -1;
		if(n>=2){
			nextArray[1] = 0;
			int i=0,j=1;
			while(j+1<n){
				if(needle.charAt(i) == needle.charAt(j)){
					if(i == 0)
						nextArray[j+1] = 1;
					else
						nextArray[j+1] = nextArray[j]+1;
					i++;
					j++;
				}
				else{
					if(i==0){
						nextArray[j+1] = 0;
						j++;
					}
					else
						i=0;
				}
			}
		}
		
		int hPointer = 0;
		int nPointer = 0;
        while(hPointer<h && nPointer<n){
        	if(nPointer == -1||haystack.charAt(hPointer) == needle.charAt(nPointer)){
        		hPointer ++;
        		nPointer ++;
        	}
        	else{
        		nPointer = nextArray[nPointer];
        	}
        }
        if(nPointer == n){
        	return hPointer-nPointer;
        }
        else
        	return -1;
    }
	public static void main(String[] args){
		ImplementstrStr i = new ImplementstrStr();
		String haystack="babba";
		String needle="abcdabd";
		System.out.println(haystack.indexOf(needle));
		int result = i.strStr(haystack, needle);
		System.out.println(result);
	}
}

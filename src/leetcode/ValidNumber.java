/**
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
package leetcode;

public class ValidNumber {
	public static void main(String[] args){
		System.out.println(new ValidNumber().isNumber("0.5"));
	}
	public boolean isNumber(String s) {
		s = s.trim();
		if(s.equals(".")||s.equals("-.")||s.equals("+.")||s.startsWith(".e")||s.startsWith("+.e")||s.startsWith("-.e"))
			return false;
		char state = 'S';
		for(char ch: s.toCharArray()){
			switch(state){
				case 'S':
					if(ch>='0'&&ch<='9')
						state = 's';
					else if(ch=='.')
						state = 'f';
					else if(ch=='-'||ch =='+')
						state = 'N';
					else
						state = 'I';
					break;
				case 'N':
					if(ch>='0'&&ch<='9')
						state = 's';
					else if(ch=='.')
						state = 'f';
					else
						state = 'I';
					break;
				case 's':
					if(ch>='0'&&ch<='9'){}
					else if(ch=='.')
						state = 'f';
					else if(ch=='e')
						state = 'E';
					else 
						state = 'I';
					break;
/*				case 'F':
					if(ch>='0'&&ch<='9')
						state = 'f';
					else
						state = 'I';
					break;
*/				case 'f':
					if(ch>='0'&&ch<='9'){}
					else if(ch=='e')
						state = 'E';
					else
						state = 'I';
					break;
				case 'E':
					if(ch>='0'&&ch<='9')
						state = 'e';
					else if (ch == '-'||ch =='+')
						state = 'n';
					else
						state = 'I';
					break;
				case 'n':
					if(ch>='0'&&ch<='9')
						state = 'e';
					else
						state = 'I';
					break;
				case 'e':
					if(ch>='0'&&ch<='9'){}
					else
						state = 'I';
					break;
			}
		}
		if(state=='S' || state =='E'||state =='I'||state=='n'||state=='N')
			return false;
		else
			return true;
	}
}

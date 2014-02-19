package str2int;

public class Str2Int {

	public static int strToInt(String str){
		int MaxValue=Integer.MAX_VALUE;
		int MinValue=-Integer.MIN_VALUE;
		int result=0;
		char sign = '+';
		if (str!=null && str.length()>0) {
			char[] c =str.toCharArray();
			int i=0;
			while (isSpace(c[i])) {
				i++;	
			}
			if (c[i]=='+'||c[i]=='-') {
				sign=c[i++];
			}

			while(i<c.length && isDigit(c[i])){
				if (sign=='+' && (result>MaxValue/10 || c[i]-'0'>MaxValue-10*result)){
					return MaxValue;
				}
				if(sign=='-' && (-result<MinValue/10 || '0'-c[i]<MinValue+10*result) ){
					return MinValue;  
				}
				result = result*10+(c[i]-'0');
				i++;
			}
		}


		return sign=='+'?result:-result;


	}
	public static boolean isSpace(char c) {
		return  c==' '||c=='\n'||c=='\t';

	}
	public static boolean isDigit(char c) {
		return c>='0' && c<='9';

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="";
		str="	-0150 j";
		System.out.println(strToInt(str));

	}

}

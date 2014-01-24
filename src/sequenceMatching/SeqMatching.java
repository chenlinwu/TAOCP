package sequenceMatching;

public class SeqMatching {

	public static char[][] seqMatching(char[] input, char[] rule) {
		int l1 = input.length;
		int l2 = rule.length;
		if(l1<l2 || l2==0) return null;

		int[][] longestMatch= new int[l1+1][l2+1];

		for (int i = 0; i <= l1; i++) {
			longestMatch[i][0]=0;
		}
		for (int i = 1; i <= l2; i++) {
			for (int j = 0; j < i; j++) {

				longestMatch[j][i]=-1;
			}
		}

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= i&& j<=l2; j++) {

				if (rule[j-1]=='*') {
					if (longestMatch[i-1][j-1]==-1 && longestMatch[i-1][j]==-1) {
						longestMatch[i][j]=-1;
					}
					else {
						longestMatch[i][j]=Math.max(longestMatch[i-1][j],longestMatch[i-1][j-1])+1;
					}
							
				}
				else{
					if (longestMatch[i-1][j-1]==-1) {
						longestMatch[i][j]=-1;
					}
					else{
						if (rule[j-1]=='?' || rule[j-1]==input[i-1]) {
							longestMatch[i][j]=longestMatch[i-1][j-1]+1;
						}
						else {
							longestMatch[i][j]=-1;
						}
					}

				}

			}
		}
		
		int maxLen=0;
		int countResults=0;
		int[] begin = new int[l1/l2];
		char[][] result=new char[l1/l2][l1];

		for (int i = 1; i <= l1; i++) {
			if(longestMatch[i][l2]>maxLen){
				maxLen=longestMatch[i][l2];
				countResults=1;
				begin[0]=i-maxLen;
			}
			if(longestMatch[i][l2]==maxLen && i-maxLen>=begin[countResults-1]+maxLen){
				begin[countResults++]=i-maxLen;

			}	

		}
		for (int i = 0; i < countResults; i++) {
			for(int j=0; j<maxLen; j++){
				result[i][j]=input[begin[i]+j];
			}
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1= "breakfastfood";
		String s2="f?";
		char[] input= s1.toCharArray();
		char[] rule=s2.toCharArray();
		char[][] r=seqMatching(input,rule);
		
		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i]);

		}

	}

}

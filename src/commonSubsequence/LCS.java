package commonSubsequence;

public class LCS {

	public static boolean contains(String longS, String shortS) {
		int hash[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

		int numOfOnes = 0;

		for(int i=0;i<shortS.length();i++){
			if(hash[(int)shortS.charAt(i)-'A']==0){
				hash[(int)shortS.charAt(i)-'A']=1;
				numOfOnes++;
			}
		}
		for(int i=0; i<longS.length();i++){
			if(hash[(int)longS.charAt(i)-'A']==1){
				hash[(int)longS.charAt(i)-'A']=0;
				numOfOnes--;

				if(numOfOnes==0){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(contains("ABCDCEFGH","ADCCD"));

	}

}

package commonSubstring;

public class LCS {
	//if all characters in shortS appear in longS
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
	//best alg, with time(n+m), space O(1)
	
	public static boolean contains_2(String longS,String shortS)
	{
	    int hash = 0;
	    for (int i = 0; i < longS.length(); ++i)
	    {
	        hash |= (1 << (longS.charAt(i) - 'A'));//00000000..001 left shift 
	    }
	    for (int i = 0; i < shortS.length(); ++i)
	    {
	        if ((hash & (1 << (shortS.charAt(i) - 'A'))) == 0)
	        {
	            return false;
	        }
	    }
	    return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(contains("ABCDCEFGH","ADCCD"));
		System.out.println(contains_2("ABCDCEFGH","ADCCD"));
	}

}

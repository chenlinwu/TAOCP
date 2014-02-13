package longestCommonSeq;

public class LCS {

	public static String findLCS(String A, String B) {
		int[][] dPTable = new int[A.length()+1][B.length()+1];
		for (int i = 0; i < dPTable.length; i++) {
			for (int j = 0; j < dPTable[0].length; j++) {
				if (i==0|| j==0) {
					dPTable[i][j]=0;
					}
				else if (A.charAt(i-1)==B.charAt(j-1)) {
					dPTable[i][j] = dPTable[i-1][j-1]+1;
					
				}else {
					dPTable[i][j] = Math.max(dPTable[i-1][j], dPTable[i][j-1]);
				}
				
			}
			
		}
		
		String lcsString = "";
		int i = A.length();
		int j = B.length();
		while(i>0 && j>0){
			if (A.charAt(i-1)==B.charAt(j-1)) {
				lcsString+=A.charAt(i-1);
				i--;j--;
			}
			else if (dPTable[i-1][j]>=dPTable[i][j-1]) {
				i--;
			}
			else {
				j--;
			}
		}
		
		
		return new StringBuffer(lcsString).reverse().toString();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String a = "oewifnfn.abcd";
		String b = "oeifnabd";
		System.out.println(findLCS(a, b));
		
	}

}

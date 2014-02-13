package editDistance;

public class EditDist {
	private static final int match=0;
	private static final int replace=-1;	
	private static final int insert=-1;
	private static final int delete=-1;
//DP 
	public static int shortestEditDist(String dest, String src) {
		
		int distTable[][] = new int[src.length()+1][dest.length()+1];
		for (int i = 0; i < distTable.length; i++) {
			distTable[i][0]=-i;
		}
		for (int i = 0; i < distTable[0].length; i++) {
			distTable[0][i]=-i;
		}
		for (int i = 1; i < distTable.length; i++) {
			for (int j = 1; j < distTable[0].length; j++) {
				distTable[i][j]=Math.max(distTable[i-1][j-1]+(src.charAt(i-1)==dest.charAt(j-1)?match:replace), 
						Math.max(distTable[i-1][j]+delete,distTable[i][j-1]+insert));
			}
			
		}
		String modifiedString="";
		int i=src.length();
		int j=dest.length();
		while(i>0 && j>0){
			if (src.charAt(i-1)==dest.charAt(j-1)) {
				modifiedString+=src.charAt(i-1);
				i--;j--;
			}
			//insert ( )
			else if(distTable[i][j-1]==distTable[i][j]+1){
				modifiedString+=")"+dest.charAt(j-1)+"(";
				j--;
			}
			//replace -> <-
			else if (distTable[i-1][j-1]==distTable[i][j]+1) {
				modifiedString+="'"+dest.charAt(j-1)+"'";
				i--;j--;
			}
			//delete _
			else {
				modifiedString+="_";
				i--;
			}
			
		}
		if(i!=0) modifiedString+="_";
		if(j!=0) modifiedString+=")"+dest.charAt(0)+"(";
		System.out.println(src+" -> "+dest);
		System.out.println(new StringBuffer(modifiedString).reverse().toString());
		
		
		return -distTable[src.length()][dest.length()];
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String srcString = "TBGAT";
		String destString="ATBCA";
		System.out.println("shortestEditDist: "+shortestEditDist(destString, srcString));

	}

}

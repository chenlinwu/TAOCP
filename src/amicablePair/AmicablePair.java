package amicablePair;

public class AmicablePair {

    public static void findAmicablePair(int n){
    	int[] sumOfFactor=new int[n+1];
    	for(int i=0; i<=n;i++){
    		sumOfFactor[i]=1;
    	}
    	for(int factor=2; factor<=n/2;factor++){
    		int num=factor+factor;
    		while(num<=n){
    			sumOfFactor[num]+=factor;
    			num+=factor;
    		}
    	}
    	
    	for(int i=0; i<n;i++){
    		if(sumOfFactor[i]>i && sumOfFactor[i]<=n && sumOfFactor[sumOfFactor[i]]==i){
    			System.out.println(i+", "+sumOfFactor[i]);
    		}
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5000000;
		System.out.println("find amicalble pair under "+n+": ");
		findAmicablePair(n);

	}

}

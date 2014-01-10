package theEuclidsAlgo;

public class EuclidsAlgo {

	public static int greatestCommonDiviser(int m, int n) {
		int r=m%n;
		while(r!=0){
			m=n;
			n=r;
			r=m%n;
		}
		return n;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(greatestCommonDiviser(51,170));

	}

}

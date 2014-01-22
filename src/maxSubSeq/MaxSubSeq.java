package maxSubSeq;

import java.util.ArrayList;
import java.util.List;


public class MaxSubSeq {
	
	static List<Integer> subSeq=new ArrayList<Integer>();

	public static int findMaxSubSeq(int[] seq) {
		int a=0;
		int b=0;
		int sum=seq[0];
		boolean re=false;
		for (int i = 0; i < seq.length; i++) {
		
			if(a<0){
				a=seq[i];
				b=i;
				re=true;
			}
			else {
				a+=seq[i];
				
			}

			if(a>sum){
				sum=a;
				for(int j=b;j<=i;j++){
					if(re==true) {
						subSeq.clear();
						re=false;
					}
				    subSeq.add(seq[j]);
				}
				b=i+1;
			}
		}
		if (sum<=0) {
			for (int i = 0; i < seq.length; i++) {
				if(seq[i]>=sum) {
					sum=seq[i];
				subSeq.clear();
				subSeq.add(seq[i]);
				}
			}
		}
		return sum;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] s= {-20, -2,- 3,- 10, -4, -7,-2, -5
				};
		int maxSum=findMaxSubSeq(s);
		System.out.println(subSeq+"\n"+maxSum);// TODO Auto-generated method stub

	}

}

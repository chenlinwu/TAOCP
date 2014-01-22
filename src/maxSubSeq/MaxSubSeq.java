package maxSubSeq;

import java.util.ArrayList;
import java.util.List;


public class MaxSubSeq {

	static List<Integer> subSeq=new ArrayList<Integer>();

	
	static int MaxSubsequenceSum(int A[], int N)
	{
		int ThisSum, MaxSum;
		
		ThisSum = 0;
		MaxSum=A[0];
		/*for recording the subseq*/
		int j=0;
		boolean re=false;

		for (int i = 0; i < N; i++)
		{
			ThisSum += A[i];
			if (ThisSum > MaxSum){
				MaxSum = ThisSum;
				/*for recording the subseq	*/
				for(int k=j;k<=i;k++){
					if(re==true) {
						subSeq.clear();
						re=false;
					}
					subSeq.add(A[k]);
				}
				j=i+1;
				
			}
			else if (ThisSum < 0){
				ThisSum = 0;
				re=true;
				j=i+1;
			}

		}
		return MaxSum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] s= {-20, -2,- 3,10, -4, 7,2, -5
		};
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");

		}
		System.out.println();
		System.out.println(MaxSubsequenceSum(s, s.length)+"\t"+subSeq);
	}

}

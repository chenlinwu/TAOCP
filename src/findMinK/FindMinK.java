package findMinK;

import java.util.Arrays;
import java.util.Random;



public class FindMinK {

	private static int[] findMin(int[] A, int k){
		return randSelect(A,0,A.length-1,k-1);
	}
	private static int[] randSelect(int[] A, int begin, int end, int rank) {
		
		if(begin==end)
			return Arrays.copyOfRange(A, 0, end+1);
		Random rd = new Random(System.currentTimeMillis());
		int x=begin+rd.nextInt(end-begin+1);// get random integer from begin to end
		int temp = A[end];
		A[end]=A[x];
		A[x]=temp;
		int q= partition(A,begin,end);
		int k= q-begin;
		if(k==rank) return Arrays.copyOfRange(A, 0, q+1);
		else if(k>rank) return randSelect(A, begin, q-1, rank);
		else return randSelect(A,q+1,end,rank-1-k);
		
	}
	
	private static int partition(int[] A,int p, int r){
		int i=p-1;
		int j=p-1;
		do{
			j++;
			if (A[j]<A[r]){
				i++;
				int temp=A[i];//swap A[i],A[j]
				A[i]=A[j];
				A[j]=temp;		
			}
		}
		while (j<r-1);
		int temp=A[i+1];//swap A[i+1],A[r]
		A[i+1]=A[r];
		A[r]=temp;		
		return i+1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A={1,3,4,5,2,6,7};
		int[] B=findMin(A,6);
		for(int x:B){
		System.out.print(x+" ");
		}

	}

}

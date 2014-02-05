package binarySearch;

import java.util.Arrays;

public class BinarySearch {

	public static int BinSearch(int[] a, int k){
		int left=0;
		int right = a.length;

		while(left<right){
			int median = left+((right-left)>>1);

			if(k>a[median]){
				left = median+1;

			}else if(k<a[median]){
				right=median;
			}
			else return median;
		}

		return -1;



	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {3,6,8,9,20,-1,0,6};
		Arrays.sort(a);
		for (int i : a) {
			System.out.print(i+" ");
		}

		System.out.println("\n" +BinSearch(a, 9));

	}

}

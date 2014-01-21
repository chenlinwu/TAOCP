package lis;

public class bidirectionalLIS {

	private static int binSearchForLenOfIncrSeq(int[] seq,int len, int value ) {
		int left = 0;
		int right = len;
		while(left<=right){
			int mid = left+(right-left)/2;
			if(value>seq[mid]){
				left=mid+1;
			}
			else if(value<seq[mid]){
				right=mid-1;
			}
			else return mid;
		}
		return left;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr= {3,4,5,1,2,3};
		int n = arr.length;
		int[] subseqOfLen= new int[n];
		int[] forward= new int[n];
		int[] backward= new int[n];
		subseqOfLen[0]=arr[0];
		int len=0;
		forward[0]=1;
		for(int i =1; i<n; i++){
			int j=binSearchForLenOfIncrSeq(subseqOfLen, len, arr[i]);
			subseqOfLen[j]=arr[i];
			if(j>len) len=j;
			forward[i]=j+1;
		}
		subseqOfLen[0]=arr[n-1];
		len=0;
		backward[n-1]=1;
		for(int i=n-2;i>=0;i--){
			int j=binSearchForLenOfIncrSeq(subseqOfLen,len,arr[i]);
			subseqOfLen[j]=arr[i];
			if(j>len) len=j;
			backward[i]=j+1;
		}
		
		int max=0;
		int pivot=-1;
		for(int i =0; i<n; i++){
			if(forward[i]+backward[i]>max){
				max=forward[i]+backward[i];
				pivot=i;
			}
		}
		System.out.println("with pivot at index "+pivot+" , remove at least "+(n-max+1)+" number(s)");
		
		
		
	}

}

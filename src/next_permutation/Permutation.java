package next_permutation;




public class Permutation {

	public static int countAllPermutation(int[] perm) {
		 if (perm.length < 1)
		        return 0;
		 int count=1;
		    while (true)
		    {
		        int i;
		        for (i = perm.length - 2; i >= 0; --i)
		        {
		            if (perm[i] < perm[i + 1])
		                break;
		        }

		        if (i < 0)
		            break;  // found all;

		        int k;
		        for (k = perm.length - 1; k > i; --k)
		        {
		            if (perm[k] > perm[i])
		                break;
		        }
		        int temp=perm[i];
		        perm[i]=perm[k];
		        perm[k]=temp;
		        
		        for(int j=0;j<(perm.length-i)/2;j++ ){
		        	 int temp2=perm[i+1+j];
				        perm[i+1+j]=perm[perm.length-j-1];
				        perm[perm.length-j-1]=temp2;
		        }
		        
		        for (int j = 0; j < perm.length; j++) {
		        	System.out.print(perm[j]+" ");
				}
		        System.out.println();
		        count++;
		    }
		    return count;

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a={1,2,3,4};
		char a1='a';
		int b=a[a1];
		System.out.println(b);
		System.out.println(countAllPermutation(a));



	}

}

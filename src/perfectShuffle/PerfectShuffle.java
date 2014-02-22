package perfectShuffle;

public class PerfectShuffle {

	public static void perfectShuffle(int[] a,int start, int end) {
		int n=end-start,m,k,begin=start;
		while(n>1){
			for (m=1,k=0; m<=n+1 ;k++, m*=3) {
			}
			k--;
			m = (m/3-1)/2;

			rightRotate(a, begin+m, (n+1)/2-m, m);
			//first part: 0~2m-1
			for (int i = 0,cycleHead=1; i < k; i++,cycleHead*=3) {
				int t=a[begin+cycleHead-1];
				for (int j = cycleHead*2%(2*m+1); j !=cycleHead; j=j*2%(2*m+1)) {
					int temp = t;
					t=a[j+begin-1];
					a[j+begin-1]=temp;
				}
				a[begin+cycleHead-1] = t;


			}
			begin+=2*m;
			n-=2*m;
		}
		if(n==1){
			int temp = a[begin];
			a[begin]=a[begin+1];
			a[begin+1]=temp;
		}

	}







	public PerfectShuffle() {
		// TODO Auto-generated constructor stub



		// TODO Auto-generated constructor stub
	}
	//right rotate len number of elements
	public static void rightRotate(int[] a,int from, int len,int shift) {
		reverse(a, from, from+len);
		reverse(a, from+len, from+len+shift);
		reverse(a, from, from+len+shift);


	}
	public static void reverse(int[] a, int begin, int end) {
		int b=begin, e=end;
		for(;b<e;b++,e--){
			int t=a[b];
			a[b]=a[e-1];
			a[e-1]=t;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1,2,3,4,5,6,7,8,9,10,11,12};
		perfectShuffle(a,1,11);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

}

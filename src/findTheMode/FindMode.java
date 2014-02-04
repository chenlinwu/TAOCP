package findTheMode;

public class FindMode {
	
//find the number that appears more than (or equal to)half the time.
	
	final static private int NOT_FOUND = -1;
	public static int FindTheMode(int[] a) {
		int count = 0;
		int candidate=NOT_FOUND;
		for (int i : a) {
			if (count++==0){
				candidate=i;
			}
			else if (candidate==i) {
				count++;
			}
			else {
				count--;
			}
		}
		//varify
		int count1,count2;
		count1=count2=0;
		int candidate2 = a[a.length-2];
		for (int i : a) {
			if (i==candidate) {
				count1++;
			}
			if (i==candidate2) {
				count2++;
			}
		}
		if (count1*2>=a.length) {
			return candidate;
		}
		else if (count2*2>=a.length) {
			return candidate2;
		}
		return NOT_FOUND;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] a = {1,3,0,0,3,3,3,5};
		System.out.println(FindTheMode(a));

	}

}

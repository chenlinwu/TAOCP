package randomPick;

import java.util.Random;

public class RandomPick {
	public static final int NO_INT = -1;
//randomly pick an element in an array 
	public static int PickRandomly(int[] a ) {
		int resultInt = NO_INT;
		for (int i = 0; i < a.length; i++) {
			int randInt = new Random().nextInt();
			if (randInt%(i+1)==0) {
				resultInt=a[i];
			}
		}
		return resultInt;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {0, 9, 1};
		double count0 = 0;
		double count9 = 0;
		double count1 = 0;
		int N=100000;
		for (int i = 0; i < N; i++) {
			switch (PickRandomly(a)) {
			case 0: count0++;
				break;
			case 1: count1++;break;
			case 9: count9++;break;
			default:
				break;
			}
		}
		System.out.println(count0/N+" "+count1/N+" "+count9/N);

	}

}

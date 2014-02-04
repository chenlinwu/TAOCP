package youngTableau;

import java.awt.Point;

public class YoungTableau {
	
	private static final int NOT_FOUND=-1;;
	//find x in a YOUNGTABLEAU a
	public static Point find(int[][] a,int x) {
		int i = a.length-1;
		int j = 0;
		while (i>=0 && j<a[1].length) {
			if (a[j][i]==x) {
				return new Point(i,j);
			}
			else if (a[j][i]>x) {
				i--;
			}
			else {
				j++;
			}
		}
		return new Point(NOT_FOUND,NOT_FOUND);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a={{3,6,8,9,30},
				{4,7,10,12,31},
				{11,16,13,20,32},
				{34,17,22,24,50}};
		System.out.println(find(a, 13));
		

	}

}

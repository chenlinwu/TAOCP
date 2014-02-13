package maxProd;

public class maxProduct {

	public static double findMaxProduct(double[] a) {
		double thisMax=a[0];
		double thisMin=a[0];
		double maxProd=a[0];

		for (int i = 0; i < a.length; i++) {
			thisMax*=a[i];
			thisMin*=a[i];
			if (thisMax<thisMin) { 
				double t=thisMin;
				thisMin=thisMax;
				thisMax=t;
			}
			if(thisMax>maxProd) {
				maxProd=thisMax;
			}
		
			if (thisMax<1) {thisMax=1;}
			
		}
		return maxProd;
		// TODO Auto-generated constructor stub
	}
	//dP alg
	public static double findMaxProductByDP(double[] a) {
		double[] maxA= new double[a.length];
		double[] minA= new double[a.length];
		maxA[0]=minA[0]=a[0];
		double maxValue=a[0];
		for (int i = 1; i < a.length; i++) {
			maxA[i]=Math.max(Math.max(a[i], maxA[i-1]*a[i]),minA[i-1]*a[i]);
			minA[i]=Math.min(Math.min(a[i], minA[i-1]*a[i]), maxA[i-1]*a[i]);
			maxValue=Math.max(maxValue, maxA[i]);
		}
		return maxValue;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] a={-0.5,0.4,-0.3,0.5,0.8,-0.1,-0.1,0.20};
		System.out.println(findMaxProduct(a));
		System.out.println(findMaxProductByDP(a));
	}

}

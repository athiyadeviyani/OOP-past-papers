import java.util.Arrays;

public class Inequalities {

	public static int dotProduct(int[] a, int[] b) {
		
		int result = 0;
		
		if (a.length != b.length) {
			return 0;
		}
		
		for (int i = 0; i < a.length; i++) {
			int product = a[i] * b[i];
			result += product;
		}
		
		return result;
	}
	
	public static int[] concatenate(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		
		for (int i = 0; i < b.length; i++) {
			c[i + a.length] = b[i];
		}
		
		return c;
	}
	
	public static boolean cs(int[] a, int[] b) {
		boolean one = a.length == b.length;
		double lhs = Math.pow(dotProduct(a,b), 2);
		double rhs = (dotProduct(a,a) * dotProduct(b,b));
		boolean two = lhs <= rhs;
		
		return one && two;
	}
	
	public static boolean amgm(int[] a) {
		int sum = 0;
		int n = a.length;
		
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		
		double arithmeticMean = sum / n;
		
		int product = 0;
		for (int i = 0; i < a.length; i++) {
			product = product * a[i];
		}
		
		double geometricMean = Math.pow(product, 1/n);
		
		return arithmeticMean >= geometricMean;
	}
	
	
	public static void main(String[] args) {
		
//		// test dotProduct
//		int[] a = {2,1};
//		int[] b = {3,4};
//		
//		System.out.println(dotProduct(a,b));
//		
//		// test concatenate
//		int[] c = {5,6};
//		int[] d = {1,2,3};
//		
//		System.out.println(Arrays.toString(concatenate(c,d)));
//		
//		// test cs 
//		System.out.println(cs(a,b));
//		
//		// test amgm
//		int[] e = {4,9};
//		System.out.println(amgm(e));
		
		int[] a = new int[(args.length - 1)/2];
		int[] b = new int[(args.length - 1)/2];
		int n = Integer.parseInt(args[0]);
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(args[i+1]);
		}
		
		for (int i = 0; i < n; i++ ) {
			b[i] = Integer.parseInt(args[i+1+n]);
		}
		
		System.out.println("CS held: " + cs(a,b));
		System.out.println("AMGM held: " + amgm(concatenate(a,b)));		
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
		
	}
	
	
}

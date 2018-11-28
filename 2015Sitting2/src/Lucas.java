import java.util.Arrays;

public class Lucas {
	
	private static long[] lucas;
	private static double phiPlus = (Math.sqrt(5) + 1) / 2; 
	private static double phiMinus = (Math.sqrt(5) - 1) / 2; 

	public static void upto(int n) {
		lucas = new long[n];
		lucas[0] = 2L;
		lucas[1] = 1L;
		
		if ( n > 2 ) {
			for ( int i = 2; i < n; i++ ) {
				lucas[i] = lucas[i-1] + lucas[i-2];
			}
		}
//		System.out.println(Arrays.toString(lucas));
	}
	
	
	public static boolean isPrime(long n) {
		for (int i = 2; i < n; i++) {
			if ((n % i) == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void primes() {
		for (int i = 0; i < lucas.length; i++) {
			if (isPrime(lucas[i])) {
				System.out.println("L("+i+")="+lucas[i]);
			}
		}
	}
	
	public static double maxDiffClosedForm() {
		double maximum = 0;
//		double[] closed = new double[lucas.length];
//		for (int i = 0; i < lucas.length; i++) {
//			closed[i] = Math.pow(phiPlus, i) + Math.pow(-1 * phiMinus, i);
//		}
//		
//		for (int i = 0; i < lucas.length; i++) {
//			double n = Math.abs(lucas[i] - closed[i]);
//			if (n > maximum) {
//				maximum = n;
//			}
//		}
//		
//		return maximum;
		
		for ( int i = 0; i < lucas.length; i++) {
			double n = Math.pow(phiPlus, i) + Math.pow(-phiMinus, i);
			double difference = Math.abs(lucas[i] - n);
			if (difference > maximum) {
				maximum = difference;
			}
		}
		
		return maximum;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		if (n>=2 && n<=42) {
			upto(n);
			primes();
			System.out.println(String.format("%.15f", maxDiffClosedForm()));
		}
	}
	
}

import java.util.Arrays;

public class ComplexNumbers {

	public static double[] complexAdd(double[] z1, double[] z2) {
		double[] result = new double[z1.length];
		for (int i = 0; i < z1.length; i++) {
			result[i] = z1[i] + z2[i];
		}

		return result;
	}

	public static double[] complexConjugate(double[] z) {
		double[] result = new double[z.length];
		if (z[1] != 0.0) {
			result[0] = z[0];
			result[1] = -1 * z[1];
		} else {
			result[0] = z[0];
			result[1] = z[1];
		}

		return result;
	}
	
	public static double[] complexMultiply(double[] z1, double[] z2) {
		double[] result = new double[z1.length];
		result[0] = z1[0]*z2[0] - z1[1]*z2[1];
		result[1] = z1[1]*z2[0] + z1[0]*z2[1];
		return result;
	}

	public static double[] complexReciprocal(double[] z) {
		double[] result = new double[z.length];
		result[0] = z[0] / (z[0]*z[0] + z[1]*z[1]);
		result[1] = -1 * z[1] / (z[0]*z[0] + z[1]*z[1]);
		return result;
	}
	
	public static String toString(double[] z) {
		String s = "";
		if (z[1] == 0 && z[0] == 0) {
			s = "0.0";
		} else if (z[0] == 0) {
			s = String.format("%.1fi", z[1]);
		} else if (z[1] == 0) {
			s = String.format("%.1f", z[0]);
		} else if (z[1] > 0) {
			s = String.format("%.1f+%.1fi", z[0], z[1]);
		} else if (z[1] < 0) {
			s = String.format("%.1f%.1fi", z[0], z[1]);
		}
		return s;
	}
	
	public static double complexMagnitude(double[] z) {
		double magnitude = Math.sqrt(z[0]*z[0] + z[1]*z[1]);
		return magnitude;
	}
	
	public static double[][] sortByMagnitude(double[][] complexList) {
		Arrays.sort(complexList, (z1,z2) -> Double.compare(complexMagnitude(z1), complexMagnitude(z2)));
		return complexList;
	}
	
	public static void main(String[] args) {

//		// test complexAdd
//		double[] a = { 1.0, 2.0 };
//		double[] b = { 3.0, 4.0 };
//		System.out.println(Arrays.toString(complexAdd(a, b)));
//
//		// test complexConjugate
//		double[] c = { 2.0, 0.0 };
//		System.out.println(Arrays.toString(complexConjugate(c)));
//		System.out.println(Arrays.toString(complexConjugate(a)));
//		
//		// test complexMultiply
//		System.out.println(Arrays.toString(complexMultiply(a,b)));
//
//		// test complexReciprocal
//		System.out.println(Arrays.toString(complexReciprocal(a)));
//		
//		// test toString
//		double[] d = {5.6666,-7.12};
//		double[] e = {-3.355,-1.0};
//		double[] f = {-1.0,0.0};
//		double[] g = {0.0,-3.45};
//		double[] h = {0.0,0.0};
//		System.out.println(toString(a));
//		System.out.println(toString(d));
//		System.out.println(toString(e));
//		System.out.println(toString(f));
//		System.out.println(toString(g));
//		System.out.println(toString(h));
//		
//		// test sortByMagnitude
//		double[][] i = {{5.0,-2.0},{1.0,2.0},{0.0,0.0}};
//		for (double[] array : sortByMagnitude(i)) {
//			System.out.println(Arrays.toString(array));
//		}
		
		double[] z1 = new double[2];
		double[] z2 = new double[2];
		
		for (int i = 0; i < 2; i++) {
			z1[i] = Double.parseDouble(args[i]);
		}
		
		for (int i = 0; i < 2; i++) {
			z2[i] = Double.parseDouble(args[i + 2]);
		}
		
		System.out.println(toString(complexAdd(z1,z2)));
		System.out.println(toString(complexConjugate(z1)));
		System.out.println(toString(complexMultiply(z1,z2)));
		System.out.println(toString(complexReciprocal(z1)));
		System.out.println(toString(complexConjugate(complexAdd(z1,z2))));
	}

}

import java.util.Arrays;

public class Rearrangement {

	public static int dotWith(int[] a, int[] b) {
		if (a.length != b.length) {
			return 0;
		}
		
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			int product = a[i] * b[i];
			sum = sum + product;
		}
		
		return sum;
	}
	
	public static void rotate(int[] b) {
		int temp = b[b.length - 1];
		for (int i = b.length - 1 ; i > 0; i--) {
			b[i] = b[i - 1];
		}
		b[0] = temp;
	}
	
	public static int[] rotateStored(int[] b) {
		int[] result = new int[b.length];
		int temp = b[b.length - 1];
		for (int i = b.length - 1 ; i > 0; i--) {
			result[i] = b[i - 1];
		}
		result[0] = temp;
		
		return result;
	}
	
	public static int useRotations(int[] a, int[] b) {
		if (a.length != b.length) {
			return 0;
		}
		
		
		int[] rotated = new int[b.length];
		rotated = b;
		int max = dotWith(a,b);
		
		for (int i = 1; i < b.length; i++) {
			rotated = rotateStored(rotated);
			int dot = dotWith(a,rotated);
			if (dot > max) {
				max = dot;
			}
		}
		
		return max;
	}
	
	public static int useSorted(int[] a, int[] b) {
		
		if (a.length != b.length) {
			return 0;
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
		
		return dotWith(a,b);
		
		
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] a = new int[n];
		int[] b = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(args[i + 1]);
		}
		
	//	System.out.println(Arrays.toString(a));
		
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(args[i + 1 + n]);
		}
		
	//	System.out.println(Arrays.toString(b));
		
		System.out.println("dotWith gave: " + dotWith(a,b));
		System.out.println("useRotations gave: " + useRotations(a,b));
		System.out.println("useSorted gave: " + useSorted(a,b));
	}
}

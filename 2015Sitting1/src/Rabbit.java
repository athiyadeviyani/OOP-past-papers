import java.util.Arrays;
import java.util.Collections;

public class Rabbit {
	
	private Integer[][] r;
	private int n;
	
	public Rabbit(int n) {
		this.n = n;
		r = new Integer[n][];
	}
	
	public void init() {
		if (n >= 2) {
//			r[0] = new Integer[1];
//			r[1] = new Integer[2];
//			r[0][0] = 1;
//			r[1][0] = 1;
//			r[1][1] = 0;
			
			r[0] = new Integer[] {1};
			r[1] = new Integer[] {1,0};
			
			for (int i = 2; i < n; i++) {
				int x = r[i-1].length;
				int y = r[i-2].length;
				
				r[i] = new Integer[x+y];
				
				// use two arraycopies
//				Copies an array from the specified source array, beginning at the specified position, 
//				to the specified position of the destination array. A subsequence of array components are copied 
//				from the source array referenced by src to the destination array referenced by dest. 
//				The number of components copied is equal to the length argument. 
//				The components at positions srcPos through srcPos+length-1 in the source array are copied into positions 
//				destPos through destPos+length-1, respectively, of the destination array. 
				
				System.arraycopy(r[i-1], 0, r[i], 0, r[i-1].length); // first part [x,_,_]
				System.arraycopy(r[i-2], 0, r[i], r[i-1].length, r[i-2].length); // second part [_,x,x]
//				
//				System.out.println(Arrays.toString(r[i]));

			}
		}
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < n; i++) {
			s = s + Arrays.toString(r[i]) +"\n";
		}
		return s;
	}
	
	public int subsequenceIndex(Integer[] target) {
		return Collections.indexOfSubList(Arrays.asList(r[n-1]), Arrays.asList(target));
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		if (n >= 2) {
			Rabbit test = new Rabbit(n);
			test.init();
			System.out.print(test.toString());
			System.out.println(test.subsequenceIndex(new Integer[] {1,1,0}));
			System.out.println(test.subsequenceIndex(new Integer[] {1,1,1}));
		}
	}
}

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class Divergence {

	public static int[] charCount(String s) {
		if (s.equals(null) || s.isEmpty()) {
			return null;
		}

		char[] cs = s.toCharArray();
		Arrays.sort(cs);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : cs) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);

		}

		int[] result = new int[map.size()];
		int i = 0;
		for (Integer n : map.values()) {
			result[i] = n;
			i++;
		}

		return result;
	}

	public static double[] normalise(int[] c) {
		double[] p = new double[c.length];
		int sum = 0;

		for (int i = 0; i < c.length; i++) {
			sum += c[i];
		}

		for (int i = 0; i < c.length; i++) {
			p[i] = (double) c[i] / sum;
		}

		return p;
	}

	public static double kld(double[] p, double[] q) {
		double result = 0;
		for (int i = 0; i < q.length; i++) {

			result += p[i] * Math.log(p[i] / q[i]);

		}
		return result;
	}
	
	public static int[][] charCountArray(String[] a) {
		Hashtable<Character, Integer> unique = new Hashtable<Character, Integer>();
		// count all character occurrences in all strings to determine unique characters
		for (int sIdx = 0; sIdx < a.length; sIdx++) {
			// where sIdx is string index
			String s = a[sIdx];
			while (s.length() > 0) {
				char c = s.charAt(0);
				if (!unique.containsKey(c)) {
					unique.put(c, 0);
				}
				unique.put(c, unique.get(c) + 1);
				
				// remove remaining characters from s so we only consider them once per string
				s = s.replaceAll("" + c, "");
			}
		}
		
		// if a character in unique is associated with a 1, it is actually unique in the entire input set
		
		int[][] output = new int[a.length][];
		for (int sIdx = 0; sIdx < a.length; sIdx++) {
			char[] charArray = a[sIdx].toCharArray();
			Arrays.sort(charArray);
			
			ArrayList<Integer> outCount = new ArrayList<Integer>();
			Character current = null;
			int count = 0;
			for (int cIdx = 0; cIdx < charArray.length; cIdx++) {
				// cIdx is character index
				if(current == null) {
					current = charArray[cIdx];
					count = 1;
				} else if (charArray[cIdx] != current) { // changing character
					if (unique.get(current) == 1) { // output if unique
						outCount.add(count);
					}
					current = charArray[cIdx];
					count = 1;
				} else {
					count++;
				}
			}
			
			// don't forget the last
			
			if (unique.get(current) == 1) {
				outCount.add(count);
			}
			output[sIdx] = new int[outCount.size()];
			for (int i = 0; i < outCount.size(); i++) {
				output[sIdx][i] = outCount.get(i);
			}
			
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(charCount(args[0])));
		System.out.println(Arrays.toString(normalise(charCount(args[0]))));
		System.out.println(Arrays.toString(normalise(charCount(args[1]))));
		
		String[] a = new String[args.length];
		for (int i = 0; i < args.length; i++) {
			a[i] = args[i];
		}
		int[][] counted = charCountArray(a);
		for (int[] c : counted) {
			System.out.println(Arrays.toString(c));
		}
		

		
		
	}
}

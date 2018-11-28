import java.util.ArrayList;
import java.util.Arrays;

public class Question1 {
	
	public static ArrayList<Integer> cayley() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				if (i*10 + j == i*j + i+j) {
					result.add(i*10 + j);
				}
			}
		}
		
//		System.out.println(Arrays.toString(result.toArray()));
		return result;
	}
	
	public static boolean isVowel(char c) {
		boolean a = c == 'a' || c == 'A';
		boolean e = c == 'e' || c == 'E';
		boolean i = c == 'i' || c == 'I';
		boolean o = c == 'o' || c == 'O';
		boolean u = c == 'u' || c == 'U';
		
		return a || e || i || o || u;
		
	}
	public static int[] countVowels(String[] strings) {
		int[] result = new int[strings.length];

		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings[i].length(); j++) {
				if (isVowel(strings[i].charAt(j))) {
					result[i]++;
				}
			}
		}
		
	//	System.out.println(Arrays.toString(result));
		return result;
	}
	
	public static int countVowels2(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (isVowel(s.charAt(i))) {
				count++;
			}
		}
		return count;
	}
	
	public static String mostVowels(String[] strings) {
		if (strings == null) {
			return "";
		}
		
		String result = "";
		int max = 0;
		for (String s : strings) {
			if (countVowels2(s) > max) {
				max = countVowels2(s);
				result = s;
			}
		}
		
//		System.out.println(result);
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(cayley().toArray()));
		String[] a = new String[args.length];
	//	String[] b = {"HELLO", "world"};
		for (int i = 0; i < args.length; i++) {
			a[i] = args[i];
		}
		
	//	System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(countVowels(a)));
		System.out.println(mostVowels(a));
		

	}
}

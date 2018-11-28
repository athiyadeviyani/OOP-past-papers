import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Beads {

	public static Set<Integer> sums(ArrayList<Integer> beads, int n) {
 		Set<Integer> resultSet = new HashSet<Integer>();
		
		if (n < 1 || beads.isEmpty()) {
			return new HashSet<Integer>();
		}
		
		for (int i = 0; i < beads.size(); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += beads.get((i+j)%beads.size());
			}
			resultSet.add(sum);
		}
		
		return resultSet;
	}
	
	public static Set<Integer> allSums(ArrayList<Integer> a) {
		Set<Integer> resultSet = new HashSet<Integer>();
		for (int j = 0; j <= a.size(); j++) {
			Set<Integer> jSum = sums(a,j);
			for (Integer s : jSum) {
				resultSet.add(s);
			}
		}
		
		return resultSet;
	}
	
	public static int findMax(Set<Integer> set) {
		
		ArrayList<Integer> setTwo = new ArrayList<Integer>(set);
		
		int max = 0;
		
		if (!setTwo.contains(1)) {
			max = 0;
		}
		
		for (int i = 0; i < set.size() - 1; i++) {
			if (setTwo.get(i + 1) != (setTwo.get(i) + 1)) {
				max = setTwo.get(i);
				break;
			}
				else if (setTwo.get(i + 1) > max) {
					max = setTwo.get(i + 1);
				}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> beads = new ArrayList<Integer>();
		for (int i = 0; i < args.length; i++) {
			beads.add(Integer.parseInt(args[i]));
		}
		
	//	int n = args.length;
		
//		for (Integer i  : allSums(beads)) {
//			System.out.println(i);
//		}
		
		Set<Integer> allTheSums = allSums(beads);
		System.out.print(findMax(allTheSums));
		
//		ArrayList<Integer> beads = new ArrayList<Integer>();
//		beads.add(1);
//		beads.add(2);
//		beads.add(3);
//		beads.add(4);
//	//	beads.add(5);
//////		int n = 2;
//////		
//		for (Integer i  : sums(beads, 2)) {
//			System.out.println(i);
//		}
//		
//		System.out.println("--");
////		
//		for (Integer i  : allSums(beads)) {
//			System.out.println(i);
//		}
//		
//		Set<Integer> set = new HashSet<Integer>();
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		set.add(4);
//		set.add(5);
//		set.add(6);
//		set.add(7);
//		//set.add(9);
//	//	set.add(10);
//		
//		System.out.println(findMax(set));
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Fermat {

	public static Set<ArrayList<String>> threadings(int n, Set<String> beads) {
		// n is the number of beads on each necklace
		// beads is the available bead colours
		// Necklaces<Necklace<Bead>>

		Set<ArrayList<String>> necklaces = new HashSet<ArrayList<String>>();

		if (n < 1) {
			return new HashSet<>();
		}

		for (String firstBead : beads) {
			if (n == 1) {
				ArrayList<String> necklace = new ArrayList<String>();
				necklace.add(firstBead);
				necklaces.add(necklace);
			}

			for (ArrayList<String> theRestOfTheBeads : threadings(n - 1, beads)) {
				ArrayList<String> necklace = new ArrayList<String>();
				necklace.add(firstBead);
				necklace.addAll(theRestOfTheBeads);
				necklaces.add(necklace);
			}
		}

		return necklaces;
	}

	public static boolean isEquiv(ArrayList<String> necklace1, ArrayList<String> necklace2) {
		// rotate then reverse
		ArrayList<String> rotated = new ArrayList<String>();

		rotated.addAll(necklace1);
		boolean rotateYes = false;
		boolean reverseYes = false;

		if (necklace1.equals(necklace2)) {
			return true;
		}

		for (int i = 0; i < necklace1.size(); i++) {

			if (!rotated.equals(necklace2)) {
				Collections.rotate(rotated, i);
				if (rotated.equals(necklace2)) {
					rotateYes = true;
				} else {
					Collections.reverse(rotated);
					if (rotated.equals(necklace2)) {
						reverseYes = true;
					}
				}

			}
		}

		return rotateYes || reverseYes;
	}

	public static void analyse(Set<ArrayList<String>> s) {

		Set<ArrayList<String>> singletons = new HashSet<ArrayList<String>>(s);
		ArrayList<ArrayList<String>> necklace = new ArrayList<ArrayList<String>>(s);

		for (int i = 0; i < necklace.size(); i++) {
			for (int j = 0; j < necklace.size(); j++) {
				if (i != j) {
					if (isEquiv(necklace.get(i), necklace.get(j))) {
						singletons.remove(necklace.get(i));
					}
				}
			}
		}

		for (ArrayList<String> a : singletons) {
			System.out.println(Arrays.toString(a.toArray()) + " is a singleton");
		}
	}

	public static void main(String[] args) {
//		Set<String> beads = new HashSet<String>();
//		beads.add("red");
//		beads.add("green");
//
//		for (ArrayList<String> a : threadings(2, beads)) {
//			System.out.println(Arrays.toString(a.toArray()));
//		}
//
//		ArrayList<String> necklace1 = new ArrayList<String>();
//		necklace1.add("red");
//		necklace1.add("green");
//		necklace1.add("red");
//		necklace1.add("green");
//		// necklace1.add("blue");
//		// necklace1.add("pink");
//
//		ArrayList<String> necklace2 = new ArrayList<String>();
//		necklace2.add("red");
//		// necklace2.add("pink");
//		// necklace2.add("blue");
//		// necklace2.add("pink");
//		necklace2.add("red");
//		necklace2.add("green");
//		necklace2.add("green");
//
//		System.out.println(isEquiv(necklace1, necklace2));
//
//		ArrayList<String> necklace3 = new ArrayList<String>();
//		necklace3.add("red");
//		necklace3.add("red");
//
//		ArrayList<String> necklace4 = new ArrayList<String>();
//		necklace4.add("red");
//		necklace4.add("green");
//
//		ArrayList<String> necklace5 = new ArrayList<String>();
//		necklace5.add("green");
//		necklace5.add("red");
//
//		Set<ArrayList<String>> a = new HashSet<ArrayList<String>>();
//		a.add(necklace3);
//		a.add(necklace4);
//		a.add(necklace5);
//
//		analyse(a);

		int n = Integer.parseInt(args[0]);
		
		Set<String> s = new HashSet<String>();
		
		for (int i = 0; i < args.length - 1; i++) {
			s.add(args[i + 1]);
		}
		
		threadings(n, s);
		analyse(threadings(n,s));
	}
	

}

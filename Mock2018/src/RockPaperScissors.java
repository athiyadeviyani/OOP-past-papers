import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

class RockPaperScissors {

	/**
	 * Returns if a given symbol is a valid symbol for the game.
	 * 
	 * @param symbol
	 *            the symbol to be checked
	 * @return true if the given symbol is valid, false otherwise
	 */
	public static boolean isValidSymbol(char symbol) {
		return symbol == 'R' || symbol == 'P' || symbol == 'S';
	}

	public static List<Matchup> parseMatchups(String[] args) {

		List<Matchup> matchups = new ArrayList<Matchup>();

		for (String s : args) {
			if (s.length() == 2) {
				int i = 0;
				if (isValidSymbol(s.charAt(i))) {
					Matchup m = new Matchup(s.charAt(0), s.charAt(1));
					matchups.add(m);
					i++;

				}
			}
		}
		return matchups;
	}

	/**
	 * Returns the outcome of a given matchup as String.
	 *
	 * @param match
	 *            The matchup to be decided.
	 * @return a String representation of the matchup result; R, P, S or DRAW
	 * @throws IllegalArgumentException
	 *             if the given matchup parameter is null
	 */
	public static String decideOutcome(Matchup match) {
		if (match == null)
			throw new IllegalArgumentException("Given match must not be null!");

		String res = "" + match.getPlayerOne() + match.getPlayerTwo();

		if (res.equals("RP") || res.equals("PR"))
			return "P";
		if (res.equals("RS") || res.equals("SR"))
			return "R";
		if (res.equals("PS") || res.equals("SP"))
			return "S";

		return "DRAW";
	}

	public static Map<String, Integer> countOutcomes(List<Matchup> matches) {
		// IMPLEMENT ME
		int countR = 0;
		int countP = 0;
		int countS = 0;
		int countDRAW = 0;

		Map<String, Integer> result = new Hashtable<String, Integer>();

		if (matches.isEmpty() || matches == null) {
			return new Hashtable<String, Integer>();
		}

		for (Matchup m : matches) {
			String winner = decideOutcome(m);
			if (winner.equals("S")) {
				countS++;
				result.put("S", countS);
			}
			if (winner.equals("R")) {
				countR++;
				result.put("R", countR);
			}
			if (winner.equals("P")) {
				countP++;
				result.put("P", countP);
			}
			if (winner.equals("DRAW")) {
				countDRAW++;
				result.put("DRAW", countDRAW);
			}
		}
		int max = 0;
		String maxString = "";
		for (String s : result.keySet()) {
			if (result.get(s) > max) {
				max = result.get(s);
				maxString = s;
			}
		}
		System.out.println("Most outcomes: " + maxString);
		return result;
	}

	/**
	 * Executes different functionality for the game RockPaperScissors.
	 *
	 * @param args
	 *            A series of matchups encoded as pairs of single characters. The
	 *            series of matchups can be empty.
	 */
	public static void main(String[] args) {
		List<Matchup> matches = parseMatchups(args);
		System.out.println(matches);

		if (matches != null) {
			System.out.println(matches.size() + " matches parsed.");

			System.out.println("\nCount outcomes per symbol...");
			Map<String, Integer> outcomesPerSymbol = countOutcomes(matches);
			System.out.println(outcomesPerSymbol);
		}
	}

}

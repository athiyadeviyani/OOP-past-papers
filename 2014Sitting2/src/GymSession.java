import java.util.HashMap;

class GymSession extends ExerciseSession {
	
	private HashMap<String,Length> machines = new HashMap<String,Length>();
	
	public GymSession(String type, String place) {
		super(type, place);
		machines = new HashMap<String,Length>(8);
	}
	
	public void addMachine(String name, Length use) {
		machines.put(name, use);
	}
	
	public String toString() {
		String s = super.toString() + "\nMachines:";
		for (String machine : machines.keySet()) {
			s = s + "\n" + machine + " " + machines.get(machine);
		}
		return s;
	}
	
	public static void main(String[] args) {
		GymSession g1 = new GymSession("Gym", "The Pleasance");
		Length l1 = new Length();
		l1.setNumber(10);
		l1.setUnits("minutes");
		g1.addMachine("Treadmill", l1);
		g1.addMachine("Cross-trainer", l1);
		System.out.print(g1.toString());
	}
	
}

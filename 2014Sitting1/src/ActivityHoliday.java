import java.util.HashMap;

class ActivityHoliday extends Holiday {
	
	private HashMap<String, Cost> activities = new HashMap<String, Cost>();
	
	public ActivityHoliday(String destination, int days) {
		super(destination, days);
		activities = new HashMap<String, Cost>(10);
	}
	
	public void addActivity(String activity, Cost cost) {
		activities.put(activity, cost);
	}
	
	public String toString() {
		String s = super.toString() + "\nActivities:";
		for (String key : activities.keySet()) {
			s = s + "\n" + key + " " + activities.get(key);
		}
		return s;
	}
	
	public static void main(String[] args) {
		ActivityHoliday a1 = new ActivityHoliday("Glasgow",14);
		Cost c1 = new Cost();
		c1.setAmount(5);
		c1.setCurrency("pounds sterling");
		a1.addActivity("Hunterian Museum", c1);
		a1.addActivity("Mackintosh House", c1);
		System.out.println(a1.toString());
	}
}
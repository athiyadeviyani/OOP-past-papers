class UG5Student extends Student {
	
	private int extraLevel9s;
	
	public UG5Student(String name, String uun, int extraLevel9s) {
		super(name, uun, 5);
		this.extraLevel9s = extraLevel9s;
	}
	
	public UG5Student() {
		this("not set","not set",0);
	}
	
	public int level9s() {
		int total = 0;
		for (Course c : getCourses()) {
			if (c.getLevel() == 9) {
				total++;
			}
		}

		return total;
	}
	
	public boolean addCourse(Course course) {
		int maxLevel9s = extraLevel9s + 1;
		int currentLevel9s = level9s();
		
		if (currentLevel9s >= maxLevel9s) {
			return false;
		}
		
		super.addCourse(course);
		return true;
	}
	
	public String toString() {
		String s = super.toString();
		if (level9s() == 0 || level9s() == 1) {
			return s;
		}
		
		s = s + "\nTaking extra level 9s. Permission for " + extraLevel9s + " extra.";
		for (Course c : getCourses()) {
			s = s + "\n" + c.getName();
		}
		
		return s;
 	}
	
	public static void main(String[] args) {
		UG5Student u1 = new UG5Student("David Parnas", "s1709906", 1);
		Course c1 = new Course("Operating Systems", 'O', 9);
		Course c2 = new Course("Informatics 1 Object Oriented Programming", 'O', 9);
		Course c3 = new Course("Logic Programming", 'O', 9);
		u1.addCourse(c1);
		u1.addCourse(c2);
		u1.addCourse(c3);
		
		System.out.println(u1.toString());
	}
}
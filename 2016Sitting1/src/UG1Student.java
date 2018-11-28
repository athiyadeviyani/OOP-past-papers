class UG1Student extends Student {
	
	private char mainSchedule;

	public UG1Student(String name, String uun, char mainSchedule) {
		super(name, uun, 1);
		this.mainSchedule = mainSchedule;
	}
	
	public UG1Student() {
		this("not set", "not set", 'X');
	}
	
	public boolean addCourse(Course course) {
		int level = course.getLevel();
		if ((level != 7) && (level != 8)) {
			return false;
		}
		super.addCourse(course);
		return true;
	}
	
	public boolean addCourses(Course[] courses) {
		boolean flag = true;
		for (Course c : courses) {
			if (!addCourse(c)) {
				flag = false;
			}
		}
		return flag;
	}
	
	public String toString() {
		String s = super.toString() + "\nMain schedule " + mainSchedule + " courses:";
		for (Course c : getCourses()) {
			s = s + "\n" + c.getName();
		}
		return s;
	}
	
	
}
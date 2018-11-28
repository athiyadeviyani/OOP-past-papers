import java.util.ArrayList;
import java.util.HashMap;

class Student extends Person {
	
	private ArrayList<Course> activeCourses = new ArrayList<Course>();
	private ArrayList<Course> completedCourses = new ArrayList<Course>();
	private int maxCourses;
	
	public int getMaxCourses() {
		return maxCourses;
	}
	
	public void setMaxCourses(int maxCourses) {
		this.maxCourses = maxCourses;
	}
	
	public Student(String firstName, String lastName, ArrayList<Course> activeCourses, ArrayList<Course> completedCourses, int maxCourses) {
		super(firstName, lastName);
		this.activeCourses = activeCourses;
		this.completedCourses = completedCourses;
		this.maxCourses = maxCourses;
	}
	
	public boolean canEnroll(Course course) {
		// ArrayList<String> getPrerequisiteCourses()
		
		boolean a = true; 
		ArrayList<String> courseNames = new ArrayList<String>();
		
		for (Course name : completedCourses) {
			courseNames.add(name.getName());
		}
		
		for (String prereq : course.getPrerequisiteCourses()) {
			if (courseNames.contains(prereq)) {
				a = a && true;
			}
		}
		
		boolean b = !activeCourses.contains(course);
		boolean c = !completedCourses.contains(course);
		boolean d = activeCourses.size() < maxCourses;
		
		return a && b && c && d;
	}

	public boolean enroll(Course course) {
		if (!canEnroll(course)) {
			return false;
		}
		activeCourses.add(course);
		return true;
	}
	
	public boolean complete(String courseName) {
		ArrayList<String> activeCourseNames = new ArrayList<String>();
		for (Course c : activeCourses) {
			activeCourseNames.add(c.getName());
		}
		
		if (!activeCourseNames.contains(courseName)) {
			return false;
		}
		
		for (Course c : activeCourses) {
			if (c.getName().equals(courseName)) {
				activeCourses.remove(c);
				completedCourses.add(c);
			}
		}
		return true;
	}
	
	
	public HashMap<Course,String> getAllCourses() {
		HashMap<Course,String> result = new HashMap<Course,String>();
		for (Course c : activeCourses) {
			result.put(c, "active");
		}
		for (Course c : completedCourses) {
			result.put(c, "completed");
		}
		return result;
	}
	
	public String summary() {
		String s = "";
		for (Course key : getAllCourses().keySet()) {
			s = s + String.format("%s (%s)", key.getName(), getAllCourses().get(key)) + "\n";
		}
		return s;
	}
	
	
}
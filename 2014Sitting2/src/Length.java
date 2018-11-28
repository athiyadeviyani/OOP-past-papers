
public class Length {

	private int number;
	private String units;
	
	public Length() {
		number = 0;
		units = "km";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int newNumber) {
		if (number >= 0) {
			this.number = newNumber;
		}
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String newUnit) {
		boolean a = newUnit.equals("km");
		boolean b = newUnit.equals("miles");
		boolean c = newUnit.equals("minutes");
		
		if (a || b || c) {
			this.units = newUnit;
		}
	}
	
	public void convert(String newUnits, double rate) {
		setUnits(newUnits);
		setNumber((int) Math.round(getNumber() / rate));
	}
	
	public String toString() {
		return getNumber() + " " + getUnits();
	}
	
//	public static void main(String[] args) {
//		Length l1 = new Length();
//		l1.setNumber(40);
//		l1.setUnits("minutes");
//		l1.convert("miles", 1.60934);
//		System.out.println(l1.toString());
//	}
}

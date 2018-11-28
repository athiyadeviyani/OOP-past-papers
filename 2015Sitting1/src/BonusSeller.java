import java.util.HashMap;

class BonusSeller extends Seller {
	
	private HashMap<String, Double> sales = new HashMap<String, Double>();
	// names of customers and the TOTAL weight sold to each customer
	
	public BonusSeller(String n) {
		super(n);
		sales = new HashMap<String, Double>(10);
	}
	
	public void sale(String name, double price) {
		// invoke the superclass's sale method
		super.sale(price);
		
		Double sold = sales.get(name);
		if (sold == null) {
			sold = 0.0;
		}
		
		sold += price;
		sales.put(name, sold);
	}
	
	public String toString() {
		String s = super.toString() + "\nSales per customer:";
		for (String key : sales.keySet()) {
		//	s = s + "\n" + key + ":" + sales.get(key) + "kg";
			s = s + "\n" + String.format("%s:%.0fkg", key, sales.get(key));
		}
		return s;
	}
	
	public int calculateBonus() {
		int count = 0;
		int bonus = 0;
		
		for (String key : sales.keySet()) {
			if (sales.get(key) >= 20) {
				count++;
			}
		}
		
		if (count < 5) {
			bonus = 0;
		} else if (count >= 5 && count < 10) {
			bonus = 5;
		} else if (count >= 10) {
			bonus = 7;
		}
		
		
		return bonus;
	}
	
	public static void main(String[] args) {
		BonusSeller b1 = new BonusSeller("Charles");
		b1.sale("Monsanto", 13.0);
		b1.sale("ICI", 35.0);
		
		System.out.println(b1);
		System.out.println(b1.calculateBonus());
	}
}
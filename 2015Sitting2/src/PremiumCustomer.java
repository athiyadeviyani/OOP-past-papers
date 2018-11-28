import java.util.HashMap;
import java.util.Map;

class PremiumCustomer extends Customer {
	
	private Map<String,String> freeGifts = new HashMap<String,String>();
	
	public PremiumCustomer(String name, Map<String,String> freeGifts) {
		super(name);
		this.freeGifts = freeGifts;
	}
	
	public void giftsFrom(String item, int quantity) {
		if (freeGifts.containsKey(item)) {
			System.out.println(freeGifts.get(item) + " x " + quantity);
		}
	}
	
	public String toString() {
		String s = super.toString() + "\nFree gifts:";
		for (String str : freeGifts.keySet()) {
			s = s + "\n" + freeGifts.get(str) + " on ordering " + str;
		}
		return s;
	}
	
	public int chocolateGifts() {
		int count = 0;
		for (String str : freeGifts.values()) {
			if (str.indexOf("chocolate") != -1) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Map<String,String> gifts = new HashMap<String,String>();
		gifts.put("printer cartridge", "chocolate bar");
		PremiumCustomer pc1 = new PremiumCustomer("Charles", gifts);
		System.out.println(pc1.chocolateGifts());

	}
}

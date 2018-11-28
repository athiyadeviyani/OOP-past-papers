
public class Cost {
	private int amount;
	private String currency;

	public Cost() {
		amount = 0;
		currency = "pounds sterling";
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int newAmount) {
		if (newAmount >= 0) {
			this.amount = newAmount;
		}
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String newCurrency) {
		boolean a = newCurrency.equals("pounds sterling");
		boolean b = newCurrency.equals("US dollars");
		boolean c = newCurrency.equals("euros");
		
		if (a || b || c ) {
			this.currency = newCurrency;
		}
	}
	
	public void convert (String newCurrency, double rate) {
		setCurrency(newCurrency);
		int newAmt = (int) Math.round(getAmount() / rate);
		setAmount(newAmt);
	}
	
	public String toString() {
		return getAmount() + " " + getCurrency();
	}

}

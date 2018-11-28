class Boss extends Monster {
	private int stage;
	private final int initialHealth;

	public Boss(int health, int power) {
		super(health, power);
		this.initialHealth = health;
		this.stage = 1;
	}

	public String toString() {
		String s = super.toString() + "\nStage: " + stage;
		return s;
	}

	public void takeDamage(int damage) {

		super.takeDamage(damage);

		if (!isDefeated()) {
			double a = health / (double) initialHealth;
			
			if (stage == 1) {
				if (a < 0.5 && a >= 0.2) {
					stage += 1;
					power *= 2;
				} else if (a < 0.2) {
					stage += 2;
					power = power * 2 * 2;
				}
			}

			if (stage == 2) {
				if (a < 0.2) {
					stage += 1;
					power *= 2;
				}
			}
		}
	}

	public static void main(String[] args) {
		Boss b1 = new Boss(600, 20);
		b1.takeDamage(190);
		b1.takeDamage(130);
		System.out.println(b1.toString());
	}
}
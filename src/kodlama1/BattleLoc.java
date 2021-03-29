package kodlama1;

public abstract class BattleLoc extends Location {

	protected Obstacle obstacle;
	protected String award;

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("Dikkatli ol !");
		System.out.println("Burada " + obsCount + " tane " + obstacle.getName() + " var!");
		System.out.print("<S>avas veya <K>ac : ");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(getName() + " bolgesindeki tum dusmanlari temizlediniz! ");
				if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println("Odun kazandiniz!");
					player.getInv().setFirewood(true);
				} else if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println("Yemek kazandiniz!");
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println("Su kazandiniz!");
					player.getInv().setWater(true);
				}
				return true;
			}
			if (player.getHealty() <= 0) {
				System.out.println("Oldunuz..");
				return false;
			}
		}
		return true;
	}

	public boolean combat(int obsCount) {
		// defaultHealty asagida kullanilacak. canavar bir kere öldügu zaman sifir canla
		// baslamasin diye. canavar 3 kere üretilmiyor. bir kere üretiliyor o yüzden set
		// edilen can digerlerini de etkiliyor.
		int defaultObstacleHealty = obstacle.getHealty();
		for (int i = 0; i < obsCount; i++) {
			// asagida kullaniciyi bilgilendirmek amacli statusler bulunuyor.
			playerStatus();
			obstacleStatus();
			while (player.getHealty() > 0 && obstacle.getHealty() > 0) {
				System.out.print("<V>ur veya <K>ac :");
				String temp = scan.nextLine();
				if (temp.equalsIgnoreCase("V")) {
					System.out.println("Vurdunuz !");
					obstacle.setHealty(obstacle.getHealty() - player.getTotalDamage());
					afterAtack();
					if (obstacle.getHealty() > 0) {
						System.out.println();
						System.out.println(obstacle.getName() + " size vurdu ! ");
						player.setHealty(player.getHealty() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterAtack();
					}
				} else
					return false;
			}
			if (obstacle.getHealty() <= 0) {
				System.out.println("--------------");
				System.out.println(obstacle.getName() + " öldü !");
				System.out.println("--------------");
				player.setMoney(player.getMoney() + obstacle.getAwardMoney());
				obstacle.setHealty(defaultObstacleHealty);
				System.out.println("Güncel paraniz : " + player.getMoney());
			}
		}
		return true;
	}

	public void playerStatus() {
		System.out.println("<< Oyuncu bilgileri >>");
		System.out.println("Can   : " + player.getHealty());
		System.out.println("Hasar : " + player.getTotalDamage());
		System.out.println("Para  : " + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Silah : " + player.getInv().getWeaponName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Zirh  : " + player.getInv().getArmorName());
		}
	}

	public void obstacleStatus() {
		System.out.println("<< " + obstacle.getName() + " bilgileri >>");
		System.out.println("Can    : " + obstacle.getHealty());
		System.out.println("Hasar  : " + obstacle.getDamage());
		System.out.println("Odul $ : " + obstacle.getAwardMoney());
	}

	public void afterAtack() {
		System.out.println("Oyuncu cani : " + player.getHealty());
		System.out.println(obstacle.getName() + " cani : " + obstacle.getHealty());
	}
}

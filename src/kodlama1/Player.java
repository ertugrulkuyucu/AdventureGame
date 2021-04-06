package kodlama1;

import java.util.Scanner;

public class Player {

	private String name, charName;
	private int healty, damage, money, charID, firstHealty;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}

	public void selectChar() {
		/**
		 * Buraya char listten secilen karakterID si d�n�yor ve 
		 * ID sayesinde caselerle karakter se�iyoruz.
		 */

		/**
		 * NOT : Ilk �nce set metodlariyla hepsini d�zenledik caselerin i�inde sonradan
		 * kodu daha aza indirmek i�in bir fonksiyon yardimiyla defineSelectChar in
		 * i�inde tek satirda yapmis olduk.
		 */

		switch (charList()) {
		case 1:
			defineSelectChar("Samuray", 5, 21, 15);
			break;
		case 2:
			defineSelectChar("Okcu", 7, 18, 20);
			break;
		// normalde �� karakter i�in �� case yapilacakti ve default i�in tekrardan
		// yazilmasi gerekince ben direkt 3 yerine defaultu yazdim.
		default:
			defineSelectChar("Sovalye", 8, 24, 5);
			break;
		}
		System.out.println("Karakteriniz : " + getCharName());
	}

	public int charList() {

		System.out.println("L�tfen bir karakter se�iniz.");
		System.out.println("1 ) Samuray --> \tHasar : 5 \tSaglik : 21 \tPara : 15");
		System.out.println("2 ) Okcu    --> \tHasar : 7 \tSaglik : 18 \tPara : 20");
		System.out.println("3 ) Sovalye --> \tHasar : 8 \tSaglik : 24 \tPara : 5");
		System.out.print("Seciminiz : ");
		charID = scan.nextInt();

		// olas� yanl�� tu�laman�n �n�ne ge�ildi.
		while (charID < 1 || charID > 3) {
			System.out.print("Lutfen gecerli bir karakter numarasi giriniz :");
			charID = scan.nextInt();
		}

		// return selectChar da kullanilacak.
		return charID;
	}

	public void defineSelectChar(String charName, int damage, int healty, int money) {

		setCharName(charName);
		setDamage(damage);
		setHealty(healty);
		setMoney(money);
		setFirstHealty(healty);
	}

	public int getTotalDamage () {
		int totalDamage = getDamage() + inv.getDamage();
		return totalDamage;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public int getHealty() {
		return healty;
	}

	public void setHealty(int healty) {
		this.healty = healty;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	
	public int getFirstHealty() {
		return firstHealty;
	}

	public void setFirstHealty(int firstHealty) {
		this.firstHealty = firstHealty;
	}

	
}

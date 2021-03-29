package kodlama1;

public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "Magaza");
	}

	public boolean getLocation() {
		System.out.println("Para : " + player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zirhlar");
		System.out.println("3. Magazadan Cik");
		System.out.print("Seciminiz : ");
		int chooseStore = scan.nextInt();
		int chooseID;
		switch (chooseStore) {
		case 1:
			// temp buyWeaponun parantez içinde iþe yarýyor. nr waponmenu - buyweapon
			// diyerek ikisini de çalýþtýrmýþ olduk.
			chooseID = weaponMenu();
			// burada buyWeapon(weaponMenu()) diye denediðimde weapon menunun iki kere
			// çalýþtýðýný gördüm. bu þekilde yazýlýnca her türlü çalýþýyor.
			buyWeapon(chooseID);
			break;

		case 2:
			chooseID = armorMenu();
			buyArmor(chooseID);
			break;
		case 3:
			break;

		default:
			System.out.println("Gecersiz islem...");
			break;
		}
		return true;
	}

	public int weaponMenu() {
		System.out.println("1. Tabanca < Hasar : 2 - Para : 25 >");
		System.out.println("2. Kilic   < Hasar : 3 - Para : 35 >");
		System.out.println("3. Tüfek   < Hasar : 7 - Para : 45 >");
		System.out.println("4. Geri");
		System.out.print("Seciminiz : ");
		int chooseWeapon = scan.nextInt();
		return chooseWeapon;
	}

	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch (itemID) {
		case 1:
			damage = 2;
			price = 15;
			wName = "Tabanca";
			break;
		case 2:
			damage = 3;
			price = 35;
			wName = "Kilic";
			break;
		case 3:
			damage = 7;
			price = 45;
			wName = "Tüfek";
			break;
		case 4:
			getLocation();
			break;
		default:
			System.out.println("Gecersiz islem !");
			break;
		}

		// aþaðýyý tam anlamadým. player.getýnv().setWeaponname.???? ama mantýk olarak
		// buradaki caselerden gelen deðerleri envanterin içindeki deðiþkenlere atýyoruz
		// setler ile.

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInv().setDamage(damage);
				player.getInv().setWeaponName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println(wName + " satin aldiniz. Yine bekleriz. :)");
				System.out.println("Kalan paraniz : " + player.getMoney());
				System.out.println("Yeni toplam hasariniz : " + player.getTotalDamage());
			} else {
				System.out.println("Yetersiz bakiye..");
			}
		}
	}

	public int armorMenu() {
		System.out.println("1. Hafif Zirh  < Engel  : 1 - Para : 15 >");
		System.out.println("2. Orta  Zirh  < Engel  : 3 - Para : 25 >");
		System.out.println("3. Agir  Zirh  < Engel  : 5 - Para : 40 >");
		System.out.println("4. Geri");
		System.out.print("Seciminiz : ");
		int chooseArmor = scan.nextInt();
		return chooseArmor;
	}

	public void buyArmor(int itemID) {

		int avoid = 0, price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			avoid = 1;
			price = 15;
			aName = "Hafif Zirh";
			break;
		case 2:
			avoid = 3;
			price = 25;
			aName = "Orta Zirh";
			break;
		case 3:
			avoid = 5;
			price = 40;
			aName = "Agir Zirh";
			break;
		case 4:
			getLocation();
			break;
		default:
			System.out.println("Geçersiz islem !");
			break;
		}

		if (price > 0) {
			if (player.getMoney() >= price) {
				player.getInv().setArmor(avoid);
				player.getInv().setArmorName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(aName + " satin aldiniz. Yine bekleriz. :)");
				System.out.println("Kalan paraniz : " + player.getMoney());
			} else {
				System.out.println("Yetersiz bakiye..");
			}
		}
	}
}

package kodlama1;

import java.util.Scanner;

public class Game {

	// Tüm oyun burada donecek main de ise burasi çagrilacak.

	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {

		System.out.println("Macera oyununa hosgeldiniz! ");
		System.out.print("Lütfen isminizi girin : ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectChar();
		start();

	}

	public void start() {
		while (true) {
			System.out.println("\n ========================= \n");
			System.out.println("Lütfen bulunmak istediginiz mekani seciniz.");
			System.out.println("1. Ev     --> Size ait güvenli bir mekan. Caniniz yenilenir.");
			System.out.println("2. Magara --> Karsiniza zombi cikabilir.");
			System.out.println("3. Orman  --> Karsiniza vampir cikabilir.");
			System.out.println("4. Nehir  --> Karsiniza ayi cikabilir.");
			System.out.println("5. Magaza --> Silah veya zirh alabilirsiniz.");
			System.out.print("Seciminiz : ");
			int chooseLocation = scan.nextInt();
			while (chooseLocation < 1 || chooseLocation > 6) {
				System.out.println("Lütfen geçerli bir mekan giriniz :");
				chooseLocation = scan.nextInt();
			}
			switch (chooseLocation) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
				
			}
			
			//burda kontrol ettik. 62 ve 63. satýrý.
//			System.out.println(location.getClass());
//			System.out.println(location.getName());
			
			//olmuyor getclass.getname olmadý. ben chooselocatþonu = 1 yapýnca düzeldi?????
			//package ismi karýþtýedý. defoult package olmadýðý için kodlama1.safehouse diye geliyor.
			if (location.getClass().getName().equals("SafeHouse")  || chooseLocation == 1) {
				if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Tebrikler Oyunu Kazandiniz !");
					break;
				}
			}

			if (!location.getLocation()) {
				System.out.println("Oyun Bitti..");
				break;
			}
		}
	}

}

package kodlama1;

public class SafeHouse extends NormalLoc{
	
	SafeHouse (Player player){
		super(player, "Guvenli Ev");	
		
	}

	public boolean getLocation () {
		player.setHealty(player.getFirstHealty());
		System.out.println("Caniniz fullendi.");
		System.out.println("Suan Güvenli evdesiniz..");
		return true;
	}
	
}

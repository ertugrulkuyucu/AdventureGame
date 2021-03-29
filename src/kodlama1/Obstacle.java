package kodlama1;

import java.util.Random;

public class Obstacle {

	private String name;
	private int damage, healty, awardMoney, maxNumber;
	public Obstacle(String name, int damage, int healty, int award, int maxNumber) {
		this.name = name;
		this.damage = damage;
		this.healty = healty;
		this.awardMoney = award;
		this.maxNumber = maxNumber;
	}
	public int count () {
		Random r = new Random();
		return r.nextInt(this.maxNumber) + 1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealty() {
		return healty;
	}
	public void setHealty(int healty) {
		this.healty = healty;
	}
	public int getAwardMoney() {
		return awardMoney;
	}
	public void setAward(int award) {
		this.awardMoney = award;
	}
	public int getMaxNumber() {
		return maxNumber;
	}
	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}
	
	
}

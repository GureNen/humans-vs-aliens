package entity;

import java.util.HashMap;
import java.lang.Thread;

public class Human extends Entity {
	
	// Assets for the Human class
	
	public enum Asset {
		MICROPHONE(100), ENERGY_DRINK(50);
		private int price;
		private Asset(int price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return this.name();
		}
	}
	
	// Human traits
	
	private int money;
	private HashMap<Asset, Integer> assets;
	
	// constructor
	
	public Human(String name) {
		super(name, 0);
		this.money = 0;
		this.assets = new HashMap<>();
		this.assets.put(Asset.MICROPHONE, 0);
		this.assets.put(Asset.ENERGY_DRINK, 0);
	}
	
	public Human(String name, int position) {
		super(name, position);
		this.money = 0;
		this.assets = new HashMap<>();
		this.assets.put(Asset.MICROPHONE, 0);
		this.assets.put(Asset.ENERGY_DRINK, 0);
	}
	
	// getters

	public int getMoney() {
		return money;
	}
	public HashMap<Asset, Integer> getAssets() {
		return assets;
	}
	
	// setters
	
	public void setMoney(int money) {
		this.money = money;
	}
	public void setAssets(HashMap<Asset, Integer> assets) {
		this.assets = assets;
	}
	
	// shared methods (Overridden)
	
	@Override
	public boolean greet(Entity entity) {
		if (Math.abs(this.getPosition() - entity.getPosition()) <= this.getVoice()) {
			if (this.getEnergy() < 5) {
				System.out.println("Not enough energy !!!");
				return false;
			} else {
				System.out.println("Greetings !!!");
				this.setEnergy(this.getEnergy() - 5);
				this.setMoney(this.getMoney() + 20);
				this.setPoints(this.getPoints() + 10);
				return true;
			}
		} else {
			System.out.println("Target is too far !!!");
			this.setPoints(this.getPoints() - 5);
			return false;
		}
	}
	
	// Human behavior
	
	public void buyAssets(Asset asset) {
		if (this.getMoney() >= asset.price) {
			if (asset.equals(Asset.ENERGY_DRINK)) {
				if (this.assets.get(asset) < 5) {
					this.assets.put(asset,  this.assets.get(asset) + 1);
					this.setMoney(this.getMoney() - asset.price);
				} else {
					System.out.println("Can't have more than 5 from this item !!!");
				}
			} else if (asset.equals(Asset.MICROPHONE)) {
				if (this.assets.get(asset) < 2) {
					this.assets.put(asset,  this.assets.get(asset) + 1);
					this.setMoney(this.getMoney() - asset.price);
				} else {
					System.out.println("Can't have more than 2 from this item !!!");
				}
			}
		} else {
			System.out.println("Not enough credits !!!");
		}
	}
	
	public void useAsset(Asset asset) {
		if (asset.equals(Asset.ENERGY_DRINK)) {
			if (this.assets.get(asset) > 0) {
				this.setEnergy(this.getEnergy() + 15);
				if (this.getEnergy() > 100) {
					this.setEnergy(100);
				}
				this.assets.put(asset, this.assets.get(asset) - 1);
			} else {
				System.out.println("No more energy drinks !!!");
			}
		} else if (asset.equals(Asset.MICROPHONE)) {
			if (this.assets.get(asset) > 0) {
				try {
					this.assets.put(asset, this.assets.get(asset) - 1);
					this.setVoice(50);
					Thread.sleep(10000);
					this.setVoice(20);
				} catch(InterruptedException e) {
					System.out.println(e);
				}
			} else {
				System.out.println("No more microphones !!!");
			}
		}
	}
	
}
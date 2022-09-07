package entity;

import java.util.HashMap;
import java.lang.Thread;

public class Alien extends Entity {
	
	// Spells for the Alien class
	
	public enum Spell {
		SCREAM(100), REGEN(50);
		private int price;
		private Spell(int price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return this.name();
		}
	}
	
	// Alien traits
	
	private int magic;
	private HashMap<Spell, Integer> spells;
	
	// constructor
	
	public Alien(String name) {
		super(name, 0);
		this.magic = 0;
		this.spells = new HashMap<>();
		this.spells.put(Spell.REGEN, 0);
		this.spells.put(Spell.SCREAM, 0);
	}
	public Alien(String name, int position) {
		super(name, position);
		this.magic = 0;
		this.spells = new HashMap<>();
		this.spells.put(Spell.REGEN, 0);
		this.spells.put(Spell.SCREAM, 0);
	}
	
	// getters

	public int getMagic() {
		return magic;
	}
	public HashMap<Spell, Integer> getSpells() {
		return spells;
	}
	
	// setters

	public void setMagic(int magic) {
		this.magic = magic;
	}
	public void setSpells(HashMap<Spell, Integer> spells) {
		this.spells = spells;
	}
	
	// shared methods (Overridden)
	
	@Override
	public boolean greet(Entity entity) {
		if (Math.abs(this.getPosition() - entity.getPosition()) <= this.getVoice()) {
			if (this.getEnergy() < 5) {
				System.out.println("Not enough magic !!!");
				return false;
			} else {
				System.out.println("Greetings !!!");
				this.setEnergy(this.getEnergy() - 5);
				this.setMagic(this.getMagic() + 20);
				this.setPoints(this.getPoints() + 10);
				return true;
			}
		} else {
			System.out.println("Target is too far !!!");
			this.setPoints(this.getPoints() - 5);
			return false;
		}
	}
	
	// Alien behavior
	
	public void makeSpells(Spell spell) {
		if (this.getMagic() >= spell.price) {
			if (spell.equals(Spell.REGEN)) {
				if (this.spells.get(spell) < 5) {
					this.spells.put(spell, this.spells.get(spell) + 1);
					this.setMagic(this.getMagic() - spell.price);
				} else {
					System.out.println("Can't have more than 5 from this spell !!!");
				}
			} else if (spell.equals(Spell.SCREAM)) {
				if (this.spells.get(spell) < 2) {
					this.spells.put(spell, this.spells.get(spell) + 1);
					this.setMagic(this.getMagic() - spell.price);
				} else {
					System.out.println("Can't have more than 2 from this spell !!!");
				}
			}
		} else {
			System.out.println("Not enough magic !!!");
		}
	}
	
	public void useSpell(Spell spell) {
		if (spell.equals(Spell.REGEN)) {
			if (this.spells.get(spell) > 0) {
				this.setEnergy(this.getEnergy() + 15);
				if (this.getEnergy() > 100) {
					this.setEnergy(100);
				}
				this.spells.put(spell, this.spells.get(spell) - 1);
			} else {
				System.out.println("No more regeneration spells !!!");
			}
		} else if (spell.equals(Spell.SCREAM)) {
			if (this.spells.get(spell) > 0) {
				try {
					this.spells.put(spell, this.spells.get(spell) - 1);
					this.setVoice(50);
					Thread.sleep(10000);
					this.setVoice(20);
				} catch(InterruptedException e) {
					System.out.println(e);
				}
			} else {
				System.out.println("No more screaming spells !!!");
			}
		}
	}
	
}

package entity;


// class that shares common behaviors between entities

public class Entity {
	
	// common traits
	
	private String name;
	private int energy;
	private int points;
	private int position;
	private int voice;
	
	// constructor
	
	public Entity(String name, int position) {
		this.name = name;
		this.points = 0;
		this.energy = 100;
		this.position = position;
		this.voice = 20;
	}
	
	// getters
	
	public String getName() {
		return this.name;
	}
	public int getPoints() {
		return this.points;
	}
	public int getEnergy() {
		return energy;
	}
	public int getPosition() {
		return this.position;
	}
	public int getVoice() {
		return this.voice;
	}
	
	// setters
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}

	// common behaviors
	
	public void move(int position) {
		int distance = Math.abs(this.position - position);
		if (distance <= this.energy) {
			this.energy -= distance;
			this.position = position;
		} else {
			System.out.println("Not Enough Energy !!!");
		}
	}
	public boolean greet(Entity entity) {
		System.out.println("Greetings !!!");
		return true;
	}
}

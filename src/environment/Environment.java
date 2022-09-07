package environment;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Alien;
import entity.Human;

// for the purpose of the exercise we will leave the scenario Human specific

public class Environment {
	
	// data structure that holds all the entities in an environment
	
	private ArrayList<Alien> aliens;
	private Human human;
	Scanner input;
	
	// constructor

	public Environment() {
		this.human = new Human("BOTzed");
		this.aliens = new ArrayList<>();
		this.aliens.add(new Alien("Jeff", 20));
		this.aliens.add(new Alien("Guren", 50));
		this.aliens.add(new Alien("Ardis", -50));
		this.aliens.add(new Alien("Zypax", -30));
		this.aliens.add(new Alien("Epeslome", -10));
		this.input = new Scanner(System.in);
	}
	
	// getters
	
	public ArrayList<Alien> getAliens() {
		return aliens;
	}
	public Human getHuman() {
		return human;
	}
	
	// setters
	
	public void setAliens(ArrayList<Alien> aliens) {
		this.aliens = aliens;
	}
	public void setHuman(Human human) {
		this.human = human;
	}
	
	// interactions method
	
	public void greet(Alien alien) {
		if (this.human.greet(alien)) {
			this.aliens.remove(alien);
		}
	}
}

package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.Alien;
import entity.Entity;
import entity.Alien.Spell;

public class AlienTest {

	Alien guren;
	
	@Before
	public void setUp() {
		guren = new Alien("Guren", 0);
	}

	@Test
	public void testInstanciation() {
		assertEquals("Guren", guren.getName());
		assertEquals(0, guren.getMagic()); 
	}
	@Test
	public void testBehavior () {
		Entity ardis = new Entity("Ardis", 30);
		guren.move(10);
		assertEquals(10, guren.getPosition());
		assertEquals(90, guren.getEnergy());
		guren.greet(ardis);
		assertEquals(20, guren.getMagic());
		assertEquals(85, guren.getEnergy());
		guren.setMagic(1000);
		guren.makeSpells(Spell.SCREAM);
		guren.makeSpells(Spell.REGEN);
		assertEquals(1, (int)guren.getSpells().get(Spell.SCREAM));
		guren.makeSpells(Spell.SCREAM);
		assertEquals(2, (int)guren.getSpells().get(Spell.SCREAM));
		assertEquals(1, (int)guren.getSpells().get(Spell.REGEN));
		guren.useSpell(Spell.REGEN);
		assertEquals(0, (int)guren.getSpells().get(Spell.REGEN));
		assertEquals(100, guren.getEnergy());
	}

}

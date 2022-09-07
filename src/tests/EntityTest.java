package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.Entity;

public class EntityTest {
	
	Entity entity;
	
	@Before
	public  void setUp() {
		entity = new Entity("Jeff", 0);
	}

	@Test
	public void testInstanciation() {
		assertEquals("Jeff", entity.getName());
		assertEquals(100, entity.getEnergy());
		assertEquals(0, entity.getPoints());
		assertEquals(0, entity.getPosition());
	}
	@Test
	public void testBehavior() {
		entity.move(10);
		assertEquals(10, entity.getPosition());
	}

}

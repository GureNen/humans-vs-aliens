package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import environment.Environment;

public class EnvironmentTest {
	
	Environment e1;
	Environment e2;

	@Before
	public void setUp() throws Exception {
		e1 = new Environment();
		e2 = new Environment();
	}

	@Test
	public void testInstanciation() {
		assertEquals("BOTzed", e1.getHuman().getName());
		assertEquals(20, e1.getAliens().get(0).getPosition());
	}
	@Test
	public void testInteraction() {
		e1.getHuman().move(10);
		assertEquals(10, e1.getHuman().getPosition());
		e1.greet(e1.getAliens().get(0));
		assertEquals("Guren", e1.getAliens().get(0).getName());
		e1.greet(e1.getAliens().get(1));
		assertEquals("Ardis", e1.getAliens().get(1).getName());
	}

}

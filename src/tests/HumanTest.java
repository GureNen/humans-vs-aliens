package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.Entity;
import entity.Human;
import entity.Human.Asset;

public class HumanTest {
	
	Human jeff;
	Entity mark;
	
	@Before
	public void setUp() {
		jeff = new Human("Jeff", 0);
		mark = new Entity("Mark", 30);
	}

	@Test
	public void testInstanciation() {
		assertEquals("Jeff", jeff.getName());
		assertEquals(0, jeff.getMoney());
	}
	@Test
	public void testBehavior() {
		jeff.move(10);
		assertEquals(10, jeff.getPosition());
		assertEquals(90, jeff.getEnergy());
		jeff.greet(mark);
		assertEquals(20, jeff.getMoney());
		assertEquals(85, jeff.getEnergy());
		jeff.setMoney(1000);
		jeff.buyAssets(Asset.MICROPHONE);
		jeff.buyAssets(Asset.ENERGY_DRINK);
		assertEquals(1, (int)jeff.getAssets().get(Asset.MICROPHONE));
		jeff.buyAssets(Asset.MICROPHONE);
		assertEquals(2, (int)jeff.getAssets().get(Asset.MICROPHONE));
		assertEquals(1, (int)jeff.getAssets().get(Asset.ENERGY_DRINK));
		jeff.useAsset(Asset.ENERGY_DRINK);
		assertEquals(0, (int)jeff.getAssets().get(Asset.ENERGY_DRINK));
		assertEquals(100, jeff.getEnergy());
	}
}

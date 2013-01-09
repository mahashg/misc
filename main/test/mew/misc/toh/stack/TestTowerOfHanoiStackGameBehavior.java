package mew.misc.toh.stack;

import mew.misc.toh.stack.TowerOfHanoiStackGame;

import org.junit.Test;

import junit.framework.TestCase;

public class TestTowerOfHanoiStackGameBehavior extends TestCase {
	
	@Test
	public void testGameDefaultConfiguration(){
		TowerOfHanoiStackGame game = new TowerOfHanoiStackGame();
		
		assertFalse(game.isConfigured());
	}
	
	@Test
	public void testGameInvalidConfiguration(){
		TowerOfHanoiStackGame game = new TowerOfHanoiStackGame();
		int invalidBlockNumber = -5;
		boolean isSetSuccessful = game.setNumberOfBlocks(invalidBlockNumber);

		// To check that invalid block number is not set.
		assertFalse(isSetSuccessful);
	}

	@Test
	public void testGameSetUp(){
		TowerOfHanoiStackGame game = new TowerOfHanoiStackGame();
		game.setNumberOfBlocks(5);
		
		assertTrue(game.isConfigured());
	}	
	
	@Test
	public void testGameConfigurationWithOneBlock(){
		TowerOfHanoiStackGame game = new TowerOfHanoiStackGame();
		game.setNumberOfBlocks(1);
		
		assertTrue(game.isConfigured());
		assertEquals(game.play(), 1);
	}
	
	@Test
	public void testGameConfigurationWithTwoBlock(){
		TowerOfHanoiStackGame game = new TowerOfHanoiStackGame();
		game.setNumberOfBlocks(2);
		
		assertTrue(game.isConfigured());
		assertEquals(game.play(), 3);
	}
	
	@Test
	public void testGameConfigurationWithFiveBlock(){
		TowerOfHanoiStackGame game = new TowerOfHanoiStackGame();
		game.setNumberOfBlocks(5);
		assertTrue(game.isConfigured());
		assertEquals(game.play(), 31);
	}
	
	@Test
	public void testGameConfigurationWithTenBlock(){
		TowerOfHanoiStackGame game = new TowerOfHanoiStackGame();
		game.setNumberOfBlocks(10);
		
		assertTrue(game.isConfigured());
		assertEquals(game.play(), 1023);		
	}
}

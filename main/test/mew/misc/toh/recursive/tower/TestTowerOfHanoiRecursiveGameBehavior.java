package mew.misc.toh.recursive.tower;

import mew.misc.toh.recursive.tower.TowerOfHanoiResursiveGame;

import org.junit.Test;

import junit.framework.TestCase;

public class TestTowerOfHanoiRecursiveGameBehavior extends TestCase{

	@Test
	public void testWithUnConfiguredTowerGame(){
		TowerOfHanoiResursiveGame game = new TowerOfHanoiResursiveGame();
		
		assertEquals(game.play(), 0);
	}
	
	@Test
	public void testWithInCorrectlyConfiguredTowerGame(){
		TowerOfHanoiResursiveGame game = new TowerOfHanoiResursiveGame();
		game.setNumberOfBlocks(-1);
		
		assertEquals(game.play(), 0);
	}
	
	@Test
	public void testWithOneBlockTowerGame(){
		TowerOfHanoiResursiveGame game = new TowerOfHanoiResursiveGame();
		game.setNumberOfBlocks(1);
		
		assertEquals(game.play(), 1);
		
	}
	
	@Test
	public void testWithTwoBlockTowerGame(){
		TowerOfHanoiResursiveGame game = new TowerOfHanoiResursiveGame();
		game.setNumberOfBlocks(2);
		
		assertEquals(game.play(), 3);
	}
	
	@Test
	public void testWithFiveBlockTowerGame(){
		TowerOfHanoiResursiveGame game = new TowerOfHanoiResursiveGame();
		game.setNumberOfBlocks(5);
		
		assertEquals(game.play(), 31);
	}
	
	@Test
	public void testWithTenBlockTowerGame(){
		TowerOfHanoiResursiveGame game = new TowerOfHanoiResursiveGame();
		game.setNumberOfBlocks(10);
		assertEquals(game.play(), 1020);
	}
}

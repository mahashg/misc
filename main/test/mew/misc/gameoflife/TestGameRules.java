package mew.misc.gameoflife;

import mew.misc.gameoflife.ConvaysGame;

import org.junit.Test;

import junit.framework.TestCase;

public class TestGameRules extends TestCase {

	
	@Test
	public void testAliveNeighbourDiesWithSuffocation(){
		assertFalse(ConvaysGame.getNextStateForCellUsingConvaysGameRule(true, 1));
	}
	
	@Test
	public void testAliveNeighbourRemainsAliveUnderNormalCondition(){
		assertTrue(ConvaysGame.getNextStateForCellUsingConvaysGameRule(true, 2));
		assertTrue(ConvaysGame.getNextStateForCellUsingConvaysGameRule(true, 3));
	}
	
	@Test
	public void testAliveNeighbourDiesWithOverCrowding(){
		assertFalse( ConvaysGame.getNextStateForCellUsingConvaysGameRule(true, 4));
	}
	
	@Test
	public void testDeadNeighbourRemainsDeadWithLessThanThreeNeighbours(){
		assertFalse(ConvaysGame.getNextStateForCellUsingConvaysGameRule(false, 2));
	}
	
	@Test
	public void testDeadNeighbourGoesAliveWithThreeNeighbours(){
		assertTrue(ConvaysGame.getNextStateForCellUsingConvaysGameRule(false, 3));
	}
	
	@Test
	public void testDeadNeighbourRemainsDeadWithOvercrowding(){
		assertFalse(ConvaysGame.getNextStateForCellUsingConvaysGameRule(false, 4));
	}
	

}

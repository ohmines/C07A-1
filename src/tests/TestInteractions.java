package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.MovingEnemy;
import levelPieces.ObstaclePiece;
import levelPieces.AdvancePiece;
import levelPieces.PricePiece;
import levelPieces.SniperPiece;

public class TestInteractions {

	public TestInteractions() {
		// TODO Auto-generated constructor stub
	}

    /*
     * Test that MovingEnemy kills player (interaction) only when player is on same location
    */
    @Test
    public void testMovingEnemy() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		MovingEnemy enemy = new MovingEnemy('K', "Killer", 10);
		gameBoard[10] = enemy;
		// Hit points if player on same space
		assertEquals(InteractionResult.KILL, enemy.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i = 0; i < 10; i++)
			assertEquals(InteractionResult.NONE, enemy.interact(gameBoard, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, enemy.interact(gameBoard, i));
	}
    
    /*
     * Test that Obstacle hits player (interaction) only when player is on same location
    */
    @Test
    public void testObstaclePiece() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		ObstaclePiece obstacle = new ObstaclePiece('O', "Obstacle", 10);
		gameBoard[10] = obstacle;
		// Hit points if player on same space
		assertEquals(InteractionResult.HIT, obstacle.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i = 0; i < 10; i++)
			assertEquals(InteractionResult.NONE, obstacle.interact(gameBoard, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, obstacle.interact(gameBoard, i));
	}
    
    /*
     * Test that Advance advances player (interaction) only when player is on same location
    */
    @Test
    public void testAdvancePiece() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		AdvancePiece advance = new AdvancePiece('A', "Advance", 10);
		gameBoard[10] = advance;
		// Hit points if player on same space
		assertEquals(InteractionResult.ADVANCE, advance.interact(gameBoard, 10));
		// These loops ensure no interaction if not on same space
		for (int i = 0; i < 10; i++)
			assertEquals(InteractionResult.NONE, advance.interact(gameBoard, i));
		for (int i = 11; i < GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, advance.interact(gameBoard, i));
	}
    
    /*
     * Test that Price gives player point (interaction) only when player is at most one square away
    */
    @Test
    public void testPricePiece() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		PricePiece price = new PricePiece('X', "Prize", 10);
		gameBoard[10] = price;
		// Hit points if player is at most one space away
		assertEquals(InteractionResult.GET_POINT, price.interact(gameBoard, 9));
		assertEquals(InteractionResult.GET_POINT, price.interact(gameBoard, 10));
		assertEquals(InteractionResult.GET_POINT, price.interact(gameBoard, 11));
		// These loops ensure no interaction if not on same space
		for (int i = 0; i < 9; i++)
			assertEquals(InteractionResult.NONE, price.interact(gameBoard, i));
		for (int i = 12; i < GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, price.interact(gameBoard, i));
	}
    
    /*
     * Test that Sniper hits player (interaction) when player is close enough
    */
    @Test
    public void testSniperPiece() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		SniperPiece sniper = new SniperPiece('S', "Sniper", 10);
		gameBoard[10] = sniper;
		// Hit points if player is at most one space away
		for (int i = 7; i < 14; i++)
			assertEquals(InteractionResult.HIT, sniper.interact(gameBoard, i));
		// These loops ensure no interaction if not on same space
		for (int i = 0; i < 7; i++)
			assertEquals(InteractionResult.NONE, sniper.interact(gameBoard, i));
		for (int i = 14; i < GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, sniper.interact(gameBoard, i));
	}
}








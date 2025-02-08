package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.MovingEnemy;
import levelPieces.RandomMover;

public class TestMovingPieces {

	public TestMovingPieces() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Tests ability of mover to loop around the gameboard
	 */
	@Test
	public void testLoopingMovement() {
		// Each test will create its own gameBoard
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		MovingEnemy enemy = new MovingEnemy('K', "Killer", 0);
		gameBoard[0] = enemy;
		for (int i = 1; i <= GameEngine.BOARD_SIZE; i++) {
			enemy.move(gameBoard, -1); // it doesn't matter what we put for the player position
			if (i < GameEngine.BOARD_SIZE) {
				assertEquals(gameBoard[i], enemy);
			}
			else {
				assertEquals(gameBoard[0], enemy); // to check whether it actually looped around
			}
		}	
	}
	
	/*
	 * Tests the random movement of the RandomMover by ensuring that it will randomly return its results (left, nothing, right)
	 */
	@Test
	public void testRandomMovement() {
		// Each test will create its own gameBoard
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		RandomMover mover = new RandomMover('G', "Goblin", 10);
		gameBoard[10] = mover;
		for(int i = 0; i < 200; i++) {
			mover.move(gameBoard, -1); // it doesn't matter what we put for the player position
			if (gameBoard[9] != mover && gameBoard[10] != mover && gameBoard[11] != mover) {
				fail("RandomMover moved to a square it wasn't supposed to access.");
			}
			gameBoard[10] = mover;
		}
	}

}

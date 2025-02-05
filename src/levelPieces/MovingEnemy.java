package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/**
 * MovingEnemny moves one step forward each turn 
 * If the player lands on its location, they are killed.
 */

public class MovingEnemy extends GamePiece implements Moveable {

	public MovingEnemy(char symbol, String label, int location) {
		// TODO Auto-generated constructor stub
		super(symbol, label, location);
	}
	
	
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == this.getLocation()) {
			return InteractionResult.KILL; //Kill the player
		}
		return InteractionResult.NONE; // No interaction otherwise
	}
	
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
	    int oldLocation = getLocation();
	    int newLocation = (getLocation() + 1) % GameEngine.BOARD_SIZE; // Moves forward, wraps around

	    // Update the game board safely
	    if (gameBoard[oldLocation] == this) {
	        gameBoard[oldLocation] = null; // Only clear if this object is in the old position
	    }

	    // Update location
	    setLocation(newLocation);

	    // If the new location is empty, set this piece; otherwise, leave other objects unaffected
	    if (gameBoard[newLocation] == null) {
	        gameBoard[newLocation] = this;
	    }

	    // Debug log
	    //System.out.println("MovingEnemy moved from " + oldLocation + " to " + newLocation);
	}
}

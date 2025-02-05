package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.Random;

/**
 * RandomMover moves randomly left (-1), right (+1), or stays in place (0).
 * If the player lands on its location, the player takes damage.
 */

public class RandomMover extends GamePiece implements Moveable {
	private Random random;
	
	public RandomMover(char symbol, String label, int location) {
		// TODO Auto-generated constructor stub
		super(symbol, label, location);
        this.random = new Random();
	}
	
	@Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        return InteractionResult.NONE; // Not supposed to interact
    }
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
	    int oldLocation = getLocation();
	    int moveDirection = random.nextInt(3) - 1; // Randomly move -1, 0, or 1
	    int newLocation = oldLocation + moveDirection;

	    // Ensure the new location is within bounds
	    if (newLocation >= 0 && newLocation < gameBoard.length) {
	        // Clear the old position only if this object occupies it
	        if (gameBoard[oldLocation] == this) {
	            gameBoard[oldLocation] = null;
	        }

	        // Update location
	        setLocation(newLocation);

	        // Place this piece at the new location only if it's empty
	        if (gameBoard[newLocation] == null) {
	            gameBoard[newLocation] = this;
	        }
	    }

	    // Debug log for movement
	    //System.out.println("RandomMover moved from " + oldLocation + " to " + newLocation);
	}
}

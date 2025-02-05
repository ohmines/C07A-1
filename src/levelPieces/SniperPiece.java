package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/**
 * SniperPiece can kill the player from a distance.
 */
public class SniperPiece extends GamePiece {

	public SniperPiece(char symbol, String label, int location) {
		// TODO Auto-generated constructor stub
		super(symbol, label, location);
	}
	
	//Hits the player if they are within a certain distance (e.g., 5 tiles).
	@Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (Math.abs(playerLocation - this.getLocation()) <= 3) {
            return InteractionResult.HIT; // Player takes damage
        }
        return InteractionResult.NONE; // No interaction otherwise
    }
}

package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/**
 * ObstaclePiece damages the player when touched.
 */
public class ObstaclePiece extends GamePiece {

	public ObstaclePiece(char symbol, String label, int location) {
		// TODO Auto-generated constructor stub
		super(symbol, label, location);
	}
	
	//The player takes damage when landing on this piece.
	@Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == this.getLocation()) {
            return InteractionResult.HIT;
        }
        return InteractionResult.NONE;
    }
}

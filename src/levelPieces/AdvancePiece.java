package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/**
 * AdvancePiece allows the player to advance to the next level.
 */
public class AdvancePiece extends GamePiece {

	public AdvancePiece(char symbol, String label, int location) {
		// TODO Auto-generated constructor stub
		super(symbol, label, location);
	}
	
	//The player advances to the next level when landing on this piece.
	@Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        if (playerLocation == this.getLocation()) {
            return InteractionResult.ADVANCE; // Player advances to the next level
        }
        return InteractionResult.NONE; // No interaction otherwise
    }
}

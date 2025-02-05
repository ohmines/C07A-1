package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/**
 * PrizePiece grants the player a point when collected.
 */
public class PricePiece extends GamePiece {

	public PricePiece(char symbol, String label, int location) {
		// TODO Auto-generated constructor stub
		super(symbol, label, location);
	}
		
	//The player earns a point when they land near this piece (within one tile).
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(playerLocation - this.getLocation()) <= 1) {
			return InteractionResult.GET_POINT; //Player get points
		}
		return InteractionResult.NONE; // otherwise nothing happens
	}

}

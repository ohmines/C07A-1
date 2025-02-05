package levelPieces;

import gameEngine.Drawable;


/**
 * FlowerPiece is a purely decorative object with no interactions.
 */
public class FlowerPiece implements Drawable {
	private char symbol;
	
	public FlowerPiece(char symbol) {
		// TODO Auto-generated constructor stub
		this.symbol = symbol;
	}
	
	@Override
    public void draw() {
        System.out.print(symbol); // Simply draw the symbol
    }
}

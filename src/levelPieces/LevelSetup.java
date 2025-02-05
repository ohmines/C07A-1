package levelPieces;

import java.util.ArrayList;


import gameEngine.Drawable;
import gameEngine.Moveable;


public class LevelSetup {
	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStartLoc;

	public LevelSetup() {
		// TODO Auto-generated constructor stub
	}

	public void createLevel(int levelNum) {
		board = new Drawable[21];
		movingPieces = new ArrayList<>();
		interactingPieces = new ArrayList<>();
		
		if (levelNum == 1) {
			// Level 1 setup
			board[5] = new PricePiece('X', "Prize", 5);
			board[10] = new ObstaclePiece('O', "Obstacle", 10);
			board[15] = new MovingEnemy('K', "Killer", 15);
			board[18] = new RandomMover('G', "Goblin", 18);
			board[20] = new AdvancePiece('A', "Advance", 20);
			
			// Add moveable pieces
	        movingPieces.add((Moveable) board[15]); // MovingEnemy
	        movingPieces.add((Moveable) board[18]); // RandomMover
	        
	        // Add interacting pieces
	        interactingPieces.add((GamePiece) board[5]); // PrizePiece
	        interactingPieces.add((GamePiece) board[10]); // ObstaclePiece
	        interactingPieces.add((GamePiece) board[15]); // MovingEnemy
	        interactingPieces.add((GamePiece) board[18]); // RandomMover
	        interactingPieces.add((GamePiece) board[20]); // AdvancePiece
			
	        
	        // Set player start location
	        playerStartLoc = 0;
	    } 
		else if (levelNum == 2) {
	        // Level 2 setup
	        board[18] = new SniperPiece('S', "Sniper", 18);
	        board[7] = new PricePiece('X', "Prize", 7);
	        board[12] = new FlowerPiece('F'); // Drawable-only
	        board[16] = new MovingEnemy('K', "Killer", 16);
	        board[3] = new RandomMover('G', "Goblin", 3);

	       
	        movingPieces.add((Moveable) board[16]); // MovingEnemy


	        movingPieces.add((Moveable) board[3]); // RandomMover

	        // Add interacting pieces
	        interactingPieces.add((GamePiece) board[18]); // DistancePiece
	        interactingPieces.add((GamePiece) board[7]); // PrizePiece
	        interactingPieces.add((GamePiece) board[16]); // MovingEnemy
	        interactingPieces.add((GamePiece) board[3]); // RandomMover

	        // Set player start location
	        playerStartLoc = 1;
	    }
	}

	public Drawable[] getBoard() {
		// TODO Auto-generated method stub
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		// TODO Auto-generated method stub
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		// TODO Auto-generated method stub
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		return playerStartLoc;
	}

}

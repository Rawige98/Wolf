package Controller;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import Model.Game;
import Model.Player;
import Model.SysData;
import Model.Tile;
import Utils.DataType;
import Utils.GameStatus;
import Utils.MoveType;
import View.Piece;
import javafx.scene.paint.Color;

public class PlayGameController {
	private static PlayGameController instance;
	private Game game;

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	private  Player player1;
	private  Player player2;
	private PlayGameController() {
	}

	public static PlayGameController getInstance() {
		if (instance == null)
			instance = new PlayGameController();
		return instance;
	}

	public void startGame(Player p1, Player p2) {
		player1=p1;
		player2=p2;
		game = new Game(p1, p2);

	}

	public MoveType movePiece(int oldX, int oldY, int newX, int newY) {
		MoveType type = game.move(oldX, oldY, newX, newY);
		return type;
	}
	public boolean switchTurnNow() {
//		if(game.getBoard().checkAvailableMoves
//				(!Game.getIsP1Turn()).isEmpty())
//		{
//			game.finishGame(GameStatus.FINISH);
//			Game.notFinished=false;
//			SysData.getInstance().saveGame(DataType.FINISHED_GAMES,game);
//			return false;
//			
//		}
//		else
//		{
			game.switchTurn();	
			return true;
//		}
		
	}

	//	public ArrayList<Tile> returnYellowTiles() {
	//		return (game.getBoard().showYellowTiles());
	//	}

	
	public boolean isLastMove() {
		System.out.println(game.getBoard().checkAvailableMoves(!Game.getIsP1Turn()));
		if(game.getBoard().checkAvailableMoves(!Game.getIsP1Turn()).isEmpty())
		{
			game.finishGame(GameStatus.FINISH);
			Game.notFinished=false;
			SysData.getInstance().saveGame(DataType.FINISHED_GAMES,game);
			return true;
			
		}
		return false;
	}
	
	public boolean isQueen(int x, int y)
	{
		return(game.getBoard().getTile(y, x).isQueen());
	}
	
	public boolean isYellowTile(int x, int y) {
		if (game.getBoard().getTile(y, x).getColor().equals(Color.YELLOW)) {
			return true;
		}

		return false;
	}
	
	
	public ArrayList<Tile> blueMoveSuggestedTiles(boolean isBlack)
	{
		return game.getBlueSuggtedTiles(isBlack);
	}
	
	
	
	
	public void getBackSoldierToLife(int x, int y)
	{
		game.addSoldier(x,y);
	}
	
	/*
	 * public void startGame(String username1, String username2) {
	 * 
	 * GameStatus status = GameStatus.FINISH; String turnString, scoresStatus,
	 * moveInput; Player playerToPlay; Player player1 = new Player(username1);
	 * Player player2 = new Player(username2); Game game = new Game(player1,
	 * player2);
	 * 
	 * while (!game.finishGame(status)) { playerToPlay = game.showPlayerTurn();
	 * turnString = String.format("%s's turn:", playerToPlay.getUsername()); //
	 * check the score of each player to view on the game view
	 * game.checkColorsToShow(); game.finishGame(status); boolean
	 * legalFirstMoveInput = false; while (!legalFirstMoveInput) {
	 * 
	 * // get the moves input
	 * 
	 * // game.move(fromX, fromY, toX, toY); game.getBoard().turnOffAllTilesColor();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * // game.run();
	 * 
	 * }
	 */
	public static void setInstance(PlayGameController instance) {
		PlayGameController.instance = instance;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void checkTilesToBeColored() {
		game.checkColorsToShow();
	}

	public Color getTileColor(int x, int y) {
		return game.getBoard().getMyBoard()[x][y].getColor();
	}

	public ArrayList<Tile> getSuggestedTilesArrayForPlayer(){
		return game.getSuggestedTilesArray();
	}

	public void colorRandomTile(ArrayList<Tile> tiles , Color color) {
		game.getBoard().colorRandomTile(tiles, color);
	}

	public void colorAllTiles(ArrayList<Tile> tiles , Color color) {
		game.getBoard().colorAllTiles(tiles, color);
	}

	public Player getCurrentPlayer() {
		// TODO Auto-generated method stub
		return game.isP1Turn() ? game.getPlayer1() : game.getPlayer2();
	}

	public boolean checkMovesAvailability(int x , int y) {
		HashMap<Tile, ArrayList<Tile>> suggestedMoves= game.getAvailableMoves();
		Tile tile = game.getBoard().getMyBoard()[x][y];
		return suggestedMoves.keySet().contains(tile);
	}
	
	public boolean checkIfQueen(int x, int y) {
		return game.getBoard().getMyBoard()[x][y].isQueen();
	}
	
	public boolean haveAnotherKill(int x, int y) {
		Tile currTile = game.getBoard().getTile(x, y);
		System.out.println("Current: "+currTile.longString());
		System.out.println("Player1:" + Game.getIsP1Turn());
		ArrayList<Tile> suggestedSkips = game.getBoard().avilableSkipsForTile(currTile, Game.getIsP1Turn());
		System.out.println(suggestedSkips);
		for(Tile tile : suggestedSkips) {
			System.out.println(tile.longString());
		}
		System.out.println("will return -" + !suggestedSkips.isEmpty() + "- for another kill");
		return !suggestedSkips.isEmpty();
	}
}

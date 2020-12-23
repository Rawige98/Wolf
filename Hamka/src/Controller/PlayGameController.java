package Controller;

import Model.Game;
import Model.Player;
import Utils.GameStatus;
import Utils.MoveType;

public class PlayGameController {
	private static PlayGameController instance;
	private  Game game;

	private PlayGameController() {
	}

	public static PlayGameController getInstance() {
		if (instance == null)
			instance = new PlayGameController();
		return instance;
	}

	public void startGame(Player p1, Player p2) {

		game = new Game(p1, p2);

	}

	public MoveType movePiece(int oldX, int oldY, int newX, int newY) {
		return game.getBoard().move(oldX, oldY, newX, newY, true, game.getPlayer1());
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

}
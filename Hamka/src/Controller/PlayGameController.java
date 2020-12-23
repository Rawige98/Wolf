package Controller;

import Model.Game;
import Model.Player;
import Utils.GameStatus;

public class PlayGameController {
	private static PlayGameController instance;
	

	private PlayGameController() {
	}

	public static PlayGameController getInstance() {
		if (instance == null)
			instance = new PlayGameController();
		return instance;
	}

	public void startGame(String username1, String username2) {

		GameStatus status = GameStatus.FINISH;
		String turnString, scoresStatus, moveInput;
		Player playerToPlay;
		Player player1 = new Player(username1);
		Player player2 = new Player(username2);
		Game game = new Game(player1, player2);

		while (!game.finishGame(status)) {
			playerToPlay = game.showPlayerTurn();
			turnString = String.format("%s's turn:", playerToPlay.getUsername());
			// check the score of each player to view on the game view
			game.checkColorsToShow();
			game.finishGame(status);
			boolean legalFirstMoveInput = false;
			while (!legalFirstMoveInput) {

				// get the moves input

				// game.move(fromX, fromY, toX, toY);
				game.getBoard().turnOffAllTilesColor();

			}

		}

		// game.run();

	}

	public static void setInstance(PlayGameController instance) {
		PlayGameController.instance = instance;
	}

}

package View;

import Utils.Consts;
import Utils.PieceType;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Piece extends StackPane {
	
	public PieceType pieceType;
	public String iconPath;
	private double mouseX, mouseY, oldX, oldY;
	
	public Piece(PieceType pieceType, int x, int y ,String iconPath) {
		this.pieceType = pieceType;
		oldX = x * Consts.TILE_SIZE;	
		oldY = y * Consts.TILE_SIZE;
		this.iconPath = iconPath;
		
		relocate(x * Consts.TILE_SIZE, y * Consts.TILE_SIZE	);
		
		Ellipse bgEllipse = new Ellipse(Consts.TILE_SIZE*0.3125 , Consts.TILE_SIZE*0.26);
		bgEllipse.setFill(Color.WHITE);
		
		bgEllipse.setStroke(Color.BLACK);
		bgEllipse.setStrokeWidth(Consts.TILE_SIZE * 0.03);
		
		bgEllipse.setTranslateX((Consts.TILE_SIZE - Consts.TILE_SIZE * 0.3125 * 2) / 2);
		bgEllipse.setTranslateY((Consts.TILE_SIZE - Consts.TILE_SIZE * 0.26 * 2) / 2 + Consts.TILE_SIZE * 0.07);
		
		Ellipse ellipse = new Ellipse(Consts.TILE_SIZE*0.3125 , Consts.TILE_SIZE*0.26);
		ellipse.setFill(pieceType == PieceType.RED ? Color.RED : Color.BLUE);
		
		ellipse.setStroke(Color.BLACK);
		ellipse.setStrokeWidth(Consts.TILE_SIZE * 0.03);
		
		ellipse.setTranslateX((Consts.TILE_SIZE - Consts.TILE_SIZE * 0.3125 * 2) / 2);
		ellipse.setTranslateY((Consts.TILE_SIZE - Consts.TILE_SIZE * 0.26 * 2) / 2);
		
		getChildren().addAll(bgEllipse , ellipse);
		
		setOnMousePressed(e -> {
			mouseX = e.getSceneX();
			mouseY = e.getSceneY();
		});
		
		setOnMouseDragged(e ->{
			relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
		});
	}
	
	public PieceType getPieceType() {
		return pieceType;
	}
	
	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}
	
	public void move(int x, int y) {
		oldX = x*Consts.TILE_SIZE;
		oldY = y*Consts.TILE_SIZE;
		relocate(oldX, oldY);
	}
	
	public double getOldX() {
		return oldX;
	}
	public double getOldY() {
		return oldY;
	}
	
	public void aboartMove() {
		relocate(oldX, oldY);
	}
}
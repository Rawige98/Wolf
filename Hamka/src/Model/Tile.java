package Model;

import java.awt.Color;


public class Tile implements Cloneable,TileOperations{
	private int value;
	private java.awt.Color color;
	private int rows;
	private int cols;
	public static final String TEXT_RESET = "\u001B[0m";
	public static final String TEXT_BLACK = "\u001B[30m";
	public static final String TEXT_RED = "\u001B[31m";
	public static final String TEXT_GREEN = "\u001B[32m";
	public static final String TEXT_YELLOW = "\u001B[33m";
	public static final String TEXT_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String TEXT_WHITE = "\u001B[37m";
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


	
	public Tile(int value, java.awt.Color color,  int cols,int rows) {
		super();
		this.value = value;
		this.color = color;
		this.rows = rows;
		this.cols = cols;
	}

	// -------------------Getters and Setters-----------
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public java.awt.Color getColor() {
		return color;
	}

	public void setColor(java.awt.Color color) {
		this.color = color;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	// ------------------------------------

	//Clone Factory
	public Tile getClone(Tile t) {
		
		return t.makeCopy();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cols;
		result = prime * result + rows;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (cols != other.cols)
			return false;
		if (rows != other.rows)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return value+"";
	}

	@Override
	public boolean upgradeToQueen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isQueen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tile makeCopy() {
		// TODO Auto-generated method stub
		return null;
	}

}

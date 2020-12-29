package Model;

import java.awt.Color;

public class WhiteSoldier extends Tile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WhiteSoldier(int cols, int rows) {
		super(1,  Color.black, cols, rows);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean upgradeToQueen() {
		if( MoveValidation.toIndex(getRows(), getCols()) >= 0 && MoveValidation.toIndex(getRows(), getCols()) < 4)
		{
			setValue(11);
			return true;
		}
			return false;
		}
	@Override
	public boolean isQueen() {
		if(getValue()==11)
			return true;
		return false;
	}
	@Override
	public Tile makeCopy() {
		WhiteSoldier w=null;
		try {
			w=(WhiteSoldier)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return w;
	}
	@Override
	public String subClass() {
		// TODO Auto-generated method stub
		return "WhiteSoldier";
	}
}

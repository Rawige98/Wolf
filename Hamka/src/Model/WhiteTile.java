package Model;

import java.awt.Color;

public class WhiteTile extends Tile{

	public WhiteTile(int cols, int rows) {
		super(0,  Color.white, cols, rows);
		// TODO Auto-generated constructor stub
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
		WhiteTile w=null;
		try {
			w=(WhiteTile)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return w;
	}

}
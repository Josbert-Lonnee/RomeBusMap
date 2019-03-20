package com.josbertlonnee.util;

public enum Direction8
{
	N (0,  0, -1),
	NE(1,  1, -1),
	E (2,  1,  0),
	SE(3,  1,  1),
	S (4,  0,  1),
	SW(5, -1,  1),
	W (6, -1,  0),
	NW(7, -1, -1);
	
	private int n;
	private Vector vector;
	
	Direction8(int n, double vx, double vy)
	{
		this.n = n;
		vector = new Vector(vx, vy);
	}
	
	public Vector getVector(double scale)
	{
		return new Vector(vector).scale(scale);
	}
	
	/**
	 * Number of rotation steps to turn to the right from this direction to the other. 
	 * @param d2 The other direction.
	 * @return 1 for one rotation step to the right, -1 for one rotation step to the left, etc. Always 4 for the opposite direction.
	 */
	public int relativeRotationTo(Direction8 d2)
	{
		int r = d2.n - n;
		
		if (r <= -4)
			return r + 8;
		
		if (r > 4)
			return r - 8;
		
		return r;
	}
	
	/**
	 * The direction in degrees (360).
	 * @return 0 for north
	 */
	public int getDegrees()
	{
		return 45 * n;
	}
}

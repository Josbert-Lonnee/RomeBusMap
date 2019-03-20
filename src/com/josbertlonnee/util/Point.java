package com.josbertlonnee.util;

public class Point extends AbstractPoint
{
	public Point(double x, double y)
	{
		super(x, y);
	}
	
	/** Create a copy. */
	public Point(AbstractPoint p)
	{
		super(p);
	}
	
	public Point move(Vector v)
	{
		this.x += v.x;
		this.y += v.y;
		return this;
	}
}

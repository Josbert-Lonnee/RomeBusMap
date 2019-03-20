package com.josbertlonnee.util;

public abstract class AbstractPoint
{
	protected double x;
	protected double y;
	
	protected AbstractPoint(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	/** Create a copy. */
	protected AbstractPoint(AbstractPoint p)
	{
		this.x = p.x;
		this.y = p.y;
	}
	
	public double x()
	{
		return x;
	}
	
	public double y()
	{
		return y;
	}
	
	@Override
	public String toString()
	{
		return "(" + x + ',' + y + ')';
	}
}

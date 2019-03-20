package com.josbertlonnee.svg;

import com.josbertlonnee.util.AbstractPoint;

public class SvgPoint
{
	private int x;
	private int y;
	
	public SvgPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public SvgPoint(AbstractPoint p, int scale)
	{
		this.x = (int)Math.round(p.x() * scale);
		this.y = (int)Math.round(p.y() * scale);
	}
	
	public int x()
	{
		return x;
	}
	
	public int y()
	{
		return y;
	}
}

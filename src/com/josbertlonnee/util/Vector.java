package com.josbertlonnee.util;

public class Vector extends AbstractPoint
{
	public Vector(double x, double y)
	{
		super(x, y);
	}
	
	/** Create a copy. */
	public Vector(AbstractPoint p)
	{
		super(p);
	}
	
	public Vector add(Vector v)
	{
		this.x += v.x;
		this.y += v.y;
		return this;
	}
	
	public Vector subtract(Vector v)
	{
		this.x -= v.x;
		this.y -= v.y;
		return this;
	}
	
	public Vector multiply(Vector v)
	{
		this.x *= v.x;
		this.y *= v.y;
		return this;
	}
	
	public Vector scale(Vector v)
	{
		this.x *= v.x;
		this.y *= v.y;
		return this;
	}
	
	public Vector scale(double s)
	{
		this.x *= s;
		this.y *= s;
		return this;
	}
}

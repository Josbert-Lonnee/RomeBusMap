package com.josbertlonnee.util;

public class RgbColor implements Color
{
	private int red;
	private int green;
	private int blue;

	public RgbColor(int red, int green, int blue)
	{
		this.red   = red  ;
		this.green = green;
		this.blue  = blue ;
	}

	@Override
	public String toSvgString()
	{
		StringBuilder sb = new StringBuilder(16);
		
		sb.append("rgb(");
		sb.append(red);
		sb.append(',');
		sb.append(green);
		sb.append(',');
		sb.append(blue);
		sb.append(')');
		
		return sb.toString();
	}

	@Override
	public String toString()
	{
		return toSvgString();
	}
}

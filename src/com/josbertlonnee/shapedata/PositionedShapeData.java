package com.josbertlonnee.shapedata;

import com.josbertlonnee.util.Point;

public class PositionedShapeData
{
	protected Point position;
	
	protected PositionedShapeData(Point position)
	{
		this.position = new Point(position);
	}
	
	public Point getPosition()
	{
		return new Point(position);
	}
}

package com.josbertlonnee;

import com.josbertlonnee.transport.Label;
import com.josbertlonnee.util.*;

public class PlaceLabel extends Label
{
	public static final double SIZE = 1.5;
	public static final Color COLOR = SpecificColor.BLACK;
	
	public PlaceLabel(Point position, double rotationDegrees, String text)
	{
		super(position, text, SIZE, COLOR);
		
		setRotation(rotationDegrees);
	}
}

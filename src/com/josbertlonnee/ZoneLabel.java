package com.josbertlonnee;

import com.josbertlonnee.transport.Label;
import com.josbertlonnee.util.*;

public class ZoneLabel extends Label
{
	public static final double SIZE = 2.0;
	public static final Color COLOR = SpecificColor.BLACK;
	
	public ZoneLabel(Point position, String text)
	{
		super(position, text, SIZE, COLOR);
	}
}

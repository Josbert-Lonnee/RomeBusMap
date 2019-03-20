package com.josbertlonnee;

import com.josbertlonnee.transport.Label;
import com.josbertlonnee.util.*;

public class AreaLabel extends Label
{
	public static final double SIZE = 3.0;
	public static final Color COLOR = new RgbColor(140,  10,  35);
	
	public AreaLabel(Point position, String text)
	{
		super(position, text, SIZE, COLOR);
	}
}

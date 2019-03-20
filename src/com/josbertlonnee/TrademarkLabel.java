package com.josbertlonnee;

import com.josbertlonnee.transport.Label;
import com.josbertlonnee.util.*;

public class TrademarkLabel extends Label
{
	public static final double SIZE = 0.8;
	public static final Color COLOR = new RgbColor(150, 150, 150);
	
	public TrademarkLabel(Point position, String text)
	{
		super(position, text, SIZE, COLOR);
	}
}

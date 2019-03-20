package com.josbertlonnee;

import com.josbertlonnee.transport.Zone;
import com.josbertlonnee.util.*;

public class TransferZone extends Zone
{
	private static final int SHADE = 210;
	private static final Color FILL_COLOR = new RgbColor(SHADE, SHADE, SHADE);
	private static final double[] DASH_ARRAY = { 0.5, 0.5 };
	
	public TransferZone(Point position, double width, double height, double rotationDegrees)
	{
		super(position, width, height, rotationDegrees, FILL_COLOR, 0.05, SpecificColor.BLACK, DASH_ARRAY);
	}
}

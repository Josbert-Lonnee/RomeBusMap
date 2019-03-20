package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class BusLineLabel extends AbstractBusLineAnnotation
{
	public static final double WIDTH  = 1.0;
	public static final double LENGTH = 2.4;
	
	@Override
	protected void createSvg(AbstractContainerSvgElement parentElement, BusLine line, Point position, int directionDegrees)
	{
		directionDegrees = GetDirectionUpright(directionDegrees - 90);
		
		SvgGroupElement group = new SvgGroupElement(parentElement);
		group.setPosition(position);
		group.setRotation(directionDegrees);
		
		SvgRectangleElement square = CreateCenteredSquare(group, LENGTH, WIDTH, line.getLineColor());
		square.setRoundedCorners(0.2);
		
		CreateCenteredText(group, WIDTH, line.getName(), SpecificColor.WHITE);
	}
}

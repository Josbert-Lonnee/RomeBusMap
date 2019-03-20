package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class BusLineTerminus extends AbstractBusLineAnnotation
{
	public static final double WIDTH  = 1.5;
	public static final double LENGTH = 3.8;
	
	@Override
	protected void createSvg(AbstractContainerSvgElement parentElement, BusLine line, Point position, int directionDegrees)
	{
		directionDegrees = GetDirectionUpright(directionDegrees - 90);
		
		SvgGroupElement group = new SvgGroupElement(parentElement);
		group.setPosition(position);
		group.setRotation(directionDegrees);
		
		SvgRectangleElement square = CreateCenteredSquare(group, LENGTH, WIDTH, line.getLineColor());
		square.setRoundedCorners(0.4);
		square.setStroke(SpecificColor.BLACK);
		square.setStrokeWidth(0.1);
		
		CreateCenteredText(group, WIDTH, line.getName(), SpecificColor.WHITE);
	}
}

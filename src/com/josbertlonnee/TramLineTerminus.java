package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class TramLineTerminus extends AbstractTramLineAnnotation
{
	private static final double WIDTH  = 1.5;
	private static final double LENGTH = 3.5;
	
	@Override
	protected void createSvg(AbstractContainerSvgElement parentElement, TramLine line, Point position, int directionDegrees)
	{
		directionDegrees = GetDirectionUpright(directionDegrees - 90);
		
		SvgGroupElement group = new SvgGroupElement(parentElement);
		group.setPosition(position);
		group.setRotation(directionDegrees);
		
		SvgRectangleElement square = CreateCenteredSquare(group, LENGTH, WIDTH, TramLine.COLOR);
		square.setRoundedCorners(0.2);
		square.setStroke(SpecificColor.BLACK);
		square.setStrokeWidth(0.1);
		
		CreateCenteredText(group, WIDTH, line.getName(), SpecificColor.WHITE);
	}
}

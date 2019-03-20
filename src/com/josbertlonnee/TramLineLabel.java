package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class TramLineLabel extends AbstractTramLineAnnotation
{
	private static final double WIDTH  = 1.0;
	private static final double LENGTH = 2.5;
	
	@Override
	protected void createSvg(AbstractContainerSvgElement parentElement, TramLine line, Point position, int directionDegrees)
	{
		directionDegrees = GetDirectionUpright(directionDegrees - 90);
		
		SvgGroupElement group = new SvgGroupElement(parentElement);
		group.setPosition(position);
		group.setRotation(directionDegrees);
		
		SvgRectangleElement square = CreateCenteredSquare(group, LENGTH, WIDTH, TramLine.COLOR);
		square.setRoundedCorners(0.2);
		
		CreateCenteredText(group, WIDTH, line.getName(), SpecificColor.WHITE);
	}
}

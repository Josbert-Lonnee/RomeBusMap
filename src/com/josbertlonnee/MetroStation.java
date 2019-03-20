package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class MetroStation extends AbstractMetroLineAnnotation
{
	private static final double SVG_SIZE = 1.7;
	private static final Color COLOR = new RgbColor(225, 0, 30);
	
	@Override
	protected void createSvg(AbstractContainerSvgElement parentElement, MetroLine line, Point position, int directionDegrees)
	{
		SvgGroupElement group = new SvgGroupElement(parentElement);
		group.setPosition(position);
		
		SvgRectangleElement square = CreateCenteredSquare(group, SVG_SIZE, SVG_SIZE, COLOR);
		square.setRoundedCorners(0.2);
		
		CreateCenteredText(group, SVG_SIZE, "M", SpecificColor.WHITE);
	}
}

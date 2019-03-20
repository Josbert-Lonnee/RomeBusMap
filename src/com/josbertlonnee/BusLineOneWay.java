package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class BusLineOneWay extends AbstractBusLineAnnotation
{
	@Override
	protected void createSvg(AbstractContainerSvgElement parentElement, BusLine line, Point position, int directionDegrees)
	{
		SvgPolygonElement polygon = new SvgPolygonElement(parentElement, new Vector(0, 0));
		polygon.setPosition(position);
		polygon.setRotation(directionDegrees);
		polygon.setFill(line.getLineColor());
		
		final double width = BusLine.WIDTH;
		
		polygon.addPoint( new Vector( 2, 4).scale(width) );
		polygon.addPoint( new Vector( 0, 3).scale(width) );
		polygon.addPoint( new Vector(-2, 4).scale(width) );
	}
}

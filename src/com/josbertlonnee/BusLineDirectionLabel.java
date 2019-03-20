package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class BusLineDirectionLabel extends AbstractBusLineAnnotation
{
	public static final double LENGTH = 10;
	
	private String direction;
	private boolean toNotFrom;
	
	public BusLineDirectionLabel(String direction, boolean toNotFrom)
	{
		this.direction = direction;
		this.toNotFrom = toNotFrom;
	}
	
	@Override
	protected void createSvg(AbstractContainerSvgElement parentElement, BusLine line, Point position, int directionDegrees)
	{
		SvgGroupElement group = new SvgGroupElement(parentElement);
		group.setPosition(position);
		group.setRotation( directionDegrees + (toNotFrom ? 0 : 180) );
		
		Vector scale = new Vector(BusLineLabel.WIDTH / 2, LENGTH / 2);
		SvgPolygonElement polygon = new SvgPolygonElement(group, new Vector(0, -1.25).scale(scale));
		polygon.addPoint(new Vector( 1, -1).scale(scale));
		polygon.addPoint(new Vector( 1,  1).scale(scale));
		polygon.addPoint(new Vector(-1,  1).scale(scale));
		polygon.addPoint(new Vector(-1, -1).scale(scale));
		polygon.setFill(line.getLineColor());
		
		SvgGroupElement group2 = new SvgGroupElement(parentElement);
		group2.setPosition(position);
		group2.setRotation( GetDirectionUpright(directionDegrees - 90) );
		
		CreateCenteredText(group2, BusLineLabel.WIDTH, direction, SpecificColor.WHITE);
	}
}

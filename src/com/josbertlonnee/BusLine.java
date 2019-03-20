package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.transport.*;
import com.josbertlonnee.util.*;

public class BusLine extends AbstractLineWithAnnotationsShapeData<BusLine, BusLineLeg, AbstractBusLineAnnotation>
{
	public static final double WIDTH = 0.3;
	
	private Color lineColor;
	private String name;

	public BusLine(String name, Color lineColor, Point startPosition)
	{
		super(/*cornerRadius=*/0.5, startPosition);
		
		this.lineColor = lineColor;
		this.name = name;
	}
	
	@Override
	protected BusLineLeg createLegData(Direction8 direction, double length)
	{
		return new BusLineLeg(direction, length);
	}

	@Override
	protected void createPathSvg(AbstractContainerSvgElement parentElement)
	{
		SvgPathElement path = createSvgPath(parentElement);
		path.setStroke(lineColor);
		path.setStrokeWidth(WIDTH);
	}

	final String getName()
	{
		return name;
	}

	final Color getLineColor()
	{
		return lineColor;
	}
}

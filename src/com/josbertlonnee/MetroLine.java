package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.transport.*;
import com.josbertlonnee.util.*;

public class MetroLine extends AbstractLineWithAnnotationsShapeData<MetroLine, MetroLineLeg, AbstractMetroLineAnnotation>
{
	private static final double WIDTH = 0.6;
	
	private Color lineColor;

	public MetroLine(Point startPosition, Color lineColor)
	{
		super(/*cornerRadius=*/1.5, startPosition);
		
		this.lineColor = lineColor;
	}
	
	public Color getLineColor()
	{
		return lineColor;
	}
	
	@Override
	protected MetroLineLeg createLegData(Direction8 direction, double length)
	{
		return new MetroLineLeg(direction, length);
	}

	@Override
	protected void createPathSvg(AbstractContainerSvgElement parentElement)
	{
		SvgPathElement path = createSvgPath(parentElement);
		path.setStroke(lineColor);
		path.setStrokeWidth(WIDTH);
	}
}

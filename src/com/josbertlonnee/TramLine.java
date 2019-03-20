package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.transport.*;
import com.josbertlonnee.util.*;

public class TramLine extends AbstractLineWithAnnotationsShapeData<TramLine, TramLineLeg, AbstractTramLineAnnotation>
{
	public static final double WIDTH = 0.3;
	public static final Color COLOR = new RgbColor(40, 155, 85);
	public static final double[] STROKE_DASH_ARRAY = { 0.2, 0.3 };

	private String name;

	public TramLine(String name, Point startPosition)
	{
		super(/*cornerRadius=*/0.5, startPosition);
		
		this.name = name;
	}
	
	@Override
	protected TramLineLeg createLegData(Direction8 direction, double length)
	{
		return new TramLineLeg(direction, length);
	}

	@Override
	protected void createPathSvg(AbstractContainerSvgElement parentElement)
	{
		SvgPathElement path = createSvgPath(parentElement);
		path.setStroke(COLOR);
		path.setStrokeWidth(WIDTH);
		
		path = createSvgPath(parentElement);
		path.setStroke(COLOR);
		path.setStrokeWidth(2 * WIDTH);
		path.setStrokeDashArray(STROKE_DASH_ARRAY);
	}

	final String getName()
	{
		return name;
	}
}

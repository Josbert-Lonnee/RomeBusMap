package com.josbertlonnee;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.transport.*;
import com.josbertlonnee.util.*;

public class TrainLine extends AbstractLineWithAnnotationsShapeData<TrainLine, TrainLineLeg, TrainStation>
{
	private static final double WIDTH = 0.6;
	private static final int SHADE = 80;
	public static final Color COLOR = new RgbColor(SHADE, SHADE, SHADE);
	private static final double[] STROKE_DASH_ARRAY = { 0.2, 0.4 };
	
	public TrainLine(Point startPosition)
	{
		super(/*cornerRadius=*/2.5, startPosition);
	}
	
	@Override
	protected TrainLineLeg createLegData(Direction8 direction, double length)
	{
		return new TrainLineLeg(direction, length);
	}

	@Override
	protected void createPathSvg(AbstractContainerSvgElement parentElement)
	{
		SvgPathElement path = createSvgPath(parentElement);
		path.setStroke(COLOR);
		path.setStrokeWidth(WIDTH);
		
		path = createSvgPath(parentElement);
		path.setStroke(COLOR);
		path.setStrokeWidth(3*WIDTH / 2);
		path.setStrokeDashArray(STROKE_DASH_ARRAY);
	}
}

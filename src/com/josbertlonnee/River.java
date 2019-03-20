package com.josbertlonnee;

import com.josbertlonnee.shapedata.*;
import com.josbertlonnee.svg.*;
import com.josbertlonnee.transport.*;
import com.josbertlonnee.util.*;

public class River extends AbstractLineWithAnnotationsShapeData<River, Direction8LegData<AbstractAnnotationData<River>>, AbstractAnnotationData<River>>
{
	public static final double WIDTH = 6.0;
	public static final double CORNER_RADIUS = 4.0;
	public static final Color COLOR = new RgbColor(200, 200, 255);
	
	public River(Point startPosition)
	{
		super(CORNER_RADIUS, startPosition);
	}

	@Override
	protected void createPathSvg(AbstractContainerSvgElement parentElement)
	{
		SvgPathElement path = createSvgPath(parentElement);
		path.setStroke(COLOR);
		path.setStrokeWidth(WIDTH);
		path.setStrokeOpacity(0.3);
	}
}

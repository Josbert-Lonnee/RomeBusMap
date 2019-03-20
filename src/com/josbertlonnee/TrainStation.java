package com.josbertlonnee;

import com.josbertlonnee.shapedata.AbstractAnnotationData;
import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class TrainStation extends AbstractAnnotationData<TrainLine>
{
	private static final double SVG_WIDTH  = 2.5;
	private static final double SVG_LENGTH = 4.0;
	
	@Override
	protected void createSvg(AbstractContainerSvgElement parentElement, TrainLine line, Point position, int directionDegrees)
	{
		SvgGroupElement group = new SvgGroupElement(parentElement);
		group.setPosition(position);
		group.setRotation(directionDegrees + 90);
		
		SvgRectangleElement square = new SvgRectangleElement(group, new Point(-SVG_LENGTH/2, -SVG_WIDTH/2), new Vector(SVG_LENGTH, SVG_WIDTH));
		square.setFill(TrainLine.COLOR);
		square.setRoundedCorners(SVG_WIDTH / 6);
	}
}

package com.josbertlonnee.transport;

import com.josbertlonnee.shapedata.*;
import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class Zone extends AbstractMultiPhaseShapeData<AbstractShapeData>
{
	private Point position;
	private double width;
	private double height;
	private double rotationDegrees;
	
	private Color fillColor;
	private double strokeWidth;
	private Color strokeColor;
	private double[] strokeDashArray;
	
	public Zone(Point position, double width, double height, double rotationDegrees, Color fillColor, double strokeWidth, Color strokeColor, double[] strokeDashArray)
	{
		this.position        = position;
		this.rotationDegrees = rotationDegrees;
		this.width           = width;
		this.height          = height;
		
		this.fillColor       = fillColor;
		this.strokeWidth     = strokeWidth;
		this.strokeColor     = strokeColor;
		this.strokeDashArray = strokeDashArray;
	}

	@Override
	public final int getNumberOfSvgCreatePhases()
	{
		return 1;
	}

	@Override
	public final void createSvg(AbstractContainerSvgElement parentElement, int phase)
	{
		if (phase == 0)
			createZoneSvg(parentElement);
	}

	private void createZoneSvg(AbstractContainerSvgElement parentElement)
	{
		SvgGroupElement group = new SvgGroupElement(parentElement);
		group.setPosition(position);
		group.setRotation(rotationDegrees);
		
		SvgRectangleElement square = CreateCenteredSquare(group, width, height, fillColor);
		square.setRoundedCorners(1.0);
		square.setStrokeWidth(strokeWidth);
		square.setStroke(strokeColor);
		square.setStrokeDashArray(strokeDashArray);
		square.setFillOpacity(0.3);
	}
}

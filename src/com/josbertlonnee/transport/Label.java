package com.josbertlonnee.transport;

import com.josbertlonnee.shapedata.*;
import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public class Label extends AbstractMultiPhaseShapeData<AbstractShapeData>
{
	private Point position;
	private double rotation;
	private String text;
	private double fontSize;
	private Color color;
	
	public Label(Point position, String text, double fontSize, Color color)
	{
		this.position = position;
		this.text     = text;
		this.fontSize = fontSize;
		this.color    = color;
	}
	
	protected void setRotation(double rotation)
	{
		this.rotation = rotation;
	}

	@Override
	public final int getNumberOfSvgCreatePhases()
	{
		return 4;
	}

	@Override
	public final void createSvg(AbstractContainerSvgElement parentElement, int phase)
	{
		if (phase == 3)
			createLabelSvg(parentElement);
	}

	private void createLabelSvg(AbstractContainerSvgElement parentElement)
	{
		SvgGroupElement group = new SvgGroupElement(parentElement);
		group.setPosition(position);
		group.setRotation(rotation);
		
		SvgTextElement svgText = CreateCenteredText(group, fontSize, text, color);
		svgText.setStrokeWidth(fontSize / 40);
		svgText.setStroke( SvgDocument.GetBackgroundColor() );
	}
}

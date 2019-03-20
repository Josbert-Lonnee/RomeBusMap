package com.josbertlonnee.shapedata;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public abstract class AbstractShapeData
{
	protected static final int GetDirectionNormalized(int direction)
	{
		if (direction >= 360)
			direction -= (direction / 360) * 360;
		
		if (direction < 0)
			direction += ((-direction / 360) + 1) * 360;
		
		return direction;
	}
	
	protected static final int GetDirectionUpright(int direction)
	{
		direction = GetDirectionNormalized(direction);
		
		if (direction > 90 && direction <= 270)
			direction += 180;
		
		if (direction >= 360)
			direction -= 360;
		
		return direction;
	}
	
	protected final static SvgRectangleElement CreateCenteredSquare(AbstractContainerSvgElement parentElement, double width, double height, Color fillColor)
	{
		SvgRectangleElement rectangleElement = new SvgRectangleElement(parentElement, new Point(-width/2.0, -height/2.0), new Vector(width, height));
		rectangleElement.setFill(fillColor);
		return rectangleElement;
	}
	
	protected final static SvgTextElement CreateCenteredText(AbstractContainerSvgElement parentElement, double size, String text, Color color)
	{
		double textWidth =  size * CalculateTextWidthFactor("Arial", true, text); 
		
		SvgTextElement textElement = new SvgTextElement(parentElement, new Point(-textWidth/2, (size/2) * 0.7), text, color);
		textElement.setFontFamily("Arial,sans-serif");
		textElement.setFontSize(size);
		textElement.setBold(true);
		return textElement;
	}
	
	protected final static double CalculateTextWidthFactor(String fontName, boolean bold, String text)
	{
		final int factor = 10000;
		
		AffineTransform affinetransform = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
		Font font = new Font("Arial", bold ? Font.BOLD : Font.PLAIN, factor);
		return ( font.getStringBounds(text, frc).getWidth() / factor );
	}
}

package com.josbertlonnee.svg;

import org.w3c.dom.Element;

import com.josbertlonnee.util.*;

public abstract class AbstractStrokeSvgElement extends AbstractTransformableSvgElement
{
	private Color color;
	private double width;
	private double opacity = 1.0;
	private double[] strokeDashArray;
	
	protected AbstractStrokeSvgElement(AbstractContainerSvgElement parentElement, Point position)
	{
		super(parentElement, position);
	}
	
	public void setStroke(Color color)
	{
		this.color = color;
	}
	
	public void setStrokeWidth(double width)
	{
		this.width = width;
	}
	
	public void setStrokeOpacity(double opacity)
	{
		this.opacity = opacity;
	}

	public void setStrokeDashArray(double[] strokeDashArray)
	{
		this.strokeDashArray = strokeDashArray;
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		setDomAttribute       (domElement, "stroke"          , color  );
		setDomAttributeScaled (domElement, "stroke-width"    , width  );
		setDomOpacityAttribute(domElement, "stroke-opacity"  , opacity);
		setDomAttributesScaled (domElement, "stroke-dasharray", strokeDashArray, ',' );
		
		super.fillDomElement(domElement);
	}
}

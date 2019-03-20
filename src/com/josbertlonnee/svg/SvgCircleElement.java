package com.josbertlonnee.svg;

import org.w3c.dom.Element;

import com.josbertlonnee.util.Point;

public class SvgCircleElement extends AbstractStrokeAndFillSvgElement
{
	private double radius;

	protected SvgCircleElement(AbstractContainerSvgElement parentElement, Point position, double radius)
	{
		super(parentElement, position);
		
		this.radius = radius;
	}

	@Override
	protected final String getDomElementQualifiedName()
	{
		return "circle";
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		setDomAttributeScaled(domElement, "r", radius);
		
		super.fillDomElement(domElement);
	}
}

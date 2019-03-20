package com.josbertlonnee.svg;

import org.w3c.dom.Element;

import com.josbertlonnee.util.*;

public class SvgRectangleElement extends AbstractStrokeAndFillSvgElement
{
	private Vector size;
	private double cornerRadius;
	
	public SvgRectangleElement(AbstractContainerSvgElement parentElement, Point position, Vector size)
	{
		super(parentElement, position);
		
		this.size = size;
	}
	
	@Override
	protected final String getDomElementQualifiedName()
	{
		return "rect";
	}
	
	public void setSize(Vector size)
	{
		this.size = size;
	}
	
	public void setRoundedCorners(double cornerRadius)
	{
		this.cornerRadius = cornerRadius;
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		setDomPointAttributesScaled(domElement, "width", "height", size);
		
		setDomAttributeScaled(domElement, "rx", cornerRadius);
		setDomAttributeScaled(domElement, "ry", cornerRadius);
		
		super.fillDomElement(domElement);
	}
}

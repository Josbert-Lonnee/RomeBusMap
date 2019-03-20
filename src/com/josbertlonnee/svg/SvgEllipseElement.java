package com.josbertlonnee.svg;

import org.w3c.dom.Element;

import com.josbertlonnee.util.*;

public class SvgEllipseElement extends AbstractStrokeAndFillSvgElement
{
	private Vector radia;
	
	public SvgEllipseElement(AbstractContainerSvgElement parentElement, Point position, Vector radia)
	{
		super(parentElement, position);
		
		this.radia = radia;
	}

	@Override
	protected final String getDomElementQualifiedName()
	{
		return "ellipse";
	}
	
	public void setRadia(Vector radia)
	{
		this.radia = radia;
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		setDomPointAttributesScaled(domElement, "rx", "ry", radia);
		
		super.fillDomElement(domElement);
	}
}

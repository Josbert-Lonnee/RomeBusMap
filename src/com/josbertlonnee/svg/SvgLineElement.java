package com.josbertlonnee.svg;

import org.w3c.dom.Element;

import com.josbertlonnee.util.*;

public class SvgLineElement extends AbstractStrokeSvgElement
{
	private Vector delta;
	
	protected SvgLineElement(AbstractContainerSvgElement parentElement, Point startPosition, Vector delta)
	{
		super(parentElement, startPosition);
		
		this.delta = delta;
	}

	@Override
	protected final String getDomElementQualifiedName()
	{
		return "line";
	}
	
	@Override
	protected final void fillDomElement(Element domElement)
	{
		setDomPointAttributesScaled(domElement, "x2", "y2", delta);
		
		super.fillDomElement(domElement);
	}
}

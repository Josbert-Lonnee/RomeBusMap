package com.josbertlonnee.svg;

import org.w3c.dom.Element;

import com.josbertlonnee.util.*;

public abstract class AbstractStrokeAndFillSvgElement extends AbstractStrokeSvgElement
{
	private Color color = new SvgNoneColor();
	private double opacity = 1.0;
	
	protected AbstractStrokeAndFillSvgElement(AbstractContainerSvgElement parentElement, Point position)
	{
		super(parentElement, position);
	}
	
	public void setFill(Color color)
	{
		if (color == null)
			this.color = new SvgNoneColor();
		else
			this.color = color;
	}
	
	public void setFillOpacity(double opacity)
	{
		this.opacity = opacity;
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		setDomAttribute       (domElement, "fill"        , color  );
		setDomOpacityAttribute(domElement, "fill-opacity", opacity);
		
		super.fillDomElement(domElement);
	}
}

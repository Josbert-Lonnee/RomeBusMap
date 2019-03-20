package com.josbertlonnee.svg;

import org.w3c.dom.*;

import com.josbertlonnee.util.*;

public abstract class AbstractSvgElement
{
	private AbstractSvgElement parentElement;
	
	protected AbstractSvgElement(AbstractContainerSvgElement parentElement)
	{
		this.parentElement = parentElement;
		
		if (getSvgDocument() == this) {
			if (parentElement != null)
				throw new IllegalArgumentException();
			
		} else {
			parentElement.addElement(this);
		}
	}
	
	SvgDocument getSvgDocument()
	{
		return parentElement.getSvgDocument();
	}
	
	protected final Element createDomElement()
	{
		Document domDocument = getSvgDocument().getDomDocument();
		
		Element domElement = domDocument.createElementNS("http://www.w3.org/2000/svg", getDomElementQualifiedName());
		
		fillDomElement(domElement);
		
		return domElement;
	}
	
	protected abstract String getDomElementQualifiedName();
	
	protected void fillDomElement(Element domElement)
	{
	}
	
	protected void setDomAttribute(Element domElement, String name, Object value)
	{
		if (value != null)
		{
			domElement.setAttribute(name, value.toString());
		}
	}
	
	protected void setDomAttribute(Element domElement, String name, Color color)
	{
		if (color != null)
		{
			domElement.setAttribute(name, color.toSvgString());
		}
	}
	
	protected void setDomAttribute(Element domElement, String name, int value)
	{
		if (value != 0)
		{
			domElement.setAttribute(name, Integer.toString(value));
		}
	}
	
	protected void setDomAttribute(Element domElement, String name, double value)
	{
		if (value != 0.0)
		{
			domElement.setAttribute(name, Double.toString(value));
		}
	}
	
	protected void setDomOpacityAttribute(Element domElement, String name, double opacity)
	{
		if (opacity < 0 || opacity > 1)
			throw new IllegalArgumentException("Opacity for '" + name + "' must be between 0 and 1, but " + opacity + " is passed.");
		
		if (opacity < 1)
			setDomAttribute(domElement, name, Double.toString(opacity));
	}
	
	protected void setDomAttributeScaled(Element domElement, String name, double value)
	{
		if(value != 0)
		{
			int scale = getSvgDocument().getScale();
			setDomAttribute(domElement, name, value * scale);
		}
	}
	
	protected void setDomPointAttributesScaled(Element domElement, String nameX, String nameY, AbstractPoint point)
	{
		if (point != null) 
		{
			int scale = getSvgDocument().getScale();
			
			setDomAttribute(domElement, nameX, point.x() * scale);
			setDomAttribute(domElement, nameY, point.y() * scale);
		}
	}

	protected void setDomAttributesScaled(Element domElement, String name, double[] array, char separationChar)
	{
		if (array != null) 
		{
			int scale = getSvgDocument().getScale();
			
			StringBuilder sb = new StringBuilder();
			
			boolean first = true;
			for(double d : array) {
				if (!first)
					sb.append(separationChar);
				
				sb.append(d * scale);
				
				first = false;
			}
			
			setDomAttribute(domElement, name, sb);
		}
	}
}

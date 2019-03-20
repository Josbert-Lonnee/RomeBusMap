package com.josbertlonnee.svg;

import java.util.*;

import org.w3c.dom.Element;

import com.josbertlonnee.util.*;

public class SvgPolygonElement extends AbstractStrokeAndFillSvgElement
{
	private List<AbstractPoint> points = new ArrayList<AbstractPoint>();
	
	public SvgPolygonElement(AbstractContainerSvgElement parentElement, AbstractPoint startPoint)
	{
		super(parentElement, null);
		
		addPoint(startPoint);
	}

	@Override
	protected final String getDomElementQualifiedName()
	{
		return "polygon";
	}
	
	public void addPoint(AbstractPoint point)
	{
		if (point == null)
			throw new NullPointerException();
		
		points.add(point);
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		StringBuilder sb = new StringBuilder();
		
		int scale = getSvgDocument().getScale();
		
		boolean first = true;
		for(AbstractPoint p : points) {
			if (!first)
				sb.append(' ');
			
			sb.append(p.x() * scale);
			sb.append(',');
			sb.append(p.y() * scale);
			
			first = false;
		}
		
		setDomAttribute(domElement, "points", sb.toString());
		
		super.fillDomElement(domElement);
	}
}

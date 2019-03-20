package com.josbertlonnee.svg;

import org.w3c.dom.Element;

import com.josbertlonnee.util.*;

public class SvgPathElement extends AbstractStrokeAndFillSvgElement
{
	class Data {
		private StringBuilder sb = new StringBuilder(40);
		private boolean closed;
		
		private void separation(char separationChar)
		{
			if (sb.length() > 0)
				sb.append(separationChar);
		}
		
		public void addCommand(char c)
		{
			if (closed)
				throw new IllegalStateException();
			
			separation(' ');
			sb.append(Character.toUpperCase(c));
		}
		
		private void addPointInternal(Point p)
		{
			SvgPoint svgPoint = getSvgDocument().getScaledPoint(p);
			sb.append(svgPoint.x());
			sb.append(' '  );
			sb.append(svgPoint.y());
		}
		
		public void addPoint(Point p)
		{
			separation(' ');
			addPointInternal(p);
		}
		
		public void addNextPoint(Point p)
		{
			separation(',');
			addPointInternal(p);
		}
		
		@Override
		public String toString()
		{
			return sb.toString();
		}

		public void setClosed()
		{
			closed = true;
		}
	};
	
	private Data data = new Data();
	
	public SvgPathElement(AbstractContainerSvgElement parentElement, Point startPoint)
	{
		super(parentElement, null);
		
		data.addCommand('M');
		data.addPoint(startPoint);
	}

	@Override
	protected final String getDomElementQualifiedName()
	{
		return "path";
	}
	
	public void addLine(Point toPoint)
	{
		data.addCommand('L');
		data.addPoint(toPoint);
	}
	
	public void addQuadraticCurve(Point vector, Point toPoint)
	{
		data.addCommand('Q');
		data.addPoint(vector);
		data.addNextPoint(toPoint);
	}
	
	public void close()
	{
		data.addCommand('Z');
		data.setClosed();
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		setDomAttribute(domElement, "d", data);
		
		super.fillDomElement(domElement);
	}
}

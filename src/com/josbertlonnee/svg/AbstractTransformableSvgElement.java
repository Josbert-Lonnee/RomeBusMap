package com.josbertlonnee.svg;

import org.w3c.dom.Element;

import com.josbertlonnee.util.Point;

public abstract class AbstractTransformableSvgElement extends AbstractSvgElement
{
	private Point position;
	private double rotation;
	
	protected AbstractTransformableSvgElement(AbstractContainerSvgElement parentElement, Point position)
	{
		super(parentElement);
		
		setPosition(position);
	}
	
	public void setPosition(Point position)
	{
		this.position = position;
	}
	
	public void setRotation(double rotation)
	{
		this.rotation = rotation;
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		if (position != null || rotation != 0)
		{
			StringBuilder transform = new StringBuilder(30);
			
			if (position != null)
			{
				int scale = getSvgDocument().getScale();
				
				transform.append("translate(");
				transform.append(position.x() * scale);
				transform.append(' ');
				transform.append(position.y() * scale);
				transform.append(')');
			}
			
			if (position != null && rotation != 0)
			{
				transform.append(' ');
			}
			
			if (rotation != 0)
			{
				transform.append("rotate(");
				transform.append(rotation);
				transform.append(')');
			}
			
			setDomAttribute(domElement, "transform", transform);
		}
		
		super.fillDomElement(domElement);
	}
}

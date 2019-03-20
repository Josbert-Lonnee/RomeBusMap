package com.josbertlonnee.svg;

import org.w3c.dom.Element;

import com.josbertlonnee.util.*;

public class SvgTextElement extends AbstractStrokeAndFillSvgElement
{
	private String text;
	private boolean bold;
	private boolean italic;
	private String fontFamily = "sans-serif";
	private double fontSize;
	
	public SvgTextElement(AbstractContainerSvgElement parentElement, Point position, String text, Color fillColor)
	{
		super(parentElement, position);
		
		this.text = text;
		
		setFill(fillColor);
	}

	@Override
	protected final String getDomElementQualifiedName()
	{
		return "text";
	}
	
	public void setBold(boolean bold)
	{
		this.bold = bold;
	}
	
	public void setItalic(boolean italic)
	{
		this.italic = italic;
	}
	
	public void setFontFamily(String fontFamily)
	{
		this.fontFamily = fontFamily;
	}
	
	public void setFontSize(double fontSize)
	{
		this.fontSize = fontSize;
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		if (bold)
			setDomAttribute(domElement, "font-weight", "bold");
		if (italic)
			setDomAttribute(domElement, "font-style", "italic");
		
		setDomAttribute(domElement, "font-family", fontFamily);
		setDomAttributeScaled(domElement, "font-size", fontSize);
		
		domElement.setTextContent(text);
		
		super.fillDomElement(domElement);
	}
}

package com.josbertlonnee.svg;

public class SvgGroupElement extends AbstractContainerSvgElement
{
	public SvgGroupElement(AbstractContainerSvgElement parentElement)
	{
		super(parentElement);
	}

	@Override
	protected final String getDomElementQualifiedName()
	{
		return "g";
	}
}

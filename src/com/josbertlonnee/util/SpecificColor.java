package com.josbertlonnee.util;

public enum SpecificColor implements Color
{
	WHITE("white"),
	BLACK("black"),
	RED("red"),
	GREEN("green"),
	BLUE("blue");
	
	private String svgName;
	
	SpecificColor(String svgName)
	{
		this.svgName= svgName;
	}
	
	@Override
	public String toSvgString()
	{
		return svgName;
	}
}

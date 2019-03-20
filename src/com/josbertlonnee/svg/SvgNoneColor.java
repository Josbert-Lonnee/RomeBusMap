package com.josbertlonnee.svg;

import com.josbertlonnee.util.Color;

public class SvgNoneColor implements Color
{
	@Override
	public String toSvgString()
	{
		return "none";
	}
}

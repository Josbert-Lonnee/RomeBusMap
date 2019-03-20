package com.josbertlonnee;

import com.josbertlonnee.shapedata.Direction8LegData;
import com.josbertlonnee.util.Direction8;

public class TramLineLeg extends Direction8LegData<AbstractTramLineAnnotation>
{
	private static final TramLineTerminus Terminus = new TramLineTerminus();
	private static final TramLineLabel    Label    = new TramLineLabel   ();
	
	TramLineLeg(Direction8 direction, double length)
	{
		super(direction, length);
	}
	
	TramLineLeg addTerminus(double distanceFromStart)
	{
		addAnn(distanceFromStart, Terminus);
		return this;
	}
	
	TramLineLeg addLabel(double distanceFromStart)
	{
		addAnn(distanceFromStart, Label);
		return this;
	}
}

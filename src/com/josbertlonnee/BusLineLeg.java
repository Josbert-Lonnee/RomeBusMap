package com.josbertlonnee;

import com.josbertlonnee.shapedata.Direction8LegData;
import com.josbertlonnee.util.Direction8;

public class BusLineLeg extends Direction8LegData<AbstractBusLineAnnotation>
{
	private static final BusLineTerminus Terminus = new BusLineTerminus ();
	private static final BusLineLabel    Label    = new BusLineLabel    ();
	private static final BusLineOneWay   OneWay   = new BusLineOneWay   ();
	
	BusLineLeg(Direction8 direction, double length)
	{
		super(direction, length);
	}
	
	BusLineLeg addTerminus(double distanceFromStart)
	{
		addAnn(distanceFromStart, Terminus);
		return this;
	}
	
	BusLineLeg addLabel(double distanceFromStart)
	{
		addAnn(distanceFromStart, Label);
		return this;
	}
	
	BusLineLeg addOneWay(double distanceFromStart)
	{
		addAnn(distanceFromStart, OneWay);
		return this;
	}

	BusLineLeg addDirection(double distanceFromStart, String direction, boolean toNotFrom)
	{
		addAnn(distanceFromStart, new BusLineDirectionLabel(direction, toNotFrom) );
		return this;
	}
}

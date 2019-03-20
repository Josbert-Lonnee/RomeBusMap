package com.josbertlonnee;

import com.josbertlonnee.shapedata.Direction8LegData;
import com.josbertlonnee.util.Direction8;

public class MetroLineLeg extends Direction8LegData<AbstractMetroLineAnnotation>
{
	private static final MetroStation Station = new MetroStation();
	
	MetroLineLeg(Direction8 direction, double length)
	{
		super(direction, length);
	}
	
	MetroLineLeg addStation(double distanceFromStart)
	{
		addAnn(distanceFromStart, Station);
		return this;
	}

	MetroLineLeg addDirection(double distanceFromStart, String direction, boolean toNotFrom)
	{
		addAnn(distanceFromStart, new MetroLineDirectionLabel(direction, toNotFrom) );
		return this;
	}
}

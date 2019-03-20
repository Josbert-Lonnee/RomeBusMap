package com.josbertlonnee;

import com.josbertlonnee.shapedata.Direction8LegData;
import com.josbertlonnee.util.Direction8;

public class TrainLineLeg extends Direction8LegData<TrainStation>
{
	private static final TrainStation Station = new TrainStation();
	
	TrainLineLeg(Direction8 direction, double length)
	{
		super(direction, length);
	}
	
	TrainLineLeg addStation(double distanceFromStart)
	{
		addAnn(distanceFromStart, Station);
		return this;
	}
}

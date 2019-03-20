package com.josbertlonnee.shapedata;

import java.util.Iterator;

import com.josbertlonnee.util.*;

public class Direction8LegData<ANN extends AbstractAnnotationData<?>> extends AbstractComplexShapeData<PathLegAnnotation<ANN>>
{
	Direction8 direction;
	double length;
	
	protected Direction8LegData(Direction8 direction, double length)
	{
		this.direction = direction;
		this.length = length;
	}
	
	public final Direction8LegData<ANN> addAnn(double distanceFromStart, ANN annotation)
	{
		if (annotation == null)
			throw new NullPointerException();
		
		PathLegAnnotation<ANN> annotationData = new PathLegAnnotation<ANN>(distanceFromStart, annotation);
		shapeElements.add(annotationData);
		
		return this;
	}

	public final Iterator<PathLegAnnotation<ANN>> getAnnotationsIterator()
	{
		return shapeElements.iterator();
	}

	public Direction8 getDirection()
	{
		return direction;
	}

	public double getLength()
	{
		return length;
	}

	public Vector getVector()
	{
		return direction.getVector( length );
	}
}

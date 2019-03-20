package com.josbertlonnee.shapedata;

public class PathLegAnnotation<D extends AbstractAnnotationData<?>> extends AbstractShapeData
{
	private double distanceFromStart;
	private D annotatededData;
	
	protected PathLegAnnotation(double distanceFromStart, D annotatededData)
	{
		this.distanceFromStart = distanceFromStart;
		this.annotatededData = annotatededData;
	}
	
	public double getDistanceFromStart()
	{
		return distanceFromStart;
	}
	
	public D getAnnotatededData()
	{
		return annotatededData;
	}
}

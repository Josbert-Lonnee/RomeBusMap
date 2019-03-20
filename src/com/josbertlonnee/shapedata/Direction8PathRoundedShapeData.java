package com.josbertlonnee.shapedata;

import java.util.Iterator;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public abstract class Direction8PathRoundedShapeData<PATH extends Direction8PathRoundedShapeData<?, ?, ?>, LEG extends Direction8LegData<ANN>, ANN extends AbstractAnnotationData<PATH>> extends Direction8PathShapeData<PATH, LEG, ANN>
{
	private double cornerRadius;
	
	public Direction8PathRoundedShapeData(double cornerRadius, Point startPosition)
	{
		super(startPosition);
		
		this.cornerRadius = cornerRadius;
	}
	
	@Override
	protected SvgPathElement createSvgPath(AbstractContainerSvgElement parentElement)
	{
		SvgPathElement path = new SvgPathElement(parentElement, startPosition);
		Point lastPoint = new Point(startPosition);
		
		Iterator<Direction8LegData<ANN>> iterator = shapeElements.iterator();
		Direction8LegData<ANN> legData = iterator.next();
		Direction8 legDirection = legData.getDirection();
		double skippedLegLength = 0;
		
		while(iterator.hasNext()) {
			Direction8LegData<ANN> nextLegData = iterator.next();
			Direction8 nextLegDirection = nextLegData.getDirection();
			
			// Not making a corner??
			if (nextLegDirection == legDirection)
				throw new RuntimeException("Leg is lineair extension of the previous leg and thus superfluous!");
			
			// Length skipped at the end:
			skippedLegLength += cornerRadius;
			
			movePointOverLeg(legData, lastPoint, skippedLegLength);
			path.addLine(lastPoint);
			
			Point curveVector = new Point(lastPoint);
			curveVector.move( legDirection.getVector(cornerRadius) );
			
			// Length skipped at the beginning:
			skippedLegLength = cornerRadius;
			
			lastPoint = new Point(curveVector);
			lastPoint.move( nextLegDirection.getVector(cornerRadius) );
			
			path.addQuadraticCurve(curveVector, lastPoint);
			
			legData = nextLegData;
			legDirection = nextLegDirection;
		}
		
		movePointOverLeg(legData, lastPoint, skippedLegLength);
		path.addLine(lastPoint);
		
		return path;
	}
	
	private void movePointOverLeg(Direction8LegData<ANN> legData, Point pointToMove, double skippedLegLength)
	{
		Vector vector = legData.getDirection().getVector( legData.getLength() - skippedLegLength );
		pointToMove.move(vector);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void createSvgOfAnnotationBetweenLegs(AbstractContainerSvgElement parentElement, Point connectionPoint, Direction8LegData<ANN> legDataA, Direction8LegData<ANN> legDataB, ANN annotation)
	{
		Vector correction = legDataA.getDirection().getVector(-cornerRadius);
		correction.add( legDataB.getDirection().getVector( cornerRadius) );
		correction.scale(0.5);
		
		Point correctedPoint = new Point( connectionPoint );
		correctedPoint.move(correction);
		
		int directionDegrees = ( legDataA.getDirection().getDegrees() + legDataB.getDirection().getDegrees() ) / 2;
		
		annotation.createSvg(parentElement, (PATH) this, correctedPoint, directionDegrees);
	}
	
	@Override
	protected void createSvgOfAnnotation(AbstractContainerSvgElement parentElement, Point legBasePoint, double distanceFromStart, Direction8LegData<ANN> legData, boolean previousLeg, boolean nextLeg, ANN annotation)
	{
		if (previousLeg && distanceFromStart < cornerRadius)
			throw new RuntimeException("Leg annotation on the curve at the beginning of the leg.");
		
		if (nextLeg && distanceFromStart > legData.getLength() - cornerRadius)
			throw new RuntimeException("Leg annotation on the curve at the end of the leg.");
		
		super.createSvgOfAnnotation(parentElement, legBasePoint, distanceFromStart, legData, previousLeg, nextLeg, annotation);
	}
}

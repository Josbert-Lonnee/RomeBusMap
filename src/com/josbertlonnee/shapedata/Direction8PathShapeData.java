package com.josbertlonnee.shapedata;

import java.util.*;

import com.josbertlonnee.svg.*;
import com.josbertlonnee.util.*;

public abstract class Direction8PathShapeData<PATH extends Direction8PathShapeData<?, ?, ?>, LEG extends Direction8LegData<ANN>, ANN extends AbstractAnnotationData<PATH>> extends AbstractPathShapeData<Direction8LegData<ANN>>
{
	protected Point startPosition;
	
	protected Direction8PathShapeData(Point startPosition)
	{
		this.startPosition = new Point(startPosition);
	}
	
	public final LEG addLeg(Direction8 direction, double length)
	{
		LEG legData = createLegData(direction, length);
		shapeElements.add(legData);
		return legData;
	}
	
	@SuppressWarnings("unchecked")
	protected LEG createLegData(Direction8 direction, double length)
	{
		return (LEG) new Direction8LegData<ANN>(direction, length);
	}
	
	protected SvgPathElement createSvgPath(AbstractContainerSvgElement parentElement)
	{
		SvgPathElement path = new SvgPathElement(parentElement, startPosition);
		
		Point lastPoint = new Point(startPosition);
		
		Iterator<Direction8LegData<ANN>> iterator = shapeElements.iterator();
		while(iterator.hasNext()) {
			Direction8LegData<ANN> legData = iterator.next();
			lastPoint.move( legData.getVector() );
			path.addLine(lastPoint);
		}

		return path;
	}
	
	protected final void createSvgOfAnnotations(AbstractContainerSvgElement parentElement)
	{
		Point lastPoint = new Point(startPosition);
		
		Iterator<Direction8LegData<ANN>> iterator = shapeElements.iterator();
		
		Direction8LegData<ANN> previousLegData = null;
		Direction8LegData<ANN> legData = iterator.next();
		Direction8LegData<ANN> nextLegData = null;
		
		while(legData != null)
		{
			if (iterator.hasNext())
				nextLegData = iterator.next();
			else
				nextLegData = null;
			
			createSvgOfLegAnnotations(parentElement, lastPoint, previousLegData, legData, nextLegData);
			
			lastPoint.move( legData.getVector() );

			previousLegData = legData;
			legData = nextLegData;
		}
	}
	
	protected final void createSvgOfLegAnnotations(AbstractContainerSvgElement parentElement, Point legBasePoint, Direction8LegData<ANN> previousLegData, Direction8LegData<ANN> legData, Direction8LegData<ANN> nextLegData)
	{
		Iterator<PathLegAnnotation<ANN>> annotationIterator = legData.getAnnotationsIterator();
		
		double distanceFromStart = 0;
		
		while(annotationIterator.hasNext()) {
			PathLegAnnotation<ANN> annotationData = annotationIterator.next();
			ANN annotation = annotationData.getAnnotatededData();
			
			// Annotation at the beginning of this leg?
			if (annotationData.getDistanceFromStart() == 0)
			{
				if (previousLegData != null) {
					createSvgOfAnnotationBetweenLegs(parentElement, legBasePoint, previousLegData, legData, annotation);
				}
				else {
					createSvgOfAnnotation(parentElement, legBasePoint, distanceFromStart, legData, previousLegData != null, nextLegData != null, annotation);
				}
			}
			
			// Annotation at the end of this leg?
			else
			{
				distanceFromStart += annotationData.getDistanceFromStart();

				if (annotationData.getDistanceFromStart() < 0)
				{
					if (nextLegData != null) {
						Point connectionPoint = new Point(legBasePoint);
						connectionPoint.move( legData.getVector() );
						
						createSvgOfAnnotationBetweenLegs(parentElement, connectionPoint, legData, nextLegData, annotation);
					}
					else {
						createSvgOfAnnotation(parentElement, legBasePoint, legData.getLength(), legData, previousLegData != null, nextLegData != null, annotation);
					}
				}
				
				// Annotation somewhere in the middle of this leg?
				else
				{
					createSvgOfAnnotation(parentElement, legBasePoint, distanceFromStart, legData, previousLegData != null, nextLegData != null, annotation);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void createSvgOfAnnotationBetweenLegs(AbstractContainerSvgElement parentElement, Point connectionPoint, Direction8LegData<ANN> legDataA, Direction8LegData<ANN> legDataB, ANN annotation)
	{
		int directionDegrees = ( legDataA.getDirection().getDegrees() + legDataB.getDirection().getDegrees() ) / 2;
		
		annotation.createSvg(parentElement, (PATH) this, connectionPoint, directionDegrees);		
	}
	
	@SuppressWarnings("unchecked")
	protected void createSvgOfAnnotation(AbstractContainerSvgElement parentElement, Point legBasePoint, double distanceFromStart, Direction8LegData<ANN> legData, boolean previousLeg, boolean nextLeg, ANN annotation)
	{
		if (distanceFromStart > legData.getLength())
			throw new RuntimeException("Leg annotation further from the start of the leg than the length of the leg itself.");
		
		Direction8 direction = legData.getDirection();
		
		Point point = new Point(legBasePoint);
		point.move(direction.getVector( distanceFromStart ));
		
		annotation.createSvg(parentElement, (PATH) this, point, direction.getDegrees());
	}
}

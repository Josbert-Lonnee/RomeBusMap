package com.josbertlonnee.transport;

import com.josbertlonnee.shapedata.*;
import com.josbertlonnee.svg.AbstractContainerSvgElement;
import com.josbertlonnee.util.Point;

public abstract class AbstractLineWithAnnotationsShapeData<PATH extends Direction8PathRoundedShapeData<?, ?, ?>, LEG extends Direction8LegData<ANN>, ANN extends AbstractAnnotationData<PATH>> extends Direction8PathRoundedShapeData<PATH, LEG, ANN>
{
	public AbstractLineWithAnnotationsShapeData(double cornerRadius, Point startPosition)
	{
		super(cornerRadius, startPosition);
	}

	@Override
	public final int getNumberOfSvgCreatePhases()
	{
		return 3;
	}

	@Override
	public final void createSvg(AbstractContainerSvgElement parentElement, int phase)
	{
		if (phase == 1)
			createPathSvg(parentElement);
		
		if (phase == 2)
			createSvgOfAnnotations(parentElement);
	}

	protected abstract void createPathSvg(AbstractContainerSvgElement parentElement);
}

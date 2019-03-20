package com.josbertlonnee.shapedata;

import com.josbertlonnee.svg.AbstractContainerSvgElement;

public abstract class AbstractMultiPhaseShapeData<D extends AbstractShapeData> extends AbstractComplexShapeData<D>
{
	public abstract int getNumberOfSvgCreatePhases();

	public abstract void createSvg(AbstractContainerSvgElement parentElement, int phase);
}

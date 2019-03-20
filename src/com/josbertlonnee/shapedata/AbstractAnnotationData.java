package com.josbertlonnee.shapedata;

import com.josbertlonnee.svg.AbstractContainerSvgElement;
import com.josbertlonnee.util.Point;

public abstract class AbstractAnnotationData<P extends AbstractPathShapeData<?>> extends AbstractShapeData
{
	protected abstract void createSvg(AbstractContainerSvgElement parentElement, P path, Point position, int directionDegrees);
}

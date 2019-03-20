package com.josbertlonnee.shapedata;

import java.util.*;

public abstract class AbstractComplexShapeData<D extends AbstractShapeData> extends AbstractShapeData
{
	protected List<D> shapeElements = new ArrayList<D>();
}

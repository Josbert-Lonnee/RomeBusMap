package com.josbertlonnee.shapedata;

import java.util.*;

import com.josbertlonnee.svg.SvgDocument;

public class ComplexShapesCanvas
{
	private int width;
	private int height;
	
	private List<AbstractMultiPhaseShapeData<?>> complexShapesList = new ArrayList<AbstractMultiPhaseShapeData<?>>();
	
	public ComplexShapesCanvas(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public final void addComplexShape(AbstractMultiPhaseShapeData<?> complexShape)
	{
		complexShapesList.add(complexShape);
	}
	
	public final void generateSvgFile(String fileURL, int scale, boolean addHelperLines) throws Exception
	{
		SvgDocument svgDocument = new SvgDocument(width, height, scale, addHelperLines);
		
		int maxNumberOfPhases = 1;
		for(int phase = 0; phase < maxNumberOfPhases; ++phase)
		{
			Iterator<AbstractMultiPhaseShapeData<?>> complexShapesIterator = complexShapesList.iterator();
			while(complexShapesIterator.hasNext())
			{
				AbstractMultiPhaseShapeData<?> complexShape = complexShapesIterator.next();
				
				int numberOfPhases = complexShape.getNumberOfSvgCreatePhases();
				if (maxNumberOfPhases < numberOfPhases)
					maxNumberOfPhases = numberOfPhases;
				
				complexShape.createSvg(svgDocument, phase);
			}
		}
		
		svgDocument.writeTo(fileURL);
	}
}

package com.josbertlonnee.svg;

import java.util.*;

import org.w3c.dom.Element;

public abstract class AbstractContainerSvgElement extends AbstractTransformableSvgElement
{
	private List<AbstractSvgElement> containedSvgElements = new ArrayList<AbstractSvgElement>();

	AbstractContainerSvgElement(AbstractContainerSvgElement parentElement)
	{
		super(parentElement, null);
	}

	void addElement(AbstractSvgElement abstractElement)
	{
		containedSvgElements.add(abstractElement);
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		Iterator<AbstractSvgElement> iterator = containedSvgElements.iterator();
		while(iterator.hasNext()) {
			AbstractSvgElement containedSvgElement = iterator.next();
			Element childDomElement = containedSvgElement.createDomElement();
			domElement.appendChild(childDomElement);
		}
		
		super.fillDomElement(domElement);
	}
}

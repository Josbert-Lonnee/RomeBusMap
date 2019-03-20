package com.josbertlonnee.svg;

import org.w3c.dom.*;

import com.josbertlonnee.util.*;

import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class SvgDocument extends AbstractContainerSvgElement
{
	private int width;
	private int height;
	private int scale;
	
	private Document document;

	public SvgDocument(int width, int height, int scale, boolean addHelperLines)
	{
		super(null);
		
		this.width  = width ;
		this.height = height;
		this.scale  = scale ;
		
		if (addHelperLines)
			addHelperLines();
	}
	
	@Override
	final SvgDocument getSvgDocument()
	{
		return this;
	}

	@Override
	protected final String getDomElementQualifiedName()
	{
		return "svg";
	}
	
	final int getScale()
	{
		return scale;
	}
	
	final SvgPoint getScaledPoint(AbstractPoint p)
	{
		return new SvgPoint(p, scale);
	}

	public static Color GetBackgroundColor()
	{
		return SpecificColor.WHITE;
	}

	private void addHelperLines()
	{
		int shade = 200;
		int numberAtEvery = 5;
		double fontSize = 1.2;
		
		Color color = new RgbColor(shade, shade, shade);
		
		// Horizontal Lines:
		addHelperLines(true, height, new Vector(width , 0), color, numberAtEvery, fontSize);
		
		// Vertical Lines:
		addHelperLines(false, width, new Vector(0, height), color, numberAtEvery, fontSize);
	}

	private void addHelperLines(boolean horizontalNotVertical, int number, Vector lineVector, Color color, int numberAtEvery, double fontSize)
	{
		for(int i=1; i<number; ++i) {
			Point basePoint = new Point(horizontalNotVertical ? 0 : i, horizontalNotVertical ? i : 0);
			
			if (i % numberAtEvery == 0)
			{
				Point textBasePoint = new Point(basePoint);
				
				if (!horizontalNotVertical)
					textBasePoint.move(new Vector(0, fontSize));
				
				SvgTextElement text = new SvgTextElement(this, textBasePoint, Integer.toString(i), color);
				text.setFontFamily("Arial,sans-serif");
				text.setFontSize(fontSize);
			}
			
			SvgLineElement line = new SvgLineElement(this, basePoint, lineVector);
			line.setStroke(color);
			line.setStrokeWidth(1.0 / scale / 2.0);
		}
	}
	
	@Override
	protected void fillDomElement(Element domElement)
	{
		setDomAttributeScaled(domElement, "width" , width );
		setDomAttributeScaled(domElement, "height", height);
		
		super.fillDomElement(domElement);
	}

	public void writeTo(String outputFileUrl) throws Exception
	{
		writeTo(new File(outputFileUrl));
	}
	
	public void writeTo(File outputFile) throws Exception
	{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		}
		
		document = builder.newDocument();
		
		Element svgRootElement = createDomElement();
		document.appendChild(svgRootElement);
		
		DOMSource source = new DOMSource(document);
		FileWriter writer = new FileWriter(outputFile);
		StreamResult result = new StreamResult(writer);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//W3C//DTD SVG 1.1//EN");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		
		transformer.transform(source, result);
		
		document = null;
	}

	public Document getDomDocument()
	{
		return document;
	}
}

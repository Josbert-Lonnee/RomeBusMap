package com.josbertlonnee;

import com.josbertlonnee.shapedata.*;
import com.josbertlonnee.util.*;

public class RomeBusMap extends ComplexShapesCanvas
{
	public static void main(String[] args) throws Exception
	{
		RomeBusMap romeBusMap = new RomeBusMap();
		romeBusMap.generateSvgFile("C:\\Users\\Josbert\\RomeBusMap.svg", 20, /*Add Helper Lines =*/false);
	}
	
	
	public RomeBusMap()
	{
		super(200, 160);
		
		addRiver();
		
		addMetroLines();
		
		addBusLines();
		
		addTramLines();
		
		addTrainLines();
		
		addZonesAndLabels();
	}
	
	
	// *******************************************************************
	// *** RIVER ***
	
	private void addRiver()
	{
		River river = new River(new Point(80, -5));
		
		river.addLeg(Direction8.S ,  44);
		river.addLeg(Direction8.SW,   6);
		river.addLeg(Direction8.W ,  36);
		river.addLeg(Direction8.SW,   8);
		river.addLeg(Direction8.S ,  23);
		river.addLeg(Direction8.SE,  35);
		river.addLeg(Direction8.E ,  18);
		river.addLeg(Direction8.S ,16.5);
		river.addLeg(Direction8.SW,  40);
		
		addComplexShape( river );
	}
	
	
	// *******************************************************************
	// *** METRO Lines ***
	
	private void addMetroLines()
	{
		addMetroA();
		addMetroB();
		addMetroC();
	}
	
	private void addMetroA()
	{
		MetroLine line = new MetroLine(new Point(-1, 10), new RgbColor(240,  100, 35));
		
		line.addLeg(Direction8.E ,  96).addDirection(8, "Battistini", false).addStation(19).addStation(34); // Ottaviano, Lepanto
		line.addLeg(Direction8.SE,  10).addStation(5); // Flaminio
		line.addLeg(Direction8.S ,  15);
		line.addLeg(Direction8.SE,  48).addStation( 9).addStation(15).addStation(10).addStation(11); // Spagna, Barberini, Repubblica, TERMINI
		line.addLeg(Direction8.S ,  81).addStation(24).addStation(19).addStation(18.5).addDirection(8.5, "Anagina", true); // Vittorio, Manzoni, S. Giovanni
		
		addComplexShape( line );
	}
	
	private void addMetroB()
	{
		MetroLine line = new MetroLine(new Point(89, 161), new RgbColor(30,  125, 190));
		
		line.addLeg(Direction8.NE,  31).addDirection(6, "Laurenti.", false).addStation(7); // Circo Massimo
		line.addLeg(Direction8.N ,  20).addStation(7); // Colosseo
		line.addLeg(Direction8.NE,  81).addStation(10).addStation(20).addStation(18).addStation(18).addDirection(9, "Jon. / Reb.", true); // Cavour, TERMINI, Castro Pretorio, Policlinico
		
		addComplexShape( line );
	}
	
	private void addMetroC()
	{
		MetroLine line = new MetroLine(new Point(185, 148), new RgbColor(100, 160,  30));
		
		line.addLeg(Direction8.E ,  16).addStation(0).addDirection(8, "Pantano", true); // Lodi
		
		addComplexShape( line );
	}
	
	
	// *******************************************************************
	// *** BUS Lines ***
	
	private static final Color[] busLineColorMap = {
			new RgbColor(  0,  0,  0), //  0
			new RgbColor(100,100,100), //  1
			new RgbColor(150,150,150), //  2
			
			new RgbColor(150,  0,  0), //  3
			new RgbColor(  0,  0,150), //  4
			
			new RgbColor(150,150,  0), //  5
			new RgbColor( 50,150,200), //  6
			new RgbColor(150,  0,150), //  7
			
			new RgbColor(200,  0,  0), //  8
			new RgbColor(100,200,100), //  9
			new RgbColor(  0,  0,200), // 10
			
			new RgbColor(225,200,  0), // 11
			new RgbColor(180,225,  0), // 12
			new RgbColor(  0,200,200), // 13
			new RgbColor(200,  0,200), // 14
			
			new RgbColor(190,160, 80), // 15
			new RgbColor(100,140,160), // 16
			new RgbColor(210,  0,  0), // 17
			new RgbColor(  0,  0,210), // 18
			new RgbColor(230,160,  0), // 19
	};
	
	private void addBusLines()
	{
		addBusH  ( busLineColorMap[13] );
		addBus16 ( busLineColorMap[12] );
		addBus23 ( busLineColorMap[ 6] );
		addBus30 ( busLineColorMap[ 9] );
		addBus34 ( busLineColorMap[ 9] );
		addBus40 ( busLineColorMap[ 5] );
		addBus44 ( busLineColorMap[15] );
		addBus46 ( busLineColorMap[ 4] );
		addBus49 ( busLineColorMap[19] );
		addBus51 ( busLineColorMap[17] );
		addBus60 ( busLineColorMap[ 9] );
		addBus61 ( busLineColorMap[11] );
		addBus62 ( busLineColorMap[16] );
		addBus63 ( busLineColorMap[ 7] );
		addBus64 ( busLineColorMap[11] );
		addBus66 ( busLineColorMap[17] );
		addBus70 ( busLineColorMap[ 6] );
		addBus71 ( busLineColorMap[ 3] );
		addBus75 ( busLineColorMap[ 1] );
		addBus80 ( busLineColorMap[14] );
		addBus81 ( busLineColorMap[ 0] );
		addBus82 ( busLineColorMap[ 3] );
		addBus83 ( busLineColorMap[ 1] );
		addBus85 ( busLineColorMap[19] );
		addBus87 ( busLineColorMap[14] );
		addBus92 ( busLineColorMap[15] );
		addBus115( busLineColorMap[12] );
		addBus118( busLineColorMap[ 2] );
		addBus160( busLineColorMap[ 4] );
		addBus170( busLineColorMap[15] );
		addBus280( busLineColorMap[ 7] );
		addBus301( busLineColorMap[ 2] );
		addBus310( busLineColorMap[ 9] );
		addBus360( busLineColorMap[ 2] );
		addBus490( busLineColorMap[13] );
		addBus492( busLineColorMap[13] );
		addBus590( busLineColorMap[15] );
		addBus628( busLineColorMap[12] );
		addBus649( busLineColorMap[ 7] );
		addBus710( busLineColorMap[ 0] );
		addBus780( busLineColorMap[ 4] );
		addBus870( busLineColorMap[17] );
		addBus881( busLineColorMap[13] );
		addBus990( busLineColorMap[12] );
	}
	
	private void addBusH(Color color)
	{
		// Termini to South:
		BusLine line = new BusLine("H", color, new Point(150.5, 76.5)); 
		
		line.addLeg(Direction8.NW, 8.5).addTerminus(0); // Termini
		line.addLeg(Direction8.SW,  23).addLabel(10); // Nazionale
		line.addLeg(Direction8.W ,  24).addLabel(9); // Venezia
		line.addLeg(Direction8.S ,  12).addOneWay(5).addLabel(4);
		line.addLeg(Direction8.SW,   4);
		line.addLeg(Direction8.W ,  22).addLabel(5).addOneWay(13); // Ponte Giribaldi
		line.addLeg(Direction8.SW,  57).addLabel(17).addLabel(20).addDirection(10, "DEI CAPASSO", true);
		
		addComplexShape( line );
		
		
		// South to North Part:
		line = new BusLine("H", color, new Point(68, 108)); // Ponte Giribaldi
		
		line.addLeg(Direction8.NE,  13).addOneWay(5).addLabel(2); // Connection (Teatro Marcello)
		line.addLeg(Direction8.N ,   4); // Argentina
		line.addLeg(Direction8.E ,  19).addLabel(5).addOneWay(3); // Connection (Venezia)
		
		addComplexShape( line );
	}
	
	private void addBus16(Color color)
	{
		BusLine line = new BusLine("u16", color, new Point(150, 52)); 
		
		line.addLeg(Direction8.SE, 7.5).addTerminus(0); // XX Settembre
		line.addLeg(Direction8.SW,  19).addLabel(4);
		line.addLeg(Direction8.SE,   4).addLabel(2); // Termini
		line.addLeg(Direction8.SW, 8.5);
		line.addLeg(Direction8.SE,   9).addLabel(3.5);
		line.addLeg(Direction8.S ,  34).addLabel(15);
		line.addLeg(Direction8.E ,  11);
		line.addLeg(Direction8.S ,  13).addLabel(6);
		line.addLeg(Direction8.SE,  15).addDirection(8, "COSTAMAGNA", true);
		
		addComplexShape( line );
	}
	
	private void addBus23(Color color)
	{
		BusLine line = new BusLine("u23", color, new Point( 15,  -1)); 
		
		// North to South:
		line.addLeg(Direction8.S ,  26).addDirection(9, "CLODIO", false).addLabel(12);
		line.addLeg(Direction8.SE,  13).addLabel(7);
		line.addLeg(Direction8.S ,  39).addOneWay(13).addLabel(17).addOneWay(4);
		line.addLeg(Direction8.SE,  36).addLabel(3).addOneWay(4).addLabel(10).addOneWay(4).addLabel(10).addOneWay(4);
		line.addLeg(Direction8.E ,  14).addLabel(8).addOneWay(4);
		line.addLeg(Direction8.SE,   3);
		line.addLeg(Direction8.S ,  10).addOneWay(9);
		line.addLeg(Direction8.SW,  25).addDirection(8, "PINCHERIE", true).addOneWay(7);
		line.addLeg(Direction8.SE,  11).addOneWay(3).addLabel(5);
		
		addComplexShape( line );
		
		
		// South to North;
		line = new BusLine("u23", color, new Point( 66, 161));
		
		line.addLeg(Direction8.NW, 6.5); // Connection
		line.addLeg(Direction8.NE,25.5).addLabel(8).addOneWay(4).addLabel(9).addOneWay(3);
		line.addLeg(Direction8.N ,  16).addLabel(3).addOneWay(4);
		line.addLeg(Direction8.NW,   4).addOneWay(3.5);
		line.addLeg(Direction8.W ,  15).addLabel(2);
		line.addLeg(Direction8.NW,  34).addLabel(13).addOneWay(4).addLabel(6).addOneWay(4);
		line.addLeg(Direction8.N ,  22).addLabel(14).addOneWay(4);
		line.addLeg(Direction8.NW,   4).addOneWay(3);
		line.addLeg(Direction8.N ,   2); // Connection

		addComplexShape( line );
	}
	
	private void addBus30(Color color)
	{
		BusLine line = new BusLine("u30", color, new Point( 65, 161)); 
		
		// South to North:
		line.addLeg(Direction8.NW,   4);
		line.addLeg(Direction8.NE,  27).addDirection(7, "LAURENTINA", false).addLabel(10);
		line.addLeg(Direction8.N ,  17).addLabel(5);
		line.addLeg(Direction8.NE,  10);
		line.addLeg(Direction8.N ,  19).addLabel(9.5); // Venezia
		line.addLeg(Direction8.W ,  31).addLabel(4).addLabel(18);
		line.addLeg(Direction8.NW,  13);
		line.addLeg(Direction8.N ,  20).addLabel(10);
		line.addLeg(Direction8.E ,  23).addOneWay(3).addLabel(14);
		line.addLeg(Direction8.NE,   3);
		line.addLeg(Direction8.N ,   9);
		line.addLeg(Direction8.NW,   3);
		line.addLeg(Direction8.W ,  23).addLabel(6).addOneWay(8);
		line.addLeg(Direction8.N ,  37).addLabel(11).addDirection(17, "CLODIO", true);
		
		addComplexShape( line );
		
		
		// North to South part;
		line = new BusLine("u30", color, new Point( 54,  35));
		
		line.addLeg(Direction8.S ,  18).addOneWay(7).addLabel(3).addOneWay(5); // Connection, Connection
		
		addComplexShape( line );
	}
	
	private void addBus34(Color color)
	{
		BusLine line = new BusLine("u34", color, new Point( 49, 36)); 
		
		// North-East to South-West:
		line.addLeg(Direction8.NW,   5).addTerminus(0); // Giustizia
		line.addLeg(Direction8.W ,  11);
		line.addLeg(Direction8.SW,   7);
		line.addLeg(Direction8.S ,  13).addLabel(6); // Piazza Pia, S. Spirito
		line.addLeg(Direction8.W ,  23);
		line.addLeg(Direction8.S ,  23).addLabel(-1);
		
		addComplexShape( line );
	}
	
	private void addBus40(Color color)
	{
		BusLine line = new BusLine("e40", color, new Point(152.5, 74.5));
		
		line.addLeg(Direction8.NW, 9.5).addTerminus(0); // Termini
		line.addLeg(Direction8.SW,  20); // Nazionale
		line.addLeg(Direction8.W ,  56).addLabel(17).addLabel(34); // Venezia, Argentina
		line.addLeg(Direction8.NW,  38).addLabel(25); // Pointe Vittorio
		line.addLeg(Direction8.N ,   6).addTerminus(-1); // Piazza Pia
		
		addComplexShape( line );
	}
	
	private void addBus44(Color color)
	{
		// North to South:
		BusLine line = new BusLine("u44", color, new Point( 90, 109));
		
		line.addLeg(Direction8.SW,   3).addTerminus(0); // Teatro Marcello
		line.addLeg(Direction8.S ,  17).addLabel(11);
		line.addLeg(Direction8.W ,  11).addOneWay(5);
		line.addLeg(Direction8.SW,  23).addLabel(10).addOneWay(12); // Ponte Sublicio
		line.addLeg(Direction8.NW,  20).addLabel(10);
		line.addLeg(Direction8.W ,  30).addLabel(5);
		line.addLeg(Direction8.S ,  30).addLabel(10).addDirection(11, "MONTALCINI", true);
		
		addComplexShape( line );
		
		
		// South North part:
		line = new BusLine("u44", color, new Point( 52, 151));
		
		line.addLeg(Direction8.SE, 6.5).addOneWay(4); // Connection, Ponte Sublicio
		line.addLeg(Direction8.NE,28.5).addLabel(10).addOneWay(15);
		line.addLeg(Direction8.N ,   3);
		
		addComplexShape( line );
	}
	
	private void addBus46(Color color)
	{
		BusLine line = new BusLine("e46", color, new Point( 94,  82));
		
		line.addLeg(Direction8.W ,  27).addTerminus(0).addLabel(18); // Venezia, Argentina
		line.addLeg(Direction8.NW , 30);
		line.addLeg(Direction8.W  , 24).addLabel(13);
		line.addLeg(Direction8.NW , 15).addLabel(2).addDirection(6, "MONTE MARIO", true);
		
		addComplexShape( line );
	}
	
	private void addBus49(Color color)
	{
		BusLine line = new BusLine("u49", color, new Point( 57,  40));
		
		line.addLeg(Direction8.W ,   3).addTerminus(0); // Giustizia
		line.addLeg(Direction8.NW,  11);
		line.addLeg(Direction8.W ,  27).addLabel(15);
		line.addLeg(Direction8.NW,   3);
		line.addLeg(Direction8.W ,  16).addDirection(6, "S. FILLOPO N.", true);
		
		addComplexShape( line );
	}
	
	private void addBus51(Color color)
	{
		BusLine line = new BusLine("u51", color, new Point(182, 148));
		
		line.addLeg(Direction8.W ,  24).addTerminus(0).addLabel(20); // Lodi
		line.addLeg(Direction8.NW,   2);
		line.addLeg(Direction8.N ,  14).addLabel(11);
		line.addLeg(Direction8.W ,  11);
		line.addLeg(Direction8.N ,   9);
		line.addLeg(Direction8.W ,  18).addLabel(10);
		line.addLeg(Direction8.NW,  23).addLabel(15); // Venezia
		line.addLeg(Direction8.N ,  35).addTerminus(-1); // S. Claudio
		
		addComplexShape( line );
	}
	
	private void addBus60(Color color)
	{
		BusLine line = new BusLine("u60", color, new Point(106,  82));
		
		// Venezia to East:
		line.addLeg(Direction8.E ,  17).addTerminus(0); // Venezia
		line.addLeg(Direction8.NE,  17).addLabel(9);
		line.addLeg(Direction8.NW, 6.5);
		line.addLeg(Direction8.NE,  60).addLabel(10).addLabel(10.5).addLabel(16).addDirection(17, "PUGLIESE	", true);
		
		addComplexShape( line );
	}
	
	private void addBus61(Color color)
	{
		BusLine line = new BusLine("u61", color, new Point(96, 7));
		
		// West to East:
		line.addLeg(Direction8.S ,  11).addLabel(0).addTerminus(8); // Difesa, Paiazzo del Pololo
		line.addLeg(Direction8.E ,  19).addLabel(16);
		line.addLeg(Direction8.SE,  15); // Borghese
		line.addLeg(Direction8.S ,  26).addLabel(16); // Barberini
		line.addLeg(Direction8.E ,  10);
		line.addLeg(Direction8.NE,  17).addLabel(5); // XX Settembre
		line.addLeg(Direction8.E ,  46).addLabel(11).addDirection(25, "BALSAMO CRIVELLI", true);
		
		addComplexShape( line );
	}
	
	private void addBus62(Color color)
	{
		BusLine line = new BusLine("u62", color, new Point( 30,  49));
		
		line.addLeg(Direction8.SE,  37).addTerminus(0).addLabel(16); // Ospedale di S. Spirito
		line.addLeg(Direction8.E ,  53).addLabel(9).addLabel(18).addLabel(16); // Argentina, Venezia
		line.addLeg(Direction8.NE,  21).addLabel(10);
		line.addLeg(Direction8.NW,   6);
		line.addLeg(Direction8.NE,  60).addLabel(20).addLabel(16).addDirection(17, "MARX", true);
		
		addComplexShape( line );
	}
	
	private void addBus63(Color color)
	{
		BusLine line = new BusLine("u63", color, new Point(147,  -1));
		
		// North to South:
		line.addLeg(Direction8.S ,  38).addDirection(9.5, "ROSSELLINI", false).addLabel(12);
		line.addLeg(Direction8.SW,   9).addLabel(5);
		line.addLeg(Direction8.W ,  11);
		line.addLeg(Direction8.S ,  13).addLabel(7);
		line.addLeg(Direction8.W ,  30).addLabel(13);
		line.addLeg(Direction8.S ,  44).addLabel(13).addOneWay(24);
		line.addLeg(Direction8.SW,   2);
		line.addLeg(Direction8.W ,  19).addTerminus(6).addOneWay(5);
		line.addLeg(Direction8.NE,   8).addLabel(4).addOneWay(3);
		line.addLeg(Direction8.N ,   4);
		line.addLeg(Direction8.E ,  13).addLabel(2).addOneWay(3);
		line.addLeg(Direction8.N ,   2);
		
		addComplexShape( line );
	}
	
	private void addBus64(Color color)
	{
		BusLine line = new BusLine("u64", color, new Point(13, 65));
		
		line.addLeg(Direction8.N ,   4).addTerminus(0); // Roma S. Pietro
		line.addLeg(Direction8.NE,   8);
		line.addLeg(Direction8.E ,  10);
		line.addLeg(Direction8.SE,  36).addLabel(15);
		line.addLeg(Direction8.E ,  53).addLabel(5).addLabel(18).addLabel(16); // Argentina, Venezia
		line.addLeg(Direction8.NE,22.5).addLabel(14); // Reppublica
		line.addLeg(Direction8.SE,   9).addTerminus(-1); // Termini
		
		addComplexShape( line );
	}
	
	private void addBus66(Color color)
	{
		BusLine line = new BusLine("u66", color, new Point(155.5,  71.5));
		
		line.addLeg(Direction8.NW,14.5).addTerminus(0); // Termini
		line.addLeg(Direction8.NE,  61).addLabel(16).addLabel(16).addDirection(17, "MARX", true);
		
		addComplexShape( line );
	}
	
	private void addBus70(Color color)
	{
		BusLine line = new BusLine("u70", color, new Point(162, 92)); 
		
		line.addLeg(Direction8.NW,  10).addTerminus(0); // Pantano, TERMINI
		line.addLeg(Direction8.SW,10.5);
		line.addLeg(Direction8.NW,13.5).addLabel(10);
		line.addLeg(Direction8.SW,   4);
		line.addLeg(Direction8.W ,  57).addLabel(14).addLabel(20).addLabel(18); // Venezia, Argentina
		line.addLeg(Direction8.NW,  10);
		line.addLeg(Direction8.N ,  19).addLabel(10);
		line.addLeg(Direction8.E ,  20).addLabel(10);
		line.addLeg(Direction8.NE,   6);
		line.addLeg(Direction8.N ,   9);
		line.addLeg(Direction8.NW,   6);
		line.addLeg(Direction8.W ,  22).addLabel(10); // Giustizia
		line.addLeg(Direction8.N ,  35).addLabel(4).addDirection(21, "CLODIO", true);
		
		addComplexShape( line );
	}
	
	private void addBus71(Color color)
	{
		BusLine line = new BusLine("u71", color, new Point(107, 64));
		
		line.addLeg(Direction8.E ,  11).addTerminus(0); // S. Claudio
		line.addLeg(Direction8.S ,   8).addLabel(5);
		line.addLeg(Direction8.SE,  28).addLabel(15); // Maggiore
		line.addLeg(Direction8.NE,  11);
		line.addLeg(Direction8.SE,  17).addLabel(10);
		line.addLeg(Direction8.NE,  30).addLabel(5).addDirection(15, "TIBURTINA", true);
		
		addComplexShape( line );
	}
	
	private void addBus75(Color color)
	{
		BusLine line = new BusLine("u75", color, new Point(157, 61));
		
		line.addLeg(Direction8.SW,  17).addTerminus(0); // Piazza Indiendanza
		line.addLeg(Direction8.SE,   4).addLabel(2);
		line.addLeg(Direction8.SW,30.5).addLabel(15).addLabel(9); // Colosseo
		line.addLeg(Direction8.SE,14.5);
		line.addLeg(Direction8.SW,  39).addLabel(6).addDirection(22, "POERIO", true);
		
		addComplexShape( line );
	}
	
	private void addBus80(Color color)
	{
		BusLine line = new BusLine("u80", color, new Point(101, 80.5));
		
		line.addLeg(Direction8.N ,18.5).addTerminus(0);
		line.addLeg(Direction8.E ,  31).addLabel(9);
		line.addLeg(Direction8.N ,  14).addLabel(11);
		line.addLeg(Direction8.E ,   6);
		line.addLeg(Direction8.NE,  51).addLabel(4).addLabel(21).addDirection(11, "PORTA d ROMA", true);
		
		addComplexShape( line );
	}
	
	private void addBus81(Color color)
	{
		// South to North:
		BusLine line = new BusLine("u81", color, new Point( 26,  25));
		
		// North to South:
		line.addLeg(Direction8.E ,  26).addTerminus(0).addLabel(20); // Risorgimento
		line.addLeg(Direction8.S ,   8); // Giustizia
		line.addLeg(Direction8.SE,   2); // Giustizia
		line.addLeg(Direction8.E ,  23).addLabel(14);
		line.addLeg(Direction8.SE,   4);
		line.addLeg(Direction8.S ,   9); // Augustino
		line.addLeg(Direction8.SW,   4);
		line.addLeg(Direction8.W ,  22).addLabel(10);
		line.addLeg(Direction8.S ,  24).addLabel(12);
		line.addLeg(Direction8.SE,  12);
		line.addLeg(Direction8.E ,  29).addLabel(9).addLabel(18); // Venezia, Argentina
		line.addLeg(Direction8.S ,22.5);
		line.addLeg(Direction8.SW,   3).addLabel(1.5); // Teatro Marcello
		line.addLeg(Direction8.S ,  16);
		line.addLeg(Direction8.SE,  13).addLabel(5); // Circo Massimo
		line.addLeg(Direction8.NE,  15); // Colloseo
		line.addLeg(Direction8.E ,   3);
		line.addLeg(Direction8.S ,18.5).addLabel(7);
		line.addLeg(Direction8.E ,  80).addLabel(10).addLabel(30).addLabel(15).addDirection(14, "MALATESTA", true);
		
		addComplexShape( line );
	}
	
	private void addBus82(Color color)
	{
		BusLine line = new BusLine("u82", color, new Point(154.5, 72.5));
		
		line.addLeg(Direction8.NW,15.5).addTerminus(0); // Termini
		line.addLeg(Direction8.NE,  57).addLabel(17).addLabel(16).addDirection(17, "SEMPIONE", true);
		
		addComplexShape( line );
	}
	
	private void addBus83(Color color)
	{
		BusLine line = new BusLine("u83", color, new Point(59, 161));
		
		// South to North:
		line.addLeg(Direction8.NE,  31).addDirection(6, "PARTIGIANI", false).addLabel(10);
		line.addLeg(Direction8.N ,  17).addLabel(7);
		line.addLeg(Direction8.NE,  10);
		line.addLeg(Direction8.N ,  42).addLabel(5).addLabel(21); // S. Claudio
		line.addLeg(Direction8.E ,  31).addLabel(6);
		line.addLeg(Direction8.N ,  14).addLabel(7);
		line.addLeg(Direction8.E ,   7);
		line.addLeg(Direction8.NE,  10).addLabel(7);
		line.addLeg(Direction8.N ,  46).addLabel(12.5).addDirection(16, "L.GO VALSAB.", true);
		
		addComplexShape( line );
	}
	
	private void addBus85(Color color)
	{
		BusLine line = new BusLine("u85", color, new Point(153.5, 73.5));
		
		line.addLeg(Direction8.NW,10.5).addTerminus(0); // Termini
		line.addLeg(Direction8.W ,  40).addLabel(26);
		line.addLeg(Direction8.S ,  37).addLabel(10).addLabel(25);
		line.addLeg(Direction8.SE,  24).addLabel(15);
		line.addLeg(Direction8.E ,  17).addLabel(12);
		line.addLeg(Direction8.S ,   9);
		line.addLeg(Direction8.E ,  11).addLabel(2);
		line.addLeg(Direction8.S ,  13);
		line.addLeg(Direction8.SE,  14).addDirection(8, "TRAVERTINO", true);
		
		addComplexShape( line );
	}
	
	private void addBus87(Color color)
	{
		BusLine line = new BusLine("u87", color, new Point(75, 8));
		
		line.addLeg(Direction8.W ,  18).addLabel(0).addTerminus(13); // Lepanto
		line.addLeg(Direction8.S ,  26).addLabel(21); // Giustizia
		line.addLeg(Direction8.E ,  20).addLabel(14);
		line.addLeg(Direction8.SE,   5);
		line.addLeg(Direction8.S ,   9);
		line.addLeg(Direction8.SW,   5);
		line.addLeg(Direction8.W ,  21).addLabel(6);
		line.addLeg(Direction8.S ,  23).addLabel(7);
		line.addLeg(Direction8.SE,  11);
		line.addLeg(Direction8.E ,  34).addLabel(5).addLabel(18); // Argentina, Venezia
		line.addLeg(Direction8.S ,  12);
		line.addLeg(Direction8.SE,  26).addLabel(8).addLabel(14); // Colosseo
		line.addLeg(Direction8.E ,  15);
		line.addLeg(Direction8.S ,  10); // Laterano
		line.addLeg(Direction8.E ,   7);
		line.addLeg(Direction8.S ,   4).addLabel(2);
		line.addLeg(Direction8.SW,  21).addDirection(15, "C. ALBANI", true);
		
		addComplexShape( line );
	}
	
	private void addBus92(Color color)
	{
		BusLine line = new BusLine("u92", color, new Point(150,  -1));
		
		line.addLeg(Direction8.S ,  46).addDirection(9.5, "MARLIANA", false).addLabel(16);
		line.addLeg(Direction8.SE,  13).addLabel(5);
		line.addLeg(Direction8.SW, 9.5);
		line.addLeg(Direction8.SE,   3).addTerminus(-1); // Termini
		
		addComplexShape( line );
	}
	
	private void addBus115(Color color)
	{
		BusLine line = new BusLine("u115", color, new Point( 36,  59.5));
		
		line.addLeg(Direction8.NW, 5.5).addTerminus(0);
		line.addLeg(Direction8.W , 6.5);
		line.addLeg(Direction8.S ,67.5).addLabel(20).addLabel(25);
		line.addLeg(Direction8.SE,  14).addLabel(-1);
		
		addComplexShape( line );
	}
	
	private void addBus118(Color color)
	{
		// North to South:
		BusLine line = new BusLine("u118", color, new Point(106,  94));
		
		line.addLeg(Direction8.S ,  12).addTerminus(0); // Venezia
		line.addLeg(Direction8.SE,  21).addOneWay(3).addLabel(3); // Colloseo
		line.addLeg(Direction8.SW,  19).addLabel(8).addOneWay(9); // Massimo
		line.addLeg(Direction8.SE,  16).addDirection(7, "APPIA", true);
		
		addComplexShape( line );
		
		
		// South to North part:
		line = new BusLine("u118", color, new Point(109, 147));
		
		line.addLeg(Direction8.NW,  15).addOneWay(5).addLabel(3); // Massimo
		line.addLeg(Direction8.N ,  14).addLabel(9);
		line.addLeg(Direction8.NE,  12).addLabel(6).addOneWay(4);
		line.addLeg(Direction8.N ,   2);
		
		addComplexShape( line );
	}
	
	private void addBus160(Color color)
	{
		BusLine line = new BusLine("u160", color, new Point( 94,   7));
		
		line.addLeg(Direction8.S ,  12).addLabel(0).addTerminus(9); // Difesa, Paiazzo del Pololo
		line.addLeg(Direction8.E ,  21).addLabel(13.5);
		line.addLeg(Direction8.SE,  14); // Borghese
		line.addLeg(Direction8.S ,  25).addLabel(20); // Barberini
		line.addLeg(Direction8.W ,  27).addLabel(19); // S. Claudio
		line.addLeg(Direction8.S ,  44).addLabel(19).addLabel(17);
		line.addLeg(Direction8.SW,  11);
		line.addLeg(Direction8.S ,  18).addLabel(6);
		line.addLeg(Direction8.SE,  33).addLabel(12).addDirection(11, "MONTAGNOLA", true);
		
		addComplexShape( line );
	}
	
	private void addBus170(Color color)
	{
		BusLine line = new BusLine("u170", color, new Point(61, 161));
		
		// South to North:
		line.addLeg(Direction8.NE,  31).addDirection(9, "AGRICOLTURA", false).addLabel(10);
		line.addLeg(Direction8.N ,  17).addLabel(7);
		line.addLeg(Direction8.NE,  13).addLabel(8);
		line.addLeg(Direction8.N ,   8);
		line.addLeg(Direction8.E ,  14).addLabel(8);
		line.addLeg(Direction8.NE,22.5).addLabel(16);
		line.addLeg(Direction8.SE,   8).addTerminus(-1); // Termini
		
		addComplexShape( line );
	}
	
	private void addBus280(Color color)
	{
		// South to North:
		BusLine line = new BusLine("u280", color, new Point( 64, 161));
		
		line.addLeg(Direction8.NW,   5);
		line.addLeg(Direction8.NE,  27).addOneWay(2).addLabel(3).addLabel(15);
		line.addLeg(Direction8.N ,  16).addOneWay(2).addLabel(8);
		line.addLeg(Direction8.NW,   5).addOneWay(3);
		line.addLeg(Direction8.W ,  15).addLabel(5);
		line.addLeg(Direction8.NW,  33).addLabel(7).addOneWay(3).addLabel(17).addOneWay(3);
		line.addLeg(Direction8.N ,  20).addLabel(7).addOneWay(5);
		line.addLeg(Direction8.NE,   7);
		line.addLeg(Direction8.E ,  35).addLabel(4).addOneWay(4).addLabel(15).addOneWay(4);
		line.addLeg(Direction8.NE,   3);
		line.addLeg(Direction8.N ,   6).addOneWay(3);
		line.addLeg(Direction8.NW,   1);
		line.addLeg(Direction8.W ,  23).addLabel(6).addOneWay(6).addOneWay(9);
		line.addLeg(Direction8.NW,   1);
		line.addLeg(Direction8.N ,  40).addLabel(8).addDirection(21, "MANCINI", true);
		
		addComplexShape( line );
		
		
		// North to South:
		line = new BusLine("u280", color, new Point( 53,  30));
		
		line.addLeg(Direction8.S ,   2); // Connection
		line.addLeg(Direction8.W ,  20).addOneWay(3).addLabel(11);
		line.addLeg(Direction8.SW,   6).addOneWay(3);
		line.addLeg(Direction8.S ,  39).addLabel(9).addLabel(15).addOneWay(4);
		line.addLeg(Direction8.SE,  37).addLabel(10).addOneWay(4).addLabel(10).addOneWay(4);
		line.addLeg(Direction8.E ,  14).addLabel(4).addOneWay(4);
		line.addLeg(Direction8.SE,   2);
		line.addLeg(Direction8.S ,  10).addLabel(3).addOneWay(4);
		line.addLeg(Direction8.SW,25.5).addLabel(1).addOneWay(12).addDirection(6, "PARTIGIANI", true);
		line.addLeg(Direction8.SE,   6).addLabel(2).addOneWay(2);
		
		addComplexShape( line );
	}
	
	private void addBus301(Color color)
	{
		BusLine line = new BusLine("u301", color, new Point(56, -1));
		
		line.addLeg(Direction8.S ,  33).addDirection(9, "GROTTAROSSA", false).addLabel(17); // Giustizia
		line.addLeg(Direction8.E ,  21).addLabel(15);
		line.addLeg(Direction8.SE,   7); // Augustino
		line.addLeg(Direction8.N ,  31).addTerminus(3).addLabel(-1); // Defisa
		
		addComplexShape( line );
	}
	
	private void addBus310(Color color)
	{
		BusLine line = new BusLine("u310", color, new Point(157.5,  69.5));
		
		line.addLeg(Direction8.NW, 2.5).addTerminus(0); // Termini
		line.addLeg(Direction8.NE, 6.5);
		line.addLeg(Direction8.E , 7.5);
		line.addLeg(Direction8.S ,10.5).addLabel(7.5);
		line.addLeg(Direction8.E ,  32).addLabel(12).addDirection(12, "VESCOVIO", true);
		
		addComplexShape( line );
	}
	
	private void addBus360(Color color)
	{
		BusLine line = new BusLine("u360", color, new Point(129, 161));
		
		line.addLeg(Direction8.NE,  21).addDirection(6, "ZAMA", false).addLabel(12);
		line.addLeg(Direction8.N ,  34).addLabel(25);
		line.addLeg(Direction8.NW,14.5);
		line.addLeg(Direction8.NE,  10);
		line.addLeg(Direction8.NW,   4).addLabel(2);
		line.addLeg(Direction8.NE,  20);
		line.addLeg(Direction8.NW,12.5).addLabel(3);
		line.addLeg(Direction8.N ,  47).addLabel(5).addLabel(19.5).addDirection(12, "MUSE", true);
		
		addComplexShape( line );
	}
	
	private void addBus490(Color color)
	{
		BusLine line = new BusLine("u490", color, new Point( 92,  -1));
		
		line.addLeg(Direction8.S ,  22).addLabel(3).addDirection(13, "CORNELIA", false);
		line.addLeg(Direction8.E ,  23).addLabel(4).addLabel(11.5);
		line.addLeg(Direction8.SE,  12);
		line.addLeg(Direction8.S ,   7).addLabel(3);
		line.addLeg(Direction8.E ,  16);
		line.addLeg(Direction8.NE,   8);
		line.addLeg(Direction8.SE,   9).addLabel(2);
		line.addLeg(Direction8.E ,  37).addLabel(11).addDirection(22, "TIBURTINA", true);
		
		addComplexShape( line );
	}
	
	private void addBus492(Color color)
	{
		BusLine line = new BusLine("u492", color, new Point( -1,   5));
		
		// North-West to South-East:
		line.addLeg(Direction8.E ,  15).addDirection(8, "CIPRO", false);
		line.addLeg(Direction8.S ,  20).addLabel(10);
		line.addLeg(Direction8.SE,   2);
		line.addLeg(Direction8.E ,  28).addLabel(10);
		line.addLeg(Direction8.SE,  10).addLabel(3); // Giustizia
		line.addLeg(Direction8.E ,  23).addLabel(13);
		line.addLeg(Direction8.SE,   2); // Augustino
		line.addLeg(Direction8.S ,   9);
		line.addLeg(Direction8.SW,   2);
		line.addLeg(Direction8.W ,  19).addLabel(9);
		line.addLeg(Direction8.S ,  22).addLabel(9);
		line.addLeg(Direction8.SE,   9); // Argentina
		line.addLeg(Direction8.E ,  31).addLabel(5).addLabel(18); // Venezia
		line.addLeg(Direction8.N ,  21).addLabel(13); // S. Claudio
		line.addLeg(Direction8.E ,  47).addLabel(12);
		line.addLeg(Direction8.SE,   5).addLabel(3); // Termini
		line.addLeg(Direction8.NE,   6);
		line.addLeg(Direction8.E ,  15).addLabel(13);
		line.addLeg(Direction8.S ,  35).addLabel(9).addLabel(15);
		line.addLeg(Direction8.E ,  13).addLabel(7);
		line.addLeg(Direction8.NE,  20).addDirection(9, "TIBURTINA", true);
		
		addComplexShape( line );
	}
	
	private void addBus590(Color color)
	{
		BusLine line = new BusLine("u590", color, new Point( 24,  21));
		
		line.addLeg(Direction8.N ,  15).addTerminus(0); // Risorgimento
		line.addLeg(Direction8.E ,  69).addLabel(25).addLabel(20); // Defizia
		line.addLeg(Direction8.S ,  14).addLabel( 2);
		line.addLeg(Direction8.E ,  22).addLabel(18);
		line.addLeg(Direction8.SE,  13); // Augustino
		line.addLeg(Direction8.S ,  29).addLabel(16); // Reppublica
		line.addLeg(Direction8.SE,  19).addLabel(6).addLabel(11); // TERMINI
		line.addLeg(Direction8.SW,10.5);
		line.addLeg(Direction8.SE,14.5).addLabel(7);
		line.addLeg(Direction8.S ,  55).addLabel(13).addLabel(25).addDirection(9, "CINECITTÀ", true);
		
		addComplexShape( line );
	}
	
	private void addBus628(Color color)
	{
		BusLine line = new BusLine("u628", color, new Point(86, -1));
		
		line.addLeg(Direction8.S ,  40).addDirection(9, "VOLPI", false).addLabel(20);
		
		// One-Way Southbound:
		line.addLeg(Direction8.SE,  13).addOneWay(3).addLabel(5);
		line.addLeg(Direction8.S ,  51).addOneWay(4).addLabel(9).addOneWay(14).addLabel(16); // S Claudio, Venezia
		line.addLeg(Direction8.SW,  10);
		line.addLeg(Direction8.S ,  18).addLabel(6); // Teatro Marcello
		line.addLeg(Direction8.SE,  29).addLabel(10).addDirection(14, "BARIONIO", true);
		
		addComplexShape( line );
		
		// One-Way Northbound:
		line = new BusLine("u628", color, new Point(99, 82));
		
		line.addLeg(Direction8.N ,  2); // Connection (Venezia)
		line.addLeg(Direction8.W , 32).addOneWay(5).addLabel(8).addLabel(10).addOneWay(7); // Argentina
		line.addLeg(Direction8.NW,  8);
		line.addLeg(Direction8.N , 17).addOneWay(4).addLabel(6);
		line.addLeg(Direction8.E , 18).addLabel(12);
		line.addLeg(Direction8.NE,  9);
		line.addLeg(Direction8.N ,  8).addOneWay(4); // Connection
		
		addComplexShape( line );
	}
	
	private void addBus649(Color color)
	{
		BusLine line = new BusLine("u649", color, new Point(155, 161));
		
		// South to North-East:
		line.addLeg(Direction8.NE,  17).addDirection(12, "L. DON ORIONE", false);
		line.addLeg(Direction8.N ,  19).addLabel(2);
		line.addLeg(Direction8.NW,  34).addLabel(2).addLabel(22);
		line.addLeg(Direction8.NE,10.5);
		line.addLeg(Direction8.NW, 4.5).addLabel(2.5);
		line.addLeg(Direction8.NE,  16).addLabel(11);
		line.addLeg(Direction8.E ,  10).addLabel(3);
		line.addLeg(Direction8.S ,  10).addLabel(5);
		line.addLeg(Direction8.E ,  14).addLabel(7);
		line.addLeg(Direction8.N ,  27).addLabel(16);
		line.addLeg(Direction8.E ,  20).addDirection(9, "TIBURTINA", true);
		
		addComplexShape( line );
	}
	
	private void addBus710(Color color)
	{
		BusLine line = new BusLine("710", color, new Point( 22, 120));
		
		line.addLeg(Direction8.S ,  13).addLabel(0).addTerminus(8); // Lenin
		line.addLeg(Direction8.W ,  13);
		line.addLeg(Direction8.S ,  28).addLabel(9).addDirection(11, "CARINI", true);
		
		addComplexShape( line );
	}
	
	private void addBus780(Color color)
	{
		BusLine line = new BusLine("u780", color, new Point(17, 161));
		
		line.addLeg(Direction8.NE,  65).addDirection(6, "NERVI", false).addLabel(6).addLabel(30).addOneWay(15).addLabel(5); // Esami
		line.addLeg(Direction8.N ,   4); // Argentina
		line.addLeg(Direction8.E ,  12).addTerminus(9); // Venezia
		line.addLeg(Direction8.S ,  11).addOneWay(7);
		line.addLeg(Direction8.SW,   3); // Teatro Marcello
		line.addLeg(Direction8.W ,  19).addLabel(9).addOneWay(8);
		line.addLeg(Direction8.SW,   3);
		
		addComplexShape( line );
	}
	
	private void addBus870(Color color)
	{
		BusLine line = new BusLine("u870", color, new Point( 37,  57.5));
		
		line.addLeg(Direction8.NW,   4).addTerminus(0);
		line.addLeg(Direction8.W ,  10);
		line.addLeg(Direction8.S ,77.5).addLabel(25).addLabel(25);
		line.addLeg(Direction8.W ,  21).addLabel(15);
		line.addLeg(Direction8.S ,  30).addLabel(5).addDirection(17, "TRULLO", true);
		
		addComplexShape( line );
	}
	
	private void addBus881(Color color)
	{
		BusLine line = new BusLine("u881", color, new Point( 38,  54.5));
		
		line.addLeg(Direction8.NW,   2).addTerminus(0); // Paola
		line.addLeg(Direction8.W ,  37).addDirection(29, "AVANZINI", true);
		
		addComplexShape( line );
	}
	
	private void addBus990(Color color)
	{
		BusLine line = new BusLine("u990", color, new Point( 61,  39));
		
		line.addLeg(Direction8.W ,   7).addTerminus(0); // Giustizia
		line.addLeg(Direction8.NW,  11);
		line.addLeg(Direction8.W ,  27).addLabel(19); // Risorgimento
		line.addLeg(Direction8.NW,   3);
		line.addLeg(Direction8.N ,  19).addLabel(5);
		line.addLeg(Direction8.W ,  16).addDirection(6, "MONTE MARIO", true);
		
		addComplexShape( line );
	}

	
	// *******************************************************************
	// *** TRAM Lines ***
	
	private void addTramLines()
	{
		addTramLine2   ();
		addTramLine3   ();
		addTramLine3_19();
		addTramLine5_14();
		addTramLine8   ();
		addTramLine19  ();
	}
	
	private void addTramLine2()
	{
		TramLine line = new TramLine("2", new Point(98, 16));
		
		line.addLeg(Direction8.N ,  20).addTerminus(0);
	
		addComplexShape( line );
	}
	
	private void addTramLine3()
	{
		// South-West Part:
		TramLine line = new TramLine("3", new Point(20, 161));
		
		line.addLeg(Direction8.NE,  20).addLabel(10);
		line.addLeg(Direction8.SE,  20).addLabel(10);
		
		addComplexShape( line );
		
		
		// South-East Part:
		line = new TramLine("3", new Point(92, 161));
		
		line.addLeg(Direction8.NE,  35).addLabel(20);
		line.addLeg(Direction8.E ,  25);
		line.addLeg(Direction8.S ,  12); // Giovanni
		line.addLeg(Direction8.E ,  17).addLabel(7);
		line.addLeg(Direction8.NE,  32).addLabel(15).addLabel(12);
		
		addComplexShape( line );
	}
	
	
	private void addTramLine3_19()
	{
		// East Part:
		TramLine line = new TramLine("3.19", new Point(201, 90));
		
		line.addLeg(Direction8.NW,   5).addLabel(3);
		line.addLeg(Direction8.NE,   5);

		addComplexShape( line );
		
		
		// North-East Part:
		line = new TramLine("3.19", new Point(201, 56));
		
		line.addLeg(Direction8.NW,  57).addLabel(10).addLabel(25);

		addComplexShape( line );
	}
	
	private void addTramLine5_14()
	{
		TramLine line = new TramLine("5.14", new Point(149, 83));
		
		line.addLeg(Direction8.SW,   9).addTerminus(0); // TERMINI
		line.addLeg(Direction8.SE,  25).addLabel(20);
		line.addLeg(Direction8.E,   18);
		line.addLeg(Direction8.SE,  21).addLabel(6);
		
		addComplexShape( line );
	}
	
	private void addTramLine8()
	{
		TramLine line = new TramLine("8", new Point(18, 161)); // Esami
		
		line.addLeg(Direction8.NE,  65).addLabel(15).addLabel(20).addLabel(24);
		line.addLeg(Direction8.N ,   6); // Argentina
		line.addLeg(Direction8.E ,  11).addTerminus(-1); // Piazza Venezia
		
		addComplexShape( line );
	}
	
	private void addTramLine19()
	{
		// North Part:
		TramLine line = new TramLine("19", new Point(23, 25));
		
		line.addLeg(Direction8.N ,  20).addTerminus(0); // Piazza del Risorgimento
		line.addLeg(Direction8.E ,  74).addLabel(20).addLabel(21).addLabel(28);
		line.addLeg(Direction8.N ,  10);
		
		addComplexShape( line );

		// South Part:
		line = new TramLine("19", new Point(201, 108));
		
		line.addLeg(Direction8.SW,12.5).addLabel(8);
		line.addLeg(Direction8.SE,  15);
		
		addComplexShape( line );
	}
	
	
	// *******************************************************************
	// *** TRAIN Lines ***
	
	private void addTrainLines()
	{
		addTerminiTrainLine();
		addLazioTrainLine  ();
		addSPietroTrainLine();
		addViterboTrainLine();
	}
	
	private void addTerminiTrainLine()
	{
		TrainLine line = new TrainLine(new Point(154, 81));
		
		line.addLeg(Direction8.SE,  50).addStation(0);
		
		addComplexShape( line );
	}
	
	private void addLazioTrainLine()
	{
		TrainLine line = new TrainLine(new Point(165, 95));
		
		line.addLeg(Direction8.SE,  42).addStation(0).addStation(21); // Pantano, Porta Maggiore
		
		addComplexShape( line );
	}
	
	private void addSPietroTrainLine()
	{
		TrainLine line = new TrainLine(new Point(-1, 55));
		
		line.addLeg(Direction8.SE,  15).addStation(12);
		line.addLeg(Direction8.S , 105);
		
		addComplexShape( line );
	}
	
	private void addViterboTrainLine()
	{
		TrainLine line = new TrainLine(new Point(101, 12));
		
		line.addLeg(Direction8.NE,  15).addStation(0); // Piazza del Popolo
		
		addComplexShape( line );
	}
	
	
	// *******************************************************************
	// *** LABELS ***
	
	private void addZonesAndLabels()
	{
		addComplexShape( new TransferZone(new Point(150.5, 76.5), 22, 16, -45) );
		addComplexShape( new ZoneLabel(new Point(161, 79), "Termini") );
		
		addComplexShape( new TransferZone(new Point(140, 67.5), 13, 6, -45) );
		addComplexShape( new ZoneLabel(new Point(133, 70), "Repubblica") );
		
		addComplexShape( new TransferZone(new Point(99, 87), 15, 16, 0) );
		addComplexShape( new ZoneLabel(new Point(108, 79.5), "Venezia") );
		
		addComplexShape( new TransferZone(new Point(83, 86.5), 7, 15, 0) );
		addComplexShape( new ZoneLabel(new Point( 76,  91), "Argentina") );
		
		addComplexShape( new TransferZone(new Point(90, 109), 13, 10, 0) );
		addComplexShape( new ZoneLabel(new Point(86, 112), "Teatro Marcello") );
		
		addComplexShape( new TransferZone(new Point(28, 51), 5, 8, 0) );
		addComplexShape( new ZoneLabel(new Point(21, 49), "S. Spirito") );
		
		addComplexShape( new TransferZone(new Point(37, 57), 6, 9, 0) );
		addComplexShape( new ZoneLabel(new Point(42, 57), "Paola") );
		
		addComplexShape( new TransferZone(new Point(55, 36), 16, 10, 0) );
		addComplexShape( new ZoneLabel(new Point(62, 30.5), "Giustizia") );
		
		addComplexShape( new TransferZone(new Point(23, 25), 10, 13, 0) );
		addComplexShape( new ZoneLabel(new Point(32, 23), "Risorgimento") );
		
		addComplexShape( new TransferZone(new Point(95, 17), 14, 10, 0) );
		addComplexShape( new ZoneLabel(new Point(105.5, 16), "Flaminio") );
		
		addComplexShape( new TransferZone(new Point(95, 6), 8, 5, 0) );
		addComplexShape( new ZoneLabel(new Point(93, 3), "Marina") );
		
		addComplexShape( new TransferZone(new Point(82, 37), 11, 7, 0) );
		addComplexShape( new ZoneLabel(new Point(84, 33), "Augustino") );
		
		addComplexShape( new TransferZone(new Point(105, 147), 10, 7, -45) );
		addComplexShape( new ZoneLabel(new Point(100, 146), "Circo") );
		
		addComplexShape( new TransferZone(new Point(124, 124), 8, 11, -45) );
		addComplexShape( new ZoneLabel(new Point(120, 126), "Colosseo") );
		
		addComplexShape( new TransferZone(new Point(152.5, 140), 9, 15, 0) );
		addComplexShape( new ZoneLabel(new Point(159, 143), "Giavanni") );
		
		addComplexShape( new TransferZone(new Point(152, 106), 6, 5, 0) );
		addComplexShape( new ZoneLabel(new Point(158, 105), "Vittorio") );
		
		addComplexShape( new TransferZone(new Point(163, 94), 4, 9, -45) );
		addComplexShape( new ZoneLabel(new Point(161, 96), "Giolotti") );
		
		addComplexShape( new TransferZone(new Point(145.5, 50.5), 15, 7, -45) );
		addComplexShape( new ZoneLabel(new Point(142, 51), "XX Settembre") );
		
		addComplexShape( new TransferZone(new Point(128, 61), 10, 7, 0) );
		addComplexShape( new ZoneLabel(new Point(124, 64), "Barberini") );
		
		addComplexShape( new TransferZone(new Point(130, 40), 7, 2, 0) );
		addComplexShape( new ZoneLabel(new Point(134, 39), "Brasile") );
		
		addComplexShape( new TransferZone(new Point(103, 62), 13, 11, 0) );
		addComplexShape( new ZoneLabel(new Point(96, 57), "S. Claudio") );
		
		addComplexShape( new TransferZone(new Point(58, 8), 13, 8, 0) );
		addComplexShape( new ZoneLabel(new Point(62, 12), "Lepanto") );
		
		addComplexShape( new TransferZone(new Point(25, 8), 5, 8, 0) );
		addComplexShape( new ZoneLabel(new Point(29, 12), "Ottaviano") );
		
		addComplexShape( new TransferZone(new Point(138, 92), 8, 8, -45) );
		addComplexShape( new ZoneLabel(new Point(129, 92), "Maggiore") );
		
		addComplexShape( new TransferZone(new Point(89.5, 130), 11, 6, 0) );
		addComplexShape( new ZoneLabel(new Point(91, 129), "Bocca") );
		
		addComplexShape( new TransferZone(new Point(39, 139), 8, 8, -45) );
		addComplexShape( new ZoneLabel(new Point(39, 139), "Trastevere") );
		
		addComplexShape( new TransferZone(new Point(187, 118), 8, 8, -45) );
		addComplexShape( new ZoneLabel(new Point(186, 119), "Maggiore") );
		
		addComplexShape( new TransferZone(new Point(169, 60), 5, 6, 0) );
		addComplexShape( new ZoneLabel(new Point(172, 57), "Castro Pretorio") );
		
		addComplexShape( new TransferZone(new Point(11, 66), 7, 7, 0) );
		addComplexShape( new ZoneLabel(new Point(11, 69), "S. Pietro") );
		
		addComplexShape( new TransferZone(new Point(187, 42), 5, 6, 0) );
		addComplexShape( new ZoneLabel(new Point(184, 39), "Policlinico") );
		
		addComplexShape( new TransferZone(new Point(195, 85), 5, 5, -45) );
		addComplexShape( new ZoneLabel(new Point(193, 82), "Verano") );
		
		addComplexShape( new TransferZone(new Point(171, 24), 5, 6, -45) );
		addComplexShape( new ZoneLabel(new Point(171, 27), "Margherita") );
		
		addComplexShape( new TransferZone(new Point(70, 109), 17, 6, -45) );
		addComplexShape( new ZoneLabel(new Point(68, 110), "Garibaldi") );
		
		addComplexShape( new TransferZone(new Point(54, 152), 7, 4, -45) );
		addComplexShape( new ZoneLabel(new Point(52, 149), "Portese") );
		
		addComplexShape( new TransferZone(new Point(60, 158), 7, 7, -45) );
		addComplexShape( new ZoneLabel(new Point(56, 158), "Emporio") );
		
		addComplexShape( new TransferZone(new Point(155.5, 39.5), 6, 7, -45) );
		addComplexShape( new ZoneLabel(new Point(163, 40), "Porta Pia") );
		
		addComplexShape( new TransferZone(new Point(57, 51), 8, 10, 0) );
		addComplexShape( new ZoneLabel(new Point(62, 46), "Ponte Umberto") );
		
		addComplexShape( new TransferZone(new Point(55, 72), 9, 5, -45) );
		addComplexShape( new ZoneLabel(new Point(55, 72), "S. Pantaleo") );
		
		addComplexShape( new TransferZone(new Point(130, 98), 5, 7, -45) );
		addComplexShape( new ZoneLabel(new Point(130, 102), "Cavour") );
		
		addComplexShape( new TransferZone(new Point(152, 126), 6, 4, 0) );
		addComplexShape( new ZoneLabel(new Point(153, 124), "Manzoni") );
		
		addComplexShape( new TransferZone(new Point(158, 61), 6, 6, -45) );
		addComplexShape( new ZoneLabel(new Point(153, 58), "Indipendenza") );
		
		addComplexShape( new ZoneLabel(new Point(114, 46), "Spagna") );
		
		
		addComplexShape( new PlaceLabel(new Point( 31,  41), 90, "Piazza Pia") );
		addComplexShape( new PlaceLabel(new Point( 24, 128), 90, "Carini") );
		addComplexShape( new PlaceLabel(new Point(4.5,  74), 90, "Gallo	") );
		
		
		addComplexShape( new AreaLabel(new Point(130,  20), "Borghese") );
		addComplexShape( new AreaLabel(new Point( 15,  37), "Vaticano") );
		addComplexShape( new AreaLabel(new Point(108, 118), "Foro") );
		addComplexShape( new AreaLabel(new Point(108, 128), "Platino") );
		
		
		addComplexShape( new TrademarkLabel(new Point(190, 157), "© Josbert Lonnee, 2018") );
	}
}

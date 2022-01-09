package com.ya.skidtavling.competitions;

import java.util.*;

public class HandleIncidents {

	public static Incidents Startins(Incidents ins, Competitions tavl) {
		// TODO Auto-generated method stub

//	System.out.println("nu main testaincidents");

		String srcepath = "incidents.txt";
		String[] incidents = Filio.readfiledatatoString(srcepath);
		int rowant = incidents.length;

		/*
		 * kalkylera hur ofta som anrop skall leda till incident fr�n deltagarantal och
		 * sp�rl�ngd, som p�verkar utfallet av naturliga sk�l. empirisk metod helt utan
		 * vetenskaplig grund.
		 * 
		 */

		int work = tavl.getNbrStart() * tavl.getSparLangd();
		ins.setAntIncidentFall(rowant);
		ins.setAnropsCnt(0);
		ins.setInsidentAntal(0);
		ins.setAnropsIntervall(work / 25);// testansats

		return ins;
	}

	public static Incidents CheckInsident(Incidents ins) {
		int wrk;
		int cntanrop = ins.getAnropsCnt();
		cntanrop++;
		;

//		System.out.println("CHeck" +cntanrop);
		ins.setAnropsCnt(cntanrop);
		/*
		 * f�rsta check ca 10 incidenter under loppet
		 */
		if (cntanrop == ins.getAnropsIntervall()) {
			ins = determineincidenttyp(ins);
			ins.setAnropsCnt(0); // nollst�ll r�knare

		}
		wrk = ins.getTotalanropscnt();
		wrk++;
		ins.setTotalanropscnt(wrk);

		return ins;
	}

	private static Incidents determineincidenttyp(Incidents ins) {
		/*
		 * F�r vart anrop; incident har h�nt skapa en struktur utifr�n
		 * konffigurationsfilen f�r att ta reda p� vilken typ av incident som intr�ffat.
		 */
		int wrk = ins.getInsidentAntal();
		wrk++;
		ins.setInsidentAntal(wrk);

		int typ;
//		System.out.println("kalkylerar olyckstyp");

		String srcepath = "incidents.txt";
		String[] incidents = Filio.readfiledatatoString(srcepath);
		String[] items = new String[7];
		int rowant = incidents.length;
//		System.out.println(rowant);
		String[] incText = new String[rowant]; // textbeskrivning
		int[] incKonskod = new int[rowant];
		int[] incProkod = new int[rowant];
		boolean[] incComp = new boolean[rowant];
//		for (int i =0; i<rowant; i++)
//		{
//			System.out.println(incidents[i]);
//		}
		// plocka s�nder konf data till resp. arrayer
		for (int i = 0; i < rowant; i++) {
			items = incidents[i].split(";");
			incText[i] = items[1];
			incKonskod[i] = itemtoint(items[2]);
			incComp[i] = itemtobool(items[3]);
			incProkod[i] = itemtoint(items[4]);
		}

		int utfallskod = getutfall();
		/*
		 * uppdatera incidenten som skall returneras
		 */

		// ins.insidentAntal++;
		ins.setInsidentKod(utfallskod);
		int kod = incKonskod[utfallskod];
		ins.setKonsekvensKod(kod);
		ins.setInsidentBeskrivning(incText[utfallskod]);
		ins.setTavlingsrelated(incComp[utfallskod]);

//		System.out.println( ins.toString(2));
		// TODO Auto-generated method stub
		ins.setIsnewIncident(true);
		return ins;

	}

	private static int getutfall() {
		/*
		 * variabel sannolikhet fr�n h� till mycket l�g denna funktion klarar inte av
		 * flera typer med samma sannolikhet styrfilen skapas med ett windowsprogram
		 * somkan h�mtas h�r: https://www.skidstadion.se/Grupp3A/accidents.exe
		 * funktionen �r upa, men generar h�ndelser och dessa kan avl�sas som avbrutna
		 * lopp och i loggffile.
		 */

		Random randomno = new Random();
		int rand = randomno.nextInt(1000);
		int gr = 0;
		{
			if (rand < 710)
				return 0;
			if (rand < 874)
				return 1;
			if (rand < 953)
				return 2;
			if (rand < 991)
				return 3;
			if (rand < 997)
				return 4;
			else
				return 5;
		}

	}

	private static boolean itemtobool(String exp) {

		String bool = exp.toLowerCase();
		bool = bool.trim();
//		System.out.println(bool.trim());
		if (bool.equals("true"))
			return true;
		else
			return false;
	}

	private static int itemtoint(String exp) {
		/*
		 * omvandlar textstr�ng integer till till integer v�rde
		 */

		int tal;
		try {
			tal = Integer.parseInt(exp.trim());
		} catch (Exception f) {
			System.out.println("Formatfel vid l�sning av konfiguration incidenter");
			tal = 0;
		}
		// TODO Auto-generated method stub
		return tal;
	}

}

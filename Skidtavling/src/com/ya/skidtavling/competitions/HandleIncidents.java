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
		 * kalkylera hur ofta som anrop skall leda till incident från deltagarantal och
		 * spårlängd, som påverkar utfallet av naturliga skäl. empirisk metod helt utan
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
		 * första check ca 10 incidenter under loppet
		 */
		if (cntanrop == ins.getAnropsIntervall()) {
			ins = determineincidenttyp(ins);
			ins.setAnropsCnt(0); // nollställ räknare

		}
		wrk = ins.getTotalanropscnt();
		wrk++;
		ins.setTotalanropscnt(wrk);

		return ins;
	}

	private static Incidents determineincidenttyp(Incidents ins) {
		/*
		 * För vart anrop; incident har hänt skapa en struktur utifrån
		 * konffigurationsfilen för att ta reda på vilken typ av incident som inträffat.
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
		// plocka sönder konf data till resp. arrayer
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
		 * variabel sannolikhet från hö till mycket låg denna funktion klarar inte av
		 * flera typer med samma sannolikhet styrfilen skapas med ett windowsprogram
		 * somkan hämtas här: https://www.skidstadion.se/Grupp3A/accidents.exe
		 * funktionen är upa, men generar händelser och dessa kan avläsas som avbrutna
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
		 * omvandlar textsträng integer till till integer värde
		 */

		int tal;
		try {
			tal = Integer.parseInt(exp.trim());
		} catch (Exception f) {
			System.out.println("Formatfel vid läsning av konfiguration incidenter");
			tal = 0;
		}
		// TODO Auto-generated method stub
		return tal;
	}

}

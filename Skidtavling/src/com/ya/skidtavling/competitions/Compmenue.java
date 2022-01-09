package com.ya.skidtavling.competitions;

//Compmenue.java
import java.text.ParseException;
import com.ya.skidtavling.menu.Menu;
import com.ya.skidtavling.menu.PrintMenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import com.ya.skidtavling.*;

public class Compmenue {
	/*
	 * Hanterar menyfunktionen submenu samt härbergerar enklare funktioner
	 * 
	 */
	
	public static void Compmain(Competitions tavl1)  {
		// TODO Auto-generated method stub	
		Competitions tavl;
		Incidents ins;
		
	//	Competitions tavl1 = new Competitions();
		//incidentsklassen skapas här och instansen heter ins1
		Incidents ins1 = new Incidents();
		tavl = tavl1;
		ins1.setForvantatAntalanrop(10025);//start antagande för olyckssimulering.
		ins = ins1;
	
			int funktionsval = 0;
			float result;
			int input = -1;
			boolean doRunmenue = true;
			String textinput= "";
		
			while(doRunmenue)
			{
			
			visameny();
			
			funktionsval =dofunctionchoice();
			System.out.println(funktionsval);
			if (funktionsval == 0)
			doRunmenue = false;
			
			ins =  branchval(funktionsval, tavl, ins);
			
			}
			
	}
	private static void visameny() 
	{
	PrintMenu.SubMenu();
	return;
	}
	
//	// TODO Auto-generated method stub
	//uppdaterad information.
//	System.out.println("\t\tMENY välj funktion en av nedanstående ange nummer");
//	System.out.println("\t\t0. Tillbaks Huvudmeny");
//	System.out.println("\t\t1.Ny tävling");
//	System.out.println("\t\t2.Lista Tävlingsdata");
//	System.out.println("\t\t3.Spara Tävling på disk ...");
//	System.out.println("\t\t4.Öppna tävlingsdata från fil..");
//	System.out.println("\t\t5.Lägga  första starttid");
//	System.out.println("\t\t6.Ändra deltagarantal");
//	System.out.println("\t\t7.Lista loggfil på konsolen");
//	System.out.println("\t\t8.Nollställ Loggfil");
//	System.out.println("\t\t9.Flytta mätpunkt mellantider");
//	System.out.println("\t\t10.Ändra Spårlängd");
//	System.out.println("\t\t11.Ändra Startmetod");
//	System.out.println("\t\t12.Visa Meny");
//
//	return;
//	



	private static Incidents branchval(int funktionsval, Competitions tavl, Incidents ins) {
		
	
		float result= 0f;
		System.out.println("menyvalet: "+funktionsval);
//		result arbiträrt returvärde används fn inte.
		
		switch (funktionsval)
		{
		
		case 0: break;
		case 1:	etta(tavl); break;
		case 2:	result = tvaa(tavl);break;
		case 3:	result = trea(tavl);break;
		case 4:	result = fyra(tavl);break;
		case 5:	result = fem(tavl);break;
		case 6:	result = sex(tavl);break;
		case 7:	sju(tavl);break;
		case 8: result = atta(tavl);break;
		case 9: result = nia(tavl);break;
		case 10:result = tia(tavl);break;
		case 11:result = elva(tavl);break;
		case 12:	visameny();break;
			
		}

		return ins; 
	}
	/*
	 * Ändra startmetod;
	 * framförallt för test. observera att deltagarlistan måste läsas in på nytt.	
	 */


	private static float elva(Competitions tavl) {
		int win = tavl.getStartmetod();
		System.out.println("Nuvarande startmetod är: "+ win);
		System.out.println("Val av startmetod se nedan...");
		System.out.println("masstart = alla startar samtidigt kod 1");
		System.out.println("individuell start,med visst intervalltex 30 sek kod 3");
		System.out.println("inga andra koder fungerar....");
		win =  Input.inputInt("Ange kod för startmetod 1-4 + 'enter' ", 1, 3);
		tavl.setStartmetod(win);
		System.out.println("klart ändrat.");
	return 0f;
}
	private static float nolla(Competitions tavl)  {
	
		
//		menu2.runMenu(tavl);
		
		return 0f;
	}
	/*
	 * Ändra spårlängd i simuleringen, påverkar olycksrisken och åktider;
	 * framförallt för test. observera att deltagarlistan måste läsas in på nytt.	
	 */	
		
	private static float tia(Competitions tavl) {
		int langd = tavl.getSparLangd(); //längd i 10-tal meter;
		langd = langd*10;
		int nytt =0;
		System.out.println("Nuvarande längd i meter	: " + langd);
		System.out.println("Ändra längd till meter - avrundas  ...");
		nytt = Input.inputInt("ny längd i meter 0..35000 ",0,350000);
		tavl.setSparLangd((nytt/10));
		tavl.setSenUppd();
		// TODO Auto-generated method stub
		System.out.println("Utfört.  gäller från nästa tävling .. glöm inte spara..");
		return 0;
		
	}	
	/*
	 * Ändra placering av mätpunkt för mellantid i simuleringen, påverkar tidtagning mellantider;
	 * framförallt för test. observera att tävlingen måste tas om.	
	 */	

	private static float nia(Competitions tavl) {
		int proc = tavl.getPlaceMellantid();
		int nytt =0;
		System.out.println("Nuvarande placering % av tävl längd: " + proc);
		System.out.println("Ändra antalet procenta..");
		nytt = Input.inputInt("ny placering: 0..100 ",0,100);
		tavl.setPlaceMellantid(nytt);
		tavl.setSenUppd();
		// TODO Auto-generated method stub
		System.out.println("Utfört.  gäller från nästa tävling .. glöm inte spara..");
		return 0;
		
	}
	
	/*
	 * skriver endof file i pos 0.Filen finns kvar.	
	 */	
	
	
	private static float atta(Competitions tavl) {
		boolean isOK=Input.inputBool("Nollställa loggfil - är Du säker ?");
		if (isOK)
		 isOK = Wlogg.nollalogglist();
		
		return 0;
	}
	/*
	 * skriver loggfil på konsolen + lista somtextfil.	
	 */	

	private static void sju(Competitions tavl) {
		System.out.println("Utfört klart...");
		LoggShow.showlogglista();
		System.out.println("Utfört klart...");
		return;
	}


	private static float sex(Competitions tavl) {
		int ant = tavl.getFixedStartnbr();
		int nytt =0;
		System.out.println("Antalet anälda deltagare är: " + ant);
		System.out.println("Ändra antalet anmälda..");
		nytt = Input.inputInt("nytt antal anmälda:",0, (ant+25));
		tavl.setFixedStartnbr(nytt);
		tavl.setSenUppd();
		System.out.println("Utfört klart...");
		return 0;
	}


	private static float fem(Competitions tavl) {
		System.out.println("Ändra preliminärt stardatum till definitivt..");
		long wlong = Input.inputDatum("Ange Nytt tävlingsdatum: ");
		tavl.setForstaStartVerklig(wlong);
		tavl.setSenUppd();
		System.out.println("Utfört klart...");
		return 0;
	}


	private static float fyra(Competitions tavl)  {
		boolean isOK;
		boolean cont = Input.inputBool("läsa in från fil, skriva över befintlig ");
				if (!cont)
					return 0;
				if (cont)
				{
					 isOK = getfromdisk(tavl);
				if(!isOK)
				{
					System.out.println("Misslyckades...");	
					return -1f;
				}
				
					
		// TODO Auto-generated method stub
				tavl.setStatuskod(1);
		System.out.println("Utfört klart...");
		return 0f;
	    }
				return 0f;
	}



	private static float trea(Competitions tavl)  {
		// TODO Auto-generated method stub
		float success = 0;
		boolean isOK = savetodisk(tavl);
		System.out.println("Utfört klart...");
		return 0;
	}

	public static boolean savetodisk(Competitions tavl) {
		boolean isOK;
	 isOK= CompetionsInput.savetodisk(tavl);
	return true;
	}
	
	

	private static boolean getfromdisk(Competitions tavl) {
		
		LoadCompetition.getfromdisk(tavl);
		
		return true;
		
	
		
	}
		
	/*
	 * visar all data för tävling både förenklade och utvigade
	 * delar upp visningen på två sidor och förväntar si enter för nästa sida
	 * 
	 */
	private static float tvaa(Competitions tavl) {
		int raderpervy =10;
		int radcount =0;
		if (tavl.toString() == null)
		{
			System.out.println("Finns inget att visa..");
			return 0;
		}
		System.out.println("Tävlingsnamn:  " + tavl.getTavlingsnamn());
		System.out.println("Krav på förhandsanmälan  " + tavl.isForHandsanmalanKrav());
		System.out.println("sista_anmalningsdatum:  " + tavl.getSistaAnmalningsdatum());
		System.out.println(" Startmetod:  " + tavl.getStartmetod());
		System.out.println("Antalet anmälda startande " + tavl.getFixedStartnbr());
		System.out.println("Maximalt Antalstartande=.." + tavl.getMaxAntalstartande());
		System.out.println("Plannerad första start. " + tavl.getForstaStartPlanned());
		System.out.println("Verklig första start:  " +tavl.getForstaStartVerklig());
		System.out.println("StartIntervall.sekunder: " + tavl.getStartIntervall());
		System.out.println("Senast Uppdatering: "+ tavl.getSenUppd());
		
		boolean goon = Input.inputEnter("fortsätt visa mer...");
		
		System.out.println("ID-numrering");
		System.out.println("Nummerlappar för dekorering");
		System.out.println("Lägsta nummer för startande " + tavl.getNbrStart());
		System.out.println("Högsta nummer för startande " + tavl.getNbrSlut());
		System.out.println("Test o utvärdering");
		System.out.println("Banlängd i 10-tal meter: "+ tavl.getSparLangd());
		System.out.println("Mellantidtagning i % av banl räknat från start: "+ tavl.getPlaceMellantid());

	
		
		goon = Input.inputEnter("till menyn klar...");
		return 0;
	}




	private static int dofunctionchoice() {		
		int fv = 0; // aktuellt funktionsval definieras av menyfunktionen.
		
			String sv = "";
			int val= 0;
			int menyMax =12;
				
				{

					val = Input.inputInt("ange  ditt menyval",0,12);	
				}
				return val;
	}
	


		private static void etta(Competitions tavl){
			
		boolean isOK = Input.inputBool("förenklad registrering J/ N");
		
		if (!isOK)
		{
		CompetionsInput.extendeddata(tavl);
		return ;
		}
		
		if (isOK)
		{

		String wrk = "";
		String prmt = "";
		int win = 0;
		float wflot = 0f;
		long wlong = 0;
		Boolean wbool = false;
		//raderaKonsole(5);
		System.out.println("Ange de uppräknade egenskaperna för aktuell tävling");
		Competitions tavl1 = new Competitions();
		
		wrk =  Input.inputString("Ange tävlingens namn", false, 0);

		tavl.setTavlingsnamn(wrk);
		tavl.setForHandsanmalanKrav(false);
  		tavl.setSistaAnmalningsdatum(0);	
		tavl.setSimTidtagning(true);
				
		win = Input.inputInt("Ange spårlängd i kilometer", 1,250);
		tavl.setSparLangd(win*100);
		
		win = Input.inputInt("Mellantidstagning i hela  procent av banlängd räknat från start tex 50 mittpunkt", 1,100);
		tavl.setPlaceMellantid(win);
		System.out.println("Val av startmetod se nedan...");
		System.out.println("masstart = alla startar samtidigt kod 1");
		System.out.println("individuell start,med visst intervalltex 30 sek kod 3");
		System.out.println("inga andra koder fungerar....");
		win =  Input.inputInt("Ange kod för startmetod 1-4 se manualen !!", 1, 3);
		tavl.setStartmetod(win);
		tavl.setFixedStartnbr(200);
		tavl.setNbrStart(1);
		tavl.setNbrSlut(250);
		System.out.println("Startintervall 10 - 120 sekunder"); 
		win =  Input.inputInt("Startintervall i sekunder!", 10, 125);
		tavl.setStartIntervall(win);
		tavl.setMaxAntalstartande(300);
		
		tavl.setSenUppd();
		tavl.setStatuskod(1);
		//System.out.println(tavl.toString());
		
		System.out.println("Utfört klart...");
		return ;
		}

	}

	private static int getint(String param) {
		int x;

		param = param.trim();

		try {
			x = Integer.parseInt(param);
		} catch (Exception f) {
			System.out.println("formatfel i fildata");
			x = 0;
		}

		return x;
	}
					
}

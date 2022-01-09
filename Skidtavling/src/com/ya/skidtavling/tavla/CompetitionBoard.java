package com.ya.skidtavling.tavla;

import java.util.*;

import com.ya.skidtavling.competitions.Competitions;
import com.ya.skidtavling.competitions.Filio;
import com.ya.skidtavling.participants.Participants;
import com.ya.skidtavling.time.Time;

public class CompetitionBoard {

	Random rand = new Random();
	public static List<Participants> participantsList = new ArrayList<>();
	public List<Participants> resultBoard = new ArrayList<>();
	public List<Participants> midTimeList = new ArrayList<>();
	public List<Participants> expelledpartList = new ArrayList<>();
	public List<Participants> startoderindstartList = new ArrayList<>();
	
// tilldela tiden mer efter ett klockslag och inte en random. för att göra det helt verkligare.
	public void startingTime(Competitions tavl1) {// hur fungerar detta ????
		
		int startmetod = tavl1.getStartmetod(); // avgör sortering och innehåll
		long max = 500;
		
		
		long min = 100;
		long twoPm = 50400;// kl är 1400.
		long midnight =0 ; //kl 00.00 
//		for (Participants p : participantsList) {
//			long longSetTime = rand.nextLong() % (max - min) + max;
//			Time newTime = new Time(longSetTime);
//			p.setStartTime(newTime);
//		}  // Startlista preparation
		for(Participants p:participantsList) {
			
			p.setStartTime(0);
			p.setPlace(0);
			//p.setIndivStarTime(startTime);
			
		}
		if (startmetod== 3)//individuell start Sorteraom genom att skapa ny list
		{
		 int itemcnt = participantsList.size();
		 int index = 0;
		 String[] rows = new String[itemcnt+1];
;		 int iterator = 0;
		 String line="";
		 Participants p;
		 startoderindstartList.clear();
		 for(int ordernbr = 0; ordernbr < itemcnt; ordernbr++)
		 {
			 p = getitemfromlist(ordernbr,itemcnt);
			startoderindstartList.add(p);
		 }
//		 	System.out.println(p);
//			
//			for (Participants s : startoderindstartList) {
//				System.out.println(s);
//			}
//			boolean isOK;
		 
		 
		 
		 
		 
		 	rows[0] = "STARTLISTA INDIVIDUELL START. TIDER";
		 	System.out.println(rows[0]);
			Participants t;
			for (int k=1; k < itemcnt; k++) {
			t = startoderindstartList.get(k);
			if (t== null)
				System.out.println(k);
			rows[k] =toStartstring(t);
//			System.out.prtintln(rows[k]);
//			rows[k]= Participants.toStartstring(t);
			System.out.println(rows[k]);
//			rows[k] =toStartstring(t);
//			 System.out.println("skapar rader" + k);
//					
		 }	
		   System.out.println("skriver till fil Startlista.txt " + itemcnt  + "rader");
			Filio.writeText(rows, "Startlista.text", itemcnt+1, false);		
		 }
	
	else
	{			
	if (startmetod== 1)//masstar lista startande med endast namn och nummer.
		
	{
	 int itemcnt = participantsList.size();
	 int index = 0;
	 String[] rows = new String[itemcnt+1];
;		 int iterator = 0;
	 String line="";
	 Participants p;
	 	
 	 	rows[0] = "STARTLISTA MASSTART ANÄLDA DELTAGARE MED STARTANDE NUMMER";
	 	System.out.println(rows[0]);
		Participants t;
		for (int k=1; k < itemcnt; k++) {
		t = participantsList.get(k);
		if (t!= null)
		rows[k] =toStartstring1(t);
		
//		System.out.prtintln(rows[k]);
//		rows[k]= Participants.toStartstring(t);
		System.out.println(rows[k]);
//		rows[k] =toStartstring(t);
//		 System.out.println("skapar rader" + k);
//				
	 }	
	   System.out.println("skriver till fil Startandelista.txt också för printad utskrift " + itemcnt  + " rader");
		Filio.writeText(rows, "Startandelista.txt", itemcnt+1, false);		
		}
	}
		return;
}
//		
/* Listan av deltagare sorteras om genom att ändra ordningen på listan så att den motsvarar
 * resultatet av lottningen, en efter en hämtas namnen här i den nya ordningen och läggs i
 * den nya listan					
 */
	
	private Participants getitemfromlist(int ordernbr, int itemcnt) {
		Participants p = null;
		Participants p1 = null;
		int pnr=0;
		for (int i = 0; i < itemcnt; i++)//FOREACH DEBUGGLÄGE
		{	
			p1 = participantsList.get(i);

			pnr = p1.getParticipantNumber();
	//		System.out.println("onr" + ordernbr+"pnr " + pnr+ " i " +i);
			if (pnr == ordernbr) {
			p=p1;
			break;
			}
		}
//		System.out.println("hit  onr" + ordernbr+ p);
			return p;
		}


public String toStartstring(Participants s)
{
	
String test = s.getParticipantNumber() + s.getForName().trim() + s.getLastName().trim();
int langd = test.length();

String sp= " ";
String tab = "";
String marg ="    ";
		
for  (int i=0; i<30-langd; i++)
tab = tab + sp;

//if (langd < 10)  
	return marg+s.getParticipantNumber() + " " +s.getForName().trim() + " " + s.getLastName().trim() + tab+  s.getIndivStarTime(); 

}



public String toStartstring1(Participants s)
{
	
String test = s.getParticipantNumber() + s.getForName().trim() + s.getLastName().trim();
int langd = test.length();

String sp= " ";
String tab = "";
String marg ="    ";
		
for  (int i=0; i<30-langd; i++)
tab = tab + sp;

//if (langd < 10)  
	return marg+s.getParticipantNumber() + " " +s.getForName().trim() + " " + s.getLastName().trim() + tab+  s.getIndivStarTime(); 

}


public String toResultstring(Participants s)
{
	
String test = "Placering: "+ s.getPlace() +"   Startnr "+s.getParticipantNumber() + s.getForName().trim() + s.getLastName().trim();
int langd = test.length();

String sp= " ";
String tab = "";
String marg ="    ";
		
for  (int i=0; i<50-langd; i++)
tab = tab + sp;
int korTid = s.getStartTime();
int mellanTid = s.getMiddleTime();
int placering = s.getPlace();

String skorTid = textavtid(korTid);
String smellanTid = textavtid(mellanTid);

//if (langd < 10)  

	return "Placering: "+ placering +"   Startnr "+s.getParticipantNumber() + "   " +s.getForName().trim() + " " + s.getLastName().trim() + tab + "Åktid: " + skorTid + "\t  mellantid: "+ smellanTid; 

}

	private static String textavtid(int starttid) {
	
		int temp=0;
		int hour =0;
		int min =0;
		int secu = 0;
		temp = starttid;
		hour =0;

		hour = temp/3600;
		temp = temp-hour*3600;
		min = temp/60;
		temp = temp-min*60;
		secu = temp;
		String tidstrang =  (" "+ hour + " : " + min +" : " + secu);
		return tidstrang;
		
	}	
	

// Dessa tre kanske kan göras om till egna klasser. 
	public void printParticipantsBoard(Competitions tavl1) {
		if (tavl1.getStartmetod()== 3)
			return;
		
		for (Participants s : participantsList) {
			System.out.println(s);
		}
	}
	public void printExpelledlist() {

		for (Participants s : expelledpartList) {
			System.out.println(s);
		}
	}	
/*
 * Skriv ut resultatlista på samma sätt som ovanstående med innehåll
 * startnummer, placering,mellantid..	
 */
	public void printResultBoard(Competitions tavl1) {
		
	{
		String namn = tavl1.getTavlingsnamn();
		namn = namn.toUpperCase();
	 int itemcnt = resultBoard.size();
	 int index = 0;
	 String[] rows = new String[itemcnt+1];
;		 int iterator = 0;
	 String line="";
	 Participants p;
	 	
 	 	rows[0] = "RESULTATLISTA TÄVLING  " + namn;
	 	System.out.println(rows[0]);
		Participants t;
		for (int k=0; k < itemcnt; k++) {
		t = resultBoard.get(k);
		if (t!= null)
		rows[k] =toResultstring(t);
		
//		System.out.prtintln(rows[k]);
//		rows[k]= Participants.toStartstring(t);
		System.out.println(rows[k]);
//		rows[k] =toStartstring(t);
//		 System.out.println("skapar rader" + k);
//				
	    }	
	   System.out.println("skriver till fil Resultatlista.txt också för printad utskrift ");
		Filio.writeText(rows, "Resultatlista.txt", itemcnt+1, false);		
		}
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	//ett försök till vinnar upvissning . . .. // fungerar 
	public void printWinnerBoard()
	{
		try
		{
		String firstPlaced = resultBoard.get(0).getForName()+" "+resultBoard.get(0).getLastName();
		String secondPlaced = resultBoard.get(1).getForName()+" "+resultBoard.get(1).getLastName();
		String thirdPlaced =resultBoard.get(2).getForName()+" "+resultBoard.get(2).getLastName();
		System.out.print("\n\t"+firstPlaced+"\n\t    1#\n"+secondPlaced +"\t"+thirdPlaced+"\n\t#2\t    #3\n");
		}
		catch (Exception e)
		{
			System.out.print("Finns inga eller för få vinnare...");
			return ;
		}
		
//		System.out.print("\n\t"+firstPlaced+"\n\t    1#\n"+secondPlaced +"\t"+thirdPlaced+"\n\t#2\t    #3\n");
		
	}
	
	
	
	
	
	
}
// göra om till en egen klass ha som objekt någon annanstans / detta är nu gjort 
	
//	public void race() {
//		boolean raceOn = true;
//		long plusSec = 15;
//		
//		do {
//
//			for (Participants p : participantsList) {
//
//				if (!p.isNotFinished()) {
//					p.setDistance(p.getDistance() + rand.nextInt(5));
//					/*Idé 'är att vi skall använda randen för att generera fram en tid som blir kopplad 
//					 * till tid
//					 * */
//					p.startTime.setSec(p.startTime.getSec()+plusSec);// man måste ta class metoderna så fungera det :) 
//					System.out.println(p.toString());
//					//Här måste tittas över 
//					if (!p.isPassedMiddle() && p.getDistance()>=50) {
//						if(!p.isPassedMiddle() && p.getDistance()<=55) {
//							
//							System.out.println("midList Update-----------------------------------------");
//							midTimeList.add(p);
//							p.setPassedMiddle(true);
//						}else break;
//			
//					}else if(p.isPassedMiddle() && p.getDistance()>50) {
//						System.out.println(" ----");}
//					
//					if (p.getDistance() >= 100) {
//						System.out.println("\n  " + p.getForName() + " " + p.getLastName() + " Har Gått i mål");
//
//						p.setDistance(p.getDistance());
//						resultBoard.add(p);
//						p.setNotFinished(true);
//
//					}
//				
//					if (p.isNotFinished()) {
//						for (Participants p1 : participantsList) {
//							if (p1.isNotFinished()) {
//								raceOn = false;
//							} else
//								raceOn = true;
//						}
//					}
//				}
//			}
//
//		} while (raceOn);
////	}
//
//}

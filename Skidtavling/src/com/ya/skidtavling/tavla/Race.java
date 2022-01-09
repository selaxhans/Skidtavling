package com.ya.skidtavling.tavla;

import java.util.Random;
import com.ya.skidtavling.competitions.*;

import com.ya.skidtavling.participants.Participants;

public class Race {// Flyttad till egen klass för att snygga till det hela 
	
	Random rand = new Random();
	/*
	 * Obs partisipant.Not Finished avser inverterat värde; true är i mål
	 * och false har inte kommit i mål; lätt att missförstå....
	 */
	public void race(CompetitionBoard compBoard,Competitions tvlx) {// tar listan som Parameter
		boolean raceOn = true;     // någon i spåret fortfarande loppet igång 
		int plusSec = 15;// lägger på 15 sekunder för alla varje varv
		 int raknavarv= 0;
		 int currentvarvcnt = 0;
			int antdiskade =0;
		int speed = 6;
		int placering =1;
		Incidents ins;
		ins = tvlx.getIns();
		ins = HandleIncidents.Startins(ins,tvlx); // initiera händelsegeneratorn
		
		// Set upp tävlingskörning; lopplängd, mellantid,väntetid
		int sl = tvlx.getSparLangd();
		int pmt = tvlx.getPlaceMellantid();
		int mt = sl*pmt/100;
		int vanta= tvlx.getNbrSlut()* 10;
		
		boolean isOK;
		//skriv loggpost tävlinsstart;
		
		isOK=Wlogg.nyevent(1,"start_tavling",5,"längd:"+ sl/100 + " km mellantid: " + mt/100 );
//		System.out.println("start_tavling längd:"+ sl/100 + " km mellantid: " + mt/100 );
		
//		public  boolean nyevent(int eventkod, String eventdescr,
//				int eventsrce, String eventobj)		
		
		
		 Participants expelledpartlist;
		
		/*
		 * säkra att utgångspunkten för start är ingen i mål ännu vid tex omstart.
		 */
	
		for (Participants p1 : compBoard.participantsList) {
			p1.setNotFinished(false);
			p1.setDistance(0);
			p1.setExpelled(false);
//			p1.setIndivStarTime(0);
//			p1.setMiddletime(0);
		}
		
		do {

			for (Participants p : compBoard.participantsList) {// ställer upp listan

				if ((!p.isNotFinished())&&(!p.isExpelled())) {
					p.setDistance(p.getDistance() + rand.nextInt(speed));
					if (speed !=6) {
//						System.out.println("1 ändrad hastighet: " + speed);
						raknavarv++;
						if (raknavarv> vanta)
						{
						raknavarv =0;
						speed = 6;
						}
						
					}
				//	System.out.println("1 " +p.getDistance());
					/*Idé 'är att vi skall använda randen för att generera fram en tid som blir kopplad 
					 * till tid
					 * Genom att öka spårlängden från 100 till tusen erhålles preciare tider för målgång mm.
					 * tiden räknas upp från starttiden.
					 * */
					/* Ide2, vid varje uppdatering körs en incidentcheck, som avgör om någon
					 * incident (med ganska liten sannolikhet) har intäffat, om så är fallet
					 * medför de någon av de tänkbara konsekvenserna, Förekomster och sannolikhet beskrivs i en
					 * konfigureringsfil incidents.text, som innehåller sannolikhetskoder, konsekvenser och
					 * beskrivning. Filen skapas i ett separat program. 
					 */
				//	System.out.println("anropar incidents" + ins.getAnropsIntervall() + raknaanrop++ );
					ins = HandleIncidents.CheckInsident(ins);
					if (ins.isIsnewIncident()) {
//						System.out.println(ins.getInsidentBeskrivning() +"Kons: "+ ins.getKonsekvensKod());
						 isOK = Wlogg.nyevent(1,ins.getInsidentBeskrivning()+ "  " + ins.getInsidentKod(),5,p.getForName() +" "+ p.getLastName()+ " incident");
						 speed = konsekvenshandler(p,ins.getKonsekvensKod(),speed);
						 if (p.isExpelled())
						 { 
							 p.setExpelled(true);
							 p.setDistance(0);
							 p.setNotFinished(true);
							 compBoard.expelledpartList.add(p);
//							 compBoard.participantsList.remove(p);
							 antdiskade++;
						 }
						 
						ins.setIsnewIncident(false);
					}
					
					
					
					
					
					
					
					
					p.setStartTime(p. getStartTime()+plusSec);// man måste ta class metoderna så fungera det :) 
//					System.out.println(p.toString());
					//Här måste tittas över
					//Mellantiden kan tas vid olika delsträckor genom att variera konstanten..
					if (!p.isPassedMiddle() && p.getDistance()>=mt) {
						p.setPassedMiddle(true);// true innebär passerad kontroll. Uppdateringen måste ske före kopieringen till mellantidslistan
						midListUpdate(p,compBoard);// ny metod som gör jobbet 
						
						
						
						
//						problemet inträffar inte då skillnaden mellan varven alltid är mindre, varför ingen 
//						osäkerhet uppstår.
//						compBoard.midTimeList.add(p);
//						
//						
//						if(!p.isPassedMiddle() && p.getDistance()<=510) {// vet inte om detta gör så mkt längre
//							
//							System.out.println("midList Update-----------------------------------------");
//							p.setPassedMiddle(true);
//							midListUpdate(p,compBoard);// ny metod som gör jobbet 
////							compBoard.midTimeList.add(p);
						
						}
						
//					}else if(p.isPassedMiddle() && p.getDistance()>500) {
//						System.out.println(" ----");}
//					//tidtagning vid målgång....					
					
					if (p.getDistance() >= sl) {
//						}
//						p.setDistance(p.getDistance());
						p.setNotFinished(true);
						p.setPlace(placering);
						placering++;
						compBoard.resultBoard.add(p);
						 isOK = Wlogg.nyevent(1,"Målgång",5,p.getForName() +" "+ p.getLastName());
//						p.setNotFinished(false);

					}
					// den här behöver ses över en del gånger kommer de alla fram andra inte .... 
					if (p.isNotFinished()== true) {// kollar om någon inte kommit till mål än 
						// ansatts:alla har  gått i mål....
						raceOn = false;
//						System.out.println("2 "+ p.isNotFinished());
						/*har någon åkare inte kommit i mål, kan inte loppet avslutas
						 * kontroll genom att kolla alla tävlandende en efter en.
						 */
						for (Participants p1 : compBoard.participantsList) {
							if (p1.isNotFinished() == false) {
								raceOn = true;
					
//								System.out.println("3 "+ p.isNotFinished());	
							} 
						}
					}
				}
			}

		} while (raceOn);
		System.out.println("Tävlingen avslutad - Alla tävlande i mål-- Antal som har brutit tavlingen: "+ antdiskade);
	}
	
	
	
	
//	Kodförklaringar:
//		konsekvenskod		1->Tidstilägg; enskild åkare saktar ner
//							2->uteslutning ur tävlingen diskvalificerad
//							3->Sjukvård utgår ur tävlingen
//							4->kollektiv fartminskning berör samtliga tex snöyra
//							5->Stillastående en period av betydelse	
	
	
	private int konsekvenshandler(Participants p, int konsekvensKod,int hast) {
		// TODO Auto-generated method stub
		int pos = p.getDistance();
		switch (konsekvensKod)
		{
		
		case 0: pos = (pos - rand.nextInt(15));
		break;// tidsförlust, måttlig
		case 1:  pos = (pos - rand.nextInt(30));
		break;// tidsförlust större
		case 2:  p.setExpelled(true);break;
		case 3:	 p.setExpelled(true);break;
		case 4:	 hast = (hast -2)    ;break;		//bromsa alla
		case 5:	  hast = (hast-4);break; // bromsa alla hårt
		default:  pos = (pos - rand.nextInt(10));
		}
		p.setDistance(pos); //uppdatera position obs mellantider...
		if (hast < 1)
			hast = 2;
		
		return hast;
	}






	// verkar stämma med Hans Hypotés att det var en pekare som behövdes korrigera nu får vi ut mellantiden som det är tänkt 
	public void midListUpdate(Participants p,CompetitionBoard compBoard) {
		// gör en ny deltagare och copy n pastar Värderna för att sedan spara in dem i
		// Mid mellantidsListan 
//		System.out.println("2midlist " +p.getDistance());
		
		p.setMiddleTime(p.getStartTime());
		
		
//		System.out.println(p.getParticipantNumber()+ " " + p.getStartTime());
//		
//		
//		
//		
//		
////		Participants midListPar = new Participants(p.getParticipantNumber(),
//				p.getForName(),
//				p.getLastName(), 
//				p.getPlace(),
//				p.getStartTime(),
//				p.getIndivStarTime(),
//				p.getDistance(),
//				p.isNotFinished(),  
//				p.isPassedMiddle());
		compBoard.midTimeList.add(p);
		
		boolean isOK=Wlogg.nyevent(1,"Mellantid",5,p.getForName() +" "+ p.getLastName());
	

}
}

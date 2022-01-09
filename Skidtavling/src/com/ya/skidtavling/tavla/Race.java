package com.ya.skidtavling.tavla;

import java.util.Random;
import com.ya.skidtavling.competitions.*;

import com.ya.skidtavling.participants.Participants;

public class Race {// Flyttad till egen klass f�r att snygga till det hela 
	
	Random rand = new Random();
	/*
	 * Obs partisipant.Not Finished avser inverterat v�rde; true �r i m�l
	 * och false har inte kommit i m�l; l�tt att missf�rst�....
	 */
	public void race(CompetitionBoard compBoard,Competitions tvlx) {// tar listan som Parameter
		boolean raceOn = true;     // n�gon i sp�ret fortfarande loppet ig�ng 
		int plusSec = 15;// l�gger p� 15 sekunder f�r alla varje varv
		 int raknavarv= 0;
		 int currentvarvcnt = 0;
			int antdiskade =0;
		int speed = 6;
		int placering =1;
		Incidents ins;
		ins = tvlx.getIns();
		ins = HandleIncidents.Startins(ins,tvlx); // initiera h�ndelsegeneratorn
		
		// Set upp t�vlingsk�rning; loppl�ngd, mellantid,v�ntetid
		int sl = tvlx.getSparLangd();
		int pmt = tvlx.getPlaceMellantid();
		int mt = sl*pmt/100;
		int vanta= tvlx.getNbrSlut()* 10;
		
		boolean isOK;
		//skriv loggpost t�vlinsstart;
		
		isOK=Wlogg.nyevent(1,"start_tavling",5,"l�ngd:"+ sl/100 + " km mellantid: " + mt/100 );
//		System.out.println("start_tavling l�ngd:"+ sl/100 + " km mellantid: " + mt/100 );
		
//		public  boolean nyevent(int eventkod, String eventdescr,
//				int eventsrce, String eventobj)		
		
		
		 Participants expelledpartlist;
		
		/*
		 * s�kra att utg�ngspunkten f�r start �r ingen i m�l �nnu vid tex omstart.
		 */
	
		for (Participants p1 : compBoard.participantsList) {
			p1.setNotFinished(false);
			p1.setDistance(0);
			p1.setExpelled(false);
//			p1.setIndivStarTime(0);
//			p1.setMiddletime(0);
		}
		
		do {

			for (Participants p : compBoard.participantsList) {// st�ller upp listan

				if ((!p.isNotFinished())&&(!p.isExpelled())) {
					p.setDistance(p.getDistance() + rand.nextInt(speed));
					if (speed !=6) {
//						System.out.println("1 �ndrad hastighet: " + speed);
						raknavarv++;
						if (raknavarv> vanta)
						{
						raknavarv =0;
						speed = 6;
						}
						
					}
				//	System.out.println("1 " +p.getDistance());
					/*Id� '�r att vi skall anv�nda randen f�r att generera fram en tid som blir kopplad 
					 * till tid
					 * Genom att �ka sp�rl�ngden fr�n 100 till tusen erh�lles preciare tider f�r m�lg�ng mm.
					 * tiden r�knas upp fr�n starttiden.
					 * */
					/* Ide2, vid varje uppdatering k�rs en incidentcheck, som avg�r om n�gon
					 * incident (med ganska liten sannolikhet) har int�ffat, om s� �r fallet
					 * medf�r de n�gon av de t�nkbara konsekvenserna, F�rekomster och sannolikhet beskrivs i en
					 * konfigureringsfil incidents.text, som inneh�ller sannolikhetskoder, konsekvenser och
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
					
					
					
					
					
					
					
					
					p.setStartTime(p. getStartTime()+plusSec);// man m�ste ta class metoderna s� fungera det :) 
//					System.out.println(p.toString());
					//H�r m�ste tittas �ver
					//Mellantiden kan tas vid olika delstr�ckor genom att variera konstanten..
					if (!p.isPassedMiddle() && p.getDistance()>=mt) {
						p.setPassedMiddle(true);// true inneb�r passerad kontroll. Uppdateringen m�ste ske f�re kopieringen till mellantidslistan
						midListUpdate(p,compBoard);// ny metod som g�r jobbet 
						
						
						
						
//						problemet intr�ffar inte d� skillnaden mellan varven alltid �r mindre, varf�r ingen 
//						os�kerhet uppst�r.
//						compBoard.midTimeList.add(p);
//						
//						
//						if(!p.isPassedMiddle() && p.getDistance()<=510) {// vet inte om detta g�r s� mkt l�ngre
//							
//							System.out.println("midList Update-----------------------------------------");
//							p.setPassedMiddle(true);
//							midListUpdate(p,compBoard);// ny metod som g�r jobbet 
////							compBoard.midTimeList.add(p);
						
						}
						
//					}else if(p.isPassedMiddle() && p.getDistance()>500) {
//						System.out.println(" ----");}
//					//tidtagning vid m�lg�ng....					
					
					if (p.getDistance() >= sl) {
//						}
//						p.setDistance(p.getDistance());
						p.setNotFinished(true);
						p.setPlace(placering);
						placering++;
						compBoard.resultBoard.add(p);
						 isOK = Wlogg.nyevent(1,"M�lg�ng",5,p.getForName() +" "+ p.getLastName());
//						p.setNotFinished(false);

					}
					// den h�r beh�ver ses �ver en del g�nger kommer de alla fram andra inte .... 
					if (p.isNotFinished()== true) {// kollar om n�gon inte kommit till m�l �n 
						// ansatts:alla har  g�tt i m�l....
						raceOn = false;
//						System.out.println("2 "+ p.isNotFinished());
						/*har n�gon �kare inte kommit i m�l, kan inte loppet avslutas
						 * kontroll genom att kolla alla t�vlandende en efter en.
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
		System.out.println("T�vlingen avslutad - Alla t�vlande i m�l-- Antal som har brutit tavlingen: "+ antdiskade);
	}
	
	
	
	
//	Kodf�rklaringar:
//		konsekvenskod		1->Tidstil�gg; enskild �kare saktar ner
//							2->uteslutning ur t�vlingen diskvalificerad
//							3->Sjukv�rd utg�r ur t�vlingen
//							4->kollektiv fartminskning ber�r samtliga tex sn�yra
//							5->Stillast�ende en period av betydelse	
	
	
	private int konsekvenshandler(Participants p, int konsekvensKod,int hast) {
		// TODO Auto-generated method stub
		int pos = p.getDistance();
		switch (konsekvensKod)
		{
		
		case 0: pos = (pos - rand.nextInt(15));
		break;// tidsf�rlust, m�ttlig
		case 1:  pos = (pos - rand.nextInt(30));
		break;// tidsf�rlust st�rre
		case 2:  p.setExpelled(true);break;
		case 3:	 p.setExpelled(true);break;
		case 4:	 hast = (hast -2)    ;break;		//bromsa alla
		case 5:	  hast = (hast-4);break; // bromsa alla h�rt
		default:  pos = (pos - rand.nextInt(10));
		}
		p.setDistance(pos); //uppdatera position obs mellantider...
		if (hast < 1)
			hast = 2;
		
		return hast;
	}






	// verkar st�mma med Hans Hypot�s att det var en pekare som beh�vdes korrigera nu f�r vi ut mellantiden som det �r t�nkt 
	public void midListUpdate(Participants p,CompetitionBoard compBoard) {
		// g�r en ny deltagare och copy n pastar V�rderna f�r att sedan spara in dem i
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

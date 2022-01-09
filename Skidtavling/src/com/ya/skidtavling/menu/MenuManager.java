package com.ya.skidtavling.menu;


import com.ya.skidtavling.competitions.*;

import com.ya.skidtavling.participants.NewRegistration;
import com.ya.skidtavling.participants.SearchParticipant;
import com.ya.skidtavling.tavla.CompetitionBoard;
import com.ya.skidtavling.tavla.FillFromFile;
import com.ya.skidtavling.tavla.Race;
import com.ya.skidtavling.tavla.Tidregistrering;

public class MenuManager {
//	boolean isCompdone;
//	boolean isSetup;
//	boolean isPrepared;
//	boolean isInit;	// replaced by competisions statuscode
	
	
	
	public static void switchMenu(int userChoice, CompetitionBoard compBoard, Competitions tavl1) throws InterruptedException {
	
		// beh�ver ses igenom
		// beh�ver vi under menyer f�r diverse menyval
//		G�r ett av valen:
//			0. Avsluta.
//			1. T�vling set-upp.
//			2. Deltagare. 
//			3. S�k en Deltagare.
//			4. Skriv ut Starttavla.
//			5. Starta T�vling.
//			6. Skriv ut mellantiderna.
//			7. Skriv ut Resultattavla.
//			8. Skriv ut Vinnarna 1-3.
//			9. reserv.
		
			

Incidents ins = new Incidents();
int status = tavl1.getStatuskod();	
tavl1.setIns(ins); // handtag, pekare till insidensklassen...
		
		
		
		switch (userChoice) {			 
		case 0:
			PrintMenu.printByeByeBox();
			System.exit(0);// END
		case 1:						//set up 	
			System.out.println("till undermenyn");
			 Compmenue Smenue = new Compmenue();
			Smenue.Compmain(tavl1);
			System.out.println(tavl1.getTavlingsnamn());
			System.out.println(tavl1.getNbrStart());
			System.out.println("tillbaks fr�n  undermenyn");
		
			break;
		case 2:
		{
			if (status < 1)
			{
				System.out.println("T�vling ej angiven!! k�r menu 1 f�rst!!");
				break;
			}
			
			System.out.println("Deltagare ladda/ l�gga till");
			boolean doLoad = Input.inputBool("Ladda fr�n fil");
			if (doLoad)
			{
			FillFromFile FFF = new FillFromFile(compBoard, tavl1);// instans till nya klassen f�r fil l�sning
//			System.out.println("Nytt placenr1 " + tavl1.getNbrStart());
			}
			doLoad = Input.inputBool("Registrera X-tra deltagare Mannuellt");
//			System.out.println("Nytt placenr2" + tavl1.getNbrStart());
			if (doLoad)
			{
			NewRegistration reg = new NewRegistration();
			
			reg.Registration(compBoard,tavl1);
						}
			// ev preparera f�r individuell start lottning.
			int startkod = tavl1.getStartmetod();
			if (startkod == 3)
			{
				System.out.println("lottar starttider och ordning!!");
				indiviStartPrepare.renumber(compBoard,tavl1);
			}
			tavl1.setStatuskod(2);
			break;	
		}	
		case 3:
			if (status < 2)
			{
				System.out.println("Inga deltagare registrerade.. registrera f�rst!!");
				break;
			}
			System.out.println("S�k en Deltagare");
			SearchParticipant test = new SearchParticipant(compBoard);
			break;	
			
		case 4:
			if (status < 2)
			{
				System.out.println("Inga deltagare registrerade.. registrera f�rst!!");
				break;
			}
			System.out.println("Skriv ut T�vlingstavla");

			compBoard.startingTime(tavl1);
			//compBoard.printParticipantsBoard(tavl1);
			tavl1.setStatuskod(3);
			break;
			
		case 5:
			if (status < 3)
			{
				System.out.println("Inte klar med f�rbredelserna, t�vling, deltagare, startlista fixa..f�rst!!");
				break;
			}
			tavl1.setStatuskod(4);	
			System.out.println("Simulering av t�vling");
			Race race = new Race();// skapar en instans f�r Rejset.
			race.race(compBoard,tavl1);// anropar metoden race
			tavl1.setStatuskod(5);
			break;
			
		case 6:
			if (status < 3) {
				System.out.println("Inga deltagaret finns �nnu - k�r startlista f�rst..");
				break;
			}
			Tidregistrering tid = new Tidregistrering();
			tid.startreg(compBoard,tavl1);
			//compBoard.printMidTimeList();
			break;
		case 7:
			if (status < 5) {
			System.out.println("Inga resultat finns �nnu - k�r t�vling klart f�rst..");
			break;
		}
			System.out.println(" - ");
			compBoard.printResultBoard(tavl1);
			break;
			
		case 8:
//			if (!isCompdone) {
//				System.out.println("Inga resultat finns �nnu - k�r t�vling f�rst..");
//				break;
//			}
			compBoard.printWinnerBoard();
			break;
		
		case 9:
			System.out.println("print Brutna lopp");
			try {
				compBoard.printExpelledlist();
			} catch (Exception e) {
				System.out.println("Listan tom...");
			}
			break;

	
		default:
			System.out.println("N�got gick snett");
		}
	}

	
	
}

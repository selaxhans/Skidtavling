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
	
		// behöver ses igenom
		// behöver vi under menyer för diverse menyval
//		Gör ett av valen:
//			0. Avsluta.
//			1. Tävling set-upp.
//			2. Deltagare. 
//			3. Sök en Deltagare.
//			4. Skriv ut Starttavla.
//			5. Starta Tävling.
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
			System.out.println("tillbaks från  undermenyn");
		
			break;
		case 2:
		{
			if (status < 1)
			{
				System.out.println("Tävling ej angiven!! kör menu 1 först!!");
				break;
			}
			
			System.out.println("Deltagare ladda/ lägga till");
			boolean doLoad = Input.inputBool("Ladda från fil");
			if (doLoad)
			{
			FillFromFile FFF = new FillFromFile(compBoard, tavl1);// instans till nya klassen för fil läsning
//			System.out.println("Nytt placenr1 " + tavl1.getNbrStart());
			}
			doLoad = Input.inputBool("Registrera X-tra deltagare Mannuellt");
//			System.out.println("Nytt placenr2" + tavl1.getNbrStart());
			if (doLoad)
			{
			NewRegistration reg = new NewRegistration();
			
			reg.Registration(compBoard,tavl1);
						}
			// ev preparera för individuell start lottning.
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
				System.out.println("Inga deltagare registrerade.. registrera först!!");
				break;
			}
			System.out.println("Sök en Deltagare");
			SearchParticipant test = new SearchParticipant(compBoard);
			break;	
			
		case 4:
			if (status < 2)
			{
				System.out.println("Inga deltagare registrerade.. registrera först!!");
				break;
			}
			System.out.println("Skriv ut Tävlingstavla");

			compBoard.startingTime(tavl1);
			//compBoard.printParticipantsBoard(tavl1);
			tavl1.setStatuskod(3);
			break;
			
		case 5:
			if (status < 3)
			{
				System.out.println("Inte klar med förbredelserna, tävling, deltagare, startlista fixa..först!!");
				break;
			}
			tavl1.setStatuskod(4);	
			System.out.println("Simulering av tävling");
			Race race = new Race();// skapar en instans för Rejset.
			race.race(compBoard,tavl1);// anropar metoden race
			tavl1.setStatuskod(5);
			break;
			
		case 6:
			if (status < 3) {
				System.out.println("Inga deltagaret finns ännu - kör startlista först..");
				break;
			}
			Tidregistrering tid = new Tidregistrering();
			tid.startreg(compBoard,tavl1);
			//compBoard.printMidTimeList();
			break;
		case 7:
			if (status < 5) {
			System.out.println("Inga resultat finns ännu - kör tävling klart först..");
			break;
		}
			System.out.println(" - ");
			compBoard.printResultBoard(tavl1);
			break;
			
		case 8:
//			if (!isCompdone) {
//				System.out.println("Inga resultat finns ännu - kör tävling först..");
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
			System.out.println("Något gick snett");
		}
	}

	
	
}

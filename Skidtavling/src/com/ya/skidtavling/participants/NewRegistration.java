package com.ya.skidtavling.participants;

import com.ya.skidtavling.competitions.*;
import com.ya.skidtavling.competitions.Input;
import com.ya.skidtavling.competitions.Wlogg;
import com.ya.skidtavling.tavla.CompetitionBoard;
import java.util.*;

public class NewRegistration {

	public void Registration(CompetitionBoard compBoard, Competitions tavl1) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int regnr = 0;
		int place = 0;

		if (tavl1.getStartmetod() == 1) {
			regnr = tavl1.getNbrStart();
			place = tavl1.getNbrStart();
		}
		if (tavl1.getStartmetod() == 3) {
			place = tavl1.getNbrStart();
			regnr = rand.nextInt(100);
		}

//		System.out.println("place nr " + place);
//		System.out.println("Hur många åkare vill du registrera?: ");
		System.out.println("Registrera Sena nyanmälda åkare?");
		boolean dogoOn = true;
		String ForName = "";
		String LastName = "";
		boolean isOK = false;
		while (dogoOn) {
			place++;
			regnr++;
			System.out.println("Fyll i: Förnamn  Efternamn: avsluta med 'S' ");
			ForName = scan.next();

			ForName = ForName.trim();
			LastName = LastName.trim();
			if ((ForName.length() == 1) & (ForName.equals("S"))) { // bara en bokstav och S;
				dogoOn = false;
				System.out.println("avslutar...");
			}

			if (dogoOn) {
				LastName = scan.next();
				compBoard.participantsList.add(new Participants(ForName, LastName, place, regnr));
				isOK = Wlogg.nyevent(1, "Ny deltagare", 2, ForName + " " + LastName);
				tavl1.setNbrStart(regnr);
			}
			;

		}
		return;
	}
}

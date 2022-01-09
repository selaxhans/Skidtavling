package com.ya.skidtavling.competitions;

import com.ya.skidtavling.participants.Participants;
import com.ya.skidtavling.tavla.CompetitionBoard;
import com.ya.skidtavling.time.Time;

import java.util.*;

public class indiviStartPrepare {

	public static boolean renumber(CompetitionBoard compBoard, Competitions tavl) {
		Random rand = new Random();
		Time startTime = new Time(0);

//	System.out.println("Start renumbering and preparation");	
		int nbrof = compBoard.participantsList.size();
		int index = 0;
		boolean iscomplete = false;
		int n = nbrof;

		int[] neworderlist = new int[nbrof];

		/*
		 * skap en tabell med slumpade nummer och kontrollera att det inte blir
		 * dubletter i så fall nytt försök gör kontollen i en metod och antalet försök
		 * är okänt så använd tex whileloop
		 * 
		 */
		int x = 0;
		int count = 0;
		int filled = n;
		boolean isOK;
		String textstarttid;
		// System.out.println("Start while0 " + filled);

		x = rand.nextInt(n + 1);

		/*
		 * För att lotta ut startider, som skall följa i ett sammanhang men jämnt
		 * mellanrum måste först antalet deltagare vara klart.Sedan måste platserna
		 * fördelas på ett sådant sätt att inte två åkare får samma startnummer och did.
		 * det görs här nedan. därefter skall listan sortera från blandad till i
		 * startnummerordning. vilket blir nästa steg, varvid en helt ny lista av
		 * objekt.skapas. de här listorna gäller endast individuell start.
		 */

		/*
		 * här gör vi först en tombola med nummerlappar numrerade från 1 till antalet
		 * deltagare men av teknisk skäl har vi flera lappar av varje nummer, så vid
		 * lottningen måst vi kolla att ingen förut fått samma lottnummer. funktionen
		 * check kollar det. sedan delar vi ut starttider efter startorning.
		 * flödesschema isom diagram finns
		 */

		while (!iscomplete) {

			x = rand.nextInt(n + 1);

			isOK = chk(neworderlist, x, index);
			if (isOK) {

				count++;
				neworderlist[index] = x;
				index++;

			}
			if (index == filled)
				iscomplete = true;

		}

		for (int k = 0; k < nbrof; k++) {
		}
		/*
		 * take compbord list and renumber each item with new random number and set star
		 * time as order nr *defined start intervall from class competition. use list
		 * index order
		 */
		long midnight = 0; // kl 00.00.00
		// Time tTime = new Time(midnight);
		int starttid = 0;
		int startintervall = tavl.getStartIntervall();// tävlings förutsäätnin;
		int startordernr = 0;

		for (int k = 0; k < nbrof; k++) {
			starttid = 0;
			startordernr = neworderlist[k];//

			starttid = ((startordernr - 1) * startintervall);
//    	System.out.println("index "+ k + "  värde " + neworderlist[k]+ "  starttid i sec  " + starttid  );// läs tabellen nytt startnummer - lottat..
			Participants p = compBoard.participantsList.get(k);
			p.setParticipantNumber(startordernr);
			textstarttid = textavtid(starttid);
			p.setIndivStarTime(textstarttid);
			p.setIndivtidoffset(starttid);

		}
		return true;

	}
// klassen Time ger underliga fel men som kod fungerar det bra.

	private static String textavtid(int starttid) {

		int temp = 0;
		int hour = 0;
		int min = 0;
		int secu = 0;
		temp = starttid;
		hour = 0;

		hour = temp / 3600;
		temp = temp - hour * 3600;
		min = temp / 60;
		temp = temp - min * 60;
		secu = temp;
		return "starttid: " + min + " min  och " + secu + " sec efter första start.";

	}

	private static boolean chk(int[] rnd, int x, int index) {
		boolean result = true;
		/*
		 * check that this new number does not occupy any of filled places;
		 */
		if (x == 0) {
			return false;
		}

//		System.out.print(index + "i   ");

		for (int i = 0; i < index; i++) {

			if (rnd[i] == x) {
				// finns redan försök igen..i..
				return false;
			}
		}
//		System.out.println("index+ok2 " + index);
		return true;
	}

}

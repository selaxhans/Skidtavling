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
		 * dubletter i s� fall nytt f�rs�k g�r kontollen i en metod och antalet f�rs�k
		 * �r ok�nt s� anv�nd tex whileloop
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
		 * F�r att lotta ut startider, som skall f�lja i ett sammanhang men j�mnt
		 * mellanrum m�ste f�rst antalet deltagare vara klart.Sedan m�ste platserna
		 * f�rdelas p� ett s�dant s�tt att inte tv� �kare f�r samma startnummer och did.
		 * det g�rs h�r nedan. d�refter skall listan sortera fr�n blandad till i
		 * startnummerordning. vilket blir n�sta steg, varvid en helt ny lista av
		 * objekt.skapas. de h�r listorna g�ller endast individuell start.
		 */

		/*
		 * h�r g�r vi f�rst en tombola med nummerlappar numrerade fr�n 1 till antalet
		 * deltagare men av teknisk sk�l har vi flera lappar av varje nummer, s� vid
		 * lottningen m�st vi kolla att ingen f�rut f�tt samma lottnummer. funktionen
		 * check kollar det. sedan delar vi ut starttider efter startorning.
		 * fl�desschema isom diagram finns
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
		int startintervall = tavl.getStartIntervall();// t�vlings f�ruts��tnin;
		int startordernr = 0;

		for (int k = 0; k < nbrof; k++) {
			starttid = 0;
			startordernr = neworderlist[k];//

			starttid = ((startordernr - 1) * startintervall);
//    	System.out.println("index "+ k + "  v�rde " + neworderlist[k]+ "  starttid i sec  " + starttid  );// l�s tabellen nytt startnummer - lottat..
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
		return "starttid: " + min + " min  och " + secu + " sec efter f�rsta start.";

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
				// finns redan f�rs�k igen..i..
				return false;
			}
		}
//		System.out.println("index+ok2 " + index);
		return true;
	}

}

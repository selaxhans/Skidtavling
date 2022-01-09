package com.ya.skidtavling.tavla;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import com.ya.skidtavling.competitions.Competitions;
import com.ya.skidtavling.competitions.Wlogg;
import com.ya.skidtavling.participants.Participants;
import com.ya.skidtavling.time.Time;

public class FillFromFile {
	Random rand = new Random();
	public FillFromFile(CompetitionBoard compBoard, Competitions tavl) {

		// L�ser in deltagarena fr�n filen
//		try (BufferedReader fReader = new BufferedReader(new FileReader("Deltagare.txt"))) {
		try(BufferedReader fReader = new BufferedReader(new FileReader("PreviusResult.txt"))){// Nytt nerbantad deltagarlista
			String line;
			int stMetod = tavl.getStartmetod();  // styr numrering mm
//			int stNbr = tavl.getNbrStart();
			int stNbr = 0;
			//long midnight = 0;  
			 int zero = 0;		
			 int i = tavl.getNbrStart();
//			 System.out.println("startnr"+ i);
//			 System.out.println("l�sning start "+ i);

			// st�ller upp deltagarna rad f�r rad
			while ((line = fReader.readLine()) != null) {
				String split[] = line.split(" ");// stringSplitar raden
				String fName = split[0];// sparar f�rnamn
				String lName = split[1];// sparar efternamn
				int randNum = rand.nextInt(100);
				
				// startmetod individuell start
				if (stMetod == 3)
				{
				Participants nyParticipant = new Participants(randNum, fName, lName, i + 1, zero,zero," ", 0, false,false);
				compBoard.participantsList.add(nyParticipant);
				i++;
				tavl.setNbrStart(i);
				}
				// startmetod mass start
				if (stMetod == 1)
				{
					
					Participants newParticipant = new Participants(stNbr, fName, lName,stNbr, zero,zero, " ", 0, false,false);
					tavl.setNbrStart(stNbr);
					compBoard.participantsList.add(newParticipant);
					stNbr++;
				}
//				compBoard.participantsList.add(newParticipant);
		

			}
//			tavl.setNbrStart(i);
//			 System.out.println("l�sning slut " + i);
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Listan �r nu laddad!");
			boolean isOK = Wlogg.nyevent(1,"Deltagarlista inl�st st�rsta startnr: " + tavl.getNbrStart() ,2,"fr�n fil: PreviusResult.txt");
	//		isOK = Wlogg.nyevent(1,"M�lg�ng",5,p.getForName() +" "+ p.getLastName());
		}

	}
}

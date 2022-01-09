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

		// Läser in deltagarena från filen
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
//			 System.out.println("läsning start "+ i);

			// ställer upp deltagarna rad för rad
			while ((line = fReader.readLine()) != null) {
				String split[] = line.split(" ");// stringSplitar raden
				String fName = split[0];// sparar förnamn
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
//			 System.out.println("läsning slut " + i);
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Listan är nu laddad!");
			boolean isOK = Wlogg.nyevent(1,"Deltagarlista inläst största startnr: " + tavl.getNbrStart() ,2,"från fil: PreviusResult.txt");
	//		isOK = Wlogg.nyevent(1,"Målgång",5,p.getForName() +" "+ p.getLastName());
		}

	}
}

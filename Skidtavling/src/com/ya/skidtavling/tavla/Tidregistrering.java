/**
 * 
 */
package com.ya.skidtavling.tavla;

import java.util.*;

import com.ya.skidtavling.competitions.Competitions;
import com.ya.skidtavling.competitions.Input;
import com.ya.skidtavling.participants.Participants;
import com.ya.skidtavling.participants.SearchParticipant;
/**
 * @author hans stål
 * om Simulering inte är aktuell finns
 * denna funkionssamling för att registrera tider manuellt
 * dvs efter banan med stoppur tex..
 *
 */
public class Tidregistrering {
	
public boolean startreg(CompetitionBoard compb,Competitions tvl) {	

	int choice =0;
	boolean isOK = true;
			
	
	System.out.println("Manuell tidtagning rapportering välj mellan målgång oc mellantid");
	System.out.println("0. Avbryt");
	System.out.println("1. rapporteringsplats Mål");
	System.out.println("2. rapporteringsplats Mellantid");
	System.out.println("Registreringen sker med startnummer och åktid från start.");
	
	choice = Input.inputInt("Ange val 0,1 eller 2",0,2);
			if (choice ==0)
				return isOK;
			else
				isOK = regatid(choice);
		return isOK;
}

private boolean regatid(int choice) {
	// TODO Auto-generated method stubboolean
	int itemcnt = CompetitionBoard.participantsList.size();
	Participants p;
	int hour =0;
	int min =0;
	int secu = 0;
	int tid = 0;
	int startNummer =0;	// objektets startnummer;
	boolean doRun = true;
	while (doRun)
	{
		if (choice== 1)
		{
			System.out.println("Rapporteringsplats Mål");	
		}
		else
			System.out.println(" Rapporteringsplats Mellantid");
		{
			System.out.println("Ange Startnummer , Avbryt med 999");
			
			startNummer = Input.inputInt("åkarens startnummer", 0, 1000);
			if (startNummer == 999)
			{
				doRun = false;
				return true;
			}
			
		    p = getParticipantfromNumber(startNummer,itemcnt);
		    
		    System.out.println(p.forName + "  "+ p.getLastName());
		    
		    hour = Input.inputInt("Timmar  :", 0, 48);
		    min = Input.inputInt("Minuter  :", 0, 240);
		    secu = Input.inputInt("Sekunder:", 0, 240);
		    tid = hour*3600 + min*60+ secu;
		    if (choice ==1)
		    	p.setStartTime(tid);
		    else
		    	p.setMiddleTime(tid);
		}
	}
	return true;
	
}

private Participants getParticipantfromNumber(int startNummer,int itemcnt) 
{
	boolean found = false;
	Participants t = null;
	for (int k=0; k < itemcnt; k++) {
	t = CompetitionBoard.participantsList.get(k);
	

	if (t.getParticipantNumber() == startNummer) {
		found = true;
		break;}
	}
	// all patrticipants checked...
	if (!found)
	{
		System.out.println("Hittar inte...försök igen");
		return null;
	}
	else
		return t;

}	
	
	
	
}

	


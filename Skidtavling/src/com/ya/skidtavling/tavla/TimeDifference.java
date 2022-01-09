package com.ya.skidtavling.tavla;

import java.util.Scanner;

import com.ya.skidtavling.participants.Participants;
import com.ya.skidtavling.time.Time;

public class TimeDifference {
// Lägg till Lite mer data i Utskrift tex : namn och tid. 
	// kanske göra något liknande med mellantiderna
	public TimeDifference(CompetitionBoard comBoard) {
		Participants winner = comBoard.resultBoard.get(0);

		System.out.println(winner.startTime.toString());
		long found = 0;

		Scanner input = new Scanner(System.in);
		String search = input.nextLine();

		{
			for (Participants p : comBoard.resultBoard) {
				if (p.getForName().equals(search) || p.getLastName().equals(search)) {
					System.out.println(p.startTime);

					found = p.startTime.getSec();
				}
			}
//				if (found != true) {
//					System.out.println("Kunde inte hitta deltagare.");
//					
//				}
			long difTime = found - winner.startTime.getSec();
			System.out.println(difTime);
			Time newTime = new Time(difTime);
			System.out.println(newTime.toString());
		}
	}
}

package com.ya.skidtavling.participants;

import java.util.Scanner;

import com.ya.skidtavling.competitions.Input;
import com.ya.skidtavling.tavla.CompetitionBoard;

// EN tillfixad sökKlass den som anna gjorde nu fungerande :)
public class SearchParticipant {
	boolean goOn = true;

	public SearchParticipant(CompetitionBoard compBoard) {

		boolean found = false;

		Scanner input = new Scanner(System.in);
		while (goOn) {
			String search = input.nextLine();
			{
				for (Participants p : compBoard.participantsList) {
					if (p.getForName().equals(search) || p.getLastName().equals(search)) {
						System.out.println(toShowstring1(p));
						System.out.println(toShowstring2(p));
						found = true;
					}
//					goOn= Input.inputBool("Fortsätt ..");

				}
				if (found != true) {
					System.out.println("Kunde inte hitta deltagare.");

				}

			}
			goOn = Input.inputBool("Fortsätt ..");
		}

	}

	public String toShowstring1(Participants s) {

//String test = s.getParticipantNumber() + s.getForName().trim() + s.getLastName().trim();
//int langd = test.length();

//String sp= " ";
//String tab = "";
		String marg = "  ";
		String utgatt = " ";
		if (s.isExpelled())
			utgatt = "har avrutit loppet";

//for  (int i=0; i<30-langd; i++)
//tab = tab + sp;

		return marg + "startnummer: " + s.getParticipantNumber() + " " + s.getForName().trim() + " "
				+ s.getLastName().trim() + "  " + utgatt;

	}

	public String toShowstring2(Participants s) {

//String test = s.getParticipantNumber() + s.getForName().trim() + s.getLastName().trim();
//int langd = test.length();

		String sp = " ";
		String tab = "";
		String marg = "    ";
		int korTid = s.getStartTime();
		int mellanTid = s.getMiddleTime();
		boolean isFinished = s.isNotFinished();
		int placering = s.getPlace();
		if (!isFinished)
			placering = 0;

		String skorTid = textavtid(korTid);
		String smellanTid = textavtid(mellanTid);

		return "Placering: " + placering + " Åktid: " + skorTid + "    mellantid: " + smellanTid + "   indiv starttid: "
				+ s.getIndivStarTime();
	}

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
		String tidstrang = (" " + hour + " : " + min + " : " + secu);
		return tidstrang;

	}
}

package com.ya.skidtavling.competitions;
//Managecompetitions.java

import com.ya.skidtavling.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.text.*;
import com.ya.skidtavling.competitions.Compmenue.*;

public class Managecompetitions {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String wrk = "";
		String prmt = "";
		int win = 0;
		long wlong = 0;
		Boolean wbool = false;
		// raderaKonsole(5);
		System.out.println("Ange de uppräknade egenskaperna för aktuell tävling");
		Competitions tavl1 = new Competitions();

		wrk = Input.inputString("Ange tävlingens namn", false, 0);

		tavl1.setTavlingsnamn(wrk);

		wbool = Input.inputBool("Obligatorisk förhandsanmälan");
		tavl1.setForHandsanmalanKrav(wbool);
		wlong = Input.inputDatum(" Senaste Anmälningsdag ");
		tavl1.setSistaAnmalningsdatum(wlong);
		wbool = Input.inputBool("Simulerad tidtagning");
		tavl1.setSimTidtagning(wbool);

		win = Input.inputInt("Ange kod för startmetod 1-4 se manualen !!", 1, 4);
		tavl1.setStartmetod(win);
		win = Input.inputInt("Ange Starnummer första startande !", 10, 500);
		tavl1.setFixedStartnbr(win);
		win = Input.inputInt("Ange Startnummer i serie  !", 10, 750);
		tavl1.setNbrStart(win);
		win = Input.inputInt("Ange Sista nummer i serie !", 10, 1000);
		tavl1.setNbrSlut(win);
		win = Input.inputInt("Startintervall i sekunder!", 10, 120);

		tavl1.setStartIntervall(win);
		win = Input.inputInt("Maximalt antal startande", 10, 150);
		tavl1.setMaxAntalstartande(win);

		wlong = Input.inputDatum("Ange tävlingsdatum som ÅÅÅ-MM_DD ");
		tavl1.setForstaStartPlanned(wlong);
		tavl1.setSenUppd();

		System.out.println(tavl1.toString());

	}

	private static void Compmenue() {
		// TODO Auto-generated method stub

	}

	private static void raderaKonsole(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("\n" + "\n" + "\n" + "\n" + "\n");
		}

		return;
	}

	// TODO Auto-generated method stub

}

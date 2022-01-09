package com.ya.skidtavling.competitions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CompetionsInput {

	public static void extendeddata(Competitions tavl) {
		// TODO Auto-generated method stub

		String work = ""; // allm�n tempor�r lagring kort r�ckvidd

		int workint = 0; // allm�n tempor�r lagring
		long worklong = 0; // allm�n tempor�r lagring
		boolean workbool = false;

		System.out.println("Ange de uppr�knade egenskaperna f�r aktuell t�vling");
		Competitions tavl1 = new Competitions();

		work = Input.inputString("Ange t�vlingens namn", false, 0);

		tavl.setTavlingsnamn(work);

		workbool = Input.inputBool("Obligatorisk f�rhandsanm�lan");
		tavl.setForHandsanmalanKrav(workbool);

		worklong = Input.inputDatum(" Senaste Anm�lningsdag ");
		tavl.setSistaAnmalningsdatum(worklong);

		workbool = Input.inputBool("Simulerad tidtagning");
		tavl.setSimTidtagning(workbool);
		// sp�rl�ngd o mellantid

		workint = Input.inputInt("Ange sp�rl�ngd i 10-tals meter", 10, 30000);// talen �vre och nedre gr�ns f�r indata
		tavl.setSparLangd(workint);
		workint = Input.inputInt("Mellantidstagning i hela  procent av banl�ngd r�knat fr�n start tex 50 mittpunkt", 1,
				100);
		tavl.setPlaceMellantid(workint);

		workint = Input.inputInt("Ange kod f�r startmetod 1-4 se manualen !!", 1, 4);
		tavl.setStartmetod(workint);
		workint = Input.inputInt("Ange Antalet anm�lda startande!", 10, 500);
		tavl.setFixedStartnbr(workint);
		workint = Input.inputInt("Ange Startnummer i serie  !", 1, 750);
		tavl.setNbrStart(workint);
		workint = Input.inputInt("Ange Sista nummer i serie !", 10, 1000);
		tavl.setNbrSlut(workint);
		workint = Input.inputInt("Startintervall i sekunder!", 10, 120);

		tavl.setStartIntervall(workint);
		workint = Input.inputInt("Maximalt antal startande", 10, 300);
		tavl.setMaxAntalstartande(workint);

		worklong = Input.inputDatum("Ange t�vlingsdatum som ���-MM_DD ");
		tavl.setForstaStartPlanned(worklong);

		tavl.setSenUppd();

		tavl.setStatuskod(1);

		System.out.println("Utf�rt klart...");
		return;

	}

	public static boolean savetodisk(Competitions tavl) {
		String destpath = "skidtavling.csv";
		String[] param = new String[14];
		boolean append = false;
		boolean isOK = false;
		// String line = "";
		/*
		 * prepare data to bee written in a sTRING ARRAY.
		 */
		param[0] = "01  " + tavl.getTavlingsnamn();
		param[1] = "02  " + tavl.isForHandsanmalanKrav();
		param[2] = "03  " + tavl.getSistaAnmalningsdatum();
		param[3] = "04  " + tavl.getStartmetod();
		param[4] = "05  " + tavl.getFixedStartnbr();
		param[5] = "06  " + tavl.getMaxAntalstartande();
		param[6] = "07  " + tavl.getForstaStartPlanned();
		param[7] = "08  " + tavl.getForstaStartVerklig();
		param[8] = "09  " + tavl.getStartIntervall();
		param[9] = "10  " + tavl.getSenUppd();
		param[10] = "11  " + tavl.getNbrStart();
		param[11] = "12  " + tavl.getNbrSlut();
		param[12] = "13  " + tavl.getSparLangd();
		param[13] = "14  " + tavl.getPlaceMellantid();
		/*
		 * �ppna en kanal "str�m" f�r att skriva till disk. skriv all parametrar p�
		 * formatet "X  parametervalue \n"
		 *
		 */
		try {
			PrintWriter utstrom = new PrintWriter(new BufferedWriter(new FileWriter(destpath, append)));

			/*
			 * use skriv sedan till filen till exempel med en forllop
			 * 
			 */
			for (int i = 0; i <= 13; i++) {
				utstrom.println(param[i] + " ;");
			}

			utstrom.close();
			isOK = true;

		} catch (Exception ex) {
			System.out.println("n�got gick snett vid skrivning till disk, det gick inte att skapa fil etc");
			isOK = false;
		}

		System.out.println("sparat: " + isOK);
		return isOK;
	}

}

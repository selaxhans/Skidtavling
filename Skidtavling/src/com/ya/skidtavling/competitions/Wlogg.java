package com.ya.skidtavling.competitions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Scanner;

public class Wlogg {

	public static void writelogg(String[] args) {
		// TODO Auto-generated method stub
		String Storagepath = "tavlingslogg.txt";
		int IDnbr = 1;
		Eventlogg[] events = new Eventlogg[500];
		Eventlogg event = new Eventlogg();
		event.eventID = IDnbr;
		events[IDnbr] = event;
		IDnbr++;
		System.out.println(IDnbr);
//	for (int i=0;i < IDnbr; i++) {
//		System.out.println(events[i].toString());	// TODO Auto-generated method stub

	}

	public static boolean nyevent(int eventkod, String eventdescr, int eventsrce, String eventobj) {

		String destpath = "tavlingslogg.txt";
		String[] param = new String[12];
		boolean append = true;
		boolean isOK = false;
		String line = "";
		LocalDate idag = LocalDate.now();
		LocalTime now = LocalTime.now();
		/*
		 * # prepare data to bee written in a String hämta aktuell tidpunkt; String
		 * handelsetidpunkt =
		 */

		param[1] = " 01 ; " + idag.toString() + " " + now.toString().substring(0, 8) + " ; ";
		param[2] = " 02  ; " + eventkod + " ; ";
		param[3] = "  03  ; " + eventdescr + " ; ";
		param[4] = " 04  ; " + eventsrce + " ; ";
		param[5] = " 05  ; " + eventobj + " ; ";

		line = param[1] + param[2] + param[3] + param[4] + param[5];

		/*
		 * öppna en kanal "ström" för att skriva till disk. skriv ett post parametrar på
		 * formatet "X  parametervalue \n"
		 *
		 */
		try {
			PrintWriter utstrom = new PrintWriter(new BufferedWriter(new FileWriter(destpath, append)));

			/*
			 * use skriv sedan till filen till exempel med en forlloop
			 * 
			 */

			utstrom.println(line);

			utstrom.close();
			isOK = true;

		} catch (Exception ex) {
			System.out.println("något gick snett vid skrivning till disk, det gick inte att skapa fil etc");
			isOK = false;
		}

//				System.out.println("sparat: " + isOK);
		return isOK;

	}

	private static boolean inputEnter(String promptstring) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String inData = "";
		boolean isIndata = false;
		boolean ret = true;
		{
			System.out.println(promptstring + "tryck 'enter' för att fortsätta");
			inData = "";
			inData = scan.nextLine();

		}

		return ret;
	}

	static boolean nollalogglist() {
		String destpath = "tavlingslogg.txt";
		boolean append = false;
		boolean isOK = false;
		String line = "";
		try {
			PrintWriter utstrom = new PrintWriter(new BufferedWriter(new FileWriter(destpath, append)));

			/*
			 * use skriv sedan null i den befintliga filen
			 * 
			 */

			utstrom.print("");

			utstrom.close();
			isOK = true;

		} catch (Exception ex) {
			System.out.println("något gick snett vid skrivning till disk, det gick inte att skapa fil etc");
			isOK = false;
		}

		System.out.println("Nollställd: " + isOK);

		return isOK;
	}

}

/**
 * 
 */
package com.ya.skidtavling.competitions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Hans Stål Skidtävlingar samlade fil_las_skriv Huvudsakligen intern
 *         mellanlagring 2021-12-18
 *
 */
public class Filio {

	/**
	 * @param args
	 */

//		// TODO Auto-generated method stub
//		String srcepath = "incidents.txt";
//		används av flera rutiner

	public static int getFilesize(String path) {
		/*
		 * read file to determine number of rows
		 */
		String row = "";
		int rowcnt = 0;
		try {
			var instrom = new BufferedReader(new FileReader(path));
			while (row != null) {
				row = instrom.readLine();

//			System.out.println(line + i);
				rowcnt++;

			}
			instrom.close();
		} catch (Exception io) {
			System.out.println("fel vid filläsning!!" + rowcnt);
			rowcnt = -1;

		}
		rowcnt--;

//		System.out.println("antal lästa rader!!" +rowcnt);
		return rowcnt;
	}

	public static String[] readfiledatatoString(String srcepath) {

		boolean isOK;

		boolean atend = false; // TODO Auto-generated method stub
//		System.out.println("beräknar filstorlek...");
		int postant = getFilesize(srcepath);
//		System.out.println("postantal"+postant);

		String[] filedata = new String[postant];
		{

			String line = "";
			int i = 0;
			try {
				var instrom = new BufferedReader(new FileReader(srcepath));
				while (line != null) {
					line = instrom.readLine();

					if (line != null) {
						filedata[i] = line;
						i++;
					}

				}
				instrom.close();
//					System.out.println("post i"+i);
			} catch (Exception ex) {
				System.out.println("Fel vid filläsning !!");
				return null;
			}
			return filedata;
		}

	}

	public static boolean writeText(String[] rows, String path, int rowant, boolean append) {

		String destpath = path; // "tavlingslogg.txt";

		boolean isOK = false;
		String line = "";

//		param[1] = " 01 ; "+ idag.toString()+" "+ now.toString().substring(0,8)+" ; ";
//		param[2] = " 02  ; " + eventkod+" ; ";
//		param[3] = "  03  ; " + eventdescr+" ; ";
//		param[4] = " 04  ; " + eventsrce+ " ; ";
//		param[5] = " 05  ; " + eventobj + " ; ";

		/*
		 * öppna en kanal "ström" för att skriva till disk. skriv ett post parametrar på
		 * formatet "X  parametervalue \n"
		 *
		 */
		System.out.println("skriver till:" + path);

		try {
			PrintWriter utstrom = new PrintWriter(new BufferedWriter(new FileWriter(destpath, append)));

			for (int i = 0; i < rowant; i++) {
				utstrom.println(rows[i]);
			}
			;

			utstrom.close();
			isOK = true;

		} catch (Exception ex) {
			System.out.println("något gick snett vid skrivning till disk, det gick inte att skapa fil etc");
			isOK = false;
		}

//			System.out.println("sparat: " + isOK);
		return isOK;

	}

	public static boolean Listfile(String srcepath, int rowsperpage) {
		// String srcepath = "C://test//incidents.txt";

		boolean isOK = true;

		boolean atend = false; // TODO Auto-generated method stub

		{
			String line = "";
			int i = 0;

			try {
				var instrom = new BufferedReader(new FileReader(srcepath));
				while (line != null) {
					line = instrom.readLine();

					if (line != null) {
						// considerKonsole.....
						System.out.println(line);
						if (i > rowsperpage) {
							if (Input.inputEnter("Tryck enter för att fortsätta.."))
								i = 0;
						}

						i++;
					}
				}
				instrom.close();
//					System.out.println("post i"+i);
			} catch (Exception ex) {
				System.out.println("Fel vid filläsning !!");
				isOK = false;
			}
			return isOK;
		}

	}

}

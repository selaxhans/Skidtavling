package com.ya.skidtavling.competitions;

import java.io.*;
import java.util.*;
import java.text.ParseException;

import com.ya.skidtavling.menu.Menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import com.ya.skidtavling.*;

public class LoadCompetition {

	static void getfromdisk(Competitions tavl) {
		String srcepath = "skidtavling.csv";
		String[] param = new String[20];
		String info = "  ";
		boolean isOK;
		boolean atend = false; // TODO Auto-generated method stub

		{
			String[] inData = new String[25];
			String line = "xx";
			int i = 0;
			try {
				var instrom = new BufferedReader(new FileReader(srcepath));
				while (line != null) {
					line = instrom.readLine();
					param[i] = line;
//				System.out.println(line + i);
					i++;

				}
				instrom.close();

			} catch (Exception ex) {
				System.out.println("Fel vid filläsning !!");
				inData[0] = "readerror";
				return;
			}
			isOK = loadparam(param, tavl, (i - 1));
		}
		return;
	}

	private static boolean loadparam(String[] inD, Competitions ta, int n) {
		String param;
		String info = " ";
		int pend;
		boolean wbool;
		long wlong;
		int wint = 0;
		char e = ';';
//		System.out.println("radantal" +n );
		for (int i = 0; i < n; i++) {
			pend = inD[i].indexOf(e);
			pend = pend - 1;
			param = inD[i].substring(4, pend);

//			System.out.println(param);

			switch (i) {
			// tävlingsnamn
			case 0:
				ta.setTavlingsnamn(param);
				break;
			// Förhandsanmälan krav
			case 1: {
				if (param.equals("true"))
					wbool = true;
				else
					wbool = false;
			}
				ta.setForHandsanmalanKrav(wbool);
				break;
			// sista anmälningsdatum
			case 2: {
				wlong = getlongtime(param);
				ta.setSistaAnmalningsdatum(wlong);
			}
				break;
			// startmetod
			case 3: {
				wint = getint(param);
				ta.setStartmetod(wint);
			}
				break;
			// getFixedStartnbr
			case 4: {
				wint = getint(param);
				ta.setFixedStartnbr(wint);
			}
				break;

			// getMaxAntalstartande
			case 5: {
				wint = getint(param);
				ta.setMaxAntalstartande(wint);
			}
				break;
			// getForstaStartPlanned
			case 6: {
				wlong = getlongtime(param);
				ta.setForstaStartPlanned(wlong);
			}
				break;
			// getForstaStartVerklig
			case 7: {
				wlong = getlongtime(param);
				ta.setForstaStartVerklig(wlong);
			}
				break;
			// StartIntervall()

			case 8: {
				wint = getint(param);
				ta.setStartIntervall(wint);
			}
				break;
			// getSenUppd
			case 9: {
				info = param;
				ta.setSenUppd();
			}
				;
				break;
			// getNbrStart
			case 10: {
				wint = getint(param);
				ta.setNbrStart(wint);
			}
				break;
			// getNbrSlut
			case 11: {
				wint = getint(param);
				ta.setNbrSlut(wint);
				break;
			}
			// get sparlangd
			case 12: {
				wint = getint(param);
				ta.setSparLangd(wint);
				break;
			}
			// get midtimeplace
			case 13: {
				wint = getint(param);
				ta.setPlaceMellantid(wint);
			}

				break;
			}

		}
		return true;
	}

	private static int getint(String param) {
		int x;

		param = param.trim();

		try {
			x = Integer.parseInt(param);
		} catch (Exception f) {
			System.out.println("formatfel i fldata");
			x = 0;
		}

		return x;

	}

	private static long getlongtime(String param) {
		boolean isError;
		long time = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;

		try {
			d = df.parse(param);
		} catch (ParseException e) {
			// TODO Auto-generated catch block

			System.out.println("felangivet formati datum");
			isError = true;
			return 0;
		}

		time = d.getTime();

		return time;
	}

}

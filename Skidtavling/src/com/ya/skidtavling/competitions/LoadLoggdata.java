package com.ya.skidtavling.competitions;

import java.io.BufferedReader;
import java.io.FileReader;

public class LoadLoggdata {

	public static void main(String[] args) {
		boolean isOK = showlogglista();
	}

	private static boolean showlogglista() {
		String srcepath = "tavlingslogg.txt";
		boolean isOK;
		int PostID = 1;
		boolean atend = false; // TODO Auto-generated method stub

		int postant = getFilesize(srcepath);
		Eventlogg[] events = new Eventlogg[postant];
		for (int k = 0; k < 11; k++) {
			Eventlogg event = new Eventlogg();
			events[k] = event;
			// events[k] = event;
		}

		Eventlogg event = new Eventlogg();
		{

			{
				String line = "";
				int i = 1;
				try {
					var instrom = new BufferedReader(new FileReader(srcepath));
					while (line != null) {
						line = instrom.readLine();
						// System.out.println(line + i);
						if (line != null) {
//						
							event = loadparam(events[i - 1], line, i);
							events[i - 1] = event;

						}
						i++;

					}
					instrom.close();

				} catch (Exception ex) {
					System.out.println("Fel vid filläsning !!");
					return false;
				}
				for (int k = 0; k < 11; k++) {
					System.out.println(events[k].toString());
				}
			}
		}

		return true;
	}

	private static Eventlogg loadparam(Eventlogg event, String row, int pid) {
//							for(int i =0; (i<12); i++){

//								
//								pend = inD[i].indexOf(e);
//								pend = pend-1;
//								param = inD[i].substring(4,pend);

		String[] item = new String[12];
		item = row.split(";");
		int wint = 0; // wor output from parse;
		int i = 0;
		for (i = 0; i < 10; i++)
//								{
//									System.out.println(i+ item[i]);
//								}
//								this.eventID = eventID;
//								this.handelsetidpunkt = handelsetidpunkt;
//								this.eventkod = eventkod;
//								this.eventdescr = eventdescr;
//								this.eventsrce = eventsrce;
//								this.eventobj = eventobj;							

			switch (i) {
			// postid
			case 0:
				event.setEventID(pid);
				break;
			// tidpunkt som string
			case 1:
				event.setHandelsetidpunkt(item[1].trim());
				break;
			// faltid
			case 2:
				break;
			// startmetod
			case 3: {
				wint = getint(item[3]);
				event.setEventkod(wint);
			}
				;
				break;
			case 4:
				break;
			case 5:
				event.setEventdescr(item[5].trim());
				break;
			case 6:
				break;
			case 7: {
				wint = getint(item[7]);
			}
				event.setEventsrce(wint);
				break;
			case 8:
				break;
			case 9:
				event.setEventobj(item[9].trim());
				break;
			}
//								System.out.println(event.toString());
		return event;
	}

//						
//						System.out.println("fildata från datum  " + info + " har laddats");
//							return true;
//				}
//
	private static int getint(String param) {
		int x;

		param = param.trim();

		try {
			x = Integer.parseInt(param);
		} catch (Exception f) {
			System.out.println("formatfel i fildata");
			x = 0;
		}

		return x;
	}

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

//				System.out.println(line + i);
				rowcnt++;

			}
			instrom.close();
		} catch (Exception io) {
			System.out.println("fel vid filläsning!!" + rowcnt);
			rowcnt = -1;

		}
		rowcnt--;

		System.out.println("antal lästa rader!!" + rowcnt);
		return rowcnt;
	}

}

package com.ya.skidtavling.competitions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Input {

	public static boolean inputEnter(String promptstring) {
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

	public static int inputInt(String promptstringint, int min, int max) {
		// TODO Auto-generated method stub
		int inData = 0;
		String svar = "";
		boolean isIndata = false;
		{
			System.out.println(promptstringint);
			Scanner scan = new Scanner(System.in);
			boolean isNonumber = false;
			inData = 0;

			while (!isIndata) {

				svar = scan.nextLine();
				isNonumber = false;

				try {
					inData = Integer.parseInt(svar);

				} catch (NumberFormatException e) {

					isNonumber = true;
				}

				if ((inData < min) || (inData > max) || (isNonumber)) {
					System.out.println("ogiltigt val, försök igen!");
					// stannar kvar i whileloopen
				} else
					isIndata = true;
			}
			// scan.close();
		}

		return inData;

	}

	static String inputString(String promptString, boolean b, int i) {
		boolean noNullstring = b;

		int specfunkt = i; // 1 return as Upper case;
		String inData = "";

		boolean isIndata = false;
		{
			System.out.println(promptString);
			Scanner scan = new Scanner(System.in);

			while (!isIndata) {

				inData = scan.nextLine();

				if ((inData.length() == 0) && (noNullstring)) {
					System.out.println("Måste anges!");
					// stannar kvar i whileloopen
				} else
					isIndata = true;
			}
			// scan.close();
		}

		return inData;
	}

	static long inputDatum(String promt) {
		long time;
		boolean isError = false;
//	using Date and simpel Date Format
//	to add, subtract, print "any" time and format
//	https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat.html

		String nytid = Input.inputString("Ange datum som ÅÅÅÅ-MM-DD " + promt, true, 0);
		// System.out.println(nytid);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		Date d = null;

		try {
			d = df.parse(nytid);
		} catch (ParseException e) {
			// TODO Auto-generated catch block

			System.out.println("felangivet format");
			isError = true;

		}
		if (isError)
			return 0;

		time = d.getTime();

		return time;
	}

	public String hamtaTid(float result, int val) {
		String tidResultat = "";

		{
			LocalDate idag = LocalDate.now();
			LocalTime now = LocalTime.now();

			// parse date from yyyy-mm-dd pattern
			LocalDate birthday = LocalDate.parse("2021-05-20");

			// add one day..etc.
			LocalDate anotherday = birthday.minusYears(75);
			System.out.println("Datumtid:" + idag.toString());
			System.out.println("Datumtid:" + now.toString());
			System.out.println("Datumtid:" + anotherday.toString());
			tidResultat = "Datumtid:" + now.toString();
			return tidResultat;
		}

	}

	public static boolean inputBool(String promptstring) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String inData = "";
		boolean isIndata = false;
		boolean ret = false;
		{
			System.out.println(promptstring + " Svara J eller N");
			inData = "";

			while (inData.length() == 0) {
				inData = scan.nextLine();
				inData = inData.toLowerCase();

				if (inData.equals("j")) {
					ret = true;
					isIndata = true;
				}

				if (inData.equals("n")) {
					ret = false;
					isIndata = true;
				}

				if (!isIndata) {
					System.out.println("ogiltigt val, försök igen!");
					// stannar kvar i whileloopen
					inData = "";
				}
			}

		}

		return ret;
	}

	static float inputFloat(String promtfloat, int min, int max) {

		float inData = 0f;
		boolean isIndata = false;
		boolean isError = false;
		String sv = "";
		{
			System.out.println("Använd decimalkomma");
			System.out.println(promtfloat);
			Scanner scan = new Scanner(System.in);

			while (!isIndata) {
				try {
					sv = scan.nextLine();
					sv = sv.replace(',', '.');
					inData = Float.parseFloat(sv);

					;
				} catch (Exception ex) {

					System.out.println("Använd decimalkomma");
					isError = true;
					{
						isError = true;
					}

				}

				if (((float) inData < (float) min) || ((float) inData > (float) max) || (isError)) {
					System.out.println("ogiltigt val, försök igen!");
					// stannar kvar i whileloopen
					isError = false;

				} else
					isIndata = true;
			}
			// scan.close();
		}

		return inData;

	}

}
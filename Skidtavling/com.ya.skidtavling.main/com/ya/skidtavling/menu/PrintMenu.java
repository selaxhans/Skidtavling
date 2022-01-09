package com.ya.skidtavling.menu;

public class PrintMenu {
	/*
	 * Versionskommentarer 1.01
	 * kodst�dning formatering
	 */
	
	public static void printWelcomeBox() {

		System.out.println("�---------------�------------------�");
		System.out.println("|      V�lkommen till denna        |");
		System.out.println("|           Skidt�vling            |");
		System.out.println("|                         ver 1.01 |");
		System.out.println("�---------------�------------------�");
	}

	public static void printMenu() {
		
			System.out.println("\nG�r ett av valen:\n"
				+ "0. Avsluta.\n"
				+ "1. T�vling undermeny setup/hantera mm\n"
				+ "2. Deltagare. fr�n fil eller manuell \n"
				+ "3. S�k en Deltagare.\n"
				+ "4. Skriv ut Startlista.\n"
				+ "5. Starta T�vling.\n" 
				+ "6. Manuell tidsregistrering.\n" 
				+ "7. Skriv ut Resultattavla.\n" 
				+ "8. Skriv ut Vinnarna 1-3.\n"
				+ "9. Skriv ut Avbrutna t�vlande.\n"
				);
	}
	public static void printByeByeBox() {

		System.out.println("�---------------�------------------�");
		System.out.println("|      Tack och V�lkommen          |");
		System.out.println("|         �ter, Hej D�!            |");
		System.out.println("�---------------�------------------�");
	}
	
	public static void SubMenu()
	{	

		// TODO Auto-generated method stub
		System.out.println("\t\tMENY v�lj funktion en av nedanst�ende ange nummer");
		System.out.println("\t\t0. Tillbaks Huvudmeny");
		System.out.println("\t\t1.Ny t�vling");
		System.out.println("\t\t2.Lista T�vlingsdata");
		System.out.println("\t\t3.Spara T�vling p� disk ...");
		System.out.println("\t\t4.�ppna t�vlingsdata fr�n fil..");
		System.out.println("\t\t5.L�gga  f�rsta starttid");
		System.out.println("\t\t6.�ndra deltagarantal");
		System.out.println("\t\t7.Lista loggfil p� konsolen");
		System.out.println("\t\t8.Nollst�ll Loggfil");
		System.out.println("\t\t9.Flytta m�tpunkt mellantider");
		System.out.println("\t\t10.�ndra Sp�rl�ngd");
		System.out.println("\t\t11.�ndra Startmetod");
		System.out.println("\t\t12.Visa Meny");
	
	
}
}

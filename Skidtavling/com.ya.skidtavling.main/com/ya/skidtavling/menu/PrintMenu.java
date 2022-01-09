package com.ya.skidtavling.menu;

public class PrintMenu {
	/*
	 * Versionskommentarer 1.01
	 * kodstädning formatering
	 */
	
	public static void printWelcomeBox() {

		System.out.println("¤---------------¤------------------¤");
		System.out.println("|      Välkommen till denna        |");
		System.out.println("|           Skidtävling            |");
		System.out.println("|                         ver 1.01 |");
		System.out.println("¤---------------¤------------------¤");
	}

	public static void printMenu() {
		
			System.out.println("\nGör ett av valen:\n"
				+ "0. Avsluta.\n"
				+ "1. Tävling undermeny setup/hantera mm\n"
				+ "2. Deltagare. från fil eller manuell \n"
				+ "3. Sök en Deltagare.\n"
				+ "4. Skriv ut Startlista.\n"
				+ "5. Starta Tävling.\n" 
				+ "6. Manuell tidsregistrering.\n" 
				+ "7. Skriv ut Resultattavla.\n" 
				+ "8. Skriv ut Vinnarna 1-3.\n"
				+ "9. Skriv ut Avbrutna tävlande.\n"
				);
	}
	public static void printByeByeBox() {

		System.out.println("¤---------------¤------------------¤");
		System.out.println("|      Tack och Välkommen          |");
		System.out.println("|         Åter, Hej Då!            |");
		System.out.println("¤---------------¤------------------¤");
	}
	
	public static void SubMenu()
	{	

		// TODO Auto-generated method stub
		System.out.println("\t\tMENY välj funktion en av nedanstående ange nummer");
		System.out.println("\t\t0. Tillbaks Huvudmeny");
		System.out.println("\t\t1.Ny tävling");
		System.out.println("\t\t2.Lista Tävlingsdata");
		System.out.println("\t\t3.Spara Tävling på disk ...");
		System.out.println("\t\t4.Öppna tävlingsdata från fil..");
		System.out.println("\t\t5.Lägga  första starttid");
		System.out.println("\t\t6.Ändra deltagarantal");
		System.out.println("\t\t7.Lista loggfil på konsolen");
		System.out.println("\t\t8.Nollställ Loggfil");
		System.out.println("\t\t9.Flytta mätpunkt mellantider");
		System.out.println("\t\t10.Ändra Spårlängd");
		System.out.println("\t\t11.Ändra Startmetod");
		System.out.println("\t\t12.Visa Meny");
	
	
}
}

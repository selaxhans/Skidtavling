package com.ya.skidtavling.main;

import com.ya.skidtavling.competitions.Competitions;
import com.ya.skidtavling.menu.Menu;

public class Main {
	/*
	 * Denna version Har förutom senaste tillägg av logglista även med händelser som
	 * kan inträffa under tävling inclusive konsekvenser
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {

		Competitions tavl = new Competitions();

		Menu menu = new Menu(); // instans för meny klassen
		menu.runMenu(tavl); // kallar på runMenu klassen som skriver ut välkommen rutan och sedan valen

	}
}

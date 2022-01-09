package com.ya.skidtavling.main;

import com.ya.skidtavling.competitions.Competitions;
import com.ya.skidtavling.menu.Menu;

public class Main {
	/*
	 * Denna version Har f�rutom senaste till�gg av logglista �ven med h�ndelser som
	 * kan intr�ffa under t�vling inclusive konsekvenser
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {

		Competitions tavl = new Competitions();

		Menu menu = new Menu(); // instans f�r meny klassen
		menu.runMenu(tavl); // kallar p� runMenu klassen som skriver ut v�lkommen rutan och sedan valen

	}
}

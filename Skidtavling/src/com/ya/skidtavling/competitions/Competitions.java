package com.ya.skidtavling.competitions;

import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

//Competitions.java
public class Competitions {
	/*
	 * default arbetskatalog skulle kunna läggas till..
	 */

	/**
	 * @param forHandsanmalanKrav the forHandsanmalanKrav to set
	 */
	public void setForHandsanmalanKrav(boolean forHandsanmalanKrav) {
		this.forHandsanmalanKrav = forHandsanmalanKrav;
	}

	/**
	 * @param tavlingsnamn the tavlingsnamn to set
	 */
	public void setTavlingsnamn(String tavlingsnamn) {
		this.tavlingsnamn = tavlingsnamn;
	}

	/**
	 * @param startmetod the startmetod to set
	 */
	public void setStartmetod(int startmetod) {
		this.startmetod = startmetod;
	}

	/**
	 * @param fixedStartnbr the fixedStartnbr to set
	 */
	public void setFixedStartnbr(int fixedStartnbr) {
		this.fixedStartnbr = fixedStartnbr;
	}

	/**
	 * @param sistaAnmalningsdatum the sistaAnmalningsdatum to set
	 */
	public void setSistaAnmalningsdatum(long sistaAnmalningsdatum) {
		this.sistaAnmalningsdatum = sistaAnmalningsdatum;
	}

	/**
	 * @param maxAntalstartande the maxAntalstartande to set
	 */
	public void setMaxAntalstartande(int maxAntalstartande) {
		this.maxAntalstartande = maxAntalstartande;
	}

	/**
	 * @param forstaStartPlanned the forstaStartPlanned to set
	 */
	public void setForstaStartPlanned(long forstaStartPlanned) {
		this.forstaStartPlanned = forstaStartPlanned;
	}

	/**
	 * @param forstaStartVerklig the forstaStartVerklig to set
	 */
	public void setForstaStartVerklig(long forstaStartVerklig) {
		this.forstaStartVerklig = forstaStartVerklig;
	}

	/**
	 * @param startIntervall the startIntervall to set
	 */
	public void setStartIntervall(int startIntervall) {
		this.startIntervall = startIntervall;
	}

	/**
	 * @param nbrStart the nbrStart to set
	 */
	public void setNbrStart(int nbrStart) {
		this.nbrStart = nbrStart;
	}

	/**
	 * @param nbrSlut the nbrSlut to set
	 */
	public void setNbrSlut(int nbrSlut) {
		this.nbrSlut = nbrSlut;
	}

	/**
	 * @param simTidtagning the simTidtagning to set
	 */
	public void setSimTidtagning(boolean simTidtagning) {
		this.simTidtagning = simTidtagning;
	}

	/**
	 * @param senUppd the senUppd to set
	 */
	public void setSenUppd() {
		LocalDate idag = LocalDate.now();

		this.senUppd = idag.toString();
	}

	/**
	 * @param haschKod the haschKod to set
	 */
	public void setHaschKod(String haschKod) {
		this.haschKod = haschKod;
	}

	/**
	 * @param forHandsanmalanKrav
	 * @param tavlingsnamn
	 * @param startmetod
	 * @param fixedStartnbr
	 * @param sistaAnmalningsdatum
	 * @param maxAntalstartande
	 * @param forstaStartPlanned
	 * @param forstaStartVerklig
	 * @param startIntervall
	 * @param nbrStart
	 * @param nbrSlut
	 * @param simTidtagning
	 * @param senUppd
	 * @param haschKod
	 */
	private Competitions(boolean forHandsanmalanKrav, String tavlingsnamn, int startmetod, int fixedStartnbr,
			long sistaAnmalningsdatum, int maxAntalstartande, long forstaStartPlanned, long forstaStartVerklig,
			int startIntervall, int nbrStart, int nbrSlut, boolean simTidtagning, String senUppd, String haschKod) {
		super();
		this.forHandsanmalanKrav = forHandsanmalanKrav;
		this.tavlingsnamn = tavlingsnamn;
		this.startmetod = startmetod;
		this.fixedStartnbr = fixedStartnbr;
		this.sistaAnmalningsdatum = sistaAnmalningsdatum;
		this.maxAntalstartande = maxAntalstartande;
		this.forstaStartPlanned = forstaStartPlanned;
		this.forstaStartVerklig = forstaStartVerklig;
		this.startIntervall = startIntervall;
		this.nbrStart = nbrStart;
		this.nbrSlut = nbrSlut;
		this.simTidtagning = simTidtagning;
		this.senUppd = senUppd;
		this.haschKod = haschKod;
	}

	private boolean forHandsanmalanKrav; // * krav på förhandsanmälan == här: inläst lista är alla
	private String tavlingsnamn; // marknadsföringsnamn

	private int startmetod; // * kod för startmetod koder

	// =1 ; masstart
	// =2 ; jaktstart
	// =3 ; individuell start startintevall
	// =4 ; Random start lottad startordning

//		I första hand tänks variabler med //* markering hårkodas till fixerat editerbart värde medan övriga
//		ges möjlighet att via menyn variera.

	private int fixedStartnbr; // * Antaled anmälda startande.
	private long sistaAnmalningsdatum; // Java time hourmin,sista anmälan för deltagare;

	private int maxAntalstartande; // * deltagarantal max
	private long forstaStartPlanned; // Java time hourmin, first or only start time;
	private long forstaStartVerklig;// förvald datum tid för förstatart
	private int startIntervall; // in seconds for indiv,random startorder

	private int nbrStart; // * nummerserie startnummer "nummerlappar start nyckel till deltagare under
	private int nbrSlut; // * sista nummer i sviten nummerlappar tävling genom läsbarhet etc.
	private boolean simTidtagning; // för test och utvärdering all manuell tidtagning ersatt med metod för
									// slumpad tidtagning;
	private String senUppd; // senaste uppdatering av posten string format.
	private String haschKod; // post check; integritet.
	private int statuskod; // används för att hantera ordningsföljden av åtgärder;
	/*
	 * = 0 inga register laddade, deltagare kan inte laddas innan tävling skapats
	 * eller laddats submeny alt 1. = 1 tävling skapad och laddad.Nu kan/ skall
	 * starttid ev justeras och deltagare laddas; =2 deltagare laddade eller
	 * manuellt inlagda nu kan startlista skrivas och frågor göras på deltagare. = 3
	 * Startlista utskriven, nu kan tävling startas = 4 tävling starad och pågår = 5
	 * tävling avslutad, alla i mål (incidenter ej inlagda ) nu kan resultatlistor
	 * och prispall plockas fram..
	 */
	public Incidents ins;

	public int getSparLangd() {
		return sparLangd;
	}

	public void setSparLangd(int sparLangd) {
		this.sparLangd = sparLangd;
	}

	public int getPlaceMellantid() {
		return placeMellantid;
	}

	public void setPlaceMellantid(int placeMellantid) {
		this.placeMellantid = placeMellantid;
	}

	private int sparLangd; // spårlängd i 10-tal meter
							// rimlig åkarhastighet ca 100m på 15 sek;
	private int placeMellantid; // mätplats mellantid %*100 av spårlängd def 50;

	public Incidents getIns() {
		return ins;
	}

	public void setIns(Incidents ins) {
		this.ins = ins;
	}

	public int getStatuskod() {
		return statuskod;
	}

	public void setStatuskod(int statuskod) {
		this.statuskod = statuskod;
	}

	/**
	 * 
	 */
	public Competitions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the forHandsanmalanKrav
	 */
	public boolean isForHandsanmalanKrav() {
		return forHandsanmalanKrav;
	}

	/**
	 * @return the tavlingsnamn
	 */
	public String getTavlingsnamn() {
		return tavlingsnamn;
	}

	/**
	 * @return the sista_anmalningsdatum
	 */
	public String getSistaAnmalningsdatum() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(sistaAnmalningsdatum);

		String dettadatum = df.format(date);

		return dettadatum;
	}

	/**
	 * @return the startmetod
	 */
	public int getStartmetod() {
		return startmetod;
	}

	/**
	 * @return the fixedStartnbr
	 */
	public int getFixedStartnbr() {
		return fixedStartnbr;
	}
	/**
	 * @return the sistaAnmalningsdatum
	 */
//		public long getSistaAnmalningsdatum() {

//			return sistaAnmalningsdatum;
//		}
	/**
	 * @return the maxAntalstartande
	 */
	public int getMaxAntalstartande() {
		return maxAntalstartande;
	}

	/**
	 * @return the forstaStartPlanned
	 */
	public String getForstaStartPlanned() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(forstaStartPlanned);

		String dettadatum = df.format(date);

		return dettadatum;

	}

	/**
	 * @return the forstaStartVerklig
	 */
	public String getForstaStartVerklig() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(forstaStartVerklig);

		String dettadatum = df.format(date);

		return dettadatum;

	}

	/**
	 * @return the startIntervall
	 */
	public int getStartIntervall() {
		return startIntervall;
	}

	/**
	 * @return the nbrStart
	 */
	public int getNbrStart() {
		return nbrStart;
	}

	/**
	 * @return the nbrSlut
	 */
	public int getNbrSlut() {
		return nbrSlut;
	}

	/**
	 * @return the simTidtagning
	 */
	public boolean isSimTidtagning() {
		return simTidtagning;
	}

	/**
	 * @return the senUppd
	 */
	public String getSenUppd() {

		return senUppd;
	}

	/**
	 * @return the haschKod
	 */
	public String getHaschKod() {
		return haschKod;
	}

	@Override
	public String toString() {
		return "Competitions [forHandsanmalanKrav=" + forHandsanmalanKrav + ", tavlingsnamn=" + tavlingsnamn
				+ "startmetod=" + startmetod + "\n" + ", fixedStartnbr=" + fixedStartnbr + ", sistaAnmalningsdatum="
				+ sistaAnmalningsdatum + ", maxAntalstartande=" + maxAntalstartande + ", forstaStartPlanned="
				+ forstaStartPlanned + ", forstaStartVerklig=" + forstaStartVerklig + ", startIntervall="
				+ startIntervall + "\n" + ", nbrStart=" + nbrStart + ", nbrSlut=" + nbrSlut + ", simTidtagning="
				+ simTidtagning + ", senUppd=" + senUppd + ", haschKod=" + haschKod + "=";
	}

}

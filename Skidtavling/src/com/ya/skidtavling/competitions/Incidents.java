package com.ya.skidtavling.competitions;

public class Incidents {

	/**
	 * @return the isnewIncident
	 */
	public boolean isIsnewIncident() {
		return isnewIncident;
	}

	/**
	 * @param isnewIncident the isnewIncident to set
	 */
	public void setIsnewIncident(boolean isnewIncident) {
		this.isnewIncident = isnewIncident;
	}

	/**
	 * @return the insidentBeskrivning
	 */
	public String getInsidentBeskrivning() {
		return insidentBeskrivning;
	}

	/**
	 * @param insidentBeskrivning the insidentBeskrivning to set
	 */
	public void setInsidentBeskrivning(String insidentBeskrivning) {
		this.insidentBeskrivning = insidentBeskrivning;
	}

	/**
	 * @return the konsekvensKod
	 */
	public int getKonsekvensKod() {
		return konsekvensKod;
	}

	/**
	 * @param konsekvensKod the konsekvensKod to set
	 */
	public void setKonsekvensKod(int konsekvensKod) {
		this.konsekvensKod = konsekvensKod;
	}

	/**
	 * @return the isTavlingsrelated
	 */
	public boolean isTavlingsrelated() {
		return isTavlingsrelated;
	}

	/**
	 * @param isTavlingsrelated the isTavlingsrelated to set
	 */
	public void setTavlingsrelated(boolean isTavlingsrelated) {
		this.isTavlingsrelated = isTavlingsrelated;
	}

	/**
	 * @return the proabilityKod
	 */
	public int getProabilityKod() {
		return proabilityKod;
	}

	/**
	 * @param proabilityKod the proabilityKod to set
	 */
	public void setProabilityKod(int proabilityKod) {
		this.proabilityKod = proabilityKod;
	}

	/**
	 * @return the forvantatAntalanrop
	 */
	public int getForvantatAntalanrop() {
		return forvantatAntalanrop;
	}

	/**
	 * @param forvantatAntalanrop the forvantatAntalanrop to set
	 */
	public void setForvantatAntalanrop(int forvantatAntalanrop) {
		this.forvantatAntalanrop = forvantatAntalanrop;
	}

	/**
	 * @return the anropsCnt
	 */
	public int getAnropsCnt() {
		return anropsCnt;
	}

	/**
	 * @param anropsCnt the anropsCnt to set
	 */
	public void setAnropsCnt(int anropsCnt) {
		this.anropsCnt = anropsCnt;
	}

	/**
	 * @return the totalanropscnt
	 */
	public int getTotalanropscnt() {
		return totalanropscnt;
	}

	/**
	 * @param totalanropscnt the totalanropscnt to set
	 */
	public void setTotalanropscnt(int totalanropscnt) {
		this.totalanropscnt = totalanropscnt;
	}

	/**
	 * @return the anropsIntervall
	 */
	public int getAnropsIntervall() {
		return anropsIntervall;
	}

	/**
	 * @param anropsIntervall the anropsIntervall to set
	 */
	public void setAnropsIntervall(int anropsIntervall) {
		this.anropsIntervall = anropsIntervall;
	}

	/**
	 * @return the insidentAntal
	 */
	public int getInsidentAntal() {
		return insidentAntal;
	}

	/**
	 * @param insidentAntal the insidentAntal to set
	 */
	public void setInsidentAntal(int insidentAntal) {
		this.insidentAntal = insidentAntal;
	}

	/**
	 * @return the antIncidentFall
	 */
	public int getAntIncidentFall() {
		return antIncidentFall;
	}

	/**
	 * @param antIncidentFall the antIncidentFall to set
	 */
	public void setAntIncidentFall(int antIncidentFall) {
		this.antIncidentFall = antIncidentFall;
	}

	/**
	 * @return the insidentKod
	 */
	public int getInsidentKod() {
		return insidentKod;
	}

	/**
	 * @param insidentKod the insidentKod to set
	 */
	public void setInsidentKod(int insidentKod) {
		this.insidentKod = insidentKod;
	}

	/**
	 * 
	 */
	public Incidents() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isnewIncident
	 * @param insidentBeskrivning
	 * @param konsekvensKod
	 * @param isTavlingsrelated
	 * @param proabilityKod
	 * @param forvantatAntalanrop
	 * @param anropsCnt
	 * @param totalanropscnt
	 * @param anropsIntervall
	 * @param insidentAntal
	 * @param antIncidentFall
	 * @param insidentKod
	 */
	private Incidents(boolean isnewIncident, String insidentBeskrivning, int konsekvensKod, boolean isTavlingsrelated,
			int proabilityKod, int forvantatAntalanrop, int anropsCnt, int totalanropscnt, int anropsIntervall,
			int insidentAntal, int antIncidentFall, int insidentKod) {
		super();
		this.isnewIncident = isnewIncident;
		this.insidentBeskrivning = insidentBeskrivning;
		this.konsekvensKod = konsekvensKod;
		this.isTavlingsrelated = isTavlingsrelated;
		this.proabilityKod = proabilityKod;
		this.forvantatAntalanrop = forvantatAntalanrop;
		this.anropsCnt = anropsCnt;
		this.totalanropscnt = totalanropscnt;
		this.anropsIntervall = anropsIntervall;
		this.insidentAntal = insidentAntal;
		this.antIncidentFall = antIncidentFall;
		this.insidentKod = insidentKod;
	}

	boolean isnewIncident; // ny incident
	String insidentBeskrivning; // textbeskrivning
	int konsekvensKod; // inträffad incident skall medföra
	boolean isTavlingsrelated; // incidenten är allmän, berör samtliga tävlande
	int proabilityKod; // kod för sannolikhet att incdent denna typ inträffar normal tävling
	int forvantatAntalanrop; // förväntat antal förfrågningar denna tävling
	int anropsCnt; // räknare ordningsnummer senaste anrop
	int totalanropscnt; // total räknare
	int anropsIntervall; // beräknat intervall för skapande av incident
	int insidentAntal; // Antal genererade incidenter
	int antIncidentFall; // antalet läst poster
	int insidentKod;

	@Override
	public String toString() {
		return "Incidents [isnewIncident=" + isnewIncident + ", insidentBeskrivning=" + insidentBeskrivning
				+ ", konsekvensKod=" + konsekvensKod + ", isTavlingsrelated=" + isTavlingsrelated + ", proabilityKod="
				+ proabilityKod + ", forvantatAntalanrop=" + forvantatAntalanrop + ", anropsCnt=" + anropsCnt
				+ ", totalanropscnt=" + totalanropscnt + ", anropsIntervall=" + anropsIntervall + ", insidentAntal="
				+ insidentAntal + ", antIncidentFall=" + antIncidentFall + ", insidentKod=" + insidentKod + "]";
	}

	public String toString(int x) {
		return "Incidents [isnewincident=" + isnewIncident + ", konsekvensKod=" + konsekvensKod + ", isTavlingsrelated="
				+ isTavlingsrelated + ", forvantatAntalanrop=" + forvantatAntalanrop + ", anropsCnt=" + anropsCnt
				+ ", anropsIntervall=" + anropsIntervall + ", insidentAntal=" + insidentAntal + ", antIncidentFall="
				+ antIncidentFall + "]";

//	Kodförklaringar:
//		konsekvenskod		1->Tidstilägg; enskild åkare saktar ner
//							2->uteslutning ur tävlingen diskvalificerad
//							3->Sjukvård utgår ur tävlingen
//							4->kollektiv fartminskning berör samtliga tex snöyra
//							5->Stillastående en period av betydelse
//	
//	
//	
//Kodförklaring sannolikheter för detta testcase Gissad sannolikhet att en sådan incint intäffar under en tävling, ej Vasalopp.
//							1-> 90% antas ske varje lopp
//							2-> 20% ca vart femte
//							3-> 10 % vart tionde
//							4-> 5% 
//							5-> 1 %
//							6-> 0,1 % ytterst sällan 
	}
}
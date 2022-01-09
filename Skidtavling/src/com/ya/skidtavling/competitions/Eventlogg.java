package com.ya.skidtavling.competitions;

import java.util.*;

public class Eventlogg {
	@Override
	public String toString() {
		return "Nr:" + eventID + ", Tid:" + handelsetidpunkt + ", Kod:" + eventkod + ", beskr.:" + eventdescr
				+ ", Rapportör:" + eventsrce + ", Inblandad:" + eventobj;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventID, eventdescr, eventkod, eventobj, eventsrce, handelsetidpunkt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eventlogg other = (Eventlogg) obj;
		return eventID == other.eventID && Objects.equals(eventdescr, other.eventdescr) && eventkod == other.eventkod
				&& Objects.equals(eventobj, other.eventobj) && eventsrce == other.eventsrce
				&& Objects.equals(handelsetidpunkt, other.handelsetidpunkt);
	}

	/**
	 * @return the eventID
	 */
	public int getEventID() {
		return eventID;
	}

	/**
	 * @param eventID the eventID to set
	 */
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	/**
	 * @return the handelsetidpunkt
	 */
	public String getHandelsetidpunkt() {
		return handelsetidpunkt;
	}

	/**
	 * @param handelsetidpunkt the handelsetidpunkt to set
	 */
	public void setHandelsetidpunkt(String handelsetidpunkt) {
		this.handelsetidpunkt = handelsetidpunkt;
	}

	/**
	 * @return the eventkod
	 */
	public int getEventkod() {
		return eventkod;
	}

	/**
	 * @param eventkod the eventkod to set
	 */
	public void setEventkod(int eventkod) {
		this.eventkod = eventkod;
	}

	/**
	 * @return the eventdescr
	 */
	public String getEventdescr() {
		return eventdescr;
	}

	/**
	 * @param eventdescr the eventdescr to set
	 */
	public void setEventdescr(String eventdescr) {
		this.eventdescr = eventdescr;
	}

	/**
	 * @return the eventsrce
	 */
	public int getEventsrce() {
		return eventsrce;
	}

	/**
	 * @param eventsrce the eventsrce to set
	 */
	public void setEventsrce(int eventsrce) {
		this.eventsrce = eventsrce;
	}

	/**
	 * @return the eventobj
	 */
	public String getEventobj() {
		return eventobj;
	}

	/**
	 * @param eventobj the eventobj to set
	 */
	public void setEventobj(String eventobj) {
		this.eventobj = eventobj;
	}

	/**
	 * 
	 */
	Eventlogg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param eventID
	 * @param handelsetidpunkt
	 * @param eventkod
	 * @param eventdescr
	 * @param eventsrce
	 * @param eventobj
	 */
	private Eventlogg(int eventID, String handelsetidpunkt, int eventkod, String eventdescr, int eventsrce,
			String eventobj) {
		super();
		this.eventID = eventID;
		this.handelsetidpunkt = handelsetidpunkt;
		this.eventkod = eventkod;
		this.eventdescr = eventdescr;
		this.eventsrce = eventsrce;
		this.eventobj = eventobj;
	}

	int eventID; // postsekvensnummer;
	String handelsetidpunkt; // tidpunkt på alternaivi format YYYY:MM:DD hh:mm:ss
	int eventkod; // händelsetyp
	String eventdescr; // verbose description
	int eventsrce; // källa till rapportering
	String eventobj; // optional berörd åkare, funktionär; berörd deltagarID;

}

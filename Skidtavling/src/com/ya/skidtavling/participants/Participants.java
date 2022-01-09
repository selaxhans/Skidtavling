package com.ya.skidtavling.participants;

import com.ya.skidtavling.person.Person;
import com.ya.skidtavling.time.Time;

public class Participants extends Person {
	// egenskaperna för klassen Participants
	public int participantNumber;
	private int place;
	/*
	 * Tid /hast mm i det simulerade loppet är tidräkningen baserad på enheten 15
	 * sekunder och hast är den sträcka löparen hinner på 15 sek. all tid räknas
	 * således i 15 sekunders steg;
	 * 
	 */

	public int runTime; // redefined to run time
	public int middleTime;

	public int getMiddleTime() {
		return middleTime;
	}

	public void setMiddleTime(int middleTime) {
		this.middleTime = middleTime;
	}

	public String indivStarTime; // time in string format.
	public int indivtidoffset; // antal sekunder som int.

	public int getIndivtidoffset() {
		return indivtidoffset;
	}

	public void setIndivtidoffset(int indivtidoffset) {
		this.indivtidoffset = indivtidoffset;
	}

	public String getIndivStarTime() {
		return indivStarTime;
	}

	public void setIndivStarTime(String indivStarTime) {
		this.indivStarTime = indivStarTime;
	}

	private int distance;
	private boolean notFinished;
	private boolean passedMiddle;
	private boolean isExpelled; // utesluten ur tävlingen

	public boolean isExpelled() {
		return isExpelled;
	}

	public void setExpelled(boolean isExpelled) {

		this.isExpelled = isExpelled;
	}

	public Participants(String forName, String lastName, int place, int participantNumber) {
		super(forName, lastName);
		this.place = place;
		this.participantNumber = participantNumber;

	}

	public Participants(int participantNumber, String forName, String lastName, int place, int startTime,
			int middletime, String indivStarTime, int distance, boolean notFinished, boolean passedMiddle) {
		super(forName, lastName);
		this.participantNumber = participantNumber;
		this.place = place;
		this.runTime = startTime;
		this.indivtidoffset = 0;
		this.indivStarTime = "  ";

		this.distance = distance;
		this.notFinished = notFinished;
		this.passedMiddle = passedMiddle;

	}

	public boolean isNotFinished() {
		return notFinished;
	}

	public void setNotFinished(boolean notFinished) {
		this.notFinished = notFinished;
	}
	// används den här ??

	@Override
	public String toString() {

		String arUtgatt = "nej";
		if (isExpelled)
			arUtgatt = "ja";

		return participantNumber + " " + forName + " " + lastName + "" + "\t place=" + place + " :  " + runTime
				+ "  :  " + middleTime + " har kommit : " + distance + "\tutgått " + arUtgatt;

	}

	public int getParticipantNumber() {
		// System.out.println(participantNumber);
		return participantNumber;
	}

	public void setParticipantNumber(int participantNumber) {
		this.participantNumber = participantNumber;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public int getStartTime() {
		return runTime;
	}

	public void setStartTime(int startTime) {
		this.runTime = startTime;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isPassedMiddle() {
		return passedMiddle;
	}

	public void setPassedMiddle(boolean passedMiddle) {
		this.passedMiddle = passedMiddle;
	}

}
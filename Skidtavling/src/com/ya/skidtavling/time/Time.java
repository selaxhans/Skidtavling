package com.ya.skidtavling.time;

public  class Time {
	// kommentar
	// 1 hour = 3600 secunder
	// 1 min = 60 secunder;
	
	private long sec;

	public Time(long sec) {
		super();
		this.setSec(sec);
	}

	public long getSec() {
		return sec;
	}
	// kanske skall ändra denna 
	@Override
	public String toString() {
		
		int temp=0;
		int hour =0;
		int min =0;
		int secu = 0;
		temp = (int) sec;
		hour =0;
	
		hour = temp/3600;
		temp = temp-hour*3600;
		min = temp/60;
		temp = temp-min*60;
		secu = temp;
		return " time "+hour+" :" + min +" :"+ secu ;
	}

	public void setSec(long sec) {
		this.sec = sec;
	}
	


	
}
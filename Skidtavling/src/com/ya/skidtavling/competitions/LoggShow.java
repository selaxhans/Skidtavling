package com.ya.skidtavling.competitions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class LoggShow {



	public static boolean showlogglista() {
		String srcepath = "tavlingslogg.txt";
		boolean isOK;
		
		int PostID =1;
		boolean atend = false;		// TODO Auto-generated method stub
		System.out.println("Utfört på gång...");
		int postant = Filio.getFilesize(srcepath);
		System.out.println("postantal"+postant);
		Eventlogg[] events = new Eventlogg[postant];
		for (int k=0; k<postant; k++)
		{
			Eventlogg event = new Eventlogg();
			events[k] = event; 
		}			
		
		{
					
				{
					String line="";
					int i=1;
					try
					{
						var instrom = new BufferedReader
									(new FileReader(srcepath));
					while (line != null)
					{
						line = instrom.readLine();
					//	System.out.println(line + i);
						if (line !=null) {
						Eventlogg event = new Eventlogg();
						event = loadparam(events[i-1],line,i);
						events[i-1]= event;
						
						}
						i++;
						
					}
					instrom.close();
					i=i-2;
					System.out.println("post i"+i);
					}
					catch (Exception ex)
					{
						System.out.println("Tom lista eller Fel vid filläsning !!");
						return false;
					}
					int l =0;
					for (int k=0; k<i; k++, l++)
					{
						System.out.println(events[k].toString());
						if (l == 19)
						{
							Input.inputEnter("visa fler 'enter'");	
							l = 0;
						}
				
						
					}
		
		Input.inputEnter("återvänd menyn 'enter'");
					
					
					
					
					
					//event = loadparam(event,line,PostID);
				}
		}
	
		
					return true;	
					}
					
private static Eventlogg loadparam(Eventlogg event,String row,int pid)
					{
//						for(int i =0; (i<12); i++){
					
//							
//							pend = inD[i].indexOf(e);
//							pend = pend-1;
//							param = inD[i].substring(4,pend);
	
							String[] item = new String[12];
							item = row.split(";");
							int wint =0;  //wor output from parse;
							int i =0;
							for (i=0; i < 10; i++)
//							{
//								System.out.println(i+ item[i]);
//							}
//							this.eventID = eventID;
//							this.handelsetidpunkt = handelsetidpunkt;
//							this.eventkod = eventkod;
//							this.eventdescr = eventdescr;
//							this.eventsrce = eventsrce;
//							this.eventobj = eventobj;							
					
							switch (i)
							{
							//postid
							case 0: event.setEventID(pid);break;
							//tidpunkt som string
							case 1:	event.setHandelsetidpunkt(item[1].trim());break;
							//	faltid	
							case 2:break;
							//startmetod
							case 3:{ wint = getint(item[3]);						
							 event.setEventkod(wint);};break;
							case 4:break;
							case 5:event.setEventdescr(item[5].trim());break;
							case 6:break;
							case 7:{ wint = getint(item[7]);}
									event.setEventsrce(wint);break;
							case 8:break;
							case 9:event.setEventobj(item[9].trim());break;
							}
//							System.out.println(event.toString());
							return event;
							}
							

//					
//					System.out.println("fildata från datum  " + info + " har laddats");
//						return true;
//			}
//
private static int getint(String param) {
	int x;
	
	param = param.trim();
	
	
	try
	{
		x = Integer.parseInt(param);
	}
	catch (Exception f)
	{
	System.out.println("formatfel i fldata");
	x=0;
	}

	return x;
	
}
	



	
	
}

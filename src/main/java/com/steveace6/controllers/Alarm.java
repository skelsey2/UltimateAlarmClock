package com.steveace6.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



public class Alarm extends TimerTask{
	
	private String vlcLocation = "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe";
	private static String vlcFilePath = "";
//	= "C:\\Users\\Steve_Revature\\Documents\\Miracle_of_Self_discipline.mp3";
	
	public void run() {
		System.out.println("starting VLC in Location: " + vlcLocation);
		System.out.println("starting VLC File: " + vlcFilePath);
		ProcessBuilder pb = new ProcessBuilder(vlcLocation,vlcFilePath );
		try {
			Process start = pb.start();
			System.out.println("Video Playing");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setAlarmClock(String hour, String minute){
			// the Date and time at which you want to execute
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			try { 
				Date date = dateFormatter.parse(LocalDate.now() + " " + hour +":"  + minute +":02");
				
				// Now create the time and schedule it
				Timer timer = new Timer();

				// Use this if you want to execute it once
				timer.schedule(new Alarm(), date);

				// Use this if you want to execute it repeatedly
				// int period = 10000;//10secs
				// timer.schedule(new MyTimeTask(), date, period );
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}

	public String getVlcFilePath() {
		return vlcFilePath;
	}

	public static void setVlcFilePath(String vlcFilePathString) {
		vlcFilePath = vlcFilePathString;
	}


}

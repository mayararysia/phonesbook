package com.phonesbook.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConverter {
	/*Converte tipo Date para tipo String*/
	public static String dateTypeToString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(date);
		
		return formattedDate;
	}
	
	/*Converte tipo String para tipo Date*/
	public static Date stringTypeToDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = formatter.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/*Ano corrente:*/
	public static Integer currentYear() {
		Calendar calendar = GregorianCalendar.getInstance();
		
		return calendar.get(Calendar.YEAR);
	}
	
	/*Converte time do tipo String para Date*/
	public static Date stringTypeToTime(String time) {
		Date hour = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
			hour = formatter.parse(time);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hour;
	}
	
	/*Converte time do tipo Date para String*/
	public static String timeTypeToString(Date time) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		String hour = formatter.format(time);
		return hour;
	}
	
	
}

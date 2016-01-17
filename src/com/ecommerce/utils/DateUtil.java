package com.ecommerce.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date 2015-12-12
 * @author HERO
 * @TODO 时间工具类，获得系统当前时间戳，将时间戳转化为"yyyy-MM-dd"，将"yyyy-MM-dd"转化为时间戳
 * 		  此类中的时间戳（单位：秒）为实际时间戳（单位：毫秒）/ 1000 - 1400000000
 * 		  将"yyyy-MM-dd"转化为时间戳时 返货获得的时间戳 / 1000 - 1400000000
 * 		  将获得的时间戳转化为"yyyy-MM-dd"时 现将时间戳 * 1000 之后 + 1400000000 再进行转化
 */
public class DateUtil {
	
	static int time0 = 1400000000;
	
	public static int getLocationTime() {
		Date date = new Date();
		return (int) (date.getTime() / 1000 - time0);
	}
	
	public static String DateToString(int date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		long date1 = (long) date;
		String d = format.format((date1 + time0) * 1000);
		return d;
	}
	
	public static int StringToDate(String date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		Date d = format.parse(date);
		return (int) (d.getTime() / 1000 - time0);
	}
}

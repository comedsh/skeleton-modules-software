package com.fenghua.auto.backend.core.utills;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * 时间格式
 * @author chengbin
 *
 */
public class DateUtil {
private final static SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public static Date getNowDate() {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   String dateString = formatter.format(currentTime);
	   ParsePosition pos = new ParsePosition(8);
	   Date currentTime_2 = formatter.parse(dateString, pos);
	   return currentTime_2;
	}
	
	/**
	 * 获取今年年份
	 * @return
	 */
	public static int getThisYear(){
		Calendar calendar = Calendar.getInstance();
		return  calendar.get(Calendar.YEAR);
	}
	
	/**
	 * 获取去年年份
	 * @return
	 */
    public static int getLastYear(){
    	Calendar calendar = Calendar.getInstance();
    	calendar.add(Calendar.YEAR, -1);
    	return  calendar.get(Calendar.YEAR);
	}
    
    /**
     * 根据当前时间得到 三个月之内的时间段
     * @return Str[0],开始时间， Str[1] 结束时间
     */
    public static String[] getThreeMonthDate(){
    	String[] strs = new String[2];
    	Calendar nowCalendar = Calendar.getInstance();
    	long nowTime = nowCalendar.getTimeInMillis();
    	strs[1] = DEFAULT_FORMAT.format(new Date(nowTime));
    	
    	nowCalendar.add(Calendar.MONTH, -3);
    	nowCalendar.set(Calendar.DAY_OF_MONTH, 1);
    	
    	nowCalendar.set(Calendar.HOUR_OF_DAY, 0);
    	nowCalendar.set(Calendar.MINUTE, 0);
    	nowCalendar.set(Calendar.SECOND, 0);
    	nowCalendar.set(Calendar.MILLISECOND, 0);
    	
    	strs[0] = DEFAULT_FORMAT.format(new Date(nowCalendar.getTimeInMillis()));
    	
    	return strs;
    	
    }

	public static String[] getThisYearInterval() {
		String[] strs = new String[2];
		Calendar calendar = Calendar.getInstance();
		
		strs[1] = DEFAULT_FORMAT.format(new Date( calendar.getTimeInMillis()));
		
		calendar.set(Calendar.MONTH, 1);
		
		long min = getMinDate(calendar); 
		strs[0] = DEFAULT_FORMAT.format(new Date(min));
		return strs;
    	
	}
	
	
	public static String[] getLastYearInterval() {
		String[] strs = new String[2];
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		
		strs[1] = DEFAULT_FORMAT.format(new Date( calendar.getTimeInMillis()));
		
		calendar.set(Calendar.MONTH, 1);
		
		long min = getMinDate(calendar); 
		strs[0] = DEFAULT_FORMAT.format(new Date(min));
		return strs;
    	
	}

	public static long getMinDate(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);	
		
		return calendar.getTimeInMillis();
	}

	public static long getMaxDate(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 59);		
		return calendar.getTimeInMillis();
	}


}

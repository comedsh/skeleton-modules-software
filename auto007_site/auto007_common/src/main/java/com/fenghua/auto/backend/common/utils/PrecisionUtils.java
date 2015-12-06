package com.fenghua.auto.backend.common.utils;

import java.math.BigDecimal;

/** 
  *<des>
  *数字转换工具类
  *</des>
  * @author  lijie
  * @date 2015年11月30日
  * @version 
  */
public class PrecisionUtils {

	/**
	 * 保留两位小数
	 * @param value
	 * @return
	 */
	public static  double formatTwo(double value){		
		return format(value, 2);
	}
	
	/**
	 * 保留几位小数
	 * @param value
	 * @param scale
	 * @return
	 */
	public static  double format(double value , int scale){
		BigDecimal b= new BigDecimal(value);
		double  val = b.setScale(scale,   BigDecimal.ROUND_HALF_UP).doubleValue();  
		return val;
	}
	
	/**
	 * 百分比
	 * @param value
	 * @return
	 */
	public static  String formatPercent(double value){
		double  val = format(value, 2);
		return (val*100)+"%";
	}
}

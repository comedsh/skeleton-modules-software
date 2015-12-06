package com.fenghua.auto.backend.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 * @author chengbin
 * @createTime 2015.11.3
 *
 */
public class MD5Encoder {
	public final static String MD5(String s) {
		String result = "";
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp =getMessageDigest("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			result = new String(str);
	
		return result;
	}
	
	//根据算法得到加密MessageDigest
	public static MessageDigest getMessageDigest(String algorithm) {
		MessageDigest mdTemp = null;
		try {
			mdTemp = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return mdTemp;
	}
}

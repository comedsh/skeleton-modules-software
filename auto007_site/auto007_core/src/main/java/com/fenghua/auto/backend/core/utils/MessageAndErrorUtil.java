package com.fenghua.auto.backend.core.utils;

import com.fenghua.auto.backend.core.utils.MessageHelper;
import com.fenghua.auto.backend.domain.mto.LabelError;
import com.fenghua.auto.backend.domain.mto.LabelMessage;

/**
 * 封装返回的message and error
 * @author bin.cheng
 *
 */
public class MessageAndErrorUtil {
	/**
	 * 返回错误消息
	 * @param key
	 * @param filed
	 * @return
	 */
	public static LabelError getError(String key,String filed) {
		LabelError error = new LabelError();
		String message = MessageHelper.getMessage(key);
		error.setError(message);
		error.setField(filed);
		return error;
	}
	/**
	 * 返回普通消息
	 * @param key
	 * @param filed
	 * @return
	 */
	public static LabelMessage getMessage(String key,String filed) {
		LabelMessage msg = new LabelMessage();
		String message = MessageHelper.getMessage(key);
		msg.setMessage(message);
		msg.setField(filed);
		return msg;
	}
	
	
	public static LabelMessage getMessage(String key,String filed,Object... arguments) {
		LabelMessage msg = new LabelMessage();
		String message = MessageHelper.getMessage(key,arguments);
		msg.setMessage(message);
		msg.setField(filed);
		return msg;
	}
}

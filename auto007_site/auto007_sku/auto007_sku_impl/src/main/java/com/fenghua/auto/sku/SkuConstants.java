package com.fenghua.auto.sku;

import java.util.HashMap;
import java.util.Map;

import com.fenghua.auto.backend.core.utills.MessageHelper;

/**
 * <des>
 * Sku相关常量
 *  </des>
 * 
 * @author lijie
 * @date 2015年12月2日
 * @version
 */
public final class SkuConstants {
	
	public final static int THREE_MONTH = 1;
	public final static int THIS_YEAR = 2;
	public final static int LAST_YEAR = 3;
	
	

	/**
	 * 商品类型
	 *
	 */
	public static enum SkuTypeEnum {

		//品牌件
		BRAND(1, MessageHelper.getMessage("sku.brand")),
		//原厂件
		ORIGINAL(1, MessageHelper.getMessage("sku.original"));

		private SkuTypeEnum(int value, String name) {
			this.value = value;
			this.name = name;
		}

		private int value;
		private String name;

		public int getValue() {
			return this.value;
		}

		public String getName() {
			return this.name;
		}

		public static String findName(int value) {
			for (SkuTypeEnum item : SkuTypeEnum.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (SkuTypeEnum item : SkuTypeEnum.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	/**
	 * 商品状态
	 *
	 */
	public static enum SkuStatusEnum {

		SAVE(1, MessageHelper.getMessage("sku.enum.save")), 
		UP_SHELF(2, MessageHelper.getMessage("sku.enum.upshelf")),
		DOWN_SHELF(3,MessageHelper.getMessage("sku.enum.downshelf")),
		DELETE(4,MessageHelper.getMessage("sku.enum.delete"));

		private SkuStatusEnum(int value, String name) {
			this.value = value;
			this.name = name;
		}

		private int value;
		private String name;

		public int getValue() {
			return this.value;
		}

		public String getName() {
			return this.name;
		}

		public static String findName(int value) {
			for (SkuStatusEnum item : SkuStatusEnum.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return SAVE.getName();
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (SkuStatusEnum item : SkuStatusEnum.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	/**
	 * 评论星级
	 *
	 */
	public static enum SkuCommentStarEnum {

		ONE(1,MessageHelper.getMessage("sku.enum.badpraise")), 
		TWO(2,MessageHelper.getMessage("sku.enum.badpraise")), 
		THREE(3,MessageHelper.getMessage("sku.enum.midpraise")), 
		FOUR(4,MessageHelper.getMessage("sku.enum.goodpraise")), 
		FIVE(5,MessageHelper.getMessage("sku.enum.goodpraise"));

	
		private SkuCommentStarEnum(int value,String name) {
			this.value = value;
			this.name = name;
		}

		private int value;
		private String name;

		public int getValue() {
			return this.value;
		}
		
		public String getName() {
			return this.name;
		}

		
		public static String findName(int value) {
			for (SkuCommentStarEnum item : SkuCommentStarEnum.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return FIVE.getName();
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (SkuCommentStarEnum item : SkuCommentStarEnum.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	/**
	 * 评论显示
	 */
	public static enum SkuCommentShowStatusEnum {

		SHOW(1,true), HIDE(2,false),;

	
		private SkuCommentShowStatusEnum(int value,boolean isShow) {
			this.value = value;
			this.isShow = isShow;
		}

		private int value;
		private boolean isShow;

		public int getValue() {
			return this.value;
		}
		
		public String isShow() {
			return this.isShow();
		}

		
		public static boolean isShow(int value) {
			for (SkuCommentShowStatusEnum item : SkuCommentShowStatusEnum.values()) {
				if(item.getValue() == value) {
					return item.isShow;
				}
			}
			return SHOW.isShow;
		}	
	}
	
	/**
	 * 评价来源
	 *
	 */
	public static enum SkuCommentOriginEnum{

		PC(0,"PC"),Android(1,"android"),Iphone(2,"iphone");
		
		private SkuCommentOriginEnum(int value,String name) {
			this.value = value;
			this.name = name;
		}

		private int value;
		private String name;

		public int getValue() {
			return this.value;
		}
		
		public String getName() {
			return this.name;
		}

		
		public static String findName(int value) {
			for (SkuCommentStarEnum item : SkuCommentStarEnum.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return PC.getName();
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (SkuCommentOriginEnum item : SkuCommentOriginEnum.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	
	
}

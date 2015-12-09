/**
 * 
 */
package com.fenghua.auto.order.intf;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单模块常量类
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */

public final class OrderConstants {

	public static enum OrderMasterStatus {
		NEW(0, "新建"), 
		WAIT_PAY(10, "待支付"), 
		WAIT_AUDIT(15, "待审核"), 
		PAYED(20, "已支付"),
		AUDIT_OK(25, "审核通过"), 
		SPLITED(30, "已拆分"),
		
		CANCEL(-10, "已取消"),
		AUDIT_REJECT(-20, "审核拒绝");

		private final int value;
		private final String name;

		private OrderMasterStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (OrderMasterStatus item : OrderMasterStatus.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (OrderMasterStatus item : OrderMasterStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderMasterStatus item : OrderMasterStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum OrderHeaderStatus {
		NEW(0, "新建"), 
		WAIT_PAY(10, "待支付"), 
		WAIT_AUDIT(15, "待审核"), 
		PAYED(20, "已支付"),
		AUDIT_OK(25, "审核通过"), 
		
		SPLITED(30, "待发货"),
		
		WAIT_REC(40, "待收货"),
		
		DONE(50, "已完成"),
		
		CANCEL(-10, "已取消"),
		AUDIT_REJECT(-20, "审核拒绝");

		private final int value;
		private final String name;

		private OrderHeaderStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (OrderHeaderStatus item : OrderHeaderStatus.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (OrderHeaderStatus item : OrderHeaderStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderHeaderStatus item : OrderHeaderStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	public static enum OrderHeaderForkStatus {
		CANCEL_HANDLING(10, "取消处理中"), 
		REFUND_HANDLING(20, "退款处理中"), 
		RETURN_HANDLING(30, "退换货处理中"), 
		
		CANCELLED(-10, "已取消"),
		REFUNDED(-20, "已退款"), 
		
		PART_RETURNED(-30, "已部分退货"),
		RETURNED(-35, "已退货");

		private final int value;
		private final String name;

		private OrderHeaderForkStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (OrderHeaderForkStatus item : OrderHeaderForkStatus.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (OrderHeaderForkStatus item : OrderHeaderForkStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderHeaderForkStatus item : OrderHeaderForkStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum OrderDetailStatus {
		NORMAL(1, "正常"), 
		
		PART_RETURNED(-30, "已部分退货"),
		RETURNED(-35, "已退货");

		private final int value;
		private final String name;

		private OrderDetailStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (OrderDetailStatus item : OrderDetailStatus.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (OrderDetailStatus item : OrderDetailStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderDetailStatus item : OrderDetailStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum OrderDetailForkStatus {
		RETURN_HANDLING(30, "退换货处理中"), 
		
		PART_RETURNED(-30, "已部分退货"),
		RETURNED(-35, "已退货");

		private final int value;
		private final String name;

		private OrderDetailForkStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (OrderDetailForkStatus item : OrderDetailForkStatus.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (OrderDetailForkStatus item : OrderDetailForkStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderDetailForkStatus item : OrderDetailForkStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum PaymentType {
		OFFLINE_PAY(2, "账期支付"), 
		ONLINE_PAY(1, "在线支付");

		private final int value;
		private final String name;

		private PaymentType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (PaymentType item : PaymentType.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (PaymentType item : PaymentType.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (PaymentType item : PaymentType.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum PaymentMethod {
		OFFLINE_PAY(1, "线下支付"), 
		WEIXIN_PAY(2, "微信支付"), 
		ALI_PAY(3, "支付宝");
	
		private final int value;
		private final String name;

		private PaymentMethod(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (PaymentMethod item : PaymentMethod.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (PaymentMethod item : PaymentMethod.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (PaymentMethod item : PaymentMethod.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum PaymentStatus {
		WAITING_PAY(0, "待支付"), 
		PAYED(1, "已支付"); 
	
		private final int value;
		private final String name;

		private PaymentStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (PaymentStatus item : PaymentStatus.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (PaymentStatus item : PaymentStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (PaymentStatus item : PaymentStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	public static enum InvoiceType {
		COMMON(1, "普通发票"), 
		VAT(2, "增值税发票");
		
		private final int value;
		private final String name;

		private InvoiceType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (InvoiceType item : InvoiceType.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (InvoiceType item : InvoiceType.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (InvoiceType item : InvoiceType.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	public static enum InvoiceContentType {
		SKU_DETAIL(1, "商品明细"), 
		AUTO_PART(2, "汽车配件");
		
		private final int value;
		private final String name;

		private InvoiceContentType(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String findName(int value) {
			for (InvoiceContentType item : InvoiceContentType.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (InvoiceContentType item : InvoiceContentType.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
		public static boolean has(int value) {
			for (InvoiceContentType item : InvoiceContentType.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}
	
	public static enum InvoiceStatus {
		NEW(0, "新建"), 
		PRINTED(3, "已打印"),
		SENDED(5, "已发送");
		
		private final int value;
		private final String name;

		private InvoiceStatus(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}

		public static String findName(int value) {
			for (InvoiceStatus item : InvoiceStatus.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (InvoiceStatus item : InvoiceStatus.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
		public static boolean has(int value) {
			for (InvoiceStatus item : InvoiceStatus.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
	}
	public static enum OrderComeFrom {
		WEB(1, "PC商城"), 
		PHONE(2, "手机APP"); 
	
		private final int value;
		private final String name;

		private OrderComeFrom(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (OrderComeFrom item : OrderComeFrom.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (OrderComeFrom item : OrderComeFrom.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (OrderComeFrom item : OrderComeFrom.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
	
	
	public static enum DeliveryMethod {
		DOORTODOOR(1, "送货上门");
	
		private final int value;
		private final String name;

		private DeliveryMethod(int value, String name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public String getName() {
			return name;
		}
		public static boolean has(int value) {
			for (DeliveryMethod item : DeliveryMethod.values()) {
				if(item.getValue() == value) {
					return true;
				}
			}
			return false;
		}
		public static String findName(int value) {
			for (DeliveryMethod item : DeliveryMethod.values()) {
				if(item.getValue() == value) {
					return item.getName();
				}
			}
			return "";
		}
		public static Map<Integer, String> toMap() {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (DeliveryMethod item : DeliveryMethod.values()) {
				map.put(item.getValue(), item.getName());
			}
			return map;
		}
	}
}

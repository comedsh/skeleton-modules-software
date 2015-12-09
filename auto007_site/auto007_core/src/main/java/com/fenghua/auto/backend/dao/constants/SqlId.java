package com.fenghua.auto.backend.dao.constants;

/**
 * Mybatis Sql脚本的ID名称
 */
public interface SqlId {
	//基本键
	public String SQL_SELECT_COUNT = "selectCount";
	public String SQL_SELECT = "select";
	public String SQL_SELECT_PAGE = "selectPage";
	public String SQL_SELECT_PRIMARY_KEY = "selectByPrimaryKey";
	public String SQL_UPDATE_PRIMARY_KEY = "updateByPrimaryKey";
	public String SQL_UPDATE_PRIMARY_KEY_SELECTIVE = "updateByPrimaryKeySelective";
	public String SQL_DELETE = "delete";
	public String SQL_DELETE_PRIMARY_KEY = "deleteByPrimaryKey";
	public String SQL_INSERT = "insert";
	public String SQL_INSERT_SELECTIVE = "insertSelective";
	//订单模块
	public String SQL_SELECT_MASTERS_BY_BUYERID = "selectMastersByBuyerId";
	public String SQL_SELECT_ORDERHEADERS_BY_ORDERMASTERID = "selectOrderHeadersByOrdermaserId";
	public String SQL_SELECT_ORDERTRANSPORT_BY_ORDERHEADERID = "selectOrderTransportOrderHeadersByOrdermaserId";
	public String SQL_SELECT_ORDERITEM_BY_ORDERHEADERID = "selectOrderItemByOrderHeaderId";
	
	//用户模块
	public String SQL_SELECT_BY_NAME = "selectByName";
	public String SQL_SELECT_BY_EMAIL = "selectByEmail";
	public String SQL_SELECT_BY_TELEPHONE = "selectByTelephone";
	public String SQL_UPDATE_BY_NAME = "updateFailtimesByName";
	public String SQL_UPDATEPASSWORD_BY_PHONE = "updatePasswordByPhone";
	public String SQL_UPDATEPASSWORD_BY_USERID = "updatePasswordByUserId";
	public String SQL_UPDATEQQNUMBER_BY_USERID = "updateQqNumberByUserId";
	public String SQL_UPDATEWECHAT_BY_USERID = "updateWeChatByUserId";
	public String SQL_SELECT_BY_QQ_Number="selectByQQ_Number";
	public String SQL_SELECT_WECHAT="selectByWeChat";
	
	public String SQL_SELECT_BY_USERID="selectByUserId";
	public String SQL_SELECT_BY_CONFIGNAME="selectByConfigName";

	//company模块
	public String SQL_SELECT_BY_FIXED = "selectByFixed";
	public String SQL_SELECT_BY_CONTACTSTELEPHONE = "selectByContactsTelephone";
	public String SQL_SELECT_BY_CONTACTSEMAIL = "selectByContactsEmail";
	
	//cityArea模块获取省份
	public String SQL_SELECT_BY_PROVINCE = "selectByProvince";
	//cityArea模块获取市级
	public String SQL_SELECT_BY_CITY = "selectByCity";
	//cityArea模块获取县级
	public String SQL_SELECT_BY_AREA = "selectByArea";
	//忘记密码模块
	public String SQL_SELECT_BY_CODEANDUSER="selectByCodeAndUser";
	public String SQL_DELETE_BY_USERID="deleteByUserId";
}

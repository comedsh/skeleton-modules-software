/**
 * 
 */
package com.fenghua.auto.order.backend.dto;

import java.io.Serializable;
import java.util.List;

import com.fenghua.auto.user.intf.dto.PaymentTypeDTO;
import com.fenghua.auto.user.intf.dto.UserAddressDTO;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */
public class OrderSubmitDTO implements Serializable {

	private static final long serialVersionUID = 2263634449096339797L;
	
	private OrderMasterSubmitDTO masterSubmit;

	private List<UserAddressDTO> addressList;
	
	private List<PaymentTypeDTO> paymentTypeList;
	
	public OrderSubmitDTO() {
		super();
		this.masterSubmit = new OrderMasterSubmitDTO();
	}

	public List<UserAddressDTO> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<UserAddressDTO> addressList) {
		this.addressList = addressList;
		if(this.addressList != null && !this.addressList.isEmpty()) {
			this.masterSubmit.setUserAddressId(this.addressList.get(0).getId());
		}
	}

	public List<PaymentTypeDTO> getPaymentTypeList() {
		return paymentTypeList;
	}

	public void setPaymentTypeList(List<PaymentTypeDTO> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
		if(this.paymentTypeList != null && !this.paymentTypeList.isEmpty()) {
			masterSubmit.setPaymentType(paymentTypeList.get(0).getId());
		}
	}

	public OrderMasterSubmitDTO getMasterSubmit() {
		return masterSubmit;
	}

	public void setMasterSubmit(OrderMasterSubmitDTO masterSubmit) {
		this.masterSubmit = masterSubmit;
	}
	
}

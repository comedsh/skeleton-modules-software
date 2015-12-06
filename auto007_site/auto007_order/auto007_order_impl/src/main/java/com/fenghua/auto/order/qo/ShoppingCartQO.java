/**
 * 
 */
package com.fenghua.auto.order.qo;

import com.fenghua.auto.order.domain.ShoppingCart;

/**
 * 
 * @author zhiyuan.wang@auto007.com
 *
 */

public class ShoppingCartQO extends ShoppingCart {

	private static final long serialVersionUID = -1281643780201926010L;

	private Long[] ids;

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
}

package com.fenghua.auto.order.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.fenghua.auto.order.backend.service.OrderListService;
import com.fenghua.auto.order.backend.util.OrderListQuery;
import com.fenghua.auto.order.backend.vo.OrderMasterVO;

/**
 * 订单列表测试
 * @author zhangfr
 *
 */
@RunWith(SelfDefinedJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-context.xml", "/spring-mybatis.xml","/spring-security.xml"})
public class OrderListTest {
	@Autowired
	private OrderListService orderListService;
	@Test
	public void testName() throws Exception {
		OrderListQuery query=new OrderListQuery();
		List<OrderMasterVO> queryOrderMasterVO = orderListService.queryOrderMasterVO(query);
		for (OrderMasterVO orderMasterVO : queryOrderMasterVO) {
			System.out.println(orderMasterVO);
		}
	}
}

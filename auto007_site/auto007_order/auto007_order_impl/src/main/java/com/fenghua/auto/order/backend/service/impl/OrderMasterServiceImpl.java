/**
 * 
 */
package com.fenghua.auto.order.backend.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.order.backend.dao.OrderHeaderDao;
import com.fenghua.auto.order.backend.dao.OrderInvoiceDao;
import com.fenghua.auto.order.backend.dao.OrderItemDao;
import com.fenghua.auto.order.backend.dao.OrderMasterDao;
import com.fenghua.auto.order.backend.domain.OrderHeader;
import com.fenghua.auto.order.backend.domain.OrderInvoice;
import com.fenghua.auto.order.backend.domain.OrderItem;
import com.fenghua.auto.order.backend.domain.OrderMaster;
import com.fenghua.auto.order.backend.domain.ShoppingCart;
import com.fenghua.auto.order.backend.dto.OrderHeaderSubmitDTO;
import com.fenghua.auto.order.backend.dto.OrderItemSubmitDTO;
import com.fenghua.auto.order.backend.dto.OrderMasterResultDTO;
import com.fenghua.auto.order.backend.dto.OrderMasterSubmitDTO;
import com.fenghua.auto.order.backend.dto.OrderSubmitDTO;
import com.fenghua.auto.order.backend.service.OrderMasterService;
import com.fenghua.auto.order.backend.service.ShoppingCartService;
import com.fenghua.auto.order.intf.OrderConstants;

/**
 * Service实现类
 *
 * @author 王直元
 * @createTime 2015-11-25 11:11:35
 *
 */
@Service
public class OrderMasterServiceImpl extends BaseServiceImpl<OrderMaster> implements OrderMasterService {

	@Autowired
	private OrderMasterDao dao;
	@Autowired
	private SkuService skuService;
	@Autowired
	private UserAddressService userAddressService;
	@Autowired
	private PaymentTypeService paymentTypeService;
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private OrderHeaderDao orderHeaderDao;
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private OrderInvoiceDao orderInvoiceDao;
	@Autowired
	private ShoppingCartService shopCartService;
	
	@Override
	protected BaseDao<OrderMaster> getBaseDao() {
		return dao;
	}

	@Override
	@Transactional(readOnly = true)
	public OrderSubmitDTO initSubmit(List<ShoppingCart> shoppingCarts, Long buyerId) {
		OrderSubmitDTO orderSubmit = new OrderSubmitDTO();
		
		OrderMasterSubmitDTO dto = orderSubmit.getMasterSubmit();
		
		//地址信息
		orderSubmit.setAddressList(userAddressService.findByBuyerId(buyerId));
		
		//子订单信息
		dto.setOrderHeaders(initOrderHeader(buyerId, shoppingCarts));
		//计算价格信息
		calculatePrice(dto);
		
		dto.setBuyerId(buyerId);
		
		orderSubmit.setPaymentTypeList(paymentTypeService.findByBuyerAndSellerIds(buyerId, dto.getSellerIds()));
		
		return orderSubmit;
	}

	private List<OrderHeaderSubmitDTO> initOrderHeader(Long buyerId, List<ShoppingCart> shoppingCarts) {
		Map<Long, List<ShoppingCart>> cartMap = new HashMap<Long, List<ShoppingCart>>();
		if(shoppingCarts != null && !shoppingCarts.isEmpty()) {
			for (ShoppingCart scart : shoppingCarts) {
				if(!cartMap.containsKey(scart.getSellerId())) {
					cartMap.put(scart.getSellerId(), new ArrayList<ShoppingCart>());
				}
				cartMap.get(scart.getSellerId()).add(scart);
			}
		}
		List<OrderHeaderSubmitDTO> ohList = new ArrayList<OrderHeaderSubmitDTO>();
		for (Long sellerId : cartMap.keySet()) {
			Seller seller = sellerService.selectById(sellerId);
			
			OrderHeaderSubmitDTO orderHeader = new OrderHeaderSubmitDTO();
			int qty = 0;
			orderHeader.setSeller(seller);
			orderHeader.setBuyerId(buyerId);
			List<ShoppingCart> scartList = cartMap.get(sellerId);
			for (ShoppingCart scart : scartList) {
				Sku sku = skuService.selectById(scart.getSkuId());
				OrderItemSubmitDTO item = new OrderItemSubmitDTO();
			    
			    item.setSkuId(scart.getSkuId());
			    item.setSkuCode(sku.getCode());
			    item.setSkuName(sku.getName());
			    item.setSkuIcon(sku.getUrl());
			    item.setBrand(sku.getBrand());
			    
			    item.setQty(scart.getQty());
			    item.setCartId(scart.getId());
			    qty += item.getQty();
			    orderHeader.addItem(item);
			}
			orderHeader.setTotalQty(qty);
			ohList.add(orderHeader);
		}
		
		return ohList;
	}
	
	private void calculatePrice(OrderMasterSubmitDTO submitDTO) {
		//计算销售单价格
		for (OrderHeaderSubmitDTO oddto : submitDTO.getOrderHeaders()) {
			calculateHeaderPrice(oddto);
		}
		//计算总价格
		submitDTO.calculateTotal();
	}
	
	private void calculateHeaderPrice(OrderHeaderSubmitDTO submitDTO) {
		//TODO: 调用价格策略计算价格  sellerId，cartMap.get(sellerId)
		//TODO: 调用库存中心check库存 sellerId，cartMap.get(sellerId)
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal discountAmount = new BigDecimal(0);
		BigDecimal needPayAmount = new BigDecimal(0);
		
		if(submitDTO.getItems() != null) {
			for (OrderItemSubmitDTO item : submitDTO.getItems()) {
				Sku sku = skuService.selectById(item.getSkuId());
			    item.setOriginalPrice(sku.getPrice());
			    item.setSalePrice(sku.getSalePrice());
			    item.setTradePrice(sku.getSalePrice());
			    
			    totalAmount = totalAmount.add(item.getTradePrice().multiply(new BigDecimal(item.getQty())));
			}
		}
		
		needPayAmount = totalAmount.subtract(discountAmount);
		submitDTO.setTotalAmount(totalAmount);
		submitDTO.setDiscountAmount(discountAmount);
		submitDTO.setNeedPayAmount(needPayAmount);
		submitDTO.setTransportAmount(new BigDecimal(0.0));
	}
	
	@Override
	@Transactional
	public List<OrderMasterResultDTO> submit(OrderMasterSubmitDTO submitDTO) {
		List<OrderMasterResultDTO> resultDTOs = new ArrayList<OrderMasterResultDTO>();
		List<OrderMaster> masters = genOrderMaster(submitDTO);
		for (OrderMaster orderMaster : masters) {
			resultDTOs.add(new OrderMasterResultDTO(orderMaster));
		}
		
		return resultDTOs;
	}
	@Override
	public List<OrderMaster> selectByBuyerID(Long userId) {
		List<OrderMaster> orderMasters=dao.selectByBuyerID(userId);
		return orderMasters;
	}


	private List<OrderMaster> genOrderMaster(OrderMasterSubmitDTO submitDTO) {
		List<OrderMaster> masters = null;
		
		List<OrderMasterSubmitDTO> submitDTOs = splitPreGen(submitDTO);
		masters = doGenOrderMaster(submitDTOs);
		
		return masters;
	}
	private List<OrderMaster> doGenOrderMaster(List<OrderMasterSubmitDTO> submitDTOs) {
		List<OrderMaster> masters = new ArrayList<OrderMaster>();
		
		for (OrderMasterSubmitDTO submitDTO : submitDTOs) {
			OrderMaster master = doGenOrderMaster(submitDTO);
			masters.add(master);
		}
		
		return masters;
	}
	
	private OrderMaster doGenOrderMaster(OrderMasterSubmitDTO submitDTO) {
		//计算价格
		calculatePrice(submitDTO);
		
		UserAddress userAddr = userAddressService.selectById(submitDTO.getUserAddressId());
		
		OrderMaster master = submitDTO.createMaster(userAddr.getCityId());
		
		this.dao.insert(master);
		
	    master.setOrderHeaders(new ArrayList<OrderHeader>());
	    
	    List<Long> cartIds = new ArrayList<Long>();
	    
	    for (OrderHeaderSubmitDTO ohSubmit : submitDTO.getOrderHeaders()) {
	    	OrderHeader orderHeader = ohSubmit.createHeader(master, userAddr);
	    	if(submitDTO.isInvoiceFlag()) {
	    		orderHeader.setInvoiceFlag(1);
	    	} else {
	    		orderHeader.setInvoiceFlag(0);
	    	}
	    	this.orderHeaderDao.insert(orderHeader);
	    	
	    	master.getOrderHeaders().add(orderHeader);
	    	
	    	orderHeader.setItems(new ArrayList<OrderItem>());
	    	for (OrderItemSubmitDTO itemSubmit : ohSubmit.getItems()) {
	    		OrderItem item = itemSubmit.createItem(orderHeader, submitDTO.getUserId());
	    		this.orderItemDao.insert(item);
	    		orderHeader.getItems().add(item);
	    		if(itemSubmit.getCartId() != null && itemSubmit.getCartId() > 0) {
	    			cartIds.add(itemSubmit.getCartId());
	    		}
			}
	    	
	    	if(submitDTO.isInvoiceFlag()) {
	    		OrderInvoice orderInvoice = submitDTO.getOrderInvoice().createInvoice(orderHeader);
	    		this.orderInvoiceDao.insert(orderInvoice);
	    		orderHeader.setOrderInvoice(orderInvoice);
	    	}
		}
	    
	    if(!cartIds.isEmpty()) {
	    	shopCartService.deleteByIdInBatch(cartIds);
	    }
	    
		return master;
	}
	
	private List<OrderMasterSubmitDTO> splitPreGen(OrderMasterSubmitDTO submitDTO) {
		List<OrderMasterSubmitDTO> submitDTOs = new ArrayList<OrderMasterSubmitDTO>();
		//账期支付
		if(submitDTO.getPaymentType().intValue() == OrderConstants.PaymentType.OFFLINE_PAY.getValue()) {
			for (OrderHeaderSubmitDTO ohSubmitDTO : submitDTO.getOrderHeaders()) {
				OrderMasterSubmitDTO omSubmit = new OrderMasterSubmitDTO(submitDTO, ohSubmitDTO);
				submitDTOs.add(omSubmit);
			}
		} else {//线上支付
			submitDTOs.add(submitDTO);
		}
		return submitDTOs;
	}
}

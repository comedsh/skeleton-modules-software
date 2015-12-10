<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<div class="success">
	<div class="success-b">
		<h2>支付方式：</h2>
		<h3>支付订单号：${payment.payNo }</h3>
		<h3>销售订单号：${payment.masterOrderNo }</h3>
		<h3>需要支付金额：￥${payment.needPayAmount }</h3>
		<h3 style="color: red">${errorMsg}</h3>
		<ul>
			<c:forEach var="paymentMethod" items="${paymentMethodList}" >
				<li>
					 <label><input type="radio" value="${paymentMethod.value }" name="payMethod" onchange="openPayPage(${paymentMethod.value },'${paymentMethod.name}')">
					 	<strong>${paymentMethod.name}</strong>
					 </label>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<script type="text/javascript">
	function openPayPage(payMethod, name) {
		alert("您选择的支付方式："+name);
		
	}
</script>
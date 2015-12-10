/*
*买家个人中心js
*/
$(function(){
	var data={
		//删除订单Url
		deleteOrderUrl:'aaa',
		//确认收货Url
		confirmReceivingUrl:'bbb'
	};
	var logic={
		eventBind:function(){
			//确认收货
			$('.js-confirm-receiving-btn').click(function(){
				var $this=$(this);
				fh_confirm('亲，您确定已经收到货了吗？',function(){
					var orderId=$this.attr('data-orderid');

					$.ajax({
						url:data.confirmReceivingUrl,
						type:'GET',
						dataType:'json',
						data:{
							orderid:orderId
						},
						success:function(response){
							location.href=location.href;
						},
						error:function(){
							location.href=location.href;
						}
					});
				});
				return false;
			});

			//删除订单
			$('.js-delete-order-btn').click(function(){
				var $this=$(this);
				fh_confirm('亲，您确定要删除该订单吗?',function(){
					var orderId=$this.attr('data-orderid');

					$.ajax({
						url:data.deleteOrderUrl,
						type:'GET',
						dataType:'json',
						data:{
							orderid:orderId
						},
						success:function(response){
							var orderBody=$this.parents('.tbody');
							orderBody.fadeOut(500,function(){
								orderBody.remove();
							});
						},
						error:function(){
							var orderBody=$this.parents('.tbody');
							orderBody.fadeOut(500,function(){
								orderBody.remove();
							});
						}
					});
				});
				return false;
			});
		},
		init:function(){
			logic.eventBind();
		}
	};
	logic.init();
});
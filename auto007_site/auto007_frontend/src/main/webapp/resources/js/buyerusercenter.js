/*
*弹出框js
*created by yangzhi on 2015.12.10
*/
$(function(){
	$('.cancel-btn,.close-btn').click(function(){
		$('.pop-up').fadeOut(200);
		return false;
	});
	$('body,html').click(function(){
		$('.pop-up').fadeOut(200);
	});
	window.fh_confirm = function(msg,callback){
		$('.pop-up').show().find('.pop-content').html(msg);
		$('.ok-btn').unbind();
		$('.ok-btn').click(function(){
			if(typeof callback=='function'){
				callback();
			}
			$('.pop-up').fadeOut(200);
			return false;
		});
	};
});
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
/*
*页面顶部js
*created by yangzhi on 2015.12.7
*/
(function(window,$){
	//显示所有备选城市
	$('.js-header-city').hover(function(){
		$(this).find('.icon-arrow_down').toggleClass('icon-arrow_up');
		$('.js-all-city-panel').fadeToggle(200);
	});
	//选择城市
	$('.js-all-city-panel a').click(function(){
		$(this).parent().addClass('current').siblings().removeClass('current');
		var currentCityId=$(this).attr('data-id');
		var currentCityName=$(this).html();
		$('.js-header-current-city').attr('data-id',currentCityId);
		$('.js-header-current-city').html(currentCityName);
		return false;
	});
})(window,$);
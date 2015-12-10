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
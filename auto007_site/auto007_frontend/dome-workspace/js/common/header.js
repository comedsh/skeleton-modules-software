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
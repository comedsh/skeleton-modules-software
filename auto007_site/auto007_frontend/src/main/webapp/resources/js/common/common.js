function address(){alert("address")}
$(function(){$(".cancel-btn,.close-btn").click(function(){return $(".pop-up").fadeOut(200),!1}),$("body,html").click(function(){$(".pop-up").fadeOut(200)}),window.fh_confirm=function(n,o){$(".pop-up").show().find(".pop-content").html(n),$(".ok-btn").unbind(),$(".ok-btn").click(function(){return"function"==typeof o&&o(),$(".pop-up").fadeOut(200),!1})}});
function datepicker(){alert("datepicker")}

!function(t,a){a(".js-header-city").hover(function(){a(this).find(".icon-arrow_down").toggleClass("icon-arrow_up"),a(".js-all-city-panel").fadeToggle(200)}),a(".js-all-city-panel a").click(function(){a(this).parent().addClass("current").siblings().removeClass("current");var t=a(this).attr("data-id"),r=a(this).html();return a(".js-header-current-city").attr("data-id",t),a(".js-header-current-city").html(r),!1})}(window,$);
function pagebar(){alert("pagebar")}
function address(){alert("address")}
function datepicker(){alert("datepicker")}

!function(t,a){a(".js-header-city").hover(function(){a(this).find(".icon-arrow_down").toggleClass("icon-arrow_up"),a(".js-all-city-panel").fadeToggle(200)}),a(".js-all-city-panel a").click(function(){a(this).parent().addClass("current").siblings().removeClass("current");var t=a(this).attr("data-id"),r=a(this).html();return a(".js-header-current-city").attr("data-id",t),a(".js-header-current-city").html(r),!1})}(window,$);
function pagebar(){alert("pagebar")}
$(function() {
	var i = 10;
	var time=setInterval(function(){
    	$(".timer").text(i+"秒内,自动跳转到首页开始您的汽车零件选购");
    	
        i--;
        if(i == -1) {
        	clearInterval(time);
        	window.location.href='/secure/main';
        }
    },1000);
});


/**
 * Created by think on 2015/11/4.
 */
$(function(){
    //城市切换
    $('.city_div').hover(function () {
        $(this).addClass('active_l');
        $('#show_div').show();
    }, function () {
        $(this).removeClass('active_l');
        $('#show_div').hide();
    });
    $('#show_div').hover(function () {
        $(this).show();
    }, function () {
        $('.city_div').hover(function () {
            $(this).addClass('active_l');
            $('#show_div').show();
        }, function () {
            $(this).removeClass('active_l');
            $('#show_div').hide();
        });
    });
    $('#show_div ul li a').on('click', function () {
        var text = $(this).html();
        $(this).addClass('active');
        $(this).parent().siblings().children('a').removeClass('active');
        $('.city_div span').html(text);
    });
    //判断span数字是否大于0
    $(".user_ul ul li span").each(function(i,val){
        if($(this).html()>0){
            $(this).css('color','#ff8d02');
        }else{
            $(this).css('color','#666');
        }
    });
});
/**
*angularJs
*bin.cheng
*/
var app=angular.module('userCenter',[]);
app.controller('centerContent',['$scope','$http',function($scope,$http){
	
}]);
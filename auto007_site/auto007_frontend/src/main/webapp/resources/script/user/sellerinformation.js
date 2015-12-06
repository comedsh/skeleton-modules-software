/**
 * Created by think on 2015/11/9.
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
    //tab切换
    $('.contact_infor p').on('click',function(){
        var index=$(this).index();
        $(this).addClass('p_active').siblings().removeClass('p_active');
        if(index==0){
            $('.contact_information').show();
            $('.enterprise_information').hide();
        }else{
            $('.contact_information').hide();
            $('.enterprise_information').show();
        }
    });
    //下拉框选择
    $('.input_select').on('click',function(){
        $(this).children('ul').show();
    });
    $('.input_select ul').hover(function(){
        $(this).show()
    },function(){
        $(this).hide()
    });
    $('.input_select ul li').on('click',function(){
        $(this).parent().parent().children('span').html($(this).html());
    });
    //支付
    $(".Remember_pwd").toggle(
        function () {
            $(this).addClass("Remember_pwd1").attr({data: '1'});
            $('.radio_div').show();
            if($('.check_radio1').hasClass('radio_r2')){
                $(this).next().find('span').html('月结');
            }else{
                $(this).next().find('span').html('季结');
            }
        },
        function () {
            $(this).removeClass("Remember_pwd1").attr({data: '0'});
            $('.radio_div').hide();
            $(this).next().find('span').html('需要平台审核，验证资质后，可使用此支付方式');
        }
    );
    //单选按钮
    $('.check_radio1').on('click',function(){
        $(this).addClass('radio_r2');
        $('.check_radio2').removeClass('radio_r2');
        $('.check_box label span').html('月结')
    });
    $('.check_radio2').on('click',function(){
        $(this).addClass('radio_r2');
        $('.check_radio1').removeClass('radio_r2');
        $('.check_box label span').html('季结');
    });
});
/**
*angularJs
*bin.cheng
*/
var app=angular.module('sellerInformation',[]);
app.controller('informationConcroller',['$scope','$http',function($scope,$http){
	//初始化信息
	$scope.init();
	
	$scope.init= function(){
		//获取个人信息
		$scope.getInformation(name);
	}
	//获取个人信息
	$scope.getInformation =function(name) {
		$http.get('/user/validateName/'+name).success(function(information){
    		$scope.informations = information;
        });
	}
}]);
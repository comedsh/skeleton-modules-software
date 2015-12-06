$(document).ready(function(){
	var value=$('#lab').val();
	if(value=='email'){
		$('.border_div').hide();
        $('.border_div1').show();
	}else{
		$('.border_div').show();
        $('.border_div1').hide();
	}
});
/**
 * Created by think on 2015/11/2.
 */
$(function() {
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
    $('.a_tab').on('click',function(){
        var index=$(this).index();
        $(this).addClass('active_tab').siblings().removeClass('active_tab');
        if(index==0){
            $('.border_div').show();
            $('.border_div1').hide();
        }else{
            $('.border_div').hide();
            $('.border_div1').show();
        }
    });
    //手机验证
    $("#mobile").blur(function(event) {
    	var str = $(this).parent();
        if($(this).val() == ""){
            $('.mobile_error img').show();
            $(".mobile_error span").html("手机号码不能为空");
            $("#sub_tel").val(1);
            return false;
        }
        var re = /^1{1}[34578]{1}[0-9]{9}$/;
        if(!re.test($(this).val())){
            $('.mobile_error img').show();
            $(".mobile_error span").html("手机号码格式不正确");
            $("#sub_tel").val(1);           
            return false;
        }else{
        	$.ajax({
                type: "GET",
                url: '/user/validateTelephone',
                data: {"telephone":$(this).val()},
                dataType: "json",
                success: function (data) {
                	 if(data == null) {
                    	$('.mobile_error img').show();
                        $(".mobile_error span").html("该手机号码未被注册");
                        $("#sub_tel").val(1);
                    } else {
                    	
                    	$("#sub_tel").val(0);
                        $('.mobile_error img').hide();
                        $(".mobile_error span").html("");
                        $('#validateTel').bind('click','validateTel()');
                      //失去焦点时，隐藏X图标
//                        var as= $(str).parent().children('.user_error3').css('display');
//                        if(as=='block'){
//                            $(str).parent().children('.remove_d').hide();
//                        
//                        }
                    }
                }
            });
        }
    });
    //图形验证码
    $(".code").blur(function(event) {
        if($(this).val() == ""){
            $('.code_error img').show();
            $(".code_error span").html("验证码不能为空");
            $("#sub_code").val(1);
            return false;
        }
        var re = /^[A-Za-z0-9]{4}$/;
        if(!re.test($(this).val())){
            $('.code_error img').show();
            $(".code_error span").html("验证码格式不正确");
           $("#sub_code").val(1);
            return false;
//        }else if($(this).val() == $(this).parent().parent().find(".verifyCode").val()){
//           
//            $('.code_error img').hide();
//            $(".code_error span").html(" 输入正确");
//            $("#sub_code").val(0);
        }else{
        	 $('.code_error img').hide();
        	 $(".code_error span").html("");
        	 $("#sub_code").val(0);
            return false;
        }
    });
    //图片验证码请求
    $('.validatePicCheck').on('click',function(){
    	var str = $(this);
    	$(this).parent().parent().find(".pictureCheckCode").attr('src','/user/validatePicCheck?'+Math.random());
//    	$.ajax({
//            type: "GET",
//            url: '/user/validatePicCheck',
//            dataType: "text",
//            success: function (data) {
//                $(str).parent().parent().find(".verifyCode").val(data);
//            }
//        });
    });
    //手机短信验证码
    $(".iPhone_code").blur(function(event) {
        if($(this).val() == ""){
            $('.iPhone_code_error img').show();
            $(".iPhone_code_error span").html("手机验证码不能为空");
            $("#sub_tel_code").val(1);
            return false;
        }
        var re = /^[0-9]{6}$/;
        if(!re.test($(this).val())){
            $('.iPhone_code_error img').show();
            $(".iPhone_code_error span").html("手机验证码格式不正确");
            $("#sub_tel_code").val(1);
            return false;
//        }else if($(this).val() == $(".telephone_code_rep").val()){
//           
//            $('.iPhone_code_error img').hide();
//            $(".iPhone_code_error span").html("输入正确");
//            $("#sub_tel_code").val(0);
        }else{
        	 $('.iPhone_code_error img').hide();
            $(".iPhone_code_error span").html("");
            $("#sub_tel_code").val(0);
            return false;
        }
    });
    //获取验证码 按钮状态
    $('.button_a').on('click',function(){
        var i=10;
        var btn=$('.button_a');
        var time=setInterval(function(){
            btn.html(i+"秒可重发").attr('disabled','disabled').css({backgroundColor:'#9c9c9c'});
            if(i==-1){
                clearInterval(time);
                btn.html('重新发送').attr("disabled",false).removeAttr('disabled').css({backgroundColor:'#0281d4'});
            }
            i--;
        },1000);
    });
    //修改密码验证
    $(".pwd_new").blur(function(event) {
        if($(this).val() == ""){
            $('.pwd_new_error img').show();
            $(".pwd_new_error span").html("密码不能为空");
            $('.second').val('1');
            return false;
        }
        var re = /^[a-zA-Z]\w{5,17}$/;
        if(!re.test($(this).val())){
            $('.pwd_new_error img').show();
            $(".pwd_new_error span").html("以字母开头，长度在6~18之间，只能包含字符、数字和下划线");
            $('.second').val('1');
            return false;
        }else{
            $('.pwd_new_error img').hide();
            $(".pwd_new_error span").html("");
            $('.second').val('0');
            return false;
        }
    });
    //再次输入密码验证
    $(".pwd_new_agin").blur(function(event) {
        if($(this).val() == ""){
            $('.pwd_agin_error img').show();
            $(".pwd_agin_error span").html("密码不能为空");
            $('.second').val('1');
            return false;
        }
        var pwd=$(".pwd_new").val();
        var pwd1=$(".pwd_new_agin").val();
        if(pwd1!=pwd){
            $('.pwd_agin_error img').show();
            $(".pwd_agin_error span").html("两次输入密码不相同");
            $('.second').val('1');
            return false;
        }else{
            $('.pwd_agin_error img').hide();
            $(".pwd_agin_error span").html("");
            $('.second').val('0');
            return false;
        }
    });
    //邮箱验证
    $(".email").blur(function(event) {
        if($(this).val() == ""){
            $('.email_error img').show();
            $(".email_error span").html("邮箱不能为空");
            $('.boolen1').val('1');
            return false;
        }
        var re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if(!re.test($(this).val())){
            $('.email_error img').show();
            $(".email_error span").html("邮箱格式不正确");
            $('.boolen1').val('1');
            return false;
        }else{
        	$.ajax({
                type: "GET",
                url: '/user/validateEmail',
                data: {"email":$(this).val()},
                dataType: "json",
                success: function (data) {
                    if(data==null || data.length == 0) {
                    	 $(".email_error span").show().html("该邮箱未被注册");
                    	 $('.boolen1').val('1');
                    } else {
                    	$('.boolen1').val('0');
                    	$('.email_error img').hide();
                        $(".email_error span").html("");
                        
//                        //失去焦点时，隐藏X图标
//                        var as= $(str).parent().children('.user_error3').css('display');
//                        if(as=='block'){
//                            $(str).parent().children('.remove_d').hide();
//                        
//                        }
                    }
                }
            });
        	

        }
    });
    //邮箱修改密码验证
    $(".email_pwd").blur(function(event) {
        if($(this).val() == ""){
            $('.email_pwd_error img').show();
            $(".email_pwd_error span").html("密码不能为空");
            $('.boolen2').val('1');
            return false;
        }
        var re = /^[a-zA-Z]\w{5,17}$/;
        if(!re.test($(this).val())){
            $('.email_pwd_error img').show();
            $(".email_pwd_error span").html("以字母开头，长度在6~18之间，只能包含字符、数字和下划线");
            $('.boolen2').val('1');
            return false;
        }else{
            $('.email_pwd_error img').hide();
            $(".email_pwd_error span").html("");
            $('.boolen2').val('0');
            return false;
        }
    });
    //邮箱再次输入密码验证
    $(".email_new_agin").blur(function(event) {
        if($(this).val() == ""){
            $('.email_agin_error img').show();
            $(".email_agin_error span").html("密码不能为空");
            $('.boolen2').val('1');
            return false;
        }
        var pwd=$(".email_pwd").val();
        var pwd1=$(".email_new_agin").val();
        if(pwd1!=pwd){
            $('.email_agin_error img').show();
            $(".email_agin_error span").html("两次输入密码不相同");
            $('.boolen2').val('1');
            return false;
        }else{
            $('.email_agin_error img').hide();
            $(".email_agin_error span").html("");
            $('.boolen2').val('0');
            return false;
        }
    });
});

    
var forgotpwd_app=angular.module('forgotpwd_app',[]);
//手机找回密码
forgotpwd_app.controller('ipone_ctr',['$scope','$http',function($scope,$http){
        $scope.mobile='';
        $scope.code='';
        $scope.iPhone_code='';
        $scope.num=0;
        $scope.myVar1 = false;
        $scope.myVar2 = true;
        $scope.myVar3 = true;
        //个人手机验证码
        $scope.validateTel = function() {
        	//if($("#"+s).css('display')=='block') {
        		$http.post(
        				'/user/validateTel/',
        				{
        					'mobilephone' : $scope.mobile
        				},
        				{
        					headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
        					transformRequest: function(data){
        						return $.param(data);
        					}
        				}
        		)
        		.success(function(data){
        			$(".telephone_code_rep").val(data);
        		})
        		.error(function(data){
        			
        		});
        	}
      //  }
        
        $scope.nextstep=function(){
            console.log($scope.mobile+"////"+$scope.num);
            if($("#sub_tel").val()==0 && $("#sub_code").val()==0 && $("#sub_tel_code").val()==0){
            	// $scope.myVar2 = false;
                $http.post(
                		'/user/findPassByPhone/',
                		{
                			'code' : $scope.code,
                			'telcode':$scope.iPhone_code}
                		,
                		{
        				    headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
        				    transformRequest: function(data){
        				        return $.param(data);
        				    }
        				}
                		)
                    .success(function(data){
                    	if(data.message.success) {
                        //第一步验证成功时
                    	 $(".ipone_two").css("display","");
                    	 $(".ipone_one").css("display","none");
                    	 $(".ipone_three").css("display","none");
                    	}else{
                    		alert(data.message.msg);
                    	}
                    })
                    .error(function(rep){
                    	alert(data.message.msg);
                    })
            }

        };
        $scope.mobile='';
        $scope.pwd_new = '';
        $scope.pwd_new_agin = '';
        $scope.second=function(){
            if($('.second').val()==0){
                $http.post('/user/updatePasswordByPhone/',{'pwd_new':$scope.pwd_new,'phone':$scope.mobile}
                ,
				{
				   headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
				    transformRequest: function(data){
				        return $.param(data);
				    }
				}
                )
                    .success(function(data){
                        //第二步验证成功时
                    	if(data.message.success) {
                    	 $(".ipone_two").css("display","none");
                    	 $(".ipone_one").css("display","none");
                    	 $(".ipone_three").css("display","");
                    	 $("#qq").html(data.message.code);
                    	}
//                        $scope.myVar2 = true;
//                        $scope.myVar3 = false;
                    })
                    .error(function(rep){
//                        //第二步验证失败时
//                        if(rep){
//                            //密码不能为空
//                            $('.pwd_new_error img').show();
//                            $(".pwd_new_error span").html("请输入密码");
//                            return false;
//                        }else{
//                            //再次输入密码不能为空
//                            $('.pwd_agin_error img').show();
//                            $(".pwd_agin_error span").html("请输入密码");
//                            return false;
//                        }
                    })
            }
        }
}]);

function reSendEail(){
	$.ajax({
      type: "post",
      url: '/user/ReSendPass/',
      dataType: "json",
      success: function (data) {
         // $(str).parent().parent().find(".verifyCode").val(data);
      }
  });
}
//手机验证找回密码第一步
function firstByPhone(){
	  if($("#sub_tel").val()==0 && $("#sub_code").val()==0 && $("#sub_tel_code").val()==0){
		  $('#firstformByPhone').submit();
	  }
}
//手机找回密码第二步提交
function secondByPhone(){
	 if($('.second').val()==0){
		 $('#secondformByPhone').submit();
	 }
}
function firstByEmail(){
	if($('.boolen1').val()==0){
		 $('#firstformByEmail').submit();
	 }else{
		 return false;
	 }
}
function secondByEmail(){
	if($('.boolen1').val()==0){
		 $('#secondformByEmail').submit();
	 }
}
//邮箱找回密码
forgotpwd_app.controller('email_ctr',['$scope','$http',function($scope,$http){
        $scope.boolen1=false;
        $scope.boolen2=true;
        $scope.boolen3=true;
        $scope.boolen4=true;
        $scope.boolen5=false;
        $scope.email='';
        $scope.emailnext=function(){
            if($('.boolen1').val()==0){
                $http.post(
                		'/user/forGotPassword/',
                		{'email':$scope.email},
                		{
		 				    headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
		 				    transformRequest: function(data){
		 				        return $.param(data);
		 				    }
		 				}
                )
                    .success(function(rep){
                        //第一步验证成功时
                        $scope.boolen1=false;
                        $scope.boolen5=true;
                        $scope.boolen4=false;
                        $("#emailcontent").html($scope.email);
                        $scope.email = $scope.email;
                    })
                    .error(function(rep){
                        //第一步验证失败时
                        if(rep){
                            //邮箱不能为空
                            $('.email_error img').show();
                            $(".email_error span").html("邮箱不能为空");
                            return false;
                        }
                    });
            }
        };
        $scope.pwd_new1 = '';
        $scope.pwd_new_agin1 = '';
        $scope.userId1='';
        $scope.second=function(){
            if($('.boolen2').val()==0){
                $http.post('/user/updatePasswordByUserId/',{'pwdNew':$scope.pwd_new1,'userId':$("#userId").val()},
                		{
 				    headers: { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
 				    transformRequest: function(data){
 				        return $.param(data);
 				    }
 				}		
                )
                    .success(function(data){
                        //第二步验证成功时
//                        $scope.boolen2=true;
//                        $scope.boolen3=false;
                    	$(".email_two").css("display","none");
                    	$(".email_three").css("display","");
                    	 $("#blindEmail").html(data.message.code);
                    })
                    .error(function(rep){
                        //第二步验证失败时
                        if(rep){

                        }
                    })
            }
        }
}]);

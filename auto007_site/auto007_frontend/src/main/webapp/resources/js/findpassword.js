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
$(function(){
	var data={
		//手机验证实体
		phoneData:{
			telphone:'',
			code:'',
			telphoneCode:''
		},
		//邮箱验证实体
		emailData:{
			email:'',
			code:''
		},
		//重置密码实体
		resetPwdData:{
			pwd:'',
			repeatPwd:''
		},
		dom:{
			phoneTextBox:$('#telphone'),
			sendPhoneCodeBtn:$('.js-send-phonecode-btn')
		},
		sendCodeLock:false,
		//发送手机验证码间隔时间
		sendCodeInterval:300,
		//验证码图片地址
		codeImageUrl:'../resources-old/img/test_code.jpg',
		//发送手机验证码地址
		sendPhoneCodeUrl:'http://www.auto007.com',
		//手机找回密码验证提交地址
		findPwdByPhoneUrl:'',
		//邮箱找回密码验证提交地址
		findPwdByEmailUrl:'',
		//重置密码链接
		resetPwdUrl:''
	};
	var logic={
		eventBind:function(){
			//切换选项卡
			$('.js-tab-box li').click(function(){
				if($('.js-findpwd-item').length){
					$('.js-findpwd-item').hide().eq($(this).index()).show();
					$(this).addClass('current').siblings().removeClass('current');
				}
			});
			$('input').focus(function(){
				logic.hideError($(this));
			});
			//手机号
			data.dom.phoneTextBox.blur(function(){
				var phone=$(this).val();
				if(phone==''){
					logic.showError($(this),'手机号不能为空');
				}else if(!phone.t_isMobile()){
					logic.showError($(this),'手机号格式不正确');
				}
			});
			//邮箱
			$('#email').blur(function(){
				var email=$(this).val();
				if(email==''){
					logic.showError($(this),'邮箱不能为空');
				}else if(!email.t_isEmail()){
					logic.showError($(this),'邮箱格式不正确');
				}
			});
			//验证码
			$('#code,#emailcode').blur(function(){
				var code=$(this).val();
				if(code==''){
					logic.showError($(this),'验证码不能为空');
				}
			});
			//短信验证码
			$('#telphonecode').blur(function(){
				var code=$(this).val();
				if(code==''){
					logic.showError($(this),'短信验证码不能为空');
				}
			});
			//密码
			$('#pwd').blur(function(){
				var pwd=$(this).val();
				if(!pwd.t_passWordCheck()){
					logic.showError($(this),'6-20位字符，建议字母、数字、特殊符号两种以上组合');
				}
			});
			//重复密码
			$('#repeatpwd').blur(function(){
				var repeatpwd=$(this).val();
				if(repeatpwd==''){
					logic.showError($(this),'请再次输入密码');
				}
				if(repeatpwd!=$('#pwd').val()){
					logic.showError($(this),'两次输入密码不一致');
				}
			});

			//更换验证码
			$('.change-code-btn').click(function(){
				logic.changeImageCode();
				return false;
			});

			//发送手机验证码
			data.dom.sendPhoneCodeBtn.click(function(){
				if (data.sendCodeLock) {
					return false;
				}
				logic.sendPhoneCode();
				return false;
			});

			//手机找回密码提交
			$('.phone-submit-btn').click(function(){
				data.phoneData={
					telphone:data.dom.phoneTextBox.val(),
					code:$('#code').val(),
					telphoneCode:$('#telphonecode').val()
				};
				var isHasError=false;
				if(!data.phoneData.telphone.t_isMobile()){
					logic.showError(data.dom.phoneTextBox,'手机号格式不正确');
					isHasError=true;
				}
				if(data.phoneData.code==''){
					logic.showError($('#code'),'验证码不能为空');
					isHasError=true;
				}
				if(data.phoneData.telphoneCode==''){
					logic.showError($('#telphonecode'),'短信验证码不能为空');
					isHasError=true;
				}
				if(isHasError){return false;}

				//此句为测试，完成后请删除
				location.href='findPasswordReset.html';

				$.ajax({
				   type: "POST",
				   url: data.findPwdByPhoneUrl,
				   data: {
				   		telphone:data.phoneData.telphone,
				   		code:data.phoneData.code,
				   		telphoneCode:data.phoneData.telphoneCode
				   },
				   success: function(response){
				     if(!response.errors||!response.length){
				     		//验证成功，跳转到重置密码页面
				     		location.href='findPasswordReset.html';
						}else{
							$.each(response.errors,function(){
								logic.showError($('input[name='+this.fild+']'),msg);
							});
							logic.changeImageCode();
						}
				   }
				});
				return false;
			});
			//邮箱找回密码提交
			$('.email-submit-btn').click(function(){
				data.emailData={
					email:$('#email').val(),
					code:$('#emailcode').val()
				};
				var isHasError=false;
				if(!data.emailData.email.t_isEmail()){
					logic.showError($('#email'),'邮箱格式不正确');
					isHasError=true;
				}
				if(data.emailData.code==''){
					logic.showError($('#emailcode'),'验证码不能为空');
					isHasError=true;
				}
				if(isHasError){return false;}
				$.ajax({
				   type: "POST",
				   url: data.findPwdByEmailUrl,
				   data: {
				   		email:data.emailData.email,
				   		code:data.emailData.code
				   },
				   success: function(response){
				     if(!response.errors||!response.length){
				     		//验证成功，显示成功提示
				     		logic.operationAfterSendEmailSuccess();
						}else{
							$.each(response.errors,function(){
								logic.showError($('input[name='+this.fild+']'),msg);
							});
							logic.changeImageCode();
						}
				   },
				   error:function(){

				   		//此句为测试，完成后请删除
				   		logic.operationAfterSendEmailSuccess();

				   		//alert('系统繁忙，请稍后再试');
				   }
				});
				return false;

			});
			//重置密码提交
			$('.js-resetpwd-btn').click(function(){
				data.resetPwdData = {
					pwd:$('#pwd').val(),
					repeatPwd:$('#repeatpwd').val()
				};
				var isHasError=false; 
				if(!data.resetPwdData.pwd.t_passWordCheck()){
					logic.showError($('#pwd'),'6-20位字符，建议字母、数字、特殊符号两种以上组合');
					isHasError=true;
				}
				if(data.resetPwdData.pwd!=data.resetPwdData.repeatPwd){
					logic.showError($('#repeatpwd'),'两次输入密码不一致');
					isHasError=true;
				}
				if(isHasError){return false;}
				$.ajax({
				   type: "POST",
				   url: data.resetPwdUrl,
				   data: {
				   		pwd:data.resetPwdData.pwd,
				   		repeatPwd:data.resetPwdData.repeatPwd
				   },
				   success: function(response){
				     if(!response.errors||!response.length){
				     		//修改成功
				     		location.href='findPasswordEmailSuccess.html';
						}else{
							$.each(response.errors,function(){
								logic.showError($('input[name='+this.fild+']'),msg);
							});
							logic.changeImageCode();
						}
				   },
				   error:function(){

				   		//此句为测试，完成后请删除
				     	location.href='findPasswordEmailSuccess.html';

				   		//alert('系统繁忙，请稍后再试');
				   }
				});
				return false;

			});


		},
		sendPhoneCode:function(){
			var phone=data.dom.phoneTextBox.val();
			if(!phone.t_isMobile()){
				logic.showError(data.dom.phoneTextBox,'手机号格式不正确');
				return false;
			}
			$.ajax({
			   type: "POST",
			   url: data.sendPhoneCodeUrl,
			   data: {phone:phone},
			   success: function(msg){
			     
			   }
			});
			data.sendCodeLock=true;
			logic.sendCodeTimeOut(data.sendCodeInterval);
		},
		sendCodeTimeOut:function(time){
			data.dom.sendPhoneCodeBtn.html(time+'秒后重发');
			if(time>0){
				data.dom.sendPhoneCodeBtn.html(time+'秒后重发');
				setTimeout(function(){
					logic.sendCodeTimeOut(--time);
				}, 1000);
			}else{
				data.sendCodeLock=false;
				data.dom.sendPhoneCodeBtn.html('获取手机验证码');
			}
		},
		changeImageCode:function(){
			$('.js-code-img').attr('src',data.codeImageUrl+'?'+Math.random());
		},
		//邮件发送成功后操作
		operationAfterSendEmailSuccess:function(){
			$('.phone-findpwd').remove();
			$('.send-email-success').show().find('.js-email-address').html(data.emailData.email);
			$('.send-email-success').siblings('.form-box').remove();
			$('.content li,.content a').unbind();
		},
		showError:function(dom,msg){
			$(dom).addClass('error').siblings('.prompt-box').show().find('span').html(msg);
		},
		hideError:function(dom){
			$(dom).removeClass('error').siblings('.prompt-box').fadeOut(200);
		},
		initTool:function(){
			//是否是手机格式
			window.String.prototype.t_isMobile = function() {
				if(this==""){
					return false;
				}
				return /^0?1[3|4|5|7|8][0-9]\d{8}$/.test(this);
			};
			//是否是邮箱格式
			window.String.prototype.t_isEmail = function(){
				if(this==""){
					return false;
				}
				return /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,5}$/.test(this);
			};
			//密码格式验证
			window.String.prototype.t_passWordCheck = function(){
				if(this==""){
					return false;
				}
				return /.{6,20}/.test(this);
			};
		},
		init:function(){
			logic.initTool();
			logic.eventBind();
		}
	};
	logic.init();
});
/*
*登录页面js
*created by yangzhi on 2015.12.7
*/
((function(window,$){
	var data={
		userInfo:{
			userName:'',
			passWord:'',
			isRememberPwd:false,
			code:''
		},
		dom:{
			userNameTextBox:$('#txtUserName'),
			passWordTextBox:$('#txtPassWord'),
			codeTextBox:$('#txtCode'),
			rememberPwdBtn:$('#remenberPwdBtn'),
			promptBox:$('.js-prompt-text')
		},
		lock:false,
		isNeedCode:false,
		//验证码图片的url地址(须后端填写)
		codeImageUrl:'/user/pictureCode',
		//校验图片路径
		validateUrl:'/secure/showPictureCode',
		//登录提交的地址(须后端填写)
		loginPostUrl:'/login'
	};
	var logic={
		eventBind:function(){
			$('input').focus(function(){
				$(this).removeClass('error');
				logic.hideError();
			});
			$('#txtUserName').blur(function(){
				logic.validate();
			});
			//记住密码
			data.dom.rememberPwdBtn.click(function(){
				$(this).toggleClass('checked');
				data.userInfo.isRememberPwd=!data.userInfo.isRememberPwd;
				return false;
			});
			//更换验证码
			$('.js-changeImageBtn').click(function(){
				logic.changeImageCode();
				return false;
			});
			//提交登录
			$('#submitBtn').click(function(){
				data.userInfo.userName=data.dom.userNameTextBox.val();
				data.userInfo.passWord=data.dom.passWordTextBox.val();
				data.userInfo.code=data.dom.codeTextBox.val();
				var $this=$(this);
				var isError=false;
				if(data.userInfo.userName==''){
					logic.showError('用户名不能为空');
					data.dom.userNameTextBox.addClass('error');
					isError=true;
				}
				if (data.userInfo.passWord=='') {
					logic.showError('密码不能为空');
					data.dom.passWordTextBox.addClass('error');
					isError=true;
				}
				if (data.userInfo.code==''&&data.isNeedCode) {
					logic.showError('验证码不能为空');
					data.dom.codeTextBox.addClass('error');
					isError=true;
				}
				if(isError){
					return false;
				}
				data.lock=true;
				$this.html('登录中...');
				$.ajax({
					url:data.loginPostUrl,
					type:'POST',
					dataType:'json',
					data:{
						username:data.userInfo.userName,
						password:data.userInfo.passWord,
						vCode:data.userInfo.code,
						autoLogin:data.userInfo.isRememberPwd?1:0
					},
					success:function(response){
						if(response==null){
							//跳转到首页、
							location.href='/secure/main';
						}else{
							logic.stopLogin();
							logic.showError(response.errors[0].error);
							if (response.messages != null) {
								if(response.messages[0].field=="showPictureCode"){
									logic.showCodeImage();
									logic.changeImageCode();
								}
							}
						}
						
					},
					error:function(){
						logic.stopLogin();
						logic.showError('系统繁忙，请稍后再试');
					}
				});
				return false;
			});
			
		},
		showError:function(msg){
			data.dom.promptBox.show().find('span').html(msg);
		},
		hideError:function(){
			data.dom.promptBox.fadeOut(200);
		},
		stopLogin:function(){
			data.lock=false;
			$('#submitBtn').html('登 录');
		},
		showCodeImage:function(){
			$('.js-code-box').show();
		},
		changeImageCode:function(){
			$('.js-code-box img').attr('src',data.codeImageUrl+'?'+Math.random());
		},
		validate:function(){
			data.userInfo.userName=data.dom.userNameTextBox.val();
			$.ajax({
				url:data.validateUrl,
				type:'GET',
				dataType:'json',
				data:{
					username:data.userInfo.userName
				},
				success:function(response){
					if(response.messages[0].message=='false'){
						logic.showCodeImage();
						logic.changeImageCode();
					}else{
						//Todo
					}
				}
			});
		},
		init:function(){
			logic.eventBind();
			logic.validate();
		}
	};
	logic.init();
})(window,$));
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
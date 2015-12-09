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
		//登录提交的地址(须后端填写)
		loginPostUrl:'/login'
	};
	var logic={
		eventBind:function(){
			$('input').focus(function(){
				$(this).removeClass('error');
				logic.hideError();
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
						name:data.userInfo.userName,
						pwd:data.userInfo.passWord,
						code:data.userInfo.code,
						isrememberpwd:data.userInfo.isRememberPwd?1:0
					},
					success:function(response){
						if(!response.errors||!response.length){
							alert('登录成功');
							//跳转到首页
							//location.href='/';
						}else{
							logic.stopLogin();
							logic.showError(response.errors[0].msg);
							if(true){
							// if(response.faultThrice){
								logic.showCodeImage();
							}
							logic.changeImageCode();
						}
						
					},
					error:function(){
						logic.stopLogin();
						logic.showError('系统繁忙，请稍后再试');
						if(true){
							// if(response.faultThrice){
								logic.showCodeImage();
							}
							logic.changeImageCode();
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
		init:function(){
			logic.eventBind();
		}
	};
	logic.init();
})(window,$));
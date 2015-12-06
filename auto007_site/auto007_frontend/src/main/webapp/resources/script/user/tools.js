(function (window) {
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
		return /^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/.test(this);
	};
	//用户名验证
	window.String.prototype.t_userNameCheck = function(){
		var str="^[\u4e00-\u9fa5a-zA-Z][\u4e00-\u9fa5a-zA-Z0-9\]{3,19}$";
		var regx=new RegExp(str);
		return regx.test(this);
	};
	//密码格式验证
	window.String.prototype.t_passWordCheck = function(){
		if(this==""){
			return false;
		}
		return /.{6,20}/.test(this);
	};
}(window));
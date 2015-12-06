/**
 * Created by think on 2015/10/27.
 * Modify by yangzhi on 2015/11/25
 */
var app=angular.module('loginApp',[]);
//登录Controller
app.controller('loginController',['$scope','$http',function($scope,$http){
    $scope.user={name:'',pwd:'',isRememberPwd:false,code:""};
    
  //根据用户名，查看是否应该显示图形验证码
    $scope.validateName = function(){
    	var name = $scope.user.name;
    	$http.get('/user/validatePic', {params: {name:name}}).success(function(data){
    		if(data.msg.success == false) {
    			$(".imgcode-box").css("display","block"); 
    		}  
        });
    }
    
    //登录错误信息
    $scope.errorMessage={isError:false,errorDesc:"用户名或密码必填"};
    //是否正在登录进行中
    $scope.isLogining=false;
    //登录按钮文字
    $scope.loginBtnText="登 录";
    //图片验证码链接
    $scope.imgeCodeSrc="/user/validatePicCheck";



    //切换是否记住密码
    $scope.toggleRemenmmberPwd=function(){
        $scope.user.isRememberPwd=!($scope.user.isRememberPwd);
    }
    //切换是否正在登录（flag为true表示正在登录）
    $scope.changeLoginStatus=function(flag){
        if(flag){
            $scope.isLogining=true;
            $scope.loginBtnText="正在登录...";
        }else{
            $scope.isLogining=false;
            $scope.loginBtnText="登 录";
        }
    }
    //更换图片验证码
    $scope.changeImgeCode=function(){
        $scope.imgeCodeSrc="/user/validatePicCheck?"+Math.random();
    }
    //设置错误信息(msg不传则代表当前无错误，否则代表有错误)
    $scope.setError=function(msg){
        if (!msg) {
            $scope.errorMessage.isError=false;            
        }else{
            $scope.errorMessage.isError=true;
            $scope.errorMessage.errorDesc=msg;
        }
    }
    //登录js
    $scope.logins=function(){
        if ($scope.isLogining) {
            return false;
        }
        var name=$scope.user.name;
        var pwd=$scope.user.pwd;
        var code=$scope.user.code;
        var isRememberPwd=$scope.user.isRememberPwd?1:0;
        if(name==''|| pwd==''){
            $scope.setError("用户名和密码必填");
        }else if(pwd.length>100){
            $scope.setError("密码过长");
        } else{
            $scope.setError();
            $scope.changeLoginStatus(true);
            $.ajax({
				url : "/login",
				type : 'POST',
				dataType : 'json',
				data : {
					'username' : name,
					'password' : pwd,
					'autoLogin' : isRememberPwd,
					'vCode' : code
				},
				success : function(rep, textStatus) {
					if (rep.msg.code == 1) {
						//成功跳转到登录页面
						$scope.loginCount = 0;
						window.location.href='/secure/main';
					} else {
						$scope.changeLoginStatus(false);
						if (rep.msg.code == -1) {
							$scope.setError("用户名不存在");
						} else if (rep.msg.code == -2) {
							$scope.setError("密码输入错误");
						} else if (rep.msg.code == -3) {
							$scope.setError("验证码输入错误");
						} else if (rep.msg.code == -4) {
							$(".imgcode-box").css("display", "block");
						} else {
							$scope.setError("系统繁忙，请稍后再试");
						}
					}
				},
				error : function() {
					$scope.changeLoginStatus(false);
					$scope.setError("系统繁忙，请稍后再试");
				}
			});
        }
        return false;
    };
    
    //页面加载就初始化
    $scope.validateName();
}]);


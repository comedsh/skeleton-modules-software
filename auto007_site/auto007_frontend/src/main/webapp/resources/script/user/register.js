
/**
 * Created by yangzhi on 2015/11/26.
 */

var app=angular.module('registerApp',[]);
app.controller('registerController',['$scope','$http',function($scope,$http){
    //当前注册类型(0个人,1企业，2商家)
    $scope.currentRegisterType=0;
    //切换注册panel
    $scope.changePanel=function(type){
        $scope.currentRegisterType=type;
    }
    
    //检查用户名的唯一性
    $scope.$on('UserNameCheck',function (event,userName) {
        var url="/user/validator/username/"+userName;
        $http.post(url).success(function (response) {
            switch($scope.currentRegisterType){
                case 0:
                    $scope.$broadcast("userNameCheckPersonal", response);
                    break;
                case 1:
                    $scope.$broadcast("userNameCheckEnterprise", response);
                    break;
                case 2:
                    $scope.$broadcast("userNameCheckMerchant", response);
                    break;
                default:
                    break;
            }
        }).error(function(){
            switch($scope.currentRegisterType){
                case 0:
                    $scope.$broadcast("userNameCheckPersonal", -1);
                    break;
                case 1:
                    $scope.$broadcast("userNameCheckEnterprise", -1);
                    break;
                case 2:
                    $scope.$broadcast("userNameCheckMerchant", -1);
                    break;
                default:
                    break;
            }
        });
    });
    //发送手机验证码
    $scope.$on('getPhoneCodeCommon',function (event,phone) {
        $http.post('url').success(function(){});
    });
    

}]).controller('personalRegisterController',['$scope','$http',function($scope,$http){
    $scope.user={
        name:'',
        pwd:'',
        pwdRepeat:'',
        email:'',
        phone:'',
        phoneCode:'',
        code:'',
        isAgreeProtol:false
    };
    //初始化错误提示model
    $scope.isTip = {};
    $scope.isWrong = {};
    $scope.isCorrect = {};
    $scope.isShowMsg={};
    $scope.err_name={};

    //图片验证码地址(后台须在此处绑定正确的图片地址)
    $scope.imageCodeSrc="../imgs/code.png?a=124124";
    //改变图片验证码
    $scope.changeImageCode=function () {
        $scope.imageCodeSrc=$scope.imageCodeSrc.split('?')[0]+"?a="+Math.random();
    }
    //用户名验证
    $scope.$on('userNameCheckPersonal',function(event,code){
        if(code>0){
            //用户名可用
            $scope.addCorrectEffects("name");
        }else{
            //用户名不可用
            $scope.addWrongEffects("name","用户名已被注册");
        }
    });
    //用户名格式验证
    $scope.checkUserName=function(){
        if(!$scope.user.name.t_userNameCheck()){
            //用户名格式错误
            return "用户名格式错误";
        }else{
            $scope.$emit("UserNameCheck", $scope.user.name);
            $scope.addCorrectEffects("name","用户名检测中...");
            return "";
        }
    }
    //密码格式验证
    $scope.checkPassWord=function(){
        if(!$scope.user.pwd.t_passWordCheck()){
            //密码格式错误
            return "密码格式错误";
        }else if ($scope.user.pwdRepeat!="" && $scope.user.pwd!=$scope.user.pwdRepeat) {
            return "两次输入密码不一致";
        };
        return "";
    }
    //确认密码验证
    $scope.checkPassWordRepeat=function(){
        if ($scope.user.pwd===$scope.user.pwdRepeat) {
            //两次输入密码不一致
            return "两次输入密码不一致";
        };
        return "";
    }
    //邮箱格式验证
    $scope.checkEmail=function(){
        if(!$scope.user.email.t_isEmail()){
            return "邮箱格式错误";
        }
        return "";
    }
    //手机号验证
    $scope.checkMobile=function(){
        if($scope.user.phone.t_isMobile()){
            return "手机号格式错误";
        }
        return "";
    }
    //文本框获得焦点事件
    $scope.onFocus=function (itemName,message) {
        $scope.resetEffects(itemName);
        $scope.isTip[itemName] = true;
        $scope.err_name[itemName] =  message;
        $scope.isShowMsg[itemName] = true;
    }
    //鼠标失去焦点事件
    $scope.onBlur=function(itemName,elment){
        $scope.resetEffects(itemName);
        var thisElment=$(elment);
        if(!thisElment.val()){
            $scope.addWrongEffects(itemName,thisElment.attr('tip'));
            return false;
        }
        if(thisElment.attr("othercheck")){
           var errorMsg=eval(thisElment.attr("othercheck"));
           if (errorMsg) {
                $scope.addWrongEffects(itemName,errorMsg);
                return false;
           };
        }
        $scope.addCorrectEffects(itemName);  
    }
    //重置提示信息
    $scope.resetEffects = function(itemName){
        $scope.isTip[itemName] = false;
        $scope.isWrong[itemName] = false;
        $scope.isCorrect[itemName] = false;
        //$scope.input_style[itemName] = "";
    }
    //显示正确提示
    $scope.addCorrectEffects=function(itemName,message){
        $scope.resetEffects(itemName);
        //$scope.input_style[itemName] = "border: 1px solid red";
        $scope.isCorrect[itemName] = true;
        $scope.err_name[itemName] =  message||"输入正确";
    }
    //显示错误提示
    $scope.addWrongEffects = function(itemName,message){
        $scope.resetEffects(itemName);
        //$scope.input_style[itemName] = "border: 1px solid red";
        $scope.isWrong[itemName] = true;
        $scope.err_name[itemName] =  message||"不能为空";
    }
    //获取手机验证码
    $scope.getPhoneCode=function(){
        if (!$scope.user.phone.t_isMobile()) {
            $scope.addWrongEffects('phone','手机号格式错误');
        }else{
            $scope.sendPhoneCodeTimeOutCount=300;
            $scope.sendPhoneCodeTimeOut();
            $(".content-personal .phone-code-btn").css("background-color","#aaa");
            $scope.$emit("getPhoneCodeCommon", $scope.user.phone);
        }
    }
    //获取手机验证码倒计时秒数
    $scope.sendPhoneCodeTimeOutCount=0;
    //获取手机验证码倒计时
    $scope.sendPhoneCodeTimeOut=function () {
        if($scope.sendPhoneCodeTimeOutCount<=0){
            $(".content-personal .phone-code-btn").html("获取手机验证码");
            $(".content-personal .phone-code-btn").css("background-color","");
        }else{
            $(".content-personal .phone-code-btn").html($scope.sendPhoneCodeTimeOutCount+"秒后重发");
            $scope.sendPhoneCodeTimeOutCount--;
            setTimeout(function(){
                $scope.sendPhoneCodeTimeOut();
            }, 1000);
            
        }
    }

    //提交注册
    $scope.submit=function(){
        //是否同意用户协议
        if (!$scope.user.isAgreeProtol) {
            return false;
        };
        var isAllCorrect=true;
        //遍历对象，判断是否所有属性都没有错误
        for(var name in $scope.user){
            if(!$scope.isCorrect[name]===true){
                if(document.getElementsByName(name)[0]){
                    document.getElementsByName(name)[0].focus();
                    document.getElementsByName(name)[0].blur();
                }
                isAllCorrect=false;
            }
        }
        if (!isAllCorrect) {
            return false;
        };
        $http({                   
            method  : 'POST',
            
            url     : '/spittle',
            
            data    : $scope.user,  // pass in data as strings
        
            headers : { 'Content-Type':'application/json' }  
        
        }).success(function(data){
            
            // 重置 errors 信息
            // $scope.err_username="";
            // $scope.err_text="";
            
            // handles the errors message
            if( data.errors.length > 0 ){
                
                angular.forEach( data.errors, function(value, key){ // value -> labelError class
                    
                    eval("$scope.addWrongEffects('"+value.field+"','"+value.error+"')");
                });
            
            }
            
        });
        alert(1);
    }


}]).controller('merchantRegisterController',['$scope','$http',function($scope,$http){

    
}]).controller('enterpriseRegisterController',['$scope','$http',function($scope,$http){
    
    
}]);

app.directive('text',function(){
    return function(scope,element,attrs){
        element.bind('focus',function(){
            //$(this).parent().addClass('focus').removeClass('error').removeClass('correct').siblings('.warning-prompt').show();
            scope.onFocus(attrs['name'],attrs['tip']);
            scope.$digest();

        });
        element.bind('blur',function(){
            //$(this).parent().removeClass('focus').siblings('.warning-prompt').hide().find('.clear-ico').hide();
            scope.onBlur(attrs['name'],element);
            scope.$digest();

        });
    }
});

//Jquery代码
$(function(){
	$(".js-protocol").click(function(){
		$(".js-protocol-layer").fadeIn(200);
	        return false;
		});
    $(".js-close-protocol-btn").click(function(){
        $(".js-protocol-layer").fadeOut(200);
        return false;
    });
}); 
$(function() {

//    //所有input获得焦点时的状态
//    $('.chren_div .input_d input').focus(function(event){
//        $(this).parent().css({
//            border:'1px solid blue'
//        })
//        $(this).parent().parent().find('.remove_d').css({
//        	display:'block'
//        });
//        $(this).parent().parent().children('.user_error1').show();
//        $(this).parent().parent().children('.user_error2').hide();
//        $(this).parent().parent().children('.user_error3').hide();
//    });
//    //清除输入内容  有bug
//    $('.remove_d').on('click',function(){
//        if($(this).prev().find('input').val().length>0){
//            $(this).prev().find('input').val('');
//            $(this).prev().css({
//                border:'1px solid red'
//            });
//            $(this).parent().children('.user_error1').hide();
//            $(this).parent().children('.user_error3').hide();
//            $(this).parent().children('.user_error2').show().html("不能为空");
//        }else{
//            return false;
//        }
//    });
    
    //user_name验证
//    $('.name').blur(function(){
//    	var str = $(this).parent();
//        $(this).parent().parent().children('.user_error1').hide();
//        $(this).parent().parent().children('.user_error3').hide();
//        if($(this).val() == ""){
//            $(this).parent().css({
//                border:'1px solid red'
//            });
//            $(this).parent().parent().children('.user_error2').show().html("用户名不能为空");
//            $(this).parent().parent().children('sub_name').val('1');
//            return false;
//        }
//        var re =/^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]{3,19}$/;
//        if(!re.test($(this).val())){
//            $(this).parent().css({
//                border:'1px solid red'
//            });
//            $(this).parent().parent().children('.user_error2').show().html("用户名格式不正确");
//            $(this).parent().parent().children('sub_name').val('1');
//            return false;
//        }else{
//        	$.ajax({
//                type: "GET",
//                url: "/validator/username/"+$(this).val(),                
//                dataType: "json",
//                success: function (data) {
//                    if(data != null) {
//                    	$(str).css({
//                            border:'1px solid red'
//                        });
//                    	$(str).parent().children('.user_error2').show().html("该用户名已经被注册，请更换用户名");
//                    	$(str).parent().children('.sub_name').val('1');
//                    } else {
//                    	$(str).css({
//                            border:'1px solid #2FA840'
//                        });
//                    	$(str).parent().children('.sub_name').val('0');
//                        $(str).parent().children('.user_error2').hide();
//                        $(str).parent().children('.user_error3').show();
//                        //失去焦点时，隐藏X图标
//                        var as= $(str).parent().children('.user_error3').css('display');
//                        if(as=='block'){
//                            $(str).parent().children('.remove_d').hide();
//                        
//                        }
//                    }
//                }
//            });
//        }
//    });

    
});

angular.module('Registered_app',[])

.controller("personalRegisterCcontroller", function personalRegisterController($scope, $http) {
								
								$scope.formdata = {};							
								
								$scope.regexp = /^[a-zA-Z\u4e00-\u9fa5][a-zA-Z0-9\u4e00-\u9fa5]{3,19}$/;
								
								$scope.nameOnFocus = function(){
									$scope.resetEffects();
									$scope.isTip = true;
									$scope.err_name =  "4-20位字符,支持汉字、字母、数字的组合,不能以数字开头";									
								}
								
								$scope.resetEffects = function(){
									$scope.isTip = false;
									$scope.isWrong = false;
									$scope.isCorrect = false;
									$scope.input_styple = "";
								}
								
								$scope.addWrongEffects = function(){
									$scope.resetEffects();
									$scope.input_style = "border: 1px solid red";
									$scope.isWrong = true;									
								}
								
								$scope.nameOnBlur = function(){
									
									if( $scope.formdata.name == "" || typeof($scope.formdata.name) == "undefined") {
										
										$scope.addWrongEffects();
										
										$scope.err_name = "用户名不能为空";
										
									}else if( !$scope.regexp.test( $scope.formdata.name ) ){
										
										$scope.addWrongEffects();
										
										$scope.err_name = "用户名格式不正确";
										
									}else{
										
										// validate by angular js through database validation.
										// restful invoke, /user/validator/username/{value}
										var url = "/user/validator/username/"+$scope.formdata.name;
										
		   								$http.get(url).success( function( mto ) { // message transfer object
		   									
		   									// if errors, handles it -> @TODO below part codes can be re-used; 
	   										if( mto.errors != null && mto.errors.length > 0 ){
	   											
	   											$scope.addWrongEffects();
	   											
	   											angular.forEach( mto.errors, function(value, key){ // value -> labelError class
	   												
	   												console.log( value.field +";"+ value.error );	

	   												// * 下面这段代码就可以自动帮你回显错误了 ~ 统一处理错误信息*
	   												eval("$scope.err_"+value.field+"='"+value.error+"'"); 
	   												
	   											});
	   										
	   										}else{
	   											
	   											$scope.resetEffects();
	   											
	   											$scope.isCorrect = true
	   											
	   											$scope.err_name = "用户名输入正确";	
	   											
	   										}
	   										
	   										
		   								});
		   																	
										
									}
								
								}
								
							    $scope.addSpittle = function(){
							    	
							    	console.log("post 2~");
							    	
   									$http({
	   									
   										method  : 'POST',
	   							        
	   									url     : '/spittle',
	   							        
	   							        data    : $scope.formdata,  // pass in data as strings
	   							    
	   							        headers : { 'Content-Type':'application/json' }  
   									
   									}).success(function(data){
   										
   										console.log("recall success"+data);
   										
   										// 重置 errors 信息
   										$scope.err_username="";
   										$scope.err_text="";
   										
   										// handles the errors message
   										if( data.errors.length > 0 ){
   											
   											angular.forEach( data.errors, function(value, key){ // value -> labelError class
   												
   												console.log( value.field +";"+ value.error );	
   												
   												// eval("$scope.err_username = '错啦'");  |  $scope.err_username = '错啦'
   												// * 下面这段代码就可以自动帮你回显错误了 ~ *
   												eval("$scope.err_"+value.field+"='"+value.error+"'"); 
   												
   											});
   										
   										}
   										
   										console.log( "add success ~ " );
   										
   									});
   									
							    }
								
							}
); 



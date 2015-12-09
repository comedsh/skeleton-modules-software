<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html  ng-app="fileUpload" >
  <head>
  
    <title>SKU发布</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="<%=request.getContextPath() %>/resources/css/common/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/resources/css/common/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath() %>/resources/css/common/styles.css" type="text/css" rel="stylesheet"/>
 <link rel="icon" href=""/>
       <link rel="icon" href=""/>

	<script type="text/javascript" src="/resources/js/lib/fenghua.lib.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/javaScript/jQuery/json2.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/script/user/placeholder.js"></script>

   <script src="/resources/javaScript/upload/ng-file-upload-shim.js"></script>
  <script src="/resources/javaScript/upload/ng-file-upload.js"></script>
    <script type="text/javascript">
  function saveproduct1(){
 
	  var oebrands='';
	$("select[name='oebrand']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			oebrands += elem.value+";";
		}else{
			oebrands +=0+";";
		}
	});
	$("#oebrands").val(oebrands);
	var oeCodes='';
	$("input[name='oeCode']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			oeCodes += elem.value+";";
		}else{
			oeCodes +=0+";";
		}
	});
	$("#oeCodes").val(oeCodes);
	var imageBigs='';
	$("input[name='imageBig']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			imageBigs += elem.value+";";
		}else{
			imageBigs +=0+";";
		}
	});
	$("#imageBigs").val(imageBigs);
	
	var imageSmalls='';
	$("input[name='imageSmall']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			imageSmalls += elem.value+";";
		}else{
			imageSmalls +=0+";";
		}
	});
	$("#imageSmalls").val(imageSmalls);
	
	var attrNames='';
	$("select[name='attr_name']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			attrNames += elem.value+";";
		}else{
			attrNames +=0+";";
		}
	});
	$("#attrNames").val(attrNames);
	
	var attrContents='';
		$("input[name='attr_contents']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			attrContents += elem.value+";";
		}else{
			attrContents +=0+";";
		}
	});
		 $("#attrContents").val(attrContents);
	 	 $('#product_saveform').attr('action','/product/saveProduct/');
	 	 $('#product_saveform').submit();
  }
  //立即上架
    function publishImediat(){
	  var oebrands='';
	$("select[name='oebrand']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			oebrands += elem.value+";";
		}else{
			oebrands +=0+";";
		}
	});
	$("#oebrands").val(oebrands);
	var oeCodes='';
	$("input[name='oeCode']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			oeCodes += elem.value+";";
		}else{
			oeCodes +=0+";";
		}
	});
	$("#oeCodes").val(oeCodes);
	var imageBigs='';
	$("input[name='imageBig']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			imageBigs += elem.value+";";
		}else{
			imageBigs +=0+";";
		}
	});
	$("#imageBigs").val(imageBigs);
	
	var imageSmalls='';
	$("input[name='imageSmall']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			imageSmalls += elem.value+";";
		}else{
			imageSmalls +=0+";";
		}
	});
	$("#imageSmalls").val(imageSmalls);
	
	var attrNames='';
	$("select[name='attr_name']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			attrNames += elem.value+";";
		}else{
			attrNames +=0+";";
		}
	});
	$("#attrNames").val(attrNames);
	
	var attrContents='';
		$("input[name='attr_contents']").each(function(index,elem){
		if( elem.value!=null&& elem.value!='') {
			attrContents += elem.value+";";
		}else{
			attrContents +=0+";";
		}
	});
	$("#attrContents").val(attrContents);
	$('#product_saveform').attr('action','/product/publishImediat/');
	$('#product_saveform').attr('target','');//不做页面跳转
 	 $('#product_saveform').submit();
  }
  //
    function setUniteSign(elem){
      if(elem==0){
      $("#brand_add").css("display","none");
      $("select[name='oebrand']").each(function(index,elem){
			elem.value='';
	  });
	  $("input[name='oeCode']").each(function(index,elem){
			elem.value='';
		});
      }else{
       $("#brand_add").css("display","");
      }
      } 
   angular.module("fileUpload", ['ngFileUpload'])

	//var todos=[];
.controller('MyCtrl', ['$scope', 'Upload', '$timeout', function ($scope, Upload, $timeout) {
    $scope.todos = [];
		 $scope.uploadFiles = function(file, errFiles) {
		 if($scope.todos.length>=5){
    	$scope.err_smallUrl='最多只能上传5张图片';
    }else{
	        $scope.f = file;
	        $scope.errFile = errFiles && errFiles[0];
	        if (file) {
	            file.upload = Upload.upload({
	                url: '/upload/uploadFile',
	                data: {upload: file,attType:'logo'}
	            });
	            file.upload.then(function (response) {
	            if(response.data.message.success) {
	            	//$scope.uploadmessage=response.data.message;
	            	   $scope.todos.push({imageBig:response.data.message.pathBig, imageSmall:response.data.message.pathSmall,num:$scope.todos.length+1});
	            	 
	            }
	            });
	        }   
	   }
      } ;
      //删除指定图片
   $scope.deletePicture= function(elem) {
	       $('#imageSmall_'+elem).val('');
		   $('#imageBig_'+elem).val('');
		 	$('.img_'+elem).attr('src','');
			$scope.todos[elem-1]={imageBig:'0', imageSmall:'0',num:0};
			var oldTodos = $scope.todos;
                        $scope.todos = [];
                        angular.forEach(oldTodos, function(todo) {
                            if (todo.imageBig!='0' && todo.imageSmall!='0'){ 
                             $scope.todos.push({imageBig:todo.imageBig, imageSmall:todo.imageSmall,num:$scope.todos.length+1});
	                            }
                        });
      };
}
])	
 .controller("checkerrror", function checkerrror($scope, $http) {
		$scope.formdata = {};
        $scope.saveproductandCheckError = function(elem){ 
     if($('#imageSmall_1').val()==null || $('#imageSmall_1').val()=='' ){
     	$scope.formdata.smallUrl=null;
     }else{
       $scope.formdata.smallUrl=$('#imageSmall_1').val();
     }
     	$http({
		   										method  : 'POST',
			   									url     : '/product/checkError/',
			   							        data    : $scope.formdata,  // pass in data as strings
			   							        headers : { 'Content-Type':'application/json' }  
		   									
		   									}).success(function(data){
		   										// 重置 errors 信息
		   										$scope.err_code="";
		   										$scope.err_title="";
		   										$scope.err_brand="";
		   										$scope.err_smallUrl="";
		   										$scope.err_contentsHtml="";
		   										$scope.err_stockCount="";
		   										$scope.err_salePrice="";
		   										$scope.err_price="";
	
		   										// handles the errors message
		   										if(data.errors!=null && data.errors.length > 0 ){
		   											angular.forEach( data.errors, function(value, key){ 
		   												console.log( value.field +";"+ value.error );	
		   												eval("$scope.err_"+value.field+"='"+value.error+"'"); 
		   												
		   											});										
		   										}else{
			   										if(elem==1){
			   											saveproduct1();
			   										}else if(elem==2){
			   											publishImediat();
			   										}
		   										
		   										}
		   										console.log( "add success ~ " );
		   										
		   									});
     }
}
);




//新增适配信息
function addBrand(){
	var len = $('#brand_add').children('td').length+1;	
	var str='<td style="margin-top: 20px">'+
				 '<select id="oebrand" name="oebrand">'+
		         ' <option  value="1" >车品牌1</option>'+
		         ' <option value="2" >车品牌2</option>'+
		     	 '</select>'+
		      	' OE号 <input id="oeCode" name="oeCode" type="text" value=""/>'+
	       	 '</td> ';
	$('#brand_add').append(str);
	
}
function addAttr(){
var str=' <div style="margin-top: 20px">'+
	       	  ' <select name="attr_name" id="attr_name1">'+
	          '<option  value="长度"  >长度</option>'+
	          ' <option value="宽度" >宽度</option>'+
	          '<option value="高度" >高度</option>'+
	          '<option value="厚度" >厚度</option>'+
	          '<option value="体积（立方厘米）">体积（立方厘米）</option>'+
	          '<option value="容量（立方厘米）" >容量（立方厘米）</option>'+
	          '<option value="直径（厘米）">直径（厘米）</option>'+
	          '<option value="重量（克）" >重量（克）</option>'+
	          '<option value="热值（卡）" >热值（卡）</option>'+
	          '<option value="电阻（欧姆）" >电阻（欧姆）</option>'+
	          '<option value="等级" >等级</option>'+
	          '<option value="颜色" >颜色</option>'+
	          '<option value="材质" >材质</option>'+
	          '<option value="其他">其他</option>'+
	         '</select>'+
             ' <input  type="text" value="" name="attr_contents" id="attr_contents1"/>'+
     ' </div>';
     $('#attr_add').append(str);
}
    </script>
  </head>
  <body>
 <div ng-controller="checkerrror">
<form action="" method="post" target="_blank" id="product_saveform">

      <div style="margin-top: 20px">
      <p><span style="color:#FF0000;">*</span>
          SKU编号 <input name="code" size="15" maxlength="15"  ng-model="formdata.code"/>
      			 <span class="error" style="color:#FF0000;" ng-show="err_code">{{ err_code }}</span>
      </div>
      
	  <div style="margin-top: 20px">
	   <p><span style="color:#FF0000;">*</span>
   		    商品标题：<input path="title" name="title" type="text" value="" ng-model="formdata.title"/>
               <span class="error" ng-show="err_title" style="color:#FF0000;">{{ err_title }}</span>
      </div>
 	  <div style="margin-top: 20px">
 	   <p><span style="color:#FF0000;">*</span>
                            商品品牌：  <input path="brand" type="text" name="brand" value="" ng-model="formdata.brand"/>
         		<span class="error" style="color:#FF0000;" ng-show="err_brand">{{ err_brand }}</span>
          <select id="type" name="type">
	          <option selected value="2">原厂件</option>
	          <option value="3">品牌件</option>
         </select>
      </div>
       <div style="margin-top: 20px">
        <p><span style="color:#FF0000;">*</span>
       		库存量： 
       		<input id="stockCount" type="text" name="stockCount" value="" ng-model="formdata.stockCount"/>
        <span class="error" style="color:#FF0000;" ng-show="err_stockCount">{{err_stockCount}}</span>
      </div>
       <div style="margin-top: 20px">
        <p><span style="color:#FF0000;">*</span>
    	    现价: <input id="salePrice" name="salePrice" type="text" value="" ng-model="formdata.salePrice"/>
     	 <span class="error" style="color:#FF0000;" ng-show="err_salePrice">{{ err_salePrice }}</span>
     	  <p><span style="color:#FF0000;">*</span>
    	    原价: <input id="price" name="price" type="text" ng-model="formdata.price" value=""/>
         <span class="error" style="color:#FF0000;" ng-show="err_price">{{ err_price}}</span>   
      </div>
      <div style="margin-top: 20px">
       <p><span style="color:#FF0000;">*</span>
     	<td>适配性</td>
		<td>
			<label><input type="radio" value="0" name="check" onclick="setUniteSign(this.value)" />通用配型</label>
			<label><input type="radio" value="1" name="check" onclick="setUniteSign(this.value)" checked="checked"/>专用车型 </label>
 		<a href="javascript:void(0);" onclick="addBrand()">新增车型和OE号</a>
		</td>
		</div>
		<div id="brand_add" style="margin-top: 20px">
			<div style="margin-top: 20px">
				 <select id="oebrand" name="oebrand">
		          <option  value="1" >车品牌1</option>
		          <option value="2" >车品牌2</option>
		     	 </select>
		      	 OE号 <input id="oeCode" name="oeCode" type="text" value=""/>
	        </div> 
         
        </div>
        <div>
        <div style="margin-top: 20px">
        商品属性：
        <a href="javascript:void(0);" onclick="addAttr()">新增商品属性</a>
        <div id="attr_add" style="margin-top: 20px">
         <div style="margin-top: 20px">
	        <select name="attr_name" id="attr_name1">
	          <option  value="长度"  >长度</option>
	          <option value="宽度" >宽度</option>
	          <option value="高度" >高度</option>
	          <option value="厚度" >厚度</option>
	          <option value="体积（立方厘米）">体积（立方厘米）</option>
	          <option value="容量（立方厘米）" >容量（立方厘米）</option>
	          <option value="直径（厘米）">直径（厘米）</option>
	          <option value="重量（克）" >重量（克）</option>
	          <option value="热值（卡）" >热值（卡）</option>
	          <option value="电阻（欧姆）" >电阻（欧姆）</option>
	          <option value="等级" >等级</option>
	          <option value="颜色" >颜色</option>
	          <option value="材质" >材质</option>
	          <option value="其他">其他</option>
	        </select>
          <input  type="text" value="" name="attr_contents" id="attr_contents1"/>
      </div>
      </div>
        </div>
        </div>




<div ng-controller="MyCtrl" style="margin-top: 20px">
 <td>
  <p><span style="color:#FF0000;">*</span>
 商品图片：
<button type="file" ngf-select="uploadFiles($file, $invalidFiles)" accept="image/*" ngf-max-height="1000" ngf-max-size="1MB">
     本地上传商品图片</button>
    <span class="error" style="color:#FF0000;" ng-show="err_smallUrl">{{ err_smallUrl}}</span> 
    <div>
	    <span ng-repeat="todo in todos" >
			 <input type="hidden" name="imageBig" id="imageBig_{{todo.num}}"  value="{{todo.imageBig}}" ng-model="imageBig">
			 <input type="hidden" name="imageSmall" id="imageSmall_{{todo.num}}" value="{{todo.imageSmall}}" ng-model="imageSmall">
			 <img style="width: 85px ; height: 85px;" class="img img_{{todo.num}}"  src="<%=basePath%>/{{todo.imageSmall}}"/>
			 <a href="javascript:void(0);" ng-click="deletePicture(todo.num);">删除</a>
	 	</span>
 	</div>
 </td>
 </div>
 <div style="margin-top: 20px">
  <p><span style="color:#FF0000;">*</span>
 商品描述：
  <input type="hidden"  id="checkErrorPicture" name="smallUrl" ng-model="formdata.smallUrl" value="">
 <input type='text' width="3000px" name="contentsHtml" id="contentsHtml" ng-model="formdata.contentsHtml" height="2000px"/>
     <span class="error" style="color:#FF0000;" ng-show="err_contentsHtml">{{ err_contentsHtml}}</span>
 </div>
	 <input type="hidden" name="id" value="0" id="skuId">
	 <input type="hidden" name="oebrands" id="oebrands"/>
      <input type="hidden" name="oeCodes" id="oeCodes"/>
      <input type="hidden" name="imageSmalls" id="imageSmalls">
      <input type="hidden" name="imageBigs" id="imageBigs">
      <input type="hidden" name="attrNames" id="attrNames">
      <input type="hidden" name="attrContents" id="attrContents">
      
     
 </form> 
  <div id="u149" class="ax_html__">
      <input id="u175_input" type="submit" value="立即发布" ng-click="saveproductandCheckError(2)"/>
     
       <input id="u175_input" type="submit" value="保存，暂不上架" ng-click="saveproductandCheckError(1)"/>
      </div>
    
  
 </div>  
  </body>

</html>

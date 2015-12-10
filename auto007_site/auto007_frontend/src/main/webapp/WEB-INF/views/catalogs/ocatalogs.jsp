<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<style type="text/css">
div{overflow: hidden;}
.fl{float: left;}
.bd{border: 1px solid #ddd;}
.p10{padding: 10px;}
.show{display: block;}.hidden{display: none;}

ul li{float: left;}

ul.ocatalogsUL{}
ul.ocatalogsUL li{width: 100px;height: 100px;margin: 5px 5px 0 0;border: 1px solid #ddd;}
ul.ocatalogsUL li div{text-align: center;}
ul.ocatalogsUL li:hover{border: 1px solid green;cursor: pointer;}
ul.modelUl{overflow: hidden;}
ul.modelUl li{padding: 5px;background: #eee;margin: 1px;border: 1px solid #eee;}
ul.modelUl li:hover{border: 1px solid green;cursor: pointer; color:green;}

.modelTable{}
.modelTable thead{}
.modelTable tbody{}
.modelTable tbody tr{}
.modelTable tbody tr:hover{cursor: pointer; color:green; background: #eee;}

.oNav{overflow: hidden;clear: both;padding: 0 5px;margin: 0 0 10px 0;}
.oNav div{padding: 10px 5px;border: 1px solid #ccc;margin: 5px;float: left;}
.oNav div.on{border-color: red;color: red;}

.brandNav {overflow: hidden;clear: both;}
.brandNav li{float: left;margin: 0 10px;}
.brandNav li:hover{cursor: pointer;color: red;}


#modelContent{height: 300px;overflow-y: auto;}

/**/
.content{
 background:none!important;
}
</style>

<link rel="stylesheet" href="/resources/css/login.css">
<div class="w">

	<div class="oNav bd">
		<div class ="on">原厂目录：</div>
		<div class ="on">选择品牌<b id="selectedBrand"></b></div>
	</div>

	<div>

		<div id="brandListDiv" class="model bd p10 show">
			<ul class="brandNav">
				<li>A</li><li>B</li><li>C</li><li>D</li><li>E</li><li>F</li><li>G</li><li>H</li>
				<li>I</li><li>J</li><li>K</li><li>L</li><li>M</li><li>N</li><li>O</li><li>P</li><li>Q</li>
				<li>R</li><li>S</li><li>T</li><li>U</li><li>V</li><li>W</li><li>X</li><li>Y</li><li>Z</li>
			</ul>
		
			<ul class="ocatalogsUL">
				<c:forEach items="${brandList}" var="brand">
					<li>
						<img alt="${brand.brand_zh}" src="http://www.auto007.com${brand.img_path}">
						<div brand="${brand.brand}" sets="${brand.sets_zh}">${brand.brand_zh}</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="modelContent" class="model bd p10 hidden" layer_id="1">
			加载中......
		</div>
	
	</div>

	<div class="bd p10" style="height: 500px;">
	
	</div>

</div>


<script type="text/javascript">
ocatalogDataObj = {};

$("#brandListDiv .ocatalogsUL li").click(function(){
	$(".model").removeClass("show");
	$(".model").addClass("hidden");
  	
	$("#modelContent").removeClass("hidden");
	$("#modelContent").addClass("show");
	
	var sBrand = $("div",this).attr("brand");
	var sBrandCn = $("div",this).text();
	
	ocatalogDataObj[sBrand]={};
	ocatalogDataObj[sBrand].brandName = sBrandCn;
	ocatalogDataObj[sBrand].layersData = {};
	
	$.ajax({
	   type:"GET",
	   url:"/ocatalogs/brand/"+sBrand,
	   dataType:"json",
	   beforeSend: function(){
		   $("#selectedBrand").text('('+sBrandCn+')');
	   }, 
	   success: function(data){

		   ocatalogDataObj[data.brand].configLayers = data.configLayers;
		   ocatalogDataObj[data.brand].layersData[data.layer_id]={};
		   
		   ocatalogDataObj[data.brand].layersData[data.layer_id].configFields = data.configFields;
		   ocatalogDataObj[data.brand].layersData[data.layer_id].dataList = data.dataList;
		   
		   for(var li = 0;li<data.configLayers.length;li++){
			   if(li == 0){
				   $(".oNav").append('<div id="layer_id_'+data.configLayers[li].id+'" class ="on">选择'+data.configLayers[li].cat_name_cn+'<b></b></div>');
			   } else {
				   $(".oNav").append('<div id="layer_id_'+data.configLayers[li].id+'">选择'+data.configLayers[li].cat_name_cn+'<b></b></div>');
			   }
		   }
		   
		   $("#modelContent").html('');
		   
		   var htmlStr = '';
		   if(data.configFields && data.configFields.length > 1){
			   
		   } else {
			   htmlStr += '<ul class="modelUl">';
			   var dr = null;
			   for(var i = 0; i< data.dataList.length; i++){
				   dr =  data.dataList[i];
				   //htmlStr += "<li>";
				   htmlStr += "<li data = '"+JSON.stringify(dr)+"'>";
				   //htmlStr += '<img alt="'+dr.model_name+'" src="http://www.auto007.com'+dr.img_path+'">';
				   htmlStr += '<div>'+dr[data.configFields[0].field_name]+'</div>';
				   htmlStr += '</li>';
			   }
			   htmlStr += '</ul>';
		   }
		   $("#modelContent").append(htmlStr);
		   $("#modelContent").attr('brand', data.brand);
		   $("#modelContent").attr('layer_id', data.layer_id);
	   }, 
	   error: function(){
		   
	   },
	   complete: function(data){
		   //alert(data);
	   }
	});
});


$("#modelContent .modelTable tr").live("click",function(){
	var data = eval("(" + $(this).attr("data") + ")");
	var brand = $("#modelContent").attr("brand");
	var layerId = $("#modelContent").attr("layer_id");
	var value = $('td',this).first().text();
	getModel(brand, layerId, data, value)
});

$("#modelContent .modelUl li").live("click",function(){
	var data = eval("(" + $(this).attr("data") + ")");
	var brand = $("#modelContent").attr("brand");
	var layerId = $("#modelContent").attr("layer_id");
	var value = $('div',this).text();
	getModel(brand, layerId, data, value);
});

function getModel(brand, layerId, data, value){
	var paramUrl = "";
	for (key in data) {
	    paramUrl += key;
	    paramUrl += "=";
	    paramUrl += data[key];
	    paramUrl += "&";
	}
	
	paramUrl = paramUrl.substring(0, paramUrl.length-1);
	
	$.ajax({
	   type:"GET",
	   url:"/ocatalogs/brand/"+brand+"/model/layer-"+layerId +"?"+paramUrl,
	   dataType:"json",
	   beforeSend: function(){
		   $("#layer_id_"+layerId+" b").text('('+value+')');
		   
		   $("#modelContent").html('加载中......');
	   }, 
	   success: function(data){
			ocatalogDataObj[data.brand].layersData[data.layer_id]={};
		   
		   	ocatalogDataObj[data.brand].layersData[data.layer_id].configFields = data.configFields;
		   	ocatalogDataObj[data.brand].layersData[data.layer_id].dataList = data.dataList;
		   	
		   	$("#modelContent").html('');
		   	
		   	$("#layer_id_"+data.layer_id).addClass("on");
		   	
		   	var htmlStr = '';
			if(data.configFields && data.configFields.length > 1){
				htmlStr += '<table class="modelTable">';
				htmlStr += '<thead>';
				htmlStr += '<tr>';
				for(var fi = 0; fi< data.configFields.length; fi++){
					var field = data.configFields[fi];
					htmlStr += '<th>';
					htmlStr += field.field_title_cn;
					htmlStr += '</th>';
				}
				htmlStr += '</tr>';
				htmlStr += '</thead>';
				htmlStr += '<tbody>';
				
				for(var i = 0; i< data.dataList.length; i++){
					var dr =  data.dataList[i];
					htmlStr += "<tr data='"+JSON.stringify(dr)+"'>";
					for(var fi = 0; fi< data.configFields.length; fi++){
						var field = data.configFields[fi];
						htmlStr += '<td>';
						htmlStr += dr[field.field_name];
						htmlStr += '';
						htmlStr += '';
						htmlStr += '';
						htmlStr += '</td>';
					}
					htmlStr += '</tr>';
			 	}
				htmlStr += '</tbody>';
				htmlStr += '</table>';
			} else {
			 	htmlStr += '<ul class="modelUl">';
			 	var dr = null;
			 	for(var i = 0; i< data.dataList.length; i++){
					  dr =  data.dataList[i];
					  htmlStr += "<li data = '"+JSON.stringify(dr)+"'>";
					  htmlStr += '<div>'+dr[data.configFields[0].field_name]+'</div>';
					  htmlStr += '</li>';
			 	}
				htmlStr += '</ul>';
			}
			$("#modelContent").append(htmlStr);
			$("#modelContent").attr('brand', data.brand);
			$("#modelContent").attr('layer_id', data.layer_id);
	   }, 
	   error: function(){
		   
	   },
	   complete: function(data){
		   //alert(data);
	   }
	});
}
</script>



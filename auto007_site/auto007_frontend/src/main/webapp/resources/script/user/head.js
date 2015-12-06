//页面头部Controller
app.controller('headerController',['$scope','$http',function($scope,$http){
    //城市是否是hover状态
    $scope.isCityActive=false;
    $scope.currentCity={id:3,cityName:"上海"};
    //全部城市列表
    $scope.allCity=[
        {id:1,cityName:"成都"},
        {id:2,cityName:"北京"},
        {id:3,cityName:"上海"},
        {id:4,cityName:"广州"},
        {id:5,cityName:"深圳"},
        {id:6,cityName:"香港"},
        {id:7,cityName:"天津"},
        {id:8,cityName:"西安"},
        {id:9,cityName:"兰州"},
        {id:10,cityName:"杭州"}
    ];
    //请求接口，获取城市列表
    // $http.get("httpurl").success(function(response) {
    //     scope.allCity=response;
    // });
    //改变当前城市
    $scope.changCurrentCity=function(cityIndex){
        $scope.currentCity=$scope.allCity[cityIndex];
    }
    $scope.mouseOver=function(){
        $scope.isCityActive=true;
    }
    $scope.mouseLeave=function(){
        $scope.isCityActive=false;
    }
}]);
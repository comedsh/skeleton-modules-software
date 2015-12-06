(function () {
	'use strict'

	angular.module('app')
	.controller('HeaderController', HeaderController);

	HeaderController.$inject = ['$scope', '$http'];

	function HeaderController($scope, $http) {
		var vm = this;
		vm.click = click;

		////////////////////////////////////////////

		function click() {
			alert('header111');
		}
	}
})();
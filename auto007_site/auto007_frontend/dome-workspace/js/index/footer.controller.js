(function () {
	'use strict'

	angular.module('app')
	.controller('FooterController', FooterController);

	FooterController.$inject = ['$scope', '$http'];

	function FooterController($scope, $http) {
		var vm = this;
		vm.click = click;

		////////////////////////////////////////////

		function click() {
			alert('footer');
		}
	}
})();
class legalClientConsultController {

	constructor(
		public $scope,
		public $state,
		public $interval,
	) { }



}

legalClientConsultController['$inject'] = [
	'$scope',
	'$state',
	'$interval',
]


export default legalClientConsultController;
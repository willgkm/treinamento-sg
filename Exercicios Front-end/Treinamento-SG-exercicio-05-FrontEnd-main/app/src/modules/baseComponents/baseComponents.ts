import './baseComponents.scss'
import template from './baseComponents.html'

class baseComponentsController {

  constructor(
    public $scope,
    public $state,
    public $interval,
  ) {}

}

baseComponentsController['$inject'] = [
  '$scope',
  '$state',
  '$interval',
]

const baseComponents = {
  controller:baseComponentsController,
  controllerAs:'$ctrl', 
  templateUrl: template
}

export default baseComponents;
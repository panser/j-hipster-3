(function() {
    'use strict';

    angular
        .module('jHipster3App')
        .controller('EntryDetailController', EntryDetailController);

    EntryDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'entity', 'Entry'];

    function EntryDetailController($scope, $rootScope, $stateParams, entity, Entry) {
        var vm = this;
        vm.entry = entity;
        vm.load = function (id) {
            Entry.get({id: id}, function(result) {
                vm.entry = result;
            });
        };
        var unsubscribe = $rootScope.$on('jHipster3App:entryUpdate', function(event, result) {
            vm.entry = result;
        });
        $scope.$on('$destroy', unsubscribe);

    }
})();

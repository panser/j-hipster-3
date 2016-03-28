(function() {
    'use strict';

    angular
        .module('jHipster3App')
        .controller('EntryDialogController', EntryDialogController);

    EntryDialogController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Entry'];

    function EntryDialogController ($scope, $stateParams, $uibModalInstance, entity, Entry) {
        var vm = this;
        vm.entry = entity;
        vm.load = function(id) {
            Entry.get({id : id}, function(result) {
                vm.entry = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('jHipster3App:entryUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        };

        var onSaveError = function () {
            vm.isSaving = false;
        };

        vm.save = function () {
            vm.isSaving = true;
            if (vm.entry.id !== null) {
                Entry.update(vm.entry, onSaveSuccess, onSaveError);
            } else {
                Entry.save(vm.entry, onSaveSuccess, onSaveError);
            }
        };

        vm.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };

        vm.datePickerOpenStatus = {};
        vm.datePickerOpenStatus.date = false;

        vm.openCalendar = function(date) {
            vm.datePickerOpenStatus[date] = true;
        };
    }
})();

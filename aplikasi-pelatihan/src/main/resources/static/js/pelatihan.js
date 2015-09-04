var aplikasiPelatihan = angular.module('aplikasiPelatihan', []);

aplikasiPelatihan.controller('HaloController', function($scope){
    $scope.daftarEmail = [
        'endy.muhardin@gmail.com',
        'endy@artivisi.com',
        'endymuhardin@yahoo.com'
    ];
    
    $scope.tambahEmail = function(){
        $scope.daftarEmail.push($scope.email);
        //$scope.email = "";
    };
    
    $scope.hapusEmail = function(x){
        var lokasiIndex = $scope.daftarEmail.indexOf(x);
        if (lokasiIndex > -1) {
            $scope.daftarEmail.splice(lokasiIndex, 1);
        }
    }
});
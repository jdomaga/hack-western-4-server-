angular.module('demo', []).controller('Hello', function($scope, $http) {
    $scope.fileNameChanged = function(files) {
        var fd = new FormData();
        //Take the first selected file
        fd.append("images_file", files[0]);

        $http.post('localhost:8080/api'
            ,fd,{})
            .then(function (response) {
                $scope.myWelcome = response.data;
                $scope.statuscode = response.status;
                $scope.statustext = response.statusText;
            });
    };
});

/*

 */
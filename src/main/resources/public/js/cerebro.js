var app = angular.module("cerebro",["ngRoute"]);

app.config(function($routeProvider){
	$routeProvider
	.when("/home",{templateUrl : "home.html",controller : "cerebroController"})
	
	// core java start
	.when("/coreJava",{templateUrl : "coreJava.html",controller : "cerebroController"})
	.when("/string",{templateUrl : "string.html",controller : "cerebroController"})
	.when("/date",{templateUrl : "date.html",controller : "cerebroController"})
	.when("/collections",{templateUrl : "collections.html",controller : "cerebroController"})
	.when("/list",{templateUrl : "list.html",controller : "cerebroController"})
	.when("/map",{templateUrl : "map.html",controller : "cerebroController"})
	.when("/annotations",{templateUrl : "annotations.html",controller : "cerebroController"})
	.when("/enums",{templateUrl : "enums.html",controller : "cerebroController"})
	.when("/aspectJ",{templateUrl : "aspectJ.html",controller : "cerebroController"})
	.when("/fileIO",{templateUrl : "fileIO.html",controller : "cerebroController"})
	.when("/multiThreading",{templateUrl : "multiThreading.html",controller : "cerebroController"})
	.when("/dynamicProxies",{templateUrl : "dynamicProxies.html",controller : "cerebroController"})
	// core java end
	
	// hibernate start
	.when("/hibernate",{templateUrl : "hibernate.html",controller : "cerebroController"})
	.when("/hibernate5HelloWorld",{templateUrl : "hibernate5HelloWorld.html",controller : "cerebroController"})
	// hibernate end
	
	// maven start
	.when("/maven",{templateUrl : "maven.html",controller : "cerebroController"})
	.when("/installMaven",{templateUrl : "installMaven.html",controller : "cerebroController"})
	.when("/coreJavaProjectWithMaven",{templateUrl : "coreJavaProjectWithMaven.html",controller : "cerebroController"})
	.when("/compilerPlugin",{templateUrl : "compilerPlugin.html",controller : "cerebroController"})
	.when("/repositoriesTag",{templateUrl : "repositoriesTag.html",controller : "cerebroController"})
	.when("/jarPlugin",{templateUrl : "jarPlugin.html",controller : "cerebroController"})
	.when("/sourcePlugin",{templateUrl : "sourcePlugin.html",controller : "cerebroController"})
	.when("/javadocPlugin",{templateUrl : "javadocPlugin.html",controller : "cerebroController"})
	.when("/warPlugin",{templateUrl : "warPlugin.html",controller : "cerebroController"})
	.when("/pmdPlugin",{templateUrl : "pmdPlugin.html",controller : "cerebroController"})
	// maven end
	
	// spring - start
	.when("/spring",{templateUrl : "spring.html",controller : "cerebroController"})
	.when("/springAopJavaConfig",{templateUrl : "springAopJavaConfig.html",controller : "cerebroController"})
	.when("/springAOPJavaConfigHelloWorld",{templateUrl : "springAOPJavaConfigHelloWorld.html",controller : "cerebroController"})
	.when("/springSecurityJavaConfig",{templateUrl : "springSecurityJavaConfig.html",controller : "cerebroController"})
	// spring end
	
	// tools start
	.when("/tools",{templateUrl : "tools.html",controller : "cerebroController"})
	.when("/csv",{templateUrl : "csv.html",controller : "cerebroController"})
	.when("/json",{templateUrl : "json.html",controller : "cerebroController"})
	.when("/jacksonJson",{templateUrl : "jacksonJson.html",controller : "cerebroController"})
	.when("/openCSV",{templateUrl : "openCSV.html",controller : "cerebroController"})
	
	// tools end
	
	// unit testing start
	.when("/unitTesting",{templateUrl : "unitTesting.html",controller : "cerebroController"})
	.when("/junit",{templateUrl : "junit.html",controller : "cerebroController"})
	.when("/junitHelloWorld",{templateUrl : "junitHelloWorld.html",controller : "cerebroController"})
	// unit testing end
	
	// ant start
	.when("/ant",{templateUrl : "ant.html",controller : "cerebroController"})
	.when("/antJacoco",{templateUrl : "antJacoco.html",controller : "cerebroController"})
	// ant end
	
	// definitions start
	.when("/definitions",{templateUrl : "definitions.html",controller : "definitionsController"});
	// definitions end
});

var CerebroController = function($scope, $location, $anchorScroll){
	
	$scope.navigate = function(id){
		$location.hash(id);
		$anchorScroll();
	};
	
	$scope.scrollUp = function(){
		$('body,html').animate({scrollTop: 0}, 800);
        return false;
	};
	
};

var DefinitionsController = function($scope, $location, $anchorScroll, $http){
	$scope.message = "Hello Definitions";
	var definitionsMessage = " Definitions";
	$scope.definitionsType;
	
	var onSuccess = function(response){
		console.log("onSuccess()");
		console.log(response.data);
	};
	
	var onError = function(onError){
		console.log("onError()");
	};
	
	var definitions = function(){
		console.log("definitionsType: "+$scope.definitionsType);
		$http.get("http://localhost:9090/definitions/"+$scope.definitionsType).then(onSuccess, onError);
		$scope.message = $scope.definitionsType + definitionsMessage;
	};
	
	$scope.definitions = definitions;
};

	/*$scope.navigations = new Array();
	$scope.navigations.push({"name": "Home","link": "cerebro.html#home"});
	$scope.navigations.push({"name": "Core Java","link": "coreJava"});
	$scope.navigations.push({"name": "Hibernate","link": "hibernate"});
	$scope.navigations.push({"name": "Vacation","link": "#"});
	
	$scope.buildBreadCrumbs = function(name, link){
		link =  "cerebro.html#"+link;
		$scope.navigations.push({name,link});
	};
	
	console.log($scope.navigations);*/


app.controller("cerebroController",["$scope", "$location", "$anchorScroll", CerebroController] );
app.controller("definitionsController",["$scope", "$location", "$anchorScroll","$http", DefinitionsController]);

//Magia
var chatRef = new Firebase('https://glowing-heat-6420.firebaseio.com');

//Mais magia
var auth = new FirebaseSimpleLogin(chatRef, function(error, user){if (error){
	console.log(error);
	$("#fblogout").hide()
	$("#fblogin").show()
}	else if(user){
	console.log('User Id: '+user.id + ', Provider: '+user.provider);
	console.log(user)
	$.post("/HelpRadar_JSF2.2/LoginServlet", { userId : user.id, displayName : user.displayName},
			function(data) {


	
		$("#userDisplayName").text("Bem vindo, "+user.displayName)

	});

	$("#fblogout").show()
	$("#fblogin").hide()





}else{
	//user is logged out
	console.log("not logged")
	$("#fblogout").hide()
	$("#fblogin").show()
	$("#userDisplayName").text("")
}
});


$(function(){

	$("#fblogin").click(function(){



		auth.login('facebook',{
			rememberMe: true, 
			scope: 'email'
		});

	});

	$("#fblogout").click(function(){

		auth.logout();
		$("#userDisplayName").text("")
		$.post("/HelpRadar_JSF2.2/LoginServlet", { logout : "logout"},
				function(data) {
				//here goes nothing
				});

	});




});


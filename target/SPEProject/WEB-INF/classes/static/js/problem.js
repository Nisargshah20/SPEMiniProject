function zoomin() {

	document.getElementById("zoomin").className = "active";
}
function zoomout() {

}
var lang = "C++";
function language(v) {

	document.getElementById(lang).className = "";
	lang =  v;
	document.getElementById(lang).className = "active";
}


function opposite() {
	if(document.getElementById("arrow").className == "arrow down")down();
	else up();
}
function up() {
	document.getElementById("bottomnav").style.bottom = "29%";
	document.getElementById("arrow").className = "arrow down";
	document.getElementById("inputoutput").className = "row bot";
}
function down() {
	document.getElementById("bottomnav").style.bottom = "0px";
	document.getElementById("arrow").className = "arrow up";
	document.getElementById("test").className = "";
	document.getElementById("errorbox").className = "row bot collapse";
	document.getElementById("inputoutput").className = "row bot collapse";
	document.getElementById("ra").className = "collapse";
	document.getElementById("wa").className = "collapse";
	document.getElementById("ce").className = "collapse";
}
var question = "Problems/";
var curr_right_page = "question.html";
function rightcontroller(v,pid){
	document.getElementById(curr_right_page).className = "";
	curr_right_page = v;
	document.getElementById("myFrame").src = question+pid+'/'+curr_right_page;
	console.log(document.getElementById("myFrame").src);
	document.getElementById(curr_right_page).className = "active";
	document.getElementById("myFrame").style.fontSize = "50pt";
}


$(document).ready(function()
{
	$("#test").click(function()
	{
		up();
		document.getElementById("test").className = "active";
		iframe = document.getElementById("editor1");
		innerDoc = iframe.contentDocument || iframe.contentWindow.document;
		document.getElementById("maincontent").value = innerDoc.getElementById("content1").value;
		var u = $("#username").val()
		var id = $("#id").val()
		var p = $("#maincontent").val()
		var i = $("#input").val()
		data=
			{
				"username" : u,
				"pid" : id,
				"program" : p,
				"input" : i
			}

		$.ajax(
			{
				url: "http://localhost:8085/test",
				type: "POST",
				async:false,
				dataType: 'json',
				contentType : "application/json",
				data :JSON.stringify(data),
				success: function (response){

					if(response["status"]==="success") {
						document.getElementById("output").value = response["output"];
					}
					else{
						document.getElementById("inputoutput").className = "row bot collapse";
						document.getElementById("errorbox").className = "row bot";
						document.getElementById("error").value = response["output"];
					}

				},
				error:function(response){
					alert("Some error occured!");
				}

			});

	});

	$("#submit").click(function()
	{
		up();
		document.getElementById("test").className = "active";
		iframe = document.getElementById("editor1");
		innerDoc = iframe.contentDocument || iframe.contentWindow.document;
		document.getElementById("maincontent").value = innerDoc.getElementById("content1").value;
		var u = $("#username").val()
		var id = $("#id").val()
		var p = $("#maincontent").val()
		var i = ""
		data=
			{
				"username" : u,
				"pid" : id,
				"program" : p,
				"input" : i
			}

		$.ajax(
			{
				url: "http://localhost:8085/submit",
				type: "POST",
				async:false,
				dataType: 'json',
				contentType : "application/json",
				data :JSON.stringify(data),
				success: function (response){

					if(response["status"]==="success") {
						document.getElementById("ra").className = "";
						document.getElementById("wa").className = "collapse";
						document.getElementById("ce").className = "collapse";
					}
					else if(response["status"]==="wrongans"){
						document.getElementById("ra").className = "collapse";
						document.getElementById("wa").className = "";
						document.getElementById("ce").className = "collapse";
					}
					else {
						document.getElementById("ra").className = "collapse";
						document.getElementById("wa").className = "collapse";
						document.getElementById("ce").className = "";
						document.getElementById("inputoutput").className = "row bot collapse";
						document.getElementById("errorbox").className = "row bot";
						document.getElementById("error").value = response["output"];
					}

				},
				error:function(response){
					alert("Some error occured!");
				}

			});

	});
});
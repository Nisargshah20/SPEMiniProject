var current="problems_list";
function myfun(v)
{
	document.getElementById("myFrame").src = v;
	document.getElementById("table1").style.display = "none";
	document.getElementById("page").style.display = "block";
	document.getElementById(v).className = "active";
    document.getElementById(current).className = "inactive";
	current = v;
}

window.addEventListener("load",function(){
	if(document.getElementById("username").value!="nisarg20")
	{
		document.getElementById("hostcontest").className += "collapse";
	}
})

function setLoad() 
{
	document.getElementById("checkcontent").value=1;
}

window.onbeforeunload = confirmExit;
function confirmExit()
{
	try
	{
    	if (document.getElementById("checkcontent").value==1)
    	{
    		if(parent.document.getElementById("editFlag").value=="nohref")
    		{
    			if(confirm(''))
    			{
    				
    				window.onbeforeunload = ""
    			}
    		}
    		else if(parent.document.getElementById("editFlag").value=="ishref")
    		{
    			loadHidInfo()
    			window.event.returnValue="";
    		}
    	}
	}catch(e){}
}

function setUnload()
{
	try
	{
		document.getElementById("checkcontent").value=0;
		parent.document.getElementById("editFlag").value="0";
	}catch(e){}
}

function setSplitArr(fieldName,relationLookupName)//Ö÷Óò£¬Áª¶¯Óò
{
		var lookupArrLength=lookupArr.length;
		lookupArr[lookupArrLength]=new Array()
		lookupArr[lookupArrLength]['name1']=fieldName
		lookupArr[lookupArrLength]['name2']=relationLookupName
}
CalendarTime = {
  "times"  : [["00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","43","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"],
        ["00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","43","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"]
         ]
}
function loadDateSelect()
{
	if(document.getElementById("timehour")!=undefined)
	{
	    var thours=document.getElementsByName("timehour");
		var tminutes=document.getElementsByName("timeminute");
		var tseconds=document.getElementsByName("timesecond");
		for(var s=0;s<thours.length;s++)
		{
	    	var thour=thours[s]
	        var thourvalue="";
	       	var tminute=tminutes[s]
	        var tminutevalue="";
	        var tsecond=tseconds[s]
	        var tsecondvalue="";
	        var k=0;
	        var k1=0;
	        var inputobjname=document.getElementById(thour.inputobjname)
	      	var inputobjnameshow=document.getElementById("__"+thour.inputobjname)
	      	if(inputobjname.value!=undefined&&inputobjname.value!="")
	      	{
	      		inputobjnameshow.value=inputobjname.value.split(" ")[0]
	      		thourvalue=inputobjname.value.split(" ")[1].split(":")[0]
	      		tminutevalue=inputobjname.value.split(" ")[1].split(":")[1]
	      		tsecondvalue=inputobjname.value.split(" ")[1].split(":")[2]
	      	}
	    	for (var i = 0; i < 24; i++){
	        	thour.options[k] = new Option(CalendarTime["times"][0][i], CalendarTime["times"][0][i]);
	        	if(CalendarTime["times"][0][i]==thourvalue)thour.options[k].selected=true;
	        	k++;
	    	}
	      	for (var i = 0; i < 60; i++){
	        	tminute.options[k1] = new Option(CalendarTime["times"][0][i],CalendarTime["times"][0][i]);
	    			tsecond.options[k1] = new Option(CalendarTime["times"][0][i],CalendarTime["times"][0][i]);
	    			if(CalendarTime["times"][0][i]==tminutevalue)tminute.options[k1].selected=true;
	    			if(CalendarTime["times"][0][i]==tsecondvalue)tsecond.options[k1].selected=true;
	    			k1++;
	      	}
		}
	}
}
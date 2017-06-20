//¼ÆËãÆ÷
var lastCalObj=null;
var x=null;
var y=null;
function getAbsPoint(e)
{
  x = e.offsetLeft;
  y = e.offsetTop;
  var panelHeight=163;
  var eselfHeight=e.clientHeight;
  while(e = e.offsetParent){
    x += e.offsetLeft;
    y += e.offsetTop;
  }
  x=parseInt(x)
  if(parseInt(y)+parseInt(eselfHeight)+parseInt(panelHeight)>parseInt(document.body.clientHeight))
  {
  	y=parseInt(y)-parseInt(panelHeight)-parseInt(eselfHeight);
  }
  else 
  {
  	y=parseInt(y);
  }
  return {"x": x, "y": y};
}
function openout(obj)
{
	var thisObj=document.getElementById(obj)
	var xy = getAbsPoint(thisObj);
	document.getElementById("calcDiv").style.top =  (xy.y + thisObj.offsetHeight) + "px";
	document.getElementById("calcDiv").style.left =xy.x + "px";
	document.getElementById("calcDiv").style.display = "";
	lastCalObj=obj
	if(thisObj.value!="")
	{
		document.getElementById("ReadOut").value=thisObj.value
	}
	else
	{
		document.getElementById("ReadOut").value=""
	}
	try{
		new Calendar().hide();
	}catch(e){}
}
function fback()
{
	var t_value = document.getElementById("ReadOut").value ;
	document.getElementById(lastCalObj).value = t_value ;
	document.getElementById("calcDiv").style.display = "none";
}

var Accum = 0;
var FlagNewNum = false;
var PendingOp = ""; 
function NumPressed (Num)
{
	if (FlagNewNum) 
	{
		document.getElementById("ReadOut").value  = Num;
		FlagNewNum = false;
   	}
	else 
	{
		if(document.getElementById("ReadOut").value == "0")
		{
			document.getElementById("ReadOut").value = Num;
		}
		else
		{
			document.getElementById("ReadOut").value += Num;
 		}  
  	}
}
function Operation(Op)
{
//	var FKeyPad = document.Keypad ;
	var Readout = document.getElementById("ReadOut").value;
	if (FlagNewNum && PendingOp != "=")
	{
		return;
	}
	else
	{
		FlagNewNum = true;
		if ( '+' == PendingOp )
		{
			Accum += parseFloat(Readout);
		}
		else if ( '-' == PendingOp )
		{
			Accum -= parseFloat(Readout);
		}
		else if ( '/' == PendingOp )
		{
			Accum /= parseFloat(Readout);
		}
		else if ( '*' == PendingOp )
		{	
			Accum *= parseFloat(Readout);
		}
		else
		{
			Accum = parseFloat(Readout);
		}
		document.getElementById("ReadOut").value = Accum;
		PendingOp = Op;
   	}
}
function Decimal ()
{
//	var FKeyPad = document.Keypad ;
	var curReadOut = document.getElementById("ReadOut").value;
	if (FlagNewNum) 
	{
		curReadOut = "0.";
		FlagNewNum = false;
   	}
	else
	{
		if (curReadOut.indexOf(".") == -1)
		{	
			curReadOut += ".";
   		}
   	}
	document.getElementById("ReadOut").value = curReadOut;
}
function ClearEntry ()
{
//	var FKeyPad = document.Keypad ;
	document.getElementById("ReadOut").value = "0";
	FlagNewNum = true;
}
function Clear ()
{
	Accum = 0;
	PendingOp = "";
	ClearEntry();
}
function Neg ()
{
//	var FKeyPad = document.Keypad ;
	document.getElementById("ReadOut").value = parseFloat(document.getElementById("ReadOut").value) * -1;
}
function Percent () 
{
//	var FKeyPad = document.Keypad ;
	document.getElementById("ReadOut").value = (parseFloat(document.getElementById("ReadOut").value) / 100) * parseFloat(Accum);
}

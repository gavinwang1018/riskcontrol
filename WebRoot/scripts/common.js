    	    window._alert=window.alert; 
			window.alert=function(s) { 
				_alert(s.replace(/&#(\d{5});/g,function(r,r1) {return String.fromCharCode(r1);})); 
			}
//lookup return value
function returnLookupValue(transID,transName)
{
    if(opener.parentType!=undefined&&opener.parentType=="listEdit")
	{
		window.opener.document._fieldObj.value=transID;
	    window.opener.document._fieldObj2.value=transName;
		window.close();
	}
	else
	{
		var formName = window.opener.document._formName;
		var fieldName = window.opener.document._fieldName;
		var fieldName2 = window.opener.document._fieldName2;
	    var f = window.opener.document.forms[formName];
	    f.elements[fieldName].value=transID;
	    f.elements[fieldName2].value=transName;
	    window.close();
	}
	
}
//lookup showtype param
function showdiv(obj,lookuppage,formName,fieldName,parameter,relationLookupFilterName,relationLookupFieldName,itemFilterType){
	document._formName = formName;
	document._fieldName = formName+":"+fieldName;
	document._fieldName2 = formName+":read_"+fieldName;
	var f = document.forms[formName];
	var currentVar = f.elements[formName+':'+fieldName].value;
	var lookuppage='../Lookups/'+lookuppage
	if(relationLookupFilterName!=undefined)
	{
		if(itemFilterType=="1")
		{
			var relationLookupFilterNameTemp=relationLookupFilterName+"_max"
		}
		else if(itemFilterType=="2")
		{
			var relationLookupFilterNameTemp=relationLookupFilterName+"_min"
		}
		else if(itemFilterType=="3")
		{
			var relationLookupFilterNameTemp=relationLookupFilterName+"_like"
		}
		else if(itemFilterType=="0")
		{
			var relationLookupFilterNameTemp=relationLookupFilterName
		}
		var urldress = lookuppage+'?_value='+currentVar+'&'+parameter+'&'+relationLookupFilterNameTemp+'='+document.getElementById(formName+":"+relationLookupFieldName).value;
	}
	else
	{
		var urldress = lookuppage+'?_value='+currentVar+'&'+parameter;
	}
	
	window.open(urldress,'','width=700,height=450,menubar=no,status=no,scrollbars=yes,top=150,left=150');
}

//show error info
function showError(obj)
{
	var errorDiv=document.getElementById('errorURL')
//	var imagePath=document.getElementById('imagePath').value
    if(errorDiv.style.display=='')
    {
		errorDiv.style.display="none"
        obj.src=imagePath+"/errorclose.gif"
    }
    else 
    {
        errorDiv.style.display=""
        obj.src=imagePath+"/erroropen.gif"
    }
}
//validate data field
function checkInput(id)	{
	var field = document.getElementById(id);
	if(field.value!='')
	{		
		var validStr=/^[a-zA-Z]+([a-zA-Z0-9_]+)*$/
		//var t=/^[a-z0-9\-_]+$/
		if(!validStr.test(field.value)) {			
			alert('请以字母开头,只能包含字母,数字和下划线!');
			field.focus();
			return false;
		}
		childShowSysInform();
		return true;
	}
	
}
//page forward
function forward(url,formName,target){
    var form = document.getElementById(formName);
    form.action = url;
    form.method = "post";
    if(target == undefined || target == '') 
    target = '_self';
    form.target = target;
    form.submit();
}
function childShowSysInform()
{	
	var sw=parseInt(parseInt(screen.width)/2);
	var sh=parseInt(parseInt(screen.height)/2);
	var st=parseInt(parent.document.body.scrollTop);
	try{
		var parentDivObj=parent.document.getElementById("loading");
		parentDivObj.style.top=sh+st-180;
		parentDivObj.style.left=sw-150;
		parentDivObj.style.display='';
		var div1=parent.document.getElementById("sDivInfo");
		if (parent.document.body.scrollHeight > parent.document.body.offsetHeight)div1.style.height=parent.document.body.scrollHeight
		else div1.style.height=parent.document.body.clientHeight;
		var divIframe=parent.document.getElementById("divFrame");
		div1.style.width=parent.document.body.clientWidth;	
		div1.style.display='';
		divIframe.style.width=div1.style.width
		divIframe.style.height=div1.style.height
	}catch(e){}
}
function loadHidInfo()
{
	window.history.forward(1); 
	try{
		var loadImg=parent.document.getElementById("loading");
		var loadImgDiv=parent.document.getElementById("sDivInfo");
		if(loadImg!=undefined&&loadImg.style.display=="")loadImg.style.display='none';
		if(loadImgDiv!=undefined&&loadImgDiv.style.display=="")loadImgDiv.style.display='none';
	}catch(e){}
}
//change background image position
function changep(thisobj,p){
	thisobj.style.backgroundPosition=p;
}
function resetTable(formObj)
{
	var allInputs=formObj.getElementsByTagName("input")
	var allTextareas=formObj.getElementsByTagName("textarea")
	var allSelects=formObj.getElementsByTagName("select")
    for(var i=0;i<allInputs.length;i++)
    {
    	if(allInputs[i].type=="checkbox"||allInputs[i].type=="radio")
		{
		if(allInputs[i].checked==true)allInputs[i].checked=false;
		}
		else if(allInputs[i].type=="text")allInputs[i].value="";
    }
    for(var i=0;i<allTextareas.length;i++)
    {
    	allTextareas[i].innerText="";
    }
	for(var i=0;i<allSelects.length;i++)
    {
    	allSelects[i].selectedIndex="0";
    }
}
//eidt scan
function doScanImage(obj)
{
	var d = new Date().getTime();
	userscan=obj.previousSibling.id;
	userscan1=obj.previousSibling.previousSibling.id;
	usermessage=document.getElementById("hiddenspan").innerText+d;
	var url="../imagescan/scanfile.jsp";
	var retValue=window.showModalDialog(url,window,"dialogWidth:920px;dialogHeight:720px;");
}
function doScanImageS(objs)
{
	var ds = new Date().getTime();
	usermessages=document.getElementById("hiddenspan").innerText+ds;
	userscans=objs.previousSibling.id;
	userscan1s=objs.previousSibling.previousSibling.id;
	var urls="../imagescan/scanfiles.jsp";
	var retValues=window.showModalDialog(urls,window,"dialogWidth:400;dialogHeight:200;");
	//var retValues=window.open(urls,"window","width:800px;height:400px;");
}
//lookup highlight
function checkLookupS()
{
	try{
		var inputs=document.getElementsByTagName("INPUT");
		if(inputs!=undefined)
		{
			var hightTd=document.getElementById("hid").value;
			for(var t=0;t<inputs.length;t++)
			{
				if(hightTd==''||hightTd=='null')break;
				else if(inputs[t].value==hightTd)
				{
					inputs[t].parentNode.parentNode.runtimeStyle.backgroundColor="#BBD1E7";
					break;
				}
			}
		}
	}catch(e){}
}
//row highlight
var lastObj = null;
var previousClass = null;
function hightlightRows(obj)
{
   	if(event.srcElement.tagName=="TD"){
   		if(lastObj != null)
   		{
   			lastObj.className = previousClass;
   			if (lastObj.firstChild.firstChild!=undefined&&lastObj.firstChild.firstChild.tagName=="IMG")
	   			lastObj.firstChild.firstChild.style.visibility ="hidden";
   		}	
	   	curRow=event.srcElement.parentElement;
	   	previousClass = curRow.className;
	   	curRow.className +=' over';
	   	lastObj = curRow;
	   	if(curRow.firstChild.firstChild!=undefined&&curRow.firstChild.firstChild.tagName=="IMG")
	   	{
   			curRow.firstChild.firstChild.style.visibility="visible";
	   	}
   	}
}
function HidShowChange(queryid,imgid)
{
	var queryDiv = document.getElementById(queryid);
	var imgId = document.getElementById(imgid);
	if(imgId.src.search('down') != -1)
	{
		imgId.src = '../images/arrow.right.png';
		queryDiv.style.display = "none";
	}else{
		imgId.src = '../images/arrow.down.png';
		queryDiv.style.display = "";
	}
}
function getDateObj()
{
	var arrs=getElementsByClassName(document,"datebutton");
	if(arrs.length>0)
	{
		var js=document.createElement("script");
		js.setAttribute("defer","defer");
		js.src="../scripts/WebCalendar.js";
		document.body.appendChild(js);
		document.body.onclick=function()
		{
			new Calendar().hide();
			if(document.getElementById("calcDiv")!=undefined)
			{
				document.getElementById("calcDiv").style.display = "none";
			}
		}
	}
	else if(document.getElementById("calcDiv")!=undefined)
	{
		document.body.onclick=function()
		{
			document.getElementById("calcDiv").style.display = "none";
		}
	}
}
//view list
function changeChildListForm(obj,formName)
{
	var allForms=document.getElementsByTagName("form")
	var allLis=document.getElementsByTagName("LI")
	for(var f=0;f<allForms.length;f++)
	{
		if(allForms[f].id==formName)
		{
			allForms[f].style.display=""
		}
		else
		{
			allForms[f].style.display="none"
		}
	}
	for(var l=0;l<allLis.length;l++)
	{
		if(allLis[l]==obj)
		{
			allLis[l].className="Selected"
		}
		else
		{
			allLis[l].className=""
		}
	}
}
function changeEditListForm(obj,formName)
{
	var allForms=document.getElementsByTagName("div")
	var allLis=document.getElementsByTagName("LI")
	for(var f=0;f<allForms.length;f++)
	{
		if(allForms[f].id.search("div_tab_")!=-1)
		{
			if(allForms[f].id==formName)
			{
				allForms[f].style.display=""
			}
			else
			{
				allForms[f].style.display="none"
			}
		}
	}
	for(var l=0;l<allLis.length;l++)
	{
		if(allLis[l]==obj)
		{
			allLis[l].className="Selected"
		}
		else if(allLis[l].id.search("tabchange")!=-1)
		{
			allLis[l].className=""
		}
	}
}
var lastListLiSeq=null;
var firstListLiSeq=null;
function loadChildList()
{
	var appul=document.getElementById("listUl");
	var allLis=appul.getElementsByTagName("LI")
	for(var l=allLis.length-2;l>1;l--)
	{
		if(parseInt(appul.clientWidth)<765&&parseInt(appul.clientHeight)<40)
		{
			lastListLiSeq=l+1;
			break;
		}
		else
		{
			overflag=true;
			allLis[l].style.display="none"
			allLis[allLis.length-1].style.display="";
		}
	}
}
//show before
function showListBefore()
{
		var appul=document.getElementById("listUl");
		var allLis=appul.getElementsByTagName("LI")
		allLis[allLis.length-1].style.display="";

		if(firstListLiSeq!=null&&allLis[firstListLiSeq]!=undefined)
		{	
			if(firstListLiSeq==1)
			{
					allLis[0].style.display="none"
			}
			allLis[firstListLiSeq].style.display=""
			for(var l=allLis.length-2;l>1;l--)
			{
				if(parseInt(appul.clientWidth)<765&&parseInt(appul.clientHeight)<40)
				{	
					firstListLiSeq=firstListLiSeq-1;
					break;
				}
				else
				{
						lastListLiSeq=l;
						allLis[l].style.display="none"	
				}
			}		
		}
}
//show after
function showListAfter()
{
		
		var appul=document.getElementById("listUl");
		var allLis=appul.getElementsByTagName("LI")
		allLis[0].style.display="";
		if(lastListLiSeq!=null&&allLis[lastListLiSeq]!=undefined)
		{	
			if(allLis.length-2==lastListLiSeq)
			{
					allLis[allLis.length-1].style.display="none"
			}
			
			allLis[lastListLiSeq].style.display=""
			
			for(var l=1;l<allLis.length-2;l++)
			{
				if(parseInt(appul.clientWidth)<765&&parseInt(appul.clientHeight)<40)
				{
					lastListLiSeq=lastListLiSeq+1;
					break;
				}
				else
				{
					firstListLiSeq=l;
					allLis[l].style.display="none"	
				}
			}		
		}
}

/*-----------------cxy add----------------*/

function hidShowSearchImg(tabId){
	var table = document.getElementById(tabId);
	var imgId = document.getElementById("searchImgId");
	if(imgId.src.search('show') != -1)
	{
		imgId.src = '../images/button_closeall.gif';
		table.style.display = "none";
	}else{
		imgId.src = '../images/button_showall.gif';
		table.style.display = "";
	}
}

/*-------------------end--------------------*/
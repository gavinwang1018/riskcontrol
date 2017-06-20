<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="cn.com.brilliance.begen.common.BeGenHistory"%>
<%@ page language="java" import="cn.com.brilliance.begen.common.Tools" %>
<%
String basePath = request.getContextPath();
%>
<!DOCTYPE html public"-//w3c//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="UTF-8">
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta name="description" content="" />
<title>SearchResult</title>
</head>
<style>
	a {	
	color:#336699;
	text-decoration: none;
}

	a:hover {
	color:#336699;
	text-decoration: underline;
}
</style>
<body style="margin:0;" >
	<table cellspacing=0 cellpadding=0 >					
		<tr>
			<td style="vertical-align:top;">
				<font style="font-size:12px;" id="historyFont">	</font>
			</td>
		</tr>

	</table>
</body>
<script language=javascript>

/*history*/

if(!(document.uniqueID))
{
    HTMLElement.prototype.insertAdjacentElement=function(where,parsedNode){
    switch(where){
        case "beforeBegin":
            this.parentNode.insertBefore(parsedNode,this);
            break;
        case "afterBegin":
            this.insertBefore(parsedNode,this.firstChild);
            break;
        case "beforeEnd":
            this.appendChild(parsedNode);
            break;
        case "afterEnd":
            if(this.nextSibling)
                this.parentNode.insertBefore(parsedNode,this.nextSibling);
            else
                this.parentNode.appendChild(parsedNode);
            break;
        }
    }
    HTMLElement.prototype.insertAdjacentHTML=function(where,htmlStr){
        var r=this.ownerDocument.createRange();
        r.setStartBefore(this);
        var parsedHTML=r.createContextualFragment(htmlStr);
        
        this.insertAdjacentElement(where,parsedHTML);
        }
    Node.prototype.replaceNode=function(Node){// 替换指定节点
        this.parentNode.replaceChild(Node,this);
        }
    Node.prototype.removeNode=function(removeChildren){// 删除指定节点
        if(removeChildren)
            return this.parentNode.removeChild(this);
        else{
            var range=document.createRange();
            range.selectNodeContents(this);
            return this.parentNode.replaceChild(range.extractContents(),this);
            }
        }
}

var hisNum=0;
Array.prototype.remove=function(dx)
{
	if(isNaN(dx)||dx>this.length){return false;}
		for(var i=0,n=0;i<this.length;i++)
		{
			if(this[i]!=this[dx])
			{
			this[n++]=this[i]
			}
		}
	this.length-=1
}

function addHistory(hisUrl,hisLabel,hisType)
{	

	var parentHisSpan=parent.document.getElementById("tasklist");
	var hisFlag=false;
	var showLabel="";

	for(var i=0;i<parent.reArr.length;i++)
	{
		if(parent.reArr[i]['url'].split("?")[0]==hisUrl.split("?")[0])
		{
			hisFlag=true;
			showLabel=parent.reArr[i]['showLabel'];
			break;
		}
		else if(parent.reArr[i]['url'].split("/")[1] != hisUrl.split("/")[1])
		{
			hisFlag=false;
			parent.reArr=new Array();
			break;	
		}
		else if(parent.reArr[i]['url'].split("/")[1] == hisUrl.split("/")[1] && parent.reArr[i]['url'].search(/\wView/g)!=-1 && hisUrl.search(/\wList/g)!=-1)
		{
			hisFlag=false;
			parent.reArr=new Array();
			break;
		}
	}
	if(!hisFlag)//找不到url
	{
		var reArrLength=parent.reArr.length;
		parent.reArr[reArrLength]=new Array();
		parent.reArr[reArrLength]['url']=hisUrl;
		parent.reArr[reArrLength]['label']=hisLabel;
		parent.reArr[reArrLength]['type']=hisType;
		for(var s=0;s<parent.reArr.length;s++)
		{
			var hisUrlShow=parent.reArr[s]['url'];
			var hisLabelShow=parent.reArr[s]['label'];			
			if(showLabel=="")
			{	
				showLabel="当前位置:<a href='<%=basePath%>"+hisUrlShow+"' target='mainFrame'  onclick='historyIframe.checkHis(\""+hisUrlShow+"\");' ><font color='blue'>"+hisLabelShow+"</font></a>";
			}
			else
			{
				showLabel=showLabel+" —> <a href='<%=basePath%>"+hisUrlShow+"' target='mainFrame'  onclick='historyIframe.checkHis(\""+hisUrlShow+"\");' style='color:blue'> <font color='blue'>"+hisLabelShow+"</font></a>";
			}
		}
		parent.reArr[reArrLength]['showLabel']=showLabel;
	}
	parentHisSpan.innerHTML="";
	parentHisSpan.insertAdjacentHTML("afterBegin",showLabel);
	
	
	
	var historyFont=document.getElementById("historyFont");
	var allAs=document.getElementsByName("hidURL");
	for(var a=0;a<allAs.length;a++)
	{
		if(hisUrl.split("?")[0]==allAs[a].value.split("?")[0])
		{
			allAs[a].parentNode.removeNode(true);
			hisNum--;
			break;
		}
	}
	if(hisNum>9)
	{
		allAs[(allAs.length-1)].parentNode.removeNode(true);
		hisNum--;
	}
	if(hisType==1)var hisImg="form.gif";
	else var hisImg="list.gif";
	var arrTempHis=new Array();
	arrTempHis[arrTempHis.length]="<div style='margin-bottom:4px;margin-top:4px;text-overflow:ellipsis;table-layout:fixed;overflow:hidden;width:140px;padding-left:10px;font-size:12px;'>";
	arrTempHis[arrTempHis.length]="	<a href='<%=basePath%>"+hisUrl+"' target='mainFrame' title='"+hisLabel+"' onclick='checkHis(\""+hisUrl+"\");childShowSysInform()'>";
	arrTempHis[arrTempHis.length]="		<nobr><image src='images/"+hisImg+"' style='border:0;vertical-align:middle;' />"+hisLabel+"</nobr>";
	arrTempHis[arrTempHis.length]="	</a>";
	arrTempHis[arrTempHis.length]="	<input type='hidden' value='"+hisUrl+"' name='hidURL' />";
	arrTempHis[arrTempHis.length]="</div>";
	historyFont.insertAdjacentHTML("afterBegin",arrTempHis.join(""));
	hisNum++;

}

function checkHis(hisUrl)
{
	var hisFlag=false;
	var plength=parent.reArr.length-1
	for(var i=plength;i>-1;i--)
	{
		if(parent.reArr[i]['url'].split("?")[0]==hisUrl.split("?")[0])
		{
			hisFlag=true;
			break;
		}
		else
		{
			parent.reArr.remove(i);
		}
	}
	if(!hisFlag)
	{
		parent.reArr=new Array()
	}
}

/*end*/
function childShowSysInform()
{
	var sw=parseInt(parseInt(screen.width)/2);
	var sh=parseInt(parseInt(screen.height)/2);
	try{
	var parentDivObj=parent.document.getElementById("loading");
	parentDivObj.style.top=sh-180;
	parentDivObj.style.left=sw-150;
	parentDivObj.style.display='';
	}catch(e){}
}
//alert(document.getElementById("historyFont").innerHTML)
</script>
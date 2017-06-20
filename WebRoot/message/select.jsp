<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.dao.*" %>
<%@ page import="cn.com.brilliance.begen.model.*" %>
<%@ page import="cn.com.brilliance.begen.common.Tools" %>
<%@ page import="java.util.*" %>
<%@ page import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<%	
	 String basePath = request.getContextPath();	    
%>
<html>
<head>
<title>Message</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/message.css" />
<style>
.button{
	height:25px;
	width:80px;
	font-family: "宋体";
	background-image:  url(<%=basePath%>/images/Btn_bg.gif);
	background-repeat: repeat-x;
	background-position: center center;
	font-size: 12px;
	color:#000000;
	padding:3px 2px 0 2px;
	cursor:pointer;
	font-weight:normal;
	display:inline;
	text-decoration: none;
	border-top-width: 1px;
	border-right-width: 1px;
	border-bottom-width: 1px;
	border-left-width: 1px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	border-top-color: #CCCCCC;
	border-right-color: #CCCCCC;
	border-bottom-color: #CCCCCC;
	border-left-color: #CCCCCC;
	background-color: #FFFFFF;
	margin:3px 5px;
}
</style>
</head>
<body>
<div id="message_title">
        	<div><img src="<%=basePath%>/images/message_action_new.gif" hspace="20" vspace="10" align="middle"><span class="message_title_tip"><%=ResourceBundle.getText(request,"label.message")%>-<%=ResourceBundle.getText(request,"message.choosereceiver")%></span></div>
</div>
<table width="500" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td><div align="center"><br><span class="select_name"><%=ResourceBundle.getText(request,"message.currentuser")%></span></br>
      <select name="showInfo1" size="5" id="showInfo1" class="input_select_list" ondblclick="moveOption('showInfo1','showInfo1_in')">
      </select>
    </div></td>
    <td width="100" align="center">
		<div class=coolButton title="Add All" style="LEFT: 190px; TOP: 145px"  onclick="moveAllOption('showInfo1','showInfo1_in')">
			<IMG height=16 src="/common/images/picklist02.gif"  width=30 style="filter:gray;cursor:hand;" onmouseover=mouseover(this,"all") onmouseout=mouseout(this,"all")>
		</div>
		<div class=coolButton title="Add" style="LEFT: 190px; TOP: 145px"  onclick="moveOption('showInfo1','showInfo1_in')">
			<IMG height=16 src="/common/images/picklist01.gif" width=30 style="filter:gray;cursor:hand;"  onmouseover=mouseover(this,"one") onmouseout=mouseout(this,"one")>
		</div>	
		<div class=coolButton title="Remove" style="LEFT: 230px; TOP: 145px" onclick="moveOption('showInfo1_in','showInfo1')">
			<span style="FILTER: flipH(); WIDTH:30px; HEIGHT: 16px"><IMG height=16 src="/common/images/picklist01.gif" width=30  style="filter:gray;cursor:hand;" onmouseover=mouseover(this,"one") onmouseout=mouseout(this,"one")></span>
		</div>
		<div class=coolButton title="Remove All" style="LEFT: 190px; TOP: 145px"  onclick="moveAllOption('showInfo1_in','showInfo1')">
			<span style="FILTER: flipH(); WIDTH:30px; HEIGHT: 16px"><IMG height=16 src="/common/images/picklist02.gif"  width=30 style="filter:gray;cursor:hand;" onmouseover=mouseover(this,"all") onmouseout=mouseout(this,"all")></span>
		</div>
	</td>
    <td><div align="center"><br><span class="select_name"><%=ResourceBundle.getText(request,"message.chooseduser")%></span></br>
		<select name="showInfo1_in" size="5" id="showInfo1_in" class="input_select_list"  ondblclick="moveOption('showInfo1_in','showInfo1')">
		</select></div>
    </td>
  </tr>
	<tr>
		<td colspan="3" style="text-align:center;">
    		<input type="button" class="button" value="<%=ResourceBundle.getText(request,"button.submit")%>" onclick="saveselect()" />
    	</td>
	</tr>
</table>
</body>	
</html>
<script>
function mouseover(obj)
{
	obj.style.filter="";
}
function mouseout(obj)
{
	obj.style.filter="gray";
}

function moveOption(objName,objName2){
	try{
		var e1=document.getElementById(objName)
		var e2=document.getElementById(objName2)
		var e2Childs=e2.childNodes;
		var sArr=new Array();
		for(var i=0;i<e1.options.length;i++)
		{
			if(e1.options[i].selected)
			{
				var e =e1.options[i] ;
				var thistype=e.parentNode.thistype
				var sArrLength=sArr.length;
				sArr[sArrLength]=new Array()
				sArr[sArrLength]['num']=i
				sArr[sArrLength]['type']=e.parentNode.thistype
				sArr[sArrLength]['text']=e.innerText
				sArr[sArrLength]['value']=e.value
			}
		}
	
		for(var s2=0;s2<e2Childs.length;s2++)
		{
			if(e2Childs[s2].tagName=="OPTGROUP")
			{
				
				for(var a=(sArr.length-1);a>-1;a--)
				{
					if(sArr[a]['type']==e2Childs[s2].thistype)
					{
						var objOption=document.createElement("option");
						objOption.innerText=sArr[a]['text']
						objOption.value=sArr[a]['value']
						e2Childs[s2].appendChild(objOption)
						e1.remove(sArr[a]['num'])					
					}
				}
			}	
		}

	}
	catch(e){}
}

function moveAllOption(objName,objName2){
	try{
		var e1=document.getElementById(objName)
		var e2=document.getElementById(objName2)
		var e2Childs=e2.childNodes;
		var sArr=new Array();
		for(var i=0;i<e1.options.length;i++)
		{
			var e =e1.options[i] ;
			var thistype=e.parentNode.thistype
			var sArrLength=sArr.length;
			sArr[sArrLength]=new Array()
			sArr[sArrLength]['num']=i
			sArr[sArrLength]['type']=e.parentNode.thistype
			sArr[sArrLength]['text']=e.innerText
			sArr[sArrLength]['value']=e.value
		}
	
		for(var s2=(e2Childs.length-1);s2>-1;s2--)
		{
			if(e2Childs[s2].tagName=="OPTGROUP")
			{
				for(var a=(sArr.length-1);a>-1;a--)
				{
					if(sArr[a]['type']==e2Childs[s2].thistype)
					{
						var objOption=document.createElement("option");
						objOption.innerText=sArr[a]['text']
						objOption.value=sArr[a]['value']
						e2Childs[s2].appendChild(objOption)
						e1.remove(sArr[a]['num'])					
					}
				}
			}	
		}
	}
	catch(e){}
}
	
var orgArray=new Array()
var roleArray=new Array()
var userArray=new Array()
var personArr=new Array()
function stateParam()
{

}
function orgObj(orgID,orgName)
{
	this.orgID=orgID;
	this.orgName=orgName;
}
function roleObj(roleID,roleName)
{
	this.roleID=roleID;
	this.roleName=roleName;
}
function userObj(userID,userName)
{
	this.userID=userID;
	this.userName=userName;
}

function setSelectValue(selectname,selectvalue,objtype)
{
		
		var objLabel=document.createElement("OPTGROUP");
		objLabel.label=selectvalue
		var objLabel_1=document.createElement("OPTGROUP");
		objLabel_1.label=selectvalue
		objLabel.thistype=objtype
		objLabel_1.thistype=objtype
		
		document.getElementById(selectname).appendChild(objLabel)
		document.getElementById(selectname+"_in").appendChild(objLabel_1)
		var selectArr=new Array()
		if(objtype=="org")selectArr=orgArray
		else if(objtype=="role")selectArr=roleArray
		else if(objtype=="user")selectArr=userArray
		for(var a=0;a<selectArr.length;a++)
		{
			var objOption=document.createElement("option");
			objOption.innerText=selectArr[a]['name']
			objOption.value=selectArr[a]['id']
			
			var inflag=false;
			for(var i=0;i<personArr.length;i++)
			{
				if(personArr[i][objtype]==selectArr[a]['id'])
				{
					inflag=true;
					break;	
				}
			}
			if(inflag)
			{
				objLabel_1.appendChild(objOption);
			}
			else
			{
				objLabel.appendChild(objOption);
			}
			
		}
	}	
			
stateParam.prototype={		
	addOrg:function(addOrgObj)
	{
		var orgArrayLength=orgArray.length;
		orgArray[orgArrayLength]=new Array();
		orgArray[orgArrayLength]['id']=addOrgObj.orgID;
		orgArray[orgArrayLength]['name']=addOrgObj.orgName;
	},
	showorg:function()
	{
		setSelectValue("showInfo1","<%=ResourceBundle.getText(request,"message.organization")%>","org");
	},
	addRole:function(addRoleObj)
	{
		var roleArrayLength=roleArray.length;
		roleArray[roleArrayLength]=new Array();
		roleArray[roleArrayLength]['id']=addRoleObj.roleID;
		roleArray[roleArrayLength]['name']=addRoleObj.roleName;
	},
	showrole:function()
	{
	setSelectValue("showInfo1","<%=ResourceBundle.getText(request,"message.role")%>","role");
	},
	addUser:function(addUserObj)
	{
		var userArrayLength=userArray.length;
		userArray[userArrayLength]=new Array();
		userArray[userArrayLength]['id']=addUserObj.userID;
		userArray[userArrayLength]['name']=addUserObj.userName;
	},
	showuser:function()
	{
	setSelectValue("showInfo1","<%=ResourceBundle.getText(request,"message.user")%>","user");
	}

}
function personInfo()
{

}
function startPersonInfo(thisorg,thisrole,thisuser)
{

	this.thisorg=thisorg;
	this.thisrole=thisrole;
	this.thisuser=thisuser;
}

personInfo.prototype={
	addPersoninfo:function(thisperdoninfo)
	{
			this.splitInfo(thisperdoninfo.thisorg,"org")
			this.splitInfo(thisperdoninfo.thisrole,"role")
			this.splitInfo(thisperdoninfo.thisuser,"user")
	},
	splitInfo:function(splitobj,splitw)
	{
		
			var splitArr=new Array()
			splitArr=splitobj.split(",")
			for(var s=0;s<splitArr.length;s++)
			{
				var personArrLength=personArr.length;
				personArr[personArrLength]=new Array()
				personArr[personArrLength][splitw]=splitArr[s]
			}
	}
}
function saveselect()
{
	
		var selectObj=document.getElementById("showInfo1_in").options
		var selectLength=selectObj.length
		var selectOrg="";
		var selectRole=""
		var selectUser=""
		var selectValue=""
		for(var i=0;i<selectLength;i++)
		{
				if(selectValue=="")selectValue=selectObj[i].innerText
				else selectValue=selectValue+","+selectObj[i].innerText
				if(selectObj[i].parentNode.thistype=="org")
				{
					if(selectOrg=="")selectOrg=selectObj[i].value
					else selectOrg=selectOrg+","+selectObj[i].value
				}
				else 	if(selectObj[i].parentNode.thistype=="role")
				{
					if(selectRole=="")selectRole=selectObj[i].value
					else selectRole=selectRole+","+selectObj[i].value
				}
				else 	if(selectObj[i].parentNode.thistype=="user")
				{
					if(selectUser=="")selectUser=selectObj[i].value
					else selectUser=selectUser+","+selectObj[i].value
				}
		}
		window.opener.document.getElementById("receiver").value=selectValue;
		window.opener.document.getElementById("org").value=selectOrg
		window.opener.document.getElementById("role").value=selectRole
		window.opener.document.getElementById("user").value=selectUser
		window.close()

}
if(opener.document.getElementById("receiver").value!="")
{
	var setorg=opener.document.getElementById("org").value
	var setrole=opener.document.getElementById("role").value
	var setuser=opener.document.getElementById("user").value
	var personinfo=new personInfo();
	var startperson=new startPersonInfo(setorg,setrole,setuser);
	personinfo.addPersoninfo(startperson);
	
}


var stateparam= new stateParam();
<%
SysOrgDAO sysOrgDAO = (SysOrgDAO) Tools.getBean("sysOrgDAO");
List<SysOrg> sysOrgList = sysOrgDAO.getSysOrgList(new SysOrg());
for (SysOrg sysOrg :sysOrgList) {	
%>
var floworg = new orgObj("<%=sysOrg.getId()%>","<%=sysOrg.getOrgName()%>(<%=sysOrg.getOrgId()%>)")
stateparam.addOrg(floworg);
<%
} 
%>
stateparam.showorg();

<%
SysRoleDAO sysRoleDAO = (SysRoleDAO) Tools.getBean("sysRoleDAO");
List<SysRole> sysRoleList = sysRoleDAO.getSysRoleList(new SysRole());
for (SysRole sysRole : sysRoleList) {	
%>
var flowrole = new roleObj("<%=sysRole.getId()%>","<%=sysRole.getRoleName()%>(<%=sysRole.getRoleId()%>)")
stateparam.addRole(flowrole);
<%
} 
%>
stateparam.showrole();

<%
SysUserDAO sysUserDAO = (SysUserDAO) Tools.getBean("sysUserDAO");
List<SysUser> sysUserList = sysUserDAO.getSysUserList(new SysUser());
for (SysUser sysUser : sysUserList) {	
%>
var flowuser = new userObj("<%=sysUser.getId()%>","<%=sysUser.getUserName()%>(<%=sysUser.getUserId()%>)")
stateparam.addUser(flowuser);
<%
} 
%>
stateparam.showuser();
</script>


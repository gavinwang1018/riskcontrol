<HTML>
<HEAD>
<%@ page language="java" pageEncoding="GBK" contentType="text/html;charset=GBK" %>
<%@ page import="java.util.*" %>
<%@ page import="cn.com.brilliance.begen.model.SysApp" %>
<%@ page import="cn.com.brilliance.begen.model.SysMenu" %>
<%@ page import="cn.com.brilliance.begen.model.SysRoleAuthority" %>
<%@ page import="cn.com.brilliance.begen.common.Tools" %>
<%@ page import="cn.com.brilliance.begen.dao.SysAppDAO" %>
<%@ page import="cn.com.brilliance.begen.dao.SysRoleAuthorityDAO" %>
<%
String roleId = (String)request.getParameter("_roleId");
//String partyId = BeAppDaoHelper.getPartyId();
String basePath = request.getContextPath();
SysAppDAO sysAppDAO = (SysAppDAO)Tools.getBean("sysAppDAO");
SysApp sa = new SysApp();
//sa.setPartyId(partyId);
List sysAppList = sysAppDAO.getSysAppList(sa);

List sysRoleAuthorityAppList = new ArrayList();
List sysRoleAuthorityMenuList = new ArrayList();

SysRoleAuthorityDAO sysRoleAuthorityDAO = (SysRoleAuthorityDAO) Tools.getBean("sysRoleAuthorityDAO");
SysRoleAuthority sysRoleAuthority = new SysRoleAuthority();
//sysRoleAuthority.setPartyId(partyId);
sysRoleAuthority.setRoleId(roleId);
List sysRoleAuthorityList = sysRoleAuthorityDAO.getSysRoleAuthorityList(sysRoleAuthority);
for(int k=0; k<sysRoleAuthorityList.size(); k++){
	SysRoleAuthority sysRoleAuth = (SysRoleAuthority)sysRoleAuthorityList.get(k);
	String type = sysRoleAuth.getAuthorityType();
	if("4".equals(type)){
		sysRoleAuthorityAppList.add(sysRoleAuth);
	}else if("5".equals(type)){
		sysRoleAuthorityMenuList.add(sysRoleAuth);		
	}
}

%>
<TITLE>用户角色的授权配置</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<SCRIPT src="<%=basePath%>/scripts/config_treetable.js" type=text/javascript></SCRIPT>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/config_common.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/extconfig.css" />


<link rel="stylesheet" type="text/css" media="all" href="<%=basePath%>/styles/config.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/styles/right.css" />

<script type="text/javascript" src="<%=basePath%>/scripts/prototype.js"></script> 
<script type="text/javascript" src="<%=basePath%>/scripts/effects.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/global.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/common.js"></script>

<script type="text/javascript" src="<%=basePath%>/scripts/behaviour.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/getclass.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/calculator.js"></script>
<script language=javascript src="<%=basePath%>/scripts/getreset.js"></script>
<SCRIPT type=text/javascript>
    treetable_callbacks['eventRowStateChanged'] = 'treetable_eventRowChanged';
    
    function treetable_eventRowChanged(rowId, state) {
      img = document.getElementById(rowId).getElementsByTagName('TD')[0].getElementsByTagName('img')[0];
      if (state == 1) {
      	if(rowId.split("_").length>2)img.src = '<%=basePath%>/images/folderopen_def.png';
        else img.src = '<%=basePath%>/images/dbopen.gif';
      } else {
      	if(rowId.split("_").length>2)img.src = '<%=basePath%>/images/folderclose_def.png';
        else img.src = '<%=basePath%>/images/dbclose.gif';
      }
      return (true); 
    }  
</SCRIPT>
<script  language="JavaScript">
loadHidInfo()
</script>
</HEAD>

<body style="margin-left:5px;margin-top:2px;margin-right:5px;margin-bottom:0px;">
<div class="title">	
	<table cellspacing=0 cellpadding=0>
        <tr>
        	<td style="vertical-align:top;">
				<img src="<%=basePath%>/images/title_icon_right.gif" align=left />
			</td>
			<td>
				<p class="titleText">授权配置</p>			
				<p class="titleText1">&nbsp;&nbsp;&nbsp;&nbsp;用户角色的授权配置</p>			
			</td>
   		</tr>
   </table>	
</div>
<br />
<form method="post" name="appConfig" action="<%=basePath%>/RightControlServlet">
<TABLE  style="width:100%;border-bottom:2px solid #7ABEFF;" cellspacing=0 cellpadding=0>
  <TBODY>
  	<tr  class="mainHeader">
  		<td style="width:70%;"><img src="<%=basePath%>/images/icon_sub_right.gif" style="vertical-align:middle;" />应用组菜单配置</td>
  		<td  style="text-align:right;width:200px;align:right;">
				<input type="button" value="全部收拢" onclick="treetable_collapseAll('table1');" class="button" id="treeButton">
  		</td>
  	</tr>
  	<tr><td style="height:2px;"  colspan=2></td></tr>
  	<tr>
  		<td style="width:100%"  colspan=2>
  			<table class=treetable id=table1 style="width:100%;" cellspacing=0 cellpadding=0>
			  <tr>
			    <th class="thTitle">&nbsp;</th>
			    <th class="thTitle" style="width:80px;text-align:center;"><nobr>权限控制开关</nobr></th>
			    <th class="thTitle">描述</th>
			 </tr>

<%
int col=1;
for(int i=0; i<sysAppList.size(); i++){
	SysApp sysApp = (SysApp)sysAppList.get(i);
	String appLabel = sysApp.getLabel();
	String appId = sysApp.getId();
	String appUrlDesc = sysApp.getUrlDescription();
	boolean appAuthority = sysApp.getAuthority().booleanValue();
	List level1List = new ArrayList();
	List level2List = new ArrayList();
	List level3List = new ArrayList();
	
	boolean flag = ((col++)%2)>0;
	boolean uflag = false;
	for(int n1=0; n1<sysRoleAuthorityAppList.size(); n1++){
		SysRoleAuthority sua = (SysRoleAuthority)sysRoleAuthorityAppList.get(n1);
		if(sua.getActionId().equals(appId)){
			uflag = true;
			break;
		}
	}
%>
	  <tr id=table1_<%=i%> class="<%if(flag){%>colTR<%}else{%>colTR1<%}%>">
	    <td style="width:180px;" title="<%=appLabel%>" class="td1">
		    <div style="width:180px;text-overflow:ellipsis;table-layout:fixed;overflow:hidden;" >
			    <nobr>
			    	<IMG class=imgbutton height=13 width=13  src="<%=basePath%>/images/dbopen.gif"  onclick="treetable_toggleRow('table1_<%=i%>');">
				    <A  href="<%=basePath%>/sys_app/sys_app_ViewForm.faces?_key=<%=appId%>"><%=appLabel%></A></nobr>
			</div>
	    </td>
	    <td class="tdTitle"  style="width:80px;text-align:center;"><nobr><%if(appAuthority){%><input type="checkbox" name="checkbox1_<%=i%>" defid="<%=appId+"||4"%>" <%if(uflag){%>checked<%}%> onclick="checkRow('checkbox1_<%=i%>')"><%}%>&nbsp;</nobr></td>
	    <td class="tdTitle" title="<%=appLabel%>" style="vertical-align:middle;"><div style="width:300px;text-overflow:ellipsis;table-layout:fixed;overflow:hidden;" ><nobr><%=appUrlDesc%></nobr></div></td>
	  </tr>
<%	
	Set sysMenuGroup = sysApp.getSysMenuGroup();
	for (Iterator it = sysMenuGroup.iterator(); it.hasNext();) {
		SysMenu sysMenu = (SysMenu) it.next();
		String mLevel = sysMenu.getMlevel();
		String party = sysMenu.getPartyId();
		//if(party != null && party.equals(partyId)){
			if ("1".equals(mLevel)) {
				level1List.add(sysMenu);
			} else if ("2".equals(mLevel)) {
				level2List.add(sysMenu);
			} else if ("3".equals(mLevel)) {
				level3List.add(sysMenu);
			} 
		//}
	}
	int index1=0;
	for(int n=0; n<level1List.size(); n++){
		SysMenu sysMenu1 = (SysMenu) level1List.get(n);
		String menuId1 = sysMenu1.getId();
		String label1 = sysMenu1.getLabel();
		String desc1 = sysMenu1.getUrlDescription();
		boolean isAuthority1 = sysMenu1.getAuthority().booleanValue();
		boolean flag1 = ((col++)%2)>0;
		boolean uflag1 = false;
		for(int a2=0; a2<sysRoleAuthorityMenuList.size(); a2++){
			SysRoleAuthority sua = (SysRoleAuthority)sysRoleAuthorityMenuList.get(a2);
			if(sua.getActionId().equals(menuId1)){
				uflag1 = true;
				break;
			}
		}
%>
	  <tr id=table1_<%=i%>_<%=index1%> class="<%if(flag1){%>colTR<%}else{%>colTR1<%}%>">
	    <td style="width:180px;" title="<%=label1%>" class="td1">
		    <div style="width:180px;text-overflow:ellipsis;table-layout:fixed;overflow:hidden;" >
			    <nobr>&nbsp;&nbsp;
			    	<IMG class=imgbutton height=13 width=13  src="<%=basePath%>/images/folderopen_def.png"  onclick="treetable_toggleRow('table1_<%=i%>_<%=index1%>');">
				    <A  href="<%=basePath%>/sys_menu/sys_menu_ViewForm.faces?_key=<%=menuId1%>"><%=label1%></A></nobr>
			</div>
	    </td>
	    <td class="tdTitle"  style="width:80px;text-align:center;"><nobr><%if(isAuthority1){%><input type="checkbox" name="checkbox1_<%=i%>_<%=index1%>" defid="<%=menuId1+"||5"%>" <%if(uflag1){%>checked<%}%> onclick="checkRow('checkbox1_<%=i%>_<%=index1%>')"><%}%>&nbsp;</nobr></td>
	    <td class="tdTitle" title="<%=label1%>" style="vertical-align:middle;"><div style="width:300px;text-overflow:ellipsis;table-layout:fixed;overflow:hidden;" ><nobr><%=desc1%></nobr></div></td>
	  </tr>	  
<%		
int index2=0;
		for (int k = 0; k < level2List.size(); k++) {
			SysMenu sysMenu2 = (SysMenu) level2List.get(k);
			String menuId2 = sysMenu2.getId();
			String parentMenuId2 = sysMenu2.getParentMenu();
			String label2 = sysMenu2.getLabel();
			String desc2 = sysMenu2.getUrlDescription();
			boolean isAuthority2 = sysMenu2.getAuthority().booleanValue();
			if(parentMenuId2.equals(menuId1)){
				boolean flag2 = ((col++)%2)>0;
				
				boolean uflag2 = false;
			    for(int b1=0; b1<sysRoleAuthorityMenuList.size(); b1++){
				    SysRoleAuthority sua = (SysRoleAuthority)sysRoleAuthorityMenuList.get(b1);
				    if(sua.getActionId().equals(menuId2)){
					    uflag2 = true;
					    break;
				    }
			    }
%>
	  <tr id=table1_<%=i%>_<%=index1%>_<%=index2%>  class="<%if(flag2){%>colTR<%}else{%>colTR1<%}%>">
	    <td style="width:180px;" title="<%=label2%>" class="td1">
		    <div style="width:180px;text-overflow:ellipsis;table-layout:fixed;overflow:hidden;" >
			    <nobr>&nbsp;&nbsp;&nbsp;&nbsp;
			    	<IMG class=imgbutton height=13 width=13  src="<%=basePath%>/images/folderopen_def.png"  onclick="treetable_toggleRow('table1_<%=i%>_<%=index1%>_<%=index2%>');">
				    <A  href="<%=basePath%>/sys_menu/sys_menu_ViewForm.faces?_key=<%=menuId2%>"><%=label2%></A></nobr>
			</div>
	    </td>
	    <td class="tdTitle"  style="width:80px;text-align:center;"><nobr><%if(isAuthority2){%><input type="checkbox" name="checkbox1_<%=i%>_<%=index1%>_<%=index2%>" defid="<%=menuId2+"||5"%>" <%if(uflag2){%>checked<%}%> onclick="checkRow('checkbox1_<%=i%>_<%=index1%>_<%=index2%>')"><%}%>&nbsp;</nobr></td>
	    <td class="tdTitle" title="<%=label2%>" style="vertical-align:middle;"><div style="width:300px;text-overflow:ellipsis;table-layout:fixed;overflow:hidden;" ><nobr><%=desc2%></nobr></div></td>
	  </tr>	
<%
		    }else{
		    	continue;
		    }
			int index3=0;		
			for (int m = 0; m < level3List.size(); m++) {
				SysMenu sysMenu3 = (SysMenu) level3List.get(m);
				String parentMenuId3 = sysMenu3.getParentMenu();
				String menuId3 = sysMenu3.getId();
				String label3 = sysMenu3.getLabel();
				String desc3 = sysMenu3.getUrlDescription();
				boolean isAuthority3 = sysMenu3.getAuthority().booleanValue();
				if(parentMenuId3.equals(menuId2)){
					boolean flag3 = ((col++)%2)>0;
					boolean uflag3 = false;
		      		for(int c1=0; c1<sysRoleAuthorityMenuList.size(); c1++){
		      			SysRoleAuthority sua = (SysRoleAuthority)sysRoleAuthorityMenuList.get(c1);
			        	if(sua.getActionId().equals(menuId3)){
				            uflag3 = true;
				            break;
			        	}
		      		}
%>
	  <tr id=table1_<%=i%>_<%=index1%>_<%=index2%>_<%=index3%> class="<%if(flag3){%>colTR<%}else{%>colTR1<%}%>">
	    <td style="width:180px;" title="<%=label3%>" class="td1">
		    <div style="width:180px;text-overflow:ellipsis;table-layout:fixed;overflow:hidden;" >
			    <nobr>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	<IMG class=imgbutton height=13 width=13  src="<%=basePath%>/images/file_def.png"  onclick="treetable_toggleRow('table1_<%=i%>_<%=index1%>_<%=index2%>_<%=index3%>');">
				    <A  href="<%=basePath%>/sys_menu/sys_menu_ViewForm.faces?_key=<%=menuId3%>"><%=label3%></A></nobr>
			</div>
	    </td>
	    <td class="tdTitle"  style="width:80px;text-align:center;"><nobr><%if(isAuthority3){%><input type="checkbox" name="checkbox1_<%=i%>_<%=index1%>_<%=index2%>_<%=index3%>" defid="<%=menuId3+"||5"%>" <%if(uflag3){%>checked<%}%> onclick="checkRow('checkbox1_<%=i%>_<%=index1%>_<%=index2%>_<%=index3%>')"><%}%>&nbsp;</nobr></td>
	    <td class="tdTitle" title="<%=label3%>" style="vertical-align:middle;"><div style="width:300px;text-overflow:ellipsis;table-layout:fixed;overflow:hidden;" ><nobr><%=desc3%></nobr></div></td>
	  </tr>	
<%	
				}else{
					continue;
				}
				index3++;
			}
			index2++;			
		}	
index1++;
	}
}	
%>		  	  
			</table>
		</td>
	</tr>
	<tr><td colspan=2 style="height:2px;"></td><tr>
	<tr  class="mainFooter">
		<td colspan=2 class="thTitle" style="text-align:center;">
			<a href="#"><input type="button" onclick="childShowSysInform();checkClick()" value="保存权限控制开关"  class="delbutton" style="background-image: url(<%=basePath%>/images/Btn_bg.gif);"></a>
			<input type="hidden" name="hid">
			<input type="hidden" name="_type" value="_role_menu">
			<input type="hidden" name="_role_id" value="<%=roleId%>">
		</td>
	</tr>	
  </TBODY>
 </TABLE>
</form>
	<script type="text/javascript">
		highlightTableRows("table1");
		function checkRow(checkID)
		{
			var checkObj=document.getElementById(checkID)
			
			var thisState=checkObj.checked;
			var allInputs=document.getElementsByTagName("INPUT");
			for(var i=0;i<allInputs.length;i++)
			{
				if(allInputs[i].type=="checkbox")
				{
					if(allInputs[i].name.search(checkID)!=-1)
					{
					allInputs[i].checked=thisState;
					}
				}
			}
			
		}
		function checkClick()
		{
			var clickName="";
			var allInputs=document.getElementsByTagName("INPUT");
			for(var i=0;i<allInputs.length;i++)
			{
				if(allInputs[i].type=="checkbox")
				{
					if(allInputs[i].checked==true)
					{
						if(allInputs[i].defid!=undefined)
						{
							if(clickName=='')clickName=allInputs[i].defid
							else clickName=clickName+","+allInputs[i].defid
						}
						
					}
				}
			}
			document.getElementById("hid").value=clickName;
			appConfig.submit();
		}
	</script>
</BODY>
</HTML>


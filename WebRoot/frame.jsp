<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="common/taglibs.jsp"%>
<%@ page language="java" import="cn.com.brilliance.begen.webapp.servlet.UserBean,cn.com.brilliance.begen.model.*" %>
<%@ page language="java" import="cn.com.brilliance.begen.common.Tools" %>
<%@ page language="java" import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<!DOCTYPE html public"-//w3c//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%
String basePath = request.getContextPath();
javax.faces.context.FacesContext.getCurrentInstance().getViewRoot().setLocale(cn.com.brilliance.begen.common.bundle.ResourceBundle.getLocale(request));

%>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
		<title>银联商务商户风险监控管理系统</title>		
		<link href="<%=basePath%>/styles/main.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePath%>/styles/xmenu.css" rel="stylesheet" type="text/css" />
		<input type="hidden" id="imagePath" value="<%=basePath%>/images">
		<input type="hidden" id="basePath" value="<%=basePath%>">	
		<input type="hidden" id="editFlag" value="0">
		<script type="text/javascript" src="<%=basePath%>/scripts/cssexpr.js"></script>
		<script type="text/javascript" src="<%=basePath%>/scripts/xmenu.js"></script>
		<script type="text/javascript" src="<%=basePath%>/scripts/prototype.lite.js" ></script>
		<script type="text/javascript" src="<%=basePath%>/scripts/moo.fx.js"></script>
		<script type="text/javascript" src="<%=basePath%>/scripts/moo.fx.pack.js"></script>
	</head>

<script type="text/javascript">
function dyniframesize(iframename) {

}

function hidLeftInfoA()
{
		document.getElementById("main_left").style.display='none';	
		document.getElementById("main_right").style.margin='0px';
		document.getElementById("showLeftMenu").innerText=document.getElementById("showlefttext").value;
		document.getElementById("showLeftMenuimg").src="images/change_btn.gif";
}

var application=new Array();
var myBar;

<%-- start:  Generated for 2c908349169f7cda0116a346225c0097 From Template: frame.jsp.vm  --%>
application[0] = new Array("<fmt:message key="app.2c908349169f7cda0116a346225c0097" />","1","homepage/right.html","")
function application_0()
{
webfxMenuImagePath	= "images";
myBar = new WebFXMenuBar;
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a349f0f800ab'] == 'true'}">
	var myMenu = new WebFXMenu;
	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916ad22cb0116ad30e9ba0004'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916ad22cb0116ad30e9ba0004" />", "t_organize_info/t_organize_info_list_List.faces", "<fmt:message key="menu.2c90834916ad22cb0116ad30e9ba0004" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a34a373800ac'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349169f7cda0116a34a373800ac" />", "t_user_info/t_user_info_list_List.faces", "<fmt:message key="menu.2c908349169f7cda0116a34a373800ac" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a34a9f6800ad'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349169f7cda0116a34a9f6800ad" />", "t_role_info/t_role_info_List.faces", "<fmt:message key="menu.2c908349169f7cda0116a34a9f6800ad" />"))
	</c:if>
	myBar.add(new WebFXMenuButton("<fmt:message key="menu.2c908349169f7cda0116a349f0f800ab" />","","<fmt:message key="menu.2c908349169f7cda0116a349f0f800ab" />",myMenu));
</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a34b15e000ae'] == 'true'}">
	var myMenu = new WebFXMenu;
	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c9083491716165a011719a1e97a0007'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c9083491716165a011719a1e97a0007" />", "t_rule_instance/t_rule_instance_list_List.faces", "<fmt:message key="menu.2c9083491716165a011719a1e97a0007" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c9083491716165a011719a08bee0006'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c9083491716165a011719a08bee0006" />", "t_rule_group/t_rule_group_list_List.faces", "<fmt:message key="menu.2c9083491716165a011719a08bee0006" />"))
	</c:if>
	myBar.add(new WebFXMenuButton("<fmt:message key="menu.2c908349169f7cda0116a34b15e000ae" />","","<fmt:message key="menu.2c908349169f7cda0116a34b15e000ae" />",myMenu));
</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a34fc3d000bc'] == 'true'}">
	var myMenu = new WebFXMenu;
	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a34feea900bd'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349169f7cda0116a34feea900bd" />", "t_riskcase/t_riskcase_list_List.faces", "<fmt:message key="menu.2c908349169f7cda0116a34feea900bd" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349173e897b011748ef9f0900e3'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349173e897b011748ef9f0900e3" />", "t_riskcase/t_riskcase_list_queryByBelong_List.faces", "<fmt:message key="menu.2c908349173e897b011748ef9f0900e3" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834917523149011758b7021a0096'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834917523149011758b7021a0096" />", "t_riskcase/t_riskcase_list_queryByBelong_List.faces", "<fmt:message key="menu.2c90834917523149011758b7021a0096" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916ad22cb0116ae83010f00b3'] == 'true'}">
		var tmp=new WebFXMenu;
		
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916ad22cb0116ae84075400b6'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916ad22cb0116ae84075400b6" />", "t_riskcase/t_riskcase_form_add_EditForm.faces?casefrom=3", "<fmt:message key="menu.2c90834916ad22cb0116ae84075400b6" />"))
	</c:if>	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916ad22cb0116ae8453be00b7'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916ad22cb0116ae8453be00b7" />", "t_riskcase/t_riskcase_form_add_dw_EditForm.faces?casefrom=4", "<fmt:message key="menu.2c90834916ad22cb0116ae8453be00b7" />"))
	</c:if>	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916ad22cb0116ae84c73900b8'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916ad22cb0116ae84c73900b8" />", "t_riskcase/t_riskcase_form_add_paper_EditForm.faces?casefrom=5", "<fmt:message key="menu.2c90834916ad22cb0116ae84c73900b8" />"))
	</c:if>	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916ad22cb0116ae85103800b9'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916ad22cb0116ae85103800b9" />", "t_riskcase/t_riskcase_form_add_otherway_EditForm.faces?casefrom=6", "<fmt:message key="menu.2c90834916ad22cb0116ae85103800b9" />"))
	</c:if>	
		myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916ad22cb0116ae83010f00b3" />", "", "<fmt:message key="menu.2c90834916ad22cb0116ae83010f00b3" />",tmp))
</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c9083491716165a011719b3a2e4000d'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuSeparator());
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a93443890699'] == 'true'}">
		var tmp=new WebFXMenu;
		
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916d142fa0116d7e91c1c04a1'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916d142fa0116d7e91c1c04a1" />", "ext_t_riskcase/ext_t_riskcase_send.faces?status=0", "<fmt:message key="menu.2c90834916d142fa0116d7e91c1c04a1" />"))
	</c:if>	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916d142fa0116d7e9947904a2'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916d142fa0116d7e9947904a2" />", "ext_t_riskcase/ext_t_riskcase_sendToInst.faces?status=1", "<fmt:message key="menu.2c90834916d142fa0116d7e9947904a2" />"))
	</c:if>	
		myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349169f7cda0116a93443890699" />", "", "<fmt:message key="menu.2c908349169f7cda0116a93443890699" />",tmp))
</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916d142fa0116d7b89542049c'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916d142fa0116d7b89542049c" />", "t_riskcase/t_riskcase_form_makeing_List.faces?status=2", "<fmt:message key="menu.2c90834916d142fa0116d7b89542049c" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916d142fa0116d7b8fcd6049d'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916d142fa0116d7b8fcd6049d" />", "t_riskcase/t_riskcase_form_actionend_List.faces?status=3", "<fmt:message key="menu.2c90834916d142fa0116d7b8fcd6049d" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c9083491716165a011719bd5418000f'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c9083491716165a011719bd5418000f" />", "t_riskcase/t_riskcase_form_depend_List.faces?status=4", "<fmt:message key="menu.2c9083491716165a011719bd5418000f" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916d142fa0116d6a4031302e6'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916d142fa0116d6a4031302e6" />", "ext_t_riskcase/ext_t_riskcase_urgent.faces?emptyList=true", "<fmt:message key="menu.2c90834916d142fa0116d6a4031302e6" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c9083491716165a011719be63840010'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c9083491716165a011719be63840010" />", "t_riskcase/t_riskcase_form_belongover_List.faces?status=5", "<fmt:message key="menu.2c9083491716165a011719be63840010" />"))
	</c:if>
	myBar.add(new WebFXMenuButton("<fmt:message key="menu.2c908349169f7cda0116a34fc3d000bc" />","","<fmt:message key="menu.2c908349169f7cda0116a34fc3d000bc" />",myMenu));
</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a35088b700bf'] == 'true'}">
	var myMenu = new WebFXMenu;
	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916f534a20116fa5daffb00d8'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916f534a20116fa5daffb00d8" />", "t_mchnt/t_mchnt_list_merandapp_List.faces", "<fmt:message key="menu.2c90834916f534a20116fa5daffb00d8" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916cc3c880116cd684f1a0009'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916cc3c880116cd684f1a0009" />", "t_keo_mchnt/t_keo_mchnt_list_List.faces", "<fmt:message key="menu.2c90834916cc3c880116cd684f1a0009" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916d142fa0116d2a249fd0031'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916d142fa0116d2a249fd0031" />", "t_mchnt/t_mchnt_list_add_List.faces", "<fmt:message key="menu.2c90834916d142fa0116d2a249fd0031" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c9083491716165a011719b4a522000e'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c9083491716165a011719b4a522000e" />", "t_keo_mchnt/t_keo_mchnt_import.faces", "<fmt:message key="menu.2c9083491716165a011719b4a522000e" />"))
	</c:if>
	myBar.add(new WebFXMenuButton("<fmt:message key="menu.2c908349169f7cda0116a35088b700bf" />","","<fmt:message key="menu.2c908349169f7cda0116a35088b700bf" />",myMenu));
</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a350d43700c0'] == 'true'}">
	var myMenu = new WebFXMenu;
	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a3517b6400c2'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349169f7cda0116a3517b6400c2" />", "t_cardbin/t_cardbin_list_view_List.faces", "<fmt:message key="menu.2c908349169f7cda0116a3517b6400c2" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916c1da250116c1f44b560019'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916c1da250116c1f44b560019" />", "t_basearg/t_basearg_list_tradecode_List.faces", "<fmt:message key="menu.2c90834916c1da250116c1f44b560019" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834916c1da250116c1f4d353001a'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834916c1da250116c1f4d353001a" />", "t_basearg/t_basearg_list_responsecode_List.faces", "<fmt:message key="menu.2c90834916c1da250116c1f4d353001a" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834917143e52011715b1bcb500df'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834917143e52011715b1bcb500df" />", "t_mcc/t_mcc_list_view_List.faces", "<fmt:message key="menu.2c90834917143e52011715b1bcb500df" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349171a86da01171aaa8a89006b'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349171a86da01171aaa8a89006b" />", "t_riskprocess_timelimit/t_riskprocess_timelimit_List.faces", "<fmt:message key="menu.2c908349171a86da01171aaa8a89006b" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349171a86da01171aab23cb006c'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349171a86da01171aab23cb006c" />", "t_basearg/t_basearg_list_warnlevel_List.faces", "<fmt:message key="menu.2c908349171a86da01171aab23cb006c" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349173e897b01173e91dc9b002f'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349173e897b01173e91dc9b002f" />", "t_basearg/t_basearg_list_similarcard_List.faces", "<fmt:message key="menu.2c908349173e897b01173e91dc9b002f" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349173e897b01173e927cb40030'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349173e897b01173e927cb40030" />", "t_basearg/t_basearg_list_newMerTime_List.faces", "<fmt:message key="menu.2c908349173e897b01173e927cb40030" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349173e897b01173e9319fd0031'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c908349173e897b01173e9319fd0031" />", "t_basearg/t_basearg_list_canceledMerTime_List.faces", "<fmt:message key="menu.2c908349173e897b01173e9319fd0031" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c9083491781cf8f011781f487cd0006'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c9083491781cf8f011781f487cd0006" />", "t_basearg/t_basearg_List.faces", "<fmt:message key="menu.2c9083491781cf8f011781f487cd0006" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834917c8642d0117c9b282e90005'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834917c8642d0117c9b282e90005" />", "t_basearg/t_basearg_list_caseMer_List.faces", "<fmt:message key="menu.2c90834917c8642d0117c9b282e90005" />"))
	</c:if>
	myBar.add(new WebFXMenuButton("<fmt:message key="menu.2c908349169f7cda0116a350d43700c0" />","","<fmt:message key="menu.2c908349169f7cda0116a350d43700c0" />",myMenu));
</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c908349169f7cda0116a3510f1d00c1'] == 'true'}">
	var myMenu = new WebFXMenu;
	
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834917afeeb10117b02a724f0006'] == 'true'}">
		var tmp=new WebFXMenu;
		
			myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834917afeeb10117b02a724f0006" />", "t_trans_info/t_trans_info_view_list_List.faces?_emptyList=true", "<fmt:message key="menu.2c90834917afeeb10117b02a724f0006" />"))
	</c:if>
<c:if test="${ sessionScope._user_info.rightMap['menu.2c90834917bef52f0117c4331017000b'] == 'true'}">
		var tmp=new WebFXMenu;
		
<c:if test="${ sessionScope._user_info.rightMap['menu.22dadfad3fafds3afas32ggadfadfs01'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="reportName.VariousIndustries" />", "t_report/VariousIndustries.faces", "<fmt:message key="reportName.VariousIndustries" />"))
	</c:if>	                                         																	
<c:if test="${ sessionScope._user_info.rightMap['menu.22dadfad3fafds3afas32ggadfadfs02'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="reportName.VariousChannels" />", "t_report/VariousChannels.faces", "<fmt:message key="reportName.VariousChannels" />"))
	</c:if>	
<c:if test="${ sessionScope._user_info.rightMap['menu.22dadfad3fafds3afas32ggadfadfs03'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="reportName.VariousBranches" />", "t_report/VariousBranches.faces", "<fmt:message key="reportName.VariousBranches" />"))
	</c:if>	
<c:if test="${ sessionScope._user_info.rightMap['menu.22dadfad3fafds3afas32ggadfadfs04'] == 'true'}">
			tmp.add(new WebFXMenuItem("<fmt:message key="reportName.VariousTime" />", "t_report/VariousTime.faces", "<fmt:message key="reportName.VariousTime" />"))
	</c:if>	
		myMenu.add(new WebFXMenuItem("<fmt:message key="menu.2c90834917bef52f0117c4331017000b" />", "", "<fmt:message key="menu.2c90834917bef52f0117c4331017000b" />",tmp))
</c:if>
	myBar.add(new WebFXMenuButton("<fmt:message key="menu.2c908349169f7cda0116a3510f1d00c1" />","","<fmt:message key="menu.2c908349169f7cda0116a3510f1d00c1" />",myMenu));
</c:if>
}


<%-- end:  Generated for 2c908349169f7cda0116a346225c0097 From Template: frame.jsp.vm  --%>
//add-app-and-menu-script-here

//hid left
function changeShow(showObj,hidAllObj)
{
	if (document.getElementById(showObj).style.display=="none"){
	document.getElementById(showObj).style.display="";
	document.getElementById("arrow_"+showObj).className="arrow_left_show_common";
	}
	else{
	document.getElementById(showObj).style.display="none";
	document.getElementById("arrow_"+showObj).className="arrow_left_close_common";
	}
	var tempHidArr=new Array()
	tempHidArr=hidAllObj.split(",");
	for(var i=0;i<tempHidArr.length;i++)
	{
		var hidObj=tempHidArr[i]
		document.getElementById(hidObj).style.display="none";
		document.getElementById("arrow_"+hidObj).className="arrow_left_close_common";
	}
}

</script>	
		<body onload="configLoadApp();loadMenu();loadLeftInfo();hidLeftInfoA()">
		<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" id="main_table">
		  <tr>
		    <td align="center" valign="middle">
		    	<table width="1000" border="0" cellspacing="0" cellpadding="0">
		      		<tr>
			        	<td>
						<div id="top1">
							<div id="logo"><img src="images/logo_chinaums.gif" /></div>
							<div id="nav1">
							<ul class="TabBarLevel1" id="appul">
								<li onclick="showAppBefore()" style="display:none;"><a href="#" hidefocus="true"><</a></li>
							</ul>
							</div>
							<div id="top_right">
							<ul>
							  <!-- <li><a href="<%=basePath%>/userinfo/modify_userinfo.faces" target="mainFrame"><img src="images/smallicon1.gif" width="13" height="13" border="0" /><%=ResourceBundle.getText(request,"message.page.editinfo")%></a></li> -->
							  <li><a href="<%=basePath%>/LogoutServlet"><img src="images/smallicon2.gif" width="12" height="14" border="0" /><%=ResourceBundle.getText(request,"message.page.quit")%></a></li>
							</ul>
							</div>
						</div>
						<div   id="top_menu"  name="top_menu"></div>
						<div id="main" >
						  <div id="main_left">
							<div id="container">
							  <H1 class="title" style="display:none"><A href="javascript:void(0)" hidefocus="true"><img src="images/leftmenuicon6.gif" width="22" height="22" border="0" /> <%=ResourceBundle.getText(request,"label.tree")%></a><img src="images/button_left_close.gif" style="float:right;margin-top:-22px;" onclick="closeTree()" onmouseover="overTree(this)" onmouseout="outTree(this)" /></H1>
							  <div class="content">
							  	<iframe style="display:none" name="treeIframe" id="treeIframe" src="tree.jsp" width="190" marginwidth="0" height="350" marginheight="0" align="left" scrolling="auto" frameborder="0" class="moo_content"></iframe>
							  </div>
							  <H1 class="title"><a href="javascript:void(0)" hidefocus="true"><img src="images/leftmenuicon5.gif" width="22" height="22" border="0" /> <%=ResourceBundle.getText(request,"label.operation")%></a></H1>
							  <div class="content">				
								<iframe name="historyIframe" id="historyIframe" src="history.jsp" scrolling="NO" width="180" marginwidth="0" height="350" marginheight="0" align="left" frameborder="0" class="moo_content"></iframe>
							  </div>
							</div>
						  </div>
						  <div id="tasklistbar">
							  <div id="tasklist"></div>
							  <!--<span><img  src="images/btn_arrow_left_01.jpg" style="cursor:pointer;padding-top:6px;" onclick="backHis()" onmouseover="overLeftShow(this)" onmouseout="overLeftHid(this)"  alt="<%=ResourceBundle.getText(request,"button.hisback")%>"> <img src="images/btn_arrow_up_01.jpg" style="cursor:pointer;" onclick="goLast()" onmouseover="overUpShow(this)" onmouseout="overUpHid(this)" alt="<%=ResourceBundle.getText(request,"button.histop")%>"></span>-->
						  </div>
						  <div id="main_right" style="padding-top:2px;padding-left:2px;">
						    <iframe src="blank.jsp" id="mainFrame" name="mainFrame" width="100%" height=470" marginwidth="0" marginheight="0" scrolling="auto" frameborder="0"></iframe>
						  </div>
						</div>
						<div class="newline"></div>
						<div id="bottom">
						  <table width="100%" height="25px" border="0" cellspacing="0" cellpadding="0">
						    <tr>
						      <td width="20">&nbsp;</td>
						      <td width="100"><a href="#" onclick="hidleft()"><img src="images/change_btn1.gif" name="showLeftMenuimg" width="18" height="16" border="0" id="showLeftMenuimg" />
						      <div id="showLeftMenu"><%=ResourceBundle.getText(request,"button.hideleft")%></div></a><input type="hidden"  id="hidlefttext" value="<%=ResourceBundle.getText(request,"button.hideleft")%>"><input type="hidden" id="showlefttext" value="<%=ResourceBundle.getText(request,"button.showleft")%>"></td>
						      <td><img src="images/smallicon5.gif" width="2" height="13" /> <img src="images/smallicon3.gif" /> <c:out value="${_user_info.tuserInfo.name}" />(<c:out value="${_user_info.tuserInfo.loginName}" />  <c:out value="${_user_info.tuserInfo.organizeIdOfTorganizeInfo.name}" />) </td>
						      <td><div align="right"><img src="images/smallicon5.gif" width="2" height="13" /> <%=ResourceBundle.getText(request,"iframe.copyright")%></div></td>
						      <td width="20">&nbsp;</td>
						    </tr>
						  </table>
						</div>
						</td>
		      		</tr>
		    	</table>
		    </td>
		  </tr>
		</table>
		<div id="loading" style="display:none;Z-INDEX: 199;POSITION: absolute;">
		  <div id="loading_text" align="center">
	  		<table width="100%" height="80%" border="0" cellspacing="0" cellpadding="0" class="loading_info">
			  <tr>
			    <td rowspan="2" width="70" valign="top" style="padding-top:10px;"><img src="images/loading.gif" hspace="10" align="absmiddle"></td>
			    <td  height="30%" style="padding:10px 40px 0 0;"><span id="inform1"><%=ResourceBundle.getText(request,"message.page")%></span></td>
			  </tr>
			  <tr>
			    <td valign="top"><input type="button" class="button" onClick="thisLoadHidInfo()" value="<%=ResourceBundle.getText(request,"message.page.cancel")%>"></td>
			  </tr>
			</table>
		  </div>
		</div>
		<div class="bgDiv" name="sDivInfo" id="sDivInfo" style="display:none">
		<iframe src="blank.jsp" frameborder=0 name="divFrame" id="divFrame"></iframe>
		</div>		
	</body>
</html>
<script language=javascript>
if(parseInt(screen.height)>1000)
{
	document.getElementById("main_left").style.height="770px";
	document.getElementById("main_right").style.height="740px";
	document.getElementById("mainFrame").style.height="740px";
	document.getElementById("historyIframe").style.height="740px";
	//document.getElementById("leftIframe").style.height="620px";
	//document.getElementById("transmitIframe").style.height="620px";
	//document.getElementById("messageIframe").style.height="620px";
	//document.getElementById("processIframe").style.height="620px";
	//document.getElementById("treeIframe").style.height="620px";
}

if(parseInt(screen.height)==900)
{
	document.getElementById("main_left").style.height="630px";
	document.getElementById("main_right").style.height="600px";
	document.getElementById("mainFrame").style.height="600px";
	document.getElementById("historyIframe").style.height="600px";
	//document.getElementById("leftIframe").style.height="620px";
	//document.getElementById("transmitIframe").style.height="620px";
	//document.getElementById("messageIframe").style.height="620px";
	//document.getElementById("processIframe").style.height="620px";
	//document.getElementById("treeIframe").style.height="620px";
}
if(parseInt(screen.height)==800)
{
	document.getElementById("main_left").style.height="510px";
	document.getElementById("main_right").style.height="480px";
	document.getElementById("mainFrame").style.height="480px";
	document.getElementById("historyIframe").style.height="480px";
	//document.getElementById("leftIframe").style.height="620px";
	//document.getElementById("transmitIframe").style.height="620px";
	//document.getElementById("messageIframe").style.height="620px";
	//document.getElementById("processIframe").style.height="620px";
	//document.getElementById("treeIframe").style.height="620px";
}

function showSysInform()
{
	var sw=parseInt(parseInt(screen.width)/2);
	var sh=parseInt(parseInt(screen.height)/2);
	var divObj=document.getElementById("loading");
	divObj.style.top=sh-180;
	divObj.style.left=sw-150;
	divObj.style.display='';
	var div1=document.getElementById("sDivInfo");
	if (document.body.scrollHeight > document.body.offsetHeight)div1.style.height=document.body.scrollHeight
	else div1.style.height=document.body.clientHeight;
	div1.style.width=document.body.clientWidth;	
	div1.style.display='';
	document.getElementById("divFrame").style.width=div1.style.width
	document.getElementById("divFrame").style.height=div1.style.height;
	
}
function thisLoadHidInfo()
{
	document.getElementById("loading").style.display='none';
	document.getElementById("sDivInfo").style.display='none';
}

</script>
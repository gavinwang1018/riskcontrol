<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<%@ include file="/common/taglibs.jsp"%>
<HTML><HEAD><TITLE></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.3790.373" name=GENERATOR>
<link rel="stylesheet" type="text/css" media="all" href="scan.css" />
<SCRIPT language=vbScript>	
Sub Init()

XinChenScan1.mFileID = "myuploadfile"
XinChenScan1.mBackColor = RGB(191,239,255)

end Sub 

</SCRIPT>

<script id="clientEventHandlersJS" language="javascript">
var finishscan=null;
var xmlhttp;
function cmdSelectTwin_onclick() {
	Xinchenscan1.SelectTwin();
}
function cmdScan_onclick() {
	Xinchenscan1.Scan();
}

function DeBorder_onclick() {
	Xinchenscan1.DeBorder(9);
}

function DeBorder1_onclick() {
	Xinchenscan1.BorderRemove(20, 50, 20);
}

function cmdSizeOut_onclick() {
	Xinchenscan1.DrawZoomOut();
}

function cmdAudesk_onclick() {
	Xinchenscan1.AutoDeskew(2);
}

function cmdAudesk1_onclick() {
	Xinchenscan1.AutoDeskew(1);
	
}

function cmdDespeckle_onclick() {
	Xinchenscan1.Despeckle();//
}

function cmdRemoveLine_onclick(){
	Xinchenscan1.QuickRemoveline(200, 0, 1, 200);
}

function cmdSizeIn_onclick() {
	Xinchenscan1.DrawZoomIn();
}

function cmdRoate_onclick() {
	Xinchenscan1.Rotate(90);
}

function CmdMoveUp_onclick() {
	Xinchenscan1.MoveUp();
}

function CmdMoveDown_onclick() {
	Xinchenscan1.MoveDown();
}

function cmdDelete_onclick() {
	Xinchenscan1.DeltetCurrentPage();
}

function cmdPrint_onclick() {
	Xinchenscan1.FilePrint();
}

function DrawLine_onclick() {
	Xinchenscan1.DrawLine();
}

function DrawZLine_onclick() {
	Xinchenscan1.DrawZLine();
}

function DrawXRectangle_onclick() {
	Xinchenscan1.DrawXRectangle();
}

function DrawSRectangle_onclick() {
	Xinchenscan1.DrawSRectangle();
}

function DrawEllipse_onclick() {
	Xinchenscan1.DrawEllipse();
}

function DrawZYLine_onclick() {
	Xinchenscan1.DrawZYLine();
}

function DrawText_onclick() {
	Xinchenscan1.DrawText();
}

function DrawColor_onclick() {
	Xinchenscan1.DrawColor();
}

function SaveNoteFile_onclick() {
	Xinchenscan1.SaveNoteFile();
}

function OpenImageNote_onclick() {
    Xinchenscan1.ImageUrl = "http://localhost/00000001.tif";
    Xinchenscan1.NoteFileUrl = "http://localhost/00000001.txt";
    Xinchenscan1.OpenImageUrl();
    var NoteFile= Xinchenscan1.NoteFileUrl;
    alert(NoteFile);
    Xinchenscan1.ShowNote=true;
}

function ShowNoteTrue_onclick() {
	Xinchenscan1.ShowNote=true;
}

function ShowNoteFalse_onclick() {
	Xinchenscan1.ShowNote=false;
}

function cmdSave_onclick() {
	Xinchenscan1.Save();
}

function cmdSaveEnd_onclick() {

	var userscan=window.dialogArguments.userscan;
	var userscan1=window.dialogArguments.userscan1;
	var usermessage=window.dialogArguments.usermessage;
   var ado_stream = new ActiveXObject("ADODB.Stream");
   var xml_dom = new ActiveXObject("MSXML2.DOMDocument");
   xml_dom.loadXML("<?xml version=\"1.0\" ?> <root/>");
   xml_dom.documentElement.setAttribute("xmlns:dt", "urn:schemas-microsoft-com:datatypes");
   var files = xml_dom.createElement("files");
   Xinchenscan1.ScanEnd();
	var filename=Xinchenscan1.MultiFileName;
   var file=xml_dom.createElement("file");
   file.setAttribute("filename",usermessage+".pdf");
   file.dataType = "bin.base64";
   ado_stream.Type = 1
   ado_stream.Open(); 
   ado_stream.LoadFromFile(filename);
   file.nodeTypedValue = ado_stream.Read(-1);   
   ado_stream.Close()
   files.appendChild(file);

//   filename= Xinchenscan1.NoteFileUrl;
//   var file=xml_dom.createElement("file");
//   file.setAttribute("filename",filename);
//   file.dataType = "bin.base64";
//   ado_stream.Open(); 
//   ado_stream.LoadFromFile(filename);
//   file.nodeTypedValue = ado_stream.Read(-1);   
//   ado_stream.Close()
//   files.appendChild(file);

	var useradd=window.dialogArguments.useradd;
	var userport=window.dialogArguments.userport;
   xml_dom.documentElement.appendChild(files);
   if(window.ActiveXObject)
   {
      xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
   }
   else if(window.XMLHttpRequest)
   {
   		xmlhttp = new XMLHttpRequest();
   }

   xmlhttp.open("POST","http://<%=request.getServerName()%>:<%=request.getServerPort()%>/config-server/EImageServlet",false);
   xmlhttp.send(xml_dom);

	window.dialogArguments.document.getElementById(userscan1).value=filename;
	window.dialogArguments.document.getElementById(userscan).value=usermessage+".pdf";

   //alert(xmlhttp.statusText);
  // var msgString = xmlhttp.ResponseText;
   //alert(msgString);
}


</script>
	</head>
	<body onload="Init()">
		<OBJECT id="Xinchenscan1" classid="clsid:89C19054-F448-4EBA-AFBA-C81486248491" VIEWASTEXT width="90%" height="80%">
			<PARAM NAME="_ExtentX" VALUE="18177">
			<PARAM NAME="_ExtentY" VALUE="13229">
		</OBJECT>
		<HR width="100%" SIZE="1">
		<INPUT id="cmdRemoveLine0" type="button" value="<%=ResourceBundle.getText(request,"scan.button.audesk")%>" name="cmdRemoveLine" onclick="javascript:cmdAudesk_onclick()">
		<INPUT id="cmdRemoveLine2" type="button" value="<%=ResourceBundle.getText(request,"scan.button.audesk1")%>" name="cmdRemoveLine" onclick="javascript:cmdAudesk1_onclick()">       
		<INPUT id="cmdRemoveLine" type="button" value="<%=ResourceBundle.getText(request,"scan.button.border")%>" name="cmdDeBorder" onclick="javascript:DeBorder_onclick()">       
		<INPUT id="Button1" type="button" value="<%=ResourceBundle.getText(request,"scan.button.border1")%>" name="cmdDeBorder1" onclick="javascript:DeBorder1_onclick()">        
        <INPUT id="cmdRemoveLine1" type="button" value="<%=ResourceBundle.getText(request,"scan.button.removeline")%>" name="cmdRemoveLine" onclick="javascript:cmdRemoveLine_onclick()">        
        <INPUT id="cmdRemoveDonet" type="button" value="<%=ResourceBundle.getText(request,"scan.button.despeckle")%>" name="Button5" onclick="javascript:cmdDespeckle_onclick()">     
        <INPUT id="cmdSizeOut" type="button" value="<%=ResourceBundle.getText(request,"scan.button.sizeout")%>" name="Button7" onclick="javascript:cmdSizeOut_onclick()">       
		<INPUT id="cmdSizeIn" type="button" value="<%=ResourceBundle.getText(request,"scan.button.sizein")%>" name="Button8" onclick="javascript:cmdSizeIn_onclick()">    
        <INPUT id="cmdRoate" type="button" value="<%=ResourceBundle.getText(request,"scan.button.roate")%>" name="Button10" onclick="javascript:cmdRoate_onclick()">       
		<HR width="100%" SIZE="1">
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.drawline")%>" name="B3" onclick="javascript:DrawLine_onclick()">
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.drawzyline")%>" name="B3" onclick="javascript:DrawZYLine_onclick()">  
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.drawzline")%>" name="B3" onclick="javascript:DrawZLine_onclick()">  
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.drawxrectangle")%>" name="B3" onclick="javascript:DrawXRectangle_onclick()">  
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.drawellipse")%>" name="B3" onclick="javascript:DrawEllipse_onclick()">  
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.drawsrectangle")%>" name="B3" onclick="javascript:DrawSRectangle_onclick()">  
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.drawtext")%>" name="B3" onclick="javascript:DrawText_onclick()">  
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.drawcolor")%>" name="B3" onclick="javascript:DrawColor_onclick()"> 
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.savenotefile")%>" name="B3" onclick="javascript:SaveNoteFile_onclick()"> 
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.openimagenote")%>" name="B3" onclick="javascript:OpenImageNote_onclick()">  
        <input type="button" value="<%=ResourceBundle.getText(request,"scan.button.shownotetrue")%>" name="B3" onclick="javascript:ShowNoteTrue_onclick()"> 
        <input type="button" value="<%=ResourceBundle.getText(request,"scan.button.shownotefalse")%>" name="B3" onclick="javascript:ShowNoteFalse_onclick()"> 
		<HR width="100%" SIZE="1">
		<INPUT id="cmdSelectTwin" type="button" value="<%=ResourceBundle.getText(request,"scan.button.SelectTwin")%>" name="Button1" onclick="javascript:cmdSelectTwin_onclick()">
		<INPUT id="cmdScan" type="button" value="<%=ResourceBundle.getText(request,"scan.button.scan")%>" name="Button2" onclick="javascript:cmdScan_onclick()">        
		<INPUT id="cmdSave" type="button" value="<%=ResourceBundle.getText(request,"scan.button.save")%>" name="Button15" onclick="javascript:cmdSave_onclick()">  
		<INPUT id="cmdSave0" type="button" value="<%=ResourceBundle.getText(request,"scan.button.print")%>" name="Button15" onclick="javascript:cmdPrint_onclick()">        
		<INPUT id="cmdDelete" type="button" value="<%=ResourceBundle.getText(request,"scan.button.delete")%>" name="Button11" onclick="javascript:cmdDelete_onclick()">     
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.moveup")%>" name="B3" onclick="javascript:CmdMoveUp_onclick()">     
		<input type="button" value="<%=ResourceBundle.getText(request,"scan.button.movedown")%>" name="B3" onclick="javascript:CmdMoveDown_onclick()">   
		<INPUT id="cmdSave" type="button" value="<%=ResourceBundle.getText(request,"scan.button.saveend")%>" name="Button15" onclick="javascript:cmdSaveEnd_onclick()">      
	</body>
</html>




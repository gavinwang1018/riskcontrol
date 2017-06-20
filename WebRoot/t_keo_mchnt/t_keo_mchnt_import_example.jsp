
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 't_keo_mchnt_import_example.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
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
    
  </head>
  
  <body>
  	<script language=javascript>
		var imagePath = "<%=basePath%>/images" ;
	</script>
    <H5>导入文件格式要求：</H5>
    <H6>1.导入文件必须是txt文件;</H6>
    <H6>2.文件每一行字段顺序为：所属分支机构编号，商户编号，网络接入服务商编号，原因，字段间以逗号隔开，行末尾回车;</H4>
    <H6>3.文件记录之间不能存在空行</H6>
    <h6>例如，如下txt文件中， 第一行记录是所属分支机构代码为：103100，商户编号为001320115203755，网络接入服务商编号为00016010，原因为：交易金额过大</h6>
	<img src="<%=basePath%>/images/importExample.gif" alt="Angry" />

</body>
</html>

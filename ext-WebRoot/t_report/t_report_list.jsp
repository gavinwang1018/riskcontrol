<%@ page language="java" pageEncoding="GBK" contentType="charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<title>Untitled Document</title>
	<link href="css/reportSearch.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
		function checkit(thisobj){
			document.getElementById(thisobj).checked=true;
		}
	</script>
</head>
	<body>
	<div class="rs_topTitle"><img src="images/icon_sub_list.gif" width="41" height="41" align="absmiddle" />����ҵ���Ʒ����̻������������ͳ�Ʊ�</div>
		<div class="rs_condition">
		    <FIELDSET>
		    <LEGEND>����ҵ���Ʒ����̻������������ͳ�Ʊ�</LEGEND>
		        <form id="form1" name="form1" method="post" action="../ReportServlet">
		        <span></span>
		              <p></p>
		        <span></span>
		              <input type="radio" name="viewmode" id="v_pdf" value="pdf" />
		              <a href="javascript:void(0);" onclick="checkit('v_pdf')">PDF</a>
		              <input type="radio" name="viewmode" id="v_excel" value="excel" />
		              <a href="javascript:void(0);" onclick="checkit('v_excel')">EXCEL</a>
		              <input type="radio" name="viewmode" id="v_html" value="html" />
		              <a href="javascript:void(0);" onclick="checkit('v_html')">HTML</a> 
		              
		              <input type="submit" name="query" value="��ѯ">
		          </form>
		    </FIELDSET>
		</div>
	</body>
</html>
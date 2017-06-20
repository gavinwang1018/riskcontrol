<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="cn.com.brilliance.begen.common.bundle.ResourceBundle" %>
<div id="calcDiv" style="display:none;position:absolute;" onclick="event.cancelBubble=true;"> 
<FORM name="Keypad" action="">
<TABLE height=60 cellpadding="0" cellspacing="2" class="tableCal">
<TR>
	<TD colspan=3 align=middle><input id="ReadOut" name="ReadOut" type="Text" class="inputArea" value="0"></TD>
	<TD><input name="btnClear" type="Button" value="C" onclick="Clear()" class="red_font"></TD>
	<TD><input name="btnClearEntry" type="Button" value="CE" onclick="ClearEntry()" class="red_font"></TD>
</TR>
<TR>
	<TD><input name="btnSeven" type="Button" value="7" onclick="NumPressed(7)"></TD>
	<TD><input name="btnEight" type="Button" value="8" onclick="NumPressed(8)"></TD>
	<TD><input name="btnNine" type="Button" value="9" onclick="NumPressed(9)"></TD>
	<TD><input name="btnNeg" type="Button" value="+/-" onclick="Neg()" class="red_font"></TD>
	<TD><input name="btnPercent" type="Button" value="% " onclick="Percent()" class="red_font"></TD>
</TR>
<TR>
	<TD><input name="btnFour" type="Button" value="4" onclick="NumPressed(4)"></TD>
	<TD><input name="btnFive" type="Button" value="5" onclick="NumPressed(5)"></TD>
	<TD><input name="btnSix" type="Button" value="6" onclick="NumPressed(6)"></TD>
	<TD align=middle><input name="btnPlus" type="Button" value="+" onclick="Operation('+')" class="red_font"></TD>
	<TD align=middle><input name="btnMinus" type="Button" value=" - " onclick="Operation('-')" class="red_font"></TD>
</TR>
<TR>
	<TD><input name="btnOne" type="Button" value="1" onclick="NumPressed(1)"></TD>
	<TD><input name="btnTwo" type="Button" value="2" onclick="NumPressed(2)"></TD>
	<TD><input name="btnThree" type="Button" value="3" onclick="NumPressed(3)"></TD>
	<TD align=middle><input name="btnMultiply" type="Button" value="*" onclick="Operation('*')" class="red_font"></TD>
	<TD align=middle><input name="btnDivide" type="Button" value=" / " onclick="Operation('/')" class="red_font"></TD>
</TR>
<TR>
	<TD><input name="btnZero" type="Button" value="0" onclick="NumPressed(0)"></TD>
	<TD><input name="btnDecimal" type="Button" value=" ." onclick="Decimal()"></TD>
	<TD colspan=2>&nbsp;</TD>
	<TD><input name="btnEquals" type="Button" value="=" onclick="Operation('=')" class="red_font"></TD>
</TR>
<TR>
	<TD colspan=5><input name="Fillback" type="Button" value=" <%=ResourceBundle.getText(request,"calculator.fillback")%> " onclick="fback()" class="button"></TD>
</TR>
</TABLE>
</FORM>
</div> 
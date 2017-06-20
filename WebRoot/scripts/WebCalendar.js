//calendar
var selectd=null;
var oldText=""; 
String.prototype.toDate = function(x, p) {
  if(x == null) x = "-";
  if(p == null) p = "ymd";
  var a = this.split(x);
  var y = parseInt(a[p.indexOf("y")]);
  if(y.toString().length <= 2) y += 2000;
  if(isNaN(y)) y = new Date().getFullYear();
  var tempm=a[p.indexOf("m")].substr(0,1);
  var tempd=a[p.indexOf("d")].substr(0,1);
  var m =(tempm==0)?a[p.indexOf("m")].substr(1):a[p.indexOf("m")];
  m=m-1;
  var d = (tempd==0)?a[p.indexOf("d")].substr(1):a[p.indexOf("d")]
  if(isNaN(d)) d = 1;
  return new Date(y, m, d);
}

Date.prototype.format = function(style) {
  var o = {
    "M+" : this.getMonth() + 1, 
    "d+" : this.getDate(),      
    "h+" : this.getHours(),     
    "m+" : this.getMinutes(),   
    "s+" : this.getSeconds(),   
    "w+" : "天一二三四五六".charAt(this.getDay()),   
    "q+" : Math.floor((this.getMonth() + 3) / 3),  
    "S"  : this.getMilliseconds() 
  }
  if(/(y+)/.test(style)) {
    style = style.replace(RegExp.$1,
    (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  }
  for(var k in o){
    if(new RegExp("("+ k +")").test(style)){
      style = style.replace(RegExp.$1,
        RegExp.$1.length == 1 ? o[k] :
        ("00" + o[k]).substr(("" + o[k]).length));
    }
  }
  return style;
};

function Calendar(beginYear, endYear, lang, dateFormatStyle) {
  this.beginYear = 1960;
  this.endYear = 2030;
  this.lang = 0; 
  this.dateFormatStyle = "yyyy-MM-dd";

  if (beginYear != null && endYear != null){
    this.beginYear = beginYear;
    this.endYear = endYear;
  }
  if (lang != null){
    this.lang = lang
  }

  if (dateFormatStyle != null){
    this.dateFormatStyle = dateFormatStyle
  }

  this.dateControl = null;
  this.panel = document.getElementById("calendarPanel");
  this.form  = null;

  this.date = new Date();
  this.year = this.date.getFullYear();
  this.month = this.date.getMonth();

  this.colors = {
  "cur_word"      : "#FFFFFF",  
  "cur_bg"        : "#00FF00",  
  "se_bg"        : "#00FF00",  
  "sun_word"      : "#FF0000", 
  "sat_word"      : "#0000FF",  
  "td_word_light" : "#333333",  
  "td_word_dark"  : "#CCCCCC", 
  "td_bg_out"     : "#DDECFE",  
  "td_bg_over"    : "#FFCC00",  
  "tr_word"       : "#FFFFFF",  
  "tr_bg"         : "#ACC6E5",  
  "input_border"  : "#CCCCCC",  
  "input_bg"      : "#C7D8ED"    
  }
  this.draw();
  this.bindYear();
  this.bindMonth();
  this.bindData();
  this.changeSelect();
}

Calendar.language = {
  "year"   : [[""], [""]],
  "months" : [["JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"],
        ["JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"]
         ],
  "weeks"  : [["SUN","MON","TUR","WED","THU","FRI","SAT"],
        ["SUN","MON","TUR","WED","THU","FRI","SAT"]
         ]
}

Calendar.prototype.draw = function() {
  calendar = this;
  var mvAry = [];
  mvAry[mvAry.length]  = '  <form name="calendarForm" style="margin: 0px;">';
  mvAry[mvAry.length]  = '    <table width="100%" border="0" cellpadding="0" cellspacing="1">';
  mvAry[mvAry.length]  = '      <tr>';
  mvAry[mvAry.length]  = '        <th align="left" width="1%"><input style="border: 1px solid ' + calendar.colors["input_border"] + ';background-color:' + calendar.colors["input_bg"] + ';width:16px;height:20px;" name="prevMonth" type="button" id="prevMonth" value="&lt;" /></th>';
  mvAry[mvAry.length]  = '        <th align="center" width="98%" nowrap="nowrap"><select name="calendarYear" id="calendarYear" style="font-size:12px;"></select><select name="calendarMonth" id="calendarMonth" style="font-size:12px;"></select></th>';
  mvAry[mvAry.length]  = '        <th align="right" width="1%"><input style="border: 1px solid ' + calendar.colors["input_border"] + ';background-color:' + calendar.colors["input_bg"] + ';width:16px;height:20px;" name="nextMonth" type="button" id="nextMonth" value="&gt;" /></th>';
  mvAry[mvAry.length]  = '      </tr>';
  mvAry[mvAry.length]  = '    </table>';
  mvAry[mvAry.length]  = '    <table id="calendarTable" width="100%" style="border:0px solid #CCCCCC;background-color:#FFFFFF;font-size:12px;" border="0" cellpadding="3" cellspacing="1">';
  mvAry[mvAry.length]  = '      <tr>';
  for(var i = 0; i < 7; i++) {
    mvAry[mvAry.length]  = '      <th style="font-weight:normal;background-color:' + calendar.colors["tr_bg"] + ';color:' + calendar.colors["tr_word"] + ';">' + Calendar.language["weeks"][this.lang][i] + '</th>';
  }
  mvAry[mvAry.length]  = '      </tr>';
  for(var i = 0; i < 6;i++){
    mvAry[mvAry.length]  = '    <tr align="center">';
    for(var j = 0; j < 7; j++) {
      if (j == 0){
        mvAry[mvAry.length]  = '  <td style="cursor:default;color:' + calendar.colors["sun_word"] + ';"></td>';
      } else if(j == 6) {
        mvAry[mvAry.length]  = '  <td style="cursor:default;color:' + calendar.colors["sat_word"] + ';"></td>';
      } else {
        mvAry[mvAry.length]  = '  <td style="cursor:default;"></td>';
      }
    }
    mvAry[mvAry.length]  = '    </tr>';
  }

  mvAry[mvAry.length]  = '    </table>';
  mvAry[mvAry.length]  = '  </form>';
  this.panel.innerHTML = mvAry.join("");
  this.form = document.forms["calendarForm"];

  this.form.prevMonth.onclick = function () {event.cancelBubble=true;calendar.goPrevMonth(this);}
  this.form.nextMonth.onclick = function () {event.cancelBubble=true;calendar.goNextMonth(this);}
	//this.form.calendarYear.onclick=function(){event.cancelBubble;}
  this.form.calendarYear.onclick = function () {	event.cancelBubble=true;calendar.update(this);}
  this.form.calendarMonth.onclick = function () {event.cancelBubble=true;calendar.update(this);}

}

Calendar.prototype.bindYear = function() {
  var cy = this.form.calendarYear;
  cy.length = 0;
  for (var i = this.beginYear; i <= this.endYear; i++){
    cy.options[cy.length] = new Option(i + Calendar.language["year"][this.lang], i);
  }
}

Calendar.prototype.bindMonth = function() {
  var cm = this.form.calendarMonth;
  cm.length = 0;
  for (var i = 0; i < 12; i++){
    cm.options[cm.length] = new Option(Calendar.language["months"][this.lang][i], i);
  }
}

Calendar.prototype.goPrevMonth = function(e){

  if (this.year == this.beginYear && this.month == 0){return;}
  this.month--;
  if (this.month == -1) {
    this.year--;
    this.month = 11;

  }
  this.date = new Date(this.year, this.month, 1);
  this.changeSelect("pre");
  this.bindData();
}

Calendar.prototype.goNextMonth = function(e){
  if (this.year == this.endYear && this.month == 11){return;}
  this.month++;
  if (this.month == 12) {
    this.year++;
    this.month = 0;
  }
  this.date = new Date(this.year, this.month, 1);
  this.changeSelect("ne");
  this.bindData();
}

Calendar.prototype.changeSelect = function(prene) {
	if((selectd!=null)&&(selectd.value!="")&&(/^([0-9])+\-([0-9])+\-[0-9]?/).test(selectd.value))
	{
		if(prene==undefined)
		{ 
			var cy = this.form.calendarYear;
	  		var cm = this.form.calendarMonth;
			var selectvalue=selectd.value;
			var arr=new Array;
			arr=selectvalue.split("-");
			var temp=arr[1].substr(0,1);
  		var ar =(temp==0)?arr[1].substr(1):arr[1];	
  		
			for (var i= 0; i < cy.length; i++)
			{
		    if (cy.options[i].value ==arr[0]){
		      cy[i].selected = true;
		      break;
		    }
		  }
		  for (var i= 0; i < cm.length; i++){
		    if (cm.options[i].value == (ar-1)){

		      cm[i].selected = true;
		      break;
		    }
		  }

		}
		else if(prene=='sel')
		{
			var cy = this.form.calendarYear;
	  	var cm = this.form.calendarMonth;
		  for (var i= 0; i < cy.length; i++){
		    if (cy.options[i].value == this.date.getFullYear()){
		      cy[i].selected = true;
		      break;
		    }
		  }
		  for (var i= 0; i < cm.length; i++){
		    if (cm.options[i].value == this.date.getMonth()){
		      cm[i].selected = true;
		      break;
		    }
		  }
		}

		else
		{
			var cy = this.form.calendarYear;
	  	var cm = this.form.calendarMonth;
		  for (var i= 0; i < cy.length; i++){
		    if (cy.options[i].value == this.date.getFullYear()){
		      cy[i].selected = true;
		      break;
		    }
		  }
		  for (var i= 0; i < cm.length; i++){
		    if (cm.options[i].value == this.date.getMonth()){
		      cm[i].selected = true;
		      break;
		    }
		  }
		}
		
	}
 	else
 	{
 		var cy = this.form.calendarYear;
  	var cm = this.form.calendarMonth;
	  for (var i= 0; i < cy.length; i++){
	    if (cy.options[i].value == this.date.getFullYear()){
	      cy[i].selected = true;
	      break;
	    }
	  }
	  for (var i= 0; i < cm.length; i++){
	    if (cm.options[i].value == this.date.getMonth()){
	      cm[i].selected = true;
	      break;
	    }
	  }
	}
}

Calendar.prototype.update = function (e){
  this.year  = e.form.calendarYear.options[e.form.calendarYear.selectedIndex].value;
  this.month = e.form.calendarMonth.options[e.form.calendarMonth.selectedIndex].value;
  this.date = new Date(this.year, this.month, 1);
  this.changeSelect("sel");
  this.bindData();
}


Calendar.prototype.bindData = function () {
  var calendar = this;
  var dateArray = this.getMonthViewArray(this.date.getYear(), this.date.getMonth());
  var tds = this.getElementById("calendarTable").getElementsByTagName("td");
  for(var i = 0; i < tds.length; i++) {
  tds[i].style.backgroundColor = calendar.colors["td_bg_out"];
    tds[i].onclick = function () {event.cancelBubble=true;return;}
    tds[i].onmouseover = function () {return;}
    tds[i].onmouseout = function () {return;}
    if (i > dateArray.length - 1) break;
    tds[i].innerHTML = dateArray[i];
    if (dateArray[i] != "&nbsp;"){
    	if(tds[i].style.border!='')
    	{
    		tds[i].style.border=0;
    	}
      tds[i].onclick = function () {
      	event.cancelBubble=true;
        if (calendar.dateControl!= null){
          calendar.dateControl.value = new Date(calendar.date.getFullYear(),
                                                calendar.date.getMonth(),
                                                this.innerHTML).format(calendar.dateFormatStyle);
                                                if(calendar.dateControl.name.search("__")!=-1)
                                                {
                                                	selectDataTime(calendar.dateControl.name.split("__")[1])
                                                }
        }
       // selectd=calendar.dateControl;
        calendar.hide();
      }
      tds[i].onmouseover = function () {
				this.style.backgroundColor = calendar.colors["td_bg_over"];
        
      }
      tds[i].onmouseout = function () {
        this.style.backgroundColor = calendar.colors["td_bg_out"];
      }

      if (new Date().format(calendar.dateFormatStyle) ==
          new Date(calendar.date.getFullYear(),
                   calendar.date.getMonth(),
                   dateArray[i]).format(calendar.dateFormatStyle)) {
                   	
        tds[i].style.backgroundColor =calendar.colors["cur_bg"];
        tds[i].onmouseover = function () {
          this.style.backgroundColor = calendar.colors["td_bg_over"];
        }
        tds[i].onmouseout = function () {
          this.style.backgroundColor = calendar.colors["cur_bg"];
        }
      }

      if((this.dateControl!=null)&&(this.dateControl.value!=""))
			{
				 if (this.dateControl.value==
          new Date(calendar.date.getFullYear(),
                   calendar.date.getMonth(),
                   dateArray[i]).format(calendar.dateFormatStyle)) {
        tds[i].style.border ="2px solid #971010"
	        tds[i].onmouseover = function () {
	          this.style.backgroundColor = calendar.colors["td_bg_over"];
	        }
	        tds[i].onmouseout = function () {
	          this.style.backgroundColor = calendar.colors["td_bg_out"];
	        }
	      }	
			}
    }
  }
}

Calendar.prototype.getMonthViewArray = function (y, m) {
  var mvArray = [];
  var dayOfFirstDay = new Date(y, m, 1).getDay();
  var daysOfMonth = new Date(y, m + 1, 0).getDate();
  for (var i = 0; i < 42; i++) {
    mvArray[i] = "&nbsp;";
  }
  for (var i = 0; i < daysOfMonth; i++){
    mvArray[i + dayOfFirstDay] = i + 1;
  }
  return mvArray;
}

Calendar.prototype.getElementById = function(id){
  if (typeof(id) != "string" || id == "") return null;
  if (document.getElementById) return document.getElementById(id);
  if (document.all) return document.all(id);
  try {return eval(id);} catch(e){ return null;}
}

Calendar.prototype.getElementsByTagName = function(object, tagName){
  if (document.getElementsByTagName) return document.getElementsByTagName(tagName);
  if (document.all) return document.all.tags(tagName);
}

Calendar.prototype.getAbsPoint = function (e){
  var x = e.offsetLeft;
  var y = e.offsetTop;
  var panelWidth=173;
  var panelHeight=170;
  var eselfHeight=e.clientHeight;
  while(e = e.offsetParent){
    x += e.offsetLeft;
    y += e.offsetTop;
  }
  x=parseInt(x)
  if(parseInt(y)+parseInt(eselfHeight)+parseInt(panelHeight)>parseInt(document.body.clientHeight))
  {
  	y=parseInt(y)-parseInt(panelHeight)-parseInt(eselfHeight)-3;
  }
  else 
  {
  	y=parseInt(y)
  }
  return {"x": x, "y": y};
}

Calendar.prototype.show = function (dateControl, popControl) {
  if (dateControl.previousSibling == null){
    throw new Error("arguments[0] is necessary")
  }
  this.dateControl = dateControl.previousSibling;
  selectd=dateControl.previousSibling;
if ((this.dateControl.value.length > 0)&&(/^([0-9])+\-([0-9])+\-[0-9]?/).test(this.dateControl.value)){
		 	this.date = new Date(this.dateControl.value.toDate());
		  this.year = this.date.getFullYear();
		  this.month = this.date.getMonth();
		  this.bindData();
		  this.changeSelect();
  }
  else
  {
  		this.date = new Date();
		  this.year = this.date.getFullYear();
		  this.month = this.date.getMonth();
		  this.bindData();
		  this.changeSelect();
  }
  if (popControl == null){
    popControl = this.dateControl;
  }
  var xy = this.getAbsPoint(popControl);
  this.panel.style.left = xy.x + "px";
  this.panel.style.top = (xy.y + dateControl.offsetHeight) + "px";
  this.setDisplayStyle("select", "hidden",parseInt(this.panel.style.left),parseInt(this.panel.style.top),parseInt(this.panel.offsetWidth),parseInt(this.panel.offsetHeight));
  this.panel.style.visibility = "visible";
  if(document.getElementById("calcDiv")!=undefined)
  {
	document.getElementById("calcDiv").style.display = "none";
  }
}

Calendar.prototype.hide = function() {
  this.setDisplayStyle("select", "visible",parseInt(this.panel.style.left),parseInt(this.panel.style.top),parseInt(this.panel.offsetWidth),parseInt(this.panel.offsetHeight));
  this.panel.style.visibility = "hidden";
}

Calendar.prototype.setDisplayStyle = function(tagName, style,x,y,m,n) {
  var tags = this.getElementsByTagName(null, tagName)
  for(var i = 0; i < tags.length; i++) {
    if (tagName.toLowerCase() == "select" &&
       (tags[i].name == "calendarYear" ||
      tags[i].name == "calendarMonth")){
      continue;
    }
    var str=getIE(tags[i]).split(",");
   if(((parseInt(str[0])<=parseInt(x)&&parseInt(str[2])>=parseInt(x))||(parseInt(str[0])<=parseInt(x+m)&&parseInt(str[2])>=parseInt(x+m))||(parseInt(str[0])>=parseInt(x)&&parseInt(str[2])<=parseInt(x+m)))&&((parseInt(str[1])>=parseInt(y)&&parseInt(str[3])<=(y+n))||(parseInt(str[1])<=parseInt(y)&&parseInt(str[3])>=parseInt(y))||(parseInt(str[1])<=parseInt(y+n)&&parseInt(str[3])>=parseInt(y+n))))
    tags[i].style.visibility = style;
  }
}

function getIE(e){
var t=e.offsetTop;
var l=e.offsetLeft;
var lw=e.offsetWidth;
var th=e.offsetHeight;
var height=e.clientHeight;
while(e=e.offsetParent){
t+=e.offsetTop;
l+=e.offsetLeft;
}
lw=l+lw;
th=t+th;
return l+","+t+","+lw+","+th
}

document.body.appendChild(document.createElement('<div id="calendarPanel" style="position: absolute;visibility: hidden;z-index: 9999;background-color: #FFFFFF;border: 1px solid #CCCCCC;width:175px;font-size:12px;">'))
var calendar = new Calendar();



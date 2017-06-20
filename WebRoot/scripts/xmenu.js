//app menu
/*----------------------------------------------------------------------------\
|                                XMenu 1.12                                   |
|-----------------------------------------------------------------------------|
|                          Created by Erik Arvidsson                          |
|                  (http://webfx.eae.net/contact.html#erik)                   |
|                      For WebFX (http://webfx.eae.net/)                      |
|-----------------------------------------------------------------------------|
| An object based tree widget,  emulating the one found in microsoft windows, |
| with persistence using cookies. Works in IE 5+, Mozilla and konqueror 3.    |
|-----------------------------------------------------------------------------|
|             Copyright (c) 2001, 2002, 2003, 2006 Erik Arvidsson             |
|-----------------------------------------------------------------------------|
| Licensed under the Apache License, Version 2.0 (the "License"); you may not |
| use this file except in compliance with the License.  You may obtain a copy |
| of the License at http://www.apache.org/licenses/LICENSE-2.0                |
| - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - |
| Unless  required  by  applicable law or  agreed  to  in  writing,  software |
| distributed under the License is distributed on an  "AS IS" BASIS,  WITHOUT |
| WARRANTIES OR  CONDITIONS OF ANY KIND,  either express or implied.  See the |
| License  for the  specific language  governing permissions  and limitations |
| under the License.                                                          |
|-----------------------------------------------------------------------------|
| 2001-01-12 | Original Version Posted.                                       |
| 2001-11-20 | Added hover mode support and removed Opera focus hacks         |
| 2001-12-20 | (1.1) Added auto positioning and some properties to support    |
|            | this.                                                          |
| 2002-08-13 | (1.11) toString used ' for attributes. Changed to " to allow   |
|            | in properties/arguments.                                       |
| 2003-04-27 | (1.12) Added support for target property on menu item/button   |
| 2006-05-28 | Changed license to Apache Software License 2.0.                |
|-----------------------------------------------------------------------------|
| Created 2001-01-12 | All changes are in the log above. | Updated 2006-05-28 |
\----------------------------------------------------------------------------*/



// check browsers

var ua = navigator.userAgent;
var opera = /opera [56789]|opera\/[56789]/i.test(ua);
var ie = !opera && /MSIE/.test(ua);
var ie50 = ie && /MSIE 5\.[01234]/.test(ua);
var ie6 = ie && /MSIE [6789]/.test(ua);
var ieBox = ie && (document.compatMode == null || document.compatMode != "CSS1Compat");
var moz = !opera && /gecko/i.test(ua);
var nn6 = !opera && /netscape.*6\./i.test(ua);
// define the default values
webfxMenuDefaultWidth			= 120;

webfxMenuDefaultBorderLeft		= 1;
webfxMenuDefaultBorderRight		= 1;
webfxMenuDefaultBorderTop		= 1;
webfxMenuDefaultBorderBottom	= 1;
webfxMenuDefaultPaddingLeft		= 1;
webfxMenuDefaultPaddingRight	= 1;
webfxMenuDefaultPaddingTop		= 1;
webfxMenuDefaultPaddingBottom	= 1;

webfxMenuDefaultShadowLeft		= 0;
webfxMenuDefaultShadowRight		= ie && !ie50 && /win32/i.test(navigator.platform) ? 4 :0;
webfxMenuDefaultShadowTop		= 0;
webfxMenuDefaultShadowBottom	= ie && !ie50 && /win32/i.test(navigator.platform) ? 4 : 0;

webfxMenuItemDefaultHeight		= 18;
webfxMenuItemDefaultText		= "Untitled";
webfxMenuItemDefaultHref		= "javascript:void(0)";

webfxMenuSeparatorDefaultHeight	= 6;

webfxMenuDefaultEmptyText		= "Empty";

webfxMenuDefaultUseAutoPosition	= nn6 ? false : true;

// other global constants
webfxMenuImagePath				= "";

webfxMenuUseHover				= opera ? true : false;
webfxMenuHideTime				= 200;
webfxMenuShowTime				= 200;

var webFXMenuHandler = {
	idCounter		:	0,
	idPrefix		:	"webfx-menu-object-",
	all				:	{},
	getId			:	function () { return this.idPrefix + this.idCounter++; },
	overMenuItem	:	function (oItem,level) {
		if (this.showTimeout != null)
			window.clearTimeout(this.showTimeout);
		if (this.hideTimeout != null)
			window.clearTimeout(this.hideTimeout);
		var jsItem = this.all[oItem.id];
		if (webfxMenuShowTime <= 0)
			this._over(jsItem);
		else{
			//this.showTimeout = window.setTimeout(function () { webFXMenuHandler._over(jsItem) ; }, webfxMenuShowTime);
			// I hate IE5.0 because the piece of shit crashes when using setTimeout with a function object
			this.showTimeout = window.setTimeout("webFXMenuHandler._over(webFXMenuHandler.all['" + jsItem.id + "'])", webfxMenuShowTime);
		}
		if(level!=undefined && level =="one"){
			var tags=mainFrame.document.getElementsByTagName('select');
			for(var i=0;i<tags.length;i++){
				if (tags[i].name == "calendarYear" ||
	      		tags[i].name == "calendarMonth"){
	      			continue;
	    		}
	    		tags[i].style.visibility = "hidden";
			}
		}		
	},
	outMenuItem	:	function (oItem) {
		if (this.showTimeout != null)
			window.clearTimeout(this.showTimeout);
		if (this.hideTimeout != null)
			window.clearTimeout(this.hideTimeout);
		var jsItem = this.all[oItem.id];
		if (webfxMenuHideTime <= 0)
			this._out(jsItem);
		else
			//this.hideTimeout = window.setTimeout(function () { webFXMenuHandler._out(jsItem) ; }, webfxMenuHideTime);
			this.hideTimeout = window.setTimeout("webFXMenuHandler._out(webFXMenuHandler.all['" + jsItem.id + "'])", webfxMenuHideTime);
	},
	blurMenu		:	function (oMenuItem) {
		window.setTimeout("webFXMenuHandler.all[\"" + oMenuItem.id + "\"].subMenu.hide();", webfxMenuHideTime);
		if(oMenuItem.levelFlag!=undefined && oMenuItem.levelFlag =='one'){
		var tags=mainFrame.document.getElementsByTagName('select');
		for(var i=0;i<tags.length;i++){
			if (tags[i].name == "calendarYear" ||
	    		tags[i].name == "calendarMonth"){
	      			continue;
	    		}
	   		tags[i].style.visibility = "visible";
		}			
//			setTimeout("showHidSelect()",1000);		
		}		
	},
	_over	:	function (jsItem) {
		if (jsItem.subMenu) {
			jsItem.parentMenu.hideAllSubs();
			jsItem.subMenu.show();
		}
		else
			jsItem.parentMenu.hideAllSubs();
	},
	_out	:	function (jsItem) {
		// find top most menu
		var root = jsItem;
		var m;
		if (root instanceof WebFXMenuButton)
			m = root.subMenu;
		else {
			m = jsItem.parentMenu;
			while (m.parentMenu != null && !(m.parentMenu instanceof WebFXMenuBar))
				m = m.parentMenu;
		}
		if (m != null)
			m.hide();
	},
	hideMenu	:	function (menu) {
		if (this.showTimeout != null)
			window.clearTimeout(this.showTimeout);
		if (this.hideTimeout != null)
			window.clearTimeout(this.hideTimeout);

		this.hideTimeout = window.setTimeout("webFXMenuHandler.all['" + menu.id + "'].hide()", webfxMenuHideTime);
	},
	showMenu	:	function (menu, src, dir) {
		if (this.showTimeout != null)
			window.clearTimeout(this.showTimeout);
		if (this.hideTimeout != null)
			window.clearTimeout(this.hideTimeout);
		if (arguments.length < 3)
			dir = "vertical";

		menu.show(src, dir);
	}
};

function WebFXMenu() {//?¯menu
	this._menuItems	= [];
	this._subMenus	= [];
	this.id			= webFXMenuHandler.getId();
	this.top		= 0;
	this.left		= 0;
	this.shown		= false;
	this.parentMenu	= null;
	webFXMenuHandler.all[this.id] = this;
}

WebFXMenu.prototype.width			= webfxMenuDefaultWidth;
WebFXMenu.prototype.emptyText		= webfxMenuDefaultEmptyText;
WebFXMenu.prototype.useAutoPosition	= webfxMenuDefaultUseAutoPosition;

WebFXMenu.prototype.borderLeft		= webfxMenuDefaultBorderLeft;
WebFXMenu.prototype.borderRight		= webfxMenuDefaultBorderRight;
WebFXMenu.prototype.borderTop		= webfxMenuDefaultBorderTop;
WebFXMenu.prototype.borderBottom	= webfxMenuDefaultBorderBottom;

WebFXMenu.prototype.paddingLeft		= webfxMenuDefaultPaddingLeft;
WebFXMenu.prototype.paddingRight	= webfxMenuDefaultPaddingRight;
WebFXMenu.prototype.paddingTop		= webfxMenuDefaultPaddingTop;
WebFXMenu.prototype.paddingBottom	= webfxMenuDefaultPaddingBottom;

WebFXMenu.prototype.shadowLeft		= webfxMenuDefaultShadowLeft;
WebFXMenu.prototype.shadowRight		= webfxMenuDefaultShadowRight;
WebFXMenu.prototype.shadowTop		= webfxMenuDefaultShadowTop;
WebFXMenu.prototype.shadowBottom	= webfxMenuDefaultShadowBottom;

WebFXMenu.prototype.add = function (menuItem) {//足赤?車2?米ㄓ
	this._menuItems[this._menuItems.length] = menuItem;
	if (menuItem.subMenu) {
		this._subMenus[this._subMenus.length] = menuItem.subMenu;
		menuItem.subMenu.parentMenu = this;
	}

	menuItem.parentMenu = this;
};

WebFXMenu.prototype.show = function (relObj, sDir) {
	if (this.useAutoPosition)
		this.position(relObj, sDir);

	var divElement = document.getElementById(this.id);
	divElement.style.left = opera ? this.left : this.left + "px";
	divElement.style.top = opera ? (parseInt(this.top)-6) : (parseInt(this.top)-6) + "px";//bcf top
	divElement.style.visibility = "visible";
	this.shown = true;
	if (this.parentMenu){
		this.parentMenu.show();
	}
};

WebFXMenu.prototype.hide = function () {
	this.hideAllSubs();
	var divElement = document.getElementById(this.id);
	divElement.style.visibility = "hidden";
	this.shown = false;
};

WebFXMenu.prototype.hideAllSubs = function () {
	for (var i = 0; i < this._subMenus.length; i++) {
		if (this._subMenus[i].shown)
			this._subMenus[i].hide();
	}
};
WebFXMenu.prototype.toString = function () {
	var top = this.top + this.borderTop + this.paddingTop;
	var str = "<div id='" + this.id + "' class='webfx-menu' style='" +
	"width:" + (!ieBox  ?
		this.width - this.borderLeft - this.paddingLeft - this.borderRight - this.paddingRight  :
		this.width) + "px;" +
	(this.useAutoPosition ?
		"left:" + this.left + "px;" + "top:" + this.top + "px;" :
		"") +
	(ie50 ? "filter: none;" : "") +
	"'>";

	if (this._menuItems.length == 0) {
		str +=	"<span class='webfx-menu-empty'>" + this.emptyText + "</span>";
	}
	else {
		// loop through all menuItems
		for (var i = 0; i < this._menuItems.length; i++) {
			var mi = this._menuItems[i];
			str += mi;
			if (!this.useAutoPosition) {
				if (mi.subMenu && !mi.subMenu.useAutoPosition)
					mi.subMenu.top = top - mi.subMenu.borderTop - mi.subMenu.paddingTop;
				top += mi.height;
			}
		}

	}

	str += "</div>";

	for (var i = 0; i < this._subMenus.length; i++) {
		this._subMenus[i].left = this.left + this.width - this._subMenus[i].borderLeft;
		str += this._subMenus[i];
	}

	return str;
};
// WebFXMenu.prototype.position defined later
function WebFXMenuItem(sText, sHref, sToolTip, oSubMenu) {//足赤?車℅車2?米ㄓ
	//this.target="iframe1"
	this.toolTip = sText;//bcf change menu description to menu name 
	/*
	if(sText!=undefined)
	{
		if(sText.length>6)
		{
		sText=sText.substr(0,6)+"..."
		}
	}
	*/
	this.text = sText || webfxMenuItemDefaultText;
	this.href = (sHref == null || sHref == "") ? webfxMenuItemDefaultHref : sHref;
	this.subMenu = oSubMenu;
	if (oSubMenu)
		oSubMenu.parentMenuItem = this;
	//this.toolTip = sToolTip;
	this.id = webFXMenuHandler.getId();
	webFXMenuHandler.all[this.id] = this;
};
WebFXMenuItem.prototype.height = webfxMenuItemDefaultHeight;
WebFXMenuItem.prototype.toString = function () {
this.target ="mainFrame"
//this.imagePath = imagePath ;
//var basePath = basePath ;
this.imagePath=document.getElementById("imagePath").value
var basePath=document.getElementById("basePath").value
//if(this.href!="javascript:void(0)")var tempValue=" onclick=showSysInform()"
//else var tempValue="";
if(this.href!="javascript:void(0)")
{
	if(this.href.search("_Tree")!=-1)
	{
		this.target="treeIframe";
		var tempValue=" onclick=loadLeftInfo(0);showTree();"
	}
	else
	{
		var tempValue=" onclick=showSysInform()"
	}
}
else 
{
	var tempValue="";
}
	return	"<a" +tempValue+
			" id='" + this.id + "'" +
			" style='word-break:keep-all;' href=\"" + basePath+"/"+this.href + "\"" +
			(this.target ? " target=\"" + this.target + "\"" : "") +
			(this.toolTip ? " title=\"" + this.toolTip + "\"" : "") +
			" onmouseover='webFXMenuHandler.overMenuItem(this)'" +
			(webfxMenuUseHover ? " onmouseout='webFXMenuHandler.outMenuItem(this)'" : "") +
			(this.subMenu ? " unselectable='on' tabindex='-1'" : "") +
			">" +
			(this.subMenu ? "<img class='arrow' src=\"" +this.imagePath+"/"+ "arrow.right.png\">" : "") +
			this.text +
			"</a>";
};



function WebFXMenuSeparator() {
	this.id = webFXMenuHandler.getId();
	webFXMenuHandler.all[this.id] = this;
};
WebFXMenuSeparator.prototype.height = webfxMenuSeparatorDefaultHeight;
WebFXMenuSeparator.prototype.toString = function () {
	return	"<div" +
			" id='" + this.id + "'" +
			(webfxMenuUseHover ?
			" onmouseover='webFXMenuHandler.overMenuItem(this)'" +
			" onmouseout='webFXMenuHandler.outMenuItem(this)'"
			:
			"") +
			"></div>"
};

function WebFXMenuBar() {
	this._parentConstructor = WebFXMenu;
	this._parentConstructor();
}
WebFXMenuBar.prototype = new WebFXMenu;
WebFXMenuBar.prototype.toString = function () {
	var str = "<div id='" + this.id + "' class='webfx-menu-bar'>";

	// loop through all menuButtons
	for (var i = 0; i < this._menuItems.length; i++)
		str += this._menuItems[i];

	str += "</div>";

	for (var i = 0; i < this._subMenus.length; i++)
		str += this._subMenus[i];

	return str;
};

function WebFXMenuButton(sText, sHref, sToolTip, oSubMenu) {
	this._parentConstructor = WebFXMenuItem;
	this._parentConstructor(sText, sHref, sToolTip, oSubMenu);
	//this.target="iframe1"
}
WebFXMenuButton.prototype = new WebFXMenuItem;
WebFXMenuButton.prototype.toString = function () {
this.target="mainFrame"
//this.imagePath= imagePath ;
this.imagePath=document.getElementById("imagePath").value;
//if(this.href!="javascript:void(0)")var tempValue=" onclick=showSysInform()"
//else var tempValue="";
if(this.href!="javascript:void(0)")
{
	if(this.href.search("_Tree")!=-1)
	{
		this.target="treeIframe";
		var tempValue=" onclick=loadLeftInfo(0);showTree();"
	}
	else
	{
		var tempValue=" onclick=showSysInform()"
	}
}
else 
{
	var tempValue="";
}
var levelparam = "";
if(this.subMenu){
	levelparam = "one" ;
}	
	return	"<a" +tempValue+
			" id='" + this.id + "'" +
			" levelFlag='one' href=\"" + this.href + "\"" +
			(this.target ? " target=\"" + this.target + "\"" : "") +
			(this.toolTip ? " title=\"" + this.toolTip + "\"" : "") +
			(webfxMenuUseHover ?
				(" onmouseover='webFXMenuHandler.overMenuItem(this)'" +
				" onmouseout='webFXMenuHandler.outMenuItem(this)'") :
				(
					" onfocus='webFXMenuHandler.overMenuItem(this,\""+levelparam+"\")'" +
					(this.subMenu ?
						" onblur='webFXMenuHandler.blurMenu(this)'" :
						""
					)
				)) +
			">" +
			this.text +
			(this.subMenu ? " <img class='arrow' src=\"" + this.imagePath+"/" + "arrow.down.png\" align='absmiddle'>" : "") +
			"</a>";
};


/* Position functions */

function getInnerLeft(el) {
	if (el == null) return 0;
	if (ieBox && el == document.body || !ieBox && el == document.documentElement) return 0;
	return getLeft(el) + getBorderLeft(el);
}

function getLeft(el) {
	if (el == null) return 0;
	return el.offsetLeft + getInnerLeft(el.offsetParent);
}

function getInnerTop(el) {
	if (el == null) return 0;
	if (ieBox && el == document.body || !ieBox && el == document.documentElement) return 0;
	return getTop(el) + getBorderTop(el);
}

function getTop(el) {
	if (el == null) return 0;
	return el.offsetTop + getInnerTop(el.offsetParent);
}

function getBorderLeft(el) {
	return ie ?
		el.clientLeft :
		parseInt(window.getComputedStyle(el, null).getPropertyValue("border-left-width"));
}

function getBorderTop(el) {
	return ie ?
		el.clientTop :
		parseInt(window.getComputedStyle(el, null).getPropertyValue("border-top-width"));
}

function opera_getLeft(el) {
	if (el == null) return 0;
	return el.offsetLeft + opera_getLeft(el.offsetParent);
}

function opera_getTop(el) {
	if (el == null) return 0;
	return el.offsetTop + opera_getTop(el.offsetParent);
}

function getOuterRect(el) {
	return {
		left:	(opera ? opera_getLeft(el) : getLeft(el)),
		top:	(opera ? (opera_getTop(el)+3) : (getTop(el)+3)),//bcf top
		width:	el.offsetWidth,
		height:	el.offsetHeight
	};
}

// mozilla bug! scrollbars not included in innerWidth/height
function getDocumentRect(el) {
	return {
		left:	0,
		top:	0,
		width:	(ie ?
					(ieBox ? document.body.clientWidth : document.documentElement.clientWidth) :
					window.innerWidth
				),
		height:	(ie ?
					(ieBox ? document.body.clientHeight : document.documentElement.clientHeight) :
					window.innerHeight
				)
	};
}

function getScrollPos(el) {
	return {
		left:	(ie ?
					(ieBox ? document.body.scrollLeft : document.documentElement.scrollLeft) :
					window.pageXOffset
				),
		top:	(ie ?
					(ieBox ? document.body.scrollTop : document.documentElement.scrollTop) :
					window.pageYOffset
				)
	};
}

/* end position functions */

WebFXMenu.prototype.position = function (relEl, sDir) {
	var dir = sDir;
	// find parent item rectangle, piRect
	var piRect;
	if (!relEl) {
		var pi = this.parentMenuItem;
		if (!this.parentMenuItem)
			return;

		relEl = document.getElementById(pi.id);
		if (dir == null)
			dir = pi instanceof WebFXMenuButton ? "vertical" : "horizontal";

		piRect = getOuterRect(relEl);
	}
	else if (relEl.left != null && relEl.top != null && relEl.width != null && relEl.height != null) {	// got a rect
		piRect = relEl;
	}
	else
		piRect = getOuterRect(relEl);

	var menuEl = document.getElementById(this.id);
	var menuRect = getOuterRect(menuEl);
	var docRect = getDocumentRect();
	var scrollPos = getScrollPos();
	var pMenu = this.parentMenu;

	if (dir == "vertical") {
		if (piRect.left + menuRect.width - scrollPos.left <= docRect.width)
			this.left = piRect.left;
		else if (docRect.width >= menuRect.width)
			this.left = docRect.width + scrollPos.left - menuRect.width;
		else
			this.left = scrollPos.left;

		if (piRect.top + piRect.height + menuRect.height <= docRect.height + scrollPos.top)
			this.top = piRect.top + piRect.height;
		else if (piRect.top - menuRect.height >= scrollPos.top)
			this.top = piRect.top - menuRect.height;
		else if (docRect.height >= menuRect.height)
			this.top = docRect.height + scrollPos.top - menuRect.height;
		else
			this.top = scrollPos.top;
	}
	else {
		if (piRect.top + menuRect.height - this.borderTop - this.paddingTop <= docRect.height + scrollPos.top)
			this.top = piRect.top - this.borderTop - this.paddingTop;
		else if (piRect.top + piRect.height - menuRect.height + this.borderTop + this.paddingTop >= 0)
			this.top = piRect.top + piRect.height - menuRect.height + this.borderBottom + this.paddingBottom + this.shadowBottom;
		else if (docRect.height >= menuRect.height)
			this.top = docRect.height + scrollPos.top - menuRect.height;
		else
			this.top = scrollPos.top;

		var pMenuPaddingLeft = pMenu ? pMenu.paddingLeft : 0;
		var pMenuBorderLeft = pMenu ? pMenu.borderLeft : 0;
		var pMenuPaddingRight = pMenu ? pMenu.paddingRight : 0;
		var pMenuBorderRight = pMenu ? pMenu.borderRight : 0;

		if (piRect.left + piRect.width + menuRect.width + pMenuPaddingRight +
			pMenuBorderRight - this.borderLeft + this.shadowRight <= docRect.width + scrollPos.left)
			this.left = piRect.left + piRect.width + pMenuPaddingRight + pMenuBorderRight - this.borderLeft;
		else if (piRect.left - menuRect.width - pMenuPaddingLeft - pMenuBorderLeft + this.borderRight + this.shadowRight >= 0)
			this.left = piRect.left - menuRect.width - pMenuPaddingLeft - pMenuBorderLeft + this.borderRight + this.shadowRight;
		else if (docRect.width >= menuRect.width)
			this.left = docRect.width  + scrollPos.left - menuRect.width;
		else
			this.left = scrollPos.left;
	}
};

//bcf add App deal
function configLoadApp()//app
{
	application_0();
	var appul=document.getElementById("appul");
	var appArr=application;
	for(var i=0;i<appArr.length;i++)
	{
		var liElement=document.createElement("LI")
		var aElement=document.createElement("A")
		var imgElement=document.createElement("IMG")
		var imgnum=appArr[i][3];
		if(imgnum==""||imgnum==undefined)
		{
			imgnum=2
		}
		else
		{
			imgnum=parseInt(imgnum)
		}
		imgElement.src="images/menuicon"+imgnum+".gif"
		aElement.appendChild(imgElement);
		aElement.href="#"
		aElement.hidefocus="true";
		aElement.innerHTML=aElement.innerHTML+appArr[i][0]
		liElement.appendChild(aElement);
		liElement.onclick=new Function("selectApp(this,"+i+")")
		if(appArr[i][1]==1)
		{
			lastApp=liElement;
			liElement.className="Selected"
		}
		
		appul.appendChild(liElement);
	}
	
	var liElement=document.createElement("LI")
	var aElement=document.createElement("A")
	aElement.href="#"
	aElement.innerText=">"
	liElement.appendChild(aElement);
	liElement.onclick=showAppAfter
	liElement.style.display="none"
	appul.appendChild(liElement);
	document.getElementById("mainFrame").src=application[0][2]
	checkAppW()
}

var lastApp;
function selectApp(obj,objnum)//change app
{
	eval("application_"+objnum+"()")
	if(obj!=lastApp)
	{
		obj.className="Selected"
		lastApp.className="";
		lastApp=obj;
	}
	
	document.getElementById("mainFrame").src=application[objnum][2]
	loadMenu()
}


function loadMenu()//menu
{
	document.getElementById("top_menu").innerHTML='';
	document.getElementById("top_menu").innerHTML=myBar;
	var objs=document.getElementById("top_menu").getElementsByTagName("A")
	var lastObj;
	for(var i=0;i<objs.length;i++)
	{
		if(objs[i].onfocus==null)
		{
			var tempWidth=objs[i].parentNode.offsetWidth
			var tempObj=objs[i].parentNode
			if(lastObj!=tempObj)
			{		
				tempObj.style.width=parseInt(tempObj.offsetWidth)+10;
				lastObj=tempObj
			}
		}
	}
}
var lastAppLiSeq=null;
var firstAppLiSeq=null;
function checkAppW()
{
	var appul=document.getElementById("appul");
	var allLis=appul.getElementsByTagName("LI")
	for(var l=allLis.length-2;l>1;l--)
	{
		if(parseInt(appul.clientWidth)<716&&parseInt(appul.clientHeight)<40)
		{
			lastAppLiSeq=l+1;
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
//forward move
function showAppBefore()
{
		var appul=document.getElementById("appul");
		var allLis=appul.getElementsByTagName("LI")
		allLis[allLis.length-1].style.display="";

		if(firstAppLiSeq!=null&&allLis[firstAppLiSeq]!=undefined)
		{	
			if(firstAppLiSeq==1)
			{
					allLis[0].style.display="none"
			}
				allLis[firstAppLiSeq].style.display=""
				for(var l=allLis.length-2;l>1;l--)
				{
					if(parseInt(appul.clientWidth)<716&&parseInt(appul.clientHeight)<40)
					{	
						firstAppLiSeq=firstAppLiSeq-1;
						break;
					}
					else
					{
							lastAppLiSeq=l;
							allLis[l].style.display="none"	
					}
				}		
		}
}
//o車辰?
function showAppAfter()
{
		var appul=document.getElementById("appul");
		var allLis=appul.getElementsByTagName("LI")
		allLis[0].style.display="";
		
		if(lastAppLiSeq!=null&&allLis[lastAppLiSeq]!=undefined)
		{	
			if(allLis.length-2==lastAppLiSeq)
			{
					allLis[allLis.length-1].style.display="none"
			}
			
			allLis[lastAppLiSeq].style.display=""
			
			for(var l=1;l<allLis.length-2;l++)
			{
				if(parseInt(appul.clientWidth)<716&&parseInt(appul.clientHeight)<40)
				{
					lastAppLiSeq=lastAppLiSeq+1;
					break;
				}
				else
				{
					firstAppLiSeq=l;
					allLis[l].style.display="none"	
				}
			}		
		}
}
//hid left menu
function hidleft()
{
	if(document.getElementById("main_left").style.display=='none')
	{
		document.getElementById("main_left").style.display='';
		document.getElementById("showLeftMenu").innerText=document.getElementById("hidlefttext").value;
		document.getElementById("showLeftMenuimg").src="images/change_btn1.gif";
	}
	else
	{
		document.getElementById("main_left").style.display='none';	
		document.getElementById("main_right").style.margin='0px';
		document.getElementById("showLeftMenu").innerText=document.getElementById("showlefttext").value;
		document.getElementById("showLeftMenuimg").src="images/change_btn.gif";
	}
}

//get workflow nums
function get_process_url()
{
	try{
	var url = "PermissionWorkflowServlet?__type=count";
		    if (window.XMLHttpRequest)
	        {
	                req_process = new XMLHttpRequest();
	        }else if (window.ActiveXObject)
	        {
	                req_process = new ActiveXObject("Microsoft.XMLHTTP");
	        }
	        if(req_process)
	        {
	                req_process.open("GET",url, true);
	                req_process.onreadystatechange = new Function("getprocess_complete()");
	                req_process.send(null);
	        }
	       }catch(e){}
}
function getprocess_complete()
{
        if (req_process.readyState == 4)
        {
                if (req_process.status == 200)
                {
                       var process_count = req_process.responseText;
                       processIframe.document.getElementById("process_count").innerHTML="["+process_count+"]";
                }
        }else{
        processIframe.document.getElementById("process_count").innerHTML="[0]";
       }

}


//get message nums
function get_message_result()
{
	var msg_type=new Array()
	msg_type[0]="count_in";
	msg_type[1]="count_out";
	
	for(var u=0;u<2;u++){
		get_message_url(msg_type[u]);
	}
}


function get_message_url(msg_url)
{
try{
        var url = "MessageServlet?__type="+msg_url;
 
 		if (msg_url=="count_in"){
	        //alert(url);
	        if (window.XMLHttpRequest)
	        {
	                req = new XMLHttpRequest();
	        }else if (window.ActiveXObject)
	        {
	                req = new ActiveXObject("Microsoft.XMLHTTP");
	        }
	        if(req)
	        {
	                req.open("GET",url, true);
	                req.onreadystatechange = new Function("getinbox_complete('"+msg_url+"')");
	                req.send(null);
	        }
        }else{
        		        if (window.XMLHttpRequest)
	        {
	                req2 = new XMLHttpRequest();
	        }else if (window.ActiveXObject)
	        {
	                req2 = new ActiveXObject("Microsoft.XMLHTTP");
	        }
	        if(req2)
	        {
	                req2.open("GET",url, true);
	                req2.onreadystatechange = new Function("getinbox_complete('"+msg_url+"')");
	                req2.send(null);
	        }
        
        }
     }catch(e){}   
}
function getinbox_complete(get_url)
{
	if (get_url=="count_in"){
        if (req.readyState == 4)
        {
                if (req.status == 200)
                {
                       var message_inbox_count = req.responseText;
                       messageIframe.document.getElementById(get_url).innerHTML="["+message_inbox_count+"]";
                }
        }else{
        messageIframe.document.getElementById(get_url).innerHTML="[0]";
        }
	}else{
		if (req2.readyState == 4)
        {
                if (req2.status == 200)
                {
                       var message_inbox_count = req2.responseText;
                       messageIframe.document.getElementById(get_url).innerHTML="["+message_inbox_count+"]";
                }
        }else{
        messageIframe.document.getElementById(get_url).innerHTML="[0]";
        }
	
	}        
}

//get transmit nums
function get_transmit_url()
{
	try{
	var url = "TransmitServlet?__type=count";
		    if (window.XMLHttpRequest)
	        {
	                req_transmit = new XMLHttpRequest();
	        }else if (window.ActiveXObject)
	        {
	                req_transmit = new ActiveXObject("Microsoft.XMLHTTP");
	        }
	        if(req_transmit)
	        {
	                req_transmit.open("GET",url, true);
	                req_transmit.onreadystatechange = new Function("gettransmit_complete()");
	                req_transmit.send(null);
	        }
	       }catch(e){}
}
function gettransmit_complete()
{
        if (req_transmit.readyState == 4)
        {
                if (req_transmit.status == 200)
                {
                       var transmit_count = req_transmit.responseText;
                       transmitIframe.document.getElementById("transmit_count").innerHTML="["+transmit_count+"]";
                }
        }else{
        transmitIframe.document.getElementById("transmit_count").innerHTML="[0]";
        }

}

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

var reArr=new Array();//all history

function backHis()
{
		var reArrLength=reArr.length-2
		if(reArrLength>-1)
		{
			for(var i=(reArrLength+1);i<reArr.length;i++)
			{
				reArr.remove(i)
			}
			var thisHisSpan=document.getElementById("tasklist");
			mainFrame.location.href=document.getElementById("basePath").value+"/"+reArr[reArrLength]['url']
		}
}
function goLast()
{
	var reArrLength=0
	if(reArr.length>1)
	{
		for(var i=(reArr.length-1);i>0;i--)
		{
			reArr.remove(i)
		}
		var thisHisSpan=document.getElementById("tasklist");
		mainFrame.location.href=document.getElementById("basePath").value+"/"+reArr[reArrLength]['url']
	}
}
function overLeftShow(obj)
{
	if(reArr.length>1)
	{
		obj.src="images/btn_arrow_left_02.jpg"
	}
}
function overLeftHid(obj)
{
	obj.src="images/btn_arrow_left_01.jpg"
}
function overUpShow(obj)
{
	if(reArr.length>1)
	{
		obj.src="images/btn_arrow_up_02.jpg"
	}
}
function overUpHid(obj)
{
	obj.src="images/btn_arrow_up_01.jpg"
}
//load left iframe
function loadLeftInfo(contentvalue)
{	
	var contents = document.getElementsByClassName('content');
	var toggles = document.getElementsByClassName('title');
	var myAccordion = new fx.Accordion(
		toggles, contents, {opacity: true, duration: 400}
	);
	var cvalue=contents.length-1
	if(contentvalue!=undefined)
	{
		cvalue=contentvalue
	}
	myAccordion.showThisHideOpen(contents[cvalue]);
}
//show tree,close other iframe
function closeTree()
{
	var allH1=document.getElementsByTagName("H1");
	allH1[0].style.display="none";
	for(var i=1;i<allH1.length;i++)
	{
		allH1[i].style.display="";	
	}
	document.getElementById("treeIframe").style.display="none"
	document.getElementById("processIframe").style.display=""
	document.getElementById("massageIframe").style.display=""
	document.getElementById("transmitIframe").style.display=""
	document.getElementById("leftIframe").style.display=""
	document.getElementById("historyIframe").style.display=""
	loadLeftInfo()
}
function showTree()
{
	var allH1=document.getElementsByTagName("H1");
	allH1[0].style.display="";
	for(var i=1;i<allH1.length;i++)
	{
		allH1[i].style.display="none";
	}
	document.getElementById("treeIframe").style.display=""
	document.getElementById("processIframe").style.display="none"
	document.getElementById("massageIframe").style.display="none"
	document.getElementById("transmitIframe").style.display="none"
	document.getElementById("leftIframe").style.display="none"
	document.getElementById("historyIframe").style.display="none"
	document.getElementById("treeIframe").style.height="470px"
	if(parseInt(screen.height)>1000)
	{
		document.getElementById("treeIframe").style.height="740px";
	}
}

function overTree(obj)
{
	obj.src="images/button_left_close_over.gif"
}

function outTree(obj)
{
	obj.src="images/button_left_close.gif"
}
/*
function showHidSelect(){
	var tags=mainFrame.document.getElementsByTagName('select');
	for(var i=0;i<tags.length;i++){
		if (tags[i].name == "calendarYear" ||
	    	tags[i].name == "calendarMonth"){
	      		continue;
	    	}
	   	tags[i].style.visibility = "visible";
	}		
}
*/
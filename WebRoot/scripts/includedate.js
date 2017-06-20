//判断是否包含日历控件js,调整页面大小的js
var js_style={
	'body':function(obj)
	{	
		var arrs=getElementsByClassName(document,"datebutton");
			if(arrs.length>0)
			{
				var js=document.createElement("script");
				js.setAttribute("defer","defer");
				js.src="../scripts/WebCalendar.js";
				obj.appendChild(js);
				obj.onclick=function()
				{
					new Calendar().hide();
					if(document.getElementById("calcDiv")!=undefined)
					{
						document.getElementById("calcDiv").style.display = "none";
					}
				}
			}
			else if(document.getElementById("calcDiv")!=undefined)
			{
				obj.onclick=function()
				{
					document.getElementById("calcDiv").style.display = "none";
				}
			}
	}
}
Behaviour.register(js_style);
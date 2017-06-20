var remname={
	'#button1':function(obj)//记住用户名
	{	
		obj.onclick=function(){
			if(document.getElementById("checkbox1").checked==true)
			{
				var Then = new Date() 
				Then.setTime(Then.getTime() + 1000*604800)
				var setuserName =document.getElementById("user_id").value;
				document.cookie = "begenuser="+setuserName+";expires=" + Then.toGMTString();
			}
			form1.submit();
		}
	},
	'#form1':function()//记住用户名
	{
		if (document.cookie!= "") 
		{ 
			var cookieString = new String(document.cookie)
			var cookieHeader = "begenuser="
			var beginPosition = cookieString.indexOf(cookieHeader)
			if (beginPosition != -1)
			{
				var userCookie=cookieString.substring(beginPosition + cookieHeader.length);
				var userNameA=userCookie.split(";");
				document.getElementById("user_id").value=userNameA[0];
				document.getElementById("checkbox1").checked=true;
			}
		}
		else
		{
			document.getElementById("user_id").value="";
		}
	},
	'body':function(downobj)
	{
		downobj.onkeydown=function()
		{
			if(event.keyCode == "13"&&document.getElementById("button1")!=null&&document.getElementById("password")!=null){
				document.all.button1.click();
			}
		}
	}
}
Behaviour.register(remname);

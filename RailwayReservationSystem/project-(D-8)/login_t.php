<html>
<title>Welcome here ! </title>
<head>
<style type="text/css">
body {background-image:url('b1.jpeg');}
p.one
{
font-size :40pt;
1border-style:outset;
text-align: center;
font-family:"Monotype Corsiva";
}
</style>
</head>
<body>
<p class="one"><br/>Railway Reservation System<br/></p>
<br/>
<div align="center"><font size=4pt face="Comic Sans MS">
<form action="login.php" method="POST">
Username :  <input type="text" name="name"/><br/>
Password :   <input type="password" name="pass"/><br/>
<?php session_start(); 
header("Cache-Control: no-cache");?>
<table><tr><td align="center">Enter the 3 Black Symbols displayed in the CAPTCHA below:<br>
	(antispam code, 3 black symbols)<br>
	<table><tr><td><img src="captcha.php" alt="captcha image"></td><td><input type="text" name="captcha" size="3" maxlength="3"></td></tr></table>
</td></tr></table>
<input type="submit" name="submit"/>
<br/><br/>
New User ! Register Here<br/>
<a href="registration/reg-form.html"><img src="reg5.jpeg"></a>
</font></div>
</body>
</html>

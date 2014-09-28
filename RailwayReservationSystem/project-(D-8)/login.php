<html>
<title>Registration</title>
<body>
<?php session_start();
$a=NULL;
$_SESSION["classt"]=$a;
$_SESSION["pnrno"]=$a;
$_SESSION["date"]=$a;
$_SESSION["tnum"]=$a;
$_SESSION["seats"]=$a;
$_SESSION["name"]=$_POST["name"];
$f2=0;
if(isset($_POST["captcha"]))
if($_SESSION["captcha"]==$_POST["captcha"])
{
$f2=0;
}
else
{
$f2=1;
echo "<fieldset><legend align=center><h1>Captcha not valid</h1></legend<br/>
		<div align=center><a href=login1.php>click here to go back.</a></div>";
}
if($_POST["name"]=="admin" && $_POST["pass"]=="admin" && $f2==0)
{
echo "<br/><br/><fieldset><legend align=center><h1>Welcome Administrator</h1></legend><br/>
		<div align=center><a href=admin1.html>Click to Continue..</a></div>";
}
else
{
if($f2==0)
{
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$uid=$_POST["name"];
$pass=$_POST["pass"];
$f=0;
$res=mysql_query("SELECT userid FROM customerdetails");
while($row=mysql_fetch_array($res))
{
if($uid=="$row[userid]")
{
$f=1;
}
}
if($f==1)
{
$sql =mysql_query("SELECT password FROM customerdetails WHERE userid='$_POST[name]'");
while($row2=mysql_fetch_array($sql))
{
if("$row2[password]"==$pass)
echo "<fieldset><legend align=center><h2>Username and password match.</h2><h1>Successful login.</h1></legend><br/>
		<div align=center><a href=1afterlogin.php>Click here to proceed.</a></div>";
else 
echo "<fieldset><legend align=center><h2>Username and password do not match</h2><h1> Incorrect password.</h1></legend> <br/>
		<div align=center><a href=login.html>click here to go back.</a></div>";
}
}
else if($f==0)
echo "<fieldset><legend align=center><h2>Username you have entered do not exists.
Either Register as a new user or login as a different userid.</h2></legend><br/>
		<div align=center><a href=login.html>Click to go back !</a></div>";
}
}
?>
</body>
</html>


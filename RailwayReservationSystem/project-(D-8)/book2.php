<html>
<title>Booking Cont..(Step 3)</title>
<head>
<style type="text/css">
.one
{
font-size :30pt;
border-style:outset;
text-align: center;
}
</style>
</head>
<body background="b2.jpeg">
<?php session_start(); echo "<div align=center>Welcome ".$_SESSION["name"]." </div>"; ?>
<div align="right"><a href="logout1.php">Logout..</a></div>
<div align="center">
<p class="one"><b><font size="45" face="Monotype Corsiva">Railway Reservation System</font></b></p><br/>
<hr/><hr/></div>
<?php
$_SESSION["tname"]=$_POST["trainname"];
$cap=$_SESSION["captcha"];
$_SESSION["classt"]=$_POST["class"];
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$trainno=$_POST["trainno"];
$_SESSION["date"]=$_POST["date"];
$_SESSION["tnum"]=$_POST["trainno"];

$f=0;
if(empty($_SESSION["tnum"]) || empty($_SESSION["date"]) || empty($_SESSION["tname"]) || empty($_SESSION["classt"]) )
{
echo "<br/><br/><fieldset> <legend><h4>Error in Filling Form</h4></legend><h2 align=center>Fields can not be left blank.</h2><h3 align=center>Choose the appropriate Train No. and Train Name from the list shown !</h3>
		<div align=center><a href=1afterlogin.php>Go Back</a><div></fieldset>";
$f=1;
}

if($f==0)
{
$seat=$_POST["class"];
$result=mysql_query("select $seat from seatavail where trainno=$_POST[trainno] and date='$_POST[date]'");
$k=mysql_num_rows($result);
$g=$k;
if(!($g))
{
echo "<br/><br/><br/><fieldset><legend>Error !</legend><div align=center>Incorrect details entered.<br/>
		<a href=1afterlogin.php>Go Back</a></div></fieldset>";
}
else
{
echo "<h3>The Train you have selected is  ".$_POST["trainname"]."</h3>
<br/>
<div align=center>
<big><i>Number of Available Seats are <em>";
$_SESSION["tname"]=$_POST["trainname"];
$cap=$_SESSION["captcha"];
$_SESSION["classt"]=$_POST["class"];
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$trainno=$_POST["trainno"];
$_SESSION["date"]=$_POST["date"];
$_SESSION["tnum"]=$_POST["trainno"];
$cls=$_POST["class"];
$ins=mysql_query("INSERT into ticket1 (trainno,class,captcha) VALUES ($trainno,'$cls','$cap')");


while($row=mysql_fetch_array($result))
{
echo "<font size=6pt>".$row[$seat]."</font>";
}
$res2=mysql_query("select pnrno from ticket1 where captcha='$cap'");
while($row2=mysql_fetch_array($res2))
{
$c2=$row2["pnrno"];
}
$_SESSION["pnrno"]=$c2;
mysql_close($con); 

echo "</em></i></big>
<br/>

Enter How many seats you want to Book (Maximum 6 Passenegers can be booked on a particular ticket) <br/>
<form action=book3.php method=POST>
<input type=text name=seats /><br/>
<input type=submit value=Proceed.. />
</form>
</div>";
}
}
?>
</body>
</html>

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
<div align="center">
<p class="one"><b><font size="45" face="Monotype Corsiva">Railway Reservation System</font></b></p><br/>
<hr/><hr/></div>
<?php
$f2=0;
if(empty($_POST["cnum"]) || empty($_POST["bname"]))
{
echo "<br/><br/><fieldset><legend><h4>Error ! </h4></legend><div align=center> Invalid Card Name or Card Number..<br/>
		<a href=1afterlogin.php>Go Back</a></div></fieldset>";
		$f2=1;
}
if($f2==0)
{
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$cardnum=$_POST["cnum"];
$bname=$_POST["bname"];
$qwe=mysql_query("INSERT into bank values ($cardnum,'$bname')");
$num=$_SESSION["seats"];
$date=$_SESSION["date"];
$trainnum=$_SESSION["tnum"];
$class=$_SESSION["classt"];
$user=$_SESSION["name"];
$amt=$_SESSION["amount"];
$pnr=$_SESSION["pnrno"];
$query2=mysql_query("UPDATE seatavail SET $class=($class-$num) where date='$date' and trainno=$trainnum");
$query3=mysql_query("INSERT into bookhistory values ($pnr,'$date',$amt,$cardnum,'$user')");

echo "<br/>
<div align=center>
<fieldset><legend align=center><h2>Ticket Booked</h2></legend><br/>
<div align=center>
<h3>Successful Transaction</h3>
<h2><a href=logout2.php>Logout..</a></h2>";
}
?>
</body>
</html>
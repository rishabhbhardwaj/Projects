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
<br/>
<?php
$_SESSION["seats"]=$_POST["seats"];
$f2=0;
if(empty($_SESSION["seats"]) || $_SESSION["seats"]<=0)
{
echo "<br/><br/><fieldset><legend><h4>Error ! </h4></legend><div align=center> Invalid Number of Seats..<br/>
		<a href=1afterlogin.php>Go Back</a></div></fieldset>";
		$f2=1;
}
if($f2==0)
{
echo "<h3 align=center>You have selected ". $_POST["seats"]." seats to book for your ticket.</h3>
<br/>";


$a=$_POST["seats"];

$f=0;
if($a>6)
{
echo "<div align=center><h3>More than Six passengers can not be booked on a single ticket...</h3>
		<br/><a href=1afterlogin.php>Click to go back and refill the form</a></div>";
$f=1;
}
if($f==0)
{
echo "<form method=POST action=book5.php>";
echo "<h4>Fill in the passengers details......</h4><br/>";
echo "Passenger 1 -> Name: <input type=text name=pname1 /> Gender: <select name=pgen1>
<option value=>Choose gender..</option>
<option value=male>Male</option>
  <option value=female>Female</option> </select> Age: <input type=text name=page1 /> <br/>
		Passenger 2 -> Name: <input type=text name=pname2 /> Gender: <select name=pgen2>
<option value=>Choose gender..</option>
<option value=male>Male</option>
  <option value=female>Female</option> </select> Age: <input type=text name=page2 /> <br/>
		Passenger 3 -> Name: <input type=text name=pname3 /> Gender: <select name=pgen3>
<option value=>Choose gender..</option>
<option value=male>Male</option>
  <option value=female>Female</option> </select> Age: <input type=text name=page3 /> <br/>
		Passenger 4 -> Name: <input type=text name=pname4 /> Gender: <select name=pgen4>
<option value=>Choose gender..</option>
<option value=male>Male</option>
  <option value=female>Female</option> </select> Age: <input type=text name=page4 /> <br/>
		Passenger 5 -> Name: <input type=text name=pname5 /> Gender: <select name=pgen5>
<option value=>Choose gender..</option>
<option value=male>Male</option>
  <option value=female>Female</option> </select> Age: <input type=text name=page5 /> <br/>
		Passenger 6 -> Name: <input type=text name=pname6 /> Gender: <select name=pgen6>
<option value=>Choose gender..</option>
<option value=male>Male</option>
  <option value=female>Female</option> </select> Age: <input type=text name=page6 /> <br/>";
echo "<input type=submit value=Submit details ! />";
}
}
?>


</form>
</body>
</html>
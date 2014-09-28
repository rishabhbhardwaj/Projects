<html>
<title>--Registration--</title>
<body>
<?php
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$f=0;

if(empty($_POST["userid"]))
{
echo "User Id can not be left blank <br/>
<a href=registration/reg-form.html>Go Back and Refill the form </a>";
$f=1;
}
else if(empty($_POST["pass"]))
{
echo "Password can not be left blank <br/>
<a href=registration/reg-form.html>Go Back and Refill the form </a>";
$f=1;
}
else if(empty($_POST["name"]))
{
echo "Name can not be left blank <br/>
<a href=registration/reg-form.html>Go Back and Refill the form </a>";
$f=1;
}
else if(empty($_POST["email"]))
{
echo "Email-Id can not be left blank <br/>
<a href=registration/reg-form.html>Go Back and Refill the form </a>";
$f=1;
}
if($f==0)
{
$phn=$_POST["phone"].$_POST["phone2"].$_POST["phone3"];
$nm=$_POST["name"].$_POST["name2"];
$sql="INSERT INTO customerdetails VALUES ('$_POST[userid]','$nm','$_POST[pass]','$_POST[street]','$_POST[city]','$_POST[state]','$_POST[pincode]','$phn','$_POST[email]')";
if(!mysql_query($sql,$con))
	{
	die('Error: ' .mysql_error());
	}
	echo "<fieldset><legend align=center><h2>Successful Registration.</h2></legend><br/><div align=center>
			<br/><a href=login.html>Proceed....</a></div></fieldset>";
	}
?>
</body>
</html>
<html>
<body>

<?php
$con=mysql_connect("localhost","root","");
if(!$con)
	{
	die('Could not connect: ' .mysql_error());
	}
	mysql_select_db("trains",$con);
	$sql="INSERT INTO test (name,age) VALUES ('$_POST[name]','$_POST[age]')";
if(!mysql_query($sql,$con))
	{
	die('Error: ' .mysql_error());
	}
echo "1 record added";
mysql_close($con);
$to="deepshikha.bansal20@gmail.com";
$subject="inserttest";
$email="rishrt629@gmail.com";
$msg="mail sent from inserttest confirming ur reservation";
mail($to,$subject,$msg,'From :' . $email);
?>

</body>
</html>
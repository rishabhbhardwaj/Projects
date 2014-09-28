<html>
<body>

<?php
$con=mysql_connect("localhost","root","");
if(!$con)
	{
	die('Could not connect: ' .mysql_error());
	}
	mysql_select_db("trains",$con);
	$sql="insert into test (name,age) values ('$_post[name]','$_post[age]')";
if(!mysql_query($sql,$con))
	{
	die('Error: ' .mysql_error());
	}
echo "1 record added";
mysql_close($con)
?>

</body>
</html>
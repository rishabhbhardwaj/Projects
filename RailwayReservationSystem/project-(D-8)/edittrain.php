<html>
<title>USER INFO</title>
<body>
<?php
echo " Following are the details of current users";
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$sql=mysql_query("SELECT * from customerdetails");
mysql_close($con);
?>
</body>
</html>

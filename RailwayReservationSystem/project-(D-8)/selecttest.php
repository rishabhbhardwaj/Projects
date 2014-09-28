<html>
<body>

<?php
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$result=mysql_query("SELECT * FROM test");
while($row=mysql_fetch_array($result))
	{
		echo $row['name'] . " " .$row['age'];
		echo "<br />";
	}
mysql_close($con);
?>
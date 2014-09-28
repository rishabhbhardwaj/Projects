<html>
<head>
<title>Book2->Step 2</title>
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
<br/><h1 class="one"><font size="45" face="Monotype Corsiva">Railway Reservation system</font></h1><br/>
<hr/><hr/>
<?php
$n2=0;
if(empty($_POST["src"] ) || empty($_POST["dest"]))
{
echo "<br/><br/><fieldset> <legend><h4>Error !</h4></legend><h2 align=center>Fields can not be left blank.</h2><h3 align=center>Choose the appropriate Source and Destination from the list!</h3>
		<div align=center><a href=1afterlogin.php>Go Back</a><div></fieldset>";
$n2=1;
}
if($n2==0)
{
echo "<p>You have selected source as ".$_POST["src"]." and 
destination as ". $_POST["dest"]." </p> 
<br/>

<h3>The trains with the selected source and destination are displayed below.</h3>";

$_SESSION["source"]=$_POST["src"];
$_SESSION["dest"]=$_POST["dest"];
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$result=mysql_query("select train_no from train where source='$_POST[src]' and destination='$_POST[dest]'");
echo "<table border='2'>
<tr>
<th>Train Number</th>
<th>Train Name</th>
</tr>";
while($row=mysql_fetch_array($result))
	{
		echo "<tr>";
		echo "<td>".$row["train_no"]."</td>";
		$res2=mysql_query("select train_name from train where train_no=$row[train_no]");
		while($row2=mysql_fetch_array($res2))
		echo "<td>".$row2["train_name"]."</td>";
		echo "</tr>";
		echo "<br />";
	}
	echo "</table>";
mysql_close($con);
echo "<hr/>
<br/>

<p>Enter the following details to book the ticket....</p><br/>
<form action=book2.php method=POST>
<table border=1 align=center>
<tr>
<td>Train Number :</td><td><input type=text name=trainno /></td></tr> 
<tr><td>Train Name :</td><td><input type=text name=trainname /> </td></tr>
<tr><td>Date :</td><td><input type=date name=date /></td></tr>
<tr><td>Class :</td><td> <select name=class>
<option value= >Choose Class..</option>
<option value=acseats>Air Conditioned (AC)</option>
  <option value=nonacseats>Non-AC</option> 
  </select></td></tr>
 <tr>
      <td align=center colspan=2> <input type=submit value=Submit Details ! /></td></tr>
  </div>";
  }
  ?>
</body>
</html>
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
<div align="center">
<?php session_start(); echo "<div align=center>Welcome ".$_SESSION["name"]." </div>"; ?>
<div align="right"><a href="logout1.php">Logout..</a></div>
<p class="one"><b><font size="45" face="Monotype Corsiva">Welcome <?php echo $_SESSION["name"]; ?></font></b></p><br/>
<hr/><hr/></div>
<body>
<div align="center">
<?php
$user=$_SESSION["name"];
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$sql=mysql_query("SELECT pnrno,date,amount,cardnum from bookhistory where userid='$user'");
echo "<br/><br/><table border=2><th>PNR Number</th><th>Date</th><th>Amount</th><th>Card Number</th><th>Train Number</th><th>Class</th>";
while($row=mysql_fetch_array($sql))
{ 
    echo "<tr><td>PNR Number: ".$row["pnrno"]. "</td><td> Date: ".$row["date"]. "</td><td> Amount: ".$row["amount"]. " </td><td>Card Number: " .$row["cardnum"];
	$sql2=mysql_query("SELECT trainno,class from ticket1 where pnrno=$row[pnrno]");
	while($row2=mysql_fetch_array($sql2))
	{
	echo " </td><td>Train Number: ".$row2["trainno"]."</td><td> Class: ".$row2["class"];
	}
	echo " </td></tr> ";
}
?>
</table>
<br/><br/>
<h5>Go Back to Book Ticket : <a href="1afterlogin.php">Click Here ! </a> </h5><br/>
<br/><hr/>
<h3>For Cancellation </h3><h5>Provide The PNR Number.</h5><br/>
<form action="bookhistory2.php" method="POST">
Enter PNR no. <input type="text" name="num" /><br/>
<input type="submit" value="Proceed." />
</form>
</body>
</html>


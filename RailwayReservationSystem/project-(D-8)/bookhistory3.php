<html>
<title>Cancellation..</title>
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
<p class="one"><b><font size="45" face="Monotype Corsiva">Welcome <?php echo $_SESSION["name"] ."in Cancellation section "; ?></font></b></p><br/>
<hr/><hr/></div>
<body>
<div align="center">
<?php 
$f1=0;
if(empty($_POST["name1"]))
{
echo "<fieldset><legend><h4>Error !</h4></legend><div align=center>Fields Left Blank !<br/>
		<a href=1afterlogin.php>Go Back</a></div></fieldset><br/><br/><br/><br/>";
$f1=1;
}
if($f1==0)
{
$pnr2=$_SESSION["pnr2"];
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$i=0;
$name=array("$_POST[name1]","$_POST[name2]","$_POST[name3]","$_POST[name4]","$_POST[name5]","$_POST[name6]");
while(1)
{
if($name[$i]!=NULL)
{
$abc=mysql_query("DELETE from passenger where name='$name[$i]'");

$abc2=mysql_query("select trainno,class from ticket1 where pnrno=$pnr2");
while($row1=mysql_fetch_array($abc2))
{
$var1=$row1["trainno"];
$var2=$row1["class"];
}
$abc3=mysql_query("select date from bookhistory where pnrno=$pnr2");
while($row2=mysql_fetch_array($abc3))
{
$var3=$row2["date"];
}
$que4=mysql_query("UPDATE seatavail SET $var2=$var2+1 where date='$var3' and trainno=$var1");
$i++;
}
else
break;
}
$vg=mysql_query("select $var2 from fare where train_no=$var1");
while($ab=mysql_fetch_array($vg))
{
$kk=$ab[$var2];
}
$nw=$kk*($i--);
$que1=mysql_query("UPDATE bookhistory SET amount=amount-$nw where pnrno=$pnr2 and date='$var3'");
$result=mysql_query("SELECT name from passenger where pnrno=$pnr2");
$c2=mysql_num_rows($result);
if($c2==0)
{
$que1=mysql_query("DELETE from ticket1 where pnrno=$pnr2");
$que2=mysql_query("DELETE from bookhistory where pnrno=$pnr2");
}
echo "<br/><br/><fieldset><legend align=center><h2>Ticket Cancelled</h2></legend><br/>
				<div align=center><a href=1afterlogin.php>Click Here !</a></div></fieldset>";
}
?>
</body>
</html>

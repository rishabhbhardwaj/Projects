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
<?php
$i=0;
$c=0;
$name=array("$_POST[pname1]","$_POST[pname2]","$_POST[pname3]","$_POST[pname4]","$_POST[pname5]","$_POST[pname6]");
for($k=0;$k<6;$k++)
{
if($name[$k]==NULL)
$c++;
}
$t=0;
if(6-$c!=$_SESSION["seats"])
{
echo "<br/><br/><fieldset><legend><h4>Error ! </h4></legend><div align=center> Invalid Passengers Details..<br/>
		<a href=1afterlogin.php>Go Back</a></div></fieldset>";
$t=1;
}
if($t==0)
{
$gender=array("$_POST[pgen1]","$_POST[pgen2]","$_POST[pgen3]","$_POST[pgen4]","$_POST[pgen5]","$_POST[pgen6]");
$age=array("$_POST[page1]","$_POST[page2]","$_POST[page3]","$_POST[page4]","$_POST[page5]","$_POST[page6]");
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$pnrn=$_SESSION["pnrno"];
while(1)
{
if(!empty($name[$i]))
{
$abc=mysql_query("INSERT into passenger (name,age,gender,pnrno) values('$name[$i]',$age[$i],'$gender[$i]',$pnrn)");
$i++;
}
else
break;
}


echo "<div align=center>
<br/>
<h3>Ticket Details :</h3><br/>
<table border=1>
<tr><td>PNR number : ".$_SESSION["pnrno"]."</td> 
<td>Train Number : ". $_SESSION["tnum"]." </td></tr> 
<tr><td colspan=2>Train Name : ". $_SESSION["tname"]."</td></tr> 
<tr><td>From Station: ". $_SESSION["source"]." </td> 
<td>To Station: ".$_SESSION["dest"]."</td></tr> 
<tr><td>Date : ". $_SESSION["date"]."</td> 
<td>Class : ". $_SESSION["classt"]."</td></tr> </table>
<br/>
<h3>Passenger Details :</h3><br/>

Number of Seats :". $_SESSION["seats"]."<br/>
<table border=2>
<tr><th>S.no</th><th>Name</th><th>Age</th><th>Gender</th></tr>";

$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$i=1;
$ab1=mysql_query("select name,age,gender from passenger where pnrno=$_SESSION[pnrno]");
while($row=mysql_fetch_array($ab1))
{
echo "<tr><td>".$i."</td> <td>".$row["name"]."</td> <td>".$row["age"]."</td> <td>".$row["gender"]."</td></tr> ";
$i++;
}
mysql_close();

echo "</table><br/>
<h3>Payment Details :</h3>
<table border=2>
<tr><td>
Fare (Ticket Charge) :"; 

$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$num=$_SESSION["seats"];
$abc=$_SESSION["classt"];
$efg=$_SESSION["tnum"];
$c2;
$resul1=mysql_query("select $abc from fare where train_no=$efg");
while($row=mysql_fetch_array($resul1))
{

$c2= $row["$abc"]*$num;
}
echo $c2." Rs";
$_SESSION["amount"]=$c2;
$t2=$c2+10;
echo "</td>
<td>Internet Service charge : 10 Rs</td>
<tr><td colspan=2 align=center>Total = " . $t2 . " </td></tr></table>
<br/></h3><a href=book4.php>Make Payment !</a> ";
}
?>
</body>
</html>
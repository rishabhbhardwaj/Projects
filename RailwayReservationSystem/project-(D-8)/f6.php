<html>
<title>Print Ticket...</title>
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
<p class="one"><b><font size="45" face="Monotype Corsiva">Reservation Slip</font></b></p><br/>
<hr/><hr/></div>
<?php
$i=0;
$c=0;

$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$pnrn=$_SESSION["pnrno"];
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
?>
<SCRIPT LANGUAGE="JavaScript">
if (window.print) {
document.write('<form> '
+ '<input type=button name=print value="Click" '
+ 'onClick="javascript:window.print()"> To Print this page!</form>');
}
// End -->
</script>
</body>
</html>
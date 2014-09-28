<html>
<head>
<style type="text/css">
body { background-image:url('b18.jpg');}
.one
{
font-family:"Monotype Corsiva";
font-size:30pt;
text-align:center;
text-decoration:underline;
letter-spacing:2px;
}
.qq
{
margin-top:150px;
margin-bottom:150px;
margin-left:100px;
margin-right:100px;
1border-style:solid;
1border-color:grey;
1background-image:url(b2.jpeg);
outline-width:10px;
}
</style></head>
<body>
<div class="qq">
<div align="center">
<br/><br/><br/><br/>
<?php
$f1=0;
if(empty($_POST["trainno"]) || empty($_POST["date"]) || empty($_POST["acseats"]) || empty($_POST["nonacseats"]))
{
echo "<fieldset><legend><h4>Error !</h4></legend><div align=center>Fields Left Blank !<br/>
		<a href=admin1.html>Go Back</a></div></fieldset><br/><br/><br/><br/>";
$f1=1;
}
if($f1==0)
{
$tno=$_POST["trainno"];
$date=$_POST["date"];
$tna=$_POST["acseats"];
$s=$_POST["nonacseats"];
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$sql=mysql_query("UPDATE  seatavail SET acseats='$tna',nonacseats='$s' where trainno='$tno' and date='$date'");
echo "<h3> SEATS SUCCESSFULLY UPDATED </h3>";
mysql_close($con);
echo "<br/><br/>
<a href=admin1.html>GO BACK</a>
<br/><br/><br/><br/>
</div>
</div>";
}
?>
</body>
</html>	   
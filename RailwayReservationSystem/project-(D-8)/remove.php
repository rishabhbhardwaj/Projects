<html>
<title>REMOVE TRAINS</title>
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
if(empty($_POST["train_no"]))
{
echo "<fieldset><legend><h4>Error !</h4></legend><div align=center>Fields Left Blank !<br/>
		<a href=admin1.html>Go Back</a></div></fieldset><br/><br/><br/><br/>";
$f1=1;
}
if($f1==0)
{
$tno=$_POST["train_no"];
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$sql=mysql_query("DELETE from train WHERE train_no=$tno");
echo " <div align= center>";
echo "<h3> TRAIN SUCCESSFULLY REMOVED</h3> ";
echo " </div> ";
mysql_close($con);
echo "<br/><br/>
<font face=Monotype Corsiva size=4.0pt color=maroon>
<a href=admin1.html>GO BACK</a>
</font>
<br/><br/><br/><br/>
</div>
</div>";
}
?>
}</body>
</html>	  
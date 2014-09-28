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
if(empty($_POST["num"]))
{
echo "<fieldset><legend><h4>Error !</h4></legend><div align=center>Fields Left Blank !<br/>
		<a href=1afterlogin.php>Go Back</a></div></fieldset><br/><br/><br/><br/>";
$f1=1;
}
if($f1==0)
{
$_SESSION["pnr2"]=$_POST["num"];
$user=$_SESSION["name"];
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$sql=mysql_query("SELECT name,age,gender from passenger where pnrno=$_POST[num]");
while($row=mysql_fetch_array($sql))
{
echo "Name: ".$row["name"]." Age: ".$row["age"]." Gender: ".$row["gender"];
echo " <br/> ";
}

echo "<br/>
<hr/>
<h3>Enter The Names of The Passenger of which you want to cancel the ticket.</h3><br/>
<form action=bookhistory3.php method=POST>
Name->1: <input type=text name=name1 /><br/>
Name->2: <input type=text name=name2 /><br/>
Name->3: <input type=text name=name3 /><br/>
Name->4: <input type=text name=name4 /><br/>
Name->5: <input type=text name=name5 /><br/>
Name->6: <input type=text name=name6 /><br/>
<input type=submit value=Confirm Cancel ! />
</form>";
}
?>
</body>
</html>
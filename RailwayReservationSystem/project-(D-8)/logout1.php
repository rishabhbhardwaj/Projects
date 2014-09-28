<html>
<body>
<?php session_start();
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$abcd=mysql_query("DELETE from ticket1 where pnrno=$_SESSION[pnrno]");
$abcde=mysql_query("UPDATE setavail SET $_SESSION[classt]=$_SESSION[classt]+$_SESSION[seats] where date=$_SESSION[date] and trainno=$_SESSION[tnum]");
$abcd2=mysql_query("DELETE from passenger where pnrno=$_SESSION[pnrno]");
session_unset();
session_destroy();
?>
<h2 align="center"><a href="first.html">Thank you for using our Services !</a></h2>
</body>
</html>
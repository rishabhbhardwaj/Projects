<html>
<title>--Welcome User--</title>
<head>
<style type="text/css">
body { background-image:url(b18.jpg);}
.one
{
font-family:"Monotype Corsiva";
margin-left:25px;
font-size:30pt;
text-align: center;
}
.t
{margin-top:35px;

text-align: center;
}
.t2 {margin-top:37px;}
</style></head>
<body>
<p class="t2"><hr/></p>
<h1 class="t"><font face="Forte" size=30pt> Welcome
 <?php session_start();
$user=$_SESSION["name"];
echo $user;
?> </font></h1><hr/>
<br/>
<h3 class="one"><a href="book11.php">Book Ticket</a></h3>
<h3 class="one"><a href="bookhistory1.php">Booking History</a></h3>
</body>
</html> 
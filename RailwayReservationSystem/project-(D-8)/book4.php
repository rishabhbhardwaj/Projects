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
<h3>Fill in the transaction details...</h3><br/>
<div align="center">
<form action="book6.php" method="post">
Bank Name: <select name="bname"><option value="">Choose Bank....</option>
								<option value="SBI">State Bank of India.</option>
								<option value="PNB">Punjab National Bank.</option>
								<option value="HDFC">HDFC Bank</option>
								<option value="IOB">Indian Overseas Bank.</option>
								<option value="Axis Bank">Axis Bank</option>
								<option value="ICICI">ICICI Bank</option>
								<option value="Canara Bank">Canara Bank</option>
								</select><br/>
Card Number: <input type="text" name="cnum" /><br/>
<input type="submit" /><br/>
</form>
</div>

</body>
</html>

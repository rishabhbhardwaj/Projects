<html>
<title>Book->Step 1</title>
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
<body>
<body background="b2.jpeg">
<?php session_start(); echo "<div align=center>Welcome ".$_SESSION["name"]." </div>"; ?>
<div align="right"><a href="logout1.php">Logout..</a></div>
<div align="center">
<h1 class="one"><font size="45" face="Monotype Corsiva">Railway Reservation System</font></h1><br/>
<hr/><hr/>
<p>To Book your ticket select source and destination and proceed to further steps !</p>
<form action="book1.php" method="POST">
Source: <select name="src">
<option value="">Choose Source..</option>
<option value="allahabad">Allahabad</option>
<option value="ahemdabad">Ahemdabad</option>
  <option value="amritsar">Amritsar</option>
  <option value="bareilly">Bareilly</option>
  <option value="chennai">Chennai</option>
  <option value="lucknow">Lucknow</option>
  <option value="mumbai">Mumbai</option>
  <option value="new delhi">New Delhi</option>
  </select>
  <br/>
Destination: <select name="dest">
<option value="">Choose Destination..</option>
<option value="allahabad">Allahabad</option>
<option value="ahemdabad">Ahemdabad</option>
  <option value="amritsar">Amritsar</option>
  <option value="bareilly">Bareilly</option>
  <option value="chennai">Chennai</option>
  <option value="lucknow">Lucknow</option>
  <option value="mumbai">Mumbai</option>
  <option value="new delhi">New Delhi</option>
  </select>
  <br/>
<input type="submit" value="go">
</div>
</form>
</body>
</html>
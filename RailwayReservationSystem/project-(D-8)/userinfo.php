<html>
<title>USER INFO</title>
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
<?php
echo "<h3> FOLLOWING ARE THE DETAILS OF CURRENT USERS</h3>";
echo " <br/><br/><hr/> ";
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
$sql=mysql_query("SELECT * from customerdetails");
echo " <div align=center> ";
echo "<table border='3'>
<tr>
<th>User-Id</th>
<th>Name</th>
<th>Password</th>
<th>Street</th>
<th>City</th>
<th>State</th>
<th>Pincode</th>
<th>Phone Number</th>
<th>Email-ID</th>
</tr>";


while($row = mysql_fetch_array($sql))
  {
  echo "<tr>";
  echo "<td>" . $row['userid'] . "</td>";
  echo "<td>" . $row['name'] . "</td>";
  echo "<td>" . $row['password'] . "</td>";
  echo "<td>" . $row['street'] . "</td>";
  echo "<td>" . $row['city'] . "</td>";
  echo "<td>" . $row['state'] . "</td>";
  echo "<td>" . $row['pincode'] . "</td>";
  echo "<td>" . $row['phone'] . "</td>";
  echo "<td>" . $row['emailid'] . "</td>";
  echo "</tr>";
  }
echo "</table>";
echo " </div> ";
mysql_close($con);
?>
<br/><br/>
<a href="admin1.html">GO BACK</a>
<br/><br/><br/><br/>
</div>
</div>
</body>
</html>

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
<body>
<div class="qq">
<div align="center">
<?php
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
echo "<h3> .....FOLLOWING ARE THE EXISTING TRAINS......</h3>";
$sql=mysql_query("SELECT * from fare");
echo "<table border='3'>
<tr>
<th>Train Number</th>
<th>AC Fare</th>
<th>NON-AC Fare</th>
</tr>";
while($row = mysql_fetch_array($sql))
  {
  echo "<tr>";
  echo "<td>" . $row['train_no'] . "</td>";
  echo "<td>" . $row['acseats'] . "</td>";
  echo "<td>" . $row['nonacseats'] . "</td>";
  echo "</tr>";
  }
echo "</table>";

?>
<hr/>
<div align="center">
<form action="editfare1.php" method="post">
TRAIN NUMBER:<input type="text" name ="train_no" /><br/>
<br/>
AC FARE : <input type="text" name= "acseats" /><br/>
<br/>
NON AC FARE : <input type="text" name="nonacseats" /><br/>
<br/>
<input type="submit" value ="Go" />
</form>
</div>
</div>
</div>
<br/>
<br/>
</body>
</html>

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
echo "<h3> .....FOLLOWING ARE THE SEAT AVAILABILITIES......</h3>";
$sql=mysql_query("SELECT * from seatavail");
echo "<table border='3'>
<tr>
<th>Train Number</th>
<th>Date</th>
<th>AC Seats</th>
<th>Non-AC Seats</th>
</tr>";
while($row = mysql_fetch_array($sql))
  {
  echo "<tr>";
  echo "<td>" . $row['trainno'] . "</td>";
  echo "<td>" . $row['date'] . "</td>";
  echo "<td>" . $row['acseats'] . "</td>";
  echo "<td>" . $row['nonacseats'] . "</td>";
  echo "</tr>";
  }
echo "</table>";

echo "<hr/><br/><br/>
<div align=center>
<form action=editseats1.php method=post>
TRAIN NUMBER:<input type=text name=trainno /><br/>
<br/>
Date:<input type=text name=date /><br/>
<br/>
AC SEATS : <input type=text name=acseats /><br/>
<br/>
NON AC SEATS : <input type=text name=nonacseats /><br/>
<br/>
<input type=submit value =Go />
</form>
</div>
</div>
</div>
<br/>
<br/>";

?>
</body>
</html>

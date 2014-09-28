<html>
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
$con=mysql_connect("localhost","root","");
mysql_select_db("trains",$con);
echo "<h3> .....FOLLOWING ARE THE EXISTING TRAINS......</h3>";
$sql=mysql_query("SELECT * from train");
echo "<table border='3'>
<tr>
<th>Train No</th>
<th>Train Name</th>
<th>Source</th>
<th>Destination</th>
</tr>";
while($row = mysql_fetch_array($sql))
  {
  echo "<tr>";
  echo "<td>" . $row['train_no'] . "</td>";
  echo "<td>" . $row['train_name'] . "</td>";
  echo "<td>" . $row['source'] . "</td>";
  echo "<td>" . $row['destination'] . "</td>";
  echo "</tr>";
  }
echo "</table>";

?>
<br/><br/><br/><br/>
<hr/>
<div align="center">
<form action="edit1.php" method="post">
<h3>....ENTER ALL THE DETAILS....</h3>
Train Number:<input type="text" name ="train_no" /><br/>
<br/>
Train Name : <input type="text" name= "train_name" /><br/>
<br/>
Source : <input type="text" name="source" /><br/>
<br/>
Destination: <input type="text" name="destination" /><br/>
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

<html>
<body>
<?php
session_start();
echo "<fieldset><legend align=center><h3> ADMIN IS LOGGED OUT</h3></legend> 
		<div align=center><a href=login.html>Click Here !</a></div></fieldset><br/><br/>";
session_unset();
session_destroy();
?>
</body>
</html>
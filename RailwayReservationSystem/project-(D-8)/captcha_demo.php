<?php session_start() ?>
<form method="post" action="">
<table>
<tr><td align="center">CAPTCHA:<br>
	(antispam code, 3 black symbols)<br>
	<table><tr><td><img src="captcha.php" alt="captcha image"></td><td><input type="text" name="captcha" size="3" maxlength="3"></td></tr></table>
</td></tr>
<tr><th><input type="submit" value="Submit"></th></tr>	
</table>
</form>

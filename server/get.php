<?php
	include 'db_credentials.php';
	

	mysql_connect($server, $uname, $password) or die("Cant connect to DB : " . $con->connect_error);	
	mysql_select_db($db_name);
	if( $_GET['id']) {

		$query  = "CALL getRowTUser(" . $_GET['id'] . ')';
		$result = mysql_query($query);
		
		if(mysql_num_rows($result) == 0) {
			echo "No record corresponding to this ID";

		}
		else {
			
			while($row = mysql_fetch_assoc($result)) {
				echo "{'ID' : '" . $row["ID"] . "', 'NAME' : '" . $row["NAME"] . "', 'ADDRESS' : '" . $row["ADDRESS"] . "', 'PHN' : '" . $row["PHNUMBER"] . "'}";
			}			
		}


		mysql_free_result($result);
	}
	else  {
		echo "Incorrect Params received";
	}
?>
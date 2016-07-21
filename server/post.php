<?php

	include "db_credentials.php";
	mysql_connect($server, $uname, $password) or die("Cant connect to DB : " . $con->connect_error);	
	mysql_select_db($db_name);

	$json_string = '{"NAME":"Name3","ADDRESS":"Address3","PHN":"4567"}';
	$array = json_decode($_POST['json_string'], true);


	// switch (json_last_error()) {
 //        case JSON_ERROR_NONE:
 //            echo ' - No errors';
 //        break;
 //        case JSON_ERROR_DEPTH:
 //            echo ' - Maximum stack depth exceeded';
 //        break;
 //        case JSON_ERROR_STATE_MISMATCH:
 //            echo ' - Underflow or the modes mismatch';
 //        break;
 //        case JSON_ERROR_CTRL_CHAR:
 //            echo ' - Unexpected control character found';
 //        break;
 //        case JSON_ERROR_SYNTAX:
 //            echo ' - Syntax error, malformed JSON';
 //        break;
 //        case JSON_ERROR_UTF8:
 //            echo ' - Malformed UTF-8 characters, possibly incorrectly encoded';
 //        break;
 //        default:
 //            echo ' - Unknown error';
 //        break;
 //    }



	// $array = array("NAME" => "Name3", "Address" => "Address3", "PHN" => "4567");
	// echo json_encode($array);

	$query = "CALL insertRowTUser('" . $array['NAME'] . "', '" . $array['ADDRESS'] . "', '" . $array['PHN'] . "')";

	$result = mysql_query($query);

	if(!$result) {
		echo "DB Error! Query : " . $query. " " . mysql_error();
	}	
	else {
		echo "Success!";
	}

	// {"NAME":"Name3","Address":"Address3","PHN":"4567"}

?>
<?php
	include 'db_credentials.php';

	mysql_connect($server, $uname, $password) or die("Cant connect to DB : " . $con->connect_error);	
	

	//CREATION OF DB
	$query = "CREATE DATABASE SAMPLE2";
	$result = mysql_query($query);
	if(!result) {
		echo "Unable to create database : SAMPLE";
		exit;
	}
	else {
		echo "DATABASE: SAMPLE CREATED SUCCESSFULLY";
	}

	mysql_select_db("SAMPLE2");

	//CREATION OF TABLE
	$query = "CREATE TABLE TUser (
	    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
	    NAME VARCHAR(100) NOT NULL,
	    ADDRESS VARCHAR(100) NOT NULL,
	    PHNUMBER VARCHAR(100) NOT NULL
	);";

	$result = mysql_query($query) ;
	if(!result) {
		echo "<br>Unable to create table: TUser";
		exit;
	}else {
		echo "<br>TABLE TUser CREATED SUCCESSFULLY";
	}

	//CREATION OF STORED PROCEDURES
	// $query = "DELIMITER //";
	// $result = mysql_query($query);

	// if(!result) {
	// 	echo "<br>UNABLE TO CHANGE DELIMITER (1)";
	// }


	$query = "CREATE PROCEDURE insertRowTUser(IN nm varchar(100), IN addr varchar(100), IN phn varchar(100)) BEGIN INSERT INTO TUser(NAME, ADDRESS, PHNUMBER) VALUES(nm, addr, phn); END;";
	$result = mysql_query($query) ;
	if(!result) {
		echo "<br>FAILED TO CREATE PROCDURE: insertRowTUser";
		exit;
	}
	else {
		echo "<br>STORED PROCEDURE: insertRowTUser CREATED SUCCESSFULLY";
	}

	$query = "CREATE PROCEDURE getRowTUser(IN number INTEGER) BEGIN SELECT * FROM TUser WHERE ID = number;END;";

	$result = mysql_query($query);

	if(!result) {
		echo "<br>FAILED TO CREATE PROCDURE: getRowTUser";
		exit;
	}
	else {
		echo "<br>STORED PROCEDURE: getRowTUser CREATED SUCCESSFULLY";
	} 

	// $query = "DELIMITER ;";
	// $result = mysql_query($query);
	// if(!result) {
	// 	echo "<br>UNABLE TO CHANGE DELIMITER (2)";
	// }

	echo "<br><hr><br>";

	$query = "CALL insertRowTUser('Name1', 'Addr1', '1234')";
	$result = mysql_query($query);
	if(!result) {
		echo "<br>FAILED TO INSERT RECORD";
		exit;
	}
	else {
		echo "<br> 'Name1', 'Addr1', '1234' INSERTED SUCCESSFULLY <br><hr><br>";
	}

	$query = "CALL getRowTUser(1)";
	$result = mysql_query($query);
	
	while ($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
 	   echo "Retrieved Record: " . $row["NAME"] . ", " . $row["ADDRESS"] . ", " . $row["PHNUMBER"];
 	}

 	echo "<br><hr><br>"

?>
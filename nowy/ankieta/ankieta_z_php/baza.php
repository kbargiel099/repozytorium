<?php

	$odp =$_POST['input'];
	$idAnkiety =$_POST['idAnkiety'];
	$numerPytania =$_POST['numerPytania'];
	$tabAnkieta =$_POST['tabAnkieta'];
	$mysqli = new mysqli('mysql2.ph-hos.osemka.pl', '1482932445_f', 'jecky887', '1330605_bazatest');
	//$mysqli = new mysqli('127.0.0.1', 'pracownik', 'Pracownik.', 'baza_supermarket');
	if ($mysqli->connect_error) {
		die('Connect Error ('.$mysqli->connect_errno.') '. $mysqli->connect_error);
		if (mysqli_connect_error()) {
			die('Connect Error (' . mysqli_connect_errno() . ') '. mysqli_connect_error());
		}
	}else
		{echo 'Połączono';}
	if($tabAnkieta > 0)
	{			
		$ins = "INSERT INTO ankietaOdpowiedz (idAnkiety,numerPytania,odpowiedz) VALUES ($idAnkiety,$numerPytania,'$odp');";
 
		if ($mysqli->query($ins) === TRUE) {
			echo "New record created successfully";
		} else {
			echo "Error: " . $ins . "<br>" . $mysqli->error;
		}
	}
	else
	{
		$ins = "INSERT INTO ankieta (idAnkiety) VALUES ($idAnkiety);";
 
		if ($mysqli->query($ins) === TRUE) {
			echo "New record created successfully";
		} else {
			echo "Error: " . $ins . "<br>" . $mysqli->error;
		}
	}
	
?>
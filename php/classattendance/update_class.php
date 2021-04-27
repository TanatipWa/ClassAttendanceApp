<?php
$servername = "localhost";
$USERNAME = "root";
$password = "12345678";
$dbname = "classattendancedb";

$conn = new mysqli($servername, $USERNAME, $password, $dbname);

// Check connection
if($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$i = $_POST['id'];
$c = $_POST['class_code'];
$s = $_POST['status'];

$sql = "UPDATE class SET class_code = '$c', `status` = '$s' WHERE id = '$i'";

if(mysqli_query($conn, $sql)) {
    echo "Records updated successfully.";
} else {
    echo "ERROR: Could not able to execute $sql." . mysqli_error($conn);
}

// Close connection
mysqli_close($conn);
?>
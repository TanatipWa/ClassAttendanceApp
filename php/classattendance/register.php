<?php
$servername = "localhost";
$USERNAME = "root";
$password = "12345678";
$dbname = "classattendancedb";

$conn = new mysqli($servername, $USERNAME, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$r = $_POST['role'];
$u = $_POST['username'];
$p = $_POST['pass'];
$n = $_POST['name'];
$s = $_POST['surname'];

if ($r == 'Teacher') {
    $sql = "INSERT INTO teacher (username, pass, `name`, surname) VALUES ('$u', '$p', '$n', '$s')";
} else if ($r == 'Student') {
    $sql = "INSERT INTO student (username, pass, `name`, surname) VALUES ('$u', '$p', '$n', '$s')";
}

if (mysqli_query($conn, $sql)) {
    echo "Records inserted successfully.";
} else {
    echo "ERROR: Could not able to execute $sql." . mysqli_error($conn);
}

// Close connection
mysqli_close($conn);

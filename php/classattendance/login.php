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

if ($r == 'Teacher') {
    $sql = "SELECT username FROM teacher WHERE username = '$u' AND pass = '$p'";
} else if ($r == 'Student') {
    $sql = "SELECT username FROM student WHERE username = '$u' AND pass = '$p'";
}

$objQuery = mysqli_query($conn, $sql);
$objResult = mysqli_fetch_array($objQuery, MYSQLI_ASSOC);

if ($objResult) {
    echo $u;
} else {
    echo "Username and Password Incorrect!";
}

// Close connection
mysqli_close($conn);

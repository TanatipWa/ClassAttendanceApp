<?php
$servername = "localhost";
$USERNAME = "root";
$password = "12345678";
$dbname = "classattendancedb";

$conn = new mysqli($servername, $USERNAME, $password, $dbname);

if($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "SELECT * FROM class";

$result = $conn->query("SELECT * FROM class");

if($result !== false) {
    while ($row = mysqli_fetch_assoc($result)) {
        $output[] = $row;
    }

    mysqli_free_result($result);
}
else {
    echo "Error cannot query: " . $conn->error;
}
$conn->close();
print(json_encode($output));

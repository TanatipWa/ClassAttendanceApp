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

$u = $_POST['username'];
$d = $_POST['currentDate'];
$c = $_POST['class_code'];

$sql = "SELECT class_code, `status` FROM class WHERE id = '1'";
$result = mysqli_query($conn, $sql);

while ($row = mysqli_fetch_assoc($result)) {
    $old_class_code = $row['class_code'];
    $old_status = $row['status'];
}

if ((strcmp($c, $old_class_code) == 0) && (strcmp($old_status, "on") == 0)) {

    $sql2 = "SELECT * FROM attendance WHERE username = '$u' AND `date` = '$d'";
    $result2 = mysqli_query($conn, $sql2);
    $rs = mysqli_fetch_array($result2);

    if (!$rs) { //ไม่เจอ

        $sql3 = "SELECT `name`, surname FROM student WHERE username = '$u'";
        $result3 = mysqli_query($conn, $sql3);

        while ($row2 = mysqli_fetch_assoc($result3)) {
            $name = $row2['name'];
            $surname = $row2['surname'];
        }

        $sql4 = "INSERT INTO attendance (username, `name`, surname, `date`) VALUES ('$u', '$name', '$surname', '$d')";

        if (mysqli_query($conn, $sql4)) {
            echo "Take attendance successfully!";
        } else {
            echo "ERROR: Could not able to execute $sql." . mysqli_error($conn);
        }
    } else {
        echo "Error: Duplicate attendance on same day!";
    }
} else {
    echo "Error: Class code or Status incorrect!";
}


// Close connection
mysqli_close($conn);

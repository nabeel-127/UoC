<?php
$servername = "localhost"; // your database server
$username = "c2322296_Admin"; // your database username
$password = "NabeelAl!1207"; // your database password
$dbname = "c2322296_postcodeDB"; // your database name

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Example: Fetch data from a table
$sql = "SELECT * FROM your_table_name";
$result = $conn->query($sql);

$data = array();
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        $data[] = $row;
    }
} else {
    echo "0 results";
}
$conn->close();

echo json_encode($data);
?>

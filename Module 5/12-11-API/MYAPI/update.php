<?php
 include('connect.php');

 $id = $_POST['id'];
 $name = $_POST['name'];
 $surname = $_POST['surname'];
 $email = $_POST['email'];


$Sql_Query = "UPDATE info SET name='$name' ,surname='$surname',email='$email' WHERE id = '$id'";

 if(mysqli_query($con,$Sql_Query))
{
 echo 'Record Updated Successfully';
}
else
{
 echo 'Something went wrong';
 }

 mysqli_close($con);
?>

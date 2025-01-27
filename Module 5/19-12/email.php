<?php
include('connect.php');
require_once 'PHPMailer-master/src/Exception.php';
require_once 'PHPMailer-master/src/PHPMailer.php';
require_once 'PHPMailer-master/src/SMTP.php';

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

error_reporting(-1);
ini_set('display_errors', 'On');

$first_name = $_REQUEST['first_name'];
$email = $_REQUEST['email'];
$otp = random_int(100000, 999999);

$sql = "INSERT INTO test123 (first_name, email, otp, created_date) VALUES ('" . $first_name . "', '" .$email . "', '" . $otp . "', '" . date("Y-m-d H:i:s") . "')";

$mail = new PHPMailer(true);
try {
    //Server settings
    $mail->SMTPDebug = false;
    $mail->isSMTP();
    $mail->Host       = 'smtp.gmail.com';
    $mail->SMTPAuth   = true;
    $mail->Username   = 'prakrutibook@gmail.com';
    $mail->Password   = 'skqv pfsr wdss wxdw';
    $mail->SMTPSecure = 'tls';
    $mail->Port       = 587;

    //Recipients
    $mail->setFrom('prakrutibook@gmail.com', 'Prakruti');
    $mail->addAddress($email);

    //Content
    $mail->isHTML(true);
    $mail->Subject = 'Otp';
    $mail->Body    = 'Name: ' . $first_name . '<br>Otp: ' . $otp;

    $mail->send();

    $data['result'] = "success";
    $data['message'] = "Message has been sent";
} catch (Exception $e) {
    $data['result'] = "error";
    $data['message'] = $mail->ErrorInfo;
}

if (mysqli_query($con,$sql)) {
} else {
    $data['result'] = "error";
    $data['message'] = mysqli_error($con);
}
echo json_encode($data);
mysqli_close($con);
die;

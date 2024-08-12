package tops.a128

import java.io.FileOutputStream

fun main()
{
    //FileOutputStream - write
    //FileInputStream - read

    println("Enter Your Firstname:")
    var fname = readLine().toString()
    var fname1 = "\n Your Firstname :"

    println("Enter Your lastname:")
    var lname = readLine().toString()
    var lname1 = "\n Your Lastname :"

    println("Enter Your Email:")
    var email = readLine().toString()
    var email1 = "\n Your Email :"

    println("Enter Your Password:")
    var pass = readLine().toString()
    var pass1 = "\n Your Password :"

    var fout = FileOutputStream("E://deep.txt")
    fout.write(fname1.toByteArray())
    fout.write(fname.toByteArray())
    fout.write(lname1.toByteArray())
    fout.write(lname.toByteArray())
    fout.write(email1.toByteArray())
    fout.write(email.toByteArray())
    fout.write(pass1.toByteArray())
    fout.write(pass.toByteArray())

    println("success")

}
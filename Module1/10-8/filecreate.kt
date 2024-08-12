package tops.a108

import java.io.FileOutputStream

fun main()
{
    //FileOutputStream - write
    //FileInputStream - read

    var fname = "a"
    var lname = "a"
    var email = "a"
    var pass = "a"

    var fname1 = "\n Your Firstname :"
    var lname1 = "\n Your Lastname :"
    var email1 = "\n Your Email :"
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
package tops.a78

class Student
{
    //data memeber or variables
    var id:Int=0
    var name:String=""
    var surname:String=""
    var email:String=""
    var password:String=""

}

fun main()
{
    //var objname = classname();
    var s1 = Student()
    var s2 = Student()
    var s3 = Student()

    //object value assign
    s1.id=101
    s1.name="kapil"


    s2.id=102
    s2.name="rahul"

    s3.id=103
    s3.name="deep"


    println("Your id is ${s1.id} and Your name is ${s1.name}")
    println("Your id is ${s2.id} and Your name is ${s2.name}")
    println("Your id is ${s3.id} and Your name is ${s3.name}")


}
package tops.a108

import tops.a78.Student

class Student(var id:Int,var name:String)
{

   fun display()
   {
       println("Your id is $id  and Your name is $name")
   }
}
fun main()
{
    var s1 = Student(101,"A")
    s1.display()
}
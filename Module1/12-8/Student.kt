package tops.a128

class Student
{
        var id:Int=0
        var name:String=""

        constructor(id:Int, name:String)
        {
            this.id = id
            this.name = name
        }

        fun display()
        {
            println("Your id is $id and Your name is $name")
        }


}

fun main()
{
        var s1 = Student(101,"A")
        var s2 = Student(102,"B")

        s1.display()
        s2.display()
}

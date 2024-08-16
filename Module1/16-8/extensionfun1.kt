package tops.a168

class MyFirstClass
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }
}
class MyFirstClass2
{
    fun hasPassed(marks : Int) : Boolean
    {
        return marks > 40
    }
}
fun MyFirstClass.isScholar(marks: Int):Boolean
{
    return marks>95
}

fun main()
{
    var my = MyFirstClass()
    var my2 = MyFirstClass2()
    println("pass status :" + my.hasPassed(99))
    println("destinction status :" + my.isScholar(99))
}


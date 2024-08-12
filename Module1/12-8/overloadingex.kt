package tops.a128

class Calculation
{
    fun cal(a:Double,b:Double):Double
    {
       return a+b
    }

    fun cal(a:Int,b:Int):Int
    {
        return a*b
    }
}

fun main()
{

    var c = Calculation()
    println(c.cal(6,5))
    println(c.cal(6.00,5.00))


}
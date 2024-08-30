package tops.a288

class Data
{
    fun validate(age:Int)
    {
        if(age>18)
        {
            println("welcome to vote")
        }
        else
        {
           throw ArithmeticException("Not Valid")
        }
    }
}

fun main()
{
       var d1 = Data()
        d1.validate(12)
}
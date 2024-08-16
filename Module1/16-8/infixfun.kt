package tops.a168

infix fun Int.greater(other : Int) : Int
{
    if(this > other)
        return this
    else
        return other
}


fun main()
{
    val x: Int = 11
    val y : Int = 10
    val greater = x greater y
    println(greater)
}
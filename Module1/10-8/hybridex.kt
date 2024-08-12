package tops.a108

open class P1
{
    fun p()
    {
        println("p called")
    }

}
open class Q :P1()
{
    fun q()
    {
        println("q called")
    }
}
interface R
{
    fun r()
    {
        println("r called")
    }
}
class S :Q(),R
{
    fun s()
    {
        println("s called")
    }
}
fun main()
{
    var s1 = S()
    s1.p()
    s1.q()
    s1.r()
    s1.s()
}
package tops.a108

open class A
{
    fun a()
    {
        println("a called")
    }
}
class B : A()
{
    fun b()
    {
        println("b called")
    }
}
fun main()
{

    var b1 = B()

    b1.a()
    b1.b()
}
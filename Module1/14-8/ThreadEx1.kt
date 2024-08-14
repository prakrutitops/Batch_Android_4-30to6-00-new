package tops.a148

class A : Thread()
{
     override fun run()
    {
        for(i in 1..10)
        {
            println("Thrad A: $i")
        }
    }

}
class B : Thread()
{
     override fun run()
    {
        for(i in 1..10)
        {
            println("Thrad B: $i")
        }
    }
}
fun main()
{
    var a = A()
    var b = B()

    a.start()
    b.start()
}
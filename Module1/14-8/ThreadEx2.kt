package tops.a148

class A1 : Runnable
{
     override fun run()
    {
        for(i in 1..10)
        {
            println("Thrad A: $i")
        }
    }

}
class B1 : Runnable
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
    var t1 = Thread(A1())
    var t2 = Thread(B1())

    t1.start()
    t2.start()
}
package tops.a108

 interface M
{
    fun m()

}
 interface N
{
    fun n()
}
class P : M,N
{
    override fun m()
    {
        println("m called")
    }

    override fun n()
    {
       println("n called")
    }

}
fun main()
{
    var p1 = P()
    p1.m()
    p1.n()

}
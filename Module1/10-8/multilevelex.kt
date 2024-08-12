package tops.a108

open class A1
{
  fun a1()
  {
      println("a called")
  }
}
open class B1 :A1()
{
    fun b1()
    {
        println("b called")
    }
}
open class C1 :B1()
{
    fun c1()
    {
        println("c called")
    }
}
class D1 : C1()
{
    fun d1()
    {
        println("d called")
    }
}
fun main()
{
    var d = D1()
    d.a1()
    d.b1()
    d.c1()
    d.d1()
}
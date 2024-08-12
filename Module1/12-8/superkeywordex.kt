package tops.a128

open class Mycolor
{
    open var color ="black"
}
class MyColor2 :Mycolor()
{
    override var color ="white"

    fun display()
    {
        println(color)//child class
        println(super.color)//parent class value
    }
}
fun main()
{
        var m2 = MyColor2()
        m2.display()
}
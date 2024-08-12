package tops.a108

open class Bank
{
    fun bank()
    {
        println("banking")
    }
}
class Current :Bank()
{
    fun current()
    {
        println("current")
    }
}
class Save :Bank()
{
    fun save()
    {
        println("saving")
    }
}

fun main()
{
    var c1 = Current()
    var s1 = Save()

    c1.current()
    s1.save()
    c1.bank()
}
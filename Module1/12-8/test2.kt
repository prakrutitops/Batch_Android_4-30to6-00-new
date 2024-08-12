package tops.a128

open class RBI
{
    open fun rate():Int
    {
        return  0
    }
}
class Sbi :RBI()
{
    override fun rate():Int
    {
        return  7
    }
}
class Icici : RBI()
{
    override fun rate():Int
    {
        return  8
    }
}
class Axis : RBI()
{
    override fun rate():Int
    {
        return 9
    }
}

fun main()
{
    var r = RBI()

    r = Sbi()
    println(r.rate())

    r = Icici()
    println(r.rate())

    r = Axis()
    println(r.rate())
}

package tops.a78

class conex
{
    //static
    companion object
    {
        var count =0
    }

    constructor()
    {
        count++
        println(count)
    }
}
fun main()
{
    var c1 = conex()//object constructor will call automatically
    var c2 = conex()
    var c3 = conex()
}
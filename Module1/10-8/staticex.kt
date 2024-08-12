package tops.a108

class Account
{
    //static -> if we will use static it's use same memory allocation everytime

    companion object
    {
        var count = 0
    }

    constructor(name:String)
    {
        count++
        println(count)
    }
}
fun main()
{

    var a1 = Account("Deep")
    var a2 = Account("Kapil")
    var a3 = Account("Rahul")



}
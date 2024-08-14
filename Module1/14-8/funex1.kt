package tops.a148
//1)with para with return
fun a1(a:Int,b:Int) : Int
{
    return  a+b
}

//2)with para without return
fun a2(a:Int,b:Int)
{
    var c= a+b
    println(c)
}

//3)without para with return
fun a3() :Int
{
   var a= 6
    var b = 5
    var c= a+b
    return  c
}

//4)without para without return
fun a4()
{
        var a= 6
        var b =5
        var c= a+b
        println(c)
}

fun main()
{
    println(a1(6,5))
    a2(6,5)
    println(a3())
    a4()
}

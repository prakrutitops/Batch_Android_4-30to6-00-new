package tops.a288

fun main()
{
    var s1 = setOf(1,2,3,4,1,2)
    println(s1)

    var s2 = mutableSetOf(1,2,"A",3,4,"C",5,6,1,2)
    s2.add(5)
    println(s2)
}
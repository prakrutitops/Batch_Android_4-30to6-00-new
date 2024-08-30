package tops.a288

fun main()
{
    var map = HashMap<Int,String>()

    map.put(1,"d")
    map.put(2,"b")
    map.put(3,"c")
    map.put(4,"d")

    for(i in map.entries)
    {
        println(i)
    }

    println(map.keys)
    println(map.values)
}
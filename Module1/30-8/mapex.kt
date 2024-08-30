package tops.a288

fun main()
{
    //----------------------------------------------------------
    //immutable list - can not change
//    var map = mapOf<String,Int>("a" to 1,"b" to 2)
//
//    println(map)
//    for(i in map)
//    {
//        println(i)
//    }
//-----------------------------------------------------------

    //mutablelist-you can change
    var list2 = mutableMapOf<String,Int>("a" to 1,"b" to 2,"c" to 3)
   list2.put("d",4)

    //println(list2[2])
    for(i in list2)
    {
        println(i)
    }
}
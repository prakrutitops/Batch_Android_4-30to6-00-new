package tops.a288

fun main()
{
    //----------------------------------------------------------
    //immutable list - can not change
    //var list = listOf<Int>(1,2,3,4,5,6,7,8)
   // println(list)
//    for(i in list)
//    {
//        println(i)
//    }
//-----------------------------------------------------------

    //mutablelist-you can change
    var list2 = mutableListOf(1,2,3,4,"a","B",1,2)
    list2.add(5)
    list2.removeAt(2)

    //println(list2[2])
    for(i in list2)
    {
        println(i)
    }
}
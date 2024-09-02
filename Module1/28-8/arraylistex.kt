package tops.a288

fun main()
{
    var a1 = ArrayList<String>()
    a1.add("Rahul")
    a1.add("Kapil")
    a1.add("Deep")
   // a1.add(11)

    var a2 = ArrayList<String>()
    a2.add("Deep")
    a2.add("Hit")

    //a1.addAll(a2)
    //a1.removeAt(2)
    //a1.remove("Deep")
    a1.retainAll(a2)

    for(i in a1)
    {
        println(i)
    }



}
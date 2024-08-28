package tops.a288

import java.util.LinkedList

fun main()
{
    var l1 = LinkedList<String>()

    l1.add("a")
    l1.add("b")
    l1.add("c")
    l1.add("d")
    l1.add("e")
    l1.addLast("p")
    l1.addFirst("t")

    for(i in l1)
    {
        println(i)
    }
}
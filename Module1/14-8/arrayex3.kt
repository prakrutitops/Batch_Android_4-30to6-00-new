package tops.a148

fun main()
{

    var data = arrayOf("a","b","c","d","e")
    var data2 = arrayOf("")

    println(data[2])
    println(data.indexOf("c"))

   data2 = data.copyOfRange(1,4)

    for(i in 0..data2.size-1)
    {
        println(data2[i])
    }



}
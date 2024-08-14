package tops.a148

fun main()
{

    var data = intArrayOf(1,2,3,4,5)

    for(i in 0..data.size-1)
    {
        println(data[i])



    }
    if(data.contains(11))
    {
        println("true")
    }
    else
    {
        println("false")
    }
    println("Data is on ${data.indexOf(2)}")



}
package tops.a148

import java.lang.Integer.parseInt

fun main()
{
  var data = IntArray(5)

   for(i in 0..4)
   {
       println("Enter Your Number $i")
       var a = readLine()!!.toInt()
        data[i] = a
   }

    println("Your Entered elements are: ")
    for(i in 0..4)
    {

        print( " "+data[i])
    }
    if(data.contains(18))
    {
        println("true")
    }
    else
    {
        println("false")
    }
}
package tops.a78

fun main()
{
    for(i in 1..5)
    {
        for(j in 5 downTo 1)
        {
              if(j>i)
              {
                  print(" ")
              }
              else
              {
                  print("*")
              }

        }
        println()
    }
}
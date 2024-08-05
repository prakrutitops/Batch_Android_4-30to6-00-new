package tops.a58

fun main()
{

        println("Enter any number")
        var num = readLine()!!.toInt()

        var lastdigit = num%10
        var firstdigit=0
        while(num>0)
        {
            if(num>10)
            {
                num=num/10
            }
            else
            {
               firstdigit=num
            }
        }
        var ans = firstdigit+lastdigit
        println(ans)

}
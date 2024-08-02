package tops.a28

fun main()
{
    var max = 0 //7//8

    println("Enter Any Number")
    var num = readLine()!!.toInt()//4587//458

    while(num>0)
    {
            var rem = num%10//7//8//5
            if(rem>max)
            {
                max = rem
            }

            num/=10//458//45//4//0.4

    }

    println("max digit is $max")

}
package tops.a58

fun main()
{

    var lastdigit:Int=0
    var rnum=0


   println("Enter Any number")
   var num = readLine()!!.toInt()//1234


    while(num>=10)
    {
        if(num<10)

            lastdigit = num


        else

            lastdigit = num % 10
            rnum = (rnum * 10) + lastdigit
            num = num / 10




    }
    print("Reverse num is $rnum")

}
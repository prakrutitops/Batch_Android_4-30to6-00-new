package tops.a58

fun main()
{
    var num1 = 0
    var num2 = 1
    var fib = 0

    println("Enter Value for fib num")
    var fibnum = readLine()!!.toInt()

    while (fibnum > 0)
    {
        print("$fib")
        fib =num1+num2
        num1=num2
        num2=fib
        fibnum--
    }

}
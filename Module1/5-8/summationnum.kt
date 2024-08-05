package tops.a58

fun main() {

    println("Enter Any Number")
    var num = readLine()!!.toInt()//1234
    var sum = 0

    while (num > 0)
    {

        var rem = num % 10//4//3//2//1
        sum+=rem//4//7//9//10
        num = num/10
    }
    print("summation of given num is $sum")

}
package tops.a28

fun main()
{
    var age =68

    if(age>=18)
    {
        println("eligible to vote")

        if(age>=60)
        {
            println("under senior citizen category")
        }
        else
        {
            println("not under senior citizen category")
        }
    }
    else
    {
        println("not eligible to vote")
    }

}
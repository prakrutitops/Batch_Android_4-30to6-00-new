package tops.a288

data class User (var name : String, var id : Int)
{

}
fun main()
{
    var user1 = User("kot",10)
    var user2 =User("kot",20)

    println(user1)
    println(user2)


    if(user1==user2)
    {
        println("Equal")
    }
    else
    {
        println("Not Equal")
    }
}

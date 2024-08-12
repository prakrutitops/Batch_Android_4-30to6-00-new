package tops.a108

class Tops
{
    constructor(name:String)
    {
        println("Your name is $name")
    }
    constructor(name:String,email:String)
    {
        println("Your name is $name")
        println("Your email is $email")
    }
}
fun main()
{

    var t1 = Tops("kapil")
    var t2 = Tops("rahul","rahul@gmail.com")

}
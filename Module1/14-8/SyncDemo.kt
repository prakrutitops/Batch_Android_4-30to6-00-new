package tops.a148

class Sender
{
    fun send(msg:String)
    {
        println("Sending $msg")

        Thread.sleep(1000)

        println("$msg sent")

    }
}
class ThreadSend(var sender: Sender,var msg:String) : Thread()
{

    override fun run()
    {
        synchronized(sender)
        {
            sender.send(msg)
        }

    }
}
fun main()
{
    var sender = Sender()

    var t1 = ThreadSend(sender,"Hii")
    var t2 = ThreadSend(sender,"Byee")

    t1.start()
    t2.start()

}
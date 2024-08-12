package tops.a128

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

fun main()
{

    var oin = ObjectInputStream(FileInputStream("E://a.txt"))
    var s:Student2 = oin.readObject() as Student2
    println(s.id)
    println(s.name)

}


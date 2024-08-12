package tops.a128

import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main()
{

    var fout = FileOutputStream("E://a.txt")
    var s1 = Student2(101,"abcd")
    var out = ObjectOutputStream(fout)
    out.writeObject(s1)
    print("success")


}
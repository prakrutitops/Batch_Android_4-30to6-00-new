package tops.a128

import java.io.FileInputStream

fun main()
{

    var fin = FileInputStream("E://deep.txt")

    //character check
//    var i = 0
//    while(fin.read()!=-1)
//    {
//        i++
//       println("$i")
//    }

    var i=0

    do
    {
        i=fin.read()
        if(i==1)
        break
        print(i.toChar())

    }
    while(true)
    fin.close()

}
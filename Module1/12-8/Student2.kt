package tops.a128

import java.io.Serializable

class Student2 :Serializable
{
    var id =0
    var name=""

    constructor(id:Int,name:String)
    {
        this.id=id
        this.name=name
    }

}
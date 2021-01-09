package com.arun.gifbrowser.Application.Model

import java.io.Serializable
/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */

class GifList : Serializable{
   var type : String = ""
    var id : String = ""
    var url : String = ""
    var source : String = ""
    var title : String = ""
    var rating : String = ""
    var images  = GifImageList()

}
class GifImageList : Serializable{
    var original = Original()
}
class Original : Serializable{
    var height: String = ""
    var width: String = ""
    var size: String = ""
    var url: String = ""

}

package Main

object PartialFunction {
  
  val f: String => String = { case "ping" => "pong" }
                                                  //> f  : String => String = <function1>
  
  f("ping")                                       //> res0: String = pong
  //f("abc")
  
  val ff: PartialFunction[String, String] = { case "ping" => "pong" }
                                                  //> ff  : PartialFunction[String,String] = <function1>
  ff.isDefinedAt("ping")                          //> res1: Boolean = true
  ff.isDefinedAt("abc")                           //> res2: Boolean = false
  
  val fff: PartialFunction[List[Int], String] = {
  	case Nil => "one"
  	case x :: y :: rest => "two"
  }                                               //> fff  : PartialFunction[List[Int],String] = <function1>
  
  fff.isDefinedAt(List())                         //> res3: Boolean = true
  fff(List())                                     //> res4: String = one
  //fff(List(1))
  fff(List(1,2))                                  //> res5: String = two
}
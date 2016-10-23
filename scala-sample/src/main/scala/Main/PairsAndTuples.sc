package src.main.scala.Main

object PairsAndTuples {
  val pair = (42, "answer")                       //> pair  : (Int, String) = (42,answer)
  val (f, s) = pair                               //> f  : Int = 42
                                                  //| s  : String = answer
  pair._1                                         //> res0: Int = 42
  
  val tup = (42, "answer", 100, 'c')              //> tup  : (Int, String, Int, Char) = (42,answer,100,c)
  tup._1                                          //> res1: Int = 42
  tup._2                                          //> res2: String = answer
  val (a,b,c,d) = tup                             //> a  : Int = 42
                                                  //| b  : String = answer
                                                  //| c  : Int = 100
                                                  //| d  : Char = c
}
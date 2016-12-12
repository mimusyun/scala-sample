package Basics

object ConditionalsAndBlock {
	val x = 4                                 //> x  : Int = 4
  val result = if (x > 0) 1 else -1               //> result  : Int = 1
  val result2 = if (x > 0) 1 else "what"          //> result2  : Any = 1
  
  val y = 10                                      //> y  : Int = 10

  val distance = {
    val x0 = 3
 		val y0 = 3
  	val dx = x - x0
  	val dy = y - y0
  	import scala.math._
  	sqrt(dx*dx + dy*dy)
  }                                               //> distance  : Double = 7.0710678118654755
  
}
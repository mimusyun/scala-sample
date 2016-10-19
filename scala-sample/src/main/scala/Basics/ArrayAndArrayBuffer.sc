package Basics

object ArrayAndArrayBuffer {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val a = new Array[Int](10)                      //> a  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  
  for (i <- 0 until a.length) a(i) = i * i
  a                                               //> res0: Array[Int] = Array(0, 1, 4, 9, 16, 25, 36, 49, 64, 81)
  
  for (elem <- a) println(elem)                   //> 0
                                                  //| 1
                                                  //| 4
                                                  //| 9
                                                  //| 16
                                                  //| 25
                                                  //| 36
                                                  //| 49
                                                  //| 64
                                                  //| 81
  
  import scala.collection.mutable.ArrayBuffer
  val b = ArrayBuffer("Mary","had","a","little","lamb")
                                                  //> b  : scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, a
                                                  //| , little, lamb)
  
  b += "its"                                      //> res1: Basics.ArrayAndArrayBuffer.b.type = ArrayBuffer(Mary, had, a, little, 
                                                  //| lamb, its)
  b += ("fleece", "was", "white")                 //> res2: Basics.ArrayAndArrayBuffer.b.type = ArrayBuffer(Mary, had, a, little, 
                                                  //| lamb, its, fleece, was, white)
  b ++ Array("as", "snow")                        //> res3: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, 
                                                  //| a, little, lamb, its, fleece, was, white, as, snow)
  
  b.remove(3)                                     //> res4: String = little
  b                                               //> res5: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, 
                                                  //| a, lamb, its, fleece, was, white)
  
  b.insert(3, "medius-sized")
  b                                               //> res6: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, 
                                                  //| a, medius-sized, lamb, its, fleece, was, white)
  
  b.trimEnd(5)
  b                                               //> res7: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, 
                                                  //| a, medius-sized)
  // transformation
  val c = Array(2,3,5,7,11)                       //> c  : Array[Int] = Array(2, 3, 5, 7, 11)
  val result = for(elem <- c) yield 2 * elem      //> result  : Array[Int] = Array(4, 6, 10, 14, 22)
  val result2 = for(elem <- c if elem%2 != 0) yield 2 * elem
                                                  //> result2  : Array[Int] = Array(6, 10, 14, 22)
	// common algorithms
	val d = ArrayBuffer(1,7,2,9)              //> d  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 7, 2, 9)
	d.sorted                                  //> res8: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 7, 9)
	d                                         //> res9: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 7, 2, 9)
	val sortedD = d.sorted                    //> sortedD  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 7, 
                                                  //| 9)
  d.reverse                                       //> res10: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(9, 2, 7, 1)
  
  Array(1,2,3).toString                           //> res11: String = [I@6ea12c19
  Array(1,2,3).mkString("|")                      //> res12: String = 1|2|3
  Array(1,2,3).mkString("[[", "," ,"]]")          //> res13: String = [[1,2,3]]
	
	

}